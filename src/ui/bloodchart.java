/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Akhil
 * BarChart_AWT in line 22 24 changing to bloodchart
 */
   // import jfree.chart.ChartFactory;
import bbank.DB.DButil;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

//public class bloodchart extends ApplicationFrame {
 public class bloodchart extends JFrame {
   ResultSet resultSet = null;
   String selectSql;
           DButil dbconn= new DButil();
          Connection conn = dbconn.getConnection(); 
   public bloodchart( String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Blood Group",            
         "Units",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );  
      
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
   }
   
   private CategoryDataset createDataset( ) {
      final String available = "Available";        
      final String demand = "Demand";        
      final String Use = "Use";        
      final String a = "A+";  
  final String a1 = "A-";       
      final String b = "B+";   
       final String b1 = "B-";   
      final String ab = "AB+";  
  final String ab1 = "AB-";         
      final String o = "O+";   
      final String o1 = "O-";  
      final DefaultCategoryDataset dataset =       new DefaultCategoryDataset( );  
      // available data
 selectSql = "select sum(quantity),bgroup_name from bbank_stock group by bgroup_name;";
    
      try {
           Statement stmt;
          int qty=0;
          String group;
             // stmt = conn.createStatement();
              stmt =  conn.createStatement();
              resultSet = stmt.executeQuery(selectSql);
              //available data
      dataset.addValue( 0.1 , available , a );
        dataset.addValue( 0.1 , available , a1 );    
      dataset.addValue( 0.1 , available , b );   
       dataset.addValue( 0.1 , available , b1 ); 
     dataset.addValue( 0.1 , available , ab ); 
      dataset.addValue( 0.1 , available , ab1 ); 
     dataset.addValue( 0.1 , available , o );  
      dataset.addValue( 0.1 , available , o1 ); 
             while (resultSet.next()) {
                
                 qty=resultSet.getInt(1);
                group=resultSet.getString(2);
                switch(group) {
  case "A+":
    dataset.addValue( qty , available , a );  
    break;
  case "A-":
   dataset.addValue( qty , available , a1 );  
    break;
     case "B+":
     dataset.addValue( qty , available , b );  
    break;
  case "B-":
     dataset.addValue( qty , available , b1 );  
    break;
     case "AB+":
     dataset.addValue( qty , available , ab );  
    break;
  case "AB-":
    dataset.addValue( qty , available , ab1 );  
    break;
     case "O+":
    dataset.addValue( qty , available , o );  
    break;
  case "O-":
    dataset.addValue( qty , available , o1 );  
    break;
  default:
    // code block
}
            
            
             }//while
             
            
            // conn.close();                                  
            
         // conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(DonorregJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        
//demand
 selectSql = "select sum(quantity),bgroup_name from blood_demand group by bgroup_name;";
    
      try {
           Statement stmt;
          int qty=0;
          String group;
             // stmt = conn.createStatement();
              stmt =  conn.createStatement();
              resultSet = stmt.executeQuery(selectSql);
                dataset.addValue( 0.1 , demand , a );   
                 dataset.addValue( 0.1 , demand , a1 );   
     dataset.addValue( 0.1 , demand , b );    
      dataset.addValue( 0.1 , demand , b1 );   
      dataset.addValue( 0.1 , demand , ab );  
 dataset.addValue( 0.1 , demand , ab1 );         
      dataset.addValue( 0.1 , demand , o );
       dataset.addValue( 0.1 , demand , o1 );   
             while (resultSet.next()) {
                
                 qty=resultSet.getInt(1);
                 System.out.println ("demand "+qty);
                group=resultSet.getString(2);
                switch(group) {
  case "A+":
    dataset.addValue( qty , demand , a );  
    break;
  case "A-":
   dataset.addValue( qty , demand , a1 );  
    break;
     case "B+":
     dataset.addValue( qty , demand , b );  
    break;
  case "B-":
     dataset.addValue( qty , demand , b1 );  
    break;
     case "AB+":
     dataset.addValue( qty , demand , ab );  
    break;
  case "AB-":
    dataset.addValue( qty , demand , ab1 );  
    break;
     case "O+":
    dataset.addValue( qty , demand , o );  
    break;
  case "O-":
    dataset.addValue( qty , demand , o1 );  
    break;
  default:
    // code block
}
            
            
             }//while
             
            
            // conn.close();                                  
            
         // conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(DonorregJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
       

//demand

   
//use
selectSql = "select sum(quantity),bgroup_name from bbank_issued group by bgroup_name;";
    
      try {
           Statement stmt;
          int qty=0;
          String group;
             // stmt = conn.createStatement();
              stmt =  conn.createStatement();
              resultSet = stmt.executeQuery(selectSql);
               dataset.addValue( 0.1 , Use , a ); 
               dataset.addValue( 0.1 , Use , a1 ); 
               dataset.addValue( 0.1 , Use , ab ); 
               dataset.addValue( 0.1 , Use , ab1 ); 
               dataset.addValue( 0.1 , Use , b ); 
               dataset.addValue( 0.1 , Use , b1 ); 
               dataset.addValue( 0.1 , Use , o ); 
               dataset.addValue( 0.1 , Use , o1 ); 
             while (resultSet.next()) {
                
                 qty=resultSet.getInt(1);
                group=resultSet.getString(2);
                switch(group) {
  case "A+":
    dataset.addValue( qty , Use , a );  
    break;
  case "A-":
   dataset.addValue( qty , Use , a1 );  
    break;
     case "B+":
     dataset.addValue( qty , Use, b );  
    break;
  case "B-":
     dataset.addValue( qty , Use , b1 );  
    break;
     case "AB+":
     dataset.addValue( qty , Use , ab );  
    break;
  case "AB-":
    dataset.addValue( qty , Use , ab1 );  
    break;
     case "O+":
    dataset.addValue( qty , Use , o );  
    break;
  case "O-":
    dataset.addValue( qty , Use , o1 );  
    break;
  default:
    // code block
}
            
            
             }//while
             
            
            // conn.close();                                  
            
         // conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(DonorregJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
       


      return dataset; 
   }
}
    

