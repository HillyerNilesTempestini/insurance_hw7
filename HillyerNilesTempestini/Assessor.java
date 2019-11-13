import java.util.ArrayList;
import java.util.List;

public class Assessor {
	
	public static int BloodPressureEval (Member member) {
		//String bpRisk = " ";
		int bpRiskScore = 0;
		
		if (member.getBpSyst() < 120 && member.getBpDias() < 80) {
			
			//bpRisk = "Normal";
			bpRiskScore = 0;
			
		} else if ((member.getBpSyst() >= 120 && member.getBpSyst() <= 129) && member.getBpDias() < 80) {
			//bpRisk = "elevated";
			bpRiskScore = 15;
		} else if ((member.getBpSyst() >= 130 && member.getBpSyst() <= 139) || (member.getBpDias() >= 80 && member.getBpDias() <= 89)) {
			//bpRisk = "stage 1";
			bpRiskScore = 30;
		} else if ((member.getBpSyst() >= 140 && member.getBpSyst() <= 179) || (member.getBpDias() >= 90 && member.getBpDias() <= 120)) {
			//bpRisk = "stage 2";
			bpRiskScore = 75;
		}  else if (member.getBpSyst() >= 180 || member.getBpDias() >= 120) {
			//bpRisk = "Crisis";
			bpRiskScore = 100;
		}
		
		return bpRiskScore;
	}
	
	public static int AgeEval (Member member) {
		int ageRisk = 0;
		
		if (member.getAge() < 30) {
			ageRisk = 0;
		} else if (member.getAge() < 45) {
			ageRisk = 10;
		} else if (member.getAge() < 60) {
			ageRisk = 20;
		} else {
			ageRisk = 30;
		}
		
		return ageRisk;
	}
	
	public static int DiseaseEval(Member member) {
		int DiseaseRisk = 0;
		
		if (member.getAlzheimers() == 'y' || member.getAlzheimers() == 'Y') {
			DiseaseRisk = DiseaseRisk + 10;
		}
		
		if (member.getCancer() == 'y' || member.getCancer() == 'Y') {
			DiseaseRisk = DiseaseRisk + 10;
		}
		
		if (member.getDiabeties() == 'y' || member.getDiabeties() == 'Y') {
			DiseaseRisk = DiseaseRisk + 10;
		}
		
		return DiseaseRisk;
		
	}
	
	public static int WeightEval(Member member) {
		double BMI;
		int weightRisk = 0;
		
		BMI = ((member.getWeight() / (member.getHeight() * member.getHeight())) * 703);
			
		if (BMI <= 24.9) {
			weightRisk = 0;
		} else if (BMI >= 25.0 && BMI <= 29.9) {
			weightRisk = 30;
		} else {
			weightRisk = 75;
		}
		
		return weightRisk;
	}
	
	public static int DetermineScore (Member member) {
		int score = BloodPressureEval(member) + AgeEval(member) + DiseaseEval(member) + WeightEval(member);
		return score;
	}

	public static InsuranceScore ProcessInsuranceScoreInfo(String fName, String lName, int score) {
		String risk;
		String fullName = lName + ", " + fName;
		
		//InsuranceScore scoreCards;
		
			if (score <= 20) {
				risk = "Low Risk";
			} else if (score <=50) {
				risk = "ModerateRisk";
			} else if (score <= 75 ) {
				risk = "High Risk";
			} else {
				risk = "Uninsurable";
			}
			
		 InsuranceScore scoreCard = new InsuranceScore(fullName, score, risk);
		 return scoreCard;
		
	}

}

