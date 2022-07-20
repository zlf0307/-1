package handle.data;
import save.data.shopping_carbean;
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
//javac -cp .;servlet-api.jar handle/data/shoppingcar_servlet.java
public class shoppingcar_servlet extends HttpServlet{
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
    }
    public void service (HttpServletRequest request,
        HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username=(String)session.getAttribute("username");
        Connection con=null;
        shopping_carbean shoppingcar=null;
        try{
            shoppingcar=(shopping_carbean)session.getAttribute("recordBean");
            if(shoppingcar==null){
                shoppingcar=new shopping_carbean();
                session.setAttribute("shoppingcar",shoppingcar);
            }
        }
        catch(Exception exp){}
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
            ResultSet rs=sql.executeQuery("SELECT username,comNum,comName,comDes,comSrc,comPrice,cart.comNo FROM cart,commodity where commodity.comNo=cart.comNo");
            ResultSetMetaData metaData=rs.getMetaData();
            int columnCount=metaData.getColumnCount();
            String[] columnName=new String[columnCount];
            for(int i=0;i<columnCount;i++){
                columnName[i]=metaData.getColumnName(i+1);
            }
            shoppingcar.setColumnName(columnName);
            rs.last();
            int rows=rs.getRow();
            String[][] tableRecord= shoppingcar.getTableRecord();
            tableRecord=new String[rows][columnCount];
            rs.beforeFirst();
            int i=0;
            while(rs.next()){
                if(rs.getString(1).equals(username)){
                    for(int k=0;k<columnCount;k++)
                        tableRecord[i][k]=rs.getString(k+1);
                i++;
                }
            }
            shoppingcar.setTableRecord(tableRecord);
            con.close();
            response.sendRedirect("shopping_car.jsp");
        }
        catch(SQLException e){
            response.getWriter().print("<h2>"+e);
            System.out.println(e);
        }
    }
}
