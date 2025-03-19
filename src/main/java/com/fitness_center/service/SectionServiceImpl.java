package com.fitness_center.service;

import com.fitness_center.dto.SectionDto;
import com.fitness_center.entities.Section;

import java.util.List;

public interface SectionServiceImpl {

    List<SectionDto> getAll ();

    SectionDto getSectionById (Long id);

    SectionDto addSection (SectionDto sectionDto);

    SectionDto updateSection (SectionDto sectionDto);

    SectionDto deleteSection (Long id);


}
