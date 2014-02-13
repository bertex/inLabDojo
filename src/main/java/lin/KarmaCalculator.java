package lin;

import java.util.List;

public class KarmaCalculator {
	
	float d=0.85f;	
	float maxDeltaKarma=0;
	List<Programmer> programmers;
	
	public KarmaCalculator(List<Programmer> programmers) {
		this.programmers=programmers;
	}
	
	public void calculateKarma() {
		/*initialize();*/
		maxDeltaKarma=1;
		while (maxDeltaKarma>0.001) {			
			maxDeltaKarma=0;
			step();
			for (Programmer p: programmers) {
				System.out.println(p.getName()+" Karma:"+p.getKarma()+"("+p.getPrevKarma()+")");
			}
			System.out.println("---");
		}
	}
	
	public void initialize() {
		for (Programmer p: programmers) p.setKarma(1);
	}
	
	public void step() {		
		for (Programmer p: programmers) {
			float karma=0f;
			for (Programmer r: p.getRecommendedBy()) {
				karma+=r.getPrevKarma()/r.getRecommends().size();
			}			
			p.setKarma((1-d)+d*karma); 
			float deltaKarma=Math.abs(p.getKarma()-p.getPrevKarma());
			if (deltaKarma>maxDeltaKarma) maxDeltaKarma=deltaKarma;
		}		
	}


}
