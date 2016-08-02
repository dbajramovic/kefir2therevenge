package ba.utic.isssgrupe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GroupUserLink {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long groupid;
	private String username;
	
	@ManyToOne
	private UserGroup group;
	
	public UserGroup getGroup() {
		return group;
	}
	
	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public long getGroupid() {
		return groupid;
	}

	public void setGroupid(long groupid) {
		this.groupid = groupid;
	}
}
