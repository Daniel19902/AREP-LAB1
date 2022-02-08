package edu.escuelaing.arem;

import com.google.gson.Gson;

import static spark.Spark.*;
public class SparkWebApp {

    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        get("/Convertidor/:tipo/:numero", (req, res) -> gson.toJson(new Convertidor(req.params(":tipo"), Float.parseFloat(req.params(":numero")))));
    }


    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set
    }


}
