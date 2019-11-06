package com.woodlabs.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.NumberFormat;
import java.text.ParsePosition;

@Slf4j
public class Util {
    public static boolean isNumeric(String str)
    {
        try {
            NumberFormat formatter = NumberFormat.getInstance();
            ParsePosition pos = new ParsePosition(0);
            formatter.parse(str, pos);
            return str.length() == pos.getIndex();
        }
        catch (NullPointerException np){
            log.debug("null string");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
