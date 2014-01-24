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
    

    /**
     * Place the given bet by prompting the user for the specific information
     * need to complete the given bet.
     */
    public String place ()
    {
        return "";
    }


    /**
     * Checks if the given bet is won or lost given the user's choice and the result
     * of spinning the wheel.
     *
     * @param betChoice specific value user chose to try to win the bet
     * @param wheel information needed to check if bet won or lost
     */
    public boolean isMade (String betChoice, Wheel wheel)
    {
    	return false;
    }
}
