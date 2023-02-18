package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUserWithOneRole() {
		Role roleAdmin = entityManager.find(Role.class, 1);
		User userArjun = new User("arjun@gmail.com", "123", "Arjun", "Chandran");
		userArjun.addRole(roleAdmin);
		
		User savedUser = repo.save(userArjun);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateUserWithTwoRole() {
		User userRavi = new User("ravi@gmail.com", "123", "Ravi", "Kumar");
		Role roleEditor= new Role(3);
		Role roleAssistant= new Role(5);
		
		userRavi.addRole(roleAssistant);
		userRavi.addRole(roleEditor);
		
		User savedUser = repo.save(userRavi);
		assertThat(savedUser.getId()).isGreaterThan(0);
		
	}
	
	 @Test
	 public void testListAllUsers() {
		 Iterable<User> listUsers = repo.findAll();
		 listUsers.forEach(user -> System.out.println(user));
	 }
	
	 @Test
	 public void testGetUserById() {
		 User userArjun = repo.findById(1).get();
		 System.out.println(userArjun);
		 assertThat(userArjun).isNotNull();
	 }

	 @Test
	 public void testUpdateUserDetails() {
		 User userArjun = repo.findById(1).get();
		 userArjun.setEnabled(true);
		 userArjun.setPassword("123");
		 
		 repo.save(userArjun);
	 }
	 
	 @Test
	 public void testUpdateUserRoles() {
		 User userRavi = repo.findById(2).get();
		 Role roleEditor= new Role(3);
		 Role roleSalesperson= new Role(2);
		 userRavi.getRoles().remove(roleEditor);
		 userRavi.addRole(roleSalesperson);
		 
		 repo.save(userRavi);
	 }
	 
	 @Test
	 public void testDeleteUser() {
		 Integer userId = 2;
		 repo.deleteById(userId);
	 }

	 @Test
	public void testGetUserByEmail(){
		String email = "ravi@gmail.com";
		User user =repo.getUserByEmail(email);
		assertThat(user).isNotNull();
	 }
	 
	 @Test
	 public void testCountById() {
		 Integer id =1;
		 Long countById = repo.countById(id);
		 
		 assertThat(countById).isNotNull().isGreaterThan(0);
	 }
	 
	 @Test
	 public void testDisabeleUser() {
		 Integer id =1;
		 repo.updateEnabledStatus(id, false);
	 }
	 
	 @Test
	 public void testEnabeleUser() {
		 Integer id =2;
		 repo.updateEnabledStatus(id, true);
	 }
	 
}
