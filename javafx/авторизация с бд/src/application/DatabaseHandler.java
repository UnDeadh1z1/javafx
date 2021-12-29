package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs {
	Connection dbConnection;
	public Connection getDbConnection() 
			throws ClassNotFoundException, SQLException {
		String connetionString ="jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
		Class.forName("com.mysql.cj.jdbc.Driver");
		dbConnection = DriverManager.getConnection(connetionString, dbUser, dbPass);
		return dbConnection;
	}  

	public void singupuser(User user) {
		String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_ID + "," + Const.USERS_FIO + "," + Const.USERS_DOLZ + "," + Const.USERS_LOG + "," + Const.USERS_PASS + ")"
				+ "VALUES(?,?,?,?,?)";

		try {
			PreparedStatement prSt = getDbConnection().prepareStatement(insert);
			prSt.setInt(1,user.getID());
			prSt.setString(2, user.getFio());
			prSt.setString(3, user.getdolznost());
			prSt.setString(4, user.getlog());
			prSt.setString(5, user.getpas());
			
			prSt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public ResultSet getUser (User user) {
		ResultSet resSet= null;
		String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_LOG + "=? AND " + Const.USERS_PASS + "=?" ;
		try {
			PreparedStatement prSt = getDbConnection().prepareStatement(select);

			prSt.setString(1, user.getlog());
			prSt.setString(2, user.getpas());
			
			resSet=prSt.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return resSet;
	}
	
}
