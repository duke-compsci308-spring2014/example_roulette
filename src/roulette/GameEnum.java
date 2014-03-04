package roulette;

import roulette.bets.BetEnum;
import util.ConsoleReader;


/**
 * Plays a game of roulette.
 * 
 * @author Robert C. Duvall
 */
public class GameEnum
{
    // constants
    private static final String DEFAULT_NAME = "Roulette";
    // game state
    private Wheel myWheel;


    /**
     * Construct the game.
     */
    public GameEnum ()
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
        BetEnum b = promptForBet();
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
    private BetEnum promptForBet ()
    {
        BetEnum[] possibleBets = BetEnum.values();
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < possibleBets.length; k++)
        {
            System.out.println((k + 1) + ") " + possibleBets[k]);
        }

        int response = ConsoleReader.promptRange("Please make a choice",
                                                 1, possibleBets.length);
        return possibleBets[response - 1];
    }
}
