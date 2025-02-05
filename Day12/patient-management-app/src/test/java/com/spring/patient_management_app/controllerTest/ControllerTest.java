package com.spring.patient_management_app.controllerTest;


import com.spring.patient_management_app.controller.PateintController;
import com.spring.patient_management_app.model.Pateint;
import com.spring.patient_management_app.service.PateintService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @InjectMocks
    PateintController pateintController;

    @Mock
    PateintService pateintService;

    @Test
    public void testGetAllPateints() {
        Map<String, Pateint> pateintMap = new HashMap<>();
        Pateint p1 = new Pateint("roney", "PA1", "Civil Hospital", 23, "Male");
        Pateint p2 = new Pateint("ankit", "PA2", "Super Hospital", 24, "Male");
        Pateint p3 = new Pateint("muskan", "PA3", "Non Hospital", 30, "Female");

        pateintMap.put(p1.getId(),p1);
        pateintMap.put(p2.getId(),p2);
        pateintMap.put(p3.getId(),p3);

        when(pateintService.readAllPateints()).thenReturn(pateintMap);
        Map<String,Pateint> resultPateintMap =pateintController.getAllPateints();

        assert resultPateintMap!=null;
        assert resultPateintMap.size()==3;
        assert resultPateintMap.get(p1.getId())==p1;
        assert resultPateintMap.get(p2.getId())==p2;
        assert resultPateintMap.get(p3.getId())==p3;

    }

    @Test
    public void testSavePateint(){
        Pateint p1 = new Pateint("roney", "PA1", "Civil Hospital", 23, "Male");
        when(pateintService.savePateint(p1)).thenReturn(p1);
        Pateint resultP1 = pateintController.createEmployees(p1);
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
        when(pateintService.updatePateint(anyString(),anyString())).thenReturn(p1);
        Pateint resultPateint = pateintController.updateEmployee(p1.getId(),"roney");
        assert resultPateint!=null;
        assert resultPateint.getId()==p1.getId();
        assert resultPateint.getName().equals("roney");

    }

    @Test
    public void testDeletePateint(){
        doNothing().when(pateintService).deletePateint(anyString());
        pateintController.deleteEmployee("PA1");
        verify( pateintService,atLeast(1)).deletePateint(anyString());
    }

}
