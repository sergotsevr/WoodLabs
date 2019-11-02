package com.woodlabs.services;

import com.woodlabs.dto.CharacteristicsDto;
import com.woodlabs.entities.Characteristics;
import com.woodlabs.repositories.CharacteristicsRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@Transactional
public class CharacteristicsServiceImpl implements CharacteristicsService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CharacteristicsRepository characteristicsRepository;

    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public CharacteristicsDto add(CharacteristicsDto CharacteristicsDto) {
        Characteristics Characteristics = modelMapper.map(CharacteristicsDto, Characteristics.class);
        Characteristics saved = characteristicsRepository.save(Characteristics);
        CharacteristicsDto dto = modelMapper.map(saved, CharacteristicsDto.class);
        return dto;
    }

    @Override
    public void delete(CharacteristicsDto CharacteristicsDto) {
        Characteristics Characteristics;
        try {
            Characteristics = convertToEntity(CharacteristicsDto);
            characteristicsRepository.delete(Characteristics);
            return;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        log.warn("error deleting Characteristics {}", CharacteristicsDto);
    }

    @Override
    public CharacteristicsDto update(CharacteristicsDto CharacteristicsDto) {
        System.out.println(CharacteristicsDto);
        Characteristics Characteristics = modelMapper.map(CharacteristicsDto, Characteristics.class);
        Characteristics saved = characteristicsRepository.save(Characteristics);
        CharacteristicsDto dto = modelMapper.map(saved, CharacteristicsDto.class);
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CharacteristicsDto> findAll() {
        try {
            List<Characteristics> found = characteristicsRepository.findAll();
            List<CharacteristicsDto> dto = new LinkedList<>();
            for (Characteristics Characteristics : found) {
                dto.add(modelMapper.map(found, CharacteristicsDto.class));
            }
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.warn("error finding all Characteristics");
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public CharacteristicsDto findById(Integer id) {
        try {
            Optional<Characteristics> Characteristics = characteristicsRepository.findById(id);
            CharacteristicsDto dto = modelMapper.map(Characteristics, CharacteristicsDto.class);
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.warn("error searching Characteristics with id = {}", id);
        return null;
    }

    private Characteristics convertToEntity(CharacteristicsDto CharacteristicsDto) throws ParseException {
        Characteristics Characteristics = modelMapper.map(CharacteristicsDto, Characteristics.class);
        return Characteristics;
    }
}
