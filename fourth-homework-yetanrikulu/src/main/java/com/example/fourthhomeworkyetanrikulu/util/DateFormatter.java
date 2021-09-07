package com.example.fourthhomeworkyetanrikulu.util;

import java.time.LocalDate;

public class DateFormatter {

    public static LocalDate convertStringToLocalDate(String date){
        return LocalDate.parse(date);
    }
}
