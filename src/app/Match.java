package app;

public class Match {
	private Competitor competitor1;
	private Competitor competitor2;
	
	public Match( Competitor c1, Competitor c2) {
		competitor1 = c1;
		competitor2 =c2;
	}
	
	public Competitor getCompetitor1() {
		return competitor1;
	}
	public Competitor getCompetitor2() {
		return competitor2;
	}
	
	
	
}
