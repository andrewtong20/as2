/*
This class takes the user's inputted integer, creates a list of numbers up to that integer, and tests to see if these numbers are prime.
 */
package as2;


public class primeGenerator {
    //instance fields
    private int primeTarget;
    private boolean prime;
    
    //parameter constructor
    public primeGenerator(int inPrime)
    {
        primeTarget=inPrime;
    }
    
    //methods
    public void isPrime(int runningInteger)
    {
        for (int divisor=2; divisor<runningInteger; divisor++)//should not divide by itself so I chose "<" not "<="
                            
            {
                if (runningInteger%divisor==0)
                {
                    prime=false;
                }
                              
            }
    }
    
    public void primeList()
    {
        prime=true;
        
        for (int runningInteger=2; runningInteger<=primeTarget; runningInteger++)
            //runningInteger is potential prime number to be printed,
            //start at 2 because 1 is not prime number
            
            {
                prime=true;//reset boolean in loop
                   
                isPrime(runningInteger); 
                
                if (prime)
                {
                    System.out.print(runningInteger+" ");
                }
            }
                System.out.println();
       
    }
    
}
