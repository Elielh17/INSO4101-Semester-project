import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.nio.BufferUnderflowException;
import java.io.*;

public class command
{
    private static void type(String s, Robot robot) throws IOException, AWTException, InterruptedException {
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                robot.keyPress(KeyEvent.VK_SHIFT);
            }
            robot.keyPress(Character.toUpperCase(c));
            robot.keyRelease(Character.toUpperCase(c));
    
            if (Character.isUpperCase(c)) {
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
        }
    }

    private static void goToSchedule(String sem, String curso, Robot robot) throws IOException, AWTException, InterruptedException{
        robot.keyPress(KeyEvent.VK_5);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_6);
        Thread.sleep(1000);

        type(sem, robot);
        Thread.sleep(2000);
        type(curso, robot);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
    } 
    

    
    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        Runtime run = Runtime.getRuntime();
        run.exec("cmd /c start cmd.exe /K ssh estudiante@rumad.uprm.edu > output.txt");
        Thread.sleep(2000);

 
        // Create an instance of Robot class
        Robot robot = new Robot();
 
        // Press keys using robot. A gap of
        // of 500 milli seconds is added after
        // every key press
        robot.keyPress(KeyEvent.VK_ENTER);Thread.sleep(2000);

        goToSchedule("2", "mate4145", robot);
    }
}

// ssh estudainte@rumad.uprm.edu