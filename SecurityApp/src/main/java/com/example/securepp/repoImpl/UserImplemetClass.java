
package com.example.securepp.repoImpl;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.securepp.model.User;

public class UserImplemetClass implements UserDetails {

	private User user;

	public UserImplemetClass(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("USER"));

	}

	@Override
	public String getPassword() { // TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() { // TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // TODO Auto-generated method
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // TODO Auto-generated
		return true;
	}

	@Override
	public boolean isEnabled() { // TODO Auto-generated method stub
		return true;
	}

}
