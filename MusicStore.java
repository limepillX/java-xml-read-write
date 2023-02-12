import java.util.ArrayList;

public class MusicStore {
    String name;
    public ArrayList<Instrument> instruments = new ArrayList<>();

    public MusicStore(String name) {
        this.name = name;
    }

    public void add_instrum(Instrument inst){

        instruments.add(inst);
    }

    public void print(){
        System.out.println("\n Магазин " + this.name);

        for (Instrument inst : instruments){
            inst.print();
        }

    }


}