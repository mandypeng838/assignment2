/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 *
 * @author 342353125
 */
public class QuestionManager {
    private int score = 0;
    private Question[] questions;
    public static final int MAX_QUESTIONS = 8;
    private String userAnswer;
    
    public QuestionManager () {
        questions = new Question[MAX_QUESTIONS];
    }
    
    public Question getQuestions(int index){
        if (index >= 0 && index < MAX_QUESTIONS) {
            return questions[index];
        }
        return null;
    }
    
    public boolean submitAnswer(int index){
        if (questions[index].isCorrect(userAnswer)){
            score++;
            return true;
        }
        return false;
    }
    
    public int getScore() {
       return score;
    }
    
    public void saveScore (String name, String filename){
        try {
            PrintWriter writer = new PrintWriter (new File(filename));
            writer.println(name + ": " + score + "/" + MAX_QUESTIONS);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the file to hold scores.");
        }
    }
}
