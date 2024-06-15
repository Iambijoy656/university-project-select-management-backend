package com.projectselectapp.www.project.select.app.Final_Defense;



public class Final_Defensemapper {


    public  static Final_Defense maptoFinal_Defence(Final_DefenseDto final_defenseDto){

        return new Final_Defense(
                final_defenseDto.getId(),
                final_defenseDto.getStudentId(),
                final_defenseDto.getProjectLink(),
                final_defenseDto.getReportLink(),
                final_defenseDto.getPptLink()

        );}


    public  static Final_DefenseDto maptoFinal_DefencedTO(Final_Defense final_defense){

        return new Final_DefenseDto(
                final_defense.getId(),
                final_defense.getStudentId(),
                final_defense.getProjectLink(),
                final_defense.getReportLink(),
                final_defense.getPptLink()

        );}



}