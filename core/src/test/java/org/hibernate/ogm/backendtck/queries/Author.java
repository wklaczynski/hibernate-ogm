/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.backendtck.queries;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

/**
 * @author Gunnar Morling
 */
@Entity
@Indexed
public class Author {

	@Id
	private Long id;

	@Field(store = Store.YES, analyze = Analyze.NO, indexNullAs = "NULL_VALUE")
	private String name;

	@ContainedIn
	@OneToMany(mappedBy = "author")
	private Set<Hypothesis> hypotheses;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@IndexedEmbedded
	private Address address;

	private Integer age;

	private String country;

	public Author(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Author(Long id, String name, Integer age, String country) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.country = country;
	}

	public Author() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Hypothesis> getHypotheses() {
		return hypotheses;
	}

	public void setHypotheses(Set<Hypothesis> hypotheses) {
		this.hypotheses = hypotheses;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
