import java.awt.event.*;  
import Tools.*;
import Tools.command.RumadBot;

import java.io.IOException;
import java.util.ArrayList;
import java.awt.AWTException;
import java.awt.Robot;

interface Actions extends ActionListener {
    public static gui mygui = new gui();

    //Action to return to the main buttons state
    public class MainButtons implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            mygui.MatriculaButton.setVisible(true);
            mygui.AltaButton.setVisible(false);
            mygui.BajaButton.setVisible(false);
            mygui.EnterButton.setVisible(false);
            mygui.txt.setVisible(false);
            mygui.curso.setVisible(false);
            
        }

    }

    //Action of 'Matricula' button
    public class MatriculaButtons implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mygui.AltaButton.setVisible(true);
            mygui.BajaButton.setVisible(true);
            mygui.MatriculaButton.setVisible(false);

            //In case of 'BackButton' Action
            mygui.EnterButton.setVisible(false);
            mygui.txt.setVisible(false);
            mygui.curso.setVisible(false);

            mygui.CurrentState = gui.States.MatriculaButtons;
            
        }

    }

    //Enroll
    //Action of 'Altabutton'
    public class AltaButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mygui.AltaButton.setVisible(false);
            mygui.BajaButton.setVisible(false);
            mygui.EnterButton.setVisible(true);
            mygui.txt.setVisible(true);
            mygui.curso.setVisible(true);
            
            mygui.CurrentState = gui.States.CourseInput;
        }
        
    }
    
    //Unenroll
    //Action of 'Bajabutton'
    public class BajaButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mygui.AltaButton.setVisible(false);
            mygui.BajaButton.setVisible(false);
            mygui.EnterButton.setVisible(true);
            mygui.txt.setVisible(true);
            mygui.curso.setVisible(true);

            mygui.CurrentState = gui.States.CourseInput;
        }

    }
    //Action to return to the previous state
    public class BackButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (mygui.CurrentState) {
                case MatriculaButtons:
                    mygui.mainbuttons.actionPerformed(e);
                  break;
                case CourseInput:
                    mygui.matriculaButtons.actionPerformed(e);
                break;
      
                default:
                  break;
            }
        }
            
        

    }

    //Action to store text and process it to make actions in Rumad server
    public class EnterButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mygui.UserInputText = mygui.txt.getText();
            System.out.println(mygui.UserInputText);

            Runtime run = Runtime.getRuntime();
            try {
                run.exec("cmd /c start cmd.exe /K ssh estudiante@rumad.uprm.edu");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        
            // Create an instance of Robot class
            command command = new command();
            RumadBot bot = null;
            try {
                bot = command.new RumadBot(new Robot(), "2", mygui.UserInputText, new ArrayList<String>());
            } catch (AWTException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            try {
                bot.enter();
            } catch (IOException | AWTException | InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                bot.goToSchedule();
            } catch (IOException | AWTException | InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }

}