package Memoization;
import java.util.*;
public class ListOfLongestChainOfPairs{
    public static int[][] longestPair(int[][] pair){
        Arrays.sort(pair,Comparator.comparingInt(a->a[1]));
        List<int[]> result=new ArrayList<>();
        int[] prev=pair[0];
        result.add(prev);
        for(int i=1;i<pair.length;i++){
            int[] current=pair[i];
            if(current[0]>prev[1]){
                result.add(current);
                prev=current;
            }
        }
        int[][] longest=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            longest[i]=result.get(i);
        }
        return longest;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        str=str.substring(2,str.length()-2);
        String[] pairs=str.split("\\],\\[");
        int[][] pair=new int[pairs.length][2];
        for(int i=0;i<pairs.length;i++){
            String[] num=pairs[i].split(",");
            pair[i][0]=Integer.parseInt(num[0]);
            pair[i][1]=Integer.parseInt(num[1]);
        }
        int[][] longest=longestPair(pair);
        for(int i=0;i<longest.length;i++){
            System.out.print("["+longest[i][0]+","+longest[i][1]+"]");
            if(i<longest.length-1){
                System.out.print(" -> ");
            }
        }
        in.close();
    }
} 