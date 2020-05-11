import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class BattleField extends JPanel {

	private static int level = 0;
	private static int enemyRate;
	
	private static int iter;
	
	private static Point currentPos;
	
	public static List<BattleUnit> allPlayerUnits = new ArrayList<BattleUnit>();
	
	public static List<BattleUnit> allEnemyUnits = new ArrayList<BattleUnit>();
	
	public static boolean[] deployUnit = new boolean[6];
	
	public static final int FIELD_WIDTH = 500;
	public static final int FIELD_HEIGHT = 500;
	public static final int INTERVAL = 20;
	
	public BattleField() {
		Timer timer = new Timer(INTERVAL, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
		timer.start();
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getX() > 0 && e.getX() < 600 && e.getY() > 300 && e.getY() < 550) {
					currentPos = e.getPoint();
					BattleUnit newUnit;
						if (deployUnit[0]) {
							if (Game.mithrils >= 1) {
								newUnit = new Infantry();
								newUnit.setX(currentPos.x);
								newUnit.setY(currentPos.y);
								newUnit.setID(iter);
								allPlayerUnits.add(newUnit);
								Game.mithrils -= 1;
							} else {
								Game.game.status.setText("Not enough mithrils available!");
							}
						} else if (deployUnit[1]) {
							if (Game.mithrils >= 2) {
								newUnit = new Rider();
								newUnit.setX(currentPos.x);
								newUnit.setY(currentPos.y);
								newUnit.setID(iter);
								allPlayerUnits.add(newUnit);
								Game.mithrils -= 2;
							} else {
								Game.game.status.setText("Not enough mithrils available!");
							}
						} else if (deployUnit[2]) {
							if (Game.mithrils >= 5) {
								newUnit = new Archer();
								newUnit.setX(currentPos.x);
								newUnit.setY(currentPos.y);
								newUnit.setID(iter);
								allPlayerUnits.add(newUnit);
								Game.mithrils -= 5;
							} else {
								Game.game.status.setText("Not enough mithrils available!");
							}
						} else if (deployUnit[3]) {
							if (Game.mithrils >= 8) {
								newUnit = new Warrior();
								newUnit.setX(currentPos.x);
								newUnit.setY(currentPos.y);
								newUnit.setID(iter);
								allPlayerUnits.add(newUnit);
								Game.mithrils -= 8;
							} else {
								Game.game.status.setText("Not enough mithrils available!");
							}
						} else if (deployUnit[4]) {
							if (Game.mithrils >= 13) {
								newUnit = new Knight();
								newUnit.setX(currentPos.x);
								newUnit.setY(currentPos.y);
								newUnit.setID(iter);
								allPlayerUnits.add(newUnit);
								Game.mithrils -= 13;
							} else {
								Game.game.status.setText("Not enough mithrils available!");
							}
						} else if (deployUnit[5]) {
							if (Game.mithrils >= 20) {
								newUnit = new Ranger();
								newUnit.setX(currentPos.x);
								newUnit.setY(currentPos.y);
								newUnit.setID(iter);
								allPlayerUnits.add(newUnit);
								Game.mithrils -= 20;
							} else {
								Game.game.status.setText("Not enough mithrils available!");
							}
						}
					
				} else {
					Game.game.status.setText("Deploy unit on the bottom half of the field!");
				}
			}
		});
	}
	
	public void reset() {
		Game.GameON = true;
		level += 1;
		if (level == 1) {
			Game.game.status.setText("Click the button and deploy troop on the lower half of the field");
		} else {
			Game.game.status.setText("Wave "+Integer.toString(level)+": Defeat Sauron's Forces!");
		}
		enemyRate = (int)Math.round(50 * Math.pow(1.3, 1-(double)level));
		
		// initialize map of all units
		allPlayerUnits = new ArrayList<BattleUnit>();
		allPlayerUnits.add(new Citadel());
		allEnemyUnits = new ArrayList<BattleUnit>();
		
		// initialize the amount of mithrils and HP
		Game.mithrils = 0;
		Game.HP = 5000;
		// initialize iteration number
		iter = 1;
		requestFocusInWindow();
	}
	
	void tick() {
		if(Game.GameON) {
			// call a function to deploy enemy units at random positions on the battlefield
			if (iter % enemyRate == 0) {
				setEnemy();
			}
			
			// update battles and movements of all units
			if (iter % 2 == 0) {
				gameBattle();
				gameMove();
			}
			// update amount of mithrils (game currency) and life
			if (iter % 30 == 0) {
				if (Game.mithrils < 1000) {
					Game.mithrils += 1;
				}
			}
			
			if (Game.HP < 1000) {
				Game.game.status.setText("Citadel is in danger. Deploy troops to protect Gondor!");
			} else if (iter > 2000) {
				Game.game.status.setText("Great job. Keep those orcs away from Middle-Earth!");
			} else if (iter % 500 == 0) {
				Game.game.status.setText("Protect the free people of Middle-Earth!");
			}
			
			Game.game.mithrilLabel.setText(Integer.toString(Game.mithrils));
			Game.game.HPLabel.setText(Integer.toString(Game.HP));
			iter += 1;
			
			if (Game.HP <= 0) {
				Game.GameON = false;
				Game.game.status.setText("Defeat. Sauron's forces have dominated.");
				IOHandler.writeScore(Game.userName, level);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Game.game.setVisible(false);
				Game.game.dispose();
			} else if (iter == 3000) {
				Game.GameON = false;
				Game.game.status.setText("Victory! Next round will begin shortly");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				reset();
			}
			
			repaint();
		}
	}
	
	/**
	 * Deploys enemy unit to a random position in the upper portion of the map
	 */
	public static void setEnemy() {
		Orc enemy = new Orc();
		enemy.setX((int)Math.round(Math.random()*500));
		enemy.setY((int)Math.round(Math.random()*150));
		enemy.setID(iter);
		allEnemyUnits.add(enemy);
	}
	
	/**
	 * Manages the battle state of all units in the battlefield
	 */
	public static void gameBattle() {
		if (!allPlayerUnits.isEmpty()) {
			for (BattleUnit current_unit : allPlayerUnits) {
				current_unit.battle();
			}
		}
		if (!allEnemyUnits.isEmpty()) {
			for (BattleUnit current_unit : allEnemyUnits) {
				current_unit.battle();
			}
		}
	}
	
	/**
	 * Manages the movement of all units in the battlefield
	 */
	public static void gameMove() {
		if (!allPlayerUnits.isEmpty()) {
			for (BattleUnit current_unit : allPlayerUnits) {
				current_unit.move();
			}
		}
		if (!allEnemyUnits.isEmpty()) {
			for (BattleUnit current_unit : allEnemyUnits) {
				current_unit.move();
			}
		}
	}
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // iterate over map of all units and draw each of them
        if (!allPlayerUnits.isEmpty()) {
	        for (BattleUnit current_unit : allPlayerUnits) {
				current_unit.draw(g);
			}
        }
        if (!allEnemyUnits.isEmpty()) {
	        for (BattleUnit current_unit : allEnemyUnits) {
				current_unit.draw(g);
	        }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(FIELD_WIDTH, FIELD_HEIGHT);
    }
}
