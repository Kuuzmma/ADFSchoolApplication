package view.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import view.common.MyADFUtil;

public class LoginBean {
    private RichInputText usernameInputText;
    private RichInputText passwordInputText;

    public LoginBean() {
    }

    public void setUsernameInputText(RichInputText usernameInputText) {
        this.usernameInputText = usernameInputText;
    }

    public RichInputText getUsernameInputText() {
        return usernameInputText;
    }

    public void setPasswordInputText(RichInputText passwordInputText) {
        this.passwordInputText = passwordInputText;
    }

    public RichInputText getPasswordInputText() {
        return passwordInputText;
    }

    public String loginAction()
      {
        String username = getUsernameInputText().getValue().toString();
        String password = getPasswordInputText().getValue().toString();
        
        System.out.println("username: " + username + " - password: " + password);
        
        PreparedStatement stat = null;
        ResultSet rs = null;
        Connection conn = null;
        try
        {
          String sql = "select school_principal_name from school_information where school_principal_username='" + username + "' and SCHOOL_PRINCIPAL_PASWORD='" + password + "'";
          conn = MyADFUtil.getConnection();
          stat = conn.prepareStatement(sql);
          rs = stat.executeQuery();
            
          while(rs.next())
          {
            System.out.println(rs.getString(1));
            MyADFUtil.putInSessionScope("username", username);
            MyADFUtil.putInSessionScope("principalName", rs.getString(1));
            return "dashboard";
          }
        }
        catch (Exception e)
        {
          // TODO: Add catch code
          e.printStackTrace();
        }
        MyADFUtil.showErrorMessage("Invalid username or password");
        return null;
      }
    public String logoutAction()
      {
        try
        {
          FacesContext context = FacesContext.getCurrentInstance();
          HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
          if (session != null)
          {
            session.invalidate();
          }
        }
        catch (Exception e)
        {
          System.err.println("error in logout -- " + e);
        }
        return "index";
      }
}
