package com.tahauddin.syed.security.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "MY_USER_TABLE")
public class MyUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String username;

	private String password;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "MY_USER_AUTHORITY", 
			joinColumns = @JoinColumn(name="USER_ID", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name="AUTHORITY_ID", referencedColumnName = "ID")
	)
	@Singular
	private Set<Authority> authorities;

	@Builder.Default
	private boolean accountNonExpired = true;

	@Builder.Default
	private boolean accountNonLocked = true;

	@Builder.Default
	private boolean credentialsNonExpired = true;

	@Builder.Default
	private boolean enabled = true;

}
