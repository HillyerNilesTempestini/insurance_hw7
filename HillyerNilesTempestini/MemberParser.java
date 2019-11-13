package HillyerNilesTempestini;

import java.io.*;


public class MemberParser implements Serializable{
/**
 * @author Sam Tempestini
 * @param 
 * @return
 */
	public static Member memberParser(String current)
	{
		Member mem = new Member();
		String[] parts = current.split("\\t");
		mem.setFirstName(parts[0].trim());
		mem.setLastName(parts[1].trim());
		mem.setAge(Integer.parseInt(parts[2].trim()));
		mem.setHeight(Integer.parseInt(parts[3].trim()));
		mem.setWeight(Integer.parseInt(parts[4].trim()));
		mem.setBpSyst(Integer.parseInt(parts[5].trim()));
		mem.setBpDias(Integer.parseInt(parts[6].trim()));
		mem.setCancer(parts[7].trim());
		mem.setDiabeties(parts[8].trim());
		mem.setAlzheimers(parts[9].trim());
		return mem;
	}
	
}
