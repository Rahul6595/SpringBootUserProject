package com.pas.testuser.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pas.testuser.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	
	List<User> findById(String id);
	List<User> findByUsername(String username);
	//List<User> findByDepartment(String department);
	/*@Query("SELECT t FROM Todo t where t.title = :title AND t.description = :description")
    public Optional<Todo> findByTitleAndDescription(@Param("title") String title, @Param("description") String description);
     
    @Query(value = "SELECT * FROM todos t where t.title = :title AND t.description = :description", nativeQuery=true)
    public Optional<Todo> findByTitleAndDescription(@Param("title") String title, @Param("description") String description);	*/
	
	@Query(value = "SELECT * FROM user u where u.department = :department", nativeQuery = true)
	public List<User> findByDepartment(@Param(value = "department") String department);
	
	List<User> findAllByOrderByDepartment();
	
	List<User> findByIdGreaterThan(int id);
	
}
