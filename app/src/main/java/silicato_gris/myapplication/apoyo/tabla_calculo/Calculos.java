package silicato_gris.myapplication.apoyo.tabla_calculo;

public class Calculos {


    public Calculos() {
    }

    public double relacionAC (double fc){

        double resistencia = 1.1497*(Math.exp(-0.0025*fc));

        return redondeo (resistencia, 3);
    }
    double sacoCemento = 42.2;

    //proporcion unitaria
    public double cantidadCemento (int cantidadAgua, double relAC){
        double cemento = cantidadAgua/relAC;
        return redondeo(cemento, 2);
    }
    public double cantidadAgregados (int cantidadAgua, double cantidadCemento, int pesoConcreto){
        double agregados = pesoConcreto-cantidadAgua-cantidadCemento;
        return redondeo(agregados, 2);
    }
    public double cantidadFino (double cantidadAgregados, double porcentaje){
        double fino = cantidadAgregados*porcentaje;
        return redondeo(fino, 2);
    }
    public double cantidadGrueso (double cantidadAgregados, double porcentaje){
        double grueso = cantidadAgregados*(1-porcentaje);
        return redondeo(grueso, 2);
    }
    //proporcion volumetrica
    public double propArena (double cantidadCemento, double cantidadFino){
        double arena = cantidadFino/cantidadCemento;
        return redondeo(arena, 1);

    }
    public double propPiedrin (double cantidadCemento, double cantidadGrueso){
        double grueso = cantidadGrueso/cantidadCemento;
        return redondeo(grueso, 1);

    }

    //cantidad de material a comprar
    public double comprarCemento(double cantidadCemento, double volumen){
        double cemento = (cantidadCemento*volumen)/sacoCemento;
        return Math.ceil(cemento);
    }
    public double comprarArena(double cantidadArena, double volumen, int pesoArenaCompactado){
        double arena = (cantidadArena*volumen)/pesoArenaCompactado;
        return redondeo(arena, 2);
    }
    public double comprarPiedrin(double cantidadPiedrin, double volumen, int pesoPiedrinCompactado){
        double piedrin = (cantidadPiedrin*volumen)/pesoPiedrinCompactado;
        return redondeo(piedrin, 2);
    }
    public double comprarAgua(double cantidadAgua, double volumen){
        double agua = (cantidadAgua*volumen)/1000;
        return redondeo(agua, 2);
    }
    //cantidad por saco
    public double costalArena(int pesoArenaSuelto, double propVolArena){
        double arena = (propVolArena * 1000*sacoCemento)/pesoArenaSuelto;
        return redondeo(arena, 2);
    }
    public double costalPiedrin(int pesoPiedrinSuelto, double propVolPiedrin){
        double arena = (propVolPiedrin * 1000*sacoCemento)/pesoPiedrinSuelto;
        return redondeo(arena, 2);
    }
    public double costalAgua(double propVolAgua){
        double arena = (propVolAgua * 1000*sacoCemento)/1000;
        return redondeo(arena, 2);
    }


    public double redondeo (double numero, int numeroDecimales){
        return Math.round(numero*Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);

    }


}
