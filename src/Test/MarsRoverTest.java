package Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
public class MarsRoverTest {

    @Test
    public void should_initialize_mars_rover(){
        // Given
        MarsRover rover = new MarsRover(0,0,'N');
        Assertions.assertNotNull(rover);

        //When
        String report = rover.showStatus();

        //Then
        Assertions.assertEquals("0:0:N", report);
    }



}
