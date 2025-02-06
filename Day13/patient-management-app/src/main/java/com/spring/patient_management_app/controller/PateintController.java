package com.spring.patient_management_app.controller;


import com.spring.patient_management_app.model.Pateint;
import com.spring.patient_management_app.service.PateintService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pateint")
public class PateintController {

 private final PateintService pateintService;

    public PateintController(PateintService pateintService) {
        this.pateintService = pateintService;
    }

    @GetMapping("/age/all")
    public Map<String, Pateint> getAllPateints(){
        return pateintService.readAllPateints();
    }

    @PostMapping("/save")
    public Pateint createEmployees(@RequestBody Pateint pateint) {
        return pateintService.savePateint(pateint);
    }
    @PutMapping("/update")
    public Pateint updateEmployee(@RequestParam("id") String id,@RequestParam("hospitalName") String name) {
        return pateintService.updatePateint(id,name);
    }
    @DeleteMapping("/delete")
    public void deleteEmployee(@RequestParam("id") String id) {
        pateintService.deletePateint(id);
    }




}
