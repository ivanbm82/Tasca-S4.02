package cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n01.model.domain.Fruit;

import java.util.Optional;

public interface FruitService {


    Iterable<Fruit> getAll();

    Fruit add(Fruit fruit);

    void deleteById(Long id);

    Optional<Fruit> getOne(Long id);

}