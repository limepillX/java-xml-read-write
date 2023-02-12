import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;

public class ReaderSAX {

    public static void read(String path) {
        try {
            File fXmlFile = new File(path);
            SAXHandler handler = new SAXHandler();

            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            SAXParser parser = factory.newSAXParser();
            parser.parse(fXmlFile, handler.handler);
            handler.print();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
