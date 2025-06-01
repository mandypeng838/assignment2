/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windows
 */
public class TF extends Question {
    public TF(String questionText, String correctAnswer, String explanation){
        super(questionText, correctAnswer, explanation);
    }
    
    public String[] getOptions(){
        return new String[] {"True", "False"};
    }
}
