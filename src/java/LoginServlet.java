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
public class LoginServlet extends HttpServlet {

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
            HttpSession session=request.getSession(true);
            String uname=request.getParameter("un");
            String pass=request.getParameter("ps");
            String ut=request.getParameter("utype");
            String table="";
            String col1="";
            String col2="";
            
            if(ut.equals("1"))
            {
               table="student";
               col1="stud_email";
               col2="stud_password";
            }
                
            else
            {
                table="teacher";
                col1="teach_email";
                col2="teach_password";
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("<link type='text/css' href='CSS/mystyle.css' rel='stylesheet' />");            
            out.println("</head>");
            out.println("<body><center>");
            out.println("<div class=dv1>Assign Help</div><br>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","root");
            Statement st1=con.createStatement();
            ResultSet rs=st1.executeQuery("select * from "+table+" where "+col1+"='"+uname+"' and "+col2+"='"+pass+"';");
            
            if(rs.next())
            {
                session.setAttribute("uname",uname);
//                session.setAttribute("st",st1);
                session.setAttribute("uid", rs.getInt(1));
                session.setAttribute("name", rs.getString(2));
                if(ut.equals("1"))
                    response.sendRedirect("StudentHome.jsp");
                else
                    response.sendRedirect("TeacherHome");
                //For redirection to the dashboard we need to check whether the user is student or teacher
                
                //The BELOW PART IS USED FOR TESTING PURPOSE
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<title>Login</title>");            
//                out.println("</head>");
//                out.println("<body>");
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<title>Servlet QuizResult</title>");            
//                out.println("<link type='text/css' href='CSS/mystyle.css' rel='stylesheet' />");
//                out.println("</head>");
//                out.println("<body><center>");
//                out.println("<h1><font color=red>Welcome, "+session.getAttribute("name")+"</font></h1>");
//                out.println("</center></body>");
//                out.println("</html>");
            }
            else
            {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet QuizResult</title>");            
                out.println("<link type='text/css' href='CSS/mystyle.css' rel='stylesheet' />");
                out.println("</head>");
                out.println("<body><center>");
                out.println("<h1><font color=red>Sorry..Your Credentials are wrong..try again..!</font></h1>");
                out.println("<br><a href='Login.html'><input type=button value='<-Back<-'></a>");
                out.println("</center></body>");
                out.println("</html>");
            }
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
