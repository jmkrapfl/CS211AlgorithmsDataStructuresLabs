import java.io.*;
public class fiveLetterWords
{
    public static String[] words = load("/Users/jessicakrapfl/Desktop/words.txt");
    public static void main(String args[])
    {
        try
        {
            FileWriter myWriter = new FileWriter("/Users/jessicakrapfl/Desktop/5LetterWords.txt");//write to this doc
            for(int i = 0; i< words.length; i++)
            {
                char[] chars = words[i].toCharArray();
                if(chars.length==5 && !words[i].matches("[A-Z|0-9]"))
                {
                    myWriter.write(words[i] + "\n");//write the word into the file
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

    //Load Method
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
}
