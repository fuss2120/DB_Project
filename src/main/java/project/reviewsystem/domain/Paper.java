package project.reviewsystem.domain;

public class Paper {
	private String title;
	private String paperid;
	
	public Paper(String title, String paperid) {
		this.title = title;
		this.paperid = paperid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPaperid() {
		return paperid;
	}
	
	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}
	
	
}
