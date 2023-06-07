package cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.repository.FruitRepository;

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
    public Page<Fruit> getAll(Pageable pageable) {
        return fruitRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Fruit add(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        fruitRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Fruit> getOne(String id) {
        return fruitRepository.findById(id);
    }
}