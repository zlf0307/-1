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
//javac -cp .;servlet-api.jar handle/data/deletcom.java
public class deletcom extends HttpServlet{
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
    }
    public void service (HttpServletRequest request,
        HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String classNo = request.getParameter("classNo");
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
            String deleteSQL=
            "delete from cart where comNo='"+classNo+"'";
            int ok=sql.executeUpdate(deleteSQL);
            response.sendRedirect("shoppingcar_servlet");
        }
        catch(SQLException e){
            response.getWriter().print("<h2>"+e);
            System.out.println(e);
        }
    }
}
