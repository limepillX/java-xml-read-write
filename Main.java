import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner i_reader = new Scanner(System.in);
        System.out.println("\t1 - Прочитать файл, 2 - создать файл, 3 - создать и прочитать: ");
        int n = i_reader.nextInt();

        switch (n) {
            case 1 -> {

                System.out.println("\t1 - DOM, 2 - SAX");
                i_reader = new Scanner(System.in);
                int x = i_reader.nextInt();

                System.out.println("\tИмя файла:");
                i_reader = new Scanner(System.in);
                String name = i_reader.nextLine() + ".xml";

                switch (x) {
                    case 1 -> {
                        ReaderDOM readerDOM = new ReaderDOM(name);
                        readerDOM.print();
                    }
                    case 2 -> {
                        ReaderSAX.read(name);
                    }
                }
                i_reader.close();

            }
            case 2 -> {
                System.out.println("\tИмя файла:");
                i_reader = new Scanner(System.in);
                String name = i_reader.nextLine() + ".xml";
                i_reader.close();

                new Writer().create(name);
            }
            case 3 -> {

                System.out.println("\tИмя файла");
                i_reader = new Scanner(System.in);
                String name = i_reader.nextLine() + ".xml";

                System.out.println("\t1 - DOM, 2 - SAX");
                i_reader = new Scanner(System.in);
                int x = i_reader.nextInt();
                i_reader.close();

                new Writer().create(name);

                switch (x) {
                    case 1 -> {
                        ReaderDOM readerDOM = new ReaderDOM(name);
                        readerDOM.print();
                    }
                    case 2 -> {
                        ReaderSAX.read(name);
                    }
                }
            }
            default -> {
                System.out.println("Введено неверное значение");
            }
        }


    }
}
