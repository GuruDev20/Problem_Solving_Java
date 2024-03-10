import java.util.*;
public class DetectLoop {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    private static Node head=null;
    public boolean detectLoop(){
        Node temp=head;
        HashSet<Integer> nodes=new HashSet<>();
        while(temp!=null){
            if(nodes.contains(temp.data)){
                return true;
            }
            else{
                nodes.add(temp.data);
                temp=temp.next;
            }
        }
        return false;
    }
    public void insert(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        DetectLoop obj=new DetectLoop();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            obj.insert(in.nextInt());
        }
        if(obj.detectLoop()){
            System.out.println("LOOP");
        }
        else{
            System.out.println("NO LOOP");
        }
        in.close();
    }
}
