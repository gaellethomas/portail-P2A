package co.simplon.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team")
	@SequenceGenerator(name = "team", sequenceName = "team_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "team_name")
	private String name;

	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Person> personList;

	public Team() {
	}

	public Team(String name) {
		this.name = name;
	}

	public Team(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Team(Long id, String name, List<Person> personList) {
		this.id = id;
		this.name = name;
		this.personList = personList;
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

	/**
	 * @return the personList
	 */
	public List<Person> getPersonList() {
		return personList;
	}

	/**
	 * @param personList
	 *            the personList to set
	 */
	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

}
