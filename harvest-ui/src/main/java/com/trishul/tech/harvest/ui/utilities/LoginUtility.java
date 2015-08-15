/**
 * Copyright © 2015 Trishul Technologies pvt Ltd.
 * This file is part of Harvest project.
 * Harvest project can not be copied and/or distributed without the express
 * permission of Trishul Techologies pvt Ltd. 
 */
package com.trishul.tech.harvest.ui.utilities;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
 
public class LoginUtility {
 
      public static HttpSession getSession() {
        return (HttpSession)
          FacesContext.getCurrentInstance().getExternalContext().getSession(false);
      }
       
      public static HttpServletRequest getRequest() {
       return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
      }
 
      public static String getUserName()
      {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return  session.getAttribute("username").toString();
      }
       
      public static String getUserId()
      {
        HttpSession session = getSession();
        if ( session != null )
            return (String) session.getAttribute("userid");
        else
            return null;
      }
}
