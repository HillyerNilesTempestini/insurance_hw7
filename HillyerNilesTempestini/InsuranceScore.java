package HillyerNilesTempestini;
import java.util.ArrayList;

/**
 * 
 * @author Chris Hillyer
 * @author Sam Tempestini
 * @author Chelsea Niles
 *
 */
public class InsuranceScore {
	private String name;
	private int score;
	private String riskLevel;
	ArrayList <InsuranceScore> scores = new ArrayList<InsuranceScore>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(String riskLevel) {
		
		this.riskLevel = riskLevel;
	}
	
	public InsuranceScore(String name, int score, String riskLevel) {
		setName(name);
		setScore(score);
		setRiskLevel(riskLevel);
	}
	
	@Override
	public String toString() {
		return String.format("Here are the insurance assessments: \t\n"
				 +"Name:%30s\n"
				 +"Score:%28s\n" 
				 +"Risk Level:%23s\n", getName(), getScore(), getRiskLevel());
	}
	
	public static void PrintScoreCard(ArrayList<InsuranceScore> IS) {
        for (InsuranceScore temp : IS) {
            System.out.println(temp);
        }
	
	}
	

}
