package com.fse.menurest.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="subject")
public class Subject implements Serializable{

	private static final long serialVersionUID = -4629419842063373937L;
	@Id //PK support
	@GeneratedValue(strategy=GenerationType.IDENTITY) //unique + auto incr
	@Column(name="subjectid")
	private long subjectId;
	
	@Column(name="subjecttitle")
	private String subtitle;
	
	@Column(name="duration")
	private Integer durationInHours;
	
	@JsonIgnore
	@OneToMany(mappedBy="subject", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Book> references = new HashSet<Book>();
	
	public Subject() {
		super();

	}
	public Subject(long subjectId, String subtitle, Integer durationInHours, Set<Book> references) {
		super();
		this.subjectId = subjectId;
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
		this.references = references;
	}
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public Integer getDurationInHours() {
		return durationInHours;
	}
	public void setDurationInHours(Integer durationInHours) {
		this.durationInHours = durationInHours;
	}
	public Set<Book> getReferences() {
		return references;
	}
	public void setReferences(Set<Book> references) {
		this.references = references;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (subjectId ^ (subjectId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (subjectId != other.subjectId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subtitle=" + subtitle + ", durationInHours=" + durationInHours
				+ ", references=" + references + "]";
	}
}
