package KYUTES;

import java.text.NumberFormat;
import java.util.concurrent.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import javax.swing.JLabel;

public class CountDown{

	private JLabel timer;
	private int testTime;
	private int hr, min, sec;
	final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public CountDown(JLabel timer,int testTime) {
		this.timer = timer;
		this.testTime = testTime * 60;
	}
	
	public void start() {
		NumberFormat numberFormat = NumberFormat.getInstance();//控制時間的顯示格式
		numberFormat.setMinimumIntegerDigits(2);//設定數值的整數部分允許的最小位數
		
		final Runnable runnable = new Runnable() {
			
	        public void run() {
	        	hr = testTime / 3600;
				min = testTime % 3600 / 60;
				sec = testTime % 60;
				StringBuffer stringBuffer = new StringBuffer("");
				stringBuffer.append(numberFormat.format(hr) + ":" + numberFormat.format(min) + ":"+ numberFormat.format(sec));
				timer.setText(stringBuffer.toString());
	        	testTime--;
	            if (testTime < 0) {
	            	timer.setText("Time's Over!");
	                scheduler.shutdown();
	            }
	        }
	    };
	    scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
	}
	
	public void stop() {
		scheduler.shutdown();
	}
}