package ru.Kirpikov.box;

public class Box <T> {
    private T value;

    public void put(T value) {
        if (this.value != null) {
            throw new RuntimeException("Коробка уже занята!");
        }
        this.value = value;
    }

    public T get() {
        if (this.value == null) {
            throw new RuntimeException("Коробка пуста!");
        }
        T temp = this.value;
        this.value = null;
        return temp;
    }

    public boolean isEmpty() {
        return this.value == null;
    }
}
