import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.ArrayList;

public class SAXHandler extends DefaultHandler {
    private StringBuilder text = new StringBuilder();
    private String name;
    private MusicStore store;

    ArrayList<MusicStore> musicStores = new ArrayList<>();

    DefaultHandler handler = new DefaultHandler() {

        public void startElement(String u, String m, String n, Attributes a) {
            if ("store".equals(n)) {
                if (store != null) musicStores.add(store);
                name = a.getValue("name");
                store = new MusicStore(name);
            }
            if ("instrument".equals(n)) {
                Instrument newinst = new Instrument(a.getValue("class"),a.getValue("type"), a.getValue("firm"), a.getValue("name"));
                store.add_instrum(newinst);
            }
        }

        public void endDocument(){
            musicStores.add(store);
        }
    };

    public void print(){
        for(MusicStore store : musicStores){
            store.print();
        }
    }
}
