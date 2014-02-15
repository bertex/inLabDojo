package lin;

import java.util.ArrayList;
import java.util.List;

public class DemoFile {
	
	public static void main (String[] args) {
		
		ManageData manageData=new ManageData();
		List<Programmer> programmers=manageData.readFile();

		for (Programmer p: programmers) {
			System.out.println(p.toString());
		}
		
		KarmaCalculator karmaCalculator=new KarmaCalculator(programmers);
		karmaCalculator.calculateKarma();		
				
		float totalKarma=0;
		for (Programmer p: programmers) {
			System.out.println(p.getName()+" Karma:"+p.getKarma());
			totalKarma+=p.getKarma();
		}
		System.out.println(totalKarma);
	}
	
}
