package com.projectselectapp.www.project.select.app.Final_Defense;


import java.util.List;

public interface Final_DefenseService {


    Final_DefenseDto createFinal_Defense(Final_DefenseDto final_defenseDto);

    List<Final_DefenseDto> getAll();

    Final_DefenseDto findById(Long id);

    void deleteById(Long id);

    Final_DefenseDto updateFinal_Defence (Final_DefenseDto final_defenseDto);

}