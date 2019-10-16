# changex2m

Parses your Maven [changes.xml](https://maven.apache.org/plugins/maven-changes-plugin/changes.html) file and write the corresponding [CHANGELOG.md](https://keepachangelog.com/en/0.3.0/).

## Prerequisites

* Java 11+
* Maven 3.6.0+

## Installing / Compiling

`mvn clean install` on the project root folder.

## Running 

The previous command will generate a jar named _changex2m.jar_.

Usage:
`java -jar changex2m.jar [changes.xml input path] [CHANGELOG.md output path]`

In case input or output path are not specified, _./changes.xml_ and _./CHANGELOG.md_ will be used respectively

## Running the tests

TODO

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [dom4j](https://dom4j.github.io) - The Java XML parser
* [jaxen](http://www.cafeconleche.org/jaxen/) - The Java XPath engine
* [markdowngenerator](https://github.com/Steppschuh/Java-Markdown-Generator) - The Java MarkDown generator
* [jansi](https://github.com/fusesource/jansi) - Java lib to use ANSI escape codes to format console

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/ThomasIommi/changex2m/tags). 

## Authors

* **Thomas Iommi** - *Initial work* - [GitHub](https://github.com/ThomasIommi)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

