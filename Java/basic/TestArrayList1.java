import java.util.*;

/**
 * Array list containing 0, 1, ...size-1, all Integer. The size comes from command line argument. Timing for different size.
 */
public class TestArrayList1
{
    public static List<Integer> generateList(int size)
    {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0; i<size; i++)
            list.add(i);
        return list;
    }

    // Try: int array, not a list
    public static int[] generateIntArray(int size)
    {
        int[] list=new int[size];
        for(int i=0; i<size; i++)
            list[i]=i;
        return list;
    }

    // return all values between given indices
    public static int[] getRange(List<Integer> list, int start, int end)
    {
        int[] result=new int[end-start+1];
        for(int i=start; i<=end; i++)
            result[i-start]=list.get(i);
        return result;
    }
    
    // Test 
    public static void main(String[] args)
    {
        int size=Integer.parseInt(args[0]);
        int start=Integer.parseInt(args[1]);
        int end=Integer.parseInt(args[2]);
        
        // time the creation of list
        long timeList=System.currentTimeMillis();
        List list=generateList(size);
        long timeTakenList=System.currentTimeMillis()-timeList;

        // time the creation of primitive array
        long timeArray=System.currentTimeMillis();
        int[] array=generateIntArray(size);
        long timeTakenArray=System.currentTimeMillis()-timeArray;
        
        // time the retrive of List
        long timeListRetrive=System.currentTimeMillis();
        int[] result=getRange(list, start, end);
        long timeTakenListRetrieve=System.currentTimeMillis()-timeListRetrive;

        // time the retrive of primitive array

        System.out.println("Time taken for list= "+timeTakenList+"\nTime taken for primitive array= "+timeTakenArray);
        System.out.println("Time taken for retrive list= "+timeTakenListRetrieve);
    }
}
