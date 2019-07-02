package br.com.erudio.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements Serializable, UserDetails{

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;

	@Column(name = "user_name", unique = true)
	private String userName;
	
	@Column(name = "full_name")
	private String fullname;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "account_non_expired")
	private Boolean accountNonExpired;
	
	@Column(name = "account_non_locked")
	private Boolean accountNonLocked;
	
	@Column(name = "credentials_non_expired")
	private Boolean credentialsNonExpired; 
	
	@Column(name = "enabled")
	private Boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER) // trazer sempre
	@JoinTable(name = "user_permission", joinColumns = {@JoinColumn(name = "id_user")},
										inverseJoinColumns = {@JoinColumn(name = "id_permission")})
	private List<Permission> permissions;
	
	public List<String> getRoles() {
		List<String> roles = new ArrayList<>();
		for (Permission permission: this.permissions) {
			roles.add(permission.getDescription());
		}
		return roles;
	}
	
	
	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}




	public String getFullname() {
		return fullname;
	}




	public void setFullname(String fullname) {
		this.fullname = fullname;
	}




	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}




	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}




	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}




	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}




	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}




	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}




	public Boolean getEnabled() {
		return enabled;
	}




	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}




	public List<Permission> getPermissions() {
		return permissions;
	}




	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}




	public void setUserName(String username) {
		this.userName = username;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.permissions;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((accountNonExpired == null) ? 0 : accountNonExpired.hashCode());
		result = prime * result + ((accountNonLocked == null) ? 0 : accountNonLocked.hashCode());
		result = prime * result + ((credentialsNonExpired == null) ? 0 : credentialsNonExpired.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (accountNonExpired == null) {
			if (other.accountNonExpired != null)
				return false;
		} else if (!accountNonExpired.equals(other.accountNonExpired))
			return false;
		if (accountNonLocked == null) {
			if (other.accountNonLocked != null)
				return false;
		} else if (!accountNonLocked.equals(other.accountNonLocked))
			return false;
		if (credentialsNonExpired == null) {
			if (other.credentialsNonExpired != null)
				return false;
		} else if (!credentialsNonExpired.equals(other.credentialsNonExpired))
			return false;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		if (fullname == null) {
			if (other.fullname != null)
				return false;
		} else if (!fullname.equals(other.fullname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (permissions == null) {
			if (other.permissions != null)
				return false;
		} else if (!permissions.equals(other.permissions))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	

	

}