package com.woodlabs.controllers;

import com.woodlabs.dto.AddressDto;
import com.woodlabs.dto.ClientDto;
import com.woodlabs.entities.enums.Role;
import com.woodlabs.services.interfaces.AddressService;
import com.woodlabs.services.interfaces.CategoryService;
import com.woodlabs.services.interfaces.CharacteristicsService;
import com.woodlabs.services.interfaces.ClientService;
import com.woodlabs.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/admin/client")
@Slf4j
public class ClientController {

    @Autowired
    AddressService addressService;
    @Autowired
    ClientService clientService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CharacteristicsService characteristicsService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/test")
    public String tet(Model model) {
        List<ClientDto> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "test/test";
    }

    @GetMapping
    public String main(Model model) {
        List<ClientDto> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "client/clientMain";
    }

    @GetMapping("/create")
    public String create(@Valid @ModelAttribute("client") ClientDto updatedDto, BindingResult result, Model model) {
        model.addAttribute("client", new ClientDto());
        return "client/clientCreate";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("client") ClientDto updatedDto, BindingResult result, @RequestParam Map<String, String> allRequestParams, HttpServletRequest request, Model model) {

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
        return "redirect:";
    }

    @GetMapping("/clientUpdate")
    public String updateView(@RequestParam Integer id, Model model) {
        ClientDto clientDto = clientService.findById(id);
        model.addAttribute("client", clientDto);
        return "client/clientUpdate";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("client") ClientDto updatedDto, BindingResult result, @RequestParam Map<String, String> allRequestParams, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("client", updatedDto);
            log.warn(result.getAllErrors().toString());
            model.addAttribute(result);
            return "client/clientUpdate";
        }
        ClientDto clientDto = clientService.findById(updatedDto.getClientId());
        if (clientDto != null) {
            try {
                AddressDto addressDto = addressService.findById(Integer.parseInt(allRequestParams.get("AddressId")));
                updatedDto.setAddressDto(addressDto);
            } catch (Exception e) {
                log.info(clientDto.toString());
                log.info("attempt to update client with wrong addressID");
            }
            clientService.update(updatedDto);
            model.addAttribute("client", clientDto);
            return "redirect:";
        }
        return "client/clientUpdate";
    }

    @GetMapping("/delete")
    public String delete(Integer id) {
        ClientDto clientDto = new ClientDto();
        clientDto.setClientId(id);
        clientService.delete(clientDto);
        return "redirect:";
    }
}
