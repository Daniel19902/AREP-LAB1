package edu.escuelaing.arem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class AppTest {


    @Test
    public void CelsiusToFahrenheit1(){
        Convertidor convertidor = new Convertidor("Celsius", 35);
        Assertions.assertEquals(convertidor.getConversion(), 95);
    }

    @Test
    public void CelsiusToFahrenheit2(){
        Convertidor convertidor = new Convertidor("Celsius", -35);
        Assertions.assertEquals(convertidor.getConversion(), -31);
    }

    @Test
    public void CelsiusToFahrenheit3(){
        Convertidor convertidor = new Convertidor("Celsius", (float) -35.59);
        Assertions.assertEquals(convertidor.getConversion(), -32.06199645996094);
    }

    @Test
    public void CelsiusToFahrenheit4(){
        Convertidor convertidor = new Convertidor("Celsius", 100);
        Assertions.assertEquals(convertidor.getConversion(), 212);
    }

    @Test
    public void CelsiusToFahrenheit5(){
        Convertidor convertidor = new Convertidor("Celsius", -100);
        Assertions.assertEquals(convertidor.getConversion(), -148);
    }

    @Test
    public void FahrenheitToCelsius(){
        Convertidor convertidor = new Convertidor("Fahrenheit", 35);
        Assertions.assertEquals(convertidor.getConversion(), 1.6666666269302368);
    }

    @Test
    public void FahrenheitToCelsius2(){
        Convertidor convertidor = new Convertidor("Fahrenheit", 0);
        Assertions.assertEquals(convertidor.getConversion(), -17.77777862548828);
    }

    /*
        10 pruebas concurrentes remotas
     */
    @Test
    public void ServicioConcurrente()  {
        for(int i = 0; i <= 10; i++) {
            new Thread(new ThreadConnection()).start();
        }

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class ThreadConnection extends Thread{
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
                Assertions.assertEquals(responseCode, 200);
            }catch (IOException e){

            }
        }
    }

}
