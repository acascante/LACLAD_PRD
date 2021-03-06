// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cyu.laclad.domain;

import com.cyu.laclad.domain.Quiz;
import com.cyu.laclad.domain.QuizQuestion;
import com.cyu.laclad.enums.QuizType;
import com.cyu.laclad.enums.Status;
import java.util.Set;

privileged aspect Quiz_Roo_JavaBean {
    
    public String Quiz.getName() {
        return this.name;
    }
    
    public void Quiz.setName(String name) {
        this.name = name;
    }
    
    public String Quiz.getDescription() {
        return this.description;
    }
    
    public void Quiz.setDescription(String description) {
        this.description = description;
    }
    
    public QuizType Quiz.getType() {
        return this.type;
    }
    
    public void Quiz.setType(QuizType type) {
        this.type = type;
    }
    
    public Status Quiz.getStatus() {
        return this.status;
    }
    
    public void Quiz.setStatus(Status status) {
        this.status = status;
    }
    
    public Set<QuizQuestion> Quiz.getQuestions() {
        return this.questions;
    }
    
    public void Quiz.setQuestions(Set<QuizQuestion> questions) {
        this.questions = questions;
    }
    
}
