import david.naessens.app.competition.League;
import david.naessens.app.competition.Master;
import david.naessens.app.competition.Tournament;
import david.naessens.app.competition.component.Competitor;
import david.naessens.app.competitorsselector.BettersOut;
import david.naessens.app.competitorsselector.CompetitorsSelector;
import david.naessens.app.exceptions.NotAPowerOfTwoException;
import david.naessens.app.sportObserver.Bookmaker;
import david.naessens.app.sportObserver.Journalist;
import david.naessens.util.CompetitorsGenerator;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws NotAPowerOfTwoException {

        //Create your own competitors
        Competitor competitor = new Competitor("Name");

        //Generate some random competitors
        ArrayList<Competitor> competitors = CompetitorsGenerator.generateCompetitors(11);

        //Don't forget to add your competitor to the list before creating a competition
        competitors.add(competitor);

        // Create your own league
        //A league makes every competitors play against each other twice
        League league = new League(competitors);

        // Let's play the League !
        league.play();

        // What's the ranking now ?
        System.out.println(league.ranks());

        // Would have been great to have some Journalists commenting who won each match
        Journalist journalist = new Journalist("FFSU");

        league = new League(competitors);
        league.addSportObserver(journalist);

        league.play();

        //Want to have some bookmaker to see the evolution of the odds after each match ?
        Bookmaker bookmaker = new Bookmaker(competitors);
        league.addSportObserver(bookmaker);

        // Now we can play it again and see the commentary and the odds
        league.play();


        // Let's have a look at the other types of competition
        competitors = CompetitorsGenerator.generateCompetitors(12);
        Tournament tournament = new Tournament(competitors);
        tournament.play();
        System.out.println(tournament.tournamentSummary());

        // /!\ The competitors selector require for its argument a power of two /!\
        competitors = CompetitorsGenerator.generateCompetitors(12);
        CompetitorsSelector competitorsSelector = new BettersOut(8);
        Master master = new Master(competitors, 4, competitorsSelector);

        master.play();
        System.out.println(master.masterSummary());

    }

}
