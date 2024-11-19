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
    @Test
    public void should_face_west_when_orient_north_and_turn_left(){
        // Given
        MarsRover rover = new MarsRover(0,0,'N');

        //When
        rover.updateStatus("L");
        String report = rover.showStatus();

        //Then
        Assertions.assertEquals("0:0:W", report);
    }
    @Test
    public void should_face_south_when_orient_east_and_turn_right(){

        // Given
        MarsRover rover = new MarsRover(0,0,'E');

        //When
        rover.updateStatus("R");
        String report = rover.showStatus();

        //Then
        Assertions.assertEquals("0:0:S", report);
    }
    @Test
    public void should_be_minus1_minus1_E_when_turn_left_given_minus1_minus1_S(){
        // Given
        MarsRover rover = new MarsRover(-1,-1,'S');

        //When
        rover.updateStatus("L");
        String report = rover.showStatus();

        //Then
        Assertions.assertEquals("-1:-1:E", report);
    }




}
