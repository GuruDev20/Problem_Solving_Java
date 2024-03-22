package Single;
import java.util.*;
public class MergeTwoLinkedList{
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
    public void display(){
        Node current=head;
        while(current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }
    public static MergeTwoLinkedList mergeTwoList(MergeTwoLinkedList obj1,MergeTwoLinkedList obj2){
        MergeTwoLinkedList merge=new MergeTwoLinkedList();
        Node temp1=obj1.head;
        Node temp2=obj2.head;
        while(temp1!=null && temp2!=null){
            if(temp1.data<temp2.data){
                merge.insert(temp1.data);
                temp1=temp1.next;
            }
            else{
                merge.insert(temp2.data);
                temp2=temp2.next;
            }
        }
        while(temp1!=null){
            merge.insert(temp1.data);
            temp1=temp1.next;
        }
        while(temp2!=null){
            merge.insert(temp2.data);
            temp2=temp2.next;
        }
        return merge;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        MergeTwoLinkedList obj1=new MergeTwoLinkedList();
        int m=in.nextInt();
        for(int i=0;i<m;i++){
            obj1.insert(in.nextInt());
        }
        MergeTwoLinkedList obj2=new MergeTwoLinkedList();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            obj2.insert(in.nextInt());
        }
        MergeTwoLinkedList obj3=MergeTwoLinkedList.mergeTwoList(obj1,obj2);
        obj3.display();
        in.close();
    }
}