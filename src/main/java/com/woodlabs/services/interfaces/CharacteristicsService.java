package com.woodlabs.services.interfaces;

import com.woodlabs.dto.CharacteristicsDto;

import java.util.List;

public interface CharacteristicsService {
    public CharacteristicsDto add(CharacteristicsDto characteristicsDto);
    public void delete(CharacteristicsDto characteristicsDto);
    public CharacteristicsDto update(CharacteristicsDto characteristicsDto);
    public List<CharacteristicsDto> findAll();
    public CharacteristicsDto findById(Integer id);
}
