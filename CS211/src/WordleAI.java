import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
public class WordleAI
{
    //text file words
    public static String[] possibleWords = load("/Users/jessicakrapfl/Desktop/wordlewords.txt");
    //arrays and things to keep track of the word scores, green letters,grey letters, and yellow letters
    public static int[] score = new int[possibleWords.length];
    public static char[] greenLetters = {' ',' ',' ',' ',' '};
    public static String yellowLetters = "";
    public static String greyLetters = "";

    //finding the magic word
    public static int rand = (int)(Math.random()*possibleWords.length);
    public static String magicWord = possibleWords[rand];//the word the user is trying to guess
    //public static String magicWord = "hello";//for testing
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
    public static int round=1;

    public WordleAI()
    {
        //create properties
        JFrame frame = new JFrame();
        JButton start = new JButton("Start");
        JPanel panel = new JPanel();

        //******set and add properties********
        //start button
        start.setBounds(220,700,100,50);
        frame.add(start);
        start.addActionListener(new eventHandler());

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
        new WordleAI();
    }

    //other classes
    class eventHandler implements ActionListener//where most of the gameplay is run
    {
        public void actionPerformed(ActionEvent ae)
        {
            //Toolkit.getDefaultToolkit().beep();//fun little ding
            while(round<7)
            {
                if (round == 1)//puts the chars of the first guessed word into the first row
                {
                    guessedWord = "audio";//first guessed word
                    row1Col1.setText(String.valueOf(guessedWord.charAt(0)));
                    row1Col2.setText(String.valueOf(guessedWord.charAt(1)));
                    row1Col3.setText(String.valueOf(guessedWord.charAt(2)));
                    row1Col4.setText(String.valueOf(guessedWord.charAt(3)));
                    row1Col5.setText(String.valueOf(guessedWord.charAt(4)));
                    colorHandler();
                    round++;
                } else if (round == 2)//puts the chars of the second guessed word into the second row
                {
                    guessedWord = nextGuess();
                    row2Col1.setText(String.valueOf(guessedWord.charAt(0)));
                    row2Col2.setText(String.valueOf(guessedWord.charAt(1)));
                    row2Col3.setText(String.valueOf(guessedWord.charAt(2)));
                    row2Col4.setText(String.valueOf(guessedWord.charAt(3)));
                    row2Col5.setText(String.valueOf(guessedWord.charAt(4)));
                    colorHandler();
                    round++;

                } else if (round == 3)//puts the chars of the third guessed word into the third row
                {
                    guessedWord=nextGuess();
                    row3Col1.setText(String.valueOf(guessedWord.charAt(0)));
                    row3Col2.setText(String.valueOf(guessedWord.charAt(1)));
                    row3Col3.setText(String.valueOf(guessedWord.charAt(2)));
                    row3Col4.setText(String.valueOf(guessedWord.charAt(3)));
                    row3Col5.setText(String.valueOf(guessedWord.charAt(4)));
                    colorHandler();
                    round++;
                } else if (round == 4)//puts the chars of the fourth guessed word into the fourth row
                {
                    guessedWord=nextGuess();
                    row4Col1.setText(String.valueOf(guessedWord.charAt(0)));
                    row4Col2.setText(String.valueOf(guessedWord.charAt(1)));
                    row4Col3.setText(String.valueOf(guessedWord.charAt(2)));
                    row4Col4.setText(String.valueOf(guessedWord.charAt(3)));
                    row4Col5.setText(String.valueOf(guessedWord.charAt(4)));
                    colorHandler();
                    round++;
                } else if (round == 5)//puts the chars of the fifth guessed word into the fifth row
                {
                    guessedWord=nextGuess();
                    row5Col1.setText(String.valueOf(guessedWord.charAt(0)));
                    row5Col2.setText(String.valueOf(guessedWord.charAt(1)));
                    row5Col3.setText(String.valueOf(guessedWord.charAt(2)));
                    row5Col4.setText(String.valueOf(guessedWord.charAt(3)));
                    row5Col5.setText(String.valueOf(guessedWord.charAt(4)));
                    colorHandler();
                    round++;
                } else if (round == 6)//puts the chars of the sixth guessed word into the sixth row
                {
                    guessedWord=nextGuess();
                    row6Col1.setText(String.valueOf(guessedWord.charAt(0)));
                    row6Col2.setText(String.valueOf(guessedWord.charAt(1)));
                    row6Col3.setText(String.valueOf(guessedWord.charAt(2)));
                    row6Col4.setText(String.valueOf(guessedWord.charAt(3)));
                    row6Col5.setText(String.valueOf(guessedWord.charAt(4)));
                    colorHandler();
                    round++;
                }
            }
        }
    }

