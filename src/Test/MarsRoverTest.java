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
    public void should_face_west_when_orient_north_and_turn_right(){
        // Given
        MarsRover rover = new MarsRover(0,0,'N');

        //When
        rover.updateStatus("R");
        String report = rover.showStatus();

        //Then
        Assertions.assertEquals("0:0:E", report);
    }


    @Test
    public void should_face_south_when_orient_east_and_turn_left(){

        // Given
        MarsRover rover = new MarsRover(0,0,'E');

        //When
        rover.updateStatus("L");
        String report = rover.showStatus();

        //Then
        Assertions.assertEquals("0:0:N", report);
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
    @Test
    public void should_face_west_when_orient_south_and_turn_right(){

        // Given
        MarsRover rover = new MarsRover(0,0,'S');

        //When
        rover.updateStatus("R");
        String report = rover.showStatus();

        //Then
        Assertions.assertEquals("0:0:W", report);
    }
    @Test
    public void should_face_south_when_orient_west_and_turn_left(){

        // Given
        MarsRover rover = new MarsRover(0,0,'W');

        //When
        rover.updateStatus("L");
        String report = rover.showStatus();

        //Then
        Assertions.assertEquals("0:0:S", report);
    }
    @Test
    public void should_face_north_when_orient_west_and_turn_right(){

        // Given
        MarsRover rover = new MarsRover(0,0,'W');

        //When
        rover.updateStatus("R");
        String report = rover.showStatus();

        //Then
        Assertions.assertEquals("0:0:N", report);
    }

    @Test
    public void should_be_0_1_N_when_0_0_N_and_move_forward(){

        // Given
        MarsRover rover = new MarsRover(0,0,'N');

        //When
        rover.updateStatus("M");
        String report = rover.showStatus();

        //Then
        Assertions.assertEquals("0:1:N", report);
    }

    @Test
    public void should_be_1_0_E_when_0_0_E_and_move_forward(){

        // Given
        MarsRover rover = new MarsRover(0,0,'E');

        //When
        rover.updateStatus("M");
        String report = rover.showStatus();

        //Then
        Assertions.assertEquals("1:0:E", report);
    }

    @Test
    public void should_be_0_minus1_S_when_0_0_S_and_move_forward(){

        // Given
        MarsRover rover = new MarsRover(0,0,'S');

        //When
        rover.updateStatus("M");
        String report = rover.showStatus();

        //Then
        Assertions.assertEquals("0:-1:S", report);
    }

    @Test
    public void should_be_minus1_0_W_when_0_0_W_and_move_forward(){

        // Given
        MarsRover rover = new MarsRover(0,0,'W');

        //When
        rover.updateStatus("M");
        String report = rover.showStatus();

        //Then
        Assertions.assertEquals("-1:0:W", report);
    }



    @Test
    public void should_stay_the_same_when_inputInvalidCharacter_given_minus1_minus1_S(){
        // Given
        MarsRover rover = new MarsRover(-1,-1,'S');

        //When
        rover.updateStatus("P");
        String report = rover.showStatus();

        //Then
        Assertions.assertEquals("-1:-1:S", report);
    }



}
