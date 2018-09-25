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
import javax.persistence.Table;

@Entity
@Table(name = "accessType")
public class LinkType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String nameAccessType;

	@OneToMany(mappedBy = "linkType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Link> accessList;

	public LinkType() {
	}

	public LinkType(String nameAccessType) {
		this.nameAccessType = nameAccessType;
	}

	public LinkType(Long id, String nameAccessType) {
		this.id = id;
		this.nameAccessType = nameAccessType;
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
	 * @return the nameLinkType
	 */
	public String getNameAccessType() {
		return nameAccessType;
	}

	/**
	 * @param nameLinkType
	 *            the nameLinkType to set
	 */
	public void setNameAccessType(String nameAccessType) {
		this.nameAccessType = nameAccessType;
	}

	/**
	 * @return the accessList
	 */
	public List<Link> getAccessList() {
		return accessList;
	}

	/**
	 * @param accessList
	 *            the accessList to set
	 */
	public void setAccessList(List<Link> accessList) {
		this.accessList = accessList;
	}
}
