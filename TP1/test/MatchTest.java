import org.junit.Test;
import app.Match;
import app.Competitor;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



public class MatchTest {
	
	private Competitor c1;
	private Competitor c2;


    /* méthode exécutée avant l'exécution de chacune des méthodes de test*/
	@Before 
	public void before() {
	    // réinitialisation des attributs c1 et c2 pour chacun des tests
		this.c1 = new Competitor("John");
		this.c2 = new Competitor("Doe");
	}

	@Test
	public void testNewMatchEqualStrength() {
		Match match = new Match(c1,c2);
		match.play();
		/* Trouver un assert pour un résultat aléatoire */
	}

	// ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(MatchTest.class);
	}

}
