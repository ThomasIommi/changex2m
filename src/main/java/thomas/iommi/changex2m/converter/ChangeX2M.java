package thomas.iommi.changex2m.converter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import thomas.iommi.changex2m.models.Changes;
import thomas.iommi.changex2m.utils.MdWriter;
import thomas.iommi.changex2m.utils.NameSpaceCleaner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ChangeX2M {

	public static void main(String[] args) throws DocumentException, IOException {

		System.out.println("\nConversion process started!");

		System.out.println("Reading changes.xml file...");
		File inputFile = new File("/home/thomas/Projects/Java/changex2m/src/main/resources/changes.xml");

		System.out.println("SAX parsing...");
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputFile);
		document.accept(new NameSpaceCleaner());

		System.out.println("File analysis...");
		Changes changes = new Changes(document);

		System.out.println("Creating markdown...");
		String mdOutput  = MdWriter.writeMarkDown(changes);

		System.out.println("Writing file...");
		FileWriter writer = new FileWriter("/home/thomas/Projects/Java/changex2m/src/main/resources/CHANGELOG.md");
		writer.write(mdOutput);
		writer.close();

		System.out.println("All done!");
		System.exit(0);
	}
}
