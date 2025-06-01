/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windows
 */
public class FillBlank extends Question {
    public FillBlank (String questionText, String correctAnswer, String explanation){
        super(questionText, correctAnswer, explanation);
    }
    
    public String[] getOptions(){
        return new String[] {"Type your answer in the blank."};
    }
}
