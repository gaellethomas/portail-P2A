package co.simplon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "access")
public class Access {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_idlink_type")
	@Column(name = "link_type")
	private LinkType linkType;

	@Column(name = "title_access")
	private String titleAccess;

	@Column(name = "path_access")
	private String pathAccess;

	@ManyToOne
	@JoinColumn(name = "fk_idactivity")
	private Activity activityAccess;

	public Access() {
	}

	public Access(LinkType linkType, String titleAccess, String pathAccess, Activity activityAccess) {
		this.linkType = linkType;
		this.titleAccess = titleAccess;
		this.pathAccess = pathAccess;
		this.activityAccess = activityAccess;
	}

	public Access(Long id, LinkType linkType, String titleAccess, String pathAccess, Activity activityAccess) {
		this.id = id;
		this.linkType = linkType;
		this.titleAccess = titleAccess;
		this.pathAccess = pathAccess;
		this.activityAccess = activityAccess;
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
	 * @return the linkType
	 */
	public LinkType getLinkType() {
		return linkType;
	}

	/**
	 * @param linkType
	 *            the linkType to set
	 */
	public void setLinkType(LinkType linkType) {
		this.linkType = linkType;
	}

	/**
	 * @return the titleAccess
	 */
	public String getTitleAccess() {
		return titleAccess;
	}

	/**
	 * @param titleAccess
	 *            the titleAccess to set
	 */
	public void setTitleAccess(String titleAccess) {
		this.titleAccess = titleAccess;
	}

	/**
	 * @return the pathAccess
	 */
	public String getPathAccess() {
		return pathAccess;
	}

	/**
	 * @param pathAccess
	 *            the pathAccess to set
	 */
	public void setPathAccess(String pathAccess) {
		this.pathAccess = pathAccess;
	}

	/**
	 * @return the activityAccess
	 */
	public Activity getActivityAccess() {
		return activityAccess;
	}

	/**
	 * @param activityAccess
	 *            the activityAccess to set
	 */
	public void setActivityAccess(Activity activityAccess) {
		this.activityAccess = activityAccess;
	}

}
