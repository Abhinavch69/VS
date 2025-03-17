package math;
import java.util.*;
public class seive_of_eratosthenes {

  static void isPrime(int n){
    boolean prime[] = new boolean[n+1];
    for(int i=2;i<=n;i++){
      prime[i]=true;
    }

    for(int i=2;i*i<=n;i++){
      if(prime[i]==true){
        for(int j=i*i;j<=n;j+=i){
          prime[j]=false;
        }
      }
    }
    List<Integer> list=new ArrayList<>();
    for(int i=2;i<=n;i++){
      if(prime[i]==true) list.add(i);
    }
    System.out.println(list);
  }
  public static void main(String[] args) {
    isPrime(30);
  }
}
