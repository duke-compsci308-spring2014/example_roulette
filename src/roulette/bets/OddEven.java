package roulette.bets;

import util.ConsoleReader;


public class OddEven extends Bet
{
    private String myChoice;

    
    public OddEven (String description, int odds)
    {
        super(description, odds);
    }

    @Override
    public void place ()
    {
        myChoice = ConsoleReader.promptOneOf("Please bet", "even", "odd");
    }

    @Override
    public boolean isMade (String color, int number)
    {
        return (number % 2 == 0 && myChoice.equals("even")) ||
               (number % 2 == 1 && myChoice.equals("odd"));
    }
}
