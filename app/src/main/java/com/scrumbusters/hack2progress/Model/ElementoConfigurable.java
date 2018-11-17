package com.scrumbusters.hack2progress.Model;

public abstract class ElementoConfigurable {
    private Grupo grupoPadre;
    private String nombre;
    private String descripcion;
    private String icono;
    private boolean heredaConfiguracion;
    //private Configuracion config;

    public ElementoConfigurable(String nombre, String icono, String descripcion, Grupo grupoPadre, boolean heredaConfiguracion){
        this.nombre = nombre;
        this.icono = icono;
        this.descripcion = descripcion;
        this.grupoPadre = grupoPadre;
        this.heredaConfiguracion = heredaConfiguracion;
        //this.config = config;
    }

    public Grupo getGrupoPadre() {
        return grupoPadre;
    }

    public void setGrupoPadre(Grupo grupoPadre) {
        this.grupoPadre = grupoPadre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

}
