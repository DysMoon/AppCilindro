package Models;

import androidx.annotation.NonNull;

public class Cilindro {


    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }

    public double calcularVolumen() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    @Override
    public String toString() {
        return "Cilindro de radio="  + radio + " y altura=" + altura + " tiene un volumen de " + calcularVolumen();
    }
}

