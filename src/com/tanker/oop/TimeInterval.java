package com.tanker.oop;

public class TimeInterval {

    /*
    * 1. Создать класс, описывающий промежуток времени.
    * Сам промежуток времени должен задаваться тремя свойствами:
    * секундами, минутами и часам.
    *
    * Создать метод для получения полного количества секунд в объекте   +
    *
    * Создать два конструктора:
    * первый принимает общее количество секунд,
    *
    * второй - часы, минуты и секунды по отдельности.
    *
    * Создать метод для вывода данных.
    * */

    private int seconds;
    private int minutes;
    private int hours;

    TimeInterval(int seconds){ this.seconds = seconds;}

    TimeInterval(int seconds, int minutes, int hours){ this.seconds = seconds; this.minutes = minutes; this.hours = hours;}

    public void getSeconds(){
        System.out.println(this.seconds + this.minutes * 60 + this.hours * 3600);
        System.out.println();
    }

    public void getData(){
        System.out.println("current data: " + seconds + "sec. " + minutes + "min. " + hours + "hours.");
        System.out.println();
    }


}
