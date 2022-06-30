import java.util.Scanner;

import java.io.*;
public class CS211Lab1Wordle
{
    public static String[] possibleWords = load("/Users/jessicakrapfl/Desktop/5LetterW.txt");
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int rand = (int)(Math.random()*possibleWords.length);
        String magicWord = possibleWords[rand];//the word the user is trying to guess
        boolean correctFlag = false;
        char[] greenLetters = {'_','_','_','_','_'};
        String greyLetters = "";

        while(correctFlag ==false)
        {
            String guessedWord = sc.nextLine();
            String yellowLetters = "";

            for(int i=0; i <guessedWord.length();i++)
            {
                String charAtI = Character.toString(guessedWord.charAt(i));
                if(guessedWord.charAt(i) == magicWord.charAt(i))//if it is a green letter
                {
                    greenLetters[i]=magicWord.charAt(i);
                }
                else if(magicWord.contains(charAtI))//if it is a yellow letter
                {
                    yellowLetters = yellowLetters + guessedWord.charAt(i);
                }
                else//if its not yellow of green it is gray
                {
                    char cha = guessedWord.charAt(i);
                    String strCha = String.valueOf(cha);
                    if(!greyLetters.contains(strCha))
                    {
                        greyLetters = greyLetters + guessedWord.charAt(i);
                    }
                }
            }
            if(guessedWord.matches(magicWord))
            {
                System.out.print(magicWord + " is correct!");
                correctFlag =true;
                break;
            }
            else
            {
                System.out.print("Green Letters: ");
                for(int i =0; i<5; i++)
                {
                    System.out.print(greenLetters[i]);
                }
                System.out.println();
                System.out.println("Yellow Letters this round: " + yellowLetters);
                System.out.println("Grey Letters: " + greyLetters);
            }
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
