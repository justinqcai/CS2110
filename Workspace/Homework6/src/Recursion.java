/**
 * Homework 6
 * 
 * Implement the following methods on recursion
 * as defined in the homework 6 document.
 * 
 * @author jc5pz
 *
 */
public class Recursion {
    
    public static boolean palindrome(String s) {
        if ((s.length() == 1) || (s.length() == 2 && (s.charAt(0) == s.charAt(s.length() - 1)))) {
            return true;   
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return palindrome(s.substring(1,s.length() - 1));
        }
        return false; 
    }
    
    public static String reverseString(String s) {
        if (s.length() <= 1 ) {
           return s;  
        }
        return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() -1)); 
    }

    
    public static int handShakes(int n) {
    	if(n == 0 || n == 1) {
    		return 0;
    	}
        n -= 1; 
        return n + handShakes(n); 
    }
    
    public static long ackermann(long m, long n) {
        if (m == 0) {
            return n + 1; 
        }
        
        else if (m > 0 && n == 0) {
            return ackermann(m - 1, 1);
        }
        else if (m > 0 && n > 0) {
            return ackermann(m - 1, ackermann(m, n -1));
        }
        else {
            return 0; 
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        //Palindromes
    	System.out.println("Palindromes");
        System.out.println("racecar: "+ palindrome("racecar"));               
        System.out.println("justin: " + palindrome("justin"));            
        System.out.println("lull: " + palindrome("lull"));        
        System.out.println("deed: " + palindrome("deed"));             
        
        //Reverse strings
        System.out.println("Reverse strings");
        System.out.println("Bob: " + reverseString("Bob"));                
        System.out.println("I: " + reverseString("I"));                  
        System.out.println("Hi!: " + reverseString("Hi!"));         
        System.out.println("University': " + reverseString("University")); 
        
        //Handshakes
        System.out.println("Handshakes");
        System.out.println("0: " + handShakes(0));  
        System.out.println("2: " + handShakes(2));
        System.out.println("3: " + handShakes(3));        
        System.out.println("6: " + handShakes(6));
        
        
        //Ackermann
        System.out.println("Ackermanns");
        System.out.println("0,0:  " + ackermann(0,0)); 
        System.out.println("2,0: " + ackermann(2,0)); 
        System.out.println("3,4: " + ackermann(3,4)); 
        
        
    }

}
