package app;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.MathUtil.fact;
import static util.MathUtil.sumArray;

class LeagueTest {

    Competitor c1;
    Competitor c2;
    Competitor c3;
    Competitor c4;
    League competition;


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
        competition = new League(competitors);
        competition.play();
    }

    @Test
    void mostWinTest() {

    }

    @Test
    void playTest() {
        HashMap<Competitor, Integer> ranks = competition.getRanks();
        int wins = sumArray(ranks.values());
        System.out.format("%d \n", wins);
        assertEquals(wins, (fact((competition.getCompetitors().size()) - 1)) * 2);
    }

}