package com.projectselectapp.www.project.select.app.Final_Defense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Final_Defense")

public class Final_DefenseController {
    @Autowired
    private Final_DefenseService final_DefenseService;

    @PostMapping
    public ResponseEntity<Final_DefenseDto> createFinal_Defense(@RequestBody Final_DefenseDto final_defenseDto){
        Final_DefenseDto newFinal_DefenseDto = final_DefenseService.createFinal_Defense(final_defenseDto);
        return new ResponseEntity<>(newFinal_DefenseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Final_DefenseDto>> getAllFinal_Defense(){
        List<Final_DefenseDto> newListFinal_DefenseDto = final_DefenseService.getAll();
        return ResponseEntity.ok(newListFinal_DefenseDto);
    }


    @GetMapping("{id}")
    public  ResponseEntity<Final_DefenseDto> findById(@PathVariable("id") Long id){
        Final_DefenseDto final_defenseDto = final_DefenseService.findById(id);
        return ResponseEntity.ok(final_defenseDto);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        final_DefenseService.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PutMapping
    public  ResponseEntity<Final_DefenseDto> updateFinal_Defense(@RequestBody Final_DefenseDto final_defenseDto){
        Final_DefenseDto final_Defense =final_DefenseService.updateFinal_Defence(final_defenseDto);
        return ResponseEntity.ok(final_Defense);
    }




}