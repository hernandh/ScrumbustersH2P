package com.scrumbusters.hack2progress.Model;

import java.util.List;

public class Grupo extends ElementoConfigurable{
    private List<ElementoConfigurable> listaElementos;

    public Grupo(String nombre, String icono, String descripcion, Grupo grupoPadre, boolean heredaConfiguracion, Configuracion config) {
        super(nombre, icono, descripcion, grupoPadre, heredaConfiguracion, config);

        isGroup = true;
    }

    public List<ElementoConfigurable> getListaElementos() {
        return listaElementos;
    }

    public void anhadirElementoALista(ElementoConfigurable elem) {
        listaElementos.add(elem);
    }

    public void borrarElementoDeLista(ElementoConfigurable elem) {
        listaElementos.remove(elem);
    }
}
