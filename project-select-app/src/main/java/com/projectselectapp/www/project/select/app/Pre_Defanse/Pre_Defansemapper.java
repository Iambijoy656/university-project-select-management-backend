package com.projectselectapp.www.project.select.app.Pre_Defanse;

public class Pre_Defansemapper {

    public  static Pre_Defense maptoPre_Defence(Pre_DefanseDto pre_defanseDto){

        return new Pre_Defense(
                pre_defanseDto.getId(),
                pre_defanseDto.getStudentId(),
                pre_defanseDto.getProjectLink(),
                pre_defanseDto.getReportLink()

        );}

    public  static Pre_DefanseDto maptoPre_DefenceDto(Pre_Defense pre_defance){

        return new Pre_DefanseDto(
                pre_defance.getId(),
                pre_defance.getStudentId(),
                pre_defance.getProjectLink(),
                pre_defance.getReportLink()

        );}


}