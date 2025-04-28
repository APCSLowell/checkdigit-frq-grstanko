public class CheckDigit 
{   
  /** Returns the check digit for num, as described in part (a).  
   *  Precondition: The number of digits in num is between one and    
   *  six, inclusive.  
   *          num >= 0  
   */  
   public static int getCheck(int num) 
   {  
     int sum = 0;
     int factor = 7;
     int currentDigit = 1;
     while(num != 0 && factor >= 2) {
       sum += factor*getDigit(num, currentDigit);
       factor -= 1;
       currentDigit +=1 ;
     }
     return sum;
   }
 
  /** Returns true if numWithCheckDigit is valid, or false    
   *  otherwise, as described in part (b). 
   *  Precondition: The number of digits in numWithCheckDigit   
   *  is between two and seven, inclusive.
   *                numWithCheckDigit >= 0     
   */     
   public static boolean isValid(int numWithCheckDigit)    
   {      
     int check = numWithCheckDigit % 10;
     int num = numWithCheckDigit / 10;
     return check == getCheck(num);
   }    
   
   /** Returns the number of digits in num. */    
   public static int getNumberOfDigits(int num)    
   {      
    if(num < 10)
      return 1;
    return 1 + getNumberOfDigits(num/10);    
   }    
   
   /** Returns the nthdigit of num.      
    *  Precondition: n >= 1 and n <= the number of digits in num     
    */    
    public static int getDigit(int num, int n)    
    {      
      int pos = getNumberOfDigits(num)-n+1;
      while(pos > 1){
        num/=10;
        pos--;
      }
      return num%10;
    }     

}
