import java.util.ArrayList;

public class Stack<Item> {

    private ArrayList<Item> stackArray;
    private int size; //stack size

    public Stack() {
        this.stackArray = new ArrayList<Item>();
        this.size = 0;
    }

    public void push(Item item) {
        stackArray.add(item);
        this.size++;
    }

    public Item pop() {
        if (isEmpty()) {
            System.out.println("Stack empty!");
            return null;
        } else {
            Item returnItem = stackArray.get(size - 1);
            stackArray.remove(size-1);
            this.size--;
            return returnItem;
        }
    }

    public Item top() {
        if (isEmpty()) {
            return null;
        } else {
            return stackArray.get(size - 1);
        }
    }


    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    public int size() {
        return this.size;
    }

    public String toString(){
        String stackString ="";
        int printSize = size();
        while(printSize != 0 ){
            stackString += stackArray.get(printSize -1).toString() + "\n";
            printSize--;
        }

        return stackString.equals("") ? "\n" : stackString;
    }
}
