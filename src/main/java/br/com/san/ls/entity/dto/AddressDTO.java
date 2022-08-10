package br.com.san.ls.entity.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.san.ls.entity.Address;
import br.com.san.ls.entity.enums.State;

public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotBlank
	private String city;
	@NotBlank
	private String addressName;
	@NotBlank
	private String district;
	@NotBlank
	private String complement;
	private Integer number;

	@NotNull(message = "Selecione um")
	private State state;

	public AddressDTO() {

	}

	public AddressDTO(String city, String addressName, String district, String complement, Integer number,
			State state) {
		super();
		this.city = city;
		this.addressName = addressName;
		this.district = district;
		this.complement = complement;
		this.number = number;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String address) {
		this.addressName = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Address toAddress() {
		Address addressEnt = new Address();
		addressEnt.setCity(city);
		addressEnt.setAddressName(addressName);
		addressEnt.setDistrict(district);
		addressEnt.setComplement(complement);
		addressEnt.setNumber(number);
		addressEnt.setState(state.getState());
		return addressEnt;
	}

}
