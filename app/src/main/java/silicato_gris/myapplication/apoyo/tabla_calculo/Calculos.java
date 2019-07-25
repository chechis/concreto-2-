package silicato_gris.myapplication.apoyo.tabla_calculo;

public class Calculos {

    

    public double relacionAC (double fc){

        double resistencia = 1.1497*(Math.exp(-0.0025*fc));

        return (double)(Math.round(resistencia*100)/100);
    }


}
