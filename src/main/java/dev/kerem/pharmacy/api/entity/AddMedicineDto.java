package dev.kerem.pharmacy.api.entity;

public class AddMedicineDto {
	private String name;
	private String type;
	private double price;
	private String description;
	
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

	@Override
	public String toString() {
		return "AddMedicineDto{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
	}

}
