/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windows
 */
public class TF extends Question {
    private String[] options = {"True", "False"};
    
    public TF(String questionText, boolean correctAnswer, String explanation){
        super(questionText, Boolean.toString(correctAnswer), explanation);
    }
    
    public String[] getOptions(){
        return options;
    }
    
    @Override
    public String getQuestionText(){
        return "True/False: " + super.getQuestionText();
    }
}
