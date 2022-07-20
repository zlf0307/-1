package handle.data;
import java.sql.*;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.Context;
import java.util.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.geom.*;
import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
//javac -cp .;servlet-api.jar handle/data/query.java
public class query extends HttpServlet{
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
    }
    public void service (HttpServletRequest request,
        HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("user_pass");
        if(username.length()==0||password.length()==0){
            String flag1="Please enter the content";
            session.setAttribute("flag1",flag1);
            response.sendRedirect("login.jsp");
            return;
        }
        session.setAttribute("username",username);
        Connection con=null;
        try{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            String url="jdbc:mysql://localhost:3306/jsp?user=root&password=200246yukenan&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL";
            con = DriverManager.getConnection(url);
            Statement sql=
            con.createStatement();
            ResultSet rs=sql.executeQuery("SELECT * FROM userinform where username='"+username+"' and password='"+password+"'");
            if(rs.next()){
                    response.sendRedirect("index.jsp");
                    return;
            }
            String flag="The user is not exists";
            session.setAttribute("flag",flag);
            response.sendRedirect("login.jsp");
            return;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
