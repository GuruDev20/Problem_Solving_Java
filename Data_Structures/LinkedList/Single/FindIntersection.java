package Single;
import java.util.*;
public class FindIntersection {
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
    public static FindIntersection findCommon(FindIntersection obj1,FindIntersection obj2){
        FindIntersection result=new FindIntersection();
        Node temp1=obj1.head;
        while(temp1!=null){
            Node temp2=obj2.head;
            while(temp2!=null){
                if(temp1.data==temp2.data){
                    result.insert(temp1.data);
                }
                temp2=temp2.next;
            }
            temp1=temp1.next;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        FindIntersection obj1=new FindIntersection();
        int m=in.nextInt();
        for(int i=0;i<m;i++){
            obj1.insert(in.nextInt());
        }
        FindIntersection obj2=new FindIntersection();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            obj2.insert(in.nextInt());
        }
        FindIntersection obj3=FindIntersection.findCommon(obj1,obj2);
        obj3.display();
        in.close();
    }
}
