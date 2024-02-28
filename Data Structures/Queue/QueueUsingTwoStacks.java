import java.util.*;
public class QueueUsingTwoStacks {
    public Stack<Integer> primary;
    public Stack<Integer> secondary;
    public QueueUsingTwoStacks(){
        primary = new Stack<>();
        secondary = new Stack<>();
    }
    public void enqueue(int data){
        primary.push(data);
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        if(secondary.isEmpty()){
            while (!primary.isEmpty()) {
                secondary.push(primary.pop());
            }
        }
        return secondary.pop();
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        if(secondary.isEmpty()){
            while (!primary.isEmpty()){
                secondary.push(primary.pop());
            }
        }
        return secondary.peek();
    }
    public boolean isEmpty() {
        return primary.isEmpty() && secondary.isEmpty();
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        QueueUsingTwoStacks obj=new QueueUsingTwoStacks();
        int ch=0;
        while(ch!=4){
            System.out.println("1.Enqueue  2.Dequeue  3.Peek  4.Exit");
            ch=in.nextInt();
            switch(ch){
                case 1:
                    int data=in.nextInt();
                    obj.enqueue(data);
                    break;
                case 2:
                    System.out.println(obj.dequeue());
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
