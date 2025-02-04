package com.student_management_app.demo.student_app.controllerTest;

import com.student_management_app.demo.student_app.controller.StudentController;
import com.student_management_app.demo.student_app.service.StudentService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @InjectMocks
    StudentController studentController;

    @Mock
    StudentService studentService;
}
