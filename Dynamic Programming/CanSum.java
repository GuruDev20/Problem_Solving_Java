import java.util.*;
public class CanSum {
    public static boolean canSum(int amount,List<Integer> numbers){
        return canSum(amount,numbers,new HashMap<>());
    }
    public static boolean canSum(int amount,List<Integer> numbers,HashMap<Integer,Boolean>memo){
        if(amount==0){
            return true;
        }
        if(amount<0){
            return false;
        }
        if(memo.containsKey(amount)){
            return memo.get(amount);
        }
        for(int num:numbers){
            int subAmount=amount-num;
            if(canSum(subAmount,numbers,memo)){
                memo.put(amount,true);
                return true;
            }
            else{
                return false;
            }
        }
        memo.put(amount,false);
        return false;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int amount=in.nextInt();
        int size=in.nextInt();
        List<Integer> num=new ArrayList<>();
        for(int i=0;i<size;i++){
            num.add(in.nextInt());
        }
        System.out.println(canSum(amount,num));
        in.close();
    }
}
