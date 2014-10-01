/*
    The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
    There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

    Based on Problem 35 on projecteuler.net
 */

package circular_primes;
import java.math.*;
import java.util.ArrayList;
//import java.util.List;
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
        int sum = 1;
       primes.add(2);
       boolean found = true;
        for(int i=3; i<=limit; i+=2){
            int q = i;
            do{
                if(primality(i)==false){
                    found = false;
                }
                i = rotate(i);
            }while(i!=q&&found==true);
            if(found==true){
                sum++;
                primes.add(q);
            }
        }
        if(sum>1){
            System.out.println("There are " + sum + " circular prime numbers between 0 and " + limit + ":");
            for(int c=0; c<primes.size(); c++){
                System.out.print(primes.get(c) + ", ");
            }
        }
            
        }
    
    public static boolean primality(int q){
        for(int i=3; i<=Math.sqrt(q); i+=2){
                if(q%i==0){
                    return false;
                }
            }
        return true;
    }
    
    public static int rotate(int x){
        if(x/10>0){
            int y = x/(int)Math.pow(10, digits(x));
            x = (x%(int)Math.pow(10, digits(x)))*10 + y;
            return x;
        }
        return x;
    }
    
    public static int digits(int x){
        int count = -1;
        while(x>0){
                x=x/10;
                count++;
        }
        return count;
    }
}
