package com.castlebell.lingvo.work.util;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateFormatter {

    private static final DateTimeFormatter defaultFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd (E) ");
    private static final DateTimeFormatter shortFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");

    /**
     * Returns current date in format yyyy.MM.dd (E)
     * @return
     */
    public static String formatCurrentDate() {
        return formatCurrentDate(defaultFormatter);
    }

    /**
     * Returns current date in format dd-MM-yyyy
     * @return
     */
    public static String formatShortDate() {
        return formatCurrentDate(shortFormatter);
    }

    /**
     * Returns current date in format MMMM dd, yyyy
     * @return
     */
    public static String formatCustomDate() {
        return formatCurrentDate(customFormatter);
    }

    public static String formatCurrentDate(DateTimeFormatter formatter) {
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(formatter);

        String dayOfWeek = currentDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.getDefault());
        return formattedDate.replace("Today", dayOfWeek);
    }
}