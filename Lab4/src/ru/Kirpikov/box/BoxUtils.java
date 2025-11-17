package ru.Kirpikov.box;

import java.util.Random;

public class BoxUtils {
    public static void putRandomPoint(Box<? super Coordinates3D> box) {

        Random rand = new Random();

        Coordinates3D point = new Coordinates3D(
                rand.nextInt(100),
                rand.nextInt(100),
                rand.nextInt(100)
        );

        box.put(point);
        System.out.println("В коробку помещена точка: " + point);
    }
}
