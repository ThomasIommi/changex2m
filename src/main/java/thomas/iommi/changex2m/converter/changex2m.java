package thomas.iommi.changex2m.converter;

import net.steppschuh.markdowngenerator.text.heading.Heading;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import thomas.iommi.changex2m.models.Release;
import thomas.iommi.changex2m.utils.NameSpaceCleaner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class changex2m {

	public static void main(String[] args) throws DocumentException, IOException {

		System.out.println("Conversion started!");

		System.out.println("Parsing...");
		File inputFile = new File("/home/tiommi/Progetti/ChangesConverter/changex2m/src/main/resources/changes.xml");

		SAXReader reader = new SAXReader();
		Document document = reader.read(inputFile);
		document.accept(new NameSpaceCleaner());

		String applicationName = "";
		try {
			applicationName = document.getRootElement().selectSingleNode("/document/properties/title").getText();
		} catch (Exception ex) {
			System.out.println("Impossible to parse application name!");
		}

		List<Node> releaseNodes = document.selectNodes("/document/body/release");
		List<Release> releases = new ArrayList<>();
		for (Node releaseNode : releaseNodes) {
			releases.add(new Release((Element) releaseNode));
		}

		System.out.println("Creating CHANGELOG.md...");

		StringBuilder mdResult = new StringBuilder();
		mdResult.append(new Heading("Change Log - " + applicationName, 1)).append("\n");

		for (Release release : releases) {
			mdResult.append(new Heading("["+release.getVersione()+"] - "+release.getData(), 2)).append("\n");
		}

		File output = new File("/home/tiommi/Progetti/ChangesConverter/changex2m/src/main/resources/CHANGELOG.md");
		if (!output.exists()) {
			output.createNewFile();
		}

		FileWriter writer = new FileWriter(output);
		writer.write(mdResult.toString());
		writer.close();
	}
}
