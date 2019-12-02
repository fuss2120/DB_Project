package project.reviewsystem.domain;

public class Participator {
	private String email;
	private String firstname;
	private String lastname;
	private String minit;
	private String password;
	private String phone;
	private String affiliation;
	private String role;

	public Participator() {
		this.email = null;
		this.firstname = null;
		this.lastname = null;
		this.minit = null;
		this.password = null;
		this.phone = null;
		this.affiliation = null;
		this.role = null;
	}
	
	public Participator(
			String email, String firstname,
			String lastname, String minit, String password,
			String phone, String affiliation, String role
	) {
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.minit = minit;
		this.password = password;
		this.phone = phone;
		this.affiliation = affiliation;
		this.role = role;
	}

	public Participator(
		String email, String firstname,
		String lastname, String minit,
		String phone, String affiliation
	)
	{
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.minit = minit;
		this.phone = phone;
		this.affiliation = affiliation;
		this.password = null;
		this.role = null;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMinit() {
		return minit;
	}

	public void setMinit(String minit) {
		this.minit = minit;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAffilitation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
