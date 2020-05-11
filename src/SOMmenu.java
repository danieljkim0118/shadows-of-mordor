import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class SOMmenu extends JFrame {
	
	private ImagePanel contentPane;
	
	public SOMmenu() {
		
		Image img;
		try {
			img = ImageIO.read(getClass().getResource("images/SOMmenu.jpg"));
			img = img.getScaledInstance(600, 450,  java.awt.Image.SCALE_REPLICATE );
			contentPane = new ImagePanel(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblNewLabel = new JLabel("Middle-Earth");
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 36));
		lblNewLabel.setBounds(100, 80, 400, 50);
		contentPane.add(lblNewLabel);
		
		final JLabel lblShadowsOfMordor = new JLabel("SHADOWS OF MORDOR");
		lblShadowsOfMordor.setHorizontalAlignment(SwingConstants.CENTER);
		lblShadowsOfMordor.setForeground(new Color(255, 215, 0));
		lblShadowsOfMordor.setFont(new Font("Algerian", Font.PLAIN, 48));
		lblShadowsOfMordor.setBounds(40, 140, 520, 50);
		contentPane.add(lblShadowsOfMordor);
		
		final JButton PlayButton = new JButton("PLAY");
		PlayButton.setFont(new Font("Algerian", Font.PLAIN, 28));
		PlayButton.setForeground(new Color(255, 215, 0));
		PlayButton.setBounds(200, 200, 200, 40);
		PlayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Game.game.setVisible(true);
                SOMgame.battleField.reset();
            }
        });
		contentPane.add(PlayButton);
		
		final JButton InfoButton = new JButton("INFO");
		InfoButton.setForeground(new Color(255, 215, 0));
		InfoButton.setFont(new Font("Algerian", Font.PLAIN, 28));
		InfoButton.setBounds(200, 260, 200, 40);
		InfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.info.setVisible(true);
			}
		});
		contentPane.add(InfoButton);
		
		final JButton QuitButton = new JButton("QUIT");
		QuitButton.setForeground(new Color(255, 215, 0));
		QuitButton.setFont(new Font("Algerian", Font.PLAIN, 28));
		QuitButton.setBounds(200, 320, 200, 40);
		QuitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Game.menu.setVisible(false);
            	Game.menu.dispose();
                System.out.println("Game Closing...");
            }
        });
		contentPane.add(QuitButton);
		
		
	}
}
