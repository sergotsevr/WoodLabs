package com.woodlabs.controllers;

import com.woodlabs.dto.AddressDto;
import com.woodlabs.dto.ClientDto;
import com.woodlabs.entities.Client;
import com.woodlabs.entities.enums.Role;
import com.woodlabs.services.interfaces.AddressService;
import com.woodlabs.services.interfaces.ClientService;
import com.woodlabs.utils.Mapper;
import com.woodlabs.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Controller
@Slf4j
public class MainController {
    @Autowired
    ClientService clientService;
    @Autowired
    AddressService addressService;

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/registration")
    public String Registration(Model model){
        model.addAttribute("client", new ClientDto());
        return "login/registration";
    }
    @PostMapping("/registration" )
    public String addClient(@Valid @ModelAttribute("client") ClientDto updatedDto, BindingResult result, @RequestParam Map<String, String> allRequestParams, HttpServletRequest request, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("client", updatedDto);
            log.warn(result.getAllErrors().toString());
            model.addAttribute(result);
            return "client/clientCreate";
        }
        if (Util.isNumeric(allRequestParams.get("id"))) {
            ClientDto clientDto = clientService.findById(Integer.parseInt(allRequestParams.get("id")));
            if (clientDto != null) {
                log.warn("client with id = {} already exists", allRequestParams.get("id"));
                return "client/clientMain";
            }
        }
        updatedDto.getFirstName();
        updatedDto.setRoles(Collections.singleton(Role.USER));
        try {
            AddressDto addressDto = addressService.findById(Integer.parseInt(allRequestParams.get("AddressId")));
            updatedDto = clientService.add(updatedDto);
            updatedDto.setAddressDto(addressDto);
        } catch (NumberFormatException e) {
            log.info("attempt to write incorrect addressId for client = {}", updatedDto);
        }
        updatedDto.setActive(true);
        clientService.add(updatedDto);
        model.addAttribute("client", updatedDto);
        return "rederict:";
    }
}
