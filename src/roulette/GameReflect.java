package roulette;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import roulette.bets.Bet;
import util.ConsoleReader;


/**
 * Plays a game of roulette.
 * 
 * @author Robert C. Duvall
 */
public class GameReflect
{
    // constants
    public static final String DEFAULT_NAME = "Roulette";
    public static final String DEFAULT_BETS = "resources/bets";
    // mutable state
    private Wheel myWheel;
    private List<Bet> myBets;


    /**
     * Construct the game.
     */
    public GameReflect ()
    {
        myWheel = new Wheel();
        myBets = makeBets();
    }


    private List<Bet> makeBets ()
    {
        List<Bet> results = new ArrayList<Bet>();
        ResourceBundle resources = ResourceBundle.getBundle(DEFAULT_BETS);
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements())
        {
            try
            {
                Class<?> clss = Class.forName(resources.getString(iter.nextElement()));
                results.add((Bet)clss.newInstance());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return results;
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
        for (int k = 0; k < myBets.size(); k++)
        {
            System.out.println((k + 1) + ") " + myBets.get(k));
        }

        int response = ConsoleReader.promptRange("Please make a choice",
                                                 1, myBets.size());
        return myBets.get(response - 1);
    }
}
