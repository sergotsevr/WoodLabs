package com.woodlabs.controllers;

import com.woodlabs.dto.ClientDto;
import com.woodlabs.entities.Client;
import com.woodlabs.entities.enums.Role;
import com.woodlabs.services.interfaces.ClientService;
import com.woodlabs.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Controller
@Slf4j
public class MainController {
    @Autowired
    ClientService clientService;

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
    public String addClient(ClientDto updatedDto, Map<String, Object> model){
        if(updatedDto.getClientId()!=null) {
            ClientDto clientFromDb = clientService.findById(updatedDto.getClientId());
            if (clientFromDb != null) {
                model.put("message", "user exists");
                return "login/registration";
            }
        }
       /// ClientDto clientDto = Mapper.toClientDto(updatedDto);
        ClientDto clientDto = updatedDto;
        clientDto.setActive(true);
        clientDto.setRoles(Collections.singleton(Role.USER));
        clientService.add(clientDto);

        return "redirect:login/login";
    }
}
