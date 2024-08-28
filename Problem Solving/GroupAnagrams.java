import java.util.*;
public class GroupAnagrams {
    public static List<List<String>> result(String[] str){
        if(str==null || str.length==0){
            return new ArrayList<>();
        }
        Map<String,List<String>> hm=new HashMap<>();
        for(String s:str){
            char[] a=s.toCharArray();
            Arrays.sort(a);
            String res=String.valueOf(a);
            if(!hm.containsKey(res)){
                hm.put(res,new ArrayList<>());
            }
            hm.get(res).add(s);
        }
        List<List<String>> result=new ArrayList<>(hm.values());
        for (List<String> group:result) {
            Collections.sort(group);
        }
        result.sort((a,b)->Integer.compare(a.size(),b.size()));
        return result;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String[] str=in.nextLine().replaceAll("\\[","").replaceAll("\\]","").split(",");
        List<List<String>> res=result(str);
        StringBuilder sb=new StringBuilder("[");
        for(List<String> group:res){
            sb.append("[").append(String.join(",",group)).append("],");
        }
        if(sb.length()>1){
            sb.setLength(sb.length()-1);
        }
        sb.append("]");
        System.out.println(sb.toString());
        in.close();
    }
}
