package thomas.iommi.changex2m.models;

import org.dom4j.Element;

public class Action {

	private String sviluppatore;
	private String tipo;
	private String data;
	private String testo;

	Action(Element actionElement) {
		this.sviluppatore = actionElement.attributeValue("dev");
		this.tipo = actionElement.attributeValue("type");
		this.data = actionElement.attributeValue("data");
		this.testo = actionElement.getText().trim();
	}

	public String getSviluppatore() {
		return sviluppatore;
	}

	public String getTipo() {
		return tipo;
	}

	public String getData() {
		return data;
	}

	public String getTesto() {
		return testo;
	}
}
