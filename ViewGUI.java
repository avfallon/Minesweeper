import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

class QuestionListener implements ActionListener
{
  protected ViewGUI gameBoard;
  protected JButton theButton;
  protected String category;
  protected String question;

  public QuestionListener(ViewGUI gb, JButton b, String c, String q)
  {
    gameBoard = gb;
    theButton = b;
    category = c;
    question = q;
  }

  public void actionPerformed(ActionEvent e)
  {
    gameBoard.setTitleText(category + " for " + theButton.getText());
    gameBoard.setAnswerText(question);
    theButton.setEnabled(false);
    theButton.setText("");
  }
}

public class ViewGUI extends JApplet implements View 
{      
    protected JLabel answer = null;
    protected JLabel title = null;
    protected JLabel gameOverText = null;
    

    protected String[] titles =
    { "Precedence", "Relational Ops", "CS 312" };

    protected String[][] questions = // from CS 201 lab
    {
        /**
        { // Boolean Data and Operations:
            "!false", "&&", "false || false", "!true && !false", "if ( ______ ) statement", },
        { // Numeric Data
            "4 % 8", "number of 5 bit values", "5/2 + 5",
            "int i = 4;   int j = 2;   int k = 7;     System.out.println((i+j)/2)", "the number of bits in two bytes" },
            */
        { // Operator Precedence
            "3 + 4 * 2", "4 + 5 / 6", "int m = 5;   m += 10;  System.out.println(m); ", "7 + (4+11) % 4 - 6",
            "shorthand for 'i = i + 1'", "test", "test"},
        { // Relational Operators
            "22 < 40", ">=", "b++ >= ++b", "higher precedence than +", "if (n % 2 == 0)",  "test", "test"},
        { // CS 312
            "Professor of the class", "The head honcho", "El jefe",
            "biggest linux fan in the world", "big spongebob guy", "test", "test"} };
    
    protected GameBoard model = null;

    public void setModel(GameBoard m) {model = m;}
    public void initialDisplay() {update(0, 0);}
    public void gameOver(String msg) {System.out.println(msg); System.exit(0);}
    public void update(int _r, int _c)
    {
        
    }
    
    
    public void setAnswerText(String s)
    {
      answer.setText("    \"" + s + "\"");
    }

    public void setTitleText(String s)
    {
      title.setText(s);
    }

    public void init()
    {
      JButton play = new JButton("Play");
      play.setVisible(true);
      play.addActionListener(new QuestionListener(this, play, "", ""));
      
      setLayout(new BorderLayout());

      JPanel answers = new JPanel();
      answers.setLayout(new GridLayout(8, 3));
      add("Center", answers);

      for (int i = 0; i < GameBoard.BOARD_SIZE; i++)
      {
        answers.add(new JLabel("  " + titles[i]));
      }

      for (int i = 0; i < GameBoard.BOARD_SIZE; i++)
      {
        for (int j = 0; j < GameBoard.BOARD_SIZE; j++)
        {
          JButton b = new JButton((model[]));
          Icon img = new ImageIcon("img/buttonpic.png");
          b.setIcon(img);
          answers.add(b);
          b.addActionListener(new QuestionListener(this, b, titles[j], questions[j][i]));
        }
      }

      JPanel ans = new JPanel();
      ans.setLayout(new GridLayout(4, 1));
      add("South", ans);

      answer = new JLabel("");
      title = new JLabel(" ");
      Font big = new Font(getFont().getName(), getFont().getStyle(), 20);
      answer.setFont(big);
      title.setFont(big);
      ans.add(new JLabel(" ")); // spacer
      ans.add(title);
      ans.add(answer);
      ans.add(new JLabel(" ")); // spacer
    }
}
