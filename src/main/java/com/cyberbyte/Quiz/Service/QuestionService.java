package com.cyberbyte.Quiz.Service;

import com.cyberbyte.Quiz.Dao.QuestionDao;
import com.cyberbyte.Quiz.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService
{
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK) ;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String lang) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(lang), HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question q) {
        try{
            questionDao.save(q);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(int n) {
        try{
            questionDao.deleteById(n);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
    }
}







