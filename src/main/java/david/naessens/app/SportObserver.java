package david.naessens.app;

public interface SportObserver {

    void notifyMatchResult(Competitor winner, Competitor looser);
}
