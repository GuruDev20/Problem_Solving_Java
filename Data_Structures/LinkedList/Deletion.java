import java.util.*;
public class Deletion {
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

    public void delete(int val){
        Node temp=head;
        Node prev=null;
        if(temp!=null && temp.data==val){
            head=temp.next;
            return;
        }
        while(temp!=null && temp.data!=val){
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Deletion obj=new Deletion();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            obj.insert(in.nextInt());
        }
        obj.display();
        int val=in.nextInt();
        obj.delete(val);
        obj.display();
        in.close();
    }
}
