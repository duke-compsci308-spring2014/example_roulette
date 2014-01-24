package roulette;

import util.ConsoleReader;


public class RedBlack extends Bet
{
    public RedBlack (String description, int odds)
    {
        super(description, odds);
    }

    @Override
    public String place ()
    {
        return ConsoleReader.promptOneOf("Please bet", Wheel.BLACK, Wheel.RED);
    }

    @Override
    public boolean isMade (String betChoice, Wheel wheel)
    {
        return wheel.getColor().equals(betChoice);
    }
}
