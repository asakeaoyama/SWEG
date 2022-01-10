import java.util.Scanner;

public class uva_10170_TheHotelwithInfiniteRooms {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			long s=sc.nextLong();
			long d=sc.nextLong();	
			long sum=s;
			long count=s;
			while(sum<d) {
				count++;
				sum=sum+count;
			}
			System.out.println(count);
		}
		sc.close();
	}

}
