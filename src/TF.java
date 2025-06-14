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
    
    /**
     * Constructor for the True/False question
     * @param questionText
     * @param correctAnswer
     * @param explanation
     */
    public TF(String questionText, boolean correctAnswer, String explanation){
        super(questionText, Boolean.toString(correctAnswer), explanation);
    }
    
    /**
     * returns the options
     * @return
     */
    public String[] getOptions(){
        return options;
    }
    
    /**
     * Returns what the type of question is
     * @return
     */
    @Override
    public String getQuestionText(){
        return "True/False: " + super.getQuestionText();
    }
}
