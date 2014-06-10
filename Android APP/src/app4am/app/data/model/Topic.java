package app4am.app.data.model;

import java.util.ArrayList;

public class Topic {
	private int id = -1;
	private int newspaperID = -1;
	
	private ArrayList<News> newsList = null;
	
	public Topic(int id,int newspaperID){
		this.id = id;
		this.newspaperID = newspaperID;
		this.newsList = new ArrayList<News>();
	}
	
	public void addNews(News news){
		this.newsList.add(news);
	}
	
	public int getNewsCount(){
		return newsList.size();
	}
	
}
