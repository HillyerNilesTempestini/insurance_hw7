package HillyerNilesTempestini;
import java.io.*;
import java.util.*;
import java.beans.*;
import org.json.simple.*;

public class MemberWriter implements Serializable{

    public static void writeMembersToScreen(ArrayList<Member> members) {
        for (Member m : members) {
            System.out.println(m);
            System.out.println("-----------------------------");
        }
    }
    public static boolean writeTextFile(ArrayList<Member> members, String filename) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(
                new FileWriter(new File(filename))));
            for (Member m: members) {
                pw.println(m);
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public static boolean writeBinaryFile(ArrayList<Member> members, String filename) throws IOException {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(new File(filename)));
            oos.writeObject(members);
            oos.close();
            return true;
        } catch(Exception ex) {
            return false;
        }
    }
    public static boolean writeXmlFile(ArrayList<Member> members, String filename) {
        try {
            XMLEncoder xml = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream(filename)));
            xml.writeObject(members);
            xml.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public static boolean writeJSONFile(ArrayList<Member> members, 
    	    String fname) {
    	        try {
    	            PrintWriter pw = new PrintWriter(new BufferedWriter(
    	                    new FileWriter(fname)));
    	            JSONArray array = new JSONArray();
    	            JSONObject obj;
    	            for (Member member : members) {
    	                obj = new JSONObject();
    	                obj.put("first name", member.getFirstName());
    	                obj.put("last name", member.getLastName());
    	                obj.put("age", member.getAge());
    	                obj.put("height", member.getHeight());
    	                obj.put("weight", member.getWeight());
    	                obj.put("BP Syst", member.getBpSyst());
    	                obj.put("BP Dias", member.getBpDias());
    	                obj.put("cancer", member.getCancer());
    	                obj.put("diabetes", member.getDiabeties());
    	                obj.put("alzheimers", member.getAlzheimers());
    	                array.add(obj);
    	            }
    	            JSONObject gradeList = new JSONObject();
    	            gradeList.put("member", array);
    	            pw.println(gradeList.toJSONString());
    	            pw.close();
    	            return true;
    	        } catch (Exception ex) {
    	            return false;
    	        }
    	    }

}

