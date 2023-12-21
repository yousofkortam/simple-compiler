import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LexicalAnalyzer {
    private static final String[] keywords = {"auto", "break", "case", "char", "const", "continue", "default", "do",
            "double", "else", "enum", "extern", "float", "for", "goto", "if", "int", "long", "register", "return",
            "short", "signed", "sizeof", "static", "struct", "switch", "typedef", "union", "unsigned", "void",
            "volatile", "while"};

    public static boolean isKeyword(String buffer) {
        for (String keyword : keywords) {
            if (keyword.equals(buffer)) {
                return true;
            }
        }
        return false;
    }

    public static void readFileAndPrintResult() {
        char[] operators = {'+', '-', '*', '/', '%', '='};
        char[] separators = {'(', ')', '{', '}', '[', ']', '<', '>', ','};
        int BUFFER_SIZE = 15;

        try {
            File file = new File("lexicalinput.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String token = scanner.next();

                for (char operator : operators) {
                    if (token.length() == 1 && token.charAt(0) == operator) {
                        System.out.println("OPERATOR:     " + token);
                        break;
                    }
                }

                for (char separator : separators) {
                    if (token.length() == 1 && token.charAt(0) == separator) {
                        System.out.println("SEPARATOR:    " + token);
                        break;
                    }
                }

                if (Character.isLetterOrDigit(token.charAt(0))) {
                    if (isKeyword(token)) {
                        System.out.println("KEYWORD:      " + token);
                    } else {
                        System.out.println("IDENTIFIER:   " + token);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}