import java.util.*;
class Polynomial{
    class Node{
        int val;
        int pow;
        Node prev;
        Node next;
        public Node(int val,int pow){
            this.val=val;
            this.pow=pow;
            this.prev=null;
            this.next=null;
        }
    }
    private Node head=null;
    private Node tail=null;
    public void insert(int val,int pow){
        Node newNode=new Node(val,pow);
        if(head==null){
            head=newNode;
            tail=newNode;
            head.prev=null;
            tail.next=null;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.prev=temp;
            tail=newNode;
        }
    }
    public static Polynomial add(Polynomial p1,Polynomial p2){
        Polynomial result=new Polynomial();
        Node temp1=p1.head;
        Node temp2=p2.head;
        while(temp1!=null && temp2!=null){
            int val,pow;
            if(temp1.pow==temp2.pow){
                pow=temp1.pow;
                val=temp1.val+temp2.val;
                temp1=temp1.next;
                temp2=temp2.next;
            }
            else if(temp1.pow>temp2.pow){
                pow=temp1.pow;
                val=temp1.val;
                temp1=temp1.next;
            }
            else{
                pow=temp2.pow;
                val=temp2.val;
                temp2=temp2.next;
            }
            result.insert(val,pow);
        }
        while(temp1!=null){
            result.insert(temp1.val,temp1.pow);
            temp1=temp1.next;
        }
        while(temp2!=null){
            result.insert(temp2.val,temp2.pow);
            temp2=temp2.next;
        }
        return result;
    }
    public void display(){
        if(head==null){
            System.out.println("List is empty");
        }
        else{
            Node current=head;
            boolean isFirst=true;
            while(current!=null){
                if(current.val!=0){
                    if(current.val<0){
                        System.out.print("-");
                    }
                    else if(!isFirst){
                        System.out.print("+");
                    }
                    System.out.print(Math.abs(current.val));
                    if(current.pow>0){
                        System.out.print("x");
                        if(current.pow>1){
                            System.out.print(current.pow);
                        }
                    }
                    isFirst=false;
                }
                current=current.next;
            }
        }
    }   
}
public class PolynomialAddition{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Polynomial p1=new Polynomial();
        int m=in.nextInt();
        for(int i=0;i<m/2;i++){
            int val=in.nextInt();
            int pow=in.nextInt();
            p1.insert(val,pow);
        }
        Polynomial p2=new Polynomial();
        int n=in.nextInt();
        for(int i=0;i<n/2;i++){
            int val=in.nextInt();
            int pow=in.nextInt();
            p2.insert(val,pow);
        }
        Polynomial p3=Polynomial.add(p1,p2);
        p3.display();
        in.close();
    }
}
