import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
    public static String partsFile;
    public static String itemsFile;
    public static String tokensFile;
    public static String tasksFile;
    public static String outputFile;

    public static void main(String[] args) throws FileNotFoundException {
        partsFile = args[0];
        itemsFile = args[1];
        tokensFile = args[2];
        tasksFile = args[3];
        outputFile = args[4];

        PrintStream o = new PrintStream(new File(outputFile));
        System.setOut(o);               // Prints to output file

        Part.setAllParts(Reader.readFile(partsFile));
        Part.setAllItemsToParts(Reader.readFile(itemsFile));

        Token.setAllTokens(Reader.readFile(tokensFile));
        Tasks.doAllTasks(Reader.readFile(tasksFile));

        Part.displayAllParts();
        Token.displayTokenBox();





    }
}
