package co.simplon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "link")
public class Link {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "link")
	@SequenceGenerator(name = "link", sequenceName = "link_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_id_link_type")
	@Column(name = "link_type")
	private LinkType linkType;

	@Column(name = "title_link")
	private String titleLink;

	@Column(name = "path_link")
	private String pathLink;

	@ManyToOne
	@JoinColumn(name = "fk_idactivity")
	private Activity activityLink;

	public Link() {
	}

	public Link(LinkType linkType, String titleLink, String pathLink, Activity activityLink) {
		this.linkType = linkType;
		this.titleLink = titleLink;
		this.pathLink = pathLink;
		this.activityLink = activityLink;
	}

	public Link(Long id, LinkType linkType, String titleLink, String pathLink, Activity activityLink) {
		this.id = id;
		this.linkType = linkType;
		this.titleLink = titleLink;
		this.pathLink = pathLink;
		this.activityLink = activityLink;
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
	 * @return the titleLink
	 */
	public String getTitleLink() {
		return titleLink;
	}

	/**
	 * @param titleLink
	 *            the titleLink to set
	 */
	public void setTitleLink(String titleLink) {
		this.titleLink = titleLink;
	}

	/**
	 * @return the pathLink
	 */
	public String getPathLink() {
		return pathLink;
	}

	/**
	 * @param pathLink
	 *            the pathLink to set
	 */
	public void setPathLink(String pathLink) {
		this.pathLink = pathLink;
	}

	/**
	 * @return the activityLink
	 */
	public Activity getActivityLink() {
		return activityLink;
	}

	/**
	 * @param activityLink
	 *            the activityLink to set
	 */
	public void setActivityLink(Activity activityLink) {
		this.activityLink = activityLink;
	}

}
