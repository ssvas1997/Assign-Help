
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Srinivas
 */
public class AllocAssign {
    int stud_id;
    String fileName,isOver;
    int Expected_teach_id;
    String teach_contact;
    public AllocAssign()
    {
        System.out.println("started con"+stud_id);
    }
    public void allocateAssignment(int stud_id,String fileName,String isOver)throws Exception
    {
        System.out.println("started method"+stud_id);
        this.stud_id=stud_id;
        this.fileName = fileName;
        this.isOver = isOver;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","root");
        Statement st1=con.createStatement();
        ResultSet rs1=st1.executeQuery("Select teach_id, teach_rating from teacher");
        String sql="SELECT\n" +
            "(SELECT count(assign_id) from assign where teach_id=?)-\n" +
            "(SELECT count(sol_id) from solution where teach_id=?) AS Difference";
        
        
        ArrayList<Model> arrayRes= new ArrayList<>();
        while(rs1.next())
        {
            PreparedStatement ps1=con.prepareStatement(sql);
            ps1.setInt(1, rs1.getInt(1));
            ps1.setInt(2, rs1.getInt(1));
            ResultSet rs2=ps1.executeQuery();
            if(rs2.next())
            arrayRes.add(new Model(rs1.getInt(1),rs1.getInt(2),rs2.getInt(1)));
            rs2.close();
            ps1.close();
            
        }
        Collections.sort(arrayRes);
        System.out.println("Sorted array");
        for(Model w:arrayRes){
            if(w.getPending()<=2)
            {
                //Insert Query and break out of loop
               Expected_teach_id=w.getTeach_id();
               System.out.println("Expected :"+Expected_teach_id);
               String sqlTeach = "INSERT INTO assign(stud_id,assign_file_path,is_over,teach_id) values(?,?,?,?)";
              PreparedStatement pstmt = con.prepareStatement(sqlTeach);
              pstmt.setInt(1, stud_id);
              pstmt.setString(2,fileName);
              pstmt.setString(3,isOver);
              pstmt.setInt(4, Expected_teach_id);
              pstmt.executeUpdate();
              System.out.println("INSERTED TEACH ID");
              
               break; 
            }
            
            Statement smsPrep = con.createStatement();
            ResultSet smsResult = smsPrep.executeQuery("Select teach_contact from teacher where teach_id="+Expected_teach_id+"");
            if(smsResult.next())
            {
                teach_contact = smsResult.getString("teach_contact");
            }
            
        }
        
    }
}
