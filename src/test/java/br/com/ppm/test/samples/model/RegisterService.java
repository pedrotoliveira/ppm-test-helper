package br.com.ppm.test.samples.model;

/**
 * Register Service
 * 
 * @author pedrotoliveira
 */
public class RegisterService {
    
    private UserRepository userRepository;

    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User register(User user) {
        return userRepository.save(user);
    }	
}
