import java.util.Scanner;
public class CS211Lab7
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int origBase = sc.nextInt();
        int newBase = sc.nextInt();
        int num = sc.nextInt();

        //System.out.println(base10(origBase,num));
        int b10 = base10(origBase,num);
        //if newBase ==16 push into hex method
        System.out.println(newB(b10,newBase));
    }

    //*******First convert to base 10**********
    public static int base10(int origBase, int num)
    {
        String numStr = Integer.toString(num);
        int base10num = 0;
        int exp =  numStr.length()-1;
        int indexNum=0;
        for(int i = 0;i<numStr.length();i++)
        {
            indexNum = Integer.parseInt(String.valueOf(numStr.charAt(i)));

            base10num += indexNum *(int) Math.pow(origBase,exp);
            exp--;
        }
        return base10num;
    }

    //********Convert to the new base**********
    public static String newB(int b10,int newBase)
    {

        String newBStr = "";
        while(b10 !=0)
        {
            //get the remainder of b10 and the new base and put it in a string
            String temp;
            if(b10%newBase>9)
            {
                temp = toHex(b10%newBase);
            }
            else
            {
                temp = Integer.toString(b10 % newBase);//if b10 %newBase > 10 -> use letters
            }
            newBStr += temp;

            //divide b10 by the new base
            b10 = b10/newBase;
        }
        //reverse newBStr
        String revStr = "";
        for(int i =newBStr.length()-1;i>=0;i--)
        {
            revStr += newBStr.charAt(i);
        }
        return revStr;
    }

    //***********B10 to hex*******
    public static String toHex(int num)
    {
        String hex = "123456789ABCDEF";
        return String.valueOf(hex.charAt(num-1));
    }



    //*******If its a hexadecimal*********
    public static int hexToDeci(String num)
    {
        String hex = "123456789ABCDEF";
        int base10 = 0;
        int exp = num.length()-1;;

        for(int i =0;i<num.length();i++)
        {
            int hexVal = 0;
            //find the val of num.charAt(i)
            while(num.charAt(i) != hex.charAt(hexVal))
            {
                hexVal++;
            }
            hexVal++;
            base10 += hexVal *(int) Math.pow(16,exp);
            exp--;
        }
        return base10;
    }
}
