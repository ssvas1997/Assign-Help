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

/**
 *
 * @author Srinivas
 */
public class NewUser extends HttpServlet {

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
            String nm=request.getParameter("nm1");
            String ph=request.getParameter("phn");
            String em=request.getParameter("eml");
            String ps=request.getParameter("pass");
            String ut=request.getParameter("utype");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration</title>");
            out.println("<link type='text/css' href='CSS/mystyle.css' rel='stylesheet' />");            
            out.println("</head>");
            out.println("<body><center>");
            out.println("<div class=dv1>Assign Help</div><br>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","root");
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
            int id=0;
            int i=0,j=0;
            ResultSet rs1=st1.executeQuery("select * from student where stud_email='"+em+"';");
            ResultSet rs2=st2.executeQuery("select * from teacher where teach_email='"+em+"';");
            if(rs1.next() || rs2.next())
                j=1;
            if(j==0)
            {
                if(ut.equals("1"))
                {
                    i=st1.executeUpdate("insert into student (stud_name,stud_contact,stud_email,stud_password) values('"+nm+"','"+ph+"','"+em+"','"+ps+"');");
                    if(i>0)
                    {
                        out.println("<H1><font color='#002277'>Student User registered successfully</font></H1>");
                        out.println("<br><a href='Login.html'><input type='button' value='Login' /></a>");
                    }
                    else
                    {
                        out.println("<H1><font color=red>Student User not registered</font></H1>");
                        out.println("<br><a href='NewUser.html'><input type='button' value='<-Back<-' /></a>");
                    }
                }
                else
                {
                    i=st2.executeUpdate("insert into teacher (teach_name,teach_contact,teach_email,teach_password,teach_rating) values('"+nm+"','"+ph+"','"+em+"','"+ps+"',"+0+");");
                    if(i>0)
                    {
                        out.println("<H1><font color='#002277'>Teacher User registered successfully </font></H1>");
                        out.println("<br><a href='Login.html'><input type='button' value='Login' /></a>");
                    }
                    else
                    {
                        out.println("<H1><font color=red>Teacher User not registered</font></H1>");
                        out.println("<br><a href='NewUser.html'><input type='button' value='<-Back<-' /></a>");
                    }
                }
            }
            else
            {
                out.println("<H1><font color=red>Email already registered</font></H1>");
                out.println("<H1><font color=red>User not registered</font></H1>");
                out.println("<br><a href='NewUser.html'><input type='button' value='<-Back<-' /></a>");
            }
            out.println("</center></body>");
            out.println("</html>");
        }catch(Exception e)
        {
            out.println(e);
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
