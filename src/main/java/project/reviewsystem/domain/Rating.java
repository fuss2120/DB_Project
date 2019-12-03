package project.reviewsystem.domain;

public class Rating {
	private String revemail;
	private String paperid;
	private String techmerit;
	private String readability;
	private String originality;
	private String relavance;
	private String overallrecomm;
	
	public Rating(String revemail, String paperid, String techmerit, String readability, String originality, String relavance, String overallrecomm) {
		this.revemail = revemail;
		this.paperid = paperid;
		this.techmerit = techmerit;
		this.readability = readability;
		this.originality = originality;
		this.relavance = relavance;
		this.overallrecomm = overallrecomm;
	}

	public String getRevemail() {
		return revemail;
	}

	public void setRevemail(String revemail) {
		this.revemail = revemail;
	}
	
	public String getPaperid() {
		return paperid;
	}

	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}

	public String getTechmerit() {
		return techmerit;
	}

	public void setTechmerit(String techmerit) {
		this.techmerit = techmerit;
	}

	public String getReadability() {
		return readability;
	}

	public void setReadability(String readability) {
		this.readability = readability;
	}

	public String getOriginality() {
		return originality;
	}

	public void setOriginality(String originality) {
		this.originality = originality;
	}

	public String getRelavance() {
		return relavance;
	}

	public void setRelavance(String relavance) {
		this.relavance = relavance;
	}
	
	public String getOverallrecomm() {
		return overallrecomm;
	}
	
	public void setOverallrecomm(String overallrecomm) {
		this.overallrecomm = overallrecomm;
	}
}
