package com.vupadhi.service;

import java.sql.CallableStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.vupadhi.bao.HDUsersBAO;

import com.vupadhi.bean.HDUsersBean;


@Service
public class HDUsersService {

	@Autowired
	HDUsersBAO hdUsersBAO;

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public List<HDUsersBean> getHDUsersList() throws SQLException {
	
		List<HDUsersBean> hduserslist = null;
		CallableStatement cstmt = null;
		Session session = sessionFactory.openSession();
		ResultSet resultSet = null;
		HDUsersBean hdUsersBean = null;
		try {
			hduserslist = new ArrayList<>();
			cstmt = hdUsersBAO.GetAllUserList(session);
			resultSet = cstmt.executeQuery();

			while (resultSet.next()) {

				hdUsersBean = new HDUsersBean();
				hdUsersBean.setnHelpDeskID(resultSet.getString("nHelpDeskID"));
				hdUsersBean.setnUserType(resultSet.getString("nUserType"));
				hdUsersBean.setsUserName(resultSet.getString("sUserName"));
				hdUsersBean.setsPassword(resultSet.getString("sPassword"));
				hdUsersBean.setsName(resultSet.getString("sName"));
				hdUsersBean.setsMobileNo(resultSet.getString("sMobileNo"));
				hdUsersBean.setsEmail(resultSet.getString("sEmail"));
				hdUsersBean.setsRole(resultSet.getString("sRole"));
				hdUsersBean.setnStatus(resultSet.getString("nStatus"));
				hdUsersBean.setDtCreated(resultSet
								.getString("dtCreated"));
				hdUsersBean.setDtLastLogin(resultSet
								.getString("dtLastLogin"));
				hdUsersBean.setnFailCount(resultSet.getString("nFailCount"));

				hduserslist.add(hdUsersBean);

			}

		} catch (SQLException e) {

			throw e;

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException se) {

			}
			try {
				if (cstmt != null) {
					cstmt.close();
				}
			} catch (SQLException se) {

			}
			if (session != null) {
				session.close();
			}
		}

