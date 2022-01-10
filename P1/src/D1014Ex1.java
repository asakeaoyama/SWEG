public class D1014Ex1 {
	public static void main(String[] args) {
		System.out.println("hello");
		a:
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if (i+j>10) {
					break a;
				}
			}
		}
	}
}
