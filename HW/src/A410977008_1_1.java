public class A410977008_1_1 {
	public static void main(String[] args) {
		int[][] a = { {2,5,-1},	 //object(4):a,a[0],a[1],a[2]
			      {13,2,6,8}, 
			      {7,7} };
		int minMax=0;	//�]�w��l��
		for(int i=0;i<a.length;i++) {	//a.length=3(a[0],a[1],a[2])  	(p.s. length() for String )
			int min=a[i][0];	//�]�w��l��
			for(int j=0;j<a[i].length;j++) {  //a[i].length
				if (a[i][j]<min) min=a[i][j];	//�P��l�Ȱ�����A��X�U�C�̤p��
			}
			if(minMax<min) minMax=min;	// ��X�U�C�̤p�Ȫ��̤j��
			System.out.printf("��%d�C�̤p�Ȭ� %2d\n",i+1,min);	//i��0�}�l�A�ҥH�L�Xi+1
		}
		System.out.printf("�U�C�̤p�Ȥ����̤j�Ȭ� %2d\n",minMax);
	}
}
