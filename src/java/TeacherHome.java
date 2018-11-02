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
public class TeacherHome extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session=request.getSession();
            
            int[] que=new int[10];
            char[] ans=new char[10];
            int[] vist=new int[10];
            int rnd=1+(int)(Math.random()*40);
            que[0]=rnd;
            for(int i=1;i<10;i++)
            {
                rnd=1+(int)(Math.random()*40);
                for(int j=0;j<i;j++)
                {
                    if(que[j]==rnd)
                    {
                        i--;
                        break;
                    }
                    else
                    {
                        que[i]=rnd;
                    }
                }
            }
            for(int i=0;i<10;i++)
            {
                ans[i]='0';
                vist[i]=0;
            }
            session.setAttribute("que", que);
            session.setAttribute("ans", ans);
            session.setAttribute("vist", vist);
            session.setAttribute("inx", 0);
            
            int id=(int)session.getAttribute("uid");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","root");
            Statement st1=con.createStatement();
            ResultSet rs=st1.executeQuery("select * from teacher where teach_id="+id+";");
            int rating=0;
            if(rs.next())
            {
                rating=rs.getInt("teach_rating");
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Teacher Home</title>");
            out.println("<link type='text/css' href='CSS/mystyle.css' rel='stylesheet' />");
            out.println("<script >sessionStorage.h = 0;sessionStorage.m = 1;sessionStorage.s = 0;</script>"); 
            out.println("</head>");
            out.println("<body><center>");
            out.println("<div class='dv1'>Assign Help</div><div style='float:right;'><font size=+3 color=#002277 size=+1><a href=Logout><input type=\"button\" value=\"Logout\"></a></font></div><br>");
            out.println("<font size=+2 color=#002277><h2>Welcome, "+session.getAttribute("name")+"</h2>");
            out.println("<h3>Rating : "+rating+"/10</h3>");
            out.println("<form method=post><table width=20%>");
            out.println("<tr align=center><td><input type=submit formaction='Quiz' id=\"btn\" value='Improve Score'></td></tr>");
            out.println("<tr align=center><td><input type=submit formaction='SolveAssigns.jsp' id='btn' value='Solve Question'></td></tr>");
            out.println("</table></form>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
        }
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
