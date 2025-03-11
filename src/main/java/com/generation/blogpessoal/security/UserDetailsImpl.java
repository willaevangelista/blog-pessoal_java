package com.generation.blogpessoal.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.blogpessoal.model.Usuario;

public class UserDetailsImpl implements UserDetails {
	
	//controle de versonamento para esta classe
	private static final long serialVersionUID = 1L; 
	
	// autorizacoes que o usuario tem
	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;
	
	//metodo construtor
	public UserDetailsImpl(Usuario user) {
		super();
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}
	
	public UserDetailsImpl() { }
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}
	
	// retornar a senha
	@Override
	public String getPassword() {
		
		return password;
	}

	// retornar o email do usuario
	@Override
	public String getUsername() {
		
		return userName;
	}

	// ajudar a verificar se o acesso ja expirou
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// auxiliar a validacao se usuario esta bloqueado no sistema
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// auxiliar validadar se a credencial expira
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// validar se o user esta ativp
	@Override
	public boolean isEnabled() {
		return true;
	}
	

}
