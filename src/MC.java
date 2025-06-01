/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windows
 */
public class MC extends Question {
    private String[] options;
    
    public MC (String questionText, String correctAnswer, String explanation, String[] options){
        super(questionText, correctAnswer, explanation);
        this.options = options;
    }
    
    public String[] getOptions() {
        return options;
    }
}
