import java.io.IOException;
import java.io.InputStreamReader;

public class Practica {
   public static void main (String[] args) throws IOException {
       InputStreamReader Teclado = new InputStreamReader(System.in);
       BufferReader capturador = new BufferReader (Teclado);
      System.out.println("ingrese el primer numero:");
      String strn1 = capturador.readLine();
      int num1 = Integer.parseInt(strn1);
      System.out.println("el numero es:" + num1);

   } 
}
   