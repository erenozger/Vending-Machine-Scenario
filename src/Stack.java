import java.util.ArrayList;

public class Stack {

    private ArrayList<Item> stackArray; //Stack containing items.
    private int size; //stack size

    public Stack() {
        this.stackArray = new ArrayList<Item>();
        this.size = 0;
        //An empty stack structure is created in the constructor.
    }

    public void push(Item item) {
        stackArray.add(item);
        this.size++;
        //When an item is added to the stack, it is added to the arraylist and you are increased by 1.
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
        //The size value actually specifies the last value added to the stack.
        //For this reason, the value in the size index is the first element to be deleted from the stack, and it is reduced to 1.
    }

    public Item top() {
        if (isEmpty()) {
            return null;
        } else {
            return stackArray.get(size - 1);
        }
        //returns topmost element of stack.
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
