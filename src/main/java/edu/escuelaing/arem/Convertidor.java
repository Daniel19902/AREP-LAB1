package edu.escuelaing.arem;

import java.util.Objects;

public class Convertidor implements ServiciosConvertidor{

    private String tipo;
    private float temperatura;
    private float conversion;

    public Convertidor(String tipo, float temperatura) {
        this.tipo = tipo;
        this.temperatura = temperatura;
        System.out.println("peticion");
        if(Objects.equals(tipo, "Celsius")){
            conversion = convertirToFahrenheit();
        }else {
            conversion = convertirToCelsius();
        }
    }

    @Override
    public float convertirToCelsius() {
        return  (temperatura - 32) * (float) 5/9 ;
    }

    @Override
    public float convertirToFahrenheit() {
        return  (temperatura * (float) 9/5) + 32;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getConversion() {
        return conversion;
    }

    public void setConversion(float conversion) {
        this.conversion = conversion;
    }
}
