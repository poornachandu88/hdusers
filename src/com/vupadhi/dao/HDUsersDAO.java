package com.vupadhi.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Repository;




@Repository
public class HDUsersDAO
{
	CallableStatement cs = null;
     public final CallableStatement BuildCommand(Session session, final String strParamName,final HashMap<String, String> nvcParams) 
	{
	
		session.doWork(new Work()
		{
			@Override
			public void execute(Connection connection)
			{
				try
				{
					
					cs = connection.prepareCall("{call dbo.SP_VTMS_HDUsers(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				
					cs.setString(1, strParamName);
					cs.setString(2,nvcParams.get("nHelpDeskID"));
					cs.setString(3,nvcParams.get("nUserType"));
					cs.setString(4,nvcParams.get("sUserName"));
					cs.setString(5,nvcParams.get("sPassword"));
					cs.setString(6,nvcParams.get("sName"));
					cs.setString(7,nvcParams.get("sMobileNo"));
					cs.setString(8,nvcParams.get("sEmail"));
					cs.setString(9,nvcParams.get("sRole"));
					cs.setString(10,nvcParams.get("nStatus"));
					cs.setString(11,nvcParams.get("dtCreated"));
					cs.setString(12,nvcParams.get("dtLastLogin"));
					cs.setString(13,nvcParams.get("nFailCount"));
					cs.setString(14, nvcParams.get("sResult"));
				} catch (SQLException e) {}
				
			}

		}
		);

		return cs;
	}
     
 
	}



















//"{call dbo.SP_VTMS_HDUsers(?,?,?,?,?,?,?,?,?,?,?,?)}"

