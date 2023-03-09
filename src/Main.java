import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.out.println("Hello world!");
        System.out.println("Helloooooo");

        JSONObjects jsonOb = new JSONObject();

        jsonOb.put("namn", "marcus");
        jsonOb.put("age", 34);

        System.out.println("Mitt namn är: " + jsonOb.get("namn"));

        System.out.println("Jag är " + jsonOb.get("age")+ " år gammal");


    }
}