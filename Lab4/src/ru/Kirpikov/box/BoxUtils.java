package ru.Kirpikov.box;

import java.util.Scanner;

public class BoxUtils {
    public static void putRandomPoint(Box<? super Coordinates3D> box) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите X: ");
        int x = scanner.nextInt();

        System.out.print("Введите Y: ");
        int y = scanner.nextInt();

        System.out.print("Введите Z: ");
        int z = scanner.nextInt();

        Coordinates3D point = new Coordinates3D(x, y, z);

        box.put(point);
        System.out.println("В коробку помещена точка: " + point);
    }
}

