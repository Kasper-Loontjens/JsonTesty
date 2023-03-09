import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        System.out.println("Hello world!");
        System.out.println("Hello world!");
        System.out.println("Helloooooo");

        JSONObject jsonOb = new JSONObject();

        jsonOb.put("namn", "marcus");
        jsonOb.put("age", 34);

        System.out.println("Mitt namn är: " + jsonOb.get("namn"));

        System.out.println("Jag är " + jsonOb.get("age")+ " år gammal");

        Object newO = new JSONParser().parse(new FileReader("src/jsonText.json"));
        JSONObject jsonData = (JSONObject) newO;
        JSONObject person = (JSONObject) jsonData.get("p1");
        String name= (String) person.get("name");
        System.out.println("P1 Name :" + name);
    }
}