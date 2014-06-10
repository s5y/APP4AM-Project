package app4am.app.data.model;

import java.util.List;

import android.util.Log;

public class Data {
	
	public static String[] newsPool = {"�j�k�x�G�F�Ҥ�ҥN���H��","�X�y�v���׵³g�x���Q�Ǫ��_�� ���������u�O�ٶ¡v","���~���^�� ����E�G�@�ѥ߳�",
			"�����i�J���꤭�ܤQ�~�� �i��������x�W","���;ǥ͹O400�H �|�ʱ���a�ݶD","�ߩe����밨�H ���ͻġJ�����ǹB�N��F","�����X����{ ��M�w��x",
			"�L���s�G���׹��O�֡A���|�B�藍��","���i�ҭ��״��x�ǩ��m ���ئW�D�u�ܡv","���}�w�����@�屡�� ���E���G���󤣴�����","��M�w��P�x�n��Ǭ��e�����[��"};
	
	public static String[] refreshNews = {"���^���ܡG�߰|�{�| �N�E�P�԰�","�Ť����G�{������ �O�ѬO�u�Ťߵ�v","���~���^�� ����E�G�@�ѥ߳�",
		"���v���j��� �o���u�������v","�ް��R�H�� �E������B�������","�d���@����� �ǳ꿳�I�o���y�@��","�����i�J���꤭�ܤQ�~�� �i��������x�W",
		"�g�T��O�|ĳ �b���ҥ��ʮu","���i�ҭ��״��x�ǩ��m ���ئW�D�u�ܡv","���ö���r���@��G�n���u�n��","��M�w��P�x�n��Ǭ��e�����[��"};
	
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
