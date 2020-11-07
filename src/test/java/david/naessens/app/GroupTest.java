package david.naessens.app;

import david.naessens.util.CompetitorsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupTest {

    private Group group;

    @BeforeEach
    void setup() {
        group = new Group();
    }

    @Test
    void addCompetitorTest() {
        Competitor competitor = new Competitor("Jean", 2);
        assertEquals(0, group.getCompetitors().size());
        group.addCompetitor(competitor);
        assertEquals(1, group.getCompetitors().size());
    }

    @Test
    void addCompetitorsTest() {
        ArrayList<Competitor> competitors = CompetitorsGenerator.generateCompetitors(10);
        assertEquals(0, group.getCompetitors().size());
        group.addCompetitors(competitors);
        assertEquals(10, group.getCompetitors().size());
    }

    @Test
    void orderByVictoriesTest() {
        Competitor competitor1 = new Competitor("Jean", 2);
        Competitor competitor2 = new Competitor("Claude", 2);
        Competitor competitor3 = new Competitor("Martin", 2);
        competitor1.increaseWins();
        competitor1.increaseWins();
        competitor1.increaseWins();
        competitor1.increaseWins(); // 4 wins for competitor1
        competitor3.increaseWins();
        competitor3.increaseWins();
        competitor3.increaseWins(); // 3 wins for competitor3
        competitor2.increaseWins(); // 1 win for competitor2
        group.addCompetitor(competitor1);
        group.addCompetitor(competitor2);
        group.addCompetitor(competitor3);
        ArrayList<Competitor> competitors = group.orderByVictories();
        assertEquals("Jean", competitors.get(0).getName());
        assertEquals("Martin", competitors.get(1).getName());
        assertEquals("Claude", competitors.get(2).getName());
    }
}
