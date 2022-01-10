
public class D1021EX6 {
	public static void main(String[] args) {
		String a="12345";
		int sum=0;
		for(int i=0;i<a.length();i++) {
			char tmp =a.charAt(i); //¨ú¥X¦r¤¸
			System.out.println(tmp);
			sum=sum + tmp-48; 	//tmp -'0'
			
		}
		System.out.println(sum);
	}
}
