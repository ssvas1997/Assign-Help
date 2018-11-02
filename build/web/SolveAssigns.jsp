<%-- 
    Document   : SolveAssigns
    Created on : Oct 30, 2018, 11:03:51 AM
    Author     : Srinivas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
                <link type='text/css' href='CSS/mystyle.css' rel='stylesheet' />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        alert ("Solution Uploaded Successfully");
   }
  }
 }
}</script>
    </head>
    <body><center>
         <div class='dv1'>Assign Help </div>
          <div style='float:left;'><input style='background-color:transparent;font-size:30px;border-color:transparent;' type=text disabled id='clk'></div>
          <div style='float:right;'><font size=+3 color=#002277 size=+1><a href=Logout><input type="button" value="Logout"></a></font></div><br><br>
        <h1>Assignments to be Solved</h1>
         <c:set var="Teach" value="<%=session.getAttribute("uid")%>"/>
          <sql:setDataSource var="assignData" driver="com.mysql.jdbc.Driver" 
                             url="jdbc:mysql://localhost:3306/assignment"
                             user="root"
                             password="root"
                             scope="page"
                             
             />
          
          
          <sql:query  var="AssignQuery"
                      dataSource="${assignData}"
                      scope="page"
                      
                      >
              select * from assign where teach_id=${Teach} and is_over='No';
          </sql:query>
          
              <table border="1">
                  <tr>
                      <th>Assignment ID</th>
                      <th>Assignment</th>
                  </tr>
         
        <c:forEach var="row" items="${AssignQuery.rows}">
            <tr>   
                <td>  <c:out value="${row.assign_id}"/></td>
                    
                <td> <a href="Assignments\<c:out value='${row.assign_file_path}'/>"><c:out value="${row.assign_file_path}"/></a></td>
            </tr>   
            </c:forEach>
                 </table>
                  <br><br><br>
              
              <form method="post" action="UploadSolution" enctype = "multipart/form-data">
                  <table border="1">
                      <tr>
                          <th>
                              Assignment ID
                          </th>
                          <td>
                              <select name="assignid">
                                <c:forEach var="row" items="${AssignQuery.rows}">
                                    <option value="<c:out value="${row.assign_id}"/>"><c:out value="${row.assign_id}"/></option>   
                                 </c:forEach>
                              </select>
                          </td>
                      </tr>
                      <tr>
                          <th>Upload Solution File</th>
                          <td> <input id="f" type = "file" name = "file" size = "50" required/></td>
                      </tr>
                      <tr>
                          <td colspan="2"><input type="submit" onclick="validateFileUpload();" value="Upload"></td>
                      </tr>
                  </table>
              </form>
    </center>
    </body>
</html>
