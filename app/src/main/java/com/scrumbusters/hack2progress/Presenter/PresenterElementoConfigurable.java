package com.scrumbusters.hack2progress.Presenter;

import com.scrumbusters.hack2progress.Model.Bombilla;
import com.scrumbusters.hack2progress.Model.Configuracion;
import com.scrumbusters.hack2progress.Model.ElementoConfigurable;
import com.scrumbusters.hack2progress.Model.Enchufe;
import com.scrumbusters.hack2progress.Model.Grupo;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PresenterElementoConfigurable {
    private Map<Integer, ElementoConfigurable> elementos;

    public PresenterElementoConfigurable(){
        elementos = new HashMap<Integer, ElementoConfigurable>();
    }

    public List<Grupo> getGruposRaiz(){
        ArrayList<Grupo> gruposRaiz = new ArrayList<Grupo>();
        for (ElementoConfigurable e : elementos.values()){
            Grupo padre = e.getGrupoPadre();
            if(padre == null){
                gruposRaiz.add(padre);
            }
        }

        return gruposRaiz;
    }

    public List<ElementoConfigurable> listHijos(int id){
        ElementoConfigurable ec = elementos.get(id);

        if(ec.isGroup()){
            return ((Grupo) ec).getListaElementos();
        } else {
            throw new InvalidParameterException("El elemento no es de tipo grupo.");
        }
    }

    public void deleteElemento(int id){
        elementos.remove(id);
    }

    public void editElement(int id, String nombre, String icono, String descripcion, Grupo grupoPadre,
                            boolean heredaConfiguracion){
        ElementoConfigurable ec = elementos.get(id);
        ec.setNombre(nombre);
        ec.setIcono(icono);
        ec.setDescripcion(descripcion);
        ec.setGrupoPadre(grupoPadre);
        ec.setHeredaConfiguracion(heredaConfiguracion);

    }

    public void createGrupo(String nombre, String icono, String descripcion, Grupo grupoPadre,
                            boolean heredaConfiguracion, Configuracion config){
        ElementoConfigurable ec = new Grupo(nombre, icono, descripcion, grupoPadre, heredaConfiguracion, config);
        elementos.put(ec.getId(), ec);
    }

    public void createBombilla(String nombre, String icono, String descripcion, Grupo grupoPadre,
                               boolean heredaConfiguracion, Configuracion config){
        ElementoConfigurable ec = new Bombilla(nombre, icono, descripcion, grupoPadre, heredaConfiguracion, config);
        elementos.put(ec.getId(), ec);
    }

    public void createEnchufe(String nombre, String icono, String descripcion, Grupo grupoPadre,
                              boolean heredaConfiguracion, Configuracion config){
        ElementoConfigurable ec = new Enchufe(nombre, icono, descripcion, grupoPadre, heredaConfiguracion, config);
        elementos.put(ec.getId(), ec);
    }

}
