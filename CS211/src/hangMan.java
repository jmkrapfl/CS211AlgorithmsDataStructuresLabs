import java.io.*;
import java.util.*;

public class hangMan
{
    public static String[] guessed = {"_","_","_","_","_"};
    public static int lives = 8;
    public static String[] possibleWords = load("/Users/jessicakrapfl/Desktop/Files/Maynooth/CS211/wordlewords.txt");

    public static void main(String[] args)
    {
        Random random = new Random();
        int rand = random.nextInt(possibleWords.length);
        String secretWord = possibleWords[rand];

        System.out.println(secretWord);
        while(lives>0)
        {
            char letter = nextLetter(possibleWords,guessed);
            if(Arrays.asList(guessed).contains("_")==false)
            {
                System.out.println("you won!");
                break;
            }
            else if(secretWord.contains(Character.toString(letter)) && Arrays.asList(guessed).contains(Character.toString(letter)) != true)
            {
                for(int i=0; i<secretWord.length();i++)//prints the _____
                {
                    if(secretWord.charAt(i)== letter)
                    {
                        guessed[i] = Character.toString(letter);
                    }
                    System.out.print(guessed[i]);
                }
                System.out.println();
                //System.out.println(guessedLetters);
                //System.out.println(rejected);
                //System.out.println();
            }
            else
            {
                System.out.println("the word does not contain: "+letter);
                //System.out.println(guessedLetters);
                //System.out.println(rejected);
                lives--;
            }
        }
    }

    public static String guessedLetters = "";
    public static String rejected = "";
    public static int round = -1;
    public static int[] Scores = new int[possibleWords.length];
    public static char nextLetter(String[] possibleWords, String[] guessed)//S E A O I U Y H
    {
        round++;
        char next = ' ';
        switch (round)
        {
            case 0: next='s';guessedLetters = guessedLetters+"s";
                break;
            case 1: next='e';guessedLetters = guessedLetters+"e";
                break;
            case 2: next='a';guessedLetters = guessedLetters+"a";
                break;
            case 3: next='r';guessedLetters = guessedLetters+"r";
                break;
            case 4: next='o';guessedLetters = guessedLetters+"o";
                break;
            case 5: next='i';guessedLetters = guessedLetters+"i";
                break;
            case 6: next='l';guessedLetters = guessedLetters+"l";
                break;
            case 7: next='t';guessedLetters = guessedLetters+"t";
                break;
            case 8: next='n';guessedLetters = guessedLetters+"n";
                break;
            case 9: next='u';guessedLetters = guessedLetters+"u";
                break;
            case 10: next='d';guessedLetters = guessedLetters+"d";
                break;
            case 11: next='c';guessedLetters = guessedLetters+"c";
                break;
            case 12: next='y';guessedLetters = guessedLetters+"y";
                break;
            case 13: next='p';guessedLetters = guessedLetters+"p";
                break;
            case 14: next='m';guessedLetters = guessedLetters+"m";
                break;
            case 15: next='h';guessedLetters = guessedLetters+"h";
                break;
            case 16: next='g';guessedLetters = guessedLetters+"g";
                break;
            case 17: next='b';guessedLetters = guessedLetters+"b";
                break;
            case 18: next='k';guessedLetters = guessedLetters+"k";
                break;
            case 19: next='f';guessedLetters = guessedLetters+"f";
                break;
            case 20: next='w';guessedLetters = guessedLetters+"w";
                break;
            case 21: next='v';guessedLetters = guessedLetters+"v";
                break;
            case 22: next='z';guessedLetters = guessedLetters+"z";
                break;
            case 23: next='x';guessedLetters = guessedLetters+"x";
                break;
            case 24: next='j';guessedLetters = guessedLetters+"j";
                break;
            case 25: next='q';guessedLetters = guessedLetters+"q";
                break;
        }
        if(Arrays.asList(guessed).contains(Character.toString(guessedLetters.charAt(round))) ==false)//if the last guess was not put into the _____ it was rejected
        {
            rejected = rejected + guessedLetters.charAt(round);//put that char into the reject pile
        }
        return next;
        /*
        if(guessedLetters =="")//first guess
        {
            guessedLetters= guessedLetters+"e";
            round++;
            return 'e';
        }
        else if(guessedLetters =="e")//second guess
        {
            guessedLetters= guessedLetters+"a";
            round++;
            return 'a';
        }
        else
        {
            if(Arrays.asList(guessed).contains(Character.toString(guessedLetters.charAt(round))) ==false)//if the last guess was not accepted
            {
                rejected = rejected + guessedLetters.charAt(round);//put that char into the reject pile
            }
            String best = scores();
            char nextChar=' ';
            for(int i =0;i<5;i++)
            {
                if(guessedLetters.contains(Character.toString(best.charAt(i)))==false)
                {
                    nextChar = best.charAt(i);
                    break;
                }
            }
            guessedLetters = guessedLetters + Character.toString(nextChar);
            round++;
            return nextChar;
        }

         */
    }

    //

    //Score the possible words and find the word with the highest
    public static String scores()
    {
        int highest=0;
        int index=0;
        for(int i=0;i< possibleWords.length;i++)
        {
            int score = 0;
            for(int j=0;j<possibleWords[i].length();j++)
            {
                //if the char at j==the char at guessedj and its not contained in the rejected ++score
                if( ((guessed[j] != "_") && (Character.toString(possibleWords[i].charAt(j)) == guessed[j])) && (rejected.contains(Character.toString(possibleWords[i].charAt(j)))==false)) //if the char at j==the char at guessedj
                {
                    score++;
                }
                else if(rejected.contains(Character.toString(possibleWords[i].charAt(j)))==true)// if it contains a rejected letter "delete" it
                {
                    score = -1;
                }
            }
            Scores[i]=score;
            if(Scores[i]>highest)
            {
                highest = Scores[i];
                index = i;
            }
        }
        return possibleWords[index];
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
