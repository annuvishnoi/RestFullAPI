package com.fse.menurest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="book")
public class Book implements Serializable{
	private static final long serialVersionUID = -3377999917900917685L;
	@Id //PK support
	@GeneratedValue(strategy=GenerationType.IDENTITY) //unique + auto incr
	@Column(name="bookid")
	private long bookId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="volume")
	private Integer volume;
	
	@Column(name="publishdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date publishDate;
	
	@Transient
	private String publishDateStr;
	
	//@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="subjectid", nullable=false)
	private Subject subject;
	
	
	
	@Transient
	private long selectedSubject;
	public Book() {
		
	}
	public Book(long bookId) {
		this.bookId = bookId;
	}
	public Book(long bookId, String title, double price, Integer volume, Date publishDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishDate = publishDate;
	}
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	
	}
	
	public String getPublishDateStr() {
		this.publishDateStr = getPublishDate().toString();
		return publishDateStr;
	}
	public long getSelectedSubject() {
		return selectedSubject;
	}
	public void setSelectedSubject(long selectedSubject) {
		this.selectedSubject = selectedSubject;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (bookId ^ (bookId >>> 32));
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
		Book other = (Book) obj;
		if (bookId != other.bookId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishDate=" + publishDate + "]";
	}
}
