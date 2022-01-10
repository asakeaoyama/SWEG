import java.util.Scanner;
import java.util.Arrays;
public class uva_10041_VitosFamily{
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int cases=sc.nextInt();
			for(int i=0;i<cases;i++)  {
				int size=sc.nextInt();
				int arr[]=new int[size];

				for(int k=0;k<size;k++) {
					arr[k]=sc.nextInt();
				}
				Arrays.sort(arr);

				int len=0;
				for(int o=0;o<size;o++){
					len+=Math.abs(arr[o]-arr[o/2]);
				}

				System.out.println(len);
			}
		}
	}
}