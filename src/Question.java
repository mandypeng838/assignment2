/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windows
 */
public class Question {
    private String questionText;
    private String correctAnswer;
    private String explanation;
    
    public Question (String questionText, String correctAnswer, String explanation) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.explanation = explanation;
    }
    
    public String getQuestionText(){
        return questionText;
    }
    
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    
    public String getExplanation() {
        return explanation;
    }
}
