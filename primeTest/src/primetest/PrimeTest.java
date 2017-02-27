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
    
    private ArrayList findPrime(){                            // This method is used to find the primes based on the users input
        System.out.println("Enter the number of primes");     // This is a scanner, used to get input from the user
        Scanner sc = new Scanner(System.in);
        int numOfPrime = sc.nextInt();
        sc.close();
        
        ArrayList<Integer> primes = new ArrayList<Integer>(); // will be storing the primes in an ArrayList since it is dynamic
        int numberCounter = 0;                                //  This variable is used as a number counter
        int primeCounter = 0;                                 // This variable is used to count the number of primes found
        while(primeCounter  < numOfPrime){                    //  Condition to stop once the counter reaces the same number as the number specified by the users input
            if(numberCounter % 2 != 0 || numberCounter == 2){ //  If the number is even it is not a prime except for 2
                float counter2 = 1;                           //
                float divCounter = 0;                         //
                while(counter2 <= numberCounter){             //  This loop is used to test if the number is only devisible by 1 and itself  
                    if((numberCounter % counter2 == 0)){      //  Tests if the number can be devided without remainder
                        divCounter = divCounter + 1;          //  if it can it increments the counter
                    }                                         //
                    counter2 = counter2 + 2;                  //  we only need to check the uneven numebrs
                }                                             //
                if(divCounter == 2 || numberCounter == 2){    //  The only way divCounter is 2 is if the numeber has been devided twice which means it was devided by 1 and itself and ofcourse we need to allow for 2 
                    primes.add(numberCounter);                //  Adding the prime to an array
                    primeCounter++;
                }
            }
            numberCounter++;                                  //  Increments the number 
        }
        
        return primes;                                        //  Returns the final array of primes
       
    }
    
    private void multiPrime(){
        ArrayList<Integer> primes;                            //  Same as before an arrat will be used to store the primes
        primes = this.findPrime();                            //  Called the find prime function to get the primes that will be used
        int firstNum = primes.get(0);                         //  The first number in N*M multiplication
        int secondNum = primes.get(0);                        //  The second number in N*N multiplication
        int multCount = 0;                                    //  Will be used to assign different array values to the first number
        int multCount2 = 0;                                   //  Will be used to assign different array values to the second number 
        int primeMult;                                        //  Used to store the answer to N*N
        int printCounter = 0;                                 //  Used to print out the top line of the table
        String tableFormat3 = " %6s |%n";                     //
        String tableFormat2= " %6s |";                        //  Various formating values, %n is used for compatability reasons since \n is windows based
        String tableFormat4 = "| %6s |";                      //
        System.out.format("|        |");                      //
                     
        while(printCounter < primes.size()){
            if(printCounter + 1 == primes.size()){
                System.out.format(tableFormat3,primes.get(printCounter));   //
            } else {                                                        //
                System.out.format(tableFormat2,primes.get(printCounter));   //  Loop used to print out the top row of the table
            }                                                               //
            printCounter++;                                                 //
        }                                                                   
        
        while(multCount < primes.size()){                                   // The outer loop is used to keep track of the first number in N*N
            while(multCount2 < primes.size()){                              // The inner loop is used to keep track of the second number in N*N and do the multiplication + printing out of the values
                if(secondNum == primes.get(0)){                             // checks if its the very first time it has looped
                    System.out.format(tableFormat4,firstNum);               // if it is the first loop it uses different format variable
                }
                primeMult = firstNum * secondNum;                           // Does the multiplication
                multCount2++;                                               // incements mult2 to later be used as an array index variable
                if(multCount2 == primes.size()){                            // checks if it is the last loop
                    System.out.format(tableFormat3,primeMult);              // if it is the last loop use this specific format variable
                } else {
                    System.out.format(tableFormat2,primeMult);              // if it is not the last loop use a different format variable
                }
                if(multCount2 < primes.size()){                             // only assign if the index is inbounds of the array, otherwise it will couse ArrayOutOfBounds exception
                    secondNum = primes.get(multCount2);
                }
                
            }
            multCount2 = 0;                                                 // Reassigns the multCount2 to 0 to be reused again
            secondNum = primes.get(0);                                      // reasigns the secondNum to whatever value is in the first slot of the array
            multCount++;                                                    // increments multCount to be later used as an array assignment variable
            if(firstNum < primes.get(primes.size()-1)){                     // checks if it is not the last loop, which prevents ArrayOutOfBoundsException
                firstNum = primes.get(multCount);                           // if it is not the final loop assign the new firstNum is assigned
            }
        }
    }
    
    public static void main(String[] args) {
        PrimeTest prime = new PrimeTest();
        prime.multiPrime();
    }
    
}
