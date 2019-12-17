package com.woodlabs.controllers;

import com.woodlabs.dto.AddressDto;
import com.woodlabs.services.interfaces.AddressService;
import com.woodlabs.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/admin/address")
@Slf4j
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/delete")
    public String delete(Integer id) {
        AddressDto addressDto = new AddressDto();
        addressDto.setAddressId(id);
        addressService.delete(addressDto);
        return "redirect:";
    }

    @GetMapping
    public String main(Model model) {
        List<AddressDto> addressDtos = addressService.findAll();
        model.addAttribute("addresses", addressDtos);
        return "address/addressMain";
    }

    @GetMapping("/create")
    public String create(@Valid @ModelAttribute("address") AddressDto updatedDto, BindingResult result, Model model) {
        model.addAttribute("address", new AddressDto());
        return "address/addressCreate";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("address")AddressDto updatedDto, BindingResult result, @RequestParam Map<String, String> allRequestParams, HttpServletRequest request, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("address", updatedDto);
            log.warn(result.getAllErrors().toString());
            model.addAttribute(result);
            return "address/addressCreate";
        }
        if (Util.isNumeric(allRequestParams.get("id"))) {
            AddressDto addressDto = addressService.findById(Integer.parseInt(allRequestParams.get("addressId")));
            if (addressDto != null) {
                log.warn("client with id = {} already exists", allRequestParams.get("id"));
            } else {
                addressService.add(updatedDto);
            }
        } else {
            addressService.add(updatedDto);
        }
        return "redirect:";
    }

    @GetMapping("/update")
    public String update(@RequestParam Integer addressId, Model model) {
        AddressDto addressDto = addressService.findById(addressId);
        model.addAttribute("address", addressDto);
        return "address/addressUpdate";
    }

    @PostMapping("/update")
    public String update(@Valid AddressDto updatedDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("address", updatedDto);
            log.warn(result.getAllErrors().toString());
            model.addAttribute(result);
            return "address/addressUpdate";
        }
        addressService.add(updatedDto);
        return "redirect:";
    }
}
