package silicato_gris.myapplication.apoyo;

public class ConcretoAlerta {
    private int id;
    private String nombreProyecto;
    private double resistencia;
    private int factor;
    private int asentamiento;
    private int tmn;
    private int pesoConcreto;
    private int pesoFinoSuelto;
    private int pesofinoCompacto;
    private int pesoGruesoSuelto;
    private int pesoGruesoComacto;
    private double relAC;
    private double propUniCemento;
    private double propUniAgregados;
    private double propUniFino;
    private double propUniGrueso;
    private double propUniAgua;
    private double propVolFino;
    private double propVolGrueso;
    private double comprarCemento;
    private double comprarArena;
    private double comprarPiedrin;
    private double comprarAgua;
    private double costalFino;
    private double costalGrueso;
    private double costalAgua;

    public ConcretoAlerta(int id, String nombreProyecto, double resistencia, int factor, int asentamiento, int tmn, int pesoConcreto, int pesoFinoSuelto, int pesofinoCompacto, int pesoGruesoSuelto, int pesoGruesoComacto, double relAC, double propUniCemento, double propUniAgregados, double propUniFino, double propUniGrueso, double propUniAgua, double propVolFino, double propVolGrueso, double comprarCemento, double comprarArena, double comprarPiedrin, double comprarAgua, double costalFino, double costalGrueso, double costalAgua) {
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.resistencia = resistencia;
        this.factor = factor;
        this.asentamiento = asentamiento;
        this.tmn = tmn;
        this.pesoConcreto = pesoConcreto;
        this.pesoFinoSuelto = pesoFinoSuelto;
        this.pesofinoCompacto = pesofinoCompacto;
        this.pesoGruesoSuelto = pesoGruesoSuelto;
        this.pesoGruesoComacto = pesoGruesoComacto;
        this.relAC = relAC;
        this.propUniCemento = propUniCemento;
        this.propUniAgregados = propUniAgregados;
        this.propUniFino = propUniFino;
        this.propUniGrueso = propUniGrueso;
        this.propUniAgua = propUniAgua;
        this.propVolFino = propVolFino;
        this.propVolGrueso = propVolGrueso;
        this.comprarCemento = comprarCemento;
        this.comprarArena = comprarArena;
        this.comprarPiedrin = comprarPiedrin;
        this.comprarAgua = comprarAgua;
        this.costalFino = costalFino;
        this.costalGrueso = costalGrueso;
        this.costalAgua = costalAgua;
    }

