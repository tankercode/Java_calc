package com.tanker.ink;

public class ComOrg {

    public static Comp comp0
            = new Comp(new Ram(1000), new Ssd(10));

    public static Comp comp1
            = new Comp(new Ram(1020), new Ssd(13));

    public static void main(String[] args) {
        comp0.getParams();
        comp1.getParams();
    }
}
