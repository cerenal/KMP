package kmpodevi;
import java.util.Random;
// kullan�c�dan almak i�in random fonksiyonunu kulland�k

import java.util.Scanner;
// kullan�c�dan giri�leri almak i�in scan fonksiyonunu kulland�k


class kmp {
 void kmparama(String diziB, String diziA)
 {
     int M = diziB.length();
     int N = diziA.length();
//�nceki sonraki de�erlerini ��renmek i�in bir pi dizisi yarat�yorux
     int pi[] = new int[M];
     int q = 0; // b dizisinin indexi
     int i = 0; //a dizisinin indexi
     int dene = 0;
     // burada �ncelikle pi dizimizi bulmak istiyoruz�
     oncekisonrakibul(diziB, M, pi);

    //i den n b�y�k olana kadar d�n�yor
     
     while (i < N) {
    	 // bu ifte de�erleri kontrol ediyoruz e�itli�i yani
         if (diziB.charAt(q) == diziA.charAt(i)) {
        	 //e�er e�it de�illerse bir sonraki harfe ge�iyor
             q = q +1;
             i= i+1;
         }
         // buraki if in q ve m e�itse ��kt� veriyoruz. bulduk diye
         if (q == M) {
             System.out.println("B metninin bulundu�u konumlar "    + (i - q));
             q = pi[q - 1]; //de�eri de�i�tiriyoruz ki devam edelim
             dene =1;
         }

         // uyumsuzluklar� de�erlendiriyoruz
         else if (i < N && diziB.charAt(q) != diziA.charAt(i)) {
             // e�le�ip i�le�memeli i�in de�erlendirmeleri yap�yoruz
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
     { //e�le�me bulunamad� kontrol�
    	 System.out.println("E�le�me bulunamad�");
     }
 }

 void oncekisonrakibul(String diziB, int M, int pi[])
 {
     // �nceki en uzun �n ekin uzunlu�unu bulmak i�in bu fonk var uzunluk de�i�keni �nce s�f�r oalrak tan�mlan�r
     int uzunluk = 0;
     int i = 1;
     pi[0] = 0; // pi[0] 0 olarak ba�lat�yoruz. her zaman b�yle ba�lamas� gerekir

     // while d�ng�s�, i = 1 ve M-1 i�in pi [i] 'yi hesaplar
     while (i < M) {
    	 //m den k���k olana kadar devam eder
    	 /*e�le�me varsa i ve uzunluk arad�nda uzunlu�u bir artt�r�yoruz ve sonra pi[i] yi uzunlu�a ekleriz
    	  *  dizi b kontrol edilir
    	  * else d�ng�s�nde ise 
    	  * dizi a kontrl ediliyor
    	  */
         if (diziB.charAt(i) == diziB.charAt(uzunluk)) {
             uzunluk= uzunluk +1;
             pi[i] = uzunluk;
             i = i+1;
         }
         else 
         {
           // bu arammada ka� basama�a kadar yap�ld���na bak�yoruz
             if (uzunluk != 0) {
                 uzunluk = pi[uzunluk - 1];

                 //  fakat burada i nin de�erini artt�rmad�k 
             }
             else 
            	 //bu durum uzunlu�un �l��lmesi i�in yap�ld�
             { //pi i yi uzunlu�a e�itliyoruz ve i nin de�erini bir artt�r�yoruz
                 pi[i] = uzunluk;
                 i = i+1;
             }
         }
     }
 }

 
 public static void main(String args[])
 {    
     //kullan�c�dan m ve n de�elrerini almak i�in bir al isimli de�i�ken olu�ruduk
      Scanner al = new Scanner(System.in);
      //kullan�c�dan hangi dizi boyutunu almak istedi�imizi s�ylemek i�in println kulland�k
      System.out.println("A dizisi boyutunu giriniz:");
      // kullan�c�dan n boyutunu ald�k
      int N = al.nextInt();
      //kullan�c�dan b dizisi boyutunu girmesini istedik
      System.out.println("B dizisi boyutunu giriniz:");
// m de�erini ald�k
      int M = al.nextInt();
      //a dizisinden rastgele karakter alabilmek i�in gelcnm adl� fonksiyonumuzu kulland�k 
      //once diziAy� �a��rd�k
      String diziA= gelcnm(N);
      //dizi b yi �a�r�d�k
      String diziB = gelcnm(M);
      //burada dizilerimizin g�r�nebilmesi i�in iki tane print yaptk dizi a ve dizi b i�in 
      System.out.println("A dizisi olu�turuldu: " +diziA);
      System.out.println("B dizisi olu�turuldu: "+diziB);
      
//kmp class� i�indeki kmp arama fonksiyonunu �a��rd�k
     new kmp().kmparama(diziB, diziA);
    
 }
 // bu metodumuz bize istedi�imiz diziyi olu�turmam�z� sa�l�yor
public  static String gelcnm ( int sayi)
{ // bir n ve m sayilar�ni almak i�in int sayi tan�mlad�k
  //sayim de�i�keni sadece strng olarak 0 ve 1 de�erlerini istedi�imizi g�steriyor
	String sayim = "01";
	//string builder birle�tirme yapma i�lemi  i�in kullan�l�r
	StringBuilder yarat = new StringBuilder();
	//random fonksiyonu kulland�k 
	Random rnd = new Random();
	// burada ka� tane yarataca��m�z� belirlemek i�in bir while d�ng�s� kulland�k while i�inde olu�turuyoruz.
	while( yarat.length() < sayi)
	{
		int index = (int) (rnd.nextFloat()*sayim.length());
		yarat.append(sayim.charAt(index));
	}
	// ddizi yaratt���m�z de�erin d�nd�r�lmesini sa�lar
	String dizi = yarat.toString();
	// olu�turdu�umuz dizimizi g�nderiyoruz
	return dizi;
}
}