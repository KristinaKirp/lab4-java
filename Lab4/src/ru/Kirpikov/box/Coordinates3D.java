package ru.Kirpikov.box;

public class Coordinates3D extends Coordinates2D {
    private int z;

    public Coordinates3D (int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    // Геттер и сеттер для z
    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }

}
