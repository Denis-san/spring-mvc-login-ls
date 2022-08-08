package br.com.san.ls.entity.dto;

import java.io.Serializable;

import br.com.san.ls.entity.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String firstName;
	private String lastName;
	private AddressDTO addressDTO;
	private UserLoginDTO userLoginDTO;

	public UserDTO() {
	}

	public UserDTO(String firstName, String lastName, AddressDTO addressDTO, UserLoginDTO userLoginDTO) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressDTO = addressDTO;
		this.userLoginDTO = userLoginDTO;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO adressDTO) {
		this.addressDTO = adressDTO;
	}

	public UserLoginDTO getUserLoginDTO() {
		return userLoginDTO;
	}

	public void setUserLoginDTO(UserLoginDTO userLoginDTO) {
		this.userLoginDTO = userLoginDTO;
	}

	public User toUser() {
		User user = new User();
		user.setFirstName(this.firstName);
		user.setLastName(this.lastName);
		user.setAddress(addressDTO.toAddress());
		user.setUserLogin(userLoginDTO.toUserLogin());
		return user;
	}
	
}
