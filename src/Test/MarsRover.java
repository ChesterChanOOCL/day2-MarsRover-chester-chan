package Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MarsRover {
    private static char[] directionStatus = {'N', 'E', 'S', 'W'};
    private int x;
    private int y;
    private char direction;
    private int directionIndex;

    public enum Command {
        L, R, M, B
    }

    public MarsRover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.directionIndex = IntStream.range(0, directionStatus.length)
                .filter(i -> directionStatus[i] == direction)
                .findFirst()
                .orElse(-1);
    }


    private char getDirection() {
        return directionStatus[directionIndex];
    }

    public String showStatus() {
        System.out.println(x + ":" + y + ":" + getDirection());
        return x + ":" + y + ":" + getDirection();
    }

    private boolean isValidCommand(char command) {
        return Arrays.stream(Command.values())
                .map(cmd -> cmd.name().charAt(0))
                .anyMatch(c -> c == command);
    }

    public String updateStatus(String commands) {
        commands.chars()
                .mapToObj(c -> (char) c)
                .filter(this::isValidCommand)
                .forEach(command -> {
                    switch (command) {
                        case 'R':
                            changeDirection('R');
                            break;
                        case 'L':
                            changeDirection('L');
                            break;
                        case 'M':
                            moveForward();
                            break;
                        case 'B':
                            moveBackward();
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid command: " + command);
                    }
                });
        return showStatus();
    }

    private void moveForward() {
        switch (directionStatus[directionIndex]) {
            case 'N':
                y++;
                break;
            case 'E':
                x++;
                break;
            case 'S':
                y--;
                break;
            case 'W':
                x--;
                break;
        }
    }

    private void moveBackward() {
        switch (directionStatus[directionIndex]) {
            case 'N':
                y--;
                break;
            case 'E':
                x--;
                break;
            case 'S':
                y++;
                break;
            case 'W':
                x++;
                break;
        }
    }

    private void changeDirection(char turn) {
        if (turn == 'R') {
            directionIndex = (directionIndex + 1) % 4;
        } else if (turn == 'L') {
            directionIndex = (directionIndex + 3) % 4;
        }
    }

    public static void main(String[] args) {
        MarsRover rover = new MarsRover(0, 0, 'N');
        rover.updateStatus("MMRM");
        rover.showStatus();
    }
}