		return hduserslist;
	}

	
	public HDUsersBean getHDUserDetails(String sUserName)  {
	
		HDUsersBean hdUsersBean = null;
		CallableStatement cstmt = null;
		Session session = sessionFactory.openSession();
		ResultSet resultSet = null;
		
		
		try {
			cstmt = hdUsersBAO.GetHDUserDetails(sUserName, session);
			resultSet=cstmt.executeQuery();
			while (resultSet.next()) 
			{
				hdUsersBean = new HDUsersBean();
				hdUsersBean.setnHelpDeskID(resultSet.getString("nHelpDeskID"));
				hdUsersBean.setsUserName(resultSet.getString("sUserName"));
				hdUsersBean.setsPassword(resultSet.getString("sPassword"));
				hdUsersBean.setnUserType(resultSet.getString("nUserType"));
				hdUsersBean.setnStatus(resultSet.getString("nStatus"));
			}
			

		} catch (SQLException e) {

			try {
				throw e;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException se) {

			}
			try {
				if (cstmt != null) {
					cstmt.close();
				}
			} catch (SQLException se) {

			}
			if (session != null) {
				session.close();
			}
		}

		return  hdUsersBean;

	}

	

	public boolean addHDUsers( String nUserType, String sUserName,
			String sPassword, String sName, String sMobileNo, String sEmail,
			String sRole, String nStatus) {

		CallableStatement cstmt = null;
		Session session = sessionFactory.openSession();
	
		boolean res = false;

		try { 
			
			cstmt = hdUsersBAO.SaveUserDetails(nUserType, sUserName, sPassword,
					sName, sMobileNo, sEmail, sRole, nStatus,  session);
			
			res=cstmt.execute();
			

		} catch (SQLException se) {

			try {
				throw se;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} finally {
			try {
				if (cstmt != null) {
					cstmt.close();
				}
				if (session != null) {
					session.close();
				}
			} catch (SQLException se) {

			}
		}
		return res;
	}


	public void updateUserLastLogin(String sUserName) throws SQLException 
	{
		
		CallableStatement cstmt = null;
		Session session = sessionFactory.openSession();
		
		try {
			
			cstmt = hdUsersBAO.updateLastloginDetails(sUserName,session);
					cstmt.execute();
		
		} catch (SQLException se) {

			throw se;

		} finally {
			try {
				if (cstmt != null) {
					cstmt.close();
				}
				if (session != null) {
					session.close();
				}
			} catch (SQLException se) {

			}
		}
	
	}


	public void updateUserLoginFailCount(String sUserName) throws SQLException {
		CallableStatement cstmt = null;
		Session session = sessionFactory.openSession();
		
		try { 
			
			cstmt = hdUsersBAO.updateLastFailCount(sUserName,session);
					cstmt.execute();
		
		} catch (SQLException se) {

			throw se;

		} finally {
			try {
				if (cstmt != null) {
					cstmt.close();
				}
				if (session != null) {
					session.close();
				}
			} catch (SQLException se) {

			}
		}
		
		
	}

/*
	public HDUsersBean getHDUserPassword(String nHelpDeskID) {
		// TODO Auto-generated method stub
		
	
	
	
	}*/


	public String getHDUserPasswordupdate(String nHelpDeskID,String sPassword ) {
	
		
	
		CallableStatement cstmt = null;
		Session session = sessionFactory.openSession();
	
		String res = "";

		try { 
			
			cstmt = hdUsersBAO.updteUserDetails(nHelpDeskID,sPassword,session);
			
			cstmt.registerOutParameter("pin_sResult", java.sql.Types.NVARCHAR);
			
			cstmt.execute();
			res = cstmt.getString("pin_sResult");

		} catch (SQLException se) {

			try {
				throw se;
			} catch (SQLException e) {
		
				e.printStackTrace();
			}

		} finally {
			try {
				if (cstmt != null) {
					cstmt.close();
				}
				if (session != null) {
					session.close();
				}
			} catch (SQLException se) {

			}
		}
		return res;
		
		
		
	
	
	
	
	}


	public HDUsersBean getHDUserPasswordcheck(String nHelpDeskID) {
	
		
		
		HDUsersBean hdUsersBean = null;
		CallableStatement cstmt = null;
		Session session = sessionFactory.openSession();
		ResultSet resultSet = null;
		
		
		try {
			cstmt = hdUsersBAO.GetHDUserPassword(nHelpDeskID, session);
			resultSet=cstmt.executeQuery();
			while (resultSet.next()) 
			{
				hdUsersBean = new HDUsersBean();
				hdUsersBean.setnHelpDeskID(resultSet.getString("nHelpDeskID"));
				hdUsersBean.setsPassword(resultSet.getString("sPassword"));
				
			}
			

		} catch (SQLException e) {

			try {
				throw e;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException se) {

			}
			try {
				if (cstmt != null) {
					cstmt.close();
				}
			} catch (SQLException se) {

			}
			if (session != null) {
				session.close();
			}
		}

		return  hdUsersBean;
	
		
	
	
	}


	/*public String updateHDUsers(String sPassword, String sName,
			String sMobileNo, String sEmail, String nStatus) {
		
		CallableStatement cstmt = null;
		Session session = sessionFactory.openSession();
	
		String res = "";
		
		try {  
			
			
			cstmt = hdUsersBAO.updateHDUserProfile( sPassword,
					sName, sMobileNo, sEmail, nStatus,  session);
			
			cstmt.registerOutParameter("pin_sResult", java.sql.Types.NVARCHAR);
			
			cstmt.execute();
			res = cstmt.getString("pin_sResult");
			
			
			
		
		}catch (SQLException se) {

			try {
				throw se;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} finally {
			try {
				if (cstmt != null) {
					cstmt.close();
				}
				if (session != null) {
					session.close();
				}
			} catch (SQLException se) {

			}
		}
		return res;
	
	}

	*/
	}


