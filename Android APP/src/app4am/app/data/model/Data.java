package app4am.app.data.model;

import java.util.List;

import android.util.Log;

public class Data {
	
	public static String[] newsPool = {"大法官：政黨比例代表制未違憲","合宜宅弊案肅貪官員被學長起底 王玨笑答「是抹黑」","藍籲蔡英文 表明九二共識立場",
			"美報告︰中國五至十年內 可全面封鎖台灣","約談學生逾400人 帆廷控國家濫訴","立委接獲刺馬信 網友酸︰推給學運就對了","結束訪中行程 賴清德返台",
			"林佳龍：不論對手是誰，選舉步伐不變","民進黨首度揮軍褒忠鄉 陳建名求「變」","江揆已握葉世文情資 李鴻源：為何不提醒我","賴清德行銷台南醫學美容醫療觀光"};
	
	public static String[] refreshNews = {"蔡英文放話：立院臨會 將激烈戰鬥","藍反擊：逢馬必反 別老是「空心菜」","藍籲蔡英文 表明九二共識立場",
		"住豪宅偷大賣場 她說「錢不夠」","豬骨充人骨 遷葬灌水、公僕放水","查葉世文金脈 傳喚興富發董座作證","美報告︰中國五至十年內 可全面封鎖台灣",
		"經貿國是會議 在野黨全缺席","民進黨首度揮軍褒忠鄉 陳建名求「變」","趙藤雄緊咬葉世文：要錢只好給","賴清德行銷台南醫學美容醫療觀光"};
	
	public static void initTopicNews(List<String> topicNews){
		for(String itemString : newsPool){
			topicNews.add(itemString);			
		}	
	}
	
	public static void refreshNews(List<String> news){
		if(news.size()>0)
			news.clear();
		int i = 0;
		for(String itemString : refreshNews){
			newsPool[i] = itemString;
			news.add(itemString);	
			i++;
		}		
	}
}
