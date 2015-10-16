import java.io.*;

/**
 * Use a PrintWriter, Buffer and file to write data to a file.
 */
public class TestIOStream
{
    public static void writeToFile(String filename) //throws IOException 
    {
        PrintWriter out = null;
        try {
            File outFile = new File(filename);
            
            FileWriter fout = new FileWriter(outFile);
            BufferedWriter bout = new BufferedWriter(fout);
            out = new PrintWriter(bout);
            
            out.println("I WANDERED lonely as a cloud");
            out.println("That floats on high o'er vales and hills,");
            out.println("When all at once I saw a crowd,");
            out.println("A host, of golden daffodils;");
            out.println("Beside the lake, beneath the trees,");
            out.println("Fluttering and dancing in the breeze.");
        }
        catch(IOException e) {
            System.err.println(e.getMessage());
        }
        finally {
            if(out != null) { out.close(); }
        }
    }

    public static void main(String[] args)
    {
        writeToFile("");
    }
}
