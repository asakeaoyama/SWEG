
public class D1007EX4 {
	public static void main(String[] args) {
		A: //標籤跟迴圈間不可以有任何指令 //;空白指令
		for(int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				if(i+j>10) {
					break A; //針對最內層的for迴圈
				}
			System.out.println("breaking point a");
			}
		System.out.println("breaking point b");
		}
	System.out.println("breaking point c");
	
	}
}
