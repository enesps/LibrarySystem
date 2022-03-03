/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.Connection;

/**
 *
 * @author User
 */
public class Personel extends Book1 implements LibrarySystem{
    

    //LibrarySytem interface classından override edilen method
    // personel  kısmında eğer getSurname ve password doğru ise true değeri döndürür.
    @Override
    public boolean login(String name,String pasword) {
        setNameSurname(name);
        setPassword(pasword);
        if(getNameSurname().equals("enes") &&getPassword().equals("pusa")){
            return true;
            }
        else{
            return false;
        }
        
        
    }
    

    //personelin seçimlerini olanak kılar.
    //eğer kitap ekleme kısmı seçilirse bookAdd() methodu Book1 classından cağırılır.
    //eğer kitap silme kısmı seçilirse bookDelete() methodu Book1 classından çağırılır.
    //eğer kullanıcı ekleme kısmı seçilirse kullanıcı nameSurname ve password istenerek library database'indeki user table'ına eklenir.
    public void book() {
        Scanner input=new Scanner(System.in);
        System.out.println("kitap ekleme (1)\nkitap çıkarma (2)\nkullanıcı ekleme (3)");
        int select=input.nextInt();
        
        
        
        if(select==1){
            System.out.println("lütfen kitap ismi giriniz");
            setBookName(input.next());
            bookAdd(getBookName());
        }
        else if(select==2){
            System.out.println("lütfen kitap ismi giriniz");
            setBookName(input.next());
            bookDelete(getBookName());
        }
        else if(select==3){
            
            System.out.println("lütfen eklenecek kullanıcı adını giriniz");
                setNameSurname(input.next());
            System.out.println("lütfen eklenecek şifreyi giriniz");
                setPassword(input.next());
            userAdd(getNameSurname(), getPassword());
        }

        
    }

    
   

   
    
}
