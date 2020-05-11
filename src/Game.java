/**
 * CIS 120 Game HW
 * Shadows of Mordor
 * Developed by Daniel Joongwon Kim
 */


import javax.swing.*;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * PLEASE ENTER YOUR NICKNAME ON THE CONSOLE AT THE BEGINNING OF THE GAME!!!
 * OTHERWISE THE GAME WILL NOT SHOW UP!!!
 */

public class Game implements Runnable {
	
	public static String userName;
	
	public static boolean GameON = false;
	
	public static int mithrils;
	public static int HP;
	
	public static Map<String, Integer> allRecords;
	public static String[] bestPlayers;
	public static int highScore;
	
	public static SOMmenu menu;
	public static SOMgame game;
	public static SOMinfo info;
	
	public void run() {
		
		Scanner inputReader = new Scanner(System.in);
		System.out.println("Please enter a nickname, without using $: ");
		String s = inputReader.next();
		while (s.contains("$")) {
			System.out.println("Please enter a nickname, without using $: ");
			s = inputReader.next();
		}
		userName = s;
		inputReader.close();
		
		allRecords = new TreeMap<String, Integer>();
		allRecords = IOHandler.readScore();
		bestPlayers = IOHandler.bestPlayers(allRecords);
		
		menu = new SOMmenu();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setBounds(50, 30, 600, 450);
		
		game = new SOMgame();
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setBounds(50, 30, 600, 680);
		
		info = new SOMinfo();
		info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		info.setBounds(50, 30, 600, 450);
		
		menu.setVisible(true);
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Game());
	}

}
