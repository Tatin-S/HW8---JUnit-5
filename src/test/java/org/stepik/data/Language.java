package org.stepik.data;

public enum Language {
    Русский("Поиск дешевых авиабилетов онлайн!"),
    English("Find your flight");

    public final String description;

    Language(String description) {
        this.description = description;
    }
}