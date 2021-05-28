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

        //It creates and saves the stack structure special to all the parts in the file.
        Part.setAllParts(Reader.readFile(partsFile));

        //It reads the Items.txt and places all the items in it into their stack, which sees its type.
        Part.setAllItemsToParts(Reader.readFile(itemsFile));

        //It reads all tokens and creates a new Priority Queue and saves them in it.
        Token.setAllTokens(Reader.readFile(tokensFile));

        //It reads Tasks.txt and implements the tasks in it in order.
        Tasks.doAllTasks(Reader.readFile(tasksFile));

        Part.displayAllParts();//Displays all stacks to the screen.
        Token.displayTokenBox();//Displays token box priority queue.

    }
}
