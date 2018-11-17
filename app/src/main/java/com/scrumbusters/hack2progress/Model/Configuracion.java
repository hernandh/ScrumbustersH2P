package com.scrumbusters.hack2progress.Model;

import java.util.List;

public abstract class Configuracion {

    private List<Planning> plannings;

    public Configuracion(List<Planning> plannigs){
        this.plannings = plannigs;
    }

    public List<Planning> getPlannings(){
        return plannings;
    }

    public void setPlannings(List<Planning> plannings){
        this.plannings = plannings;
    }

    public void addPlanning(Planning plan){
        plannings.add(plan);
    }

    public void deletePlanning(Planning plan){
        plannings.remove(plan);
    }

}
