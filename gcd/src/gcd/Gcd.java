/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Miriam
 */
public class Gcd {
    static List<Integer> PrimeFactorA = new LinkedList();
    static List<Integer> PrimeFactorB = new LinkedList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int result = gcdEucledian(28,4);
        System.out.println(result);
        result = gcdPrimeFactor(28,4);
        System.out.println(result);        
    }
    
    public static int gcdEucledian(int a,int b){
        int gcdResult = a;
        if(b != 0){
          int rest = a/b;
          int result = a-(rest*b);
          gcdResult = gcdEucledian(b, result);
        }
        return gcdResult;
    }
    
    public static int gcdPrimeFactor(int a,int b){
        int divisor = 2;
        int result = 0;
        while(b!= 1){
           while(b% divisor != 0)
            {
                divisor = getNextPrime(divisor);
            }

            b /= divisor;
            PrimeFactorB.add(divisor); 
        }
        divisor = 2;
        while(a!= 1){
           while(a% divisor != 0)
            {
                divisor = getNextPrime(divisor);
            }

            a /= divisor;
            PrimeFactorA.add(divisor); 
        }
        
        result = PrimeFactor();
        return result;
    }
    public static int PrimeFactor(){
        int result = 1;

        for(int i = 0;i < PrimeFactorA.size();i++){
            for (int l = i; l < PrimeFactorB.size(); l++) {
                if(PrimeFactorA.get(i) == PrimeFactorB.get(l)){
                    result *= PrimeFactorA.get(i);
                    i = l;
                }
            }            
        }
        
        return result;
    }
    
    
    public static int getNextPrime(int lastNumber){
        int currentNumber = lastNumber +1;
        while(!checkIfPrime(currentNumber)){
            currentNumber++;
        }
        return currentNumber;
    }
    
    public static boolean checkIfPrime(int number)
    {
        
        if(number == 2)
            return true;
        if(number == 0 || number == 1||number % 2 == 0)
            return false;
        
        for (int i = 3; i < number-1; i += 2) {
            if(number % i == 0)
                return false;
        }
        
        return true;
    }
    
}
