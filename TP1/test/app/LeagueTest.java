package app;


import org.junit.jupiter.api.BeforeEach;

class LeagueTest {

    Competitor c1;
    Competitor c2;
    Competitor c3;
    Competitor c4;

    @BeforeEach
    void initialize(){
        c1 = new Competitor("Jhon");
        c2 = new Competitor("Doe",5);
        c3 = new Competitor("Timo",2);
        c4 = new Competitor("Leon",7);
    }

}