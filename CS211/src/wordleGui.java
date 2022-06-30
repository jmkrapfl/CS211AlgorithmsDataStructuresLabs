import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class wordleGui
{
    //objects
    public static String[] possibleWords = load("/Users/jessicakrapfl/Desktop/wordlewords.txt");
    public static String[] accecptedWords = load("/Users/jessicakrapfl/Desktop/allowable.txt");
    public static int rand = (int)(Math.random()*possibleWords.length);
    public static String magicWord = possibleWords[rand];//the word the user is trying to guess
    //public static String magicWord = "hello";//for testing
    public static JTextField text=new JTextField();
    public static JLabel invalid = new JLabel("");
    //row 1
    public static JLabel row1Col1 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row1Col2 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row1Col3 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row1Col4 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row1Col5 = new JLabel("",null, SwingConstants.CENTER);
    //row 2
    public static JLabel row2Col1 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row2Col2 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row2Col3 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row2Col4 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row2Col5 = new JLabel("",null, SwingConstants.CENTER);
    //row 3
    public static JLabel row3Col1 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row3Col2 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row3Col3 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row3Col4 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row3Col5 = new JLabel("",null, SwingConstants.CENTER);
    //row 4
    public static JLabel row4Col1 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row4Col2 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row4Col3 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row4Col4 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row4Col5 = new JLabel("",null, SwingConstants.CENTER);
    //row 5
    public static JLabel row5Col1 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row5Col2 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row5Col3 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row5Col4 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row5Col5 = new JLabel("",null, SwingConstants.CENTER);
    //row 6
    public static JLabel row6Col1 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row6Col2 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row6Col3 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row6Col4 = new JLabel("",null, SwingConstants.CENTER);
    public static JLabel row6Col5 = new JLabel("",null, SwingConstants.CENTER);

    //variables
    public static String guessedWord;
    public static int buttonClicks=0;
    public wordleGui()
    {
        //create properties
        JFrame frame = new JFrame();
        JButton enter = new JButton("Enter");
        JPanel panel = new JPanel();

        //******set and add properties********
        //enter button
        enter.setBounds(220,720,100,50);
        frame.add(enter);
        enter.addActionListener(new eventHandler());
        //text field
        text.setBounds(170,670,200,50);
        frame.add(text);
        text.setDocument(new JTextFieldLimit(5));
        //invalid message
        invalid.setBounds(20,680,200,50);
        frame.add(invalid);
        //****labels****
        //row one
        row1Col1.setBounds(10,10,100,100); row1Col1.setOpaque(true); frame.add(row1Col1);
        row1Col2.setBounds(120,10,100,100); row1Col2.setOpaque(true); frame.add(row1Col2);
        row1Col3.setBounds(230,10,100,100); row1Col3.setOpaque(true); frame.add(row1Col3);
        row1Col4.setBounds(340,10,100,100); row1Col4.setOpaque(true); frame.add(row1Col4);
        row1Col5.setBounds(450,10,100,100); row1Col5.setOpaque(true); frame.add(row1Col5);
        //row two
        row2Col1.setBounds(10,120,100,100); row2Col1.setOpaque(true); frame.add(row2Col1);
        row2Col2.setBounds(120,120,100,100); row2Col2.setOpaque(true); frame.add(row2Col2);
        row2Col3.setBounds(230,120,100,100); row2Col3.setOpaque(true); frame.add(row2Col3);
        row2Col4.setBounds(340,120,100,100); row2Col4.setOpaque(true); frame.add(row2Col4);
        row2Col5.setBounds(450,120,100,100); row2Col5.setOpaque(true); frame.add(row2Col5);
        //row three
        row3Col1.setBounds(10,230,100,100); row3Col1.setOpaque(true); frame.add(row3Col1);
        row3Col2.setBounds(120,230,100,100); row3Col2.setOpaque(true); frame.add(row3Col2);
        row3Col3.setBounds(230,230,100,100); row3Col3.setOpaque(true); frame.add(row3Col3);
        row3Col4.setBounds(340,230,100,100); row3Col4.setOpaque(true); frame.add(row3Col4);
        row3Col5.setBounds(450,230,100,100); row3Col5.setOpaque(true); frame.add(row3Col5);
        //row four
        row4Col1.setBounds(10,340,100,100); row4Col1.setOpaque(true); frame.add(row4Col1);
        row4Col2.setBounds(120,340,100,100); row4Col2.setOpaque(true); frame.add(row4Col2);
        row4Col3.setBounds(230,340,100,100); row4Col3.setOpaque(true); frame.add(row4Col3);
        row4Col4.setBounds(340,340,100,100); row4Col4.setOpaque(true); frame.add(row4Col4);
        row4Col5.setBounds(450,340,100,100); row4Col5.setOpaque(true); frame.add(row4Col5);
        //row five
        row5Col1.setBounds(10,450,100,100); row5Col1.setOpaque(true); frame.add(row5Col1);
        row5Col2.setBounds(120,450,100,100); row5Col2.setOpaque(true); frame.add(row5Col2);
        row5Col3.setBounds(230,450,100,100); row5Col3.setOpaque(true); frame.add(row5Col3);
        row5Col4.setBounds(340,450,100,100); row5Col4.setOpaque(true); frame.add(row5Col4);
        row5Col5.setBounds(450,450,100,100); row5Col5.setOpaque(true); frame.add(row5Col5);
        //row six
        row6Col1.setBounds(10,560,100,100); row6Col1.setOpaque(true); frame.add(row6Col1);
        row6Col2.setBounds(120,560,100,100); row6Col2.setOpaque(true); frame.add(row6Col2);
        row6Col3.setBounds(230,560,100,100); row6Col3.setOpaque(true); frame.add(row6Col3);
        row6Col4.setBounds(340,560,100,100); row6Col4.setOpaque(true); frame.add(row6Col4);
        row6Col5.setBounds(450,560,100,100); row6Col5.setOpaque(true); frame.add(row6Col5);

        //frame properties
        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Jessica's Wordle");
        frame.getContentPane().add(new canvas());
        frame.setBounds(450,0,560,800);
        frame.setVisible(true);
    }

    //*******MAIN*************
    public static void main(String[] args)
    {
        new wordleGui();
    }

    //other classes

    class eventHandler implements ActionListener//where most of the gameplay is run
    {
        public void actionPerformed(ActionEvent ae)
        {
            //Toolkit.getDefaultToolkit().beep();//fun little ding
            guessedWord = text.getText();
            text.setText("");
            if(accepted(guessedWord)==false)
            {
                invalid.setText("word not accepted");
            }
            else {
                buttonClicks++;
                invalid.setText("");
                if (buttonClicks == 1)//puts the chars of the first guessed word into the first row
                {
                    row1Col1.setText(String.valueOf(guessedWord.charAt(0)));
                    row1Col2.setText(String.valueOf(guessedWord.charAt(1)));
                    row1Col3.setText(String.valueOf(guessedWord.charAt(2)));
                    row1Col4.setText(String.valueOf(guessedWord.charAt(3)));
                    row1Col5.setText(String.valueOf(guessedWord.charAt(4)));
                    colorHandler();
                } else if (buttonClicks == 2)//puts the chars of the second guessed word into the second row
                {
                    row2Col1.setText(String.valueOf(guessedWord.charAt(0)));
                    row2Col2.setText(String.valueOf(guessedWord.charAt(1)));
                    row2Col3.setText(String.valueOf(guessedWord.charAt(2)));
                    row2Col4.setText(String.valueOf(guessedWord.charAt(3)));
                    row2Col5.setText(String.valueOf(guessedWord.charAt(4)));
                    colorHandler();
                } else if (buttonClicks == 3)//puts the chars of the third guessed word into the third row
                {
                    row3Col1.setText(String.valueOf(guessedWord.charAt(0)));
                    row3Col2.setText(String.valueOf(guessedWord.charAt(1)));
                    row3Col3.setText(String.valueOf(guessedWord.charAt(2)));
                    row3Col4.setText(String.valueOf(guessedWord.charAt(3)));
                    row3Col5.setText(String.valueOf(guessedWord.charAt(4)));
                    colorHandler();
                } else if (buttonClicks == 4)//puts the chars of the fourth guessed word into the fourth row
                {
                    row4Col1.setText(String.valueOf(guessedWord.charAt(0)));
                    row4Col2.setText(String.valueOf(guessedWord.charAt(1)));
                    row4Col3.setText(String.valueOf(guessedWord.charAt(2)));
                    row4Col4.setText(String.valueOf(guessedWord.charAt(3)));
                    row4Col5.setText(String.valueOf(guessedWord.charAt(4)));
                    colorHandler();
                } else if (buttonClicks == 5)//puts the chars of the fifth guessed word into the fifth row
                {
                    row5Col1.setText(String.valueOf(guessedWord.charAt(0)));
                    row5Col2.setText(String.valueOf(guessedWord.charAt(1)));
                    row5Col3.setText(String.valueOf(guessedWord.charAt(2)));
                    row5Col4.setText(String.valueOf(guessedWord.charAt(3)));
                    row5Col5.setText(String.valueOf(guessedWord.charAt(4)));
                    colorHandler();
                } else if (buttonClicks == 6)//puts the chars of the sixth guessed word into the sixth row
                {
                    row6Col1.setText(String.valueOf(guessedWord.charAt(0)));
                    row6Col2.setText(String.valueOf(guessedWord.charAt(1)));
                    row6Col3.setText(String.valueOf(guessedWord.charAt(2)));
                    row6Col4.setText(String.valueOf(guessedWord.charAt(3)));
                    row6Col5.setText(String.valueOf(guessedWord.charAt(4)));
                    colorHandler();
                }
            }
        }
    }

    public static boolean accepted(String word)//checks if a word is accepted
    {
        for(int i =0; i<accecptedWords.length; i++)
        {
            if(guessedWord.compareTo(accecptedWords[i])==0)
            {
                return true;
            }
        }
        return false;
    }

    public static void colorHandler()//handles the box colors
    {
        if(buttonClicks ==1)//row 1
        {
            for(int i = 0; i<5;i++)
            {
                if(i ==0)//col1
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row1Col1.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row1Col1.setBackground(Color.yellow);
                    }
                    else
                    {
                        row1Col1.setBackground(Color.gray);
                    }
                }
                else if(i==1)//col2
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row1Col2.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row1Col2.setBackground(Color.yellow);
                    }
                    else
                    {
                        row1Col2.setBackground(Color.gray);
                    }
                }
                else if(i==2)//col3
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row1Col3.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row1Col3.setBackground(Color.yellow);
                    }
                    else
                    {
                        row1Col3.setBackground(Color.gray);
                    }
                }
                else if(i==3)//col4
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row1Col4.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row1Col4.setBackground(Color.yellow);
                    }
                    else
                    {
                        row1Col4.setBackground(Color.gray);
                    }
                }
                else if(i==4)//col5
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row1Col5.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row1Col5.setBackground(Color.yellow);
                    }
                    else
                    {
                        row1Col5.setBackground(Color.gray);
                    }
                }
            }
        }
        else if(buttonClicks==2)//row2
        {
            for(int i = 0; i<5;i++)
            {
                if(i ==0)//col1
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row2Col1.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row2Col1.setBackground(Color.yellow);
                    }
                    else
                    {
                        row2Col1.setBackground(Color.gray);
                    }
                }
                else if(i==1)//col2
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row2Col2.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row2Col2.setBackground(Color.yellow);
                    }
                    else
                    {
                        row2Col2.setBackground(Color.gray);
                    }
                }
                else if(i==2)//col3
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row2Col3.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row2Col3.setBackground(Color.yellow);
                    }
                    else
                    {
                        row2Col3.setBackground(Color.gray);
                    }
                }
                else if(i==3)//col4
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row2Col4.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row2Col4.setBackground(Color.yellow);
                    }
                    else
                    {
                        row2Col4.setBackground(Color.gray);
                    }
                }
                else if(i==4)//col5
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row2Col5.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row2Col5.setBackground(Color.yellow);
                    }
                    else
                    {
                        row2Col5.setBackground(Color.gray);
                    }
                }
            }
        }
        else if(buttonClicks==3)//row3
        {
            for(int i = 0; i<5;i++)
            {
                if(i ==0)//col1
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row3Col1.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row3Col1.setBackground(Color.yellow);
                    }
                    else
                    {
                        row3Col1.setBackground(Color.gray);
                    }
                }
                else if(i==1)//col2
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row3Col2.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row3Col2.setBackground(Color.yellow);
                    }
                    else
                    {
                        row3Col2.setBackground(Color.gray);
                    }
                }
                else if(i==2)//col3
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row3Col3.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row3Col3.setBackground(Color.yellow);
                    }
                    else
                    {
                        row3Col3.setBackground(Color.gray);
                    }
                }
                else if(i==3)//col4
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row3Col4.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row3Col4.setBackground(Color.yellow);
                    }
                    else
                    {
                        row3Col4.setBackground(Color.gray);
                    }
                }
                else if(i==4)//col5
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row3Col5.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row3Col5.setBackground(Color.yellow);
                    }
                    else
                    {
                        row3Col5.setBackground(Color.gray);
                    }
                }
            }
        }
        else if(buttonClicks==4)//row4
        {
            for(int i = 0; i<5;i++)
            {
                if(i ==0)//col1
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row4Col1.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row4Col1.setBackground(Color.yellow);
                    }
                    else
                    {
                        row4Col1.setBackground(Color.gray);
                    }
                }
                else if(i==1)//col2
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row4Col2.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row4Col2.setBackground(Color.yellow);
                    }
                    else
                    {
                        row4Col2.setBackground(Color.gray);
                    }
                }
                else if(i==2)//col3
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row4Col3.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row4Col3.setBackground(Color.yellow);
                    }
                    else
                    {
                        row4Col3.setBackground(Color.gray);
                    }
                }
                else if(i==3)//col4
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row4Col4.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row4Col4.setBackground(Color.yellow);
                    }
                    else
                    {
                        row4Col4.setBackground(Color.gray);
                    }
                }
                else if(i==4)//col5
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row4Col5.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row4Col5.setBackground(Color.yellow);
                    }
                    else
                    {
                        row4Col5.setBackground(Color.gray);
                    }
                }
            }
        }
        else if(buttonClicks==5)//row5
        {
            for(int i = 0; i<5;i++)
            {
                if(i ==0)//col1
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row5Col1.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row5Col1.setBackground(Color.yellow);
                    }
                    else
                    {
                        row5Col1.setBackground(Color.gray);
                    }
                }
                else if(i==1)//col2
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row5Col2.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row5Col2.setBackground(Color.yellow);
                    }
                    else
                    {
                        row5Col2.setBackground(Color.gray);
                    }
                }
                else if(i==2)//col3
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row5Col3.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row5Col3.setBackground(Color.yellow);
                    }
                    else
                    {
                        row5Col3.setBackground(Color.gray);
                    }
                }
                else if(i==3)//col4
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row5Col4.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row5Col4.setBackground(Color.yellow);
                    }
                    else
                    {
                        row5Col4.setBackground(Color.gray);
                    }
                }
                else if(i==4)//col5
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row5Col5.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row5Col5.setBackground(Color.yellow);
                    }
                    else
                    {
                        row5Col5.setBackground(Color.gray);
                    }
                }
            }
        }
        else if(buttonClicks==6)//row6
        {
            for(int i = 0; i<5;i++)
            {
                if(i ==0)//col1
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row6Col1.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row6Col1.setBackground(Color.yellow);
                    }
                    else
                    {
                        row6Col1.setBackground(Color.gray);
                    }
                }
                else if(i==1)//col2
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row6Col2.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row6Col2.setBackground(Color.yellow);
                    }
                    else
                    {
                        row6Col2.setBackground(Color.gray);
                    }
                }
                else if(i==2)//col3
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row6Col3.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row6Col3.setBackground(Color.yellow);
                    }
                    else
                    {
                        row6Col3.setBackground(Color.gray);
                    }
                }
                else if(i==3)//col4
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row6Col4.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row6Col4.setBackground(Color.yellow);
                    }
                    else
                    {
                        row6Col4.setBackground(Color.gray);
                    }
                }
                else if(i==4)//col5
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row6Col5.setBackground(Color.green);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row6Col5.setBackground(Color.yellow);
                    }
                    else
                    {
                        row6Col5.setBackground(Color.gray);
                    }
                }
            }
        }
    }

    public class JTextFieldLimit extends PlainDocument //*****Set limit of text box***
    {
        private int limit;

        JTextFieldLimit(int limit)
        {
            super();
            this.limit = limit;
        }

        public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException
        {
            if (str == null) return;

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }

    class canvas extends JComponent//******Draws the squares*******
    {
        public void paint(Graphics g)
        {
            //first row
            g.drawRect (10, 10, 100, 100);
            g.drawRect(120,10,100,100);
            g.drawRect(230,10,100,100);
            g.drawRect(340,10,100,100);
            g.drawRect(450,10,100,100);
            //second row
            g.drawRect (10, 120, 100, 100);
            g.drawRect (120, 120, 100, 100);
            g.drawRect (230, 120, 100, 100);
            g.drawRect (340, 120, 100, 100);
            g.drawRect (450, 120, 100, 100);
            //third row
            g.drawRect (10, 230, 100, 100);
            g.drawRect (120, 230, 100, 100);
            g.drawRect (230, 230, 100, 100);
            g.drawRect (340, 230, 100, 100);
            g.drawRect (450, 230, 100, 100);
            //forth row
            g.drawRect (10, 340, 100, 100);
            g.drawRect (120, 340, 100, 100);
            g.drawRect (230, 340, 100, 100);
            g.drawRect (340, 340, 100, 100);
            g.drawRect (450, 340, 100, 100);
            //fifth row
            g.drawRect (10, 450, 100, 100);
            g.drawRect (120, 450, 100, 100);
            g.drawRect (230, 450, 100, 100);
            g.drawRect (340, 450, 100, 100);
            g.drawRect (450, 450, 100, 100);
            //sixth row
            g.drawRect (10, 560, 100, 100);
            g.drawRect (120, 560, 100, 100);
            g.drawRect (230, 560, 100, 100);
            g.drawRect (340, 560, 100, 100);
            g.drawRect (450, 560, 100, 100);
        }
    }

    //*****Load method*******
    public static String[] load(String file) {
        File aFile = new File(file);
        StringBuffer contents = new StringBuffer();
        BufferedReader input = null;
        try {
            input = new BufferedReader( new FileReader(aFile) );
            String line = null;
            int i = 0;
            while (( line = input.readLine()) != null){
                contents.append(line);
                i++;
                contents.append(System.getProperty("line.separator"));
            }
        }catch (FileNotFoundException ex){
            System.out.println("Can't find the file - are you sure the file is in this location: "+file);
            ex.printStackTrace();
        }catch (IOException ex){
            System.out.println("Input output exception while processing file");
            ex.printStackTrace();
        }finally{
            try {
                if (input!= null) {
                    input.close();
                }
            }catch (IOException ex){
                System.out.println("Input output exception while processing file");
                ex.printStackTrace();
            }
        }
        String[] array = contents.toString().split("\n");
        for(String s: array){
            s.trim();
        }
        return array;
    }
}