package lin;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	
	public static void main (String[] args) {
		
		List<Programmer> programmers= new ArrayList<Programmer>();
		Programmer jaume=new Programmer("Jaume");
		programmers.add(jaume);
		Programmer isaac=new Programmer("Isaac");
		programmers.add(isaac);
		Programmer cristian=new Programmer("Cristian");
		programmers.add(cristian);
		Programmer david=new Programmer("David");
		programmers.add(david);
		Programmer jonathan=new Programmer("Jonathan");
		programmers.add(jonathan);
		Programmer ignasi=new Programmer("Ignasi");
		programmers.add(ignasi);
		
		jaume.addRecomendation(cristian);
		jaume.addRecomendation(isaac);
		isaac.addRecomendation(david);
		isaac.addRecomendation(jonathan);
		cristian.addRecomendation(jonathan);
		david.addRecomendation(jonathan);
		david.addRecomendation(ignasi);
		jonathan.addRecomendation(ignasi);
		
		for (Programmer p: programmers) {
			System.out.println(p.getName()+" Karma:"+p.getKarma());
		}
	}
	
}
