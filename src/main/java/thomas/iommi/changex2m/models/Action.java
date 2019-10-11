package thomas.iommi.changex2m.models;

import org.dom4j.Element;

public class Action {

	private String sviluppatore;
	private ActionType tipo;
	private String data;
	private String testo;

	public Action(Element actionElement) {
		this.sviluppatore = actionElement.attributeValue("dev");
		this.tipo = ActionType.fromString(actionElement.attributeValue("type"));
		this.data = actionElement.attributeValue("data");
		this.testo = actionElement.getText().trim().replaceAll("\n+\t+", "\n  ");
	}

	public String getSviluppatore() {
		return sviluppatore;
	}

	public ActionType getTipo() {
		return tipo;
	}

	public String getData() {
		return data;
	}

	public String getTesto() {
		return testo;
	}
}
