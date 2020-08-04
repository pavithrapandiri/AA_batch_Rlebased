package pack;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.relevantcodes.extentreports.LogStatus;

import oracle.jdbc.OracleTypes;

public class BProc extends AA_ILP{

	public static void bproc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("before conn");
		// Open a connection
		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.242:1521:QFUNDUAT2", prop.getProperty("db_username"),
					prop.getProperty("db_username"));

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		System.out.println("after conn");
		try {
		
			resultSet = stmt.executeQuery("Delete  From   Bo_Phone Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code in (403))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Other_Info Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code in (403))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Income Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code in (403))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Address Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code in (403))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Bank_Acnt Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code in (403))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Reference Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code in (403))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Notes Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code in (403))");
			resultSet = stmt.executeQuery("Delete  From   ACH_STAGING Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code in (403))");
			resultSet = stmt.executeQuery("DELETE FROM    st_il_RCPT A WHERE A.iLOAN_TRAN_CODE IN (SELECT iLOAN_TRAN_CODE  From  st_il_trans Where iloan_code In (Select iloan_code From st_il_Master Where st_code in (403)))");
			resultSet = stmt.executeQuery("DELETE FROM    st_il_DISB A WHERE A.iLOAN_TRAN_CODE IN (SELECT iLOAN_TRAN_CODE  From  st_il_trans Where iloan_code In (Select iloan_code From st_il_Master Where st_code in (403)))");
			resultSet = stmt.executeQuery("DELETE FROM    st_il_distribution A WHERE A.iLOAN_TRAN_CODE IN (SELECT iLOAN_TRAN_CODE  From  st_il_trans Where iloan_code In (Select iloan_code From st_il_Master Where st_code in (403)))");
			resultSet = stmt.executeQuery("DELETE FROM    st_il_Trans WHERE iLOAN_CODE IN (SELECT iLOAN_CODE  From  st_il_master Where st_code in (403))");
			resultSet = stmt.executeQuery(" Delete  From   st_il_master where st_code in (403)");
			resultSet = stmt.executeQuery("Delete  From   Bo_Master Where bo_st_code in (403)");
			resultSet = stmt.executeQuery("Delete  From   ILP_ACH_TRANS Where st_code in (403)");
			resultSet = stmt.executeQuery("Commit");

			 while (resultSet .next())
			{
				System.out.println(
						/*resultSet .getString(1) + "  " +
									 * resultSet.getString(2) + "  " +
									 * resultSet.getString(3) + "  " +
									 * resultSet.getString(4) + "  " +
									 * resultSet.getString(5)
									 */);
			}
			System.out.println("after query");
			test.log(LogStatus.PASS, "Proceduer run successfully");

			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		} catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}

}
