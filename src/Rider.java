import java.awt.Color;
import java.awt.Graphics;

public class Rider extends PlayerMilitia implements BattleUnit {

	private Color color = Color.ORANGE;
	
	public Rider() {
		super(true, false, 0, 0, 3, 120, 3, 7);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(xPos, yPos, size, size);
	}

}
