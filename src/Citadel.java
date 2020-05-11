import java.awt.Graphics;

public class Citadel extends PlayerRangedUnit implements BattleUnit {

	public Citadel() {
		super(true, false, 290, 490, 0, 5000, 70, 40);
		Game.HP = HP;
	}

	@Override
	// citadel is already displayed on the game screen, so there is no need to draw something new
	public void draw(Graphics g) {
	}
	
	@Override
	public void updateHP(int z) {
		HP = Math.max(HP - z, 0);
		Game.HP = HP;
	}

}
