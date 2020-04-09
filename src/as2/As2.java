/*
Andrew Tong
Mr. Ritter
April 1, 2019
AS2

This program gives the user a menu of options (1-5) which repeats until the user quits (option 5).
Option 1 will print an investment table compounded daily given an initial investment, number of years, and range of integer interest rates.
Option 2 will print a multiplicationt able given a range of starting and ending values.
Option 3 will print all prime numbers to an inputted integer.
Option 4 will convert an input seconds into days, hours, minutes, and seconds.
 */
package as2;
import java.util.Scanner;

public class As2 {

    public static void main(String[] args) {
        
       
       System.out.println("Hi, this is a program that will give you a menu of options.");
       System.out.println("First, it will print a table of investments compounded daily given an initial investment, number of years, and range of integer interest rates.");
       System.out.println("Second, it will ask for a range of starting and ending values and print a multiplication table.");
       System.out.println("Third, it will prompt for an integer and print out all prime numbers up to that integer.");
       System.out.println("Fourth, it will convert inputted seconds into days, hours, minutes, and seconds.");
       System.out.println();
       System.out.println("Alright, let's begin! What is your name?");
       Scanner in= new Scanner(System.in);
       
       String user=in.nextLine();
       System.out.println(user+", you are now entering the menu. The menu will repeat until you input option 5 to quit.");
       System.out.println();
       int choice=0;//increases scope to entire do while
       do
       {
           System.out.println("Option 1: Investment table.");
           System.out.println("Option 2: Multiplication table.");
           System.out.println("Option 3: Prime number generator.");
           System.out.println("Option 4: Time conversion.");
           System.out.println("Option 5: Quit.");
           System.out.println("The table will repeat itself until you quit.");
           
           System.out.println(user+", please enter which number option you would like (1, 2, 3, 4, or 5). Do not enter a non-integer.");
           
           choice=in.nextInt();
           
           switch (choice)
           {
               case 1:
                   System.out.println(user+ ", you chose option 1, where you input an initial investment, lowest and highest \n integer interest rates, and the number of years invested to make a daily compound interest table.");
                   System.out.println("Enter initial investment.");
                   double initial=in.nextDouble();
                   if (initial<=0)//instructions say to bound check
                   {
                       System.out.println("Your investment can only be a positive amount! Please enter again.");
                       initial=in.nextDouble();
                   }
                   
                   System.out.println("Enter lowest interest rate (ex: 9.5% would be 9.5, not .095).");
                   double low=in.nextDouble();//double rates because interest rates usually aren't perfect integers
                   //gives the range of interest rates more flexibility
                   //note: the loop still only goes up by 1, so the upper range will underestimate if the rate decimals aren't the same.
                   System.out.println("Enter highest interest rate (ex: 9.5% would be 9.5, not .095).");
                   double high=in.nextDouble();
                   System.out.println("How many whole years will you invest?");
                   int MAXyear=in.nextInt();
                   
                   
                   if (MAXyear<0)
                   {
                       System.out.println("Time cannot be negative. Please enter the whole years you will invest.");
                       MAXyear=in.nextInt();
                   }
                   
                   //scanner input outside of method because for portability, methods should only be dedicated to one task (the investment table)
                   investment(initial, low, high, MAXyear);
                   //formatting of table will be off for large initial investments
  
                   break;
               case 2:
                   System.out.println(user+", you chose Option 2, where you input a starting \n and ending integer values to construct a multiplication table.");
                   System.out.println("Enter your integer starting value.");//Mr. Ritter says integers only
                   int start= in.nextInt();
                   System.out.println("Enter your integer ending value.");
                   int end=in.nextInt();
                   
                   //scanner input outside of method because for portability, methods should only be dedicated to one task (in this case, the multiplication table)
                   multiplication (start,end);
                   //formatting of table will be off for large factors
                 
                   break;
                   
               case 3: 
                   System.out.println(user+", you chose Option 3, where you enter an integer to create a list of all prime numbers up to that integer.");
                   System.out.println("Pleae enter your integer.");
                   int primeTarget=in.nextInt();
                   
                   if(primeTarget<2)
                   {
                       System.out.println("2 is the first prime number, so you have to enter an integer greater than 2. Please enter again.");
                       primeTarget=in.nextInt();
                   }
                   
                   primeGenerator prime=new primeGenerator(primeTarget);
                          
                   System.out.print("The prime numbers up to "+primeTarget+" are ");//if the primeTarget is a prime number, will include that value
                   prime.primeList();
                   
                  break;
                   
               case 4:
                   System.out.println(user+", you chose Option 4, where a time in seconds to convert to days, hours, minutes, and seconds.");
                   System.out.println("Please enter a time in seconds (decimals allowed).");
                   double seconds=in.nextDouble();
                   
                   if (seconds<0)//time can't be negative bounds check
                   {
                       System.out.println("Time cannot be negative. Please enter your time as a positive value in seconds.");
                       seconds=in.nextDouble(); 
                   }
                   
                   time conversion=new time(seconds);
                   
                   //I know instructions say to print in tester class, but printing in main is better because you can refer to the user name for more personalization.
                   System.out.println(user+", your time of "+ seconds +" seconds is equivalent to:");
                   System.out.println(conversion.getDays()+" days");//units required for user experience
                   System.out.println(conversion.getHours()+" hours");
                   System.out.println(conversion.getMinutes()+" minutes");
                   System.out.printf("%.6f seconds\n", conversion.getSeconds());
                   //round to 6 decimal places for accuracy, but also to eliminate potential double rounding errors
                   
                   break;
                   
               case 5: System.out.println(user+", thank you for using this program!");
                   break;
               default: System.out.println(user+", wrong input. Please try again!");
                   break;
                  
               
           }    
           
       }
       
       while (choice!=5);
        
        
    }
    
    public static void investment(double initial, double low, double high, int MAXyear)
    {
        double balance = 0;
        double daysInYear=365.0;//maintains double multiplication
        double percentToDecimal=100.0;
        //column heading
        System.out.println("                                   Years");//Spaces to center
        
        for (int year=1; year<=MAXyear; year++)
        {
            System.out.printf("%16d", year);//formatting will be off for large investments
        }
        System.out.println();

        System.out.println("Interest Rate: ");
        for (double rate=low; rate <=high;rate++)

        {
            
            System.out.print(rate+"%     ");//row heading

            for (int year=1; year<= MAXyear; year++)
            {

                balance=initial*Math.pow((1+rate/percentToDecimal/daysInYear), daysInYear*year);

                System.out.printf("$%10.2f     ",balance);//2 decimal places because money only goes to 2 decimal places
            }
            System.out.println();
        }
    }
    
    public static void multiplication(int start, int end)
    {
        if (start>end)//makes it not matter that start has to be less than end
        {
            int temp=start;
            start=end;
            end=temp;
        }

        int result=0; 
        //print table columm heading
        for (int column=start; column<=end; column++)
        {

            System.out.printf("%10d", column);
        }
        System.out.println();

        //print table columns
        for (int row=start; row<=end; row++)

        {
            //print table row heading
            System.out.print(row);//takes account for top left corner space

            for (int column=start; column<=end; column++)
            {
                result=row*column;
                System.out.printf("%10d", result);//formatting may be off for large factors.

            }
            System.out.println();
        }

    }
    
}
