import java.awt.Color;
import java.awt.Graphics;

public class Ranger extends PlayerSpecialUnit implements BattleUnit {

	private Color color = Color.CYAN;
	
	public Ranger() {
		super(true, false, 0, 0, 6, 200, 2, 100, 7);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(xPos, yPos, size, size);
	}
	
}
