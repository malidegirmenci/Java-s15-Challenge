package com.workintech.app.library.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Helper {
    public static LocalDate convertLD(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, formatter);
    }
}