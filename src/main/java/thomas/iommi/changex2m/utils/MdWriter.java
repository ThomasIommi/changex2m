package thomas.iommi.changex2m.utils;

import net.steppschuh.markdowngenerator.MarkdownElement;
import net.steppschuh.markdowngenerator.list.UnorderedList;
import net.steppschuh.markdowngenerator.list.UnorderedListItem;
import net.steppschuh.markdowngenerator.text.heading.Heading;
import thomas.iommi.changex2m.models.Action;
import thomas.iommi.changex2m.models.Changes;
import thomas.iommi.changex2m.models.MarkDownBuilder;
import thomas.iommi.changex2m.models.Release;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MdWriter {

    public static String writeMarkDown(Changes changes) throws IOException {

        MarkDownBuilder mdBuilder = new MarkDownBuilder();
        // title
        mdBuilder.addPart(new Heading("Change Log - " + changes.getAppName(), 1));

        // releases
        for (Release release : changes.getRilasci()) {
            mdBuilder.addPart(new Heading("["+release.getVersione()+"] - "+release.getData(), 2));

            // sort by type
            release.getAzioni().sort(Comparator.comparing(Action::getTipo));

            // actions
            UnorderedList<UnorderedListItem> added = new UnorderedList<>(new ArrayList<>());
            UnorderedList<UnorderedListItem> fixed = new UnorderedList<>(new ArrayList<>());
            UnorderedList<UnorderedListItem> updated = new UnorderedList<>(new ArrayList<>());
            UnorderedList<UnorderedListItem> removed = new UnorderedList<>(new ArrayList<>());
            for (Action action : release.getAzioni()) {
                switch (action.getTipo()) {
                    case ADD:
                        added.getItems().add(new UnorderedListItem(action.getTesto()));
                        break;
                    case FIX:
                        fixed.getItems().add(new UnorderedListItem(action.getTesto()));
                        break;
                    case UPDATE:
                        updated.getItems().add(new UnorderedListItem(action.getTesto()));
                        break;
                    case REMOVE:
                        removed.getItems().add(new UnorderedListItem(action.getTesto()));
                        break;
                }
            }
            if (!added.getItems().isEmpty()) {
                mdBuilder.addPart(new Heading("Added", 3));
                mdBuilder.addPart(added);
            }
            if (!fixed.getItems().isEmpty()) {
                mdBuilder.addPart(new Heading("Fixed", 3));
                mdBuilder.addPart(fixed);
            }
            if (!updated.getItems().isEmpty()) {
                mdBuilder.addPart(new Heading("Updated", 3));
                mdBuilder.addPart(updated);
            }
            if (!removed.getItems().isEmpty()) {
                mdBuilder.addPart(new Heading("Removed", 3));
                mdBuilder.addPart(removed);
            }
        }

        File output = new File("/home/thomas/Projects/Java/changex2m/src/main/resources/CHANGELOG.md");
        if (!output.exists()) {
            output.createNewFile();
        }

        return mdBuilder.toString();
    }

    private static void addPart(StringBuilder mdResult, MarkdownElement markdownElement) {
        mdResult.append(markdownElement).append("/n");
    }

}


