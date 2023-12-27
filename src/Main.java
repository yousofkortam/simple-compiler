import java.util.Scanner;

public class Main {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            int choice;
            System.out.println("1- Push Down Machine .");
            System.out.println("2- Lexical Analyzer .");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 : {
                    PDMachine();
                    System.out.println("--------------------------------------");
                    break;
                }
                case 2 : {
                    LexicalAnalyzer();
                    System.out.println("--------------------------------------");
                    break;
                }
                default : loop = false;
            }
        }
    }

    public static void PDMachine() {
        System.out.println("Given grammar is ");
        System.out.println("S -> aAbB|ccB");
        System.out.println("A -> a|c");
        System.out.println("B -> b|a");
        System.out.println("Enter the string");
        String input = scanner.next();

        PushDownMachine machine = new PushDownMachine(input);
        if (machine.isValid())
            System.out.println("String is valid");
    }

    public static void LexicalAnalyzer() {
        LexicalAnalyzer.readFileAndPrintResult();
    }

}
