import java.util.ArrayList;

public class Queue {
    private int size;
    private Node frontNode;

    public Queue() {
        this.size = 0;
        this.frontNode = null;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public boolean isFull() {
        return false; //can not be full with i implement with linked list!
    }

    public int size() {
        return this.size;
    }

    public void enqueue(Token token) {
        Node node = new Node(token);

        if (isEmpty()) {
            this.frontNode = node;
            this.size++;
        } else {
            Node tempNode = this.frontNode; //front node , starting from first element of queue
            Node parentNode = null;
            while (tempNode != null && tempNode.compareNode(node) >= 0) {
                parentNode = tempNode;
                tempNode = tempNode.nextNode;
            }

            if (parentNode == null) {
                node.nextNode = this.frontNode;
                this.frontNode.prevNode = node;
                this.frontNode = node;
            } else if (tempNode == null) {
                parentNode.nextNode = node;
                node.prevNode = parentNode;
            } else {
                parentNode.nextNode = node;
                node.prevNode = parentNode;
                node.nextNode = tempNode;
                tempNode.prevNode = node;
            }
            this.size++;
        }

    }

    public Token dequeue(String type) {
        Node node = findPriorityItemByType(type);
        if(node != null){
            Token dequeueItem = node.item;
            if(node==this.frontNode){
                this.frontNode = node.nextNode;
//                this.frontNode.prevNode = null;
            }
            if(node.nextNode != null){
                node.nextNode.prevNode = node.prevNode;
            }
            if(node.prevNode != null){
                node.prevNode.nextNode = node.nextNode;
            }
            return dequeueItem;
        }else{
            return null;
        }
    }

    public Node findPriorityItemByType(String type){
        Node temp = this.frontNode;
        for(int i = 0 ; i<size ; i++ ){
            if(temp.item.getType().equals(type)){
                break;
            }else{
                temp = temp.nextNode;
            }
        }
        return temp;
    }


    public String toString() {
        String returnString = "";
        Node temp = this.frontNode;
        ArrayList<String> printList = new ArrayList<>();

        while (temp != null) {
            printList.add(temp.item.toString());
            temp = temp.nextNode;
        }
        for (int i = printList.size() - 1; i >= 0; i--) {
            returnString += printList.get(i);
            if (i != 0) {
                returnString += "\n";
            }
        }
        return returnString;
    }

}
