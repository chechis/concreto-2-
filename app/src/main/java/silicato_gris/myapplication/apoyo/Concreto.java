package silicato_gris.myapplication.apoyo;

public class Concreto {



    private int id;
    private double resistencia;
    private int elemento;
    private int pesoConcreto;
    private int pesoSueltoFino;
    private int pesoCompactadoFino;
    private int pesoSueltoGrueso;
    private int pesoCompactadoGrueso;
    private int aguaCemento;
    private int propUnitaria;
    private int propVol;

    private int tmnNum;
    private int asentamientoNum;
    private int factorNum;

    public Concreto() {
    }

    public Concreto(double resistencia, int elemento, int pesoConcreto, int pesoSueltoFino, int pesoCompactadoFino, int pesoSueltoGrueso, int pesoCompactadoGrueso, int aguaCemento, int propUnitaria, int propVol, int tmnNum, int asentamientoNum, int factorNum) {
        this.resistencia = resistencia;
        this.elemento = elemento;
        this.pesoConcreto = pesoConcreto;
        this.pesoSueltoFino = pesoSueltoFino;
        this.pesoCompactadoFino = pesoCompactadoFino;
        this.pesoSueltoGrueso = pesoSueltoGrueso;
        this.pesoCompactadoGrueso = pesoCompactadoGrueso;
        this.aguaCemento = aguaCemento;
        this.propUnitaria = propUnitaria;
        this.propVol = propVol;
        this.tmnNum = tmnNum;
        this.asentamientoNum = asentamientoNum;
        this.factorNum = factorNum;
    }

    public Concreto(int id, double resistencia, int elemento, int pesoConcreto, int pesoSueltoFino, int pesoCompactadoFino, int pesoSueltoGrueso, int pesoCompactadoGrueso, int aguaCemento, int propUnitaria, int propVol, int tmnNum, int asentamientoNum, int factorNum) {
        this.id = id;
        this.resistencia = resistencia;
        this.elemento = elemento;
        this.pesoConcreto = pesoConcreto;
        this.pesoSueltoFino = pesoSueltoFino;
        this.pesoCompactadoFino = pesoCompactadoFino;
        this.pesoSueltoGrueso = pesoSueltoGrueso;
        this.pesoCompactadoGrueso = pesoCompactadoGrueso;
        this.aguaCemento = aguaCemento;
        this.propUnitaria = propUnitaria;
        this.propVol = propVol;
        this.tmnNum = tmnNum;
        this.asentamientoNum = asentamientoNum;
        this.factorNum = factorNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getResistencia() {
        return resistencia;
    }

    public void setResistencia(double resistencia) {
        this.resistencia = resistencia;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public int getPesoConcreto() {
        return pesoConcreto;
    }

    public void setPesoConcreto(int pesoConcreto) {
        this.pesoConcreto = pesoConcreto;
    }

    public int getPesoSueltoFino() {
        return pesoSueltoFino;
    }

    public void setPesoSueltoFino(int pesoSueltoFino) {
        this.pesoSueltoFino = pesoSueltoFino;
    }

    public int getPesoCompactadoFino() {
        return pesoCompactadoFino;
    }

    public void setPesoCompactadoFino(int pesoCompactadoFino) {
        this.pesoCompactadoFino = pesoCompactadoFino;
    }

    public int getPesoSueltoGrueso() {
        return pesoSueltoGrueso;
    }

    public void setPesoSueltoGrueso(int pesoSueltoGrueso) {
        this.pesoSueltoGrueso = pesoSueltoGrueso;
    }

    public int getPesoCompactadoGrueso() {
        return pesoCompactadoGrueso;
    }

    public void setPesoCompactadoGrueso(int pesoCompactadoGrueso) {
        this.pesoCompactadoGrueso = pesoCompactadoGrueso;
    }

    public int getAguaCemento() {
        return aguaCemento;
    }

    public void setAguaCemento(int aguaCemento) {
        this.aguaCemento = aguaCemento;
    }

    public int getPropUnitaria() {
        return propUnitaria;
    }

    public void setPropUnitaria(int propUnitaria) {
        this.propUnitaria = propUnitaria;
    }

    public int getPropVol() {
        return propVol;
    }

    public void setPropVol(int propVol) {
        this.propVol = propVol;
    }

    public int getTmnNum() {
        return tmnNum;
    }

    public void setTmnNum(int tmnNum) {
        this.tmnNum = tmnNum;
    }

    public int getAsentamientoNum() {
        return asentamientoNum;
    }

    public void setAsentamientoNum(int asentamientoNum) {
        this.asentamientoNum = asentamientoNum;
    }

    public int getFactorNum() {
        return factorNum;
    }

    public void setFactorNum(int factorNum) {
        this.factorNum = factorNum;
    }
}
