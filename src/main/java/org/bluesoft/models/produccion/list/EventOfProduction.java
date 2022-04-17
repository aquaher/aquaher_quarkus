package org.bluesoft.models.produccion.list;

public enum EventOfProduction {
    PROD("PLANTA EN PRODUCCIÓN"),
    STOP("PLANTA DETENIDA"),
    FLUXING("FLUXING"),
    RECEIVED_TURN("RECIBO TURNO"),
    GIVE_TURN("ENTREGO TURNO"),
    CLEAN("ASEO"),
    DESINFECTION("DESINFECCION"),
    BACKWASH("RETROLAVADOS"),
    DOSAGE("DOSIFICACION");
    
    public String label;
    private EventOfProduction(String label) {
        this.label = label;
    }

}
