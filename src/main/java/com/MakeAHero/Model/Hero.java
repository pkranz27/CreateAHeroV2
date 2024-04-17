package com.MakeAHero.Model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Hero {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hero_id")
	private Long id;
	
	
	
	@Length(min = 3, message = "Your first name must have at least 3 characters")
    @NotEmpty(message = "Please provide a first name")
	private String firstname;
	@Length(min = 3, message = "Your last name must have at least 3 characters")
    @NotEmpty(message = "Please provide a last name")
	private String lastName;
	
	
	private Integer level = 0;
	
	
	@NotEmpty(message = "Please provide a Biography")
	private String biography;
	
	private Integer age= 0;
	
	private Integer skillPoints;
	
	private Integer might=0;
	
	private Integer intellegence = 0;
	@NotNull(message="please select a race")
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "race_id", referencedColumnName = "race_id")
	private Race race;
	
	@NotNull(message="please select a profession")
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "profession_id", referencedColumnName = "profession_id")
	private Profession profession;
	
	@ElementCollection
	private List<Item> inventory;
	
	



	
	@CreationTimestamp
	private Date createdAt;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id")
	public User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSkillPoints() {
		return skillPoints;
	}

	public void setSkillPoints(Integer skillPoints) {
		this.skillPoints = skillPoints;
	}

	public Integer getMight() {
		return might;
	}

	public void setMight(Integer might) {
		this.might = might;
	}

	public Integer getIntellegence() {
		return intellegence;
	}

	public void setIntellegence(Integer intellegence) {
		this.intellegence = intellegence;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public List<Item> getInventory() {
		return inventory;
	}
		

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}
	
	
	
}
