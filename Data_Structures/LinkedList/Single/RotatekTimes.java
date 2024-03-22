package Single;
import java.util.*;
public class RotatekTimes {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head=null;
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
    public void display(){
        Node current=head;
        while(current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }
    public void rotateKTimes(int k){
        if(head==null || k==0){
            return;
        }
        int length=1;
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
            length++;
        }
        k=k%length;
        if(k==0){
            return;
        }
        Node current=head;
        for(int i=1;i<length-k;i++){
            current=current.next;
        }
        temp.next=head;
        head=current.next;
        current.next=null;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        RotatekTimes obj=new RotatekTimes();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            obj.insert(in.nextInt());
        }
        obj.display();
        int k=in.nextInt();
        obj.rotateKTimes(k);
        obj.display();
        in.close();
    }
}
