package dev.kerem.pharmacy.models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "producers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	@Override
	public String toString() {
		return "Producer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
	}
	
}
