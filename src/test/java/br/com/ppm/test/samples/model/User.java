package br.com.ppm.test.samples.model;

/**
 * The User
 *
 * @author pedrotoliveira
 */
public class User {

	private String id;
	private String name;
	private String email;
	private Address address;

	public User(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public User(String id, String name, String email, Address address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
}
