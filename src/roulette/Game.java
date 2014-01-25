package roulette;

import roulette.bets.Bet;
import roulette.bets.HighLow;
import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.Consecutive;
import util.ConsoleReader;


/**
 * Plays a game of roulette.
 * 
 * @author Robert C. Duvall
 */
public class Game
{
    // name of the game
    private static final String DEFAULT_NAME = "Roulette";

    private Wheel myWheel;
    private static final Bet[] POSSIBLE_BETS =
        {
            new RedBlack("Red or Black", 1),
            new OddEven("Odd or Even", 1),
            new HighLow("High or Low", 1),
            new Consecutive("Three in a Row", 35, 1),
            new Consecutive("Three in a Row", 17, 2),
            new Consecutive("Three in a Row", 11, 3),
        };


    /**
     * Construct the game.
     */
    public Game ()
    {
        myWheel = new Wheel();
    }


    /**
     * @return name of the game
     */
    public String getName ()
    {
        return DEFAULT_NAME;
    }


    /**
     * Play a round of this game.
     *
     * For Roulette, this means prompting the player to make a bet, 
     * spinning the roulette wheel, and then verifying that the bet
     * is won or lost.
     *
     * @param player one that wants to play a round of the game
     */
    public void play (Gambler player)
    {
        int amount = ConsoleReader.promptRange("How much do you want to bet", 
                                               0, player.getBankroll());
        Bet b = promptForBet();
        b.place();

        System.out.print("Spinning ...");
        myWheel.spin();
        System.out.println("Dropped into " + myWheel.getColor() + " " + myWheel.getNumber());

        if (b.isMade(myWheel.getColor(), myWheel.getNumber()))
        {
            System.out.println("*** Congratulations :) You win ***");
            amount *= b.getOdds();
        }
        else
        {
            System.out.println("*** Sorry :( You lose ***");
            amount *= -1;
        }
        player.updateBankroll(amount);
    }


    /**
     * Prompt the user to make a bet from a menu of choices.
     */
    private Bet promptForBet ()
    {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < POSSIBLE_BETS.length; k++)
        {
            System.out.println((k + 1) + ") " + POSSIBLE_BETS[k]);
        }

        int response = ConsoleReader.promptRange("Please make a choice",
                                                 1, POSSIBLE_BETS.length);
        return POSSIBLE_BETS[response - 1];
    }
}
