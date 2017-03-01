package com.manage.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 生成唯一序列号
 * @author sun
 *
 */
public class RandomStr {
	public static String caseName;
	
	/**
     * 用当前日期生成唯一序列号
     * 格式：年+月+日+小时+分钟      20150421113300
	 * @return 
     */ 
	public String random(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		Calendar cal = Calendar.getInstance();
		String times = format.format(cal.getTime()).substring(0,19);
		Pattern pattern = Pattern.compile("[^0-9]");  
		Matcher matcher = pattern.matcher(times); 
		StringBuffer sbr = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sbr,"");
		}
		matcher.appendTail(sbr);
		System.out.println(sbr.toString());
		return sbr.toString();	
	}
	
	public String currentDate(int num){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, num); 
		String times = format.format(cal.getTime()).substring(0,10);
		return times;
	}
	
	/**
	 * 返回随机数（范围）
	 * @param min 最小数字
	 * @param max 最大数字
	 * @return
	 */
	public static int randomNum(int min, int max){		
		return new Random().nextInt(max - min + 1) + min;	
	}
	
	/**
	 * 生成邮箱
	 * 规则：3个字母 + ypg70 + 2个数字 + 合法邮箱后缀
	 * @return
	 */
	public static String randomEmail() {
        String str1 = "";
        String[] hGroup = {"@sina.com", "@163.com", "@126.com", "@qq.com", "@hotmail.com", "@gmail.com", "@sohu.com"};
        String[] qGroup = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};                   
        for(int n = 0; n < 3; n++) {
            str1 += qGroup[randomNum(0, 25)];
        }
        return str1 + "ypg70" + randomNum(10, 99) + hGroup[randomNum(0, 6)];
	}
	
	/**
	 * 生成手机号
	 * 规则：177000 + 当前时间戳最后五位数字
	 * @return
	 */
	public static String randomPhone() {
		long currenTime = System.currentTimeMillis();
		String time = Long.toString(currenTime);
		String str = time.substring(time.length()-5, time.length());
		return "127000" + str;
	}
	
	public void f() {
		System.out.println(randomEmail());
		System.out.println(randomPhone());
	}
	
	public static String createTitleName() {
		String[] names = {"我是一个粉刷匠，粉刷本领强！", "啦啦啦，我是卖报的小行家", "我在马路边，捡到一分钱", "采蘑菇的小姑娘背着一个大竹筐", "门前大桥下，游过一群鸭", "小兔子乖乖，把门儿开开",
				"天天我等着你，等着你捉泥鳅", "小螺号，嘀嘀嘀吹，海鸥听了展翅飞。", "天塌了，地陷了，小花狗不见了"};

		caseName = names[randomNum(0, 8)] + randomNum(1, 9999);

		return caseName;
	}
}
