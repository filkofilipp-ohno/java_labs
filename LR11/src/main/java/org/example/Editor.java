package org.example;

public class Editor extends Software {
    private String format;
    private boolean free;

    public Editor(String name, String version, double price, String format, boolean free) {
        super(name, version, price);
        this.format = format;
        this.free = free;
    }

    @Override
    public String getRequirements() {
        return "Низкие требования";
    }

    public void install(String path, String language) {
        System.out.println("Устанавливаю редактор в " + path
                + " с языком " + language);
    }

    public void install(int size, boolean portable) {
        System.out.println("Устанавливаю редактор размером " + size
                + " ГБ" + (portable ? " (portable-версия)" : ""));
    }

    @Override
    public String toString() {
        return "Editor{name='" + getName() + "', version='" + getVersion()
                + "', price=" + getPrice() + ", format='" + format
                + "', free=" + free + "}";
    }
}
