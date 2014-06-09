package app4am.app.basedata;

import java.util.List;

import android.util.Log;

public class Data {
	
	public static String[] title = {"大法官：政黨比例代表制未違憲","合宜宅弊案肅貪官員被學長起底 王玨笑答「是抹黑」","藍籲蔡英文 表明九二共識立場",
			"美報告︰中國五至十年內 可全面封鎖台灣","約談學生逾400人 帆廷控國家濫訴","立委接獲刺馬信 網友酸︰推給學運就對了","結束訪中行程 賴清德返台",
			"林佳龍：不論對手是誰，選舉步伐不變","民進黨首度揮軍褒忠鄉 陳建名求「變」","江揆已握葉世文情資 李鴻源：為何不提醒我","賴清德行銷台南醫學美容醫療觀光"};
	
	public static void initTopicNews(List<String> topicNews){
		for(String itemString : title){
			topicNews.add(itemString);			
		}	
	}
}
