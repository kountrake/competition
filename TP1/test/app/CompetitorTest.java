package app;
import static org.junit.Assert.*;

import src.app.Competitor;

class CompetitorTest {
    
    private Competitor c1;
    private Competitor c2;


    @Before
    public void initialize(){
        c1 = new Competitor("Jhon");
        c2 = new Competitor("Doe",5);
    }


    @Test
    public void getNameTest(){
        assertTrue(c1.getName == "Jhon");
    }

    @Test
    public void setNameTest() {
        c1.setName("Paul");
        assertTrue(c1.getName == "Paul");
    }

    @Test
    public void getStrengthTest(){
        assertTrue(c1.getStrength == 1);
        assertTrue(c2.getStrength == 5);
    }

    @Test
    public void setStrengthTest() {
        c1.setStrength(3);
        assertTrue(c1.getStrength == 3);
    }

}