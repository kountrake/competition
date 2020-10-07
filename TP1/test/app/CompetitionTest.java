package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;


import static org.junit.jupiter.api.Assertions.*;
import static util.MathUtils.*;

class CompetitionTest {

    Competitor c1;
    Competitor c2;
    Competitor c3;
    Competitor c4;
    Competition competition;


    @BeforeEach
    void setUp() {
        c1 = new Competitor("Jhon");
        c2 = new Competitor("Doe",5);
        c3 = new Competitor("Timo",2);
        c4 = new Competitor("Leon",7);
        ArrayList<Competitor> competitors = new ArrayList<>();
        competitors.add(c1);
        competitors.add(c2);
        competitors.add(c3);
        competitors.add(c4);
        competition = new Competition(competitors);
        competition.play();
    }

    @Test
    void mostWinTest() {
        assertEquals(Collections.max(competition.getWins()), competition.getWins().get(competition.mostWin()));
    }

    @Test
    void playTest(){
        assertEquals(fact(competition.getCompetitors().size()-1),sumArray(competition.getWins()));
    }

}