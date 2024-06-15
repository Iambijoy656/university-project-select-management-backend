package com.projectselectapp.www.project.select.app.Final_Defense;



import com.projectselectapp.www.project.select.app.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service

public class Final_DefenseServiceImp implements Final_DefenseService{
    @Autowired
    private Final_DefenseRepository final_DefenseRepository;


    @Override
    public Final_DefenseDto createFinal_Defense(Final_DefenseDto final_defenseDto) {
        Final_Defense final_defense= Final_Defensemapper.maptoFinal_Defence(final_defenseDto);
        Final_Defense saveFinal_Defense = final_DefenseRepository.save(final_defense);
        Final_DefenseDto newFinal_DefenseDto = Final_Defensemapper.maptoFinal_DefencedTO(saveFinal_Defense);
        return newFinal_DefenseDto;
    }

    @Override
    public List<Final_DefenseDto> getAll() {
        List<Final_Defense> allFinal_Defense = final_DefenseRepository.findAll();
        return allFinal_Defense.stream().map((finalDefense) -> {
            return Final_Defensemapper.maptoFinal_DefencedTO(finalDefense);
        }).collect(Collectors.toList());
    }

    @Override
    public Final_DefenseDto findById(Long id) {

        Final_Defense final_defense = final_DefenseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                "No Final_Defense Added with this id"+id));
        return Final_Defensemapper.maptoFinal_DefencedTO(final_defense);
    }


    @Override
    public void deleteById(Long id) {
        Final_Defense final_defense = final_DefenseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                "No Final_Defense added with this id"+id));
        final_DefenseRepository.deleteById(id);

    }


    @Override
    public Final_DefenseDto updateFinal_Defence(Final_DefenseDto final_defenseDto) {

        Final_Defense final_defense = final_DefenseRepository.findById(final_defenseDto.getId()).orElseThrow
                (()->new ResourceNotFoundException("Employee is not exist with this id" + final_defenseDto.getId()));

        final_defense.setStudentId(final_defenseDto.getStudentId());
        final_defense.setProjectLink(final_defenseDto.getProjectLink());
        final_defense.setPptLink(final_defenseDto.getPptLink());

        Final_Defense saveFinal_Defense = final_DefenseRepository.save(final_defense);
        return Final_Defensemapper.maptoFinal_DefencedTO(saveFinal_Defense);
    }
}
