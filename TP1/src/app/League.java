package app;

import java.util.List;

public class League extends Competition {

    public League(List<Competitor> competitors) {
        super(competitors);
    }

    @Override
    public Competitor play() {
        super.play(); //Match aller
        return super.play(); //Return resultat match aller + retour
    }
}
