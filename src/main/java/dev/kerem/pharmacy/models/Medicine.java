package dev.kerem.pharmacy.models;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;

import dev.kerem.pharmacy.api.entity.AddMedicineDto;

@Entity
@Table(name = "medicines")
public class Medicine {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "medicine_name", nullable = false, length = 50)
	@NotEmpty(message = "Lütfen ilacın adını giriniz!")
	private String name;
	
	@Column(name = "type", nullable = false, length = 50)
	@NotEmpty(message = "Lütfen ilacın türünü giriniz!")
	private String type;
	
	@Column(name = "med_price", nullable = false)
	@NotEmpty(message = "Lütfen ilacın fiyatını giriniz!")
	private double price;
	
	@Column(name = "description", nullable = false, length = 100)
	@NotEmpty(message = "Lütfen açıklama giriniz!")
	private String description;
	
	@ManyToOne(cascade = CascadeType.REFRESH, targetEntity = Producer.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "producer_id", referencedColumnName = "id")
	private Producer producer; 
	
	public Medicine() {}
	
	public Medicine(String name, String type, double price,
			String description) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.description = description;
	}
	
	public static Medicine from(AddMedicineDto medicineDto) {
        Medicine m = new Medicine(medicineDto.getName(),
                medicineDto.getType(),
                medicineDto.getPrice(),
                medicineDto.getDescription());
        return m;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", producer=" + producer +
                '}';
	}
	
	public void update(AddMedicineDto medicineDto) {
		this.name = medicineDto.getName();
		this.type = medicineDto.getType();
		this.price = medicineDto.getPrice();
		this.description = medicineDto.getDescription();
	}
	
}
