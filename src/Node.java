public class Node {
    Token item;
    Node nextNode;
    Node prevNode;

    //It stores the item and the previous and next nodes attached to it within each node.

    public Node(Token item) {
        this.item = item;
        this.nextNode = null;
        this.prevNode = null;
    }

    public int compareNode(Node node){
        return item.compareTo(node.item);
        //To compare 2 nodes, I am comparing the items of 2 nodes.
    }
}
