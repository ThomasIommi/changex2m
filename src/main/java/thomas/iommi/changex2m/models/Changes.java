package thomas.iommi.changex2m.models;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import java.util.ArrayList;
import java.util.List;

public class Changes {

	private String appName;
	private List<Release> rilasci = new ArrayList<>();

	public Changes(Document changesXML) {
		try {
			this.appName = changesXML.selectSingleNode("/document/properties/title").getText();
		} catch (Exception ex) {
			System.err.println("Error during the parsing of the application name!");
		}
		for (Node releaseNode : changesXML.selectNodes("/document/body/release")) {
			this.rilasci.add(new Release((Element) releaseNode));
		}
	}

	public String getAppName() {
		return appName;
	}

	public List<Release> getRilasci() {
		return rilasci;
	}

}
