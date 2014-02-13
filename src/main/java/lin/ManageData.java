package lin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ManageData {

	public List<Programmer> readFile() {
		ArrayList<Programmer> programmers = new ArrayList<Programmer>();
        SAXBuilder builder = new SAXBuilder();
        Document doc = null;
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
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
        	//Getting name
        	Element programmerElement = (Element)it.next();
        	String name = programmerElement.getAttributeValue("name");
        	Programmer p = new Programmer(name);
        	
        	//Getting Recommendations
        	Element recommendations = programmerElement.getChild("Recommendations");
        	List<Element> recs = (List<Element>) recommendations.getChildren("Recommendation");
            Iterator<Element> it2 = recs.iterator();
            while (it2.hasNext()) {
            	String rName = it2.next().getText();
            	p.addRecomendation(new Programmer(rName));
            }
            
            //Add programmer to list
        	programmers.add(p);
        }

		return programmers;
	}

}
