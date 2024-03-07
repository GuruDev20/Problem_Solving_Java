import java.util.*;
public class InsertAtPosition {
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
    }
    public void add(int pos,int data){ 
        Node newNode=new Node(data);
        if(pos==1){
            newNode.next=head;
            head=newNode;
        }
        else{
            Node temp=head;
            for(int i=1;i<pos-1 && temp!=null;i++){
                temp=temp.next;
            }
            if(temp==null){
                System.out.println("Invalid position"+pos);
                return;
            }
            newNode.next=temp.next;
            temp.next=newNode;
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        InsertAtPosition obj=new InsertAtPosition();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            obj.insert(in.nextInt());
        }
        obj.display();
        int pos=in.nextInt();
        int val=in.nextInt();
        obj.add(pos,val);
        obj.display();
        in.close();
    }
}
