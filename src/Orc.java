import java.awt.Color;
import java.awt.Graphics;

public class Orc extends EnemyMilitia implements BattleUnit {

	private Color color = Color.BLACK;
	
	public Orc() {
		super(false, false, 0, 0, 2, 80, 1.5, 7);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(xPos, yPos, size, size);
	}
}
