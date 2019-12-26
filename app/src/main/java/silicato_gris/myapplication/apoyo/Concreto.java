package silicato_gris.myapplication.apoyo;

public class Concreto {

    private int id;
    private String nombreProyecto;
    private String resistencia;
    private String asentamiento;
    private String tmn;
    private String relAC;
    private String propUniCemento;
    private String propUniFino;
    private String propUniGrueso;
    private String propUniAgua;
    private String propVolFino;
    private String propVolGrueso;
    private String costalFino;
    private String costalGrueso;
    private String costalAgua;


    public Concreto(int id, String nombreProyecto, String resistencia, String asentamiento, String tmn,
                    String relAC, String propUniCemento, String propUniFino, String propUniGrueso, String propUniAgua,
                    String propVolFino, String propVolGrueso, String costalFino, String costalGrueso, String costalAgua) {
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.resistencia = resistencia;
        this.asentamiento = asentamiento;
        this.tmn = tmn;
        this.relAC = relAC;
        this.propUniCemento = propUniCemento;
        this.propUniFino = propUniFino;
        this.propUniGrueso = propUniGrueso;
        this.propUniAgua = propUniAgua;
        this.propVolFino = propVolFino;
        this.propVolGrueso = propVolGrueso;
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

    public String getResistencia() {
        return resistencia;
    }

    public void setResistencia(String resistencia) {
        this.resistencia = resistencia;
    }

    public String getAsentamiento() {
        return asentamiento;
    }

    public void setAsentamiento(String asentamiento) {
        this.asentamiento = asentamiento;
    }

    public String getTmn() {
        return tmn;
    }

    public void setTmn(String tmn) {
        this.tmn = tmn;
    }

    public String getRelAC() {
        return relAC;
    }

    public void setRelAC(String relAC) {
        this.relAC = relAC;
    }

    public String getPropUniCemento() {
        return propUniCemento;
    }

    public void setPropUniCemento(String propUniCemento) {
        this.propUniCemento = propUniCemento;
    }

    public String getPropUniFino() {
        return propUniFino;
    }

    public void setPropUniFino(String propUniFino) {
        this.propUniFino = propUniFino;
    }

    public String getPropUniGrueso() {
        return propUniGrueso;
    }

    public void setPropUniGrueso(String propUniGrueso) {
        this.propUniGrueso = propUniGrueso;
    }

    public String getPropUniAgua() {
        return propUniAgua;
    }

    public void setPropUniAgua(String propUniAgua) {
        this.propUniAgua = propUniAgua;
    }

    public String getPropVolFino() {
        return propVolFino;
    }

    public void setPropVolFino(String propVolFino) {
        this.propVolFino = propVolFino;
    }

    public String getPropVolGrueso() {
        return propVolGrueso;
    }

    public void setPropVolGrueso(String propVolGrueso) {
        this.propVolGrueso = propVolGrueso;
    }

    public String getCostalFino() {
        return costalFino;
    }

    public void setCostalFino(String costalFino) {
        this.costalFino = costalFino;
    }

    public String getCostalGrueso() {
        return costalGrueso;
    }

    public void setCostalGrueso(String costalGrueso) {
        this.costalGrueso = costalGrueso;
    }

    public String getCostalAgua() {
        return costalAgua;
    }

    public void setCostalAgua(String costalAgua) {
        this.costalAgua = costalAgua;
    }
}