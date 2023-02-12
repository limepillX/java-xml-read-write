import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;


public class Writer {

    // Выставляем атрибуты для корневого элемента
    public void setAttributes(Element rootElement){
        rootElement.setAttribute("category", "WEB");
        rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        rootElement.setAttribute("xsi:noNamespaceSchemaLocation", "musicstore.xsd");
    }

    // Создаём инструменты при помощи "Фабрики"
    public void createInstruments(Document doc, Element store, Stores type) {

        //Паттерн фабрика https://javarush.ru/groups/posts/2370-pattern-proektirovanija-factory
        InstrumentFabric fabric = new InstrumentFabric();
        ArrayList<Instrument> instruments = fabric.create(type);

        for (Instrument single_instrument : instruments){
            Element instrument = doc.createElement("instrument");
            instrument.setAttribute("class", single_instrument.m_class);
            instrument.setAttribute("type", single_instrument.type);
            instrument.setAttribute("firm", single_instrument.firm);
            instrument.setAttribute("name", single_instrument.name);
            store.appendChild(instrument);
        }

    }

    // Создаём магазины
    public Element createStore(Document doc, Element rootElement, String name){
        Element store = doc.createElement("store");
        store.setAttribute("name", name);
        rootElement.appendChild(store);
        return store;
    }


    public void create(String name) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Создаём документ
            Document doc = docBuilder.newDocument();



            //Создаём основной элемент
            Element rootElement = doc.createElement("musictores");
            setAttributes(rootElement);
            doc.appendChild(rootElement);

            Element title =  doc.createElement("title");
            title.setAttribute("lang", "ru");
            title.setTextContent("Магазин музыкальных инструментов");
            rootElement.appendChild(title);

            //Создаём дочерние элементы, магазины
            Element store = createStore(doc, rootElement, "Музыка");
            createInstruments(doc, store, Stores.Music);

            store = createStore(doc, rootElement, "Мелодия");
            createInstruments(doc, store, Stores.Melody);

            store = createStore(doc, rootElement, "Мир музыки");
            createInstruments(doc, store, Stores.MusicWorld);

            //Записываем то, что у нас получилось в xml файл
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File("C:\\Users\\justacold\\IdeaProjects\\SITAIRIS3\\" + name));
            transformer.transform(source, result);

            System.out.println("Done");
        } catch (Exception e) {
            System.out.println("[Ошибка!] " + e.getMessage());
        }
    }
}
