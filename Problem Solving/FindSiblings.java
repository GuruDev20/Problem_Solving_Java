import java.util.*;
public class FindSiblings {
    public static int[] findSiblings(int[] a,int target){
        List<Integer> al=new ArrayList<>();
        int ind=-1;
        for(int i=0;i<a.length;i++){
            if(a[i]==target){
                ind=i;
                break;
            }
        }
        if(ind!=-1){
            int parentLevel=getLevel(ind);
            int start=(int)Math.pow(2,parentLevel)-1;
            int end=(int)Math.pow(2,parentLevel+1)-2;
            for(int i=start;i<=end && i<a.length;i++){
                if(i!=ind){
                    al.add(a[i]);
                }
            }
        }
        int[] siblings=new int[al.size()];
        for(int i=0;i<al.size();i++){
            siblings[i]=al.get(i);
        }
        return siblings;
    }

    public static int getLevel(int index){
        int level=0;
        while(index>0){
            index=(index-1)/2;
            level++;
        }
        return level;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        int target=in.nextInt();
        int[] siblings=findSiblings(a,target);
        if(siblings.length==0){
            System.out.println("-1");
        }
        else {
            for(int i=0;i<siblings.length;i++){
                System.out.print(siblings[i]+" ");
            }
        }
        in.close();
    }
}