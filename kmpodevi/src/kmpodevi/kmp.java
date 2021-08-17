package kmpodevi;
import java.util.Random;
// kullanýcýdan almak için random fonksiyonunu kullandýk

import java.util.Scanner;
// kullanýcýdan giriþleri almak için scan fonksiyonunu kullandýk


class kmp {
 void kmparama(String diziB, String diziA)
 {
     int M = diziB.length();
     int N = diziA.length();
//önceki sonraki deðerlerini öðrenmek için bir pi dizisi yaratýyorux
     int pi[] = new int[M];
     int q = 0; // b dizisinin indexi
     int i = 0; //a dizisinin indexi
     int dene = 0;
     // burada öncelikle pi dizimizi bulmak istiyoruzö
     oncekisonrakibul(diziB, M, pi);

    //i den n büyük olana kadar dönüyor
     
     while (i < N) {
    	 // bu ifte deðerleri kontrol ediyoruz eþitliði yani
         if (diziB.charAt(q) == diziA.charAt(i)) {
        	 //eðer eþit deðillerse bir sonraki harfe geçiyor
             q = q +1;
             i= i+1;
         }
         // buraki if in q ve m eþitse çýktý veriyoruz. bulduk diye
         if (q == M) {
             System.out.println("B metninin bulunduðu konumlar "    + (i - q));
             q = pi[q - 1]; //deðeri deðiþtiriyoruz ki devam edelim
             dene =1;
         }

         // uyumsuzluklarý deðerlendiriyoruz
         else if (i < N && diziB.charAt(q) != diziA.charAt(i)) {
             // eþleþip iþleþmemeli için deðerlendirmeleri yapýyoruz
             if (q != 0)
             {   
            	 q = pi[q - 1];
            	 }
             else
             { 
            	 i = i + 1;
            	 }
         }
     }
     if (dene == 0)
     { //eþleþme bulunamadý kontrolü
    	 System.out.println("Eþleþme bulunamadý");
     }
 }

 void oncekisonrakibul(String diziB, int M, int pi[])
 {
     // önceki en uzun ön ekin uzunluðunu bulmak için bu fonk var uzunluk deðiþkeni önce sýfýr oalrak tanýmlanýr
     int uzunluk = 0;
     int i = 1;
     pi[0] = 0; // pi[0] 0 olarak baþlatýyoruz. her zaman böyle baþlamasý gerekir

     // while döngüsü, i = 1 ve M-1 için pi [i] 'yi hesaplar
     while (i < M) {
    	 //m den küçük olana kadar devam eder
    	 /*eþleþme varsa i ve uzunluk aradýnda uzunluðu bir arttýrýyoruz ve sonra pi[i] yi uzunluða ekleriz
    	  *  dizi b kontrol edilir
    	  * else döngüsünde ise 
    	  * dizi a kontrl ediliyor
    	  */
         if (diziB.charAt(i) == diziB.charAt(uzunluk)) {
             uzunluk= uzunluk +1;
             pi[i] = uzunluk;
             i = i+1;
         }
         else 
         {
           // bu arammada kaç basamaða kadar yapýldýðýna bakýyoruz
             if (uzunluk != 0) {
                 uzunluk = pi[uzunluk - 1];

                 //  fakat burada i nin deðerini arttýrmadýk 
             }
             else 
            	 //bu durum uzunluðun ölçülmesi için yapýldý
             { //pi i yi uzunluða eþitliyoruz ve i nin deðerini bir arttýrýyoruz
                 pi[i] = uzunluk;
                 i = i+1;
             }
         }
     }
 }

 
 public static void main(String args[])
 {    
     //kullanýcýdan m ve n deðelrerini almak için bir al isimli deðiþken oluþruduk
      Scanner al = new Scanner(System.in);
      //kullanýcýdan hangi dizi boyutunu almak istediðimizi söylemek için println kullandýk
      System.out.println("A dizisi boyutunu giriniz:");
      // kullanýcýdan n boyutunu aldýk
      int N = al.nextInt();
      //kullanýcýdan b dizisi boyutunu girmesini istedik
      System.out.println("B dizisi boyutunu giriniz:");
// m deðerini aldýk
      int M = al.nextInt();
      //a dizisinden rastgele karakter alabilmek için gelcnm adlý fonksiyonumuzu kullandýk 
      //once diziAyý çaðýrdýk
      String diziA= gelcnm(N);
      //dizi b yi çaðrýdýk
      String diziB = gelcnm(M);
      //burada dizilerimizin görünebilmesi için iki tane print yaptk dizi a ve dizi b için 
      System.out.println("A dizisi oluþturuldu: " +diziA);
      System.out.println("B dizisi oluþturuldu: "+diziB);
      
//kmp classý içindeki kmp arama fonksiyonunu çaðýrdýk
     new kmp().kmparama(diziB, diziA);
    
 }
 // bu metodumuz bize istediðimiz diziyi oluþturmamýzý saðlýyor
public  static String gelcnm ( int sayi)
{ // bir n ve m sayilarýni almak için int sayi tanýmladýk
  //sayim deðiþkeni sadece strng olarak 0 ve 1 deðerlerini istediðimizi gösteriyor
	String sayim = "01";
	//string builder birleþtirme yapma iþlemi  için kullanýlýr
	StringBuilder yarat = new StringBuilder();
	//random fonksiyonu kullandýk 
	Random rnd = new Random();
	// burada kaç tane yaratacaðýmýzý belirlemek için bir while döngüsü kullandýk while içinde oluþturuyoruz.
	while( yarat.length() < sayi)
	{
		int index = (int) (rnd.nextFloat()*sayim.length());
		yarat.append(sayim.charAt(index));
	}
	// ddizi yarattýðýmýz deðerin döndürülmesini saðlar
	String dizi = yarat.toString();
	// oluþturduðumuz dizimizi gönderiyoruz
	return dizi;
}
}