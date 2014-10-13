/*
    Calculates the number of circular primes between 0 and an upper limit which is provided by user input.

    A number is a circular prime when both itself and its reverse are primes.
    For example, the number 13 is a circular prime number, because its reverse, 31, is also a prime.

    Based on Problem 35 on projecteuler.net
 */

package circular_primes;
import java.math.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author todyerutz @ plainintricacy.wordpress.com
 * 
 */

public class Circular_Primes {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the upper limit to parse:");
        int limit = input.nextInt();
        input.close();
        ArrayList<Integer> primes = new ArrayList<Integer>();
        int sum = 0;
       boolean found=true;
       if(limit>2){
           sum++;
           primes.add(2);
       }
       for(int i=3; i<=limit; i+=2){
           found=true;
           int temp = i; 
           if(primality(i)&&primality(rotate(temp))){
               sum++;
               primes.add(i);
           }           
        }
        if(sum>=1){
            System.out.println("There are " + sum + " circular prime numbers between 0 and " + limit + ":");
            for(int c=0; c<primes.size(); c++){
                System.out.println(primes.get(c));
            }
        }else{
            System.out.println("No circular primes were found between 0 and " + limit + ".");
        }
            
        }
    
    public static boolean primality(int q){
        if(q==2){
            return true;
        }else
        if(q%2==0&&q!=2){
            return false;
        }else{
        for(int i=3; i<=Math.sqrt(q); i+=2){
                if(q%i==0){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static int rotate(int x){
        int y=0;
        do{
            y*=10;
            y+=x%10;
            x=x/10;
        }while(x>0);
        return y;
    }
}
