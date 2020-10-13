package david.naessens.app;

/**
 * The type Competitor.
 */
public class Competitor {

    private String name;
    private int strength;
    private int wins;

    /**
     * Instantiates a new Competitor.
     */
    /* Constructors */
    public Competitor() {
        name = "no-name";
        strength = 1;
        wins = 0;
    }

    /**
     * Instantiates a new Competitor.
     *
     * @param name the name
     */
    public Competitor(String name) {
        this.name = name;
		this.strength = 1;
	}

    /**
     * Instantiates a new Competitor.
     *
     * @param name     the name
     * @param strength the strength
     */
    public Competitor (String name, int strength) {
		this.name = name;
		this.strength = strength;
	}
	
	/* Getters and Setters */

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
		return name;
	}

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets strength.
     *
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Sets strength.
     *
     * @param strength the strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Gets wins.
     *
     * @return the wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Increase wins.
     */
    public void increaseWins() {
        this.wins += 1;
    }
}
