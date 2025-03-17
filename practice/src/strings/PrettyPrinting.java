package strings;
import java.math.*;
public class PrettyPrinting {
  public static void main(String[] args) {

    //Also round of the value
    float a=453.12745f;
    System.out.printf("Formatted number is %.2f", a);
    System.out.println();

    //PI value
    System.out.printf("Pie : %.3f",Math.PI);
    System.out.println();

    //Placeholders
    System.out.printf("Hello my name is %s and I am %s","Abhinav","Cool");

    //calculating double or float values upto given decimal places
    double d=123;
    System.out.println("\n"+String.format("%.2f", d));

    double n3=Math.round(d*100.0)/100.0;
    System.out.println(n3);

    //.isdigit().....cheks if a given string is integer or not
    String stru="123$";
    System.out.println(stru.matches("[0-9]+"));
  }
}
