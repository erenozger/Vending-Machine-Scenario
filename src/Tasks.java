import java.util.ArrayList;

public class Tasks {

    public static void doAllTasks(ArrayList<String> tasksList) {
        for (int i = 0; i < tasksList.size(); i++) {
            String taskLine = tasksList.get(i);
            String[] splitLine = taskLine.split("\t");
            String taskCommand = splitLine[0];
            if (taskCommand.equals("BUY")) {
                for (int j = 1; j < splitLine.length; j++) {
                    String[] splitTask = splitLine[j].split(",");
                    BuyTask(splitTask[0], Integer.parseInt(splitTask[1]));
                }
            } else if (taskCommand.equals("PUT")) {
                for (int j = 1; j < splitLine.length; j++) {
                    String[] splitTask = splitLine[j].split(",");
                    String[] itemList = new String[splitTask.length - 1];
                    for (int k = 0; k < splitTask.length - 1; k++) {
                        itemList[k] = splitTask[k + 1];
                    }
                    PutTask(splitTask[0], itemList);
                }
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    public static void BuyTask(String type, int count) {
        //first step we pop on stacks
        for (int i = 0; i < count; i++) {
            Part.getPartFromName(type).getPart_stack().pop();
        }
        int deletedCount = 0;

        while (deletedCount != count) {

            Token token = Token.tokens.dequeue(type);

            if (token.getValue() > count) {
                token.setValue(token.getValue() - count);
                Token.tokens.enqueue(token);
                deletedCount = count;
            } else {
                deletedCount = count - token.getValue();
            }
        }
    }

    public static void PutTask(String type, String[] items) {
        ArrayList<String> itemsList = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            String itemString = items[i] + " " + type;
            itemsList.add(itemString);
        }
        Part.setAllItemsToParts(itemsList);
    }
}
