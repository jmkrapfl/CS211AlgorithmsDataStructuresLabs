import java.util.Scanner;
import java.util.Random;
public class CS211Lab4
{
    public static int[] numArr;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int showIndex = sc.nextInt();
        int len = end-start+1;
        numArr = new int[len];
        int[] colltazNums = new int[len];
        int index = 0;
        for(int i=start;i<=end;i++)
        {
            numArr[index] = i;//give the value to numArr
            colltazNums[index] = colltazLen(numArr[index])-1;//give the value of the colltazLen to colltazNums
            //System.out.println(numArr[index]);
            index++;
        }

        quicksort(colltazNums);//quick sort by colltaz
        clean(colltazNums);// check for any of the same and switch them around if needed
        //print out

        for(int i=0;i<len;i++)
        {
           System.out.println(colltazNums[i]+ " " +numArr[i]);
        }

        System.out.println(numArr[showIndex-1]);
    }
    //*******SORT BY COLLTAZ NUM******//
    private static void quicksort(int[] ColltazArray)
    {
        quicksort(ColltazArray, 0, ColltazArray.length - 1);
    }

    private static void quicksort(int[] ColltazArray, int lowIndex, int highIndex)
    {
        if (lowIndex >= highIndex)
        {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;//get a random index to pivot from
        int pivot = ColltazArray[pivotIndex];//the number at the index found above
        swap(ColltazArray, pivotIndex, highIndex);//call swap to move that num to the end

        int leftPointer = partition(ColltazArray, lowIndex, highIndex, pivot);

        quicksort(ColltazArray, lowIndex, leftPointer - 1);
        quicksort(ColltazArray, leftPointer + 1, highIndex);

    }

    private static int partition(int[] ColltazArray, int lowIndex, int highIndex, int pivot)
    {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer)
        {
            // step from the left until we find a number greater than the pivot or hit the right pointer
            while (ColltazArray[leftPointer] <= pivot && leftPointer < rightPointer)
            {
                leftPointer++;
            }
            // step from the right until we find a number less than the pivot or hit the left pointer
            while (ColltazArray[rightPointer] >= pivot && leftPointer < rightPointer)
            {
                rightPointer--;
            }
            swap(ColltazArray, leftPointer, rightPointer);
        }
        if(ColltazArray[leftPointer] > ColltazArray[highIndex])
        {
            swap(ColltazArray, leftPointer, highIndex);
        }
        else
        {
            leftPointer = highIndex;
        }

        return leftPointer;
    }

    private static void swap(int[] ColltazArray, int index1, int index2)
    {
        //swap colltaz
        int tempColl = ColltazArray[index1];
        ColltazArray[index1] = ColltazArray[index2];
        ColltazArray[index2] = tempColl;
        //swap regular
        int tempNum = numArr[index1];
        numArr[index1] = numArr[index2];
        numArr[index2] = tempNum;
    }
    //********COLTAZ LENGTH********//
    public static int colltazLen(int num)
    {
        if(num ==1)
        {
            return 1;
        }
        else if(num %2 !=0)//if its an odd num
        {
            return 1+colltazLen(3*num+1);
        }
        else//if its an even num
        {
            return 1+colltazLen(num/2);
        }
    }

    //******Fix any ones that are the same*****//
    public static void clean(int[] colltazLen)
    {

        for(int i =0;i<colltazLen.length;i++)
        {
            for(int j=0;j<colltazLen.length-1;j++)
            {
                if(colltazLen[j]==colltazLen[j+1])
                {
                    if(numArr[j]> numArr[j+1])
                    {
                        swap(colltazLen,j,j+1);
                    }
                }
            }

        }
    }
}
