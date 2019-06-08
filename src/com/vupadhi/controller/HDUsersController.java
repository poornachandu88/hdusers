package com.vupadhi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vupadhi.bean.HDUsersBean;
import com.vupadhi.service.HDUsersService;

@Controller
public class HDUsersController {
	
	@Autowired
	HDUsersService hdUsersService;


	@ModelAttribute("HDUsersForm")
	public HDUsersBean getLoginForm() {
	return new HDUsersBean();

	}


	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView gethomepage() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "HomePage");
		return mv;

	}
	
	@RequestMapping(value ="/SaveHDUsers")
	public String saveAdminUserTypes(@ModelAttribute("HDUsersForm") HDUsersBean hDUsersBean,
	                             HttpSession session, ModelMap model, HttpServletRequest request)
	{
		final String METHOD_NAME = "saveHDUsers";
		
		 try{
			 
			 model.addAttribute("sUserName", request.getParameter("sUserName"));
			 model.addAttribute("sPassword", request.getParameter("sPassword"));
			 String sUserName=request.getParameter("sUserName");
			 String sPassword=session.getAttribute("nUserID").toString();
			 model.addAttribute("backBtn", "hide");
			 //Retrieving AdminLinks From tblAdminLiks
			// List<HDUsersBean> adminLinksList=hdUsersService.getAdminUserLinks(sUserName);
			// model.addAttribute("adminLinksList", adminLinksList);
			 //For Select No Records Display
			  if(request.getParameter("hdnnUserType").equals("0"))
			  {
				  model.addAttribute("adminusertype", "Please Select Admin User Type");
					return "Admin/AdminUserType";
			  }
	          //For Saving Initialization Variable
			  int save = 0;
			  
			  String[] selCheckBox = request.getParameterValues("nLink");

				if (null == selCheckBox || selCheckBox.length == 0) {
					model.addAttribute("selChkBoxMesg", "Please Select At least one Admin User");
					return "Admin/AdminUserType";
				}
				
				StringBuilder sb = new StringBuilder();
				sb.append("<AdminUserTypes>" + "\n");
				for (int i = 0; i < selCheckBox.length; i++) {
					sb.append("<AdminUserLinks>" + "\n");
					sb.append("<nLinkID>" + selCheckBox[i]+ "</nLinkID>" + "\n");
					sb.append("</AdminUserLinks>" + "\n");

				}
				sb.append("</AdminUserTypes>");
				//save = hdUsersService.saveAdminUserLinks(sUserName,sb.toString(), sPassword); 
			   if(save > 0)
			   {
				   model.addAttribute("saveMesg", "AdminUserTypes Saved Successfully");
				   
				 //  List<HDUsersBean> adminUserLinksList=hdUsersService.getAdminUserLinks(hDUsersBean.getsUserName());
					 //For Each Loop for Checking Condition Check Box is Checked or Not
				//		 for (HDUsersBean adminLinks : adminLinksList) {
				//				 for (HDUsersBean adminUserLinks : adminUserLinksList) {
				//					if(adminLinks.getsUserName().equals(adminUserLinks.getsPassword()))
				//					{
										//adminLinks.setSelChkBox("1");
						//			}
				//				  }
				//		    }
						 
					//	model.addAttribute("adminLinksList", adminLinksList);
						model.addAttribute("backBtn", "hide");
			   }
			   else {
					model.addAttribute("saveMesg", "AdminUserTypes Not Saved");
					
					//  List<HDUsersBean> adminUserLinksList=hdUsersService.getAdminUserLinks(hDUsersBean.getsUserName());
						 //For Each Loop for Checking Condition Check Box is Checked or Not
					//		 for (HDUsersBean adminLinks : adminLinksList) {
								/*	 for (HDUsersBean adminUserLinks : adminUserLinksList) {
										if(adminLinks.getsUserName().equals(adminUserLinks.getsPassword()))
										{
											//adminLinks.setSelChkBox("1");
										}
									  }
							    }*/
							 
							//model.addAttribute("adminLinksList", adminLinksList);
							model.addAttribute("backBtn", "hide");
				}
			  
		
			
			 
		 }catch(Exception e)
		 {
			 
			 
			
		 }
		
		return "Admin/AdminUserType";
	}
	
	



}
