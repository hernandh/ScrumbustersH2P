package com.scrumbusters.hack2progress.Presenter;

import com.scrumbusters.hack2progress.Model.Configuracion;
import com.scrumbusters.hack2progress.Model.ConfiguracionIndividual;
import com.scrumbusters.hack2progress.Model.ConfiguracionPredefinida;
import com.scrumbusters.hack2progress.Model.Planning;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class PresenterConfiguraciones {

    private List<ConfiguracionPredefinida> configuraciones;

    public PresenterConfiguraciones(){
        configuraciones = new ArrayList<>();
    }

    public List<ConfiguracionPredefinida> getConfiguraciones(){
        return configuraciones;
    }

    public void addPlanning(Configuracion config,List<String> dias, Time horaEncendido, Time horaApagado){
        config.addPlanning(new Planning(dias,horaEncendido,horaApagado));
    }

    public void removePlanning(Configuracion config,Planning planning){
        config.deletePlanning(planning);
    }

    public void createConfiguracionPredefinida(List<Planning> plannings,String name){
        configuraciones.add(new ConfiguracionPredefinida(plannings,name));
    }

    public ConfiguracionIndividual createConfiguracionIndividual(List<Planning> plannings){
        return new ConfiguracionIndividual(plannings);
    }

    public void eliminateConfig(ConfiguracionPredefinida config){
        configuraciones.remove(config);
    }

    public void editarPlanning(Planning planning,List<String> dias,Time horaEncendido,Time horaApagado) {
        planning.setDias(dias);
        planning.setHoraApagado(horaApagado);
        planning.setHoraEncendido(horaEncendido);
    }
    public void editarConfig(ConfiguracionPredefinida config,String name){
        config.setName(name);
    }
}
