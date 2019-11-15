package com.woodlabs.controllers;

import com.woodlabs.dto.AddressDto;
import com.woodlabs.dto.ClientDto;
import com.woodlabs.services.AddressService;
import com.woodlabs.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/admin/address")
@Slf4j
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public String main(Model model) {
        List<AddressDto> addressDtos = addressService.findAll();
        model.addAttribute("addresses", addressDtos);
        return "address/addressMain";
    }
    @GetMapping("/create")
    public String create() {
        return "address/addressCreate";
    }

    @PostMapping("/create")
    public String create(AddressDto updatedDto, @RequestParam Map<String, String> allRequestParams, HttpServletRequest request, Model model) {

        if (Util.isNumeric(allRequestParams.get("id"))) {
            AddressDto addressDto = addressService.findById(Integer.parseInt(allRequestParams.get("addressId")));
            if (addressDto != null) {
                log.warn("client with id = {} already exists", allRequestParams.get("id"));
            }
            else {
                addressService.add(updatedDto);
            }
        }
        else {
            addressService.add(updatedDto);
        }
        return "redirect:";
    }
}
