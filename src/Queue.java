import java.util.ArrayList;

public class Queue {
    private int size;
    private Node frontNode;
    //Front node 'um specifies the frontmost element in the priority queue.

    public Queue() {
        this.size = 0;
        this.frontNode = null;
    }

    //I used a doubly linked list in the queue implementation.
    //Because if I had defined it with array, I would have to apply shift to delete the middle elements and this would decrease the efficiency considerably.
    //The reason for not using the singly linked list was to speed up the add and delete operations since it is a priority queue.

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
            //If the queue is empty, the node is added directly and the size is increased by 1.
            this.frontNode = node;
            this.size++;
        } else {
            Node tempNode = this.frontNode; //front node , starting from first element of queue
            Node parentNode = null;

            while (tempNode != null && tempNode.compareNode(node) >= 0) {
                parentNode = tempNode;
                tempNode = tempNode.nextNode;
                //In order to find the position that should be added in the Priority queue,
                //I am storing the element before the position that needs to be added in tempnode.
            }

            if (parentNode == null) {
                node.nextNode = this.frontNode;
                this.frontNode.prevNode = node;
                this.frontNode = node;
                //If the position to be added is at the front, it is added in front of the front mode and
                // the desired value is added to the new front node.

            } else if (tempNode == null) {
                parentNode.nextNode = node;
                node.prevNode = parentNode;

            } else {
                parentNode.nextNode = node;
                node.prevNode = parentNode;
                node.nextNode = tempNode;
                tempNode.prevNode = node;
                //ELEMENT - node - ELEMENT
                //If the node to be added comes together, the next node of the previous node to be added and
                //the prev nodes of the node next to the previous node are arranged.
            }
            this.size++;
        }

    }

    public Token dequeue(String type) {
        Node node = findPriorityItemByType(type);
        //The node is found according to the type of node to be deleted from the Priority queue.
        if(node != null){
            Token dequeueItem = node.item;

            //If the node to be deleted is at the bottom of the queue or at the back,
            // necessary arrangements are made and deleted accordingly.
            if(node==this.frontNode){
                this.frontNode = node.nextNode;
            }
            if(node.nextNode != null){
                node.nextNode.prevNode = node.prevNode;
            }
            if(node.prevNode != null){
                node.prevNode.nextNode = node.nextNode;
            }
            this.size--;
            return dequeueItem;
        }else{
            return null;
        }
    }

    public Node findPriorityItemByType(String type){
        Node temp = this.frontNode;
        //Priority queue's node with the highest priority (highest value) is found and returned,
        // starting from the frontmost node and moving forward.
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

        //In the output file, starting from the backmost node (from the lowest priority) to the frontmost,
        // it is displayed from the front to the back and pressed on the screen.
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
