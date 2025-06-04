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
    
    /**
     * The constructor for multiple choice questions
     * @param questionText
     * @param correctAnswer
     * @param explanation
     * @param options
     */
    public MC (String questionText, String correctAnswer, String explanation, String[] options){
        super(questionText, correctAnswer, explanation);
        this.options = options;
    }
    
    /**
     * Returns the option of the number (1-4) for the multiple choice question
     * @param num
     * @return options[] 
     */
    public String getOptions(int num) {
        return options[num];
    }
    
    /**
     * Overrides the Question method and displays whether it is a Multiple choice
     * @return questionText
     */
    @Override
    public String getQuestionText(){
        return "Multiple Choice: " + super.getQuestionText();
    }
}
