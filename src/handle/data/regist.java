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
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//javac -cp .;servlet-api.jar handle/data/regist.java
public class regist extends HttpServlet{
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
    }
    public void service (HttpServletRequest request,
        HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("user_pass");
        String repassword=request.getParameter("reuser_pass");
        if(username.length()==0||password.length()==0||repassword.length()==0){
            String flag1="Please enter your real information";
            session.setAttribute("flag1",flag1);
            response.sendRedirect("regist.jsp");
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
            String url="jdbc:mysql:///jsp?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true";
            String name = "root";
            String mima = "200246yukenan";
            con = DriverManager.getConnection(url, name, mima);
            Statement sql=
            con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1=sql.executeQuery("SELECT * FROM userinform where username='"+username+"'");
            if(rs1.next()){
                String flag="The user already exists";
                session.setAttribute("flag",flag);
                response.sendRedirect("regist.jsp");
                return;
            }
            ResultSet rs=sql.executeQuery("SELECT * FROM userinform");
            rs.moveToInsertRow();
            rs.updateString(1,username);
            rs.updateString(2,password);
            rs.insertRow();
            response.sendRedirect("index.jsp");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}