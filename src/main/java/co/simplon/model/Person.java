package co.simplon.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "uid")
	private String uid;

	@Column(name = "phone_Number")
	private int phoneNumber;

	@Column(name = "mobile_Phone_Number")
	private int mobilePhoneNumber;

	@Column(name = "mail_Address")
	private String mailAddress;

	@ManyToOne
	@JoinColumn(name = "fk_idteam")
	private Team team;

	@Column(name = "ip_Address")
	private String ipAddress;

	@Column(name = "xp_Address")
	private String xpAddress;

	@ManyToMany
	@JoinTable(name = "person_activity", joinColumns = {
			@JoinColumn(name = "FK_person", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "FK_activity", referencedColumnName = "ID") })
	private List<Activity> activityList = new ArrayList<>();

	public Person() {
	}

	public Person(String name, String firstName, String uid, int phoneNumber, int mobilePhoneNumber, String mailAddress,
			Team team, String ipAddress, String xpAddress, List<Activity> activityList) {
		this.name = name;
		this.firstName = firstName;
		this.uid = uid;
		this.phoneNumber = phoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.mailAddress = mailAddress;
		this.team = team;
		this.ipAddress = ipAddress;
		this.xpAddress = xpAddress;
		this.activityList = activityList;
	}

	public Person(Long id, String name, String firstName, String uid, int phoneNumber, int mobilePhoneNumber,
			String mailAddress, Team team, String ipAddress, String xpAddress, List<Activity> activityList) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.uid = uid;
		this.phoneNumber = phoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.mailAddress = mailAddress;
		this.team = team;
		this.ipAddress = ipAddress;
		this.xpAddress = xpAddress;
		this.activityList = activityList;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the phoneNumber
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the mobilePhoneNumber
	 */
	public int getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	/**
	 * @param mobilePhoneNumber
	 *            the mobilePhoneNumber to set
	 */
	public void setMobilePhoneNumber(int mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	/**
	 * @return the mailAddress
	 */
	public String getMailAddress() {
		return mailAddress;
	}

	/**
	 * @param mailAddress
	 *            the mailAddress to set
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	/**
	 * @return the team
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * @param team
	 *            the team to set
	 */
	public void setTeam(Team team) {
		this.team = team;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress
	 *            the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @return the xpAddress
	 */
	public String getXpAddress() {
		return xpAddress;
	}

	/**
	 * @param xpAddress
	 *            the xpAddress to set
	 */
	public void setXpAddress(String xpAddress) {
		this.xpAddress = xpAddress;
	}

	/**
	 * @return the activityList
	 */
	public List<Activity> getActivityList() {
		return activityList;
	}

	/**
	 * @param activityList
	 *            the activityList to set
	 */
	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}

}
