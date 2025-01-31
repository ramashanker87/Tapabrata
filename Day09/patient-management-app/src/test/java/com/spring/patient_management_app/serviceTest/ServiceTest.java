package com.spring.patient_management_app.serviceTest;

import com.spring.patient_management_app.controller.PateintController;
import com.spring.patient_management_app.model.Pateint;
import com.spring.patient_management_app.service.PateintService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @InjectMocks
    PateintService pateintService;

    @Test
    public void testSavePateint(){
        Pateint p1 = new Pateint("roney", "PA1", "Civil Hospital", 23, "Male");
        Pateint resultP1 = pateintService.savePateint(p1);
        assert resultP1!=null;
        assert resultP1.getId()==p1.getId();
        assert resultP1.getName()==p1.getName();
        assert resultP1.getAge()==p1.getAge();
        assert resultP1.getGender()== p1.getGender();
        assert resultP1.getHospitalName()==p1.getHospitalName();

    }
    @Test
    public void testUpdatePateint(){
        Pateint p1 = new Pateint("roney", "PA1", "Civil Hospital", 23, "Male");
        Pateint p2 = new Pateint("ankit", "PA2", "Super Hospital", 24, "Male");
        Pateint resultP1 = pateintService.savePateint(p1);
        Pateint resultP2 = pateintService.savePateint(p2);
        Pateint resultPateint = pateintService.updatePateint(p1.getId(),"Civil Hospital");
        assert resultPateint!=null;
        assert resultPateint.getId()==p1.getId();
        assert resultPateint.getHospitalName().equals("Civil Hospital");

    }

    @Test
    public void testDeletePateint(){
        Pateint p1 = new Pateint("roney", "PA1", "Civil Hospital", 23, "Male");
        Pateint resultP1 = pateintService.savePateint(p1);
            pateintService.deletePateint(p1.getId());
       Map<String,Pateint> resultMap= pateintService.readAllPateints();
        System.out.println(resultMap);
       assert resultMap.isEmpty();
    }

    @Test
    public void testReadAllPateints(){
        Pateint p1 = new Pateint("roney", "PA1", "Civil Hospital", 23, "Male");
        Pateint p2 = new Pateint("ankit", "PA2", "Super Hospital", 24, "Male");
        Pateint p3 = new Pateint("muskan", "PA3", "Non Hospital", 30, "Female");
        pateintService.savePateint(p1);
        pateintService.savePateint(p2);
        pateintService.savePateint(p3);
        Map<String,Pateint> resultMap = pateintService.readAllPateints();
        assert resultMap.size()==3;
        assert resultMap.containsKey(p1.getId());
        assert resultMap.containsKey(p2.getId());
        assert resultMap.containsKey(p3.getId());
    }

}
