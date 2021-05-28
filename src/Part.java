import java.util.ArrayList;

public class Part {
    //Each part contains the name and the stack structure created for that name.
    private String name;
    private Stack part_stack;

    static ArrayList<Part> parts = new ArrayList<Part>();
    //The Parts array contains all stacks.

    public Part(String name) {
        this.name = name;
        this.part_stack = new Stack();
        Part.parts.add(this);
    }

    public static void setAllParts(ArrayList<String> partsFile){
        for (int i = 0; i < partsFile.size(); i++) {
            if (partsFile.get(i) != null) {
                new Part(partsFile.get(i));
            }
        }
        //An empty stack is created for all parts by reading the parts.txt.
    }

    public static void setAllItemsToParts(ArrayList<String> itemsFile){
        for (int i = 0; i < itemsFile.size(); i++) {
            if (itemsFile.get(i) != null) {
                String [] itemSplit = itemsFile.get(i).split(" ");
                getPartFromName(itemSplit[1]).getPart_stack().push(new Item(itemSplit[0],itemSplit[1]));
                //Finds the stack structure to which the item will be added and a new item is created and saved.
            }
        }
    }

    public static Part getPartFromName(String partName){
        for(int i = 0 ; i<parts.size();i++){
            if(parts.get(i).getName().equals(partName)){
                return parts.get(i);
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stack getPart_stack() {
        return part_stack;
    }

    public void setPart_stack(Stack part_stack) {
        this.part_stack = part_stack;
    }

    public String toString(){
        return name+":" + "\n" + part_stack.toString() + "---------------";
    }

    public static void displayAllParts(){
        for(int i = 0 ; i<parts.size();i++){
            System.out.println(parts.get(i));
        }
    }
}
