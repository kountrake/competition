package app;

import static org.junit.jupiter.api.Assertions.*;

import app.Competitor;
import app.Match;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatchTest {

    Competitor c1;
    Competitor c2;

    @BeforeEach
    void initialize(){
        c1 = new Competitor("Jhon");
        c2 = new Competitor("Doe",5);
    }

    @Test
    public void getCompetitorTest () {
        Match match = new Match(c1,c2);
        assertEquals(c1.getName(), match.getCompetitor1().getName());
        assertEquals(c2.getName(), match.getCompetitor2().getName());
    }


    @Test 
    public void playTest () {
        Match match = new Match(c1,c2);
        assertTrue(match.play()==1||match.play()==0);
    }
}