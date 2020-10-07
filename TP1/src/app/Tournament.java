package app;

import java.util.ArrayList;
import java.util.List;

public class Tournament extends Competition {

    private List<Competitor> competitors;

    public Tournament(List<Competitor> competitors) {
        super(competitors);
    }

    public Competitor process(List<Competitor> c){
        if(c.size() == 1){
            return c.get(0);
        }
        ArrayList<Competitor> competitorsRemaining = new ArrayList<>();
        if(c.size()%2!=0){
            competitorsRemaining.add(c.get(0));
            c.remove(0);
        }
        for (int i =1; i<c.size();i+=2){
            Match m = new Match(c.get(i-1), c.get(i));
            if (m.play() == 0){
                competitorsRemaining.add(c.get(i-1));
            }else{
                competitorsRemaining.add(c.get(i));
            }
        }
        return process(competitorsRemaining);
    }

    @Override
    public Competitor play() {
        return process(competitors);
    }
}
