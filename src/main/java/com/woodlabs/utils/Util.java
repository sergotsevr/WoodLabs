package com.woodlabs.utils;

import com.woodlabs.dto.AddressDto;
import com.woodlabs.entities.Address;
import com.woodlabs.services.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.NumberFormat;
import java.text.ParsePosition;

@Slf4j
public class Util {
    @Autowired
    static AddressService addressService;

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
    public static AddressDto findAddress(Integer id){
        return addressService.findById(id);
    }

}
