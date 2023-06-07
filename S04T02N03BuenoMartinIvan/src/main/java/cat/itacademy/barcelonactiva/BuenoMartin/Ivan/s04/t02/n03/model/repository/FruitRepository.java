package cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.domain.Fruit;

@Repository
public interface FruitRepository extends MongoRepository<Fruit, String> {

}