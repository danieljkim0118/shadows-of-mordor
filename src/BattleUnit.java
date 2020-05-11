import java.awt.Graphics;

/**
 * An interface that defines the methods which a battle unit can use during the game
 * The interface is used by all units that participate in the battle, including the citadel
 */
public interface BattleUnit {
	
	/**
	 * Sets the unique ID of the battle unit
	 * @param n ID of the battle unit
	 */
	public void setID(int n);
	
	/**
	 * Initializes the x coordinate of the battle unit
	 * @param x x-coordinate
	 */
	public void setX(int x);
	
	/**
	 * Initializes the y coordinate of the battle unit
	 * @param y y-coordinate
	 */
	public void setY(int y);
	
	/**
	 * Sets the battle state of the unit
	 * @param b boolean indicating whether the unit is in battle
	 */
	public void setBattle(boolean b);
	
	/**
	 * Determines the side of the battle unit
	 * @return True if the unit is player unit, False if the unit is enemy unit
	 */
	public boolean getSide();
	
	/**
	 * 
	 * @param b Instance of another BattleUnit
	 * @return True if the unit is enemy of b, False if the units are on the same side
	 */
	public boolean isEnemy(BattleUnit b);
	
	/**
	 * Returns the battle state of the unit
	 * @return True if the unit is in battle state, False otherwise
	 */
	public boolean getBattle();
	
	/**
	 * Returns the unique ID of the unit
	 * @return ID of the battle unit
	 */
	public int getID();
	
	/**
	 * Returns the x coordinate of the battle unit
	 * @return x coordinate of the battle unit
	 */
	public int getX();
	
	/**
	 * Returns the y coordinate of the battle unit
	 * @return y coordinate of the battle unit
	 */
	public int getY();
	
	/**
	 * Returns the amount of damage the battle unit can inflict
	 * @return 'attack' field of the battle unit
	 */
	public int getAttack();
	
	/**
	 * Moves the battle unit in the battlefield
	 */
	public void move();
	
	/**
	 * Returns the HP of the battle unit
	 * @return HP of the battle unit
	 */
	public int getHP();
	
	/**
	 * Returns the size of the battle unit
	 * @return size of the battle unit
	 */
	public int getSize();
	
	/**
	 * Commands unit to battle (may not battle if no enemy unit is nearby)
	 */
	public void battle();
	
	/**
	 * Updates the battle unit's HP
	 * @param x Amount of damage afflicted by enemy
	 */
	public void updateHP(int z);
	
	/**
	 * Displays the unit on the battlefield
	 */
	public void draw(Graphics g);
	
	/**
	 * Removes the battle unit when it dies
	 */
	public void remove();
	
	/**
	 * Returns whether two battle units are equal
	 * @param u another battle unit
	 * @return boolean indicating whether two objects are equal
	 */
	public boolean equals(BattleUnit u);
	
	/**
	 * Compares the battle units
	 * @param u another battle unit
	 * @return integer indicating the relative order of the given unit w.r.t. another unit
	 */
	public int compareTo(BattleUnit u);
	
}
