/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;
/**
 *
 * @author Srinivas
 */
public class UploadSolution extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     private boolean isMultipart;
        private String filePath;
        private int maxFileSize = 50000 * 1024;
        private int maxMemSize = 50000 * 1024;
        private File file ;
           public void init( ){
            // Get the file location where it would be stored.
            filePath = getServletContext().getInitParameter("file-upload-solution"); 
         }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
        isMultipart = ServletFileUpload.isMultipartContent(request);
        HttpSession session = request.getSession();
        int teach_id=(int)session.getAttribute("uid");
        int assign_id=0;
        String fileName="";
        
        if( !isMultipart ) {
           out.println("<html>");
           out.println("<head>");
           out.println("<title>Servlet upload</title>");  
                      
           out.println("</head>");
           out.println("<body>");
           out.println("<p>No file uploaded</p>"); 
           out.println("</body>");
           out.println("</html>");
           return;
        }
     
  
      DiskFileItemFactory factory = new DiskFileItemFactory();
   
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
   
      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("c:\\temp"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      
      List  items = upload.parseRequest(request);
      Iterator iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();

            if (item.isFormField()) {

              String name = item.getFieldName();//text1
              String value = item.getString();
              assign_id=Integer.parseInt(value);
            }
            else{
                String fieldName = item.getFieldName();
                fileName = item.getName();
                String contentType = item.getContentType();
                boolean isInMemory = item.isInMemory();
                long sizeInBytes = item.getSize();
                // Write the file
                if( fileName.lastIndexOf("\\") >= 0 ) {
                   file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
                } else {
                   file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                }
                item.write( file ) ;
                out.println("Uploaded Filename: " + fileName + "<br>");
            }
        }
   
         // maximum file size to be uploaded.
         upload.setSizeMax( maxFileSize );
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet upload</title>");  
         out.println("</head>");
         out.println("<body>");
         Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","root");
        PreparedStatement ps= con.prepareStatement("INSERT into solution(assign_id,teach_id,sol_filepath) values(?,?,?)");
        ps.setInt(1, assign_id);
        ps.setInt(2, teach_id);
        ps.setString(3, fileName);
        int res=ps.executeUpdate();

        Statement stmt = con.createStatement();
        stmt.executeUpdate("Update assign set is_over='yes' where assign_id="+assign_id+"");

        response.sendRedirect("SolveAssigns.jsp");
        
         out.println("</body>");
         out.println("</html>");
         
        }catch(Exception e){}
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
