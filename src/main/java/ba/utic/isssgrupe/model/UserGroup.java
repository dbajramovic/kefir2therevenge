package ba.utic.isssgrupe.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class UserGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String description;
	private String picpath;
	private Boolean teachinggroup;
	private Boolean forcedgroup;
	private String creatorusername;
	private Timestamp dateofcreation;
	private Boolean dissolved;
	@OneToMany(mappedBy ="groupid")
	private Set<GroupUserLink> grupusers;
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public Boolean getTeachinggroup() {
		return teachinggroup;
	}

	public void setTeachinggroup(Boolean teachinggroup) {
		this.teachinggroup = teachinggroup;
	}

	public Boolean getForcedgroup() {
		return forcedgroup;
	}

	public void setForcedgroup(Boolean forcedgroup) {
		this.forcedgroup = forcedgroup;
	}

	public String getCreatorusername() {
		return creatorusername;
	}

	public void setCreatorusername(String creatorusername) {
		this.creatorusername = creatorusername;
	}

	public Timestamp getDateofcreation() {
		return dateofcreation;
	}

	public void setDateofcreation(Timestamp dateofcreation) {
		this.dateofcreation = dateofcreation;
	}

	public Boolean getDissolved() {
		return dissolved;
	}

	public void setDissolved(Boolean dissolved) {
		this.dissolved = dissolved;
	}
	
}
