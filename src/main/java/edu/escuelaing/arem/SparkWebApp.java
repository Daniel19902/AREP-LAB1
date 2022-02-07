package edu.escuelaing.arem;
import org.json.JSONObject;

import static spark.Spark.*;
public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        get("/Convertidor/:tipo/:numero", (req, res) -> convertidor(req.params(":tipo"),req.params(":numero")));
    }

    public static JSONObject convertidor(String tipo, String numero){
        JSONObject jsonObject = new JSONObject();
        float temperatura = Float.parseFloat(numero);
        jsonObject.put("tipo", tipo);
        jsonObject.put("numero", numero);
        if(tipo.equals("Celsius")){
            jsonObject.put("respuesta", parseFahrenheit(temperatura));
        }else if (tipo.equals("Fahrenheit")){
            jsonObject.put("respuesta", parseCelsius(temperatura));
        }else {
            jsonObject.put("respuesta", "Tipo de conversion no sortado");
        }
        return jsonObject;
    }

    private static float parseFahrenheit(float numero) {
        System.out.println(numero);
        return  (numero * (float) 9/5) + 32;
    }

    private static float parseCelsius(float numero){
        return  (numero - 32) * (float) 5/9 ;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
    }


}
