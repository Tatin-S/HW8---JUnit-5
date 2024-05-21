package org.stepik.data;

public enum Language {
    RU("Русский","Поиск дешевых авиабилетов онлайн!"),
    EN("English","Find your flight");

    public final String language;
    public final String title;

    Language(String language, String title) {
        this.language = language;
        this.title = title;
    }
}