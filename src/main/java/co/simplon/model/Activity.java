package co.simplon.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "activity")
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "activityList")
	private List<Person> personList = new ArrayList<>();

	@OneToMany(mappedBy = "activityAccess", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Access> accessList;

	public Activity() {
	}

	public Activity(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Activity(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	/**
	 * @return the accessList
	 */
	public List<Access> getAccessList() {
		return accessList;
	}

	/**
	 * @param accessList
	 *            the accessList to set
	 */
	public void setAccessList(List<Access> accessList) {
		this.accessList = accessList;
	}
}