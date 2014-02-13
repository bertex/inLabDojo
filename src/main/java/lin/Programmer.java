package lin;

import java.util.ArrayList;
import java.util.List;

public class Programmer {
	
	List<Programmer> recommends=new ArrayList<Programmer>();
	List<Programmer> recommendedBy=new ArrayList<Programmer>();
	float karma=1;
	float prevKarma=1;
	String name;
	
	public Programmer () {
		this.name="Anonymous";
	}	
	
	public Programmer (String name) {
		this.name=name;
	}
	
	public void setName (String name) {		
		this.name=name;
	}	
	
	public List<Programmer> getRecommends() {
		return recommends;
	}
	
	public float getKarma() {
		return karma;
	}

	public void addRecomendation(Programmer p2) {
		recommends.add(p2);		
		p2.addRecommendedBy(this);
	}

	private void addRecommendedBy(Programmer p2) {
		recommendedBy.add(p2);		
	}

	public String getName() {
		return name;
	}

	public void setKarma(float karma) {
		this.prevKarma=this.karma;
		this.karma=karma;		
	}
	
	public void setPrevKarma(float prevKarma) {
		this.prevKarma=prevKarma;		
	}
	
	public float getPrevKarma() {
		return prevKarma;		
	}	

	public List<Programmer> getRecommendedBy() {		
		return recommendedBy;
	}
	
	public String toString() {
		StringBuilder result=new StringBuilder();
		result.append("Nom: "+name+"\nRecomends:");
		for (Programmer p:getRecommends()) result.append(" "+p.getName());
		result.append("\nRecomended by:");
		for (Programmer p:getRecommendedBy()) result.append(" "+p.getName());
		result.append("\n");
		return result.toString();
	}
	
}
