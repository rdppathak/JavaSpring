package com.Example1.Company.Role;

import org.springframework.beans.factory.annotation.Autowired;

interface RoleDAO{
	public Role addRole(String title, String description);
}

public class RoleService implements RoleDAO{
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role addRole(String title, String description) {
		Role role = null;
		role = roleRepository.findByTitle(title);
		if (role == null){
			role = new Role(title, description);
			roleRepository.save(role);
		}
		return role;
	}
	
}
