package com.scrumbusters.hack2progress.Model;

import java.util.ArrayList;
import java.util.List;

public class Perfil {

    private List<ElementoConfigurable> elementos;
    private String codigoTarjeta;
    private String name;
    public enum Estado{ACTIVADO,DESACTIVADO}
    private Estado estado;


    public Perfil(String name){
        elementos = new ArrayList<>();
        codigoTarjeta = null;
        this.name = name;
        estado = Estado.DESACTIVADO;
    }

    public List<ElementoConfigurable> getElementos() {
        return elementos;
    }

    public void setElementos(List<ElementoConfigurable> elementos) {
        this.elementos = elementos;
    }

    public String getCodigoTarjeta() {
        return codigoTarjeta;
    }

    public void setCodigoTarjeta(String codigoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void addElemento(ElementoConfigurable ele){
        elementos.add(ele);
    }

    public void removeElemento (ElementoConfigurable ele){
        elementos.remove(ele);
    }
}
