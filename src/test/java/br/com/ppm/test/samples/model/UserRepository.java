package br.com.ppm.test.samples.model;

import java.util.List;

/**
 * User Repository
 * 
 * @author pedrotoliveira
 */
public interface UserRepository {
    
    User save(User user);
    
    User findOne(String id);
    
    void delete(User user);
    
    List<User> findAll();
	
}
