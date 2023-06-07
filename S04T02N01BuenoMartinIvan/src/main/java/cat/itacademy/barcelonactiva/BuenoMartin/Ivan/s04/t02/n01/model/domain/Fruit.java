package cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Fruits")
public class Fruit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    
	private Long id;

	@Column(nullable = false)
    private String name;

    private int quantityKilograms;

	public Fruit(Long id, String name, int quantityKilograms) {
		super();
		this.id = id;
		this.name = name;
		this.quantityKilograms = quantityKilograms;
	}

	public Fruit() {
		super();
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

	public int getQuantityKilograms() {
		return quantityKilograms;
	}

	public void setQuantityKilograms(int quantityKilograms) {
		this.quantityKilograms = quantityKilograms;
	}
    

}