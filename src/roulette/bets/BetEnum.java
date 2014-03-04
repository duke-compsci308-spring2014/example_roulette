package roulette.bets;

import roulette.Wheel;
import util.ConsoleReader;


/**
 * Represents player's attempt to bet on outcome of the roulette wheel's spin.
 * 
 * @author Robert C. Duvall
 */
public enum BetEnum
{
    RedBlack("Red or Black", 1)
    {
        @Override
        public void place ()
        {
            super.myChoice = ConsoleReader.promptOneOf("Please bet", Wheel.BLACK, Wheel.RED);
        }
        @Override
        public boolean isMade (String color, int number)
        {
            return color.equals(super.myChoice);
        }
    },
    OddEven("Odd or Even", 1)
    {
        @Override
        public void place ()
        {
            super.myChoice = ConsoleReader.promptOneOf("Please bet", "even", "odd");
        }
        @Override
        public boolean isMade (String color, int number)
        {
            return (number % 2 == 0 && super.myChoice.equals("even")) ||
                   (number % 2 == 1 && super.myChoice.equals("odd"));
        }
    },
    HighLow("High or Low", 1)
    {
        @Override
        public void place ()
        {
            super.myChoice = ConsoleReader.promptOneOf("Please bet", "high", "low");
        }
        @Override
        public boolean isMade (String color, int number)
        {
            int half = (Wheel.MAX_NUMBER + 1) / 2;
            return (1 <= number && number < half && super.myChoice.equals("low")) ||
                   (half <= number && number < Wheel.MAX_NUMBER && super.myChoice.equals("high"));
        }
    },
    OneConsecutive("One in a Row", 35)
    {
        private int myRange = 1;
        @Override
        public void place ()
        {
            super.myStart = ConsoleReader.promptRange("Enter first of consecutive numbers",
                                                      1, Wheel.MAX_NUMBER - myRange);
        }
        @Override
        public boolean isMade (String color, int number)
        {
            return (super.myStart <= number && number < super.myStart + myRange);
        }
    },
    TwoConsecutive("Two in a Row", 17)
    {
        private int myRange = 2;
        @Override
        public void place ()
        {
            super.myStart = ConsoleReader.promptRange("Enter first of consecutive numbers",
                                                      1, Wheel.MAX_NUMBER - myRange);
        }
        @Override
        public boolean isMade (String color, int number)
        {
            return (super.myStart <= number && number < super.myStart + myRange);
        }
    },
    ThreeConsecutive("Three in a Row", 11)
    {
        private int myRange = 3;
        @Override
        public void place ()
        {
            super.myStart = ConsoleReader.promptRange("Enter first of consecutive numbers",
                                                      1, Wheel.MAX_NUMBER - myRange);
        }
        @Override
        public boolean isMade (String color, int number)
        {
            return (super.myStart <= number && number < super.myStart + myRange);
        }
    };

    // original state
    private String myDescription;
    private int myOdds;
    // subclass state
    private int myStart;
    private String myChoice;


    /**
     * Constructs a bet with the given name and odds.
     */
    private BetEnum (String description, int odds)
    {
        myDescription = description;
        myOdds = odds;
    }

    /**
     * @return odds given by the house for this kind of bet
     */
    public int getOdds ()
    {
        return myOdds;
    }

    /**
     * @return name of this kind of bet
     */
    public String getDescription ()
    {
        return myDescription;
    }

    /**
     * @return string representation of this bet
     */
    public String toString ()
    {
        return getDescription();
    }

    /**
     * Place the given bet by prompting the user for the specific information
     * need to complete the given bet.
     */
    public abstract void place ();

    /**
     * Checks if the given bet is won or lost given the user's choice and the result
     * of spinning the wheel.
     */
    public abstract boolean isMade (String color, int number);
}
