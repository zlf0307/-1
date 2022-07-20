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
//javac -cp .;servlet-api.jar handle/data/log_out.java
public class log_out extends HttpServlet{
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
    }
    public void service (HttpServletRequest request,
        HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        session.removeAttribute("username");
        response.sendRedirect("index.jsp");
    }    
}
