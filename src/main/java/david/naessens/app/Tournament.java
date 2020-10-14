package david.naessens.app;


import java.util.ArrayList;
import java.util.List;

/**
 * The type Tournament.
 */
public class Tournament extends Competition {

    private final ArrayList<Competitor> competitorsRemaining;

    /**
     * Instantiates a new Tournament.
     *
     * @param competitors the competitors
     */
    public Tournament(List<Competitor> competitors) {
        super(competitors);
        competitorsRemaining = new ArrayList<Competitor>();
        competitorsRemaining.addAll(competitors);
    }

    /**
     * Gets competitors remaining.
     *
     * @return the competitors remaining
     */
    public ArrayList<Competitor> getCompetitorsRemaining() {
        return competitorsRemaining;
    }


    /**
     * Play a match.
     *
     * @param c the competitors
     * @param i the index
     */
    public void playAMatch(List<Competitor> c, int i) {
        match.setCompetitor1(c.get(i - 1));
        match.setCompetitor1(c.get(i));
        match.play();
    }

    /**
     * Process competitor.
     * /!\ Do not work... The Random class throw an error because of the recursive calls
     * @param c the competitors
     */
    public void process(List<Competitor> c) {
        int i = 1;
        int nbRounds = 1;
        while(c.size()!=1){
            playAMatch(c, i);
            removeLoser();
            i = nextMatch(i, nbRounds);
            if (i >= competitorsRemaining.size()){
                i--;
                nbRounds++;
            }
            if (i==0){
                i++;
                nbRounds++;
            }
        }
    }

    private int nextMatch(int i, int nbRounds) {
        if (nbRounds % 2 == 0){
            i--;
        }else{
            i++;
        }
        return i;
    }

    private void removeLoser() {
        if (this.match.getWinner() == this.match.getCompetitor1()){
            competitorsRemaining.remove(this.match.getCompetitor2());
        }else{
            competitorsRemaining.remove(this.match.getCompetitor1());
        }
        System.out.println("On remove un joueur");
    }

    @Override
    public void play() {
        process(competitorsRemaining);
    }
}
