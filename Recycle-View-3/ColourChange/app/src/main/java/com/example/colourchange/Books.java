package com.example.colourchange;

public class Books {
    private String name;
    private boolean isSelected;

    public Books(String name, boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;

    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
