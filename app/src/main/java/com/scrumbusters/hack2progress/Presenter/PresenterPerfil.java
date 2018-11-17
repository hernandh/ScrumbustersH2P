package com.scrumbusters.hack2progress.Presenter;

import com.scrumbusters.hack2progress.Model.ElementoConfigurable;
import com.scrumbusters.hack2progress.Model.Perfil;

import java.util.ArrayList;
import java.util.List;

public class PresenterPerfil {

    private List<Perfil> perfiles;

    public PresenterPerfil(){
        perfiles = new ArrayList<>();
    }

    public void addPerfil(String name){
        perfiles.add(new Perfil(name));
    }

    public void deletePerfil(Perfil perfil){
        perfiles.remove(perfil);
    }

    public void addElemento(Perfil perfil, ElementoConfigurable elemento){
        perfil.addElemento(elemento);
    }
}
