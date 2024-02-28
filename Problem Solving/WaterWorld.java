import java.util.*;
public class WaterWorld
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int clusters = sc.nextInt();
        sc.nextLine();
        int need[] = new int[clusters];
        int storage[] = new int[clusters];
        for(int i=0;i<clusters;i++)
        {
            String s[] = sc.nextLine().split(" ");
            int k = findNode(s[0]);
            need[k] = Integer.parseInt(s[1]);
            storage[k] = Integer.parseInt(s[2]);
        }
        int con = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> a = new ArrayList<>();
        boolean isNotLeaf[] = new boolean[clusters];
        
        for(int i=0;i<con;i++)
        {
            String s[] = sc.nextLine().split("_");
            int source = findNode(s[0]);
            int destination = findNode(s[1]);
            a.add(destination,source);
            if(source>=1 && source<=clusters)
                isNotLeaf[source] = true;
        }
        int res = 0;
        int temp[] = new int[clusters];
        for(int j=0;j<days;j++)
        {
            for(int i=0;i<clusters;i++)
            {
                if(!isNotLeaf[i])
                {
                    int sum = 0;
                    res += dfs(a,i,need,storage,temp,sum,true);
                }
            }
        }
        System.out.println(res);
        sc.close();
    }
    
    public static int dfs(ArrayList<Integer> a,int node ,int need[],int storage[],int temp[],int sum,boolean flag)
    {
        if(temp[node]<need[node])
        {
            flag = false;
        }
        if(!flag)
        {
            temp[node] = 0;
            temp[node] += storage[node];
            sum = storage[node];
        }
        temp[node] -= need[node];
        int i=a.get(node);
        if(i==-1)
        {
            return sum;
        }
        sum += dfs(a,i,need,storage,temp,sum,flag);
        return sum;
    }
    
    public static int findNode(String s)
    {
        if(s.equals("F"))
            return -1;
        else
            return Integer.parseInt(s.replaceAll("[^0-9]",""))-1;
    }
}