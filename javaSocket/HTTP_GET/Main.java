package http_get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL myUrl = new URL("http://webcode.me/");
        HttpURLConnection conn = (HttpURLConnection) myUrl.openConnection();

        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        System.out.println("Value of http created is : " + conn.HTTP_OK);

        if (responseCode == conn.HTTP_OK) {
            System.out.println("This is Response Code : " + responseCode);
            System.out.println("This is Response message from Server" + conn.getResponseMessage());

        } else {
            System.out.println("Go Home Everybody :( ");
        }


        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader buffer = new BufferedReader(in);

        StringBuffer fromServer = new StringBuffer();

        String eachLine = null;

        while ((eachLine = buffer.readLine()) != null) {
            fromServer.append(eachLine);
            fromServer.append(System.lineSeparator());
        }
        buffer.close();


        System.out.println("Here is our content :"+fromServer);
    }
}

