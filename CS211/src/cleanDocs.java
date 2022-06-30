/*
 * This program is separate from the project but this is what I created to get sentences from large amounts of text.
 * this java program takes a large amount of text from a text file (One.txt), puts each sentence of that file into a new line in a
 * new text file (Two.txt), and finally puts all sentences that don't contain "" and that are 10 words or less into a new text
 * file (Three.txt) and from there i am able to simply copy and paste the sentences from Three.txt into my Words.txt file
 */

import java.io.*;

public class cleanDocs
{
    //global variables
    public static char[] sentence;
    private static String[] input = load("/Users/jessicakrapfl/Desktop/Two.txt");//put the doc you want to go through here
    //main
    public static void main(String args[]) throws IOException
    {
        //step1
        sentence = firstStep();
        //step2
        secondStep(sentence);
        //step3
        thirdStep();
    }

    //Step1
    public static char[] firstStep()//reads the file and puts all the characters into an array
            throws IOException
    {
        File file = new File("/Users/jessicakrapfl/Desktop/One.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;

        while ((line = bufferedReader.readLine()) != null)
        {
            sentence = line.toCharArray();
        }
        return sentence;
    }

    //step2
    public static void secondStep(char[] senArr)throws IOException//takes the char array and writes it into a new file
    {															  //after this step each sentence is on its own line in the new text file
        //String charStr;
        for(int i = 0;i<senArr.length;i++)
        {
            String charStr = Character.toString(senArr[i]);
            if(charStr.matches("[!?.]") && i != senArr.length-1)//replaces the space after a .!? into a new line
            {
                senArr[i+1] = '\n';
            }
            //System.out.print(senArr[i]);
        }
        try {
            FileWriter myWriter = new FileWriter("/Users/jessicakrapfl/Desktop/Two.txt");
            for(int i = 0;i<senArr.length;i++)
            {
                myWriter.write(senArr[i]);
                //System.out.print(senArr[i]);
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //step3A
    public static String[] load(String file)
    {
        File aFile = new File(file);
        StringBuffer contents = new StringBuffer();
        BufferedReader input = null;
        try
        {
            input = new BufferedReader( new FileReader(aFile) );
            String line = null;
            int i = 0;
            while (( line = input.readLine()) != null)
            {
                contents.append(line);
                i++;
                contents.append(System.getProperty("line.separator"));
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Can't find the file - are you sure the file is in this location: "+file);
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            System.out.println("Input output exception while processing file");
            ex.printStackTrace();
        }
        finally
        {
            try {
                if (input!= null)
                {
                    input.close();
                }
            }
            catch (IOException ex)
            {
                System.out.println("Input output exception while processing file");
                ex.printStackTrace();
            }
        }
        String[] array = contents.toString().split("\n");//change this to . ? and !
        for(int i = 0; i< array.length;i++)
        {
            array[i] = array[i].trim();
        }
        return array;
    }

    //step3B
    public static void thirdStep()
    {
        try
        {
            FileWriter myWriter = new FileWriter("/Users/jessicakrapfl/Desktop/Three.txt");//write to this doc
            for(int i = 0;i<input.length;i++)//run through input array
            {
                String str = input[i];
                String[] arrOfStr = str.split(" ");//split the sentence to see how many words are in it
                if(arrOfStr.length <= 10 && str.contains("“") == false && str.contains("”") == false)//if the length of the array is less than or equal to 10
                {														//also i want to keep out anything a character says so i don't want "
                    myWriter.write(str + "\n");//write the word into the file
                }
            }
            myWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
