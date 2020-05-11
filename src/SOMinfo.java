
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SOMinfo extends JFrame {
	
	private JPanel contentPane;
	
	public SOMinfo() {
		
		try {
			Image img = ImageIO.read(getClass().getResource("images/SOMinfo.jpg"));
			img = img.getScaledInstance(600, 450,  java.awt.Image.SCALE_REPLICATE );
			contentPane = new ImagePanel(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblNewLabel = new JLabel("INSTRUCTIONS");
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 36));
		lblNewLabel.setBounds(150, 10, 300, 50);
		contentPane.add(lblNewLabel);
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText(" Since the end of the Second Age, the dark forces of Sauron have regathered"
				+ " to dominate \n Middle-Earth once again. As the guardian of the citadel in Minas Tirith"
				+ ", you must protect \n the kingdom of Gondor from the oncoming threats of the vast armies of Mordor."
				+ "\n The objective of this game is to protect the citadel from as many waves of orc invasions as "
				+ "\n possible. The citadel is shown on the bottom-center, with an HP of 5000 displayed on the "
				+ "\n lower-right corner. You lose the game if the HP reaches 0."
				+ "\n To defeat the incoming army of orcs, you must deploy units that will defend the citadel."
				+ "\n Every time you deploy a unit, you must pay a certain amount of mithrils, the currency of"
				+ "\n Middle-Earth, as shown on the bottom-right corner. To deploy a specific unit, click on the"
				+ "\n corresponding button, and click the mouse on the bottom portion of the battlefield to deploy"
				+ "\n the unit. Infantries are the basic foot units. Riders move quickly and are relatively cheap."
				+ "\n Archers shoot enemies from a long range in a fixed position. Warriors are stronger versions"
				+ "\n of infantries. Knights are much stronger versions of riders. Rangers are able to shoot"
				+ "\n enemies from a medium range and move around the battlefield, with extremely high stats."
				+ "\n"
				+ "\n Good luck! Remember that the fate of Middle-Earth rests upon your decisions.");
		textArea.setBounds(30, 60, 510, 290);
		contentPane.add(textArea);
		
		JButton ReturnButton = new JButton("RETURN");
		ReturnButton.setForeground(new Color(255, 215, 0));
		ReturnButton.setFont(new Font("Algerian", Font.PLAIN, 24));
		ReturnButton.setBackground(new Color(170, 170, 170));
		ReturnButton.setBounds(30, 360, 150, 40);
		ReturnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Game.info.setVisible(false);
            	Game.info.dispose();
            }
        });
		contentPane.add(ReturnButton);
		
	}
}
