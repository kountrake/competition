package david.naessens.app.sportObserver;

import david.naessens.app.competition.component.Competitor;


public interface SportObserver {

    /**
     * Notify match result.
     *
     * @param winner the winner
     * @param looser the looser
     */
    void notifyMatchResult(Competitor winner, Competitor looser);
}
