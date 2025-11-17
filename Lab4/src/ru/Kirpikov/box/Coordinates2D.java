package ru.Kirpikov.box;

public class Coordinates2D {
    private int x;
    private int y;


    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Coordinates2D (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinates2D other = (Coordinates2D) obj;
        return this.x == other.x && this.y == other.y;
    }
}
