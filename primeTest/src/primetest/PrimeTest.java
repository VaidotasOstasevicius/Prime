/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primetest;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Vy
 */
public class PrimeTest {

    /**
     * @param args the command line arguments
     */
    void PrimeTest(){
        
    }
    
    private ArrayList findPrime(){                      // This method is used to find the primes based on the users input
        System.out.println("Enter the number of primes");  // This is a scanner, used to get input from the user
        Scanner sc = new Scanner(System.in);
        int numOfPrime = sc.nextInt();
        sc.close();
        
        ArrayList<Integer> primes = new ArrayList<Integer>(); // will be storing the primes in an ArrayList since it is dynamic
        int numberCounter = 0;                                //  This variable is used as a number counter
        int primeCounter = 0;
        while(primeCounter  < numOfPrime){                    //  Condition to stop once the counter reaces the same number as the number specified by the users input
            if(numberCounter % 2 != 0 || numberCounter == 2){       //  If the number is even it is not a prime except for 2
                float counter2 = 1;                     //
                float divCounter = 0;                   //
                while(counter2 <= numberCounter){             //  This loop is used to test if the number is only devisible by 1 and itself  
                    if((numberCounter % counter2 == 0)){      //  Tests if the number can be devided without remainder
                        divCounter = divCounter + 1;    //  if it can it increments the counter
                    }                                   //
                    counter2 = counter2 + 2;            //  we only need to check the uneven numebrs
                }                                       //
                if(divCounter == 2 || numberCounter == 2){    //  The only way divCounter is 2 is if the numeber has been devided twice which means it was devided by 1 and itself and ofcourse we need to allow for 2 
                    primes.add(numberCounter);                //  Adding the prime to an array
                    System.out.println(numberCounter);        //  Prints out the prime
                    primeCounter++;
                }
            }
            numberCounter++;                                  //  Increments the number 
        }
        return primes;                                  //  Returns the final array of primes
    }
    
    public static void main(String[] args) {
        PrimeTest prime = new PrimeTest();
        prime.findPrime();
        // TODO code application logic here
    }
    
}
