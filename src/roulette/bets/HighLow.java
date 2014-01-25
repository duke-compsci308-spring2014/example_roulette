package roulette.bets;

import roulette.Wheel;
import util.ConsoleReader;

public class HighLow extends Bet
{
    private String myChoice;


    public HighLow (String description, int odds)
    {
        super(description, odds);
    }

    @Override
    public void place ()
    {
        myChoice = ConsoleReader.promptOneOf("Please bet", "high", "low");
    }

    @Override
    public boolean isMade (String color, int number)
    {
    	int half = (Wheel.MAX_NUMBER + 1) / 2;
        return (1 <= number && number < half && myChoice.equals("low")) ||
               (half <= number && number < Wheel.MAX_NUMBER && myChoice.equals("high"));
    }
}
