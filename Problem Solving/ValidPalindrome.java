import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String cleanedStr = sb.toString();
        String reversedStr = sb.reverse().toString();
        return cleanedStr.equals(reversedStr);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Solution se = new Solution();
        boolean found = se.isPalindrome(s);
        if (found) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
        in.close();
    }
}