    public ConcretoAlerta(String nombreProyecto, double resistencia, int factor, int asentamiento, int tmn, int pesoConcreto, int pesoFinoSuelto, int pesofinoCompacto, int pesoGruesoSuelto, int pesoGruesoComacto, double relAC, double propUniCemento, double propUniAgregados, double propUniFino, double propUniGrueso, double propUniAgua, double propVolFino, double propVolGrueso, double comprarCemento, double comprarArena, double comprarPiedrin, double comprarAgua, double costalFino, double costalGrueso, double costalAgua) {
        this.nombreProyecto = nombreProyecto;
        this.resistencia = resistencia;
        this.factor = factor;
        this.asentamiento = asentamiento;
        this.tmn = tmn;
        this.pesoConcreto = pesoConcreto;
        this.pesoFinoSuelto = pesoFinoSuelto;
        this.pesofinoCompacto = pesofinoCompacto;
        this.pesoGruesoSuelto = pesoGruesoSuelto;
        this.pesoGruesoComacto = pesoGruesoComacto;
        this.relAC = relAC;
        this.propUniCemento = propUniCemento;
        this.propUniAgregados = propUniAgregados;
        this.propUniFino = propUniFino;
        this.propUniGrueso = propUniGrueso;
        this.propUniAgua = propUniAgua;
        this.propVolFino = propVolFino;
        this.propVolGrueso = propVolGrueso;
        this.comprarCemento = comprarCemento;
        this.comprarArena = comprarArena;
        this.comprarPiedrin = comprarPiedrin;
        this.comprarAgua = comprarAgua;
        this.costalFino = costalFino;
        this.costalGrueso = costalGrueso;
        this.costalAgua = costalAgua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public double getResistencia() {
        return resistencia;
    }

    public void setResistencia(double resistencia) {
        this.resistencia = resistencia;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public int getAsentamiento() {
        return asentamiento;
    }

    public void setAsentamiento(int asentamiento) {
        this.asentamiento = asentamiento;
    }

    public int getTmn() {
        return tmn;
    }

    public void setTmn(int tmn) {
        this.tmn = tmn;
    }

    public int getPesoConcreto() {
        return pesoConcreto;
    }

    public void setPesoConcreto(int pesoConcreto) {
        this.pesoConcreto = pesoConcreto;
    }

    public int getPesoFinoSuelto() {
        return pesoFinoSuelto;
    }

    public void setPesoFinoSuelto(int pesoFinoSuelto) {
        this.pesoFinoSuelto = pesoFinoSuelto;
    }

    public int getPesofinoCompacto() {
        return pesofinoCompacto;
    }

    public void setPesofinoCompacto(int pesofinoCompacto) {
        this.pesofinoCompacto = pesofinoCompacto;
    }

    public int getPesoGruesoSuelto() {
        return pesoGruesoSuelto;
    }

    public void setPesoGruesoSuelto(int pesoGruesoSuelto) {
        this.pesoGruesoSuelto = pesoGruesoSuelto;
    }

    public int getPesoGruesoComacto() {
        return pesoGruesoComacto;
    }

    public void setPesoGruesoComacto(int pesoGruesoComacto) {
        this.pesoGruesoComacto = pesoGruesoComacto;
    }

    public double getRelAC() {
        return relAC;
    }

    public void setRelAC(double relAC) {
        this.relAC = relAC;
    }

    public double getPropUniCemento() {
        return propUniCemento;
    }

    public void setPropUniCemento(double propUniCemento) {
        this.propUniCemento = propUniCemento;
    }

    public double getPropUniAgregados() {
        return propUniAgregados;
    }

    public void setPropUniAgregados(double propUniAgregados) {
        this.propUniAgregados = propUniAgregados;
    }

    public double getPropUniFino() {
        return propUniFino;
    }

    public void setPropUniFino(double propUniFino) {
        this.propUniFino = propUniFino;
    }

    public double getPropUniGrueso() {
        return propUniGrueso;
    }

    public void setPropUniGrueso(double propUniGrueso) {
        this.propUniGrueso = propUniGrueso;
    }

    public double getPropUniAgua() {
        return propUniAgua;
    }

    public void setPropUniAgua(double propUniAgua) {
        this.propUniAgua = propUniAgua;
    }

    public double getPropVolFino() {
        return propVolFino;
    }

    public void setPropVolFino(double propVolFino) {
        this.propVolFino = propVolFino;
    }

    public double getPropVolGrueso() {
        return propVolGrueso;
    }

    public void setPropVolGrueso(double propVolGrueso) {
        this.propVolGrueso = propVolGrueso;
    }

    public double getComprarCemento() {
        return comprarCemento;
    }

    public void setComprarCemento(double comprarCemento) {
        this.comprarCemento = comprarCemento;
    }

    public double getComprarArena() {
        return comprarArena;
    }

    public void setComprarArena(double comprarArena) {
        this.comprarArena = comprarArena;
    }

    public double getComprarPiedrin() {
        return comprarPiedrin;
    }

    public void setComprarPiedrin(double comprarPiedrin) {
        this.comprarPiedrin = comprarPiedrin;
    }

    public double getComprarAgua() {
        return comprarAgua;
    }

    public void setComprarAgua(double comprarAgua) {
        this.comprarAgua = comprarAgua;
    }

    public double getCostalFino() {
        return costalFino;
    }

    public void setCostalFino(double costalFino) {
        this.costalFino = costalFino;
    }

    public double getCostalGrueso() {
        return costalGrueso;
    }

    public void setCostalGrueso(double costalGrueso) {
        this.costalGrueso = costalGrueso;
    }

    public double getCostalAgua() {
        return costalAgua;
    }

    public void setCostalAgua(double costalAgua) {
        this.costalAgua = costalAgua;
    }
}
