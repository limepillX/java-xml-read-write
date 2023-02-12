public class Instrument implements Clonable {
    String m_class;
    String type;
    String firm;
    String name;
    public void print() {
        System.out.println("["+this.m_class+"] " + this.type + ' ' + this.firm + ' ' + this.name);
    }

    public Instrument(String m_class, String type, String firm, String name) {
        this.m_class = m_class;
        this.type = type;
        this.firm = firm;
        this.name = name;
    }

    public Instrument(Instrument i){
        this.m_class = i.m_class;
        this.type = i.type;
        this.firm = i.firm;
        this.name = i.name;
    }

    // Паттерн прототип https://refactoring.guru/ru/design-patterns/prototype
    @Override
    public Instrument clone() {
        return new Instrument(this);
    }
}
