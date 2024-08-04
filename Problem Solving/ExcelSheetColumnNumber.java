import java.util.*;
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        int n=0;
        for(int i=0;i<s.length();i++){
            n=n*26+(s.charAt(i)-64);
        }
        System.out.println(n);
        in.close();
    }
}
