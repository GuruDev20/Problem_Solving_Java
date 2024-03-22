package Double;
import java.util.*;
public class Deletion {
    class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
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
            newNode.prev=temp;
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
    public void delete(int pos){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node current=head;
        if(pos==0){
            head=head.next;
            if(head!=null){
                head.prev=null;
            }
            return;
        }
        int count=0;
        while(current!=null && count<pos){
            current=current.next;
            count++;
        }
        if(current==null){
            System.out.println("Cannot be deleted");
            return;
        }
        if(current.next!=null){
            current.next.prev=current.prev;
        }
        if(current.prev!=null){
            current.prev.next=current.next;
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Deletion obj=new Deletion();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            obj.insert(in.nextInt());
        }
        obj.display();
        int pos=in.nextInt();
        obj.delete(pos);
        obj.display();
        in.close();
    }
}
