package HillyerNilesTempestini;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class InsuranceScoreWriter {
    public static boolean writeJSONFile(ArrayList<InsuranceScore> assessments, 
    	    String fname) {
    	        try {
    	            PrintWriter pw = new PrintWriter(new BufferedWriter(
    	                    new FileWriter(fname)));
    	            JSONArray array = new JSONArray();
    	            JSONObject obj;
    	            for (InsuranceScore assessment: assessments) {
    	                obj = new JSONObject();
    	                obj.put("name", assessment.getName());
    	                obj.put("score", assessment.getScore());
    	                obj.put("risk level", assessment.getRiskLevel());
    
    	                array.add(obj);
    	            }
    	            JSONObject gradeList = new JSONObject();
    	            gradeList.put("assessment", array);
    	            pw.println(gradeList.toJSONString());
    	            pw.close();
    	            return true;
    	        } catch (Exception ex) {
    	            return false;
    	        }
    	    }
    
    	public static void PrintScoreCard(ArrayList<InsuranceScore> IS) {
        for (InsuranceScore temp : IS) {
            System.out.println(temp);
        }
	
	}
}
