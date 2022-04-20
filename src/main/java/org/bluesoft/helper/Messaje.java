package org.bluesoft.helper;

public class Messaje {
    private String messaje;

    public Messaje(String messaje) {
        this.messaje = messaje;
    }

    public Messaje() {
    }

    public String getMessaje() {
        return messaje;
    }

    public void setMessaje(String messaje) {
        this.messaje = messaje;
    }

    @Override
    public String toString() {
        return "Messaje [messaje=" + messaje + "]";
    }
}
