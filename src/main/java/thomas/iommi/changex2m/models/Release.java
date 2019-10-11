package thomas.iommi.changex2m.models;

import org.dom4j.Element;
import org.dom4j.Node;

import java.util.ArrayList;
import java.util.List;

public class Release {

	private String version;
	private String date;
	private List<Action> actions;

	public Release(Element releaseElement) {
		this.version = releaseElement.attributeValue("version", "n/d");
		this.date = releaseElement.attributeValue("date", "n/d");
		this.actions = new ArrayList<>();
		for (Node actionNode : releaseElement.selectNodes("action")) {
			this.actions.add(new Action((Element) actionNode));
		}
	}

	public String getVersion() {
		return version;
	}

	public String getDate() {
		return date;
	}

	public List<Action> getActions() {
		return actions;
	}
}
