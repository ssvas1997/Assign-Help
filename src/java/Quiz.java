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
public class Quiz extends HttpServlet {

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
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","root");
            Statement st=con.createStatement();
            int i=(int)session.getAttribute("inx");
            int[] que=(int[])session.getAttribute("que");
            char[] ans=(char[])session.getAttribute("ans");
            int[] vist=(int[])session.getAttribute("vist");
            vist[i]=1;
            
            session.setAttribute("vist",vist);
            String un=session.getAttribute("name").toString();
            ResultSet rs=st.executeQuery("select * from quiz where quiz_id="+que[i]+";");
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Quiz</title>");
            out.println("<link type='text/css' href='CSS/mystyle.css' rel='stylesheet' />");
            out.println("<style>td{padding:10px;font-size:22px;}</style>");
            out.println("<script>function ask(){var a=confirm(\"Do you really want to submit the Quiz?\");return a;}</script>");
            out.println("<script src='CSS/clock.js'></script>");
            out.println("</head>");
            out.println("<body onload='formatTime();'><center>");
            out.println("<div class='dv1'>Assign Help </div>");
            out.println("<div style='float:left;'><input style='background-color:transparent;font-size:30px;border-color:transparent;' type=text disabled id='clk'></div>");
            out.println("<div style='float:right;'></div><br><br>");
            out.println("<table class='tb'><center><tr>");
            for(int k=0;k<10;k++)
            {
                if(k==i)
                    out.println("<td class='tb'><form method=post><input type=hidden name='indx' value="+k+"><input style='width:50px;background-color:#6633BB;' formaction='Jump' type='submit' value="+(k+1)+"></form></td>");
                else if(vist[k]==1&&ans[k]=='0')
                    out.println("<td class='tb'><form method=post><input type=hidden name='indx' value="+k+"><input style='width:50px;background-color:#ff3333;' formaction='Jump' type='submit' value="+(k+1)+"></form></td>");
                else if(vist[k]==1&&ans[k]!='0')
                    out.println("<td class='tb'><form method=post><input type=hidden name='indx' value="+k+"><input style='width:50px;background-color:#66AA22;' formaction='Jump' type='submit' value="+(k+1)+"></form></td>");
                else
                    out.println("<td class='tb'><form method=post><input type=hidden name='indx' value="+k+"><input style='width:50px;' formaction='Jump' type='submit' value="+(k+1)+"></form></td>");
            }
            out.println("</center></tr></table>");
            out.println("<br><form method=post><table>");
            if(rs.next())
            {
                out.println("<tr><td colspan=2>"+(i+1)+". "+rs.getString("que")+"<br></td></tr>");
                if(ans[i]=='a')
                    out.println("<tr align=left><td align=center><input type=radio name=ch value=a checked></td><td>A. "+rs.getString("a")+"</td></tr>");
                if(ans[i]=='0'||ans[i]!='a')
                    out.println("<tr align=left><td align=center><input type=radio name=ch value=a></td><td>A. "+rs.getString("a")+"</td></tr>");
                if(ans[i]=='b')
                    out.println("<tr align=left><td align=center><input type=radio name=ch value=b checked></td><td>B. "+rs.getString("b")+"</td></tr>");
                if(ans[i]=='0'||ans[i]!='b')
                    out.println("<tr align=left><td align=center><input type=radio name=ch value=b></td><td>B. "+rs.getString("b")+"</td></tr>");
                if(ans[i]=='c')
                    out.println("<tr align=left><td align=center><input type=radio name=ch value=c checked></td><td>C. "+rs.getString("c")+"</td></tr>");
                if(ans[i]=='0'||ans[i]!='c')
                    out.println("<tr align=left><td align=center><input type=radio name=ch value=c></td><td>C. "+rs.getString("c")+"</td></tr>");
                if(ans[i]=='d')
                    out.println("<tr align=left><td align=center><input type=radio name=ch value=d checked></td><td>D. "+rs.getString("d")+"</td></tr>");
                if(ans[i]=='0'||ans[i]!='d')
                    out.println("<tr align=left><td align=center><input type=radio name=ch value=d></td><td>D. "+rs.getString("d")+"</td></tr>");
                out.println("<tr align=center><td colspan=2>");
                if(i!=0)
                    out.println("<input type=submit formaction='Prev' value=Previous>&nbsp;&nbsp;");
                if(i!=9)
                    out.println("&nbsp;&nbsp;<input type=submit formaction='Next' value=Next>&nbsp;&nbsp;");
                out.println("&nbsp;&nbsp;<input type=submit onClick='return ask();' formaction='QuizResult' value=Submit>");
            }
            out.println("</td></tr></table>");
            out.println("</form></center>");
            out.println("</body>");
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
