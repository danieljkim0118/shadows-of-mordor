import java.awt.Color;
import java.awt.Graphics;

public class Archer extends PlayerRangedUnit implements BattleUnit {

	private Color color = Color.MAGENTA;
	
	public Archer() {
		super(true, false, 0, 0, 4, 50, 200, 7);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(xPos, yPos, size, size);
	}

}
