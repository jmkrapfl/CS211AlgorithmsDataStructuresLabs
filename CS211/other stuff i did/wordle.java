import java.util.*;
import java.io.*;
public class wordle
{
    public static void main(String [] args)
    {
        Scanner myscanner = new Scanner(System.in);
        String target = myscanner.nextLine();
        ArrayList<String> original = new ArrayList<String>();
        while(myscanner.hasNext())
        {
            String word = myscanner.nextLine();
            original.add(word);
        }
        int lives = 0;
        Brain mybrain = new Brain(original);
        String feedback = "00000";
        while(lives > 0)
        {
            String guess = mybrain.guessWord(feedback);
            feedback = getFeedback(target, guess);
            if(guess.equals(target))
            {
                System.out.println(guess);
                System.exit(0);
            }
            lives --;
        }
        System.out.println("You Fail!");
    }

    public static String getFeedback(String chosen, String guess)
    {
        char[] chosencopy = new char[5];
        for(int i = 0; i < 5; i++)
        {
            chosencopy[i] = chosen.charAt(i);
        }
        char[] guesscopy = new char[5];
        for(int i = 0; i < 5; i++)
        {
            guesscopy[i] = guess.charAt(i);
        }
        char[] feedback = new char[5];
        for(int i = 0; i< 5; i++)
        {
            feedback[i] = '0';
        }
        for(int i = 0; i < 5; i++)
        {
            if(guesscopy[i] == chosencopy[i])
            {
                feedback[i] = '2';
                chosencopy[i] = '@';
                guesscopy[i] = '*';
                break;
            }
        }
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(guesscopy[i] == chosencopy[i])
                {
                    feedback[i] = '1';
                    chosencopy[i] = '@';
                    guesscopy[i] = '*';
                    break;
                }
            }
        }
        String answer = "";
        for(int i = 0; i < 5; i++)
        {
            answer = answer + feedback[i];
        }
        return answer;
    }
}

class Brain
{
    public ArrayList dictionary;

    public Brain(ArrayList wordlist)
    {
        dictionary = wordlist;
    }
    public String guessWord(String feedback)
    {
        //fill this in so as to choose a String that is contained in dictionary
        //this method should return a String that is a good guess
        //the lines below just return a random guess - not likely to do well!
        //you receive your previous guess and the feedback as input
        //0 = grey
        //1 = yellow
        //2 = green

        /* stub code from lecture */
        Random r = new Random();
        return (String)dictionary.get(r.nextInt(dictionary.size()));
    }
}
