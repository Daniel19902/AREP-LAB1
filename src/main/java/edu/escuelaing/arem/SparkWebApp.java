package edu.escuelaing.arem;
import org.json.JSONObject;

import static spark.Spark.*;
public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        get("/Convertidor/:tipo/:numero", (req, res) -> parseCelsius(req.params(":tipo"),req.params(":numero")));
    }

    public static JSONObject parseCelsius(String tipo, String numero){
        Convertidor convertidor = new Convertidor(tipo, Float.parseFloat(numero));
        convertidor.parse();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tipo",convertidor.getTipo());
        jsonObject.put("numero",convertidor.getNumero());
        jsonObject.put("respuesta", convertidor.getRespuesta());
        return jsonObject;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
    }


}
