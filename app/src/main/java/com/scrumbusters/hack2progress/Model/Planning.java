package com.scrumbusters.hack2progress.Model;

import java.sql.Time;
import java.util.List;

public class Planning {

    private List<String> dias;
    private Time horaEncendido;
    private Time horaApagado;

    public Planning(List<String> dias,Time horaEncendido,Time horaApagado){
        this.dias = dias;
        this.horaEncendido = horaEncendido;
        this.horaApagado = horaApagado;
    }

    public List<String> getDias() {
        return dias;
    }

    public void setDias(List<String> dias) {
        this.dias = dias;
    }

    public Time getHoraEncendido() {
        return horaEncendido;
    }

    public void setHoraEncendido(Time horaEncendido) {
        this.horaEncendido = horaEncendido;
    }

    public Time getHoraApagado() {
        return horaApagado;
    }

    public void setHoraApagado(Time horaApagado) {
        this.horaApagado = horaApagado;
    }
}
