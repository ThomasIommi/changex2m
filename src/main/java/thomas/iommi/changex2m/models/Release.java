package thomas.iommi.changex2m.models;

import org.dom4j.Element;
import org.dom4j.Node;

import java.util.ArrayList;
import java.util.List;

public class Release {

	private String versione;
	private String data;
	private List<Action> azioni;

	public Release(Element releaseElement) {
		this.versione = releaseElement.attributeValue("version", "n/d");
		this.data = releaseElement.attributeValue("date", "n/d");
		this.azioni = new ArrayList<>();
		for (Node actionNode : releaseElement.selectNodes("action")) {
			this.azioni.add(new Action((Element) actionNode));
		}
	}

	public String getVersione() {
		return versione;
	}

	public String getData() {
		return data;
	}

	public List<Action> getAzioni() {
		return azioni;
	}
}
