package david.naessens.app;

public class Journalist implements SportObserver {

    private final String workingFor;

    public Journalist() {
        this.workingFor = "the competition";
    }

    public Journalist(String from) {
        this.workingFor = from;
    }

    @Override
    public void notifyMatchResult(Competitor winner, Competitor looser) {
        System.out.println(
                "Here is your favourite journalist from " + this.workingFor + ".\n"
                        + "The match opposing " + winner.getName()
                        + " versus " + looser.getName()
                        + " ended with the victory of " + winner.getName() + ".\n"
        );
    }
}
