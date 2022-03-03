/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;


import java.sql.Connection;
import javax.swing.JOptionPane;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;



public class Book1 {
    
    private String bookName;

    private String nameSurname;
    private String password;

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

   

   
    
    
       
        
        //kitap ekleme methodu
        public void bookAdd(String bookName){
        
        
       
        
          try{
            
            String host = "jdbc:mysql://localhost:3306/library";
            String uName = "root";
            String uPass= "05317312193En.";
            java.sql.Connection con =  DriverManager.getConnection(host,uName,uPass);
  
            java.sql.Statement stmt =  con.createStatement();
            String Sorgu = "INSERT INTO library.book (bookName)VALUES (" + "'" + bookName+  "')";

            stmt.executeUpdate(Sorgu);
             System.out.println("eklendi");


        }
        catch(SQLException err){
            System.out.println("Hata");;}
    }
        
        //kitap silme methodu
        public void bookDelete(String bookName){
        
         try
        {
            String host = "jdbc:mysql://localhost:3306/library";
            String uName = "root";
            String uPass= "05317312193En.";

            java.sql.Connection con1 = DriverManager.getConnection(host,uName,uPass);
            java.sql.Statement stmt =  con1.createStatement();
            String sql="SELECT * FROM library.book WHERE bookName='"+bookName+"'";
            java.sql.ResultSet rs=stmt.executeQuery(sql);
            //kitap eğer database'de varsa silinir.
            if(rs.next()){
                String sqlkod1 = String.format("DELETE FROM library.book WHERE bookName = ('%s')",bookName);//secilen masa silinir
            
            stmt.executeUpdate(sqlkod1);
            
            System.out.println("kitap çıkarıldı");
            
            //kitap database'de değilse olmadığına dahil console uyarısı.
            }else{
                System.out.println("kütüphanede silinecek "+bookName+"adında bir kitap yoktur.");
            }
           

        }
         

        catch(SQLException err)
        {
            
            System.out.println("kitap çıkarma işlemi başarısız");
        }
    }
    public void userAdd(String nameSurname,String password) {
        try{
        String host = "jdbc:mysql://localhost:3306/library";
            String uName = "root";
            String uPass= "05317312193En.";
            Connection con =  DriverManager.getConnection(host,uName,uPass);
  
            Statement stmt =  con.createStatement();
            String Sorgu = "INSERT INTO library.user (nameSurname,password)VALUES (" + "'" + nameSurname+  "','"+password+"')";//yeni kayit icin degerler eklenir

            stmt.executeUpdate(Sorgu);
             System.out.println("eklendi");
        

        //database bağlantı hatası
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(null, "HATA");}
    }
        
        
        // ödünç alma
        public void borrow(String bookName){
               try{
            
            String host = "jdbc:mysql://localhost:3306/library";
            String uName = "root";
            String uPass= "05317312193En.";
            java.sql.Connection con =  DriverManager.getConnection(host,uName,uPass);
  
            java.sql.Statement stmt =  con.createStatement();
             String sql="SELECT * FROM library.book WHERE bookName='"+bookName+"'";
            java.sql.ResultSet rs=stmt.executeQuery(sql);
            
            //kütüphanenin kendi database'inde eğer böyle bir kitap varsa ödünç alınan kitap userBook table'ına eklenir.
            //aynı zamanda kütüphanenin book table'ından silinir.
            if(rs.next()){
                //seçilen kitap userbook table'a eklenir.
                String Sorgu = "INSERT INTO library.userBook (nameSurname,bookName)VALUES (" + "'" +nameSurname+"','"+ bookName+  "')";
                //secilen kitap silinir
                String sqlkod1 = String.format("DELETE FROM library.book WHERE bookName = ('%s')",bookName);

                stmt.executeUpdate(sqlkod1);
                stmt.executeUpdate(Sorgu);
                System.out.println("ödünç alındı");
            }
            else{
                 System.out.println("ödünç alınmak istenen"+bookName+"kitabı kütüphanemizde bulunmamaktadır.");  
               }
            


        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(null, "EROR");}
    }
        
        
        //kitap iadesi
        //kitap iadesinde userBook table'ından seçilen kitap  ve kullanıcı bilgileri kontrol edilir.
        //eğer userbook tableıyla eşleiyorsa seçilen bilgiler kitap geri iade talebi kabul edilir.
        //kütüphanenin book tablenıa tekrar eklenir
        public void giveBack(String bookName){
                 try{
            
            String host = "jdbc:mysql://localhost:3306/library";
            String uName = "root";
            String uPass= "05317312193En.";
            java.sql.Connection con =  DriverManager.getConnection(host,uName,uPass);
  
            java.sql.Statement stmt =  con.createStatement();
            String sql="SELECT * FROM library.userBook WHERE nameSurname='"+nameSurname+"' and bookName ='"+bookName+"'";
            java.sql.ResultSet rs=stmt.executeQuery(sql);
            
            if(rs.next()){
                
                String Sorgu = "INSERT INTO library.book (bookName)VALUES (" + "'" + bookName+  "')";
                //secilen kitap silinir
                String sqlkod1 = String.format("DELETE FROM library.userBook WHERE bookName = ('%s')",bookName);
            
                stmt.executeUpdate(sqlkod1);
                stmt.executeUpdate(Sorgu);
                System.out.println(nameSurname+"adındaki kişi "+bookName+"kitabını iade etmiştir.");
            }else{
                System.out.println(nameSurname+"adındaki kişi "+bookName+"kitabını iade edilecekbir kayıt görünmemektedir.");
            }
           


        }
        catch(SQLException err){
            System.out.println("EROR");;}
    }
         }
         

         
        
        
    
   
