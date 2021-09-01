import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
/**
 * Data Reader recieves the file from ChartWindow
 * class, analyzes the file, and stores it in an
 * ArrayList.
 *
 * @author (seant01)
 * @version (12.4.20)
 */
public class DataReader
{
    private ArrayList<State> list = new ArrayList<State>();
    private String userfiles = "";
    /**
     * @param userfile is the file recieved
     * from the ChartWindow class.
     */
    public void instantiate(String userfile) 
    {
        userfiles = userfile;
        list = new ArrayList<State>();
    }
    /**
     * @return returns the ArrayList of stored
     * State objects.
     */
    public ArrayList readData() throws FileNotFoundException
    {
        File files = new File(userfiles);
        Scanner scanFile = new Scanner(files);
        scanFile.useDelimiter(",|\\r?\\n");
        while (scanFile.hasNext())
        {
            list.add(new State(scanFile.next(), 
                scanFile.nextInt(), scanFile.nextInt()));
        }
        return list;
    }
}
