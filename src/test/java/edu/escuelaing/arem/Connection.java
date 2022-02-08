package edu.escuelaing.arem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection extends Thread{

    public Connection() {
    }

    @Override
    public void run() {
        try {
            String GET_URL = "http://localhost:4567/Convertidor/Celsius/35";
            URL obj = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            String USER_AGENT = "Mozilla/5.0";
            con.setRequestProperty("User-Agent", USER_AGENT);

            //The following invocation perform the connection implicitly before getting the code
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }
            System.out.println("GET DONE");
        }catch (IOException e){

        }

    }
}
