import java.util.ArrayList;

public class Token implements Comparable<Token> {
    private String name;
    private String type;
    private int value;

    static Queue tokens = new Queue();

    public Token(String name, String type, int value) {
        this.name = name;
        this.type = type;
        this.value = value;
        tokens.enqueue(this);
    }

    public static void setAllTokens(ArrayList<String> tokensList){
        for(int i = 0 ; i<tokensList.size();i++){
            String line = tokensList.get(i);
            if(line != null){
                String[] lineSplit = line.split(" ");
                new Token(lineSplit[0],lineSplit[1],Integer.parseInt(lineSplit[2]));
            }
        }
    }

    public static void enqueueToken(String type,int count){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Token token) {
        if (this.value < token.value) {
            return -1;
        } else if (this.value  > token.value ) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString(){
        return this.name + " " + this.type + " " + this.value;
    }

    public static void displayTokenBox(){
        System.out.println("Token Box:");
        System.out.println(tokens);

    }
}
