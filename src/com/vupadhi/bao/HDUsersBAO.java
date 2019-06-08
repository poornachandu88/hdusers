package com.vupadhi.bao;

import java.sql.CallableStatement;
import java.util.HashMap;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vupadhi.dao.HDUsersDAO;



@Repository
public class HDUsersBAO {

	
	@Autowired
	private HDUsersDAO hdUsersDAO;
	

		public CallableStatement GetAllUserList(Session session) {
			HashMap<String, String> nvcTender = new HashMap<>();
			CallableStatement dvTender =  hdUsersDAO.BuildCommand(session,"RTL", nvcTender);
			return dvTender;
		}
		

		public CallableStatement GetHDUserDetails(String sUserName,
				Session session) {
			
			HashMap<String, String> nvcTender = new HashMap<>();
			nvcTender.put("sUserName", sUserName);
			
			CallableStatement dvTender =  hdUsersDAO.BuildCommand(session,"RTU", nvcTender);
			return dvTender;
		}


		public CallableStatement SaveUserDetails(String nUserType,
				String sUserName, String sPassword, String sName,
				String sMobileNo, String sEmail, String sRole, String nStatus,Session session) {
			 
			HashMap<String, String> nvcItems = new HashMap<>();
		
			nvcItems.put("nUserType",nUserType);
			nvcItems.put("sUserName",sUserName);
			nvcItems.put("sPassword", sPassword);
			nvcItems.put("sName", sName);
			nvcItems.put("sMobileNo", sMobileNo);
			nvcItems.put("sEmail",sEmail);
			nvcItems.put("sRole", sRole);
			nvcItems.put("nStatus", nStatus);
		
			
			
			CallableStatement dvItems = hdUsersDAO.BuildCommand(session,"SVR", nvcItems);//TableNames.HDUsers, 
			return dvItems;
			
		}


		

		public CallableStatement updateLastloginDetails(String sUserName,
				Session session) {
			HashMap<String, String> nvcTender = new HashMap<>();
			nvcTender.put("sUserName", sUserName);
			
			CallableStatement dvTender =  hdUsersDAO.BuildCommand(session,"UPD", nvcTender);
			return dvTender;
		
		}


		public CallableStatement updateLastFailCount(String sUserName, Session session) {
			HashMap<String, String> nvcTender = new HashMap<>();
			nvcTender.put("sUserName", sUserName);
			
			
			CallableStatement dvTender =  hdUsersDAO.BuildCommand(session,"UPC", nvcTender);
			return dvTender;
		}


		public CallableStatement GetHDUserPassword(String nHelpDeskID,
				Session session) {

			HashMap<String, String> nvcTender = new HashMap<>();
			nvcTender.put("nHelpDeskID", nHelpDeskID);
			
			
			CallableStatement dvTender =  hdUsersDAO.BuildCommand(session,"RTP", nvcTender);
			return dvTender;
		}


		public CallableStatement updteUserDetails(String nHelpDeskID,
				String sPassword, Session session) {
			HashMap<String, String> nvcItems = new HashMap<>();
			
			nvcItems.put("nHelpDeskID",nHelpDeskID);
			nvcItems.put("sPassword", sPassword);
		
			
			
			CallableStatement dvItems = hdUsersDAO.BuildCommand(session,"UPW", nvcItems);//TableNames.HDUsers, 
			return dvItems;
		}


		/*public CallableStatement updateHDUserProfile(String sPassword,
				String sName, String sMobileNo, String sEmail, String nStatus,
				Session session) {
			
			HashMap<String, String> nvcItems = new HashMap<>();
			nvcItems.put("sPassword", sPassword);
			nvcItems.put("sName", sName);
			nvcItems.put("sMobileNo", sMobileNo);
			nvcItems.put("sEmail",sEmail);
			nvcItems.put("nStatus", nStatus);
			
			CallableStatement dvItems = hdUsersDAO.BuildCommand(session,"UPU", nvcItems);//TableNames.HDUsers, 
			return dvItems;
			
			
			
		}
*/

	
}
