package cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.services.FruitService;

@RestController
@RequestMapping("/fruit")
public class FruitControllers {

	@Autowired
    private final FruitService fruitService;


    public FruitControllers(FruitService fruitService) {
        this.fruitService = fruitService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> addFruit(@RequestBody Fruit fruit) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fruitService.add(fruit));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Fruit fruitDetails, @PathVariable(value = "id") String fruitId) {
        Optional<Fruit> fruit = fruitService.getOne(fruitId);

        if (!fruit.isPresent()) {
            throw new NotFoundException("Fruit not found with ID: " + fruitId);
        }
        fruit.get().setName(fruitDetails.getName());
        fruit.get().setQuantityKilograms(fruitDetails.getQuantityKilograms());

        return ResponseEntity.status(HttpStatus.CREATED).body(fruitService.add(fruit.get()));
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String fruitId) {
        Optional<Fruit> fruit = fruitService.getOne(fruitId);

        if (!fruit.isPresent()) {
            throw new NotFoundException("Fruit not found with ID: " + fruitId);
        }

        fruitService.deleteById(fruitId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(value = "id") String fruitId) {
        Optional<Fruit> fruit = fruitService.getOne(fruitId);

        if (!fruit.isPresent()) {
            throw new NotFoundException("Fruit not found with ID: " + fruitId);
        }
        return ResponseEntity.ok(fruit);
    }

    @GetMapping
    public List<Fruit> getAll() {

        List<Fruit> fruits = StreamSupport
                .stream(fruitService.getAll().spliterator(), false)
                .collect(Collectors.toList());
        return fruits;
    }
}