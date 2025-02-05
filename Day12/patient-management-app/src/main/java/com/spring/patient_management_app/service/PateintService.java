package com.spring.patient_management_app.service;


import com.spring.patient_management_app.model.Pateint;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PateintService {

    Map<String,Pateint> pateints = new HashMap<>();

    public Map<String, Pateint> readAllPateints() {
        return pateints;
    }

    public Pateint savePateint(Pateint pateint) {
        pateints.put(pateint.getId(),pateint);
        return pateint;
    }

    public Pateint updatePateint(String id, String name) {
        Pateint pateint = pateints.get(id);
        pateint.setHospitalName(name);
        return pateint;
    }

    public void deletePateint(String id) {
        pateints.remove(id);
    }
}
