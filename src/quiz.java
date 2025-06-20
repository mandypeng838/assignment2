/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

// imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Windows
 */
public class quiz extends javax.swing.JFrame {
    // create an array list to hold the questions
    private List<Question> questionList = new ArrayList<>();
    private int currentIndex = 0;
    public static int score = 0;
    private boolean answered = false;
    private static final int MAX_QUESTIONS = 8;

    /**
     * Creates new form quiz
     */
    public quiz() {
        initComponents();
        setLocationRelativeTo(null);
        // call methods to display the questions
        loadQuestions();
        displayQuestion();
        // disables the continue button
        next.setEnabled(false);
    }
    
    /**
     * Method reads the Questions.txt file and adds it to the array list
     */
    public void loadQuestions(){
        try {
            // create a scanner to read from file
            Scanner scanner = new Scanner(new File("Questions.txt"));
            // initialize counter variable
            int i = 0;
            // while we are still under 8 questions, and the scanner has another line to read
            while (scanner.hasNextLine() && i < MAX_QUESTIONS){
                // the first line is always the type of the question
                String type = scanner.nextLine().trim();
                // stores the next line, which is the question itself
                String questionText = scanner.nextLine().trim();
                // if the type of question is true/false or Multiple choice
                if (type.equals("TF")) {
                    String answerLine = scanner.nextLine().trim();
                    boolean answer = Boolean.parseBoolean(answerLine);
                    String explanation = scanner.nextLine().trim();
                    // add the question to the array list
                    questionList.add(new TF(questionText, answer, explanation));
                } else if (type.equals("MC")) {
                    String[] choices = new String[4];
                    for (int j = 0; j < 4; j++) {
                        choices[j] = scanner.nextLine();
                    }
                    String answer = scanner.nextLine().trim();
                    String explanation = scanner.nextLine().trim();
                    // add the question to the array list
                    questionList.add(new MC(questionText, answer, explanation, choices));
                }
                // increase counter
                i++;
            }
            scanner.close(); // close scanner
 
            // Create a test question using the overloaded constructor
            MC testQuestion = new MC(
                "What is the purpose of an overloaded constructor?",
                "To allow multiple ways to create an object",
                "Overloaded constructors give flexibility in how objects are created."
            );

            // Print to console to explain to the user
            System.out.println("Here is a sample test question (not part of the actual quiz):");
            System.out.println(testQuestion.getQuestionText());
            System.out.println("Correct Answer: " + testQuestion.getCorrectAnswer());
            System.out.println("Explanation: " + testQuestion.getExplanation());
            System.out.println("This test question follows the same format used in the quiz.");
            
        } catch (FileNotFoundException e) {
            System.out.println("File not Found.");
        }
    }
    
    
    /**
     * This method sets all the buttons based on the type of question 
     * and displays the question text
     */
    private void displayQuestion() {
        if (currentIndex >= questionList.size()){
            saveScore();
            new result().setVisible(true);
            this.setVisible(false);
            return;
        }
        
        Question question = questionList.get(currentIndex);
        questionPane.setText(question.getQuestionText());
        // clear explanation text fiels
        jTextField2.setText("");
        explanation.setText("");
        // set the continue button to false until the user answers
        next.setEnabled(false);

        if (question instanceof MC) {
            MC mc = (MC) question;
            // set the button text to the question options
            option1.setText(mc.getOptions(0));
            option2.setText(mc.getOptions(1));
            option3.setText(mc.getOptions(2));
            option4.setText(mc.getOptions(3));
            // enable all buttons
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);
        } else if (question instanceof TF){
            // set the button text to true and false
            option1.setText("True");
            option2.setText("False");
            option3.setText("");
            option4.setText("");
            // only enable the first button, true and false
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(false);
            option4.setEnabled(false);
        }
    }
    
    /**
     * This method takes the user's answer and returns whether it is correct or not
     * It then sets the text of the JPane to the explanation
     * @param userAnswer 
     */
    private void handleAnswer(String userAnswer){
        if (answered) return;
        
        Question question = questionList.get(currentIndex);
        answered = true;
        
        if (question.isCorrect(userAnswer)){
            score++;
            jTextField2.setText("Correct! ");
            explanation.setText(question.getExplanation());
        } else {
            jTextField2.setText("Incorrect! ");
            explanation.setText(question.getExplanation());
        }
        
        // Disable all buttons after the user answers
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);
    }
    
    /**
     * This method writes the user's name and score to scores.txt 
     */
    private void saveScore() {
        try {
            FileWriter fw = new FileWriter("scores.txt", true);
            PrintWriter writer = new PrintWriter(fw);
            writer.println("Name: " + start.gName + Question.formatScore(score, MAX_QUESTIONS));
            writer.close();
        } catch (IOException e) {
            System.out.println("IOException error: " + e);
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        option1 = new javax.swing.JButton();
        option2 = new javax.swing.JButton();
        option3 = new javax.swing.JButton();
        option4 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        next = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        explanation = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionPane = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setText("Question: ");

        option1.setText("option1");
        option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });

        option2.setText("option2");
        option2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ActionPerformed(evt);
            }
        });

        option3.setText("option3");
        option3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3ActionPerformed(evt);
            }
        });

        option4.setText("option4");
        option4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jTextField2.setText("Explanation");

        next.setBackground(new java.awt.Color(102, 255, 0));
        next.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        next.setText("Continue");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        explanation.setEditable(false);
        jScrollPane2.setViewportView(explanation);

        questionPane.setEditable(false);
        jScrollPane1.setViewportView(questionPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(option4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(option3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(option2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(option1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(option4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ActionPerformed
        handleAnswer(option1.getText());
        next.setEnabled(true);
    }//GEN-LAST:event_option1ActionPerformed

    private void option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ActionPerformed
        handleAnswer(option2.getText());
        next.setEnabled(true);
    }//GEN-LAST:event_option2ActionPerformed

    private void option3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3ActionPerformed
        handleAnswer(option3.getText());
        next.setEnabled(true);
    }//GEN-LAST:event_option3ActionPerformed

    private void option4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4ActionPerformed
        handleAnswer(option4.getText());
        next.setEnabled(true);
    }//GEN-LAST:event_option4ActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        currentIndex++;
        answered = false;
        displayQuestion();
    }//GEN-LAST:event_nextActionPerformed
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane explanation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton next;
    private javax.swing.JButton option1;
    private javax.swing.JButton option2;
    private javax.swing.JButton option3;
    private javax.swing.JButton option4;
    private javax.swing.JTextPane questionPane;
    // End of variables declaration//GEN-END:variables
}

