package silicato_gris.myapplication.apoyo;

public class Concreto {

    public enum Tmn {
        tresOctavos, media, tresCuartos, una, unaYMedia

    }
    public enum Asentamiento{
        cinco, ocho, diez
    }

    public enum Factor{
        cero, veinticinco, treinta, treintaYCinco, cuarenta, cincuenta
    }

    private int id;
    private int resistencia;
    private Factor factor;
    private int elemento;
    private Tmn tmn;
    private int pesoConcreto;
    private int pesoSueltoFino;
    private int pesoCompactadoFino;
    private int pesoSueltoGrueso;
    private int pesoCompactadoGrueso;
    private int aguaCemento;
    private Asentamiento asentamiento;
    private int propUnitaria;
    private int propVol;


    public Concreto() {
    }

    public Concreto(int id, int resistencia, Factor factor, int elemento, Tmn tmn, int pesoConcreto, int pesoSueltoFino, int pesoCompactadoFino, int pesoSueltoGrueso, int pesoCompactadoGrueso, int aguaCemento, Asentamiento asentamiento, int propUnitaria, int propVol) {
        this.id = id;
        this.resistencia = resistencia;
        this.factor = factor;
        this.elemento = elemento;
        this.tmn = tmn;
        this.pesoConcreto = pesoConcreto;
        this.pesoSueltoFino = pesoSueltoFino;
        this.pesoCompactadoFino = pesoCompactadoFino;
        this.pesoSueltoGrueso = pesoSueltoGrueso;
        this.pesoCompactadoGrueso = pesoCompactadoGrueso;
        this.aguaCemento = aguaCemento;
        this.asentamiento = asentamiento;
        this.propUnitaria = propUnitaria;
        this.propVol = propVol;
    }

    public Concreto(int resistencia, Factor factor, int elemento, Tmn tmn, int pesoConcreto, int pesoSueltoFino, int pesoCompactadoFino, int pesoSueltoGrueso, int pesoCompactadoGrueso, int aguaCemento, Asentamiento asentamiento, int propUnitaria, int propVol) {
        this.resistencia = resistencia;
        this.factor = factor;
        this.elemento = elemento;
        this.tmn = tmn;
        this.pesoConcreto = pesoConcreto;
        this.pesoSueltoFino = pesoSueltoFino;
        this.pesoCompactadoFino = pesoCompactadoFino;
        this.pesoSueltoGrueso = pesoSueltoGrueso;
        this.pesoCompactadoGrueso = pesoCompactadoGrueso;
        this.aguaCemento = aguaCemento;
        this.asentamiento = asentamiento;
        this.propUnitaria = propUnitaria;
        this.propVol = propVol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public Factor getFactor() {
        return factor;
    }

    public void setFactor(Factor factor) {
        this.factor = factor;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public Tmn getTmn() {
        return tmn;
    }

    public void setTmn(Tmn tmn) {
        this.tmn = tmn;
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

    public Asentamiento getAsentamiento() {
        return asentamiento;
    }

    public void setAsentamiento(Asentamiento asentamiento) {
        this.asentamiento = asentamiento;
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
}
