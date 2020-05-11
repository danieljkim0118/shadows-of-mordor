import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class test {
	
	private static List<BattleUnit> P = BattleField.allPlayerUnits;
	private static List<BattleUnit> E = BattleField.allEnemyUnits;
	
	@Test
	public void testUnitMove() {
		// generate new infantry
		Infantry i = new Infantry();
		i.setID(0);
		i.setX(0);
		i.setY(0);
		P.add(i);
		
		// generate new enemy
		Orc o = new Orc();
		o.setID(0);
		o.setX(10);
		o.setY(0);
		E.add(o);
		
		// move infantry and check whether it moves toward enemy
		i.move();
		int x = i.getX();
		int y = i.getY();
		
		assertTrue(x > 0);
		assertTrue(y==0);
		
		// move enemy and check whether it moves toward infantry
		o.move();
		int x1 = o.getX();
		int y1 = o.getY();
		
		assertTrue(x1<10);
		assertTrue(y1==0);
		
		// generate another enemy, closer to the infantry
		Orc o2 = new Orc();
		o2.setID(1);
		o2.setX(0);
		o2.setY(5);
		E.add(o2);
		
		// move infantry, and check that it changes direction towards the closer enemy
		i.move();
		int x2 = i.getX();
		int y2 = i.getY();
		
		assertFalse(x2 > x);
		assertTrue(y2 > y);
		
		P.clear();
		E.clear();
	}
	
	@Test
	public void testBattleOn() {
		// generate new infantry
		Infantry i = new Infantry();
		i.setID(0);
		i.setX(0);
		i.setY(0);
		P.add(i);
		
		// generate new enemy, far from infantry
		Orc o = new Orc();
		o.setID(0);
		o.setX(50);
		o.setY(0);
		E.add(o);
		
		// let the infantry and enemy battle and move
		i.battle();
		i.move();
		o.battle();
		o.move();
		
		// units are not in battle state yet
		assertFalse(i.getBattle());
		assertFalse(o.getBattle());
		
		// generate new enemy close to infantry
		Orc o2 = new Orc();
		o2.setID(1);
		o.setX(3);
		o.setY(1);
		E.add(o2);
		
		// update movement and battle state of the units
		i.battle();
		i.move();
		o.battle();
		o.move();
		o2.battle();
		o2.move();
		
		// infantry enters battle state with the new enemy
		assertTrue(i.getBattle());
		assertTrue(o2.getBattle());
		
		P.clear();
		E.clear();
	}
	
	@Test
	public void testUnitsMeet() {
		// generate new infantry
		Infantry i = new Infantry();
		i.setID(0);
		i.setX(0);
		i.setY(0);
		P.add(i);
		
		// generate new enemy, far from infantry
		Orc o = new Orc();
		o.setID(0);
		o.setX(30);
		o.setY(30);
		E.add(o);
		
		// simulate movement until infantry enters battle state
		while (!i.getBattle()) {
			i.battle();
			i.move();
			o.battle();
			o.move();
			
			// both units move along the line y=x
			assertEquals(i.getX(), i.getY());
			assertEquals(o.getX(), o.getY());
		}
		
		// enemy engages in battle as soon as infantry engages in battle
		assertTrue(o.getBattle());
		
		// both units meet halfway through the coordinates (0,0) and (30,30), maintaining a distance
		// between themselves (stop when distance becomes less than the sum of their sizes)
		assertEquals(i.getX(), 11);
		assertEquals(i.getY(), 11);
		assertEquals(o.getX(), 20);
		assertEquals(o.getY(), 20);
		
		int x1 = i.getX();
		int y1 = i.getY();
		int x2 = o.getX();
		int y2 = o.getY();
		
		i.move();
		o.move();
		
		// units do not move once engaged in battle
		assertEquals(i.getX(), x1);
		assertEquals(i.getY(), y1);
		assertEquals(o.getX(), x2);
		assertEquals(o.getY(), y2);
		
		P.clear();
		E.clear();
	}
	
	@Test
	public void testUnitBattle() {
		// generate new infantry
		Infantry i = new Infantry();
		i.setID(0);
		i.setX(0);
		i.setY(0);
		P.add(i);
		
		// generate new enemy, close to infantry
		Orc o = new Orc();
		o.setID(0);
		o.setX(9);
		o.setY(9);
		E.add(o);
		
		assertEquals(i.getHP(), 100);
		assertEquals(o.getHP(), 80);
		
		// simulate one round of duel between the units
		i.battle();
		i.move();
		o.battle();
		o.move();
		
		// the units' HP whittles down by 2 each (infantry and orc have attack 2)
		assertEquals(i.getHP(), 98);
		assertEquals(o.getHP(), 78);
		
		// simulate battle until one of the units dies
		while (i.getHP() > 0 && o.getHP() > 0) {
			i.battle();
			i.move();
			o.battle();
			o.move();
		}
		
		// infantry ends up having 20 more HP than the enemy
		assertEquals(i.getHP(), 20);
		assertEquals(o.getHP(), 0);
		
		// orc is eliminated from the list of enemy units
		assertEquals(P.size(), 1);
		assertEquals(E.size(), 0);
		
		P.clear();
		E.clear();
	}
	
	@Test
	public void multipleUnitsBattle() {
		// generate new infantry
		Infantry i = new Infantry();
		i.setID(0);
		i.setX(0);
		i.setY(0);
		P.add(i);
		
		// generate new enemy, close to infantry
		Orc o = new Orc();
		o.setID(0);
		o.setX(9);
		o.setY(9);
		E.add(o);
		
		// generate another enemy - note that o2 is closer to the infantry than o
		Orc o2 = new Orc();
		o2.setID(1);
		o2.setX(0);
		o2.setY(9);
		E.add(o2);
		
		// initiate battle (simulate one round of duel)
		i.battle();
		o.battle();
		o2.battle();
		
		// we check that battle happened with these tests
		assertTrue(i.getBattle());
		assertTrue(o.getBattle());
		assertTrue(o2.getBattle());
		
		// infantry is hit twice by the orcs.
		// first orc is undamaged because it is further away from the infantry than o2.
		// second orc is damaged since it is closer to the infantry. (infantry decides to attack o2)
		assertEquals(i.getHP(), 96);
		assertEquals(o.getHP(), 80);
		assertEquals(o2.getHP(), 78);
		
		// simulate battle until one of the units dies
		while (i.getHP() > 0 && o.getHP() > 0 && o2.getHP() > 0) {
			i.battle();
			o.battle();
			o2.battle();
		}
		
		// infantry dies first
		// first orc is undamaged, since infantry only hits the closest enemy (o2)
		// note that infantry takes damage of 2*2 = 4 every turn, so lasts for 25 turns
		// then, o2 takes 25 * 2 = 50 damage, so it must have 80-50 = 30 HP left
		assertEquals(i.getHP(), 0);
		assertEquals(o.getHP(), 80);
		assertEquals(o2.getHP(), 30);
		
		// infantry is eliminated from the list of player units
		assertEquals(P.size(), 0);
		assertEquals(E.size(), 2);
		
		P.clear();
		E.clear();
	}
	
	@Test
	public void testArcher() {
		// generate new archer
		Archer i = new Archer();
		i.setID(0);
		i.setX(0);
		i.setY(0);
		P.add(i);
		
		int x = i.getX();
		int y = i.getY();
		
		// generate new enemy, far from archer
		Orc o = new Orc();
		o.setID(0);
		o.setX(200);
		o.setY(200);
		E.add(o);
		
		// update the movement and battle state of the units
		i.battle();
		i.move();
		o.battle();
		o.move();
		
		// archer does not move
		assertEquals(i.getX(), x);
		assertEquals(i.getY(), y);
		
		// enemy is not shot by the archer, since it is out of range
		assertEquals(i.getHP(), 50);
		assertEquals(o.getHP(), 80);
		
		// simulate movement until the archer enters battle state
		while(!i.getBattle()) {
			i.battle();
			i.move();
			o.battle();
			o.move();
		}
		
		// enemy is shot by the archer once they are close enough
		assertFalse(o.getBattle());
		assertEquals(o.getHP(), 76);
		
		// generate another enemy - note that o2 is closer to the archer than o, within range
		Orc o2 = new Orc();
		o2.setID(1);
		o2.setX(50);
		o2.setY(50);
		E.add(o2);
		
		// update the movement and battle state of the units
		i.battle();
		i.move();
		o.battle();
		o.move();
		o2.battle();
		o2.move();
		
		// the archer now shoots the enemy that is closer, within range
		assertTrue(i.getBattle());
		
		// the first enemy is left undamaged
		assertFalse(o.getBattle());
		assertEquals(o.getHP(), 76);
		
		// the second (closer) enemy is attacked
		assertFalse(o2.getBattle());
		assertEquals(o2.getHP(), 76);
		
		P.clear();
		E.clear();
	}
	
	@Test
	public void testRanger() {
		// generate new ranger
		Ranger i = new Ranger();
		i.setID(0);
		i.setX(0);
		i.setY(0);
		P.add(i);
		
		int x = i.getX();
		int y = i.getY();
		
		// generate new enemy, far from ranger
		Orc o = new Orc();
		o.setID(0);
		o.setX(100);
		o.setY(100);
		E.add(o);
		
		// update the movement and battle state of the units
		i.battle();
		i.move();
		o.battle();
		o.move();
		
		// ranger and enemy are not in battle yet
		assertFalse(i.getBattle());
		assertFalse(o.getBattle());
		
		// ranger moves
		assertFalse(i.getX() == x);
		assertFalse(i.getY() == y);
		
		// simulate movement until the ranger enters battle state
		while (!i.getBattle()) {
			i.battle();
			i.move();
			o.battle();
			o.move();
		}
		
		// ranger is left undamaged since it shoots the orc before they meet within the orc's range
		assertEquals(i.getHP(), 200);
		
		// enemy is not in battle state yet (it cannot reach the ranger)
		assertFalse(o.getBattle());
		assertEquals(o.getHP(), 74);
		
		P.clear();
		E.clear();
	}
	
	@Test
	public void testCitadel() {
		
		// generate a new citadel which the player must defend
		Citadel c = new Citadel();
		P.add(c);
		
		// generate new enemy, far from citadel
		Orc o = new Orc();
		o.setID(0);
		o.setX(0);
		o.setY(0);
		E.add(o);
		
		// update the battle state and move the enemy until it gets close to the citadel
		while (!o.getBattle()) {
			c.battle();
			c.move();
			o.battle();
			o.move();
		}
		
		// citadel is already in battle state when enemy attacks the citadel
		assertTrue(c.getBattle());
		
		//citadel has been already hit once when it is in battle state
		assertEquals(c.getHP(), 4998);
		
		// iteration of battle between enemy and citadel (citadel has 0 attack)
		int iter = 1;
		
		// simulate battle until citadel is defeated
		while (c.getHP() > 0) {
			c.battle();
			c.move();
			o.battle();
			o.move();
			iter += 1;
		}
		
		// citadel has HP 5000 and orc has attack 2, so there should be 5000/2 = 2500 iterations
		assertEquals(iter, 2500);
		
		// citadel is eliminated from the list of player units
		assertEquals(P.size(), 0);
	}
	
}
