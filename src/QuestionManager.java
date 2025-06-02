/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 342353125
 */
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class QuestionManager {
    private int score = 0;
    private Question[] questions;
    public static final int MAX_QUESTIONS = 8;
    
    public QuestionManager () {
        questions = new Question[MAX_QUESTIONS];
    }
    
    public void loadQuestions(String filename){
        try {
            Scanner scanner = new Scanner(new File(filename));
            int i = 0;
            while (scanner.hasNextLine() && i < MAX_QUESTIONS){
                String type = scanner.nextLine().trim();
                String questionText = scanner.nextLine().trim();
                if (type.equals("TF")) {
                    String answerLine = scanner.nextLine().trim();
                    boolean answer = Boolean.parseBoolean(answerLine);
                    String explanation = scanner.nextLine().trim();
                    questions[i] = new TF(questionText, answer, explanation);
                    i++;
                } else if (type.equals("MC")) {
                    String[] choices = new String[4];
                    for (int j = 0; j < 4; j++) {
                        choices[j] = scanner.nextLine();
                    }
                    String answer = scanner.nextLine().trim();
                    String explanation = scanner.nextLine().trim();
                    questions[i] = new MC(questionText, answer, explanation, choices);
                    i++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found.");
        }
    }
    
    public Question getQuestions(int index){
        if (index >= 0 && index < MAX_QUESTIONS) {
            return questions[index];
        }
        return null;
    }
    
    public boolean submitAnswer(int index){
        if (questions[index].isCorrect(userAnswer)){
            score++;
            return true;
        }
        return false;
    }
    
    public int getScore() {
       return score;
    }
    
    public void saveScore (String name, String filename){
        try {
            PrintWriter writer = new PrintWriter (new File(filename));
            writer.println(name + ": " + score + "/" + MAX_QUESTIONS);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the file to hold scores.");
        }
    }
}
