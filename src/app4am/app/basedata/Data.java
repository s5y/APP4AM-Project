package app4am.app.basedata;

import java.util.List;

import android.util.Log;

public class Data {
	
	public static String[] title = {"�j�k�x�G�F�Ҥ�ҥN���H��","�X�y�v���׵³g�x���Q�Ǫ��_�� ���������u�O�ٶ¡v","���~���^�� ����E�G�@�ѥ߳�",
			"�����i�J���꤭�ܤQ�~�� �i��������x�W","���;ǥ͹O400�H �|�ʱ���a�ݶD","�ߩe����밨�H ���ͻġJ�����ǹB�N��F","�����X����{ ��M�w��x",
			"�L���s�G���׹��O�֡A���|�B�藍��","���i�ҭ��״��x�ǩ��m ���ئW�D�u�ܡv","���}�w�����@�屡�� ���E���G���󤣴�����","��M�w��P�x�n��Ǭ��e�����[��"};
	
	public static void initTopicNews(List<String> topicNews){
		for(String itemString : title){
			topicNews.add(itemString);			
		}	
	}
}
