package handle.data;
// javac -cp .;servlet-api.jar handle/data/add.java
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import save.data.Show_Bean;

public class add extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {}
    }
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("GB2312");
        // String num =(String)session.getAttribute("num");
        String num = request.getParameter("num");
        Connection con = null;
        if (num == null || num.length() == 0) {
            response.sendRedirect("tran.jsp");
        }
        Show_Bean trans = null;
        try {
            trans = (Show_Bean) session.getAttribute("trans");
            String username = (String) session.getAttribute("username");
            if (username == null || username == "") {
                response.sendRedirect("tran.jsp");
            }
            // response.getWriter().print(username);
            int comNo = trans.getComNo();
            String url = "jdbc:mysql://localhost:3306/jsp?user=root&password=200246yukenan&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL";
            con = DriverManager.getConnection(url);
            Statement statement = con.createStatement();
            ResultSet rs1=statement.executeQuery("SELECT * FROM cart where comNo='"+comNo+"'and username='"+username+"'");
            if(rs1.next()){
                String flag="The commodity already exists";
                session.setAttribute("flag",flag);
                response.sendRedirect("tran.jsp");
                return;
            }
            statement.executeUpdate("insert into cart values('" + username + "'," + comNo + "," + num + ")");
            con.close();
            response.sendRedirect("jump.jsp");
        } catch (Exception e) {}
    }
}