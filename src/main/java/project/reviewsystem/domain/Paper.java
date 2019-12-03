package project.reviewsystem.domain;

public class Paper {
	private String title;
	private String paperid;
	private String filename;
	private String contactauthoremail;
	private String abstractval;

	public Paper() {}
	
	public Paper(String title, String paperid) {
		this.title = title;
		this.paperid = paperid;
	}

	public Paper(String contactauthoremail, String title, String filename, String abstractval) {
		this.contactauthoremail = contactauthoremail;
		this.title = title;
		this.filename = filename;
		this.abstractval = abstractval;
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

	public String getFileName() {
		return filename;
	}

	public void setFileName(String filename) {
		this.filename = filename;
	}

	public String getContactauthoremail() {
		return contactauthoremail;
	}

	public void setContactauthoremail(String contactauthoremail) {
		this.contactauthoremail = contactauthoremail;
	}

	public String getAbstractval() {
		return abstractval;
	}

	public void setAbstractval(String abstractval) {
		this.abstractval = abstractval;
	}
	
	
}
