package app;

import static org.junit.jupiter.api.Assertions.*;

import app.Competitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompetitorTest {
    
    private Competitor c1;
    private Competitor c2;


    @BeforeEach
    public void initialize(){
        c1 = new Competitor("Jhon");
        c2 = new Competitor("Doe",5);
    }


    @Test
    public void getNameTest(){
        assertSame("Jhon", c1.getName());
    }

    @Test
    public void setNameTest() {
        c1.setName("Paul");
        assertSame("Paul", c1.getName());
    }

    @Test
    public void getStrengthTest(){
        assertEquals(c1.getStrength(), 1);
        assertEquals(c2.getStrength(), 5);
    }

    @Test
    public void setStrengthTest() {
        c1.setStrength(3);
        assertEquals(c1.getStrength(), 3);
    }

}