import java.util.ArrayList;

public class Tasks {

    public static void doAllTasks(ArrayList<String> tasksList) {
        for (int i = 0; i < tasksList.size(); i++) {
            String taskLine = tasksList.get(i);
            String[] splitLine = taskLine.split("\t");
            String taskCommand = splitLine[0];

            //After the Tasks.txt file is read, the values in the line are separated and 2 different functions are executed according to the first data.
            if (taskCommand.equals("BUY")) {
                for (int j = 1; j < splitLine.length; j++) {
                    String[] splitTask = splitLine[j].split(",");
                    BuyTask(splitTask[0], Integer.parseInt(splitTask[1]));
                    //For the buy task, the type and count are sent as parameters.
                }
            } else if (taskCommand.equals("PUT")) {
                for (int j = 1; j < splitLine.length; j++) {
                    String[] splitTask = splitLine[j].split(",");
                    String[] itemList = new String[splitTask.length - 1];
                    for (int k = 0; k < splitTask.length - 1; k++) {
                        itemList[k] = splitTask[k + 1];
                    }
                    //The type to be added and the items to be added are sent to the function as a list.
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
        //First, the process of deleting from the stack structure is performed.


        int deletedCount = 0;
        while (deletedCount != count) {
            //Deleting from the tokens priority queue is performed repeatedly until enough deletions are performed.
            Token token = Token.tokens.dequeue(type);
            if(token == null){
                System.out.println("Not enough token!");
                break;
            }
            if (token.getValue() > count) {
                token.setValue(token.getValue() - count);
                Token.tokens.enqueue(token);
                //If the token's value is higher than the desired number to delete, it is first deleted from the priority queue
                // and the token is updated. Then it is added again.
                deletedCount = count;
            } else {
                deletedCount = deletedCount + (count - token.getValue());
            }
        }
    }

    public static void PutTask(String type, String[] items) {
        ArrayList<String> itemsList = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            String itemString = items[i] + " " + type;
            itemsList.add(itemString);
        }
        //The put task function has a stack to add. Then all items are added to stack structures by using the function in reading from the file.
        Part.setAllItemsToParts(itemsList);
    }
}
