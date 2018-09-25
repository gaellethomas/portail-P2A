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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person")
	@SequenceGenerator(name = "person", sequenceName = "person_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "uid")
	private String uid;

	@Column(name = "phone_Number")
	private String phoneNumber;

	@Column(name = "mobile_Phone_Number")
	private String mobilePhoneNumber;

	@Column(name = "mail_Address")
	private String mailAddress;

	@ManyToOne
	@JoinColumn(name = "fk_idteam")
	private Team team;

	@Column(name = "workstation_Name")
	private String workstationName;

	@ManyToMany
	@JoinTable(name = "person_activity", joinColumns = {
			@JoinColumn(name = "FK_person", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "FK_activity", referencedColumnName = "ID") })
	private List<Activity> activityList = new ArrayList<>();

	public Person() {
	}

	public Person(String name, String firstName, String uid, String phoneNumber, String mobilePhoneNumber,
			String mailAddress, Team team, String workstationName, List<Activity> activityList) {
		this.name = name;
		this.firstName = firstName;
		this.uid = uid;
		this.phoneNumber = phoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.mailAddress = mailAddress;
		this.team = team;
		this.workstationName = workstationName;
		this.activityList = activityList;
	}

	public Person(Long id, String name, String firstName, String uid, String phoneNumber, String mobilePhoneNumber,
			String mailAddress, Team team, String ipAddress, String workstationName, List<Activity> activityList) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.uid = uid;
		this.phoneNumber = phoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.mailAddress = mailAddress;
		this.team = team;
		this.workstationName = workstationName;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the mobilePhoneNumber
	 */
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	/**
	 * @param mobilePhoneNumber
	 *            the mobilePhoneNumber to set
	 */
	public void setMobilePhoneNumber(String mobilePhoneNumber) {
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
	 * @return the workstationName
	 */
	public String getWorkstationName() {
		return workstationName;
	}

	/**
	 * @param workstationName
	 *            the workstationName to set
	 */
	public void setWorkstationName(String workstationName) {
		this.workstationName = workstationName;
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
