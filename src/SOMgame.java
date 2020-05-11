import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class SOMgame extends JFrame {

	public final JLabel mithrilLabel;
	public final JLabel HPLabel;
	public final JLabel status;
	public static BattleField battleField;
	
	public SOMgame() {
		
		battleField = new BattleField();
		battleField.setBounds(0, 0, 600, 550);
		battleField.setOpaque(false);
		add(battleField);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setLayout(null);
		add(panel);
		
		final JLabel highScoreLabel1 = new JLabel();
		highScoreLabel1.setFont(new Font("Algerian", Font.PLAIN, 12));
		highScoreLabel1.setBounds(500, 30, 60, 20);
		highScoreLabel1.setText(Game.bestPlayers[0]+": "+Game.allRecords.get(Game.bestPlayers[0]));
		panel.add(highScoreLabel1);
		
		final JLabel highScoreLabel2 = new JLabel();
		highScoreLabel2.setFont(new Font("Algerian", Font.PLAIN, 12));
		highScoreLabel2.setBounds(500, 50, 60, 20);
		highScoreLabel2.setText(Game.bestPlayers[1]+": "+Game.allRecords.get(Game.bestPlayers[1]));
		panel.add(highScoreLabel2);
		
		final JLabel highScoreLabel3 = new JLabel();
		highScoreLabel3.setFont(new Font("Algerian", Font.PLAIN, 12));
		highScoreLabel3.setBounds(500, 70, 60, 20);
		highScoreLabel3.setText(Game.bestPlayers[2]+": "+Game.allRecords.get(Game.bestPlayers[2]));
		panel.add(highScoreLabel3);
		
		final JLabel troopLabel1 = new JLabel("", SwingConstants.CENTER);
		troopLabel1.setFont(new Font("Algerian", Font.PLAIN, 13));
		troopLabel1.setForeground(new Color(100, 100, 100));
		troopLabel1.setBounds(10, 610, 80, 20);
		troopLabel1.setText("Infantry: 1");
		panel.add(troopLabel1);
		
		final JLabel troopLabel2 = new JLabel("", SwingConstants.CENTER);
		troopLabel2.setFont(new Font("Algerian", Font.PLAIN, 13));
		troopLabel2.setForeground(new Color(100, 100, 100));
		troopLabel2.setBounds(90, 610, 80, 20);
		troopLabel2.setText("Rider: 2");
		panel.add(troopLabel2);
		
		final JLabel troopLabel3 = new JLabel("", SwingConstants.CENTER);
		troopLabel3.setFont(new Font("Algerian", Font.PLAIN, 13));
		troopLabel3.setForeground(new Color(100, 100, 100));
		troopLabel3.setBounds(170, 610, 80, 20);
		troopLabel3.setText("Archer: 5");
		panel.add(troopLabel3);
		
		final JLabel troopLabel4 = new JLabel("", SwingConstants.CENTER);
		troopLabel4.setFont(new Font("Algerian", Font.PLAIN, 13));
		troopLabel4.setForeground(new Color(100, 100, 100));
		troopLabel4.setBounds(250, 610, 80, 20);
		troopLabel4.setText("Warrior: 8");
		panel.add(troopLabel4);
		
		final JLabel troopLabel5 = new JLabel("", SwingConstants.CENTER);
		troopLabel5.setFont(new Font("Algerian", Font.PLAIN, 13));
		troopLabel5.setForeground(new Color(100, 100, 100));
		troopLabel5.setBounds(330, 610, 80, 20);
		troopLabel5.setText("Knight: 13");
		panel.add(troopLabel5);
		
		final JLabel troopLabel6 = new JLabel("", SwingConstants.CENTER);
		troopLabel6.setFont(new Font("Algerian", Font.PLAIN, 13));
		troopLabel6.setForeground(new Color(100, 100, 100));
		troopLabel6.setBounds(410, 610, 80, 20);
		troopLabel6.setText("Ranger: 20");
		panel.add(troopLabel6);
		
		final JButton infantryButton = new JButton();
		infantryButton.setBounds(20, 550, 60, 60);
		infantryButton.setBorder(BorderFactory.createEmptyBorder());
		infantryButton.setContentAreaFilled(false);
		infantryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<BattleField.deployUnit.length; i++) {
					if (i==0) {
						BattleField.deployUnit[i] = true;
					} else {
						BattleField.deployUnit[i] = false;
					}
				}
			}
		});
		
		try {
			Image img1 = ImageIO.read(getClass().getResource("images/SOMinfantry.png"));
			img1 = img1.getScaledInstance(60, -1,  java.awt.Image.SCALE_REPLICATE );
			infantryButton.setIcon(new ImageIcon(img1));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		panel.add(infantryButton);
		
		final JButton riderButton = new JButton();
		riderButton.setBounds(100, 550, 60, 60);
		riderButton.setBorder(BorderFactory.createEmptyBorder());
		riderButton.setContentAreaFilled(false);
		riderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<BattleField.deployUnit.length; i++) {
					if (i==1) {
						BattleField.deployUnit[i] = true;
					} else {
						BattleField.deployUnit[i] = false;
					}
				}
			}
		});
		
		try {
			Image img2 = ImageIO.read(getClass().getResource("images/SOMrider.png"));
			img2 = img2.getScaledInstance(60, -1,  java.awt.Image.SCALE_REPLICATE );
			riderButton.setIcon(new ImageIcon(img2));
		} catch (IOException e) {
			e.printStackTrace();
		}
		panel.add(riderButton);
		
		final JButton archerButton = new JButton();
		archerButton.setBounds(180, 550, 60, 60);
		archerButton.setBorder(BorderFactory.createEmptyBorder());
		archerButton.setContentAreaFilled(false);
		archerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<BattleField.deployUnit.length; i++) {
					if (i==2) {
						BattleField.deployUnit[i] = true;
					} else {
						BattleField.deployUnit[i] = false;
					}
				}
			}
		});
		
		try {
			Image img3 = ImageIO.read(getClass().getResource("images/SOMarcher.png"));
			img3 = img3.getScaledInstance(60, -1,  java.awt.Image.SCALE_REPLICATE );
			archerButton.setIcon(new ImageIcon(img3));
		} catch (IOException e) {
			e.printStackTrace();
		}
		panel.add(archerButton);
		
		final JButton warriorButton = new JButton();
		warriorButton.setBounds(260, 550, 60, 60);
		warriorButton.setBorder(BorderFactory.createEmptyBorder());
		warriorButton.setContentAreaFilled(false);
		warriorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<BattleField.deployUnit.length; i++) {
					if (i==3) {
						BattleField.deployUnit[i] = true;
					} else {
						BattleField.deployUnit[i] = false;
					}
				}
			}
		});
		
		try {
			Image img4 = ImageIO.read(getClass().getResource("images/SOMwarrior.png"));
			img4 = img4.getScaledInstance(60, -1,  java.awt.Image.SCALE_REPLICATE );
			warriorButton.setIcon(new ImageIcon(img4));
		} catch (IOException e) {
			e.printStackTrace();
		}
		panel.add(warriorButton);
		
		final JButton knightButton = new JButton();
		knightButton.setBounds(340, 550, 60, 60);
		knightButton.setBorder(BorderFactory.createEmptyBorder());
		knightButton.setContentAreaFilled(false);
		knightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<BattleField.deployUnit.length; i++) {
					if (i==4) {
						BattleField.deployUnit[i] = true;
					} else {
						BattleField.deployUnit[i] = false;
					}
				}
			}
		});
		
		try {
			Image img5 = ImageIO.read(getClass().getResource("images/SOMknight.png"));
			img5 = img5.getScaledInstance(60, -1,  java.awt.Image.SCALE_REPLICATE );
			knightButton.setIcon(new ImageIcon(img5));
		} catch (IOException e) {
			e.printStackTrace();
		}
		panel.add(knightButton);
		
		final JButton rangerButton = new JButton();
		rangerButton.setBounds(420, 550, 60, 60);
		rangerButton.setBorder(BorderFactory.createEmptyBorder());
		rangerButton.setContentAreaFilled(false);
		rangerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<BattleField.deployUnit.length; i++) {
					if (i==5) {
						BattleField.deployUnit[i] = true;
					} else {
						BattleField.deployUnit[i] = false;
					}
				}
			}
		});
		
		try {
			Image img6 = ImageIO.read(getClass().getResource("images/SOMranger.png"));
			img6 = img6.getScaledInstance(60, -1,  java.awt.Image.SCALE_REPLICATE );
			rangerButton.setIcon(new ImageIcon(img6));
		} catch (IOException e) {
			e.printStackTrace();
		}
		panel.add(rangerButton);
		
		mithrilLabel = new JLabel();
		mithrilLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
		mithrilLabel.setBounds(500, 550, 80, 30);
		
		try {
			Image img7 = ImageIO.read(getClass().getResource("images/SOMmithril.png"));
			img7 = img7.getScaledInstance(30, -1, Image.SCALE_REPLICATE);
			mithrilLabel.setIcon(new ImageIcon(img7));
		} catch(IOException e) {
			e.printStackTrace();
		}
		panel.add(mithrilLabel);
		
		HPLabel = new JLabel();
		HPLabel.setFont(new Font("Algerian", Font.PLAIN, 15));
		HPLabel.setBounds(500, 580, 80, 30);
		
		try {
			Image img8 = ImageIO.read(getClass().getResource("images/SOMlife.png"));
			img8 = img8.getScaledInstance(30, -1, Image.SCALE_REPLICATE);
			HPLabel.setIcon(new ImageIcon(img8));
		} catch(IOException e) {
			e.printStackTrace();
		}
		panel.add(HPLabel);
		
		final JLabel citadelLabel = new JLabel();
		citadelLabel.setBounds(250, 450, 80, 80);
		citadelLabel.setBorder(BorderFactory.createEmptyBorder());
		try {
			Image img9 = ImageIO.read(getClass().getResource("images/SOMcitadel.png"));
			img9 = img9.getScaledInstance(80, -1, Image.SCALE_REPLICATE);
			citadelLabel.setIcon(new ImageIcon(img9));
		} catch(IOException e) {
			e.printStackTrace();
		}
		panel.add(citadelLabel);
		
		status = new JLabel("", SwingConstants.CENTER);
		status.setForeground(new Color(240, 180, 0));
		status.setFont(new Font("Algerian", Font.PLAIN, 14));
		status.setBounds(50, 10, 500, 20);
		panel.add(status);
		
	}

}
