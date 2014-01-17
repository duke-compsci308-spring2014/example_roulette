package roulette;

/**
 * Represents player's attempt to bet on outcome of the roulette wheel's spin.
 * 
 * @author Robert C. Duvall
 */
public class Bet
{
    private String myDescription;
    private int myOdds;


    /**
     * Constructs a bet with the given name and odds.
     * 
     * @param description name of this kind of bet
     * @param odds odds given by the house for this kind of bet
     */
    public Bet (String description, int odds)
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
}
