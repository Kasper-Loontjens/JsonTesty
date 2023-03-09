import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

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
        JSONObject person1 = (JSONObject) jsonData.get("p1");
        JSONObject person2 = (JSONObject) jsonData.get("p2");
        String name = (String) person1.get("name");

        int ageP1 = Integer.parseInt(person1.get("age").toString());
        System.out.println("P1 Name: " + name + "--- P2 Name: "+ person2.get("name"));
        System.out.println((name + " is " + ageP1 + " years old."));
        System.out.println((person2.get("name") + " is " + person2.get("age") + " years old."));

        fetchJsonFromApi();
    }


    static void fetchJsonFromApi() throws IOException, ParseException {
        URL issUrl = new URL("https://api.wheretheiss.at/v1/satellites/25544");
        HttpURLConnection conn = (HttpURLConnection) issUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        if (conn.getResponseCode() == 200) System.out.println("lyckat");
        else System.out.println("miss");

        StringBuilder strData = new StringBuilder();
        Scanner scanner = new Scanner(issUrl.openStream());
        while (scanner.hasNext()) {
            strData.append(scanner.nextLine());
        }
        scanner.close();
        JSONObject dataObject = (JSONObject) new JSONParser().parse(String.valueOf(strData));
        System.out.println(dataObject);
        System.out.println("Velooo: " +dataObject.get("velocity"));
    }
}