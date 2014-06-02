import java.awt.*; 
import java.awt.event.*; 

import javax.swing.*; 

public class TitleMenu extends JPanel

	{
	private static final long serialVersionUID = 1L; 
	static String player, name;
	static int totalPlayers, bet;  
	static String [] playerNames = {"", "", "", "", "", ""}; 
	static int [] playerMoney = {500, 500, 500, 500, 500, 500}; 
	static int [] playerBets = {0, 0, 0, 0 ,0 ,0 };
	static JFrame playerFrame = new JFrame(); 
	static JFrame betFrame= new JFrame(); 
	static JFrame initialDeal = new JFrame(); 
	
	public static void miniMethodTitle()
		{
		askForPlayers(); 
		askForBets(); 
		}
	
	public static void askForPlayers()
		{
		Object[] playerOptions = {1, 2, 3, 4}; 
		totalPlayers  = (JOptionPane.showOptionDialog(playerFrame, "How many players will be playing?", "Choose player count", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, playerOptions, playerOptions[3])+1); 
		for(int i=0; i<totalPlayers; i++)
			{
			name = JOptionPane.showInputDialog("Player " + (i+1) + ", What is your name?"); 
			playerNames[i]= name; 
			}

		}
	
	public static void askForBets()
		{
		Object[] possibleBets = {100, 200, 300, 400, 500}; 
		for(int j=0; j<totalPlayers; j++)
			{
			bet = JOptionPane.showOptionDialog(betFrame, "Okay, " + playerNames[j] + ", what is your bet?", "Place Your Bets", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, possibleBets, possibleBets[4]); 
			playerBets[j]= (bet*100); 
			}
		}

	}
