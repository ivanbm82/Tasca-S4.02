package cat.itacademy.barcelonactiva.BuenoMartinIvan.s04.t02.n02.model.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.BuenoMartinIvan.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.BuenoMartinIvan.s04.t02.n02.model.repository.FruitRepository;

@Service
public class FruitServicesImpl implements FruitService{

	 private final FruitRepository fruitRepository;

	    @Autowired
	    public FruitServicesImpl(FruitRepository fruitRepository) {
	        this.fruitRepository = fruitRepository;
	    }

	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Fruit> getAll() {
		// TODO Auto-generated method stub
		return fruitRepository.findAll();
		}

	@Override
	@Transactional(readOnly = true)
	public Page<Fruit> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return fruitRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Fruit add(Fruit fruit) {
		// TODO Auto-generated method stub
		return fruitRepository.save(fruit);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		fruitRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Fruit> getOne(int id) {
		// TODO Auto-generated method stub
		return fruitRepository.findById(id);
	}
	
	

}
