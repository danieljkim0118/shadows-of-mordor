import java.awt.Color;
import java.awt.Graphics;

public class Warrior extends PlayerMilitia implements BattleUnit {

	private Color color = Color.GRAY;
	
	public Warrior() {
		super(true, false, 0, 0, 4, 200, 1.5, 7);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(xPos, yPos, size, size);
	}
	
}
