import java.awt.Graphics;
import java.awt.Point;

public abstract class PlayerSpecialUnit implements BattleUnit {

	boolean side;
	boolean battleState;
	int ID;
	int xPos;
	int yPos;
	int attack;
	int HP;
	double speed;
	int range;
	int size;
	
	public PlayerSpecialUnit(boolean v1, boolean v2, int v3, int v4, int v5, int v6, double v7, int v8, int v9) {
		side = v1;
		battleState = v2;
		xPos = v3;
		yPos = v4;
		attack = v5;
		HP = v6;
		speed = v7;
		range = v8;
		size = v9;
	}

	@Override
	public void setID(int n) {
		ID = n;
	}
	
	@Override
	public void setX(int x) {
		xPos = x;
	}

	@Override
	public void setY(int y) {
		yPos = y;
	}

	@Override
	public void setBattle(boolean b) {
		battleState = b;
	}

	@Override
	public boolean getSide() {
		return side;
	}

	@Override
	public boolean isEnemy(BattleUnit b) {
		return side == b.getSide();
	}

	@Override
	public boolean getBattle() {
		return battleState;
	}

	@Override
	public int getID() {
		return ID;
	}
	
	@Override
	public int getX() {
		return xPos;
	}

	@Override
	public int getY() {
		return yPos;
	}

	@Override
	public int getAttack() {
		return attack;
	}

	@Override
	public int getHP() {
		return HP;
	}
	
	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	public void move() {
		if (!battleState) {
			if (!BattleField.allEnemyUnits.isEmpty()) {
				double minD = 1000;
				Point p = null;
				for (BattleUnit enemy : BattleField.allEnemyUnits) {
					double current_d = Math.sqrt(Math.pow((xPos - enemy.getX()), 2) + Math.pow((yPos - enemy.getY()), 2));
					if (current_d < minD) {
						minD = current_d;
						p = new Point(enemy.getX(), enemy.getY());
					}
				}
				xPos += (int)((p.getX() - xPos)*speed/minD);
				yPos += (int)((p.getY() - yPos)*speed/minD);
			}
		}
	}

	@Override
	public void battle() {
		if (!BattleField.allEnemyUnits.isEmpty()) {
			double minD = 1000;
			BattleUnit battleEnemy = null;
			for (BattleUnit enemy : BattleField.allEnemyUnits) {
				double current_d = Math.sqrt(Math.pow((xPos - enemy.getX()), 2) + Math.pow((yPos - enemy.getY()), 2));
				if (current_d < minD) {
					minD = current_d;
					battleEnemy = enemy;
				}
			}
			if (minD < range) {
				setBattle(true);
				battleEnemy.updateHP(attack);
				if (battleEnemy.getHP() == 0) {
					BattleField.allEnemyUnits.remove(battleEnemy);
				}
			} else {
				setBattle(false);
			}
		}
	}

	@Override
	public void updateHP(int z) {
		HP = Math.max(HP - z, 0);
	}

	@Override
	public abstract void draw(Graphics g);

	@Override
	public void remove() {
		BattleField.allPlayerUnits.remove(this);
	}

	@Override
	public boolean equals(BattleUnit u) {
		return this.ID == u.getID();
	}
	
	@Override
	public int compareTo(BattleUnit u) {
		if (ID < u.getID()) {
			return -1;
		} else if (ID > u.getID()){
			return 1;
		} else {
			return 0;
		}
	}
	
}
