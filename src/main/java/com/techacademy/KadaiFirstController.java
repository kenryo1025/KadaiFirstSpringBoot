package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {
    @GetMapping("/dayofweek/{yyyymmdd}")
    public String dispDayOfWeek(@PathVariable String yyyymmdd) {
        String dayOfWeek = getDayOfWeek(yyyymmdd);

       return dayOfWeek;


    }

    private String getDayOfWeek(String yyyymmdd) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

            LocalDate date=LocalDate.parse(yyyymmdd,formatter);

            DayOfWeek dayOfWeek = date.getDayOfWeek();

            return dayOfWeek.toString();
        }catch(DateTimeParseException e) {
            return null;
        }
    }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1 ,@PathVariable int val2) {
        int res=0;
        res= val1 +val2;
        return "計算結果："+res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1 ,@PathVariable int val2) {
        int res=0;
        res= val1-val2;
        return "計算結果："+res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1 ,@PathVariable int val2) {
        int res=0;
        res= val1 *val2;
        return "計算結果："+res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1 ,@PathVariable int val2) {
        int res=0;
        res= val1/val2;
        return "計算結果："+res;
    }
}


