package org.example;

public class Cup extends Dish {
    private boolean handle;

    public Cup(String name, int id, double volume, boolean handle) {
        super(name, id, volume);
        this.handle = handle;
    }

    public boolean hasHandle() { return handle; }

    @Override
    public String toString() {
        return super.toString() + ", handle=" + handle + "}";
    }
}
