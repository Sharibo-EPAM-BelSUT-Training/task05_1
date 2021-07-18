package gmail.alexejkrawez;

/**
 * @name Java.SE.05-1
 * @package gmail.alexejkrawez;
 * @file Main.java
 * @author Alexej Krawez
 * @email AlexejKrawez@gmail.com
 * @created 03.01.2019
 * @version 1.0
 */

import gmail.alexejkrawez.production.Conveyor;
import gmail.alexejkrawez.production.Detail;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Detail d1 = new Detail(1, 1, 5);
        Detail d2 = new Detail(2, 6, 4);
        Detail d3 = new Detail(3, 2, 3);
        Detail d4 = new Detail(4, 6, 3);
        Detail d5 = new Detail(5, 9, 1);
        Detail d6 = new Detail(6, 4, 5);
        Detail d7 = new Detail(7, 2, 2);
        Detail d8 = new Detail(8, 7, 7);

        Conveyor conveyor = new Conveyor(d1, d2, d3, d4, d5, d6, d7, d8);
        System.out.println(conveyor.getDetailList());
        LinkedList<Detail> finishedList = conveyor.algorithmJohnsons();
        System.out.println(finishedList);
        System.out.println(conveyor.productionTime(finishedList));

    }
}
