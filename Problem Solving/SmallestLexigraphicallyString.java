import java.util.*;
public class SmallestLexigraphicallyString{
    public static char[] findString(int n,int k){
        char[] arr=new char[n];
        Arrays.fill(arr,'a');
        for(int i=n-1;i>=0;i--){
            k-=i;
            if(k>=0){
                if(k>=26){
                    arr[i]='z';
                    k-=26;
                }
                else{
                    arr[i]=(char)(k+97-1);
                    k-=arr[i]-'a'+1;
                }
            }
            else{
                break;
            }
            k+=i;
        }
        return arr;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            int k=in.nextInt();
            System.out.println(new String(findString(n,k)));
        }
        in.close();
    }
}