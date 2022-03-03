/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library;

import java.util.Scanner;


public class Library {


    public static void main(String[] args) {
        Personel personel = new Personel();
        Kullanici kullanici=new Kullanici();

        Scanner input=new Scanner(System.in);
      boolean TaF=true;
        //kütüphanemizin çalışma yeri
        while(TaF){
            System.out.println("Personel girişi (1)\nKullanıcı girişi (2)\nÇıkış (3)\nlütfen girmek istediğiniz logini seçiniz"); 
            int select=input.nextInt();
            if(select==1){
               System.out.println("lütfen personel username'i giriniz:");
               
                personel.setNameSurname(input.next());
                System.out.println("lütfen personel şifresini giriniz:");
                personel.setPassword(input.next());
                //login girişindeki bilgiler doğru ise true döndürür.ve if bloğuna girer.
                if(personel.login(personel.getNameSurname(), personel.getPassword())){
                    int gir=1;
                   while(gir!=0){
                      //personel bloğundaki book() methodu çağıralaarak kitap ekleme kitap çıkarma ve kullanıcı ekleme işlemleri yapılır.
                      personel.book();
                       System.out.println("çıkmak için 0' a basınız:");
                      int giris=input.nextInt();
                      gir=giris;
                   }
                }    
                 else{
                    System.out.println("hatalı giriş");
                }   
            }
            //personel girişi
            else if(select==2){
             System.out.println("lütfen kullanıcı username'i giriniz:");
                
                kullanici.setNameSurname(input.next());
                System.out.println("lütfen kullanıcı şifresini giriniz:");
                kullanici.setPassword(input.next());
                
                //personel loginindeki bilgiler doğru ise true döndürür.
                if(kullanici.login(kullanici.getNameSurname(), kullanici.getPassword())){
                     int gir=1;
                   while(gir!=0){
                      //kullanıcı işlemleri yapılır. ödünç alma ve iade etme..
                      kullanici.bookSelected();
                       System.out.println("çıkmak için 0' a basınız:");
                      int giris=input.nextInt();
                      gir=giris;
                   }

                    
                }else{
                    System.out.println("hatalı giriş");
                }
            }
            //sistemden çıkış 
            else if(select==3){
                TaF=false;
            }
            else{
                System.out.println("Hatalı seçim");
            }
            
        }
        
    }
    
}
