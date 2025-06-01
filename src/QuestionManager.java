/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 342353125
 */


public class QuestionManager {
    private int score = 0;
    private int currentIndex = 0;
    private Question[] questions;
    public static final int MAX_QUESTIONS = 8;
    
    public QuestionManager () {
        questions = new Question[MAX_QUESTIONS];
    }
    
    public void loadQuestions(String filename){
        
    }
    
    public Question getQuestions(int index){
        
    }
    
    public Question submitAnswer(int index){
        
    }
    
    public int getScore() {
        return score;
    }
    
    public void saveScore (String name, String filename){

    }
    
    
}
