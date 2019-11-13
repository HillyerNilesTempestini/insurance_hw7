package HillyerNilesTempestini;
import java.util.*;
import java.io.*;
import java.beans.*;

/** 
 * 
 * @author Sam Tempestini
 * @author Chelsea Niles
 *
 */

@SuppressWarnings("unchecked")
public class MemberReader implements Serializable{
	
	
	public static ArrayList<Member> readTextFile(String fname) throws FileNotFoundException
	{
		ArrayList<Member> mems = new ArrayList<Member>();
		ArrayList<String> lines = new ArrayList<String>();
		String line,cur;
		// local members vars

		
		try {
			Scanner fsc = new Scanner(System.in);
			fsc = new Scanner(new File(fname));	
			
			while(fsc.hasNextLine())
			{
				line = fsc.nextLine().trim();
				if (line.length() > 0)
				{
					lines.add(line); 
				}	
			}
			for(int i = 0; i < lines.size(); ++i)
			{
				cur = lines.get(i);
				Member m  = MemberParser.memberParser(cur);
				mems.add(m);
			}
			
		}catch(FileNotFoundException fnfe) {
			System.out.println("ERROR occurred...Could NOT find specified file.");
			return null;
		}
		
		return mems;
	}
    public static ArrayList<Member> readBinaryFile(String fname) {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(new File(fname)));
            ArrayList<Member> result = (ArrayList<Member>)ois.readObject();
            ois.close();
            return result;
        } catch (Exception ex) {
            return null;
        }
    }

    public static ArrayList<Member> readXmlFile(String fname) throws IllegalAccessException{
        try {
            XMLDecoder xml = new XMLDecoder(new BufferedInputStream(
                new FileInputStream(fname)));
            ArrayList<Member> result = (ArrayList<Member>)xml.readObject();
            xml.close();
            return result;
        } catch (Exception ex) {
            return null;
        }
    }

}
