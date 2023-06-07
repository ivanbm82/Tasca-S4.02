package cat.itacademy.barcelonactiva.BuenoMartinIvan.s04.t02.n02.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import cat.itacademy.barcelonactiva.BuenoMartinIvan.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.BuenoMartinIvan.s04.t02.n02.model.services.FruitService;

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
    public ResponseEntity<?> update(@Valid @RequestBody Fruit fruitDetails, @PathVariable(value = "id") int fruitId) {
       Optional<Fruit> fruit =fruitService.getOne(fruitId);
      
       if(!fruit.isPresent()) {
           throw new NotFoundException("Fruit not found with ID: " + fruitId);
			
		}
       	fruit.get().setName(fruitDetails.getName());
       	fruit.get().setQuantityKilograms(fruitDetails.getQuantityKilograms());
       	
		return ResponseEntity.status(HttpStatus.CREATED).body(fruitService.add(fruit.get()));
	}
    

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int fruitId) {
    	
    	if(!fruitService.getOne(fruitId).isPresent()) {
            throw new NotFoundException("Fruit not found with ID: " + fruitId);
		}
		
		fruitService.delete(fruitId);
		return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(value = "id") int fruitId) {
    	Optional<Fruit> fruit =fruitService.getOne(fruitId);
        
        if(!fruit.isPresent()) {
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
