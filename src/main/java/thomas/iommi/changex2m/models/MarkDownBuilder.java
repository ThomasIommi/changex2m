package thomas.iommi.changex2m.models;

import net.steppschuh.markdowngenerator.MarkdownElement;

public class MarkDownBuilder {

    private StringBuilder stringBuilder = new StringBuilder();

    public MarkDownBuilder() {}

    public void addPart(MarkdownElement mdElement) {
        this.stringBuilder.append(mdElement).append("\n\n");
    }

    public void addEmptyLine() {
        this.stringBuilder.append("\n");
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

}
