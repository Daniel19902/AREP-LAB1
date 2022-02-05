package edu.escuelaing.arem;

public class Convertidor {

    private String tipo;
    private float numero;
    private float respuesta;


    public Convertidor(String tipo, float numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public void parse(){
        if( tipo == "Celsius"){
            parseFahrenheit();
        }
        parseCelsius();
    }

    private void parseFahrenheit() {
        respuesta = (numero * (float) 9/5) + 32;
    }

    private void parseCelsius(){
        respuesta = (numero - 32) * (float) 5/9 ;
    }

    public float getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(float respuesta) {
        this.respuesta = respuesta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getNumero() {
        return numero;
    }

    public void setNumero(float numero) {
        this.numero = numero;
    }
}
