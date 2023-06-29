/*************************************************************************
 *  Compilation:  javac RecursiveAppend.java
 *  Execution:    java RecursiveAppend
 *
 *  @author: Raashi Maheshwari 
 *  NetId: rm1622
 *  Email: rm1622@scarletmail.rutgers.edu 
 *
 *************************************************************************/

public class RecursiveAppend {

    // Returns the original string appended to the original string n times 
    public static String appendNTimes (String original, int n) {

	// WRITE YOUR CODE HERE
    if(n == 0) {
        return original;
    }
    else {
        original = original + appendNTimes(original, n - 1); 
        return original;
    }


    }

    public static void main (String[] args) {

	// WRITE TEST CASES HERE to test your methodd
    StdOut.println(appendNTimes("cat", 0));
    StdOut.println(appendNTimes("cat", 1));
    StdOut.println(appendNTimes("cat", 2));
    }
}
