package cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03;

import org.junit.jupiter.api.BeforeEach;
import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.repository.*;
import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.services.*;
import cat.itacademy.barcelonactiva.BuenoMartin.Ivan.s04.t02.n03.model.domain.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FruitServicesImplTest {

    @Mock
    private FruitRepository fruitRepository;

    @InjectMocks
    private FruitServicesImpl fruitService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll_ShouldReturnAllFruits() {
        // Arrange
        List<Fruit> fruits = List.of(new Fruit(), new Fruit(), new Fruit());

        when(fruitRepository.findAll()).thenReturn(fruits);

        // Act
        Iterable<Fruit> result = fruitService.getAll();

        // Assert
        assertEquals(fruits, result);
        verify(fruitRepository, times(1)).findAll();
    }

    @Test
    void add_ShouldReturnAddedFruit() {
        // Arrange
        Fruit fruit = new Fruit();
        fruit.setName("Apple");
        fruit.setQuantityKilograms(10);

        when(fruitRepository.save(fruit)).thenReturn(fruit);

        // Act
        Fruit result = fruitService.add(fruit);

        // Assert
        assertEquals(fruit, result);
        verify(fruitRepository, times(1)).save(fruit);
    }

    @Test
    void deleteById_ShouldInvokeRepositoryDeleteById() {
        // Arrange
        String fruitId = "123";

        // Act
        fruitService.deleteById(fruitId);

        // Assert
        verify(fruitRepository, times(1)).deleteById(fruitId);
    }

    @Test
    void getOne_ShouldReturnOptionalFruit() {
        // Arrange
        String fruitId = "123";
        Fruit fruit = new Fruit();
        fruit.setId(fruitId);
        fruit.setName("Apple");
        fruit.setQuantityKilograms(10);

        when(fruitRepository.findById(fruitId)).thenReturn(Optional.of(fruit));

        // Act
        Optional<Fruit> result = fruitService.getOne(fruitId);

        // Assert
        assertEquals(Optional.of(fruit), result);
        verify(fruitRepository, times(1)).findById(fruitId);
    }
}

