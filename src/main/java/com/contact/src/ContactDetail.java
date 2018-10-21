package com.contact.src;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 * Created by praveen on 10/18/18.
 */
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class ContactDetail
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String user;
	private String email;

	public ContactDetail()
	{

	}
	ContactDetail(String user,
			String email)
	{
		this.user = user;
		this.email = email;
	}

	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getUser()
	{
		return user;
	}
	public void setUser(String user)
	{
		this.user = user;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact{" +
				"id=" + id +
				", name='" + user + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
