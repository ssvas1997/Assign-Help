/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Srinivas
 */
public class QuizResult extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            HttpSession session=request.getSession();
            char[] ans=(char[])session.getAttribute("ans");
            int[] que=(int[])session.getAttribute("que");
            int i=(int)session.getAttribute("inx");
            String name=session.getAttribute("name").toString();
            if(request.getParameter("ch")!=null)
                ans[i]=request.getParameter("ch").charAt(0);
            session.setAttribute("chr",ans[i]);
            session.setAttribute("indx",i);
            session.setAttribute("ans", ans);
            i=0;
            session.setAttribute("inx",i);
            int uid=(int)session.getAttribute("uid");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","root");
            Statement st=con.createStatement();
            int j=0,k=0;
            for(i=0;i<10;i++)
            {
                if(ans[i]=='0')
                    k++;
                else
                {
                    ResultSet rs=st.executeQuery("select * from quiz where quiz_id="+que[i]+";");
                    rs.next();
                    if(rs.getString("ans").charAt(0)==ans[i])
                    {
                        j++;    //rating
                    }
                }
            }
           
            Statement st1=con.createStatement();
            Statement ratingUpdate=con.createStatement();
            ResultSet rs=st1.executeQuery("select * from teacher where teach_id ="+uid);
            if(rs.next())
            {
                int score=rs.getInt("teach_rating");
                if(score<j)
                {
                    ratingUpdate.executeUpdate("update teacher set teach_rating="+j+" where teach_id="+uid);
                }
            }
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>TTest Result</title>");            
            out.println("<link type='text/css' href='CSS/mystyle.css' rel='stylesheet' />");
            out.println("<style>td{padding:5px;font-size:22px;}</style>");
            out.println("</head>");
            out.println("<body><center>");
            out.println("<div class='dv1'>Assign Help</div><div style='float:right;'><font size=+3 color=#002277 size=+1><a href=Logout><input type=\"button\" value=\"Logout\"></a></font></div><br><br>");
            out.println("<form method=post><table>");
            out.println("<tr><td>Name : </td><td>"+name+"</td></tr>");
            out.println("<tr><td>Attempted : </td><td>"+(10-k)+"</td></tr>");
            out.println("<tr><td>Unattempted : </td><td>"+(k)+"</td></tr>");
            out.println("<tr><td>Your Score : </td><td>"+j+"/10</td></tr>");
            
            out.println("<tr><td colspan='2'><center><input type=submit value='Go to home' formaction='TeacherHome'></center></td>");
            out.println("</form></center></body>");
            out.println("</html>");
        }
        catch(Exception e)
        {}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
