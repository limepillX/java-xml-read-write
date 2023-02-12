import java.util.ArrayList;

//Паттерн фабрика https://javarush.ru/groups/posts/2370-pattern-proektirovanija-factory

enum Stores {
    Music,
    Melody,
    MusicWorld
}

public class InstrumentFabric {
    public ArrayList<Instrument> create(Stores i){
        ArrayList<Instrument> instruments = new ArrayList<>();

        switch (i){
            case Music -> {
                Instrument fenderStratocaster = new Instrument("Струнные", "Гитара", "Fender", "Stratocaster");
                // Паттерн прототип https://refactoring.guru/ru/design-patterns/prototype
                Instrument fenderClone = fenderStratocaster.clone();

                instruments.add(fenderClone);
                instruments.add(new Instrument("Духовые", "Блок-флейта", "Yamaha", "Yamaha YAS-280"));
                instruments.add(new Instrument("Клавишные", "Пианино", "Беларусь", "Беларусь-1"));
            }
            case Melody -> {
                instruments.add(new Instrument("Духовые", "Труба", "Fender", "YTR-4335Gll"));
                instruments.add(new Instrument("Духовые", "Труба", "Yamaha", "AD810 OP"));
                instruments.add(new Instrument("Струнные", "Классическая гитара", "Hohner", "B95084DB"));
            }
            case MusicWorld -> {
                instruments.add(new Instrument("Клавишные", "Синтезатор", "Casio", "Casiotone CT-S100 Black"));
                instruments.add(new Instrument("Струнные", "Акустическая гитара", "Cort", "Yamaha P-45B"));
                instruments.add(new Instrument("Духовые", "Саксофон", "Stagg", "C440M NAT"));
            }
        }


        return instruments;
    }
}
