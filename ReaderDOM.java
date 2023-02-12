import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import java.util.ArrayList;


public class ReaderDOM {
    String path;
    ArrayList<MusicStore> musicStores = new ArrayList<>();

    public ReaderDOM(String path) {
        this.path = path;
        read();
    }

    private void read() {
        try {

            File fXmlFile = new File(this.path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            NodeList stores = doc.getElementsByTagName("store");

            for (int i = 0; i < stores.getLength(); i++) {

                Element store = (Element) stores.item(i);
                String name = store.getAttribute("name");
                MusicStore newStore = new MusicStore(name);

                NodeList instruments = store.getElementsByTagName("instrument");
                for (int j = 0; j < instruments.getLength(); j++) {

                    Node instrument = instruments.item(j);
                    NamedNodeMap attributes = instrument.getAttributes();

                    Instrument newinst = new Instrument(attributes.getNamedItem("class").getNodeValue(), attributes.getNamedItem("type").getNodeValue(), attributes.getNamedItem("firm").getNodeValue(), attributes.getNamedItem("name").getNodeValue());
                    newStore.add_instrum(newinst);
                }
                musicStores.add(newStore);
            }

            System.out.println("Успешно прочитали файл!");
        } catch (Exception e) {
            System.out.println("[Ошибка!] " + e.getMessage());
        }
    }

    public void print(){
        for(MusicStore store : musicStores){
            store.print();
        }
    }


}