    public static void colorHandler()//handles the box colors
    {
        if(round ==1)//row 1
        {
            for(int i = 0; i<5;i++)
            {
                if(i ==0)//col1
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row1Col1.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row1Col1.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row1Col1.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==1)//col2
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row1Col2.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row1Col2.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row1Col2.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==2)//col3
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row1Col3.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row1Col3.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row1Col3.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==3)//col4
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row1Col4.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row1Col4.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row1Col4.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==4)//col5
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row1Col5.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row1Col5.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row1Col5.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
            }
        }
        else if(round==2)//row2
        {
            for(int i = 0; i<5;i++)
            {
                if(i ==0)//col1
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row2Col1.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row2Col1.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row2Col1.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==1)//col2
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row2Col2.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row2Col2.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row2Col2.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==2)//col3
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row2Col3.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row2Col3.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row2Col3.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==3)//col4
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row2Col4.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row2Col4.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row2Col4.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==4)//col5
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row2Col5.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row2Col5.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row2Col5.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
            }
        }
        else if(round==3)//row3
        {
            for(int i = 0; i<5;i++)
            {
                if(i ==0)//col1
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row3Col1.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row3Col1.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row3Col1.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==1)//col2
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row3Col2.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row3Col2.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row3Col2.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==2)//col3
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row3Col3.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row3Col3.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row3Col3.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==3)//col4
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row3Col4.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row3Col4.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row3Col4.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==4)//col5
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row3Col5.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row3Col5.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row3Col5.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
            }
        }
        else if(round==4)//row4
        {
            for(int i = 0; i<5;i++)
            {
                if(i ==0)//col1
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row4Col1.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row4Col1.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row4Col1.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==1)//col2
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row4Col2.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row4Col2.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row4Col2.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==2)//col3
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row4Col3.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row4Col3.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row4Col3.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==3)//col4
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row4Col4.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row4Col4.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row4Col4.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==4)//col5
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row4Col5.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row4Col5.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row4Col5.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
            }
        }
        else if(round==5)//row5
        {
            for(int i = 0; i<5;i++)
            {
                if(i ==0)//col1
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row5Col1.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row5Col1.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row5Col1.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==1)//col2
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row5Col2.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row5Col2.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row5Col2.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==2)//col3
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row5Col3.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row5Col3.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row5Col3.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==3)//col4
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row5Col4.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row5Col4.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row5Col4.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==4)//col5
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row5Col5.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row5Col5.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row5Col5.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
            }
        }
        else if(round==6)//row6
        {
            for(int i = 0; i<5;i++)
            {
                if(i ==0)//col1
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row6Col1.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row6Col1.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row6Col1.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==1)//col2
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row6Col2.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row6Col2.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row6Col2.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==2)//col3
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row6Col3.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row6Col3.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row6Col3.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==3)//col4
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row6Col4.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row6Col4.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row6Col4.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
                else if(i==4)//col5
                {
                    if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                    {
                        row6Col5.setBackground(Color.green);
                        greenLetters[i] = guessedWord.charAt(i);
                    }
                    else if(magicWord.contains(String.valueOf(guessedWord.charAt(i))))//if it is a yellow letter
                    {
                        row6Col5.setBackground(Color.yellow);
                        yellowLetters = yellowLetters+ guessedWord.charAt(i);
                    }
                    else
                    {
                        row6Col5.setBackground(Color.gray);
                        greyLetters = greyLetters+ guessedWord.charAt(i);
                    }
                }
            }
        }
    }

    public static void wordScore()//scores the next guess and stores the value into the score array
    {
        char[] greyArr = greyLetters.toCharArray();
        char[] yellowArr = yellowLetters.toCharArray();

        for(int i =0;i<possibleWords.length;i++)
        {
            //if the word at index i has a grey letter its score is 0
            for(int j=0; j<greyArr.length; j++)//runs through the greyArr
            {
                if(possibleWords[i].contains(String.valueOf(greyArr[j])))
                {
                    score[i] = -1;
                }
            }
            //if the word at index i contains a green or a yellow letter its score is++
            if(score[i] !=-1)
            {
                for(int j = 0; j< 5;j++)//runs through the word length
                {
                    if(greenLetters[j]== possibleWords[i].charAt(j))
                    {
                        score[i]++;
                    }
                }

                for(int j=0; j<yellowArr.length; j++)//runs through yellowArr
                {
                    if(possibleWords[i].contains(String.valueOf(yellowArr[j])))
                    {
                        score[i]++;
                    }
                }
            }
        }
    }

    public String nextGuess()//gets the next guessedWord
    {
        wordScore();
        int highest=0;
        int index = 0;
        for(int i=0; i<possibleWords.length; i++)
        {
            if(score[i]>highest)
            {
                highest = score[i];
                index = i;
            }
        }
        return possibleWords[index];
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
