package de.hoellriegl.hypixel;

import zone.nora.slothpixel.Slothpixel;

public class Hypixel {
    private static Hypixel instance;

    private Slothpixel slothpixel;

    // Singleton
    public static synchronized Hypixel getInstance() {
        if(Hypixel.instance == null) {
            Hypixel.instance = new Hypixel();
        }
        return Hypixel.instance;
    }

    private Hypixel() {

    }

    /********************************************
     * Getter / Setter
     ********************************************/
    public Slothpixel getSlothpixel() {
        return slothpixel;
    }

    public void setSlothpixel(Slothpixel slothpixel) {
        this.slothpixel = slothpixel;
    }
}
