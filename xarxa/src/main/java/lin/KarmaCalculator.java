package lin;

import java.util.List;

public class KarmaCalculator {
	
	float d=0.85f;	
	List<Programmer> programmers;
	
	public KarmaCalculator(List<Programmer> programmers) {
		this.programmers=programmers;
	}
	
	public void calculateKarma() {
		initialize();
		step();
	}
	
	public void initialize() {
		for (Programmer p: programmers) p.setKarma(1);
	}
	
	public void step() {
		for (Programmer p: programmers) {
			float karma=0f;
			for (Programmer r: p.getRecommendedBy()) {
				karma+=r.getKarma()/r.getRecommends().size();
			}
			p.setKarma((1-d)+d*karma);
		}		
	}


}
