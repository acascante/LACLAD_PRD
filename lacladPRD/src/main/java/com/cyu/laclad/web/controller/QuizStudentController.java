package com.cyu.laclad.web.controller;
import com.cyu.laclad.domain.QuizStudent;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/quizstudents")
@Controller
@RooWebScaffold(path = "quizstudents", formBackingObject = QuizStudent.class)
public class QuizStudentController {
}
