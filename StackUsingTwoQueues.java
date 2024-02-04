import java.util.*;
public class StackUsingTwoQueues {
    public Queue<Integer> primary;
    public Queue<Integer> secondary;
    public StackUsingTwoQueues(){
        primary=new LinkedList<>();
        secondary=new LinkedList<>();
    }
    public void push(int data){
        while(!primary.isEmpty()){
            secondary.add(primary.poll());
        }
        primary.add(data);
        while(!secondary.isEmpty()){
            primary.add(secondary.poll());
        }
    }
    public int pop(){
        if(primary.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return primary.poll();
    }
    public int peek(){
        if(primary.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return primary.peek();
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        StackUsingTwoQueues obj=new StackUsingTwoQueues();
        int ch=0;
        while(ch!=4){
            System.out.println("1. Push  2. Pop  3. Peek  4. Exit");
            ch = in.nextInt();
            switch (ch) {
                case 1:
                    int val=in.nextInt();
                    obj.push(val);
                    break;
                case 2:
                    System.out.println(obj.pop());
                    break;
                case 3:
                    System.out.println(obj.peek());
                    break;
                default:
                    break;
            }
        }
        in.close();
    }
}
