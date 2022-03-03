/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;


import java.util.Scanner;

/**
 *
 * @author User
 */
public class Kullanici extends Book1 implements LibrarySystem{


    
    //LibrarySytem interface classından override edilen method
    //kullanıcı kısmında eğer getSurname ve password doğru ise true değeri döndürür.
    @Override
    public boolean login(String name,String pasword) {
        setNameSurname(name);
        setPassword(pasword);
         try {//kullanıcı giriş yeri

            String host = "jdbc:mysql://localhost:3306/library";
            String uName = "root";
            String uPass= "05317312193En.";

            java.sql.Connection con = java.sql.DriverManager.getConnection(host,uName,uPass);


            java.sql.Statement stmt = con.createStatement();

            String sql="SELECT * FROM library.user WHERE nameSurname='"+getNameSurname()+"' and password ='"+getPassword()+"'";
            java.sql.ResultSet rs=stmt.executeQuery(sql);
            //databasede olma durum sorgusunun kontrolü
            if(rs.next()){
                return true;
               
            }
            else{
                
                return false;
            }
        }
         //sql bağlantı hatası
        catch(java.sql.SQLException err)
        {
            System.out.println("HATA");
            return false;
        }
        
        
    }
    //kullanıcı giriş yerleri
    void bookSelected(){
         Scanner input=new Scanner(System.in);
        System.out.println("ödünç alma (1)\niade etme (2)");
        int select=input.nextInt();
        //kullanıcı kitap ödünç alır.
        //Book1 classından borrow methodundan ödünç alır.
        if(select==1){
             System.out.println("lütfen kitap ismi giriniz");
            setBookName(input.next());
           
            borrow( getBookName());
        }
        //kullanıcı kitap iade eder.
        //Book1 classından giveback() methodundan kitabı iade eder personele.
        //personel ise kütüphanenin database'ine ekler.
        else if(select==2){
             System.out.println("lütfen kitap ismi giriniz");
            setBookName(input.next());
            giveBack( getBookName());        }
        
    }
   
    
   

   
    
}
