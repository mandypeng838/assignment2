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
    
    /**
     * This method creates a question holding the text, correct answer, 
     * and an explanation
     * @param questionText
     * @param correctAnswer
     * @param explanation
     */
    public Question (String questionText, String correctAnswer, String explanation) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.explanation = explanation;
    }
    
    /**
     * returns the question
     * @return questionText
     */
    public String getQuestionText(){
        return questionText;
    }
    
    /**
     * returns the correct answer
     * @return correctAnswer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    
    /**
     * returns the explanation
     * @return explanation
     */
    public String getExplanation() {
        return explanation;
    }
    
    /**
     * This method checks whether the answer was correct
     * @param userAnswer
     * @return correctAnswer
     */
    public boolean isCorrect (String userAnswer){
        return correctAnswer.equalsIgnoreCase(userAnswer.trim());
   }
    
    /**
     * This method formats the score text
     * @param score
     * @param total
     * @return " Score: " + score + "/" + total
     */
    public static String formatScore(int score, int total){
        return " Score: " + score + "/" + total;
    }
}
