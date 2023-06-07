package cat.itacademy.barcelonactiva.BuenoMartinIvan.s04.t02.n02.model.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "fruits")
public class Fruit implements Serializable{
	
	private static final long serialVersionUID = -2027531472541758098L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @NotBlank
	@Column(length = 50, nullable=false, unique=true)
	private String name;
	
	@Column(name = "Quantity_Kg", nullable=false)
	private int	 quantityKilograms;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantityKilograms() {
		return quantityKilograms;
	}

	public void setQuantityKilograms(int quantityKilograms) {
		this.quantityKilograms = quantityKilograms;
	}
	
	

}
