package com.example.thebarberdacristian;

public class Intervallo {
    int oraInizio, minutiInizio;
    boolean prenotato;
    String personaPrenotata;

    public Intervallo(int _ora, int _min, boolean _stato, String persona) {
        oraInizio = _ora;
        minutiInizio = _min;
        prenotato = _stato;
        personaPrenotata = persona;
    }

    public int getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(int oraInizio) {
        this.oraInizio = oraInizio;
    }

    public int getMinutiInizio() {
        return minutiInizio;
    }

    public void setMinutiInizio(int minutiInizio) {
        this.minutiInizio = minutiInizio;
    }

    public boolean isPrenotato() {
        return prenotato;
    }

    public void setPrenotato(boolean prenotato) {
        this.prenotato = prenotato;
    }

    public String getPersonaPrenotata() {
        return personaPrenotata;
    }

    public void setPersonaPrenotata(String personaPrenotata) {
        this.personaPrenotata = personaPrenotata;
    }


}
