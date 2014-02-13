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
        	Programmer p = new Programmer();
        	Element programmerElement = (Element)it.next();
        	p.setName(programmerElement.getAttributeValue("name"));
            programmers.add(p);
        }

		return programmers;
	}

}
