package Data_Structures.Hashing;
import java.util.*;
public class SeparateChaining{
    public static void separateChaining(int[] a,int n){
        int size=7;
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] hash=new LinkedList[size];
        for(int i=0;i<size;i++){
            hash[i]=new LinkedList<>();
        }
        for(int i=0;i<n;i++){
            int rem=a[i]%size;
            hash[rem].add(a[i]);
        }
        for(int i=0;i<size;i++){
            System.out.println("at index "+i);
            if(hash[i].isEmpty()){
                System.out.println("No Hash Entry");
            }
            else{
                for(int val:hash[i]){
                    System.out.print(val+"->");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args)throws Exception{
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        in.close();
        separateChaining(a,n);
    }
}