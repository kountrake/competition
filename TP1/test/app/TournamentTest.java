package app;


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
    void oddCompetitors() {
        assertEquals(5, competition.competitors.size());
        competition.oddCompetitors();
        assertEquals(4, competition.competitors.size());
        assertEquals(1, competition.getCompetitorsRemaining().size());
        assertEquals(c1, competition.getCompetitorsRemaining().get(0));
    }

    @Test
    void winnerGoesNextRoundTest() {
        assertEquals(0, competition.getCompetitorsRemaining().size());
        competition.playMatch(c1, c2);
        competition.winnerGoesNextRound();
        assertEquals(1, competition.getCompetitorsRemaining().size());
    }

    @Test
    void playARoundTest() {
        assertEquals(5, competition.competitors.size());
        competition.oddCompetitors();
        assertEquals(4, competition.competitors.size());
        assertEquals(1, competition.getCompetitorsRemaining().size());
        assertEquals(c1, competition.getCompetitorsRemaining().get(0));
        competition.playARound(competition.competitors);
        assertEquals(3, competition.getCompetitorsRemaining().size());
    }

    @Test
    void playTest() {
        assertEquals(5, competition.competitors.size());
        assertEquals(0, competition.getCompetitorsRemaining().size());
        competition.play();
        assertEquals(1, competition.getCompetitorsRemaining().size(), "Problem with the amount of winner");
    }
}