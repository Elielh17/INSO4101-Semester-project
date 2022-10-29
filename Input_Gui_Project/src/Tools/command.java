package Tools;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.io.*;

public class command
{   

    private void type(String s, Robot bot) throws IOException, AWTException, InterruptedException {
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                bot.keyPress(KeyEvent.VK_SHIFT);
            }
            bot.keyPress(Character.toUpperCase(c));
            bot.keyRelease(Character.toUpperCase(c));
    
            if (Character.isUpperCase(c)) {
                bot.keyRelease(KeyEvent.VK_SHIFT);
            }
        }
    }

    public class RumadBot {
        private Robot bot;
        private String courses;
        private List<String> secc;
        private String sem;
        

        public RumadBot(Robot roboCop, String sem, String course, List<String> secc) {
            this.bot = roboCop;
            courses = course;
            this.secc = secc;
            this.sem = sem;
        }

        public void goToSchedule() throws IOException, AWTException, InterruptedException{
            bot.keyPress(KeyEvent.VK_5);
            Thread.sleep(1000);
            bot.keyPress(KeyEvent.VK_6);
            Thread.sleep(1000);

            type(sem, bot);
            Thread.sleep(2000);
            type(courses, bot);
            bot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            bot.keyPress(KeyEvent.VK_ENTER);
        } 

        public void enter() throws IOException, AWTException, InterruptedException{
            bot.keyPress(KeyEvent.VK_ENTER);Thread.sleep(2000);
        }
    }
    
}

// ssh estudainte@rumad.uprm.edu