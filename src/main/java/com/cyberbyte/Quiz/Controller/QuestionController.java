package com.cyberbyte.Quiz.Controller;

import com.cyberbyte.Quiz.Question;
import com.cyberbyte.Quiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
     QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{lang}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String lang){
        return questionService.getQuestionsByCategory(lang);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question q){
        questionService.addQuestion(q);
        return "Success";
    }

    @DeleteMapping("remove/{n}")
    public String deleteQuestion(@PathVariable int n){
        questionService.deleteQuestion(n);
        return "Deleted!";
    }

}
