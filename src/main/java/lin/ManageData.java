package lin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ManageData {

	public List<Programmer> readFile() {
		ArrayList<Programmer> programmers = new ArrayList<Programmer>();
        SAXBuilder builder = new SAXBuilder();
        Document doc = null;
        
        Map<String,Programmer> index=new HashMap<String,Programmer>();
        
		try {
			doc = builder.build(new FileInputStream("ProNet.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

        Element arrel = doc.getRootElement();
        List<Element> elements = (List<Element>) arrel.getChildren("Programmer");
        
        // First step: create programmers list and index
        for (Element programmerElement:elements) {
        	String name = programmerElement.getAttributeValue("name");
        	Programmer p = new Programmer(name);
        	programmers.add(p);
        	index.put(name,p);
        }        	
        
        // Second step: add recommendations between already existing Programmer objects
        for (Element programmerElement:elements) {
        	String name = programmerElement.getAttributeValue("name");
        	Element recommendations = programmerElement.getChild("Recommendations");
        	List<Element> recs = (List<Element>) recommendations.getChildren("Recommendation");
            Iterator<Element> it2 = recs.iterator();
            while (it2.hasNext()) {
            	String rName = it2.next().getText();
            	Programmer p1=index.get(name);
            	Programmer p2=index.get(rName);
            	p1.addRecomendation(p2);
            }            
        }

		return programmers;
	}

}
