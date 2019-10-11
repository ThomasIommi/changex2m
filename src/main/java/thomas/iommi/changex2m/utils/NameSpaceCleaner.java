package thomas.iommi.changex2m.utils;

import org.dom4j.*;
import org.dom4j.tree.DefaultElement;

public class NameSpaceCleaner extends VisitorSupport {

	public void visit(Document document) {
		((DefaultElement) document.getRootElement()).setNamespace(Namespace.NO_NAMESPACE);
		document.getRootElement().additionalNamespaces().clear();
	}

	public void visit(Namespace namespace) {
		namespace.detach();
	}

	public void visit(Attribute node) {
		if (node.toString().contains("xmlns") || node.toString().contains("xsi:")) {
			node.detach();
		}
	}

	public void visit(Element node) {
		if (node instanceof DefaultElement) {
			((DefaultElement) node).setNamespace(Namespace.NO_NAMESPACE);
		}
	}
}
