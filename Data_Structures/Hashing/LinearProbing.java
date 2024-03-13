package Data_Structures.Hashing;
import java.util.*;
public class LinearProbing{
    public static void linearProbing(int[] a,int n){
        int[] hash=new int[n];
        Arrays.fill(hash,-1);
        for(int i=0;i<n;i++){
            int rem=a[i]%n;
            if(hash[rem]==-1){
                hash[rem]=a[i];
            }
            else{
                int j=1;
                while(hash[(rem+j)%n]!=-1){
                    j++;
                }
                hash[(rem+j)%n]=a[i];
            }
        }
        for(int i=0;i<n;i++){
            System.out.println("index "+i+" value = "+hash[i]);
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        in.close();
        linearProbing(a,n);
    }
}