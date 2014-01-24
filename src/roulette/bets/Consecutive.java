package roulette.bets;

import roulette.Wheel;
import util.ConsoleReader;


public class Consecutive extends Bet
{
    private int myStart;
    private int myRange;


    public Consecutive (String description, int odds, int range)
    {
        super(description, odds);
        myRange = range;
    }

    @Override
    public void place ()
    {
         myStart = ConsoleReader.promptRange("Enter first of consecutive numbers",
        		                             1, Wheel.MAX_NUMBER - myRange);
    }

    @Override
    public boolean isMade (String color, int number)
    {
        return (myStart <= number && number < myStart + myRange);
    }
}
