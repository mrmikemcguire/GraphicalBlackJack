import java.awt.*; 
import java.awt.event.*; 
import java.util.Random;
import java.util.Scanner;

import javax.swing.*; 

public class DealCards
	{
	private static final long serialVersionUID = 1L; 
	static int [] playerScores = {0, 0, 0, 0, 0, 0}; 
	static String [] useless = {"Okay"};
	static int dealerScore=0, h;
	static String cardDrawn, cardDrawn2; 
	static String [] dealerCards = {"", "", "", "", ""};
	static String [] possibleCards = {"Two of Hearts", "Three of Hearts", "Four of Hearts", "Five of Hearts", "Six of Hearts", "Seven of Hearts", "Eight of Hearts", "Nine of Hearts", "Ten of Hearts", "Jack of Hearts", "Queen of Hearts", "King of Hearts", "Ace of Hearts",  
			"Two of Hearts", "Three of Diamonds", "Four of Diamonds", "Five of Diamonds", "Six of Diamonds", "Seven of Diamonds", "Eight of Diamonds", "Nine of Diamonds", "Ten of Diamonds", "Jack of Diamonds", "Queen of Diamonds", "King of Diamonds", "Ace of Diamonds",
			"Two of Spades", "Three of Spades", "Four of Spades", "Five of Spades", "Six of Spades", "Seven of Spades", "Eight of Spades", "Nine of Spades", "Ten of Spades", "Jack of Spades", "Queen of Spades", "King of Spades", "Ace of Spades", 
			"Two of Clubs", "Three of Clubs", "Four of Clubs", "Five of Clubs", "Six of Clubs", "Seven of Clubs", "Eight of Clubs", "Nine of Clubs", "Ten of Clubs", "Jack of Clubs", "Queen of Clubs", "King of Clubs", "Ace of Clubs"};
	static int [] cardValues = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 
		2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 
		2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11, 
		2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11}; 
	static JFrame initialDeal = new JFrame();
	static JFrame showScore = new JFrame(); 
	static JFrame hitOrStayFrame = new JFrame(); 
	static JFrame secondDealing = new JFrame();
	
	public static void miniMethodDealCards()
		{
		dealInitialCards(); 
		dealIfHit(); 
		examineScores(); 
		}
	
	public static void dealInitialCards()
		{
		Random randomNumber1 = new Random();
		int randomCard = randomNumber1.nextInt(52);
		cardDrawn = possibleCards[randomCard]; 
		h=0; 
		dealerCards[h] = cardDrawn; 
		h++; 
		Random randomNumber2 = new Random();
		int randomCard2 = randomNumber2.nextInt(52);
		cardDrawn = possibleCards[randomCard2]; 
		dealerCards[h] = cardDrawn;
		h++; 
		dealerScore = dealerScore + cardValues[randomCard] + cardValues[randomCard2];
		
		for(int l=0; l < TitleMenu.totalPlayers; l++)
			{
			for(int i=0; i<1; i++)
				{
				Random randomNumber3 = new Random();
				int randomCard1 = randomNumber3.nextInt(52);
				cardDrawn = possibleCards[randomCard1]; 
				Random randomNumber4 = new Random();
				int randomCard4 = randomNumber4.nextInt(52);
				cardDrawn2 = possibleCards[randomCard4]; 
				int uselessVariable  = JOptionPane.showOptionDialog(initialDeal, "Okay, " + TitleMenu.playerNames[l] + ", you have been dealt the following cards. " + cardDrawn + " and " + cardDrawn2, "Initial dealing", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
				playerScores[l] = playerScores[l] + cardValues[randomCard1] + cardValues[randomCard4]; 
				int uselessVariable2  = JOptionPane.showOptionDialog(showScore, "Okay, " + TitleMenu.playerNames[l] + ", your score is " + playerScores[l], "Score Count", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
				}
			}
		}
	
	public static void dealIfHit() 
	{
	for(int e = 0; e<2; e++)
		{
		for(int y=0; y<TitleMenu.totalPlayers; y++)
			{
			if(dealerScore<15)
				{
				Random randomNumber2 = new Random();
				int randomCard2 = randomNumber2.nextInt(52);
				cardDrawn = possibleCards[randomCard2]; 
				dealerScore = dealerScore + cardValues[randomCard2]; 
				dealerCards[h] = cardDrawn;
				h++;
				}
			else
				{	
				}
			String [] hitOrStay = {"Stay", "Hit"}; 
		int hitOrStayChoice  = JOptionPane.showOptionDialog(hitOrStayFrame, "Okay, " + TitleMenu.playerNames[y] + " your current score is " + playerScores[y] +". What would you like to do", "Hit or Stay", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, hitOrStay, hitOrStay[1]);
		switch(hitOrStayChoice)
			{
			case 1: 
				{
				Random randomNumber3 = new Random();
				int randomCard1 = randomNumber3.nextInt(52);
				cardDrawn = possibleCards[randomCard1]; 
				int uselessVariable  = JOptionPane.showOptionDialog(secondDealing, "Okay, " + TitleMenu.playerNames[y] + ", you have been dealt the " + cardDrawn, "Second dealing", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
				playerScores[y] = playerScores[y] + cardValues[randomCard1];
				}
			case 2: 
				{
				break; 
				}
			}
			}
		}
	}
	
	public static void examineScores()
	{
	int uselessVariable  = JOptionPane.showOptionDialog(secondDealing, "Okay, the dealer drew the following cards. " + dealerCards[0] + " " + dealerCards[1] + " " + dealerCards[2] + " " + dealerCards[3], "Dealer Cards", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
	int uselessVariable1  = JOptionPane.showOptionDialog(secondDealing, "The dealer has a final score of " + dealerScore, "Dealer Score", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
	
	for(int s=0; s<TitleMenu.totalPlayers; s++)
		{
		int playerScore = JOptionPane.showOptionDialog(secondDealing,"Okay, " + TitleMenu.playerNames[s] + ", your final score is " + playerScores[s], "Player Score", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
		if(playerScores[s] >21)
			{
			int uselessVariable2  = JOptionPane.showOptionDialog(secondDealing, "You busted out! You lost your bet of " + TitleMenu.playerBets[s], "Player Bust", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
			TitleMenu.playerMoney[s] = (TitleMenu.playerMoney[s] - TitleMenu.playerBets[s]); 
			int uselessVariable3  = JOptionPane.showOptionDialog(secondDealing, "You are walking away with " + TitleMenu.playerMoney[s], "Player Bust", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
			}
		else if(dealerScore>21)
			{
			int uselessVariable2  = JOptionPane.showOptionDialog(secondDealing,"The dealer has busted out! You win your bet of " + TitleMenu.playerBets[s], "Player Bust", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
			TitleMenu.playerMoney[s] = TitleMenu.playerMoney[s] + (TitleMenu.playerBets[s]*2); 
			int uselessVariable4  = JOptionPane.showOptionDialog(secondDealing,"You are walking away with " + TitleMenu.playerMoney[s], "Player Bust", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
			}
		else if ((dealerScore < playerScores[s]) && (playerScores[s] <= 21))
			{
			int uselessVariable2  = JOptionPane.showOptionDialog(secondDealing,"The dealer had a score of " + dealerScore + ", while you had a score of " + playerScores[s], "Player Bust", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
			int uselessVariable3  = JOptionPane.showOptionDialog(secondDealing,"You beat the dealer!! You win your bet of " + TitleMenu.playerBets[s], "Player Bust", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
			TitleMenu.playerMoney[s] = TitleMenu.playerMoney[s] + (TitleMenu.playerBets[s]*2); 
			int uselessVariable4  = JOptionPane.showOptionDialog(secondDealing,"You are walking away with " + TitleMenu.playerMoney[s], "Player Bust", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
			}
		else if (dealerScore > playerScores[s])
			{
			int uselessVariable2  = JOptionPane.showOptionDialog(secondDealing,"Im sorry. The dealer beat you with his score of " + dealerScore + " and your score of "	+ playerScores[s], "Player Bust", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
			int uselessVariable3  = JOptionPane.showOptionDialog(secondDealing,"The dealer has won your bet of " + TitleMenu.playerBets[s], "Player Bust", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
			TitleMenu.playerMoney[s] = TitleMenu.playerMoney[s] - (TitleMenu.playerBets[s]);
			int uselessVariable4  = JOptionPane.showOptionDialog(secondDealing,"You are walking away with " + TitleMenu.playerMoney[s], "Player Bust", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, useless, useless[0]);
			} 
 		else
			{	
			}
		}
	}
	}
