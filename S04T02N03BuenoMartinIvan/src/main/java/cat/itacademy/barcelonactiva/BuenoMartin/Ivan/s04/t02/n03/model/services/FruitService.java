package cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.domain.Fruit;

import java.util.Optional;

public interface FruitService {

    public Iterable<Fruit> getAll();

    public Page<Fruit> getAll(Pageable pageable);

    public Fruit add(Fruit fruit);

    public void deleteById(String id);

    public Optional<Fruit> getOne(String id);

}