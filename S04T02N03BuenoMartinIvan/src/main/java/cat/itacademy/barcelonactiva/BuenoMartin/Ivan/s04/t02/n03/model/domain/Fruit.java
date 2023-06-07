package cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.domain;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fruits")
public class Fruit implements Serializable {

    private static final long serialVersionUID = -2027531472541758098L;

    @Id
    private String id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    private int quantityKilograms;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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