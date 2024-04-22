package com.tanker.ink;

public class Comp {

    private final Ram ram;
    private final Ssd ssd;

    public Comp(Ram ram, Ssd ssd) {
        this.ram = ram;
        this.ssd = ssd;
    }

    public void getParams(){
        System.out.println("ram: " + ram.getValue() + " ssd: " + ssd.getValue());
    }
}
