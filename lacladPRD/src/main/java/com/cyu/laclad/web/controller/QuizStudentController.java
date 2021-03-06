package com.cyu.laclad.web.controller;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.cyu.laclad.domain.Quiz;
import com.cyu.laclad.domain.QuizStudent;
import com.cyu.laclad.domain.Student;
import com.cyu.laclad.enums.Status;

@RequestMapping("/quizstudents")
@Controller
@RooWebScaffold(path = "quizstudents", formBackingObject = QuizStudent.class)
public class QuizStudentController {

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid QuizStudent quizStudent, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, quizStudent);
            return "quizstudents/create";
        }
        uiModel.asMap().clear();
        quizStudent.persist();
        return "redirect:/quizstudents/" + encodeUrlPathSegment(quizStudent.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new QuizStudent());
        return "quizstudents/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("quizstudent", QuizStudent.findQuizStudent(id));
        uiModel.addAttribute("itemId", id);
        return "quizstudents/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("quizstudents", QuizStudent.findQuizStudentEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) QuizStudent.countQuizStudents() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("quizstudents", QuizStudent.findAllQuizStudents(sortFieldName, sortOrder));
        }
        return "quizstudents/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid QuizStudent quizStudent, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, quizStudent);
            return "quizstudents/update";
        }
        uiModel.asMap().clear();
        quizStudent.merge();
        return "redirect:/quizstudents/" + encodeUrlPathSegment(quizStudent.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, QuizStudent.findQuizStudent(id));
        return "quizstudents/update";
    }

	@RequestMapping(value = "/{id}", params = "assign", produces = "text/html")
    public String assignForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditFormFromQuiz(uiModel, Arrays.asList(Quiz.findQuiz(id)));
        return "quizstudents/create";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        QuizStudent quizStudent = QuizStudent.findQuizStudent(id);
        quizStudent.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/quizstudents";
    }

	void populateEditForm(Model uiModel, QuizStudent quizStudent) {
        uiModel.addAttribute("quizStudent", quizStudent);
        uiModel.addAttribute("quizes", Quiz.findAllQuizes());
        uiModel.addAttribute("students", Student.findAllStudents());
        uiModel.addAttribute("statuses", Arrays.asList(Status.values()));
    }

	void populateEditFormFromQuiz(Model uiModel, List<Quiz> quizes) {
		uiModel.addAttribute("quizStudent", new QuizStudent());
        uiModel.addAttribute("quizes", quizes);
        uiModel.addAttribute("students", Student.findAllStudents(Status.ACTIVE));
        uiModel.addAttribute("statuses", Arrays.asList(Status.values()));
    }
	
	String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
}
