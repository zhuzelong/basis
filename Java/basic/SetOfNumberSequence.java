import java.util.ArrayList;

/**
 * Using ArrayList class to create a list of number sequence
 */
public class SetOfNumberSequence
{
    private ArrayList list;
    /**
     * Constructor, create a new array list
     */
    public SetOfNumberSequence()
    {
        ArrayList list=new ArrayList();
    }

    /** 
     * Add number sequence to the array list
     */
    public void add(NumberSequence seq)
    {
        list.add(seq);
    }

    /**
     * @return value, return a value of the given index
     */
    public NumberSequence get(int index)
    {
        NumberSequence result;
        result=(NumberSequence)list.get(index);
        return result;
    }

    /**
     * main function, to test the array list
     */
    public static void main(String[] args)
    {
        NumberSequence seq1=new NumberSequence(10,2);
        NumberSequence seq2=new NumberSequence(200,-1);
        SetOfNumberSequence sons=new SetOfNumberSequence();
        sons.add(seq1);
        sons.add(seq2);
        int index=20;
        System.out.println(sons.get(index));
    }
}
