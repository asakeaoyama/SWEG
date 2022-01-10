package p0106_2;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empl[]empl= new Empl[3];
		empl[0]=new Staff("01","john");
		empl[1]=new Sales("02","jason");
		empl[2]=new HourWorker("03","jenny");
		for(int i=0;i<3;i++) {
			System.out.println(empl[i].id+", "+empl[i].name+", "+empl[i].getPay());
		}
	}

}
/*
沒有用abstract class 的缺點 : 在父代必須先定義一個getpay方法的內容
實際情況 : 父代不知道 必須知道子代才知道怎麼做
>>將父代變成abstract class(必須被實作)
 */
/*兩大觀念
1.父代無法定義方法 2.子代強制改寫方法
*/
