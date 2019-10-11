package thomas.iommi.changex2m.models;

import org.dom4j.Element;

public class Action {

	private String developer;
	private ActionType type;
	private String date;
	private String text;

	public Action(Element actionElement) {
		this.developer = actionElement.attributeValue("dev");
		this.type = ActionType.fromString(actionElement.attributeValue("type"));
		this.date = actionElement.attributeValue("data");
		this.text = actionElement.getText().trim()
				.replaceAll("\n+\\s+", "\n  ")
				.replaceAll("(\n+\\s*)\\(\\*\\)", "$1\\*");
	}

	public String getDeveloper() {
		return developer;
	}

	public ActionType getType() {
		return type;
	}

	public String getDate() {
		return date;
	}

	public String getText() {
		return text;
	}
}
