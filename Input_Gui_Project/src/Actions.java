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
            mygui.AvailableSectionsButton.setVisible(true);
            mygui.AltaButton.setVisible(false);
            mygui.BajaButton.setVisible(false);
            mygui.EnterButton.setVisible(false);
            mygui.textField.setVisible(false);
            mygui.cursoLabel.setVisible(false);
            mygui.BackButton.setVisible(false);
            mygui.NumeroIDLabel.setVisible(false);
            mygui.CodigoAccesoLabel.setVisible(false);
            mygui.SeguroSocialLabel.setVisible(false);
            mygui.FechaNacimientoLabel.setVisible(false);
            mygui.AddButton.setVisible(false);
            mygui.DeveloperLabel.setVisible(true);
            mygui.VersionLabel.setVisible(true);
            //mygui.TittleLabel.setVisible(true);
            
        }

    }

    //Action of 'Matricula' button
    public class MatriculaButtons implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            mygui.textField.setVisible(true);
            mygui.NumeroIDLabel.setVisible(true);
            mygui.EnterButton.setVisible(true);
            mygui.MatriculaButton.setVisible(false);
            mygui.AvailableSectionsButton.setVisible(false);
            mygui.DeveloperLabel.setVisible(false);
            mygui.VersionLabel.setVisible(false);
            //mygui.TittleLabel.setVisible(false);
            mygui.BackButton.setVisible(true);

            mygui.textField.setText(null);

            mygui.CurrentState = gui.States.StudentInfoInput; 
        }

    }
    
    public class AvailableSectionsButtons implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mygui.MatriculaButton.setVisible(false);
            mygui.AvailableSectionsButton.setVisible(false);
            mygui.DeveloperLabel.setVisible(false);
            mygui.VersionLabel.setVisible(false);
            //mygui.TittleLabel.setVisible(false);
            mygui.EnterButton.setVisible(true);
            mygui.textField.setVisible(true);
            mygui.cursoLabel.setVisible(true);
            mygui.BackButton.setVisible(true);

            mygui.textField.setText(null);

            mygui.CurrentState = gui.States.AvailableSection;
            
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
            mygui.AddButton.setVisible(true);
            mygui.textField.setVisible(true);
            mygui.cursoLabel.setVisible(true);
            
            mygui.textField.setText(null);

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
            mygui.AddButton.setVisible(true);
            mygui.textField.setVisible(true);
            mygui.cursoLabel.setVisible(true);

            mygui.textField.setText(null);

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
                case StudentInfoInput:
                    mygui.mainbuttons.actionPerformed(e);
                break;
                case CourseInput:
                    mygui.mainbuttons.actionPerformed(e);
                break;
                case AvailableSection:
                    mygui.mainbuttons.actionPerformed(e);
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
            //When doing matricula
            if (mygui.CurrentState == gui.States.CourseInput) {
                mygui.UsercourseInput = mygui.textField.getText();
                System.out.println(mygui.UsercourseInputArr);

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
                    bot = command.new RumadBot(new Robot(), "2", mygui.UsercourseInput, new ArrayList<String>());
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
            //When in available sections
            else if (mygui.CurrentState == gui.States.AvailableSection) {
                //Insert code here <-------------------------------------------------------------------------------------Here
            }

            //When entering info of student
            else if (mygui.CurrentState == gui.States.StudentInfoInput && mygui.count +1 != mygui.Labels.length) {

                if (mygui.textField.getText() == " ") {
                    mygui.textField.setText("Write text here!");
                }
                else {
                    mygui.Labels[mygui.count].setVisible(false);
                    mygui.count += 1;
                    mygui.Labels[mygui.count].setVisible(true);
                    mygui.textField.setText(null);
                    mygui.UserInfoInput.add(mygui.textField.getText());
                }
            }
            //When finish entering info of student
            else {
                mygui.AltaButton.setVisible(true);
                mygui.BajaButton.setVisible(true);
                mygui.BackButton.setVisible(true);
                mygui.FechaNacimientoLabel.setVisible(false);

                //In case of 'BackButton' Action
                mygui.EnterButton.setVisible(false);
                mygui.textField.setVisible(false);
                mygui.cursoLabel.setVisible(false);
                mygui.count = 0;

                mygui.CurrentState = gui.States.MatriculaButtons;
            }
        }

    }
    //Add action
    public class AddButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (mygui.textField.getText().charAt(8) != '-') {
                    mygui.textField.setText("Wrong Input!");
                }
                else {
                    String curso = mygui.textField.getText().substring(0,8);
                    String Section = mygui.textField.getText().substring(9);
                    mygui.UsercourseInputArr.add(mygui.textField.getText().substring(0, 8));
                    mygui.UsersectionInputArr.add(mygui.textField.getText().substring(9));

                    mygui.textField.setText(null);
                }
            } catch (Exception l) {
                mygui.textField.setText("Wrong Input!");
            }
            
        }

    }


}