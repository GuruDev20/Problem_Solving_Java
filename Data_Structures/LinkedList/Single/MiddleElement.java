package Single;
import java.util.*;
public class MiddleElement {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    private Node head=null;
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
    public int middleElement(int key){
        Node current=head;
        int count=0;
        while(current!=null){
            if(count==key){
                return current.data;
            }
            current=current.next;
            count++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        MiddleElement obj=new MiddleElement();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            obj.insert(in.nextInt());
        }
        System.out.println(obj.middleElement(n/2));
        in.close();
    }
}
