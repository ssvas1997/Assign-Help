<%-- 
    Document   : StudentHome
    Created on : Oct 29, 2018, 4:58:49 PM
    Author     : Srinivas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Home</title>
        
        <link type='text/css' href='CSS/mystyle.css' rel='stylesheet' />
        <script>function validateFileUpload () {
for(i=0;i<document.forms[0].elements.length;++i)
 {
  var elem = document.forms[0].elements[i];
  if (elem.type == "file") {
    
    if (elem.value == "") {
        alert ("please attach your file");
        return ("");
    }
   else
   {
        alert ("Assignment Uploaded Successfully");
   }
  }
 }
}
</script>
    </head>
    <body>
    <center>
       <div class='dv1'>Assign Help </div>
          <div style='float:left;'><input style='background-color:transparent;font-size:30px;border-color:transparent;' type=text disabled id='clk'></div>
          <div style='float:right;'><font size=+3 color=#002277 size=+1><a href=Logout><input type="button" value="Logout"></a></font></div><br><br>
       <h3>Upload Your Assignment here</h3>
       <table>
           <tr>
               <th>
                   Select a file to upload: 
               </th>
               <td>
                <form action = "UploadAssign" method = "post"
                    enctype = "multipart/form-data">
                    <input type = "file" name = "file" size = "50" required />
            </td>
      </tr>
      <tr align="center "><td colspan="2">
              <input type = "submit" onclick="validateFileUpload();" value = "Upload File" />
          </td>
      </tr>
       </table>
       <h4>Note: Please Give Precise names to Your Files.PDF looks Good.</h4>
      </form>
      </center>
      
    <div id="mydiv">
          <div class="updiv">
          <h2>Uploaded Assignments</h2>
          <br>
<!--          <!%
              
              String stud_id=session.getAttribute("uid");
              %>-->

            <c:set var="stud" value="<%=session.getAttribute("uid")%>"/>

          <sql:setDataSource var="assignData" driver="com.mysql.jdbc.Driver" 
                             url="jdbc:mysql://localhost:3306/assignment"
                             user="root"
                             password="root"
                             scope="page"
                             
             />
          
          
          <sql:query  var="UploadAssignQuery"
                      dataSource="${assignData}"
                      scope="page"
                      
                      >
              select * from assign where stud_id=${stud}
          </sql:query>
              <table border="1">
                  <tr> <th>
                           Assignment ID
                      </th>
                      <th>
                          Uploaded Assignments
                      </th>
                  </tr>
        <c:forEach var="row" items="${UploadAssignQuery.rows}">
            <tr>
                <td><c:out value="${row.assign_id}"/></td>
                <td>
                        <a href="Assignments\<c:out value='${row.assign_file_path}'/>"><c:out value="${row.assign_file_path}"/></a>
                </td>
        </tr>
            </c:forEach>
                </table>

      </div>
          
          
            <sql:query  var="SolnQuery"
                      dataSource="${assignData}"
                      scope="page"
                      
                      >
              select * from solution where assign_id IN(select assign_id from assign where stud_id=${stud});
          </sql:query>
          <div class="solndiv">
                <h2>Solution of the Assignments</h2>
                <br>
              <table border="1">
                  <tr>
                      <th>Assignment ID</th>
                      <th>Solution of Assignment</th>
                  </tr>
                  <c:forEach var="row" items="${SolnQuery.rows}">
                      <tr>
                      <td><c:out value="${row.assign_id}"/></td>
                      <td><a href="Solutions\<c:out value="${row.sol_filepath}"/>"><c:out value="${row.sol_filepath}"/></a></td>
                      </tr>
                  </c:forEach>
              </table>
          </div>
    </div>
    </body>
</html>
