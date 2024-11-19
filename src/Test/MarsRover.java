package Test;

public class MarsRover {
    private static char[] directionStatus = {'N', 'E', 'S', 'W'};

    private int x;
    private int y;
    private char direction;
    private int directionIndex;


    public enum Command {
        L, R , M
    }

    public MarsRover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        for (int i = 0; i < directionStatus.length; i++) {
            if (directionStatus[i] == this.direction) {
                this.directionIndex = i;
                break;
            }
        }
    }

    private char getDirection() {
        return directionStatus[directionIndex];
    }

    public String showStatus() {
        System.out.println(x + ":" + y + ":" + getDirection());
        return x + ":" + y + ":" + getDirection();
    }

    private boolean isValidCommand(char command){
        for (Command cmd: Command.values()){
            if (cmd.name().charAt(0) == command) {
                return true;
            }
        }
        return false;
    }

    public String updateStatus(String commands) {
        for (char command : commands.toCharArray()) {
            if (isValidCommand(command)) {
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

                }
            }
        }
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

    private void changeDirection(char turn) {
        if (turn == 'R') {
            directionIndex = (directionIndex + 1) % 4;
        } else if (turn == 'L') {
            directionIndex = (directionIndex + 3 ) % 4;
        }
    }

    public static void main(String[] args) {
        MarsRover rover = new MarsRover(0, 0, 'N');
        String status = rover.updateStatus("M");
        String status2 = rover.updateStatus("R");
        String status3 = rover.updateStatus("P");

    }
}