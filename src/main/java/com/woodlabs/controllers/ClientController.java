package com.woodlabs.controllers;

import com.woodlabs.dto.AddressDto;
import com.woodlabs.dto.CharacteristicsDto;
import com.woodlabs.dto.ClientDto;
import com.woodlabs.dto.ProductCategoryDto;
import com.woodlabs.entities.Address;
import com.woodlabs.entities.Characteristics;
import com.woodlabs.entities.Client;
import com.woodlabs.entities.ProductCategory;
import com.woodlabs.repositories.AddressRepository;
import com.woodlabs.services.AddressService;
import com.woodlabs.services.CategoryService;
import com.woodlabs.services.CharacteristicsService;
import com.woodlabs.services.ClientService;
import com.woodlabs.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/client")
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
    @GetMapping
    public String main(Model model){
        List<ClientDto> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "clientMain";
    }
    @PostMapping("/create")
    public String create(@RequestParam Map<String, String> allRequestParams, HttpServletRequest request, Model model){
        if (Util.isNumeric(allRequestParams.get("id"))) {
            ClientDto clientDto = clientService.findById(Integer.parseInt(allRequestParams.get("id")));
            if (clientDto!=null) {
                log.warn("client with id = {} already exists", allRequestParams.get("id"));
                return "clientMain";
            }
        }
        ClientDto clientDto = new ClientDto();
        clientDto.setFirstName(allRequestParams.get("FirstName"));
        clientDto.setLastName(allRequestParams.get("LastName"));
        clientDto.setDateOfBirth(LocalDate.parse(allRequestParams.get("DateOfBirth")));
        clientDto.setEmail(allRequestParams.get("email"));
        clientDto.setPassword(allRequestParams.get("Password"));
        try {
            AddressDto addressDto = addressService.findById(Integer.parseInt(allRequestParams.get("AddressId")));
            clientDto = clientService.add(clientDto);
            clientDto.setAddressDto(addressDto);
        }
        catch (NumberFormatException e){
            log.info("attempt to write incorrect addressId for client = {}", clientDto);
        }
        clientService.add(clientDto);
        model.addAttribute("client", clientDto);
        return "redirect:";
    }
    @PostMapping("/update")
    public String update(@RequestParam Map<String, String> allRequestParams, Model model){
        if (Util.isNumeric(allRequestParams.get("id"))) {
            ClientDto clientDto = clientService.findById(Integer.parseInt(allRequestParams.get("id")));
            if (clientDto!=null) {
                clientDto.setClientId(Integer.parseInt(allRequestParams.get("id")));
                clientDto.setFirstName(allRequestParams.get("FirstName"));
                clientDto.setLastName(allRequestParams.get("LastName"));
                clientDto.setDateOfBirth(LocalDate.parse(allRequestParams.get("DateOfBirth")));
                clientDto.setEmail(allRequestParams.get("email"));
                clientDto.setPassword(allRequestParams.get("Password"));
                try {
                    AddressDto addressDto = addressService.findById(Integer.parseInt(allRequestParams.get("AddressId")));
                    clientDto = clientService.update(clientDto);
                    clientDto.setAddressDto(addressDto);
                }
                catch (NumberFormatException e){
                    log.warn("attempt to write incorrect addressId for client = {}", clientDto);
                }
                clientService.update(clientDto);
                model.addAttribute("client", clientDto);
                return "redirect:";
            }
        }
        return "clientUpdate";
    }
    @GetMapping("test")
    public String test( Model model) {
        ClientDto clientDto = clientService.findById(227);
        model.addAttribute("client", clientDto);
       /* ClientDto clientDto = new ClientDto();
        clientDto.setEmail("Gut@man.ru");
        AddressDto address = new AddressDto();
        address.setApartments(12);
        address.setBuilding(45);
        address.setCity("LA");
        address.setCountry("UD");
        address.setStreet("451 av");
        address = addressService.add(address);
        clientDto = clientService.add(clientDto);
        clientDto.setAddressDto(address);
        clientDto.setDateOfBirth(LocalDate.now());
        clientDto.setFirstName("John");
        clientDto.setLastName("Man");
        clientDto.setPassword("1234");
        clientService.update(clientDto);*/
        /*
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        CharacteristicsDto characteristicD = new CharacteristicsDto();
        characteristicD.setCharacteristic("Volume");
        CharacteristicsDto characteristic2D = new CharacteristicsDto();
        characteristic2D.setCharacteristic("price");
        characteristicD = characteristicsService.add(characteristicD);
        characteristic2D = characteristicsService.add(characteristic2D);
        List<Characteristics> cha = new LinkedList<>();
        productCategoryDto = categoryService.add(productCategoryDto);
        productCategoryDto.setCharacteristics(cha);
        cha.add(modelMapper.map(characteristicD, Characteristics.class));
        cha.add(modelMapper.map(characteristic2D, Characteristics.class));
        productCategoryDto.setCharacteristics(cha);
        productCategoryDto.setName("main");
        categoryService.update(productCategoryDto);
*/
        return "clientCreate";
    }
}
