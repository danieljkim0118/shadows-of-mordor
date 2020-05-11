import java.awt.Color;
import java.awt.Graphics;

public class Infantry extends PlayerMilitia implements BattleUnit {
	
	private Color color = Color.RED;
	
	public Infantry() {
		super(true, false, 0, 0, 2, 100, 1.5, 7);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(xPos, yPos, size, size);
	}

}
