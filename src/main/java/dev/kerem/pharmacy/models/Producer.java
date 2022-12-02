package dev.kerem.pharmacy.models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Producer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "firstName", nullable = false, length = 50)
    @NotEmpty(message = "Lütfen isim giriniz!")
	private String firstName;
	
	@Column(name = "lastName", nullable = false, length = 50)
    @NotEmpty(message = "Lütfen soyisim giriniz!")
	private String lastName;
	
	@Column(name = "producer_address", nullable = false, length = 100)
    @NotEmpty(message = "Lütfen adresinizi giriniz!")
	private String address;
	
	@Column(name = "email_address", nullable = false, unique = true, length = 60)
    @NotEmpty(message = "Lütfen email adresinizi giriniz!")
    @Email(message = "Lütfen geçerli bir email adresi giriniz!")
	private String email;
	
	@Column(name = "phone_num", nullable = false, length = 15)
    @NotEmpty(message = "Lütfen telefon numaranızı giriniz!")
	private String phone;
	
	@OneToMany(mappedBy = "producer", cascade = CascadeType.ALL)
    @JsonIgnore
	private List<Medicine> medicines;
}
