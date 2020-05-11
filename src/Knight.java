import java.awt.Color;
import java.awt.Graphics;

public class Knight extends PlayerMilitia implements BattleUnit {

	private Color color = Color.BLUE;
	
	public Knight() {
		super(true, false, 0, 0, 5, 180, 3, 7);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(xPos, yPos, size, size);
	}
	
}
