
public class D1007EX4 {
	public static void main(String[] args) {
		A: //���Ҹ�j�鶡���i�H��������O //;�ťի��O
		for(int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				if(i+j>10) {
					break A; //�w��̤��h��for�j��
				}
			System.out.println("breaking point a");
			}
		System.out.println("breaking point b");
		}
	System.out.println("breaking point c");
	
	}
}
