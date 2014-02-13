package lin;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalculateKarma {

	@Test
	public void test() {
		Programmer p1=new Programmer();
		Programmer p2=new Programmer();
		p1.addRecomendation(p2);
		System.out.println("parella");
		System.out.println(p1.getKarma());
		System.out.println(p2.getKarma());				
	}
	
	@Test
	public void testForeverAlone() {
		System.out.println("sol");
		Programmer p1=new Programmer();
		System.out.println(p1.getKarma());				
	}	
	
	@Test
	public void testCycle() {
		Programmer p1=new Programmer();
		Programmer p2=new Programmer();
		p1.addRecomendation(p2);
		p2.addRecomendation(p1);
		System.out.println(p2.getKarma());				
	}	

}
