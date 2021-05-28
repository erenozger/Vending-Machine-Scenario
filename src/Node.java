public class Node {
    Token item;
    Node nextNode;
    Node prevNode;

    public Node(Token item) {
        this.item = item;
        this.nextNode = null;
        this.prevNode = null;
    }

    public int compareNode(Node node){
        return item.compareTo(node.item);
    }
}
