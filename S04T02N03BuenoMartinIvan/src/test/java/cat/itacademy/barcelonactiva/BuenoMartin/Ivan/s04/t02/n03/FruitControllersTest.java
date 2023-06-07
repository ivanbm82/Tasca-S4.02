package cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.controllers.*;
import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.services.FruitService;
import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.domain.Fruit;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class FruitControllersTest {

    @Mock
    private FruitService fruitService;

    @InjectMocks
    private FruitControllers fruitControllers;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addFruit_ShouldReturnCreatedStatus() {
        // Arrange
        Fruit fruit = new Fruit();
        fruit.setName("Manzana");
        fruit.setQuantityKilograms(10);

        when(fruitService.add(fruit)).thenReturn(fruit);

        // Act
        ResponseEntity<?> response = fruitControllers.addFruit(fruit);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(fruit, response.getBody());
        verify(fruitService, times(1)).add(fruit);
    }

    @Test
    void update_ShouldReturnUpdatedFruit() {
        // Arrange
        String fruitId = "1";
        Fruit existingFruit = new Fruit();
        existingFruit.setId(fruitId);
        existingFruit.setName("Manzana");
        existingFruit.setQuantityKilograms(10);

        Fruit updatedFruit = new Fruit();
        updatedFruit.setId(fruitId);
        updatedFruit.setName("Banana");
        updatedFruit.setQuantityKilograms(15);

        when(fruitService.getOne(fruitId)).thenReturn(Optional.of(existingFruit));
        when(fruitService.add(existingFruit)).thenReturn(updatedFruit);

        // Act
        ResponseEntity<?> response = fruitControllers.update(updatedFruit, fruitId);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(updatedFruit, response.getBody());
        verify(fruitService, times(1)).getOne(fruitId);
        verify(fruitService, times(1)).add(existingFruit);
    }

    @Test
    void delete_ShouldReturnOkStatus() {
        // Arrange
        String fruitId = "1";
        Fruit existingFruit = new Fruit();
        existingFruit.setId(fruitId);
        existingFruit.setName("Manzana");
        existingFruit.setQuantityKilograms(10);

        when(fruitService.getOne(fruitId)).thenReturn(Optional.of(existingFruit));

        // Act
        ResponseEntity<?> response = fruitControllers.delete(fruitId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(fruitService, times(1)).getOne(fruitId);
        verify(fruitService, times(1)).deleteById(fruitId);
    }

    @Test
    void delete_ThrowsNotFoundException_WhenFruitNotFound() {
        // Arrange
        String fruitId = "1";

        when(fruitService.getOne(fruitId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> fruitControllers.delete(fruitId));
        verify(fruitService, times(1)).getOne(fruitId);
        verify(fruitService, never()).deleteById(any());
    }

	  
    @Test
    void getOne_ThrowsNotFoundException_WhenFruitNotFound() {
        // Arrange
        String fruitId = "1";

        when(fruitService.getOne(fruitId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> fruitControllers.getOne(fruitId));
        verify(fruitService, times(1)).getOne(fruitId);
    }

    @Test
    void getAll_ShouldReturnAllFruits() {
        // Arrange
        List<Fruit> fruits = List.of(new Fruit(), new Fruit(), new Fruit());

        when(fruitService.getAll()).thenReturn(fruits);

        // Act
        List<Fruit> result = fruitControllers.getAll();

        // Assert
        assertEquals(fruits, result);
        verify(fruitService, times(1)).getAll();
    }
}
