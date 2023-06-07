package cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n01.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n01.model.repository.FruitRepository;

import java.util.Optional;

@Service
public class FruitServicesImpl implements FruitService {

    @Autowired
    private final FruitRepository fruitRepository;

    public FruitServicesImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Iterable<Fruit> getAll() {
        return fruitRepository.findAll();
    }

    @Override
    @Transactional
    public Fruit add(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        fruitRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Fruit> getOne(Long id) {
        return fruitRepository.findById(id);
    }
}