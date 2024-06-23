package com.projectselectapp.www.project.select.app.Pre_Defanse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Pre_Defense")
@CrossOrigin(origins = "*")
public class Pre_DefanseController {

    @Autowired
    private Pre_DefanseService pre_DefanseService;


    @PostMapping
    public ResponseEntity<Pre_DefanseDto> createPre_Defense(@RequestBody Pre_DefanseDto pre_DefanseDto){
        Pre_DefanseDto newPre_DefanseDto = pre_DefanseService.createPre_Defance(pre_DefanseDto);
        return new ResponseEntity<>(newPre_DefanseDto, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Pre_DefanseDto>> getAllPre_Defense(){
        List<Pre_DefanseDto> newListPre_DefenseDto = pre_DefanseService.getAll();
        return ResponseEntity.ok(newListPre_DefenseDto);
    }


    @GetMapping("{id}")
    public  ResponseEntity<Pre_DefanseDto> findById(@PathVariable("id") Long id){
        Pre_DefanseDto pre_defanseDto = pre_DefanseService.findById(id);
        return ResponseEntity.ok(pre_defanseDto);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        pre_DefanseService.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PutMapping
    public  ResponseEntity<Pre_DefanseDto> updatePre_Defense(@RequestBody Pre_DefanseDto pre_DefanseDto){
        Pre_DefanseDto Pre_DefanseDto =pre_DefanseService.updatePreDefanceDto(pre_DefanseDto);
        return ResponseEntity.ok(pre_DefanseDto);
    }

}