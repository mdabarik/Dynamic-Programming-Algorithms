import java.util.*;
import java.util.stream.*;

class PalindromicPartitioning{
    //if the current substring is a palindrome or not
    public static boolean isPalindrome(String s, int i, int j){
      while(i < j){
        if (s.charAt(i) != s.charAt(j))
          return false;
        i += 1;
        j -= 1;
      }
      return true;
    }

    // Helper function with updated signature: i is start index of the current substring
    // j is the end index of the current substring
    public static int minCutsHelper(String s, int i, int j){
      // Base case
      if (i == j || isPalindrome(s, i, j))
        return 0;

      // Variable to store the minimum number of cuts per iteration
      int result = j - i + 1;

      // Loop to place a cut after each index
      for(int k = i; k < j; k++){
        int totalCuts = 1 + minCutsHelper(s, i, k) + minCutsHelper(s, k + 1, j);
        result = Math.min(result, totalCuts);
      }

      // Return the minimum number of cuts
      return result;
    }

    public static int minCuts(String s){
      return minCutsHelper(s, 0, s.length() - 1);
    }

  // Driver code
  public static void main(String[] args){
    ArrayList <String> inputs = new ArrayList<String>(){{add("radar"); add("abac"); add("book"); add("sleek"); add("fours");}};

    // You can uncomment the lines below and check how this recursive solution causes a time-out 
    // inputs.add("elwxubtrnarrrjguuqwwoopgwjaaeavczrdubcgfvnxeutcatt");

    for (int i = 0; i < inputs.size(); i++){
        System.out.println(i + 1 + ".\tInput string:" + inputs.get(i) + "\n\n\t" + "The minimum number of cuts are: " + minCuts(inputs.get(i)));
        Stream.generate(() -> "-").limit(100).forEach(System.out::print);
        System.out.println();
    }
  }
}
// TC: O(2^n), SC: O(n)
