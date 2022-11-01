import java.util.Scanner;

public class integer {

   public static void main (String[] args)  {
       int i=0, contador=0;
       Scanner datos = new Scanner (System.in);
       System.out.println("Hasta que numero se desea conocer sus primos? ");
       String numeros = datos.next();
       int numero = Integer.parseInt(numeros);
       boolean esPrimo=true;
       while(i < numero) {
            if (numero % i == 0){
            esPrimo = false;}  
        numero ++;
        
       if (esPrimo==true){      
         contador ++;   
         numero ++;
        } 
       }
       System.out.println("Hay " + contador + "numeros primos hasta el numero " + numeros);
        
    

             
       /*      Pares E Impares
       Scanner datos = new Scanner (System.in);
      System.out.println("ingrese un numero:");
      String numero = datos.next();
      int num1 = Integer.parseInt(numero);
      boolean par = (num1 % 2) == 0;
      if (par == true) {
          System.out.println("el numero" + num1 + "es par");
      }
      else {
          System.out.println("el numero"  + num1  + "es inpar");
      }
      
 /*   MAXIMO Y MINIMO
      Scanner datos = new Scanner (System.in);
      System.out.println("ingrese el primer numero:");
      String numero = datos.next();
      int num1 = Integer.parseInt(numero);
      System.out.println("ingrese el segundo numero:");
      String numero2 = datos.next();
      int num2 = Integer.parseInt(numero2);
      
      System.out.println("ingrese el tercer numero:");
      String numero3 = datos.next();
      int num3 = Integer.parseInt(numero3);
      
      int mayor = num1;
      int menor = num1;
      if(num2>mayor) {
          mayor = num2;
      }
      if(num3>mayor) {
          mayor = num3;
      }
      if(num2<menor) {
          menor = num2;
      }
      if(num3<menor) {
          menor = num3;
      }
      
      System.out.println("el numero mayor es:" + mayor);
      System.out.println("el numero menor es:" + menor);

   } */

}}
 