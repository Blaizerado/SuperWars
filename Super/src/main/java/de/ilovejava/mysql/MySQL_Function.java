package de.ilovejava.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.ilovejava.superwars.SuperWars;

public class MySQL_Function {
	public static Boolean playerExist(String UUID) {
		try {
			ResultSet rs = SuperWars.mysql.query("SELECT * FROM SuperWars_Stats WHERE UUID= '" + UUID +"'");
			if(rs.next()) {
				return rs.getString("UUID") !=null;
			}
			return false;
		} catch (SQLException e) {}
		return false;
	}
	
	public static void createPlayer(String UUID) {
		SuperWars.mysql.update("INSERT INTO SuperWars_Stats(UUID,Kills,Deaths,BedBreakes) VALUES('"+UUID+"','0','0','0')");
	}
	
	public static Integer getKills(String UUID) {
		int i=0;
		try {
			ResultSet rs = SuperWars.mysql.query("SELECT * FROM SuperWars_Stats WHERE UUID='"+UUID+"'");
			if(rs.next()) {
				i = rs.getInt("Kills");
			}
		}catch(Exception e) {}
		return i;
	}
	
	public static Integer getDeaths(String UUID) {
		int i = 0;
		try {
			ResultSet rs = SuperWars.mysql.query("SELECT * FROM SuperWars_Stats WHERE UUID='"+UUID+"'");
			if(rs.next()) {
				i = rs.getInt("Deaths");
			}
		} catch (Exception e) {}
		return i;
	}
	
	public static Integer getBedBreaks(String UUID) {
		int i = 0;
		try {
			ResultSet rs = SuperWars.mysql.query("SELECT * From SuperWars_Stats WHERE UUID='"+UUID+"'");
			if(rs.next()) {
				i = rs.getInt("BedBreakes");
			}
		}catch(Exception e) {}
		return i;
	}
	
	public static void giveKills(String UUID, Integer ammount) {
		int newammount = getKills(UUID)+ammount;
		SuperWars.mysql.update("UPDATE SuperWars_Stats SET Kills='"+newammount+"' WHERE UUID='"+UUID+"'");
	}
	
	public static void giveDeaths(String UUID, Integer ammount) {
		int newammount = getDeaths(UUID)+ammount;
		SuperWars.mysql.update("UPDATE SuperWars_Stats SET Deaths='"+newammount+"' WHERE UUID='"+UUID+"'");
	}
	
	public static void giveBeds(String UUID, Integer ammount) {
		int newammount = getBedBreaks(UUID)+ammount;
		SuperWars.mysql.update("UPDATE SuperWars_Stats SET BedBreakes='"+newammount+"' WHERE UUID='"+UUID+"'");
	}
}
