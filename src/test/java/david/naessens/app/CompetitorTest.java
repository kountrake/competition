package david.naessens.app;

import static org.junit.jupiter.api.Assertions.*;

import david.naessens.app.Competitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompetitorTest {
    
    private Competitor c1;
    private Competitor c2;


    @BeforeEach
    void initialize(){
        c1 = new Competitor("Jhon");
        c2 = new Competitor("Doe",5);
    }

    @Test
    void setNameTest() {
        assertEquals("Jhon", c1.getName());
        c1.setName("Paul");
        assertSame("Paul", c1.getName());
    }

    @Test
    void setStrengthTest() {
        assertEquals(5, c2.getStrength());
        c2.setStrength(3);
        assertEquals(3, c2.getStrength());
    }

    @Test
    void setWinsTest(){
        assertEquals(0, c1.getWins());
        c1.increaseWins();
        assertEquals(1, c1.getWins());
    }

}