package david.naessens.app;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TournamentTest {

    Competitor c1;
    Competitor c2;
    Competitor c3;
    Competitor c4;
    Competitor c5;
    Tournament competition;


    @BeforeEach
    void setUp() {
        c1 = new Competitor("Jhon");
        c2 = new Competitor("Doe", 5);
        c3 = new Competitor("Timo", 2);
        c4 = new Competitor("Leon", 7);
        c5 = new Competitor("Test", 3);
        ArrayList<Competitor> competitors = new ArrayList<>();
        competitors.add(c1);
        competitors.add(c2);
        competitors.add(c3);
        competitors.add(c4);
        competitors.add(c5);
        competition = new Tournament(competitors);
    }

    @Test
    void playTest() {
        competition.play();
        assertEquals(1, competition.getCompetitorsRemaining().size(), "Problem with the amount of winner");
    }
}