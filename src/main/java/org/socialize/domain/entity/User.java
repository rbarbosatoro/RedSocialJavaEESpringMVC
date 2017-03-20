package org.socialize.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {

	private static final long serialVersionUID = -3320116015906956049L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	private String email;

	@NotNull
	@NotEmpty
	private String password;

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String lastname;

	@NotNull
	private Date birthdate;

	private Date joindate;

	private String phone1;

	private String phone2;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;

	@ManyToMany
	@JoinTable(name = "favorite_tweets")
	private Set<Tweet> favorite_tweets;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<Tweet> tweets;

	public User() {

	}

	public User(String email, String password, String name, String lastname, Date birthdate, Date joindate,
			Set<Role> roles) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.joindate = joindate;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Tweet> getFavorite_tweets() {
		return favorite_tweets;
	}

	public void setFavorite_tweets(Set<Tweet> favorite_tweets) {
		this.favorite_tweets = favorite_tweets;
	}

	public Set<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(Set<Tweet> tweets) {
		this.tweets = tweets;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<>();

		for (Role r : getRoles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + r.getName().toUpperCase()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((favorite_tweets == null) ? 0 : favorite_tweets.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((joindate == null) ? 0 : joindate.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone1 == null) ? 0 : phone1.hashCode());
		result = prime * result + ((phone2 == null) ? 0 : phone2.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((tweets == null) ? 0 : tweets.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (favorite_tweets == null) {
			if (other.favorite_tweets != null)
				return false;
		} else if (!favorite_tweets.equals(other.favorite_tweets))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (joindate == null) {
			if (other.joindate != null)
				return false;
		} else if (!joindate.equals(other.joindate))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone1 == null) {
			if (other.phone1 != null)
				return false;
		} else if (!phone1.equals(other.phone1))
			return false;
		if (phone2 == null) {
			if (other.phone2 != null)
				return false;
		} else if (!phone2.equals(other.phone2))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (tweets == null) {
			if (other.tweets != null)
				return false;
		} else if (!tweets.equals(other.tweets))
			return false;
		return true;
	}

}
