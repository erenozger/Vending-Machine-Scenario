public class Item {
    private String item_id;
    private String item_type;

    public Item(String item_id, String item_type) {
        this.item_id = item_id;
        this.item_type = item_type;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String toString(){
        return item_id;
    }
}
