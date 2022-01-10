public class A410977008_1_1 {
	public static void main(String[] args) {
		int[][] a = { {2,5,-1},	 //object(4):a,a[0],a[1],a[2]
			      {13,2,6,8}, 
			      {7,7} };
		int minMax=0;	//砞﹚﹍
		for(int i=0;i<a.length;i++) {	//a.length=3(a[0],a[1],a[2])  	(p.s. length() for String )
			int min=a[i][0];	//砞﹚﹍
			for(int j=0;j<a[i].length;j++) {  //a[i].length
				if (a[i][j]<min) min=a[i][j];	//籔﹍暗ゑ耕т程
			}
			if(minMax<min) minMax=min;	// т程程
			System.out.printf("材%d程 %2d\n",i+1,min);	//iパ0秨﹍┮i+1
		}
		System.out.printf("程い程 %2d\n",minMax);
	}
}
