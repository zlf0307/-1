package handle.data;
// javac -cp .;servlet-api.jar handle/data/ShowCom.java
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import save.data.Show_Bean;
public class ShowCom extends HttpServlet{
    public void init(ServletConfig config)throws ServletException{
        super.init(config);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e){}
    }
    public void service(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException{
        HttpSession session =request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("GB2312");
        String comNo= request.getParameter("comNo");
        int no=Integer.parseInt(comNo);
        Show_Bean trans =null;
        try{
            trans =(Show_Bean)session.getAttribute("trans");
            if(trans==null){
                trans =new Show_Bean();
                session.setAttribute("trans", trans);
            }
        }
        catch(Exception e){}
        // Show_Bean trans =new Show_Bean();
        trans.setComNo(no);
        Connection con=null;
        // response.getWriter().print(no);
        try{
//            response.getWriter().print("1111");
            String url = "jdbc:mysql://localhost:3306/jsp?user=root&password=200246yukenan&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL";
            con=DriverManager.getConnection(url);
            Statement statement =con.createStatement();
            // response.getWriter().print("1111");
            ResultSet rs= statement.executeQuery("select * from commodity where comNo="+no);
            while(rs.next()){
            String name= rs.getString(2);
            String des= rs.getString(3);
            String src= rs.getString(4);
            int price= rs.getInt(5);
            // response.getWriter().print(name);
            trans.setComName(name);
            trans.setComDes(des);
            trans.setComSrc(src);
            trans.setComPrice(price);
            }
            con.close();
            response.sendRedirect("tran.jsp");
        }
        catch(Exception e){
        }
    }
}
