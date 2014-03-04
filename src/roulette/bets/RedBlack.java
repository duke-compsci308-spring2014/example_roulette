package roulette.bets;

import roulette.Wheel;
import util.ConsoleReader;


public class RedBlack extends Bet
{
    private String myChoice;


    public RedBlack ()
    {
        this("Red or Black", 1);
    }

    public RedBlack (String description, int odds)
    {
        super(description, odds);
    }

    @Override
    public void place ()
    {
        myChoice = ConsoleReader.promptOneOf("Please bet", Wheel.BLACK, Wheel.RED);
    }

    @Override
    public boolean isMade (String color, int number)
    {
        return color.equals(myChoice);
    }
}
