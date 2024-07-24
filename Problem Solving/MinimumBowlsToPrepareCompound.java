import java.util.*;
public class MinimumBowlsToPrepareCompound{
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        LinkedHashMap<String,ArrayList<String>> map=new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            String[] h=in.nextLine().replace("+","=").split("=");
            ArrayList<String> ll=new ArrayList<>();
            for(int j=1;j<h.length;j++){
                ll.add(h[j]);
            }
            map.put(h[0],ll);
        }
        ArrayList<String> com=new ArrayList<>();
        int u=in.nextInt();
        in.nextLine();
        for(int i=0;i<u;i++){
            com.add(in.nextLine());
        }
        LinkedHashMap<String,Integer> fin=new LinkedHashMap<>();
        for(int i=0;i<com.size();i++){
            if(!fin.containsKey(com.get(i))){
                fin.put(com.get(i),1);
                ArrayList<String> oo=new ArrayList<>(map.get(com.get(i)));
                for(String b:oo){
                    if(map.containsKey(b)){
                        fin.put(b,1);
                    }
                }
            }
        }
        int t=0;
        for(String q:fin.keySet()){
            t+=fin.get(q);
        }
        System.out.println(t);
        in.close();
    }
}