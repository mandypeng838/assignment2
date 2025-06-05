/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 342353125
 */
public class QuestionManager {
    private Question[] questions;
    public static final int MAX_QUESTIONS = 8;
    
    public QuestionManager (Question[] questions) {
        questions = new Question[MAX_QUESTIONS];
    }
    
    public Question getQuestions(int index){
        if (index >= 0 && index < MAX_QUESTIONS) {
            return questions[index];
        }
        return null;
    }
}
