import java.util.*;
class Solution {
    public String convertToTitle(int columnNumber) {
        String result = "";

        while (columnNumber > 0) {
            columnNumber--;
            char digit = (char) ('A' + columnNumber % 26);
            result = digit + result;
            columnNumber /= 26;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter column number: ");
        int col = in.nextInt();
        Solution s = new Solution();
        String str = s.convertToTitle(col);
        System.out.println("Excel sheet column title: " + str);
        in.close();
    }
}