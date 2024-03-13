package Data_Structures.Hashing;
import java.util.*;
public class QuadraticProbing{
	public static void quadraticProbing(int[] a,int n){
		int size=n+n/2;
		int[] hash=new int[size];
		Arrays.fill(hash,-1);
		for(int i=0;i<n;i++){
			int rem=a[i]%size;
			if(hash[rem]==-1){
				hash[rem]=a[i];
				System.out.println("Inserting "+a[i]+" in index "+rem);
			}
			else{
				System.out.println("Inserting "+a[i]+" in index "+rem+" -> Collision");
				int j=1;
				while(true){
					int temp=(rem+j*j)%size;
					if(hash[temp]==-1){
						hash[temp]=a[i];
						System.out.println("Inserting "+a[i]+" in index "+temp);
						break;
					}
					else{
						System.out.println("Inserting "+a[i]+" in index "+temp+" -> Collision");
						j++;
					}
				}
			}
		}
		System.out.println();
		System.out.println("Hash Table:");
		for(int i=0;i<size;i++){
			System.out.println("Element at position "+i+": "+hash[i]);
		}
	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
		}
        in.close();
		quadraticProbing(a,n);
	}
}
