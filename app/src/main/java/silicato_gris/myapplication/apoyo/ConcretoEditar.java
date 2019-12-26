package silicato_gris.myapplication.apoyo;

public class ConcretoEditar {
    private int id;
    private String nombreProyecto;
    private String resistencia;
    private String factor;
    private String asentamiento;
    private String tmn;
    private String pesoConcreto;
    private String pesoFinoSuelto;
    private String pesofinoCompacto;
    private String pesoGruesoSuelto;
    private String pesoGruesoComacto;
    private String relAC;
    private String propUniCemento;
    private String propUniAgregados;
    private String propUniFino;
    private String propUniGrueso;
    private String propUniAgua;
    private String propVolFino;
    private String propVolGrueso;
    private String comprarCemento;
    private String comprarArena;
    private String comprarPiedrin;
    private String comprarAgua;
    private String costalFino;
    private String costalGrueso;
    private String costalAgua;
    private String volumen;

    public ConcretoEditar(int id, String nombreProyecto, String resistencia, String factor, String asentamiento, String tmn, String pesoConcreto, String pesoFinoSuelto, String pesofinoCompacto, String pesoGruesoSuelto, String pesoGruesoComacto, String relAC, String propUniCemento, String propUniAgregados, String propUniFino, String propUniGrueso, String propUniAgua, String propVolFino, String propVolGrueso, String comprarCemento, String comprarArena, String comprarPiedrin, String comprarAgua, String costalFino, String costalGrueso, String costalAgua, String volumen) {
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
        this.volumen = volumen;
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

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
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

    public String getPesoConcreto() {
        return pesoConcreto;
    }

    public void setPesoConcreto(String pesoConcreto) {
        this.pesoConcreto = pesoConcreto;
    }

    public String getPesoFinoSuelto() {
        return pesoFinoSuelto;
    }

    public void setPesoFinoSuelto(String pesoFinoSuelto) {
        this.pesoFinoSuelto = pesoFinoSuelto;
    }

    public String getPesofinoCompacto() {
        return pesofinoCompacto;
    }

    public void setPesofinoCompacto(String pesofinoCompacto) {
        this.pesofinoCompacto = pesofinoCompacto;
    }

    public String getPesoGruesoSuelto() {
        return pesoGruesoSuelto;
    }

    public void setPesoGruesoSuelto(String pesoGruesoSuelto) {
        this.pesoGruesoSuelto = pesoGruesoSuelto;
    }

    public String getPesoGruesoComacto() {
        return pesoGruesoComacto;
    }

    public void setPesoGruesoComacto(String pesoGruesoComacto) {
        this.pesoGruesoComacto = pesoGruesoComacto;
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

    public String getPropUniAgregados() {
        return propUniAgregados;
    }

    public void setPropUniAgregados(String propUniAgregados) {
        this.propUniAgregados = propUniAgregados;
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

    public String getComprarCemento() {
        return comprarCemento;
    }

    public void setComprarCemento(String comprarCemento) {
        this.comprarCemento = comprarCemento;
    }

    public String getComprarArena() {
        return comprarArena;
    }

    public void setComprarArena(String comprarArena) {
        this.comprarArena = comprarArena;
    }

    public String getComprarPiedrin() {
        return comprarPiedrin;
    }

    public void setComprarPiedrin(String comprarPiedrin) {
        this.comprarPiedrin = comprarPiedrin;
    }

    public String getComprarAgua() {
        return comprarAgua;
    }

    public void setComprarAgua(String comprarAgua) {
        this.comprarAgua = comprarAgua;
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

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }
}
