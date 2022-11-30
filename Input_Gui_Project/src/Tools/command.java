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
            Thread.sleep(100);
        }
    }

    public class RumadBot {
        private Robot bot;
        private List<String> courses;
        private List<String> secc;
        private List<String> studentInfo;
        private String sem;
        private boolean alta;
        

        public RumadBot(Robot roboCop, String sem, List<String> course, List<String> secc, List<String> info, boolean alta) {
            this.bot = roboCop;
            courses = course;
            this.secc = secc;
            this.sem = sem;
            studentInfo = info;
            this.alta = alta;
        }

        public void goToSchedule() throws IOException, AWTException, InterruptedException{
            bot.keyPress(KeyEvent.VK_5);
            Thread.sleep(1000);
            bot.keyPress(KeyEvent.VK_6);
            Thread.sleep(1000);

            type(String.valueOf((Integer.parseInt(sem)+1)%4), bot);
            Thread.sleep(2000);


            type(courses.get(0), bot);


            bot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            bot.keyPress(KeyEvent.VK_ENTER);
        } 

        private void doAlta() throws IOException, AWTException, InterruptedException{
            bot.keyPress(KeyEvent.VK_A);
            Thread.sleep(1000);
            for (int i = 0; i<courses.size(); i++) {
                type(courses.get(i), bot);
                Thread.sleep(1000);
                bot.keyPress(KeyEvent.VK_ENTER);
                Thread.sleep(1000);
                type(secc.get(i), bot);
                Thread.sleep(1000);
                bot.keyPress(KeyEvent.VK_ENTER);
            }
            Thread.sleep(1000);
            type("fin", bot);
            bot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            type("s", bot);
            Thread.sleep(1000);
            type("s", bot);
        } 

        private void dobaja() throws IOException, AWTException, InterruptedException{
            bot.keyPress(KeyEvent.VK_B);
            Thread.sleep(1000);
            for (int i = 0; i<courses.size(); i++) {
                type(courses.get(i), bot);
                Thread.sleep(1000);
                bot.keyPress(KeyEvent.VK_ENTER);
            }
            Thread.sleep(1000);
            type("fin", bot);
            bot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            type("s", bot);
            Thread.sleep(1000);
            type("s", bot);
        } 

        public void doMatricula() throws IOException, AWTException, InterruptedException{
            bot.keyPress(KeyEvent.VK_2);
            Thread.sleep(1000);
            for(String s : studentInfo) {
                type(s, bot);
                Thread.sleep(1000);
            }
            Thread.sleep(1000);
            type(sem, bot);
            Thread.sleep(2000);
            
            if(alta){doAlta();}
            else {dobaja();}
        } 

        public void enter() throws IOException, AWTException, InterruptedException{
            bot.keyPress(KeyEvent.VK_ENTER);Thread.sleep(2000);
        }
    }
    
}

// ssh estudainte@rumad.uprm.edu