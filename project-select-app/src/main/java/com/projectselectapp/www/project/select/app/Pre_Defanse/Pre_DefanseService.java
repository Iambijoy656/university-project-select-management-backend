package com.projectselectapp.www.project.select.app.Pre_Defanse;

import java.util.List;


public interface Pre_DefanseService {

    Pre_DefanseDto createPre_Defance(Pre_DefanseDto pre_defanseDto);

    List<Pre_DefanseDto> getAll();

    Pre_DefanseDto findById(Long id);

    void deleteById(Long id);

    Pre_DefanseDto updatePreDefanceDto(Pre_DefanseDto pre_defanseDto);
}