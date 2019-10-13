package thomas.iommi.changex2m.converter;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.fusesource.jansi.AnsiConsole;
import thomas.iommi.changex2m.models.Changes;
import thomas.iommi.changex2m.utils.MdWriter;
import thomas.iommi.changex2m.utils.NameSpaceCleaner;

import java.io.File;
import java.io.FileWriter;

import static org.fusesource.jansi.Ansi.ansi;

public class ChangeX2M {

	public static void main(String[] args) throws Exception {

		AnsiConsole.systemInstall();

		System.out.println("\nChecking configuration...");
		String inputFilePath = args.length > 0 ? args[0] : "./changes.xml";
		String outputFilePath = args.length > 1 ? args[1] : "./CHANGELOG.md";
		File inputFile = new File(inputFilePath);
		if (!inputFile.exists() || !inputFile.isFile()) {
			printErrorAndUsage("Input changes.xml file doesn't exist or isn't readable");
			System.exit(1);
		}

		System.out.println("Conversion process started!");

		System.out.println("Parsing changes.xml file...");
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputFile);
		document.accept(new NameSpaceCleaner());

		System.out.println("File analysis...");
		Changes changes = new Changes(document);

		System.out.println("Creating markdown...");
		String mdOutput  = MdWriter.writeMarkDown(changes);

		System.out.println("Writing CHANGELOG.md file...");
		FileWriter writer = new FileWriter(outputFilePath);
		writer.write(mdOutput);
		writer.close();

		System.out.println("All done!\n");
		System.exit(0);
	}

	private static void printErrorAndUsage(String error) {
		System.out.println(ansi().fgRed().a(error));
		System.out.println(ansi().fgBrightBlue().a("\nUSAGE: changex2m [changes.xml input path] " +
				"[CHANGELOG.md output path]"));
		System.out.println(ansi().fgYellow().a("in case input or output path are not specified, " +
				"./changes.xml and ./CHANGELOG.md will be used respectively\n"));
	}
}
