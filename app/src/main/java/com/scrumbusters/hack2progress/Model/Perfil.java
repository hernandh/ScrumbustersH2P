package com.scrumbusters.hack2progress.Model;

import java.util.ArrayList;
import java.util.List;

public class Perfil {

    private List<ElementoConfigurable> elementos;
    private String codigoTarjeta;

    public Perfil(){
        elementos = new ArrayList<>();
        codigoTarjeta = null;
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

    public void addElemento(ElementoConfigurable ele){
        elementos.add(ele);
    }

    public void removeElemento (ElementoConfigurable ele){
        elementos.remove(ele);
    }
}
