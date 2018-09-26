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
	@JoinColumn(name = "fk_id_linkType")
	private LinkType linkType;

	@Column(name = "title")
	private String title;

	@Column(name = "path")
	private String path;

	@ManyToOne
	@JoinColumn(name = "fk_idactivity")
	private Activity activity;

	public Link() {
	}

	public Link(LinkType linkType, String title, String path, Activity activity) {
		this.linkType = linkType;
		this.title = title;
		this.path = path;
		this.activity = activity;
	}

	public Link(Long id, LinkType linkType, String title, String path, Activity activity) {
		this.id = id;
		this.linkType = linkType;
		this.title = title;
		this.path = path;
		this.activity = activity;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the activity
	 */
	public Activity getActivity() {
		return activity;
	}

	/**
	 * @param activity
	 *            the activity to set
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

}
