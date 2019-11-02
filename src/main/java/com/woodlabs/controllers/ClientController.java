package com.woodlabs.controllers;

import com.woodlabs.dto.AddressDto;
import com.woodlabs.dto.CharacteristicsDto;
import com.woodlabs.dto.ClientDto;
import com.woodlabs.dto.ProductCategoryDto;
import com.woodlabs.entities.Address;
import com.woodlabs.entities.Characteristics;
import com.woodlabs.entities.ProductCategory;
import com.woodlabs.repositories.AddressRepository;
import com.woodlabs.services.AddressService;
import com.woodlabs.services.CategoryService;
import com.woodlabs.services.CharacteristicsService;
import com.woodlabs.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

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
    public String main(){
        return "clientMain";
    }
    @GetMapping("test")
    public String test( Model model) {
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

        return "congrat";
    }
}
