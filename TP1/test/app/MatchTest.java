package app;
import static org.junit.Assert.*;

import src.app.Competitor;
import src.app.Match;

class MatchTest {

    @Before
    public void initialize(){
        c1 = new Competitor("Jhon");
        c2 = new Competitor("Doe",5);
    }

    @Test
    public void getCompetitorTest () {
        Match match = new Match(c1,c2);
        assertTrue(match.getCompetitor1().getName()==c1.getName());
        assertTrue(match.getCompetitor2().getName()==c2.getName());
    }


    @Test 
    public void playTest () {
        Match match = new Match(c1,c2);
        assertTrue(match.play()==1||0);
    }
}