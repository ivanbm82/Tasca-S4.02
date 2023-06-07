package cat.itacademy.barcelonactiva.BuenoMartinIvan.s04.t02.n02.model.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cat.itacademy.barcelonactiva.BuenoMartinIvan.s04.t02.n02.model.domain.Fruit;

public interface FruitService {
	

	public Iterable<Fruit> getAll();
	
	public Page<Fruit> getAll(Pageable pageable);
	
	public Fruit add(Fruit fruit);
   
	public void delete(int id);
	
	public Optional<Fruit> getOne(int id);
	

}
