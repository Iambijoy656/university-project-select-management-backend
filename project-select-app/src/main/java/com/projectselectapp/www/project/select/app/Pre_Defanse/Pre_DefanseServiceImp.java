package com.projectselectapp.www.project.select.app.Pre_Defanse;


import com.projectselectapp.www.project.select.app.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Pre_DefanseServiceImp implements Pre_DefanseService {

    @Autowired
    private Pre_DefanseRepository pre_DefanseRepository;


    @Override
    public Pre_DefanseDto createPre_Defance(Pre_DefanseDto pre_defanseDto) {
        Pre_Defense pre_defense= Pre_Defansemapper.maptoPre_Defence(pre_defanseDto);
        Pre_Defense savePre_Defense = pre_DefanseRepository.save(pre_defense);
        Pre_DefanseDto newPre_DefenseDto = Pre_Defansemapper.maptoPre_DefenceDto(savePre_Defense );
        return newPre_DefenseDto;

    }

    @Override
    public List<Pre_DefanseDto> getAll() {
        List<Pre_Defense> allPre_Defense = pre_DefanseRepository.findAll();
        return allPre_Defense.stream().map((pre_Defense) -> {
            return Pre_Defansemapper.maptoPre_DefenceDto(pre_Defense);
        }).collect(Collectors.toList());
    }

    @Override
    public Pre_DefanseDto findById(Long id) {
        Pre_Defense pre_defense = pre_DefanseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                "No Pre_Defense Added with this id"+id));
        return Pre_Defansemapper.maptoPre_DefenceDto(pre_defense);
    }

    @Override
    public void deleteById(Long id) {
        Pre_Defense pre_defense = pre_DefanseRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                "No Final_Defense added with this id"+id));
        pre_DefanseRepository.deleteById(id);
    }

    @Override
    public Pre_DefanseDto updatePreDefanceDto(Pre_DefanseDto pre_defanceDto) {
        Pre_Defense pre_defense = pre_DefanseRepository.findById(pre_defanceDto.getId()).orElseThrow
                (()->new ResourceNotFoundException("Employee is not exist with this id" + pre_defanceDto.getId()));

        pre_defense.setId(pre_defense.getId());
        pre_defense.setStudentId(pre_defanceDto.getStudentId());
        pre_defense.setProjectLink(pre_defanceDto.getProjectLink());
        pre_defense.setReportLink(pre_defanceDto.getReportLink());


        Pre_Defense savePre_Defense = pre_DefanseRepository.save(pre_defense);
        return Pre_Defansemapper.maptoPre_DefenceDto(savePre_Defense);
    }
}