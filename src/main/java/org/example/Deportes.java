package org.example;

public class Deportes {
    String nombre;
    int jugadores;
    float anchoCancha,largoCancha;

    boolean contacto;

    public Deportes(String nombre, int jugadores, float anchoCancha, float largoCancha, boolean contacto) {
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.anchoCancha = anchoCancha;
        this.largoCancha = largoCancha;
        this.contacto = contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getJugadores() {
        return jugadores;
    }

    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }

    public float getAnchoCancha() {
        return anchoCancha;
    }

    public void setAnchoCancha(float anchoCancha) {
        this.anchoCancha = anchoCancha;
    }

    public float getLargoCancha() {
        return largoCancha;
    }

    public void setLargoCancha(float largoCancha) {
        this.largoCancha = largoCancha;
    }

    public boolean isContacto() {
        return contacto;
    }

    public void setContacto(boolean contacto) {
        this.contacto = contacto;
    }
}
