import javax.swing.*;
import java.awt.*; 


import java.io.IOException;

public class gui {

  /*
  * States:
  * 1- Main buttons
  * 2- Matricula Actions, Alta/Baja (MatriculaButton takes you to this state)
  * 3- Course information input for Alta/Baja
  */
  public static enum States {
    MainButtons, MatriculaButtons, CourseInput;
  }
  //Instantiating buttons and other items
  public static JButton MatriculaButton = new JButton("Matricula");;
  public static JButton AltaButton = new JButton("Alta");
  public static JButton BajaButton = new JButton("Baja");
  public static JButton EnterButton = new JButton("Enter");
  public static JButton BackButton = new JButton("Back");
  public static JTextField txt = new JTextField();
  public static JLabel curso = new JLabel("Codificacion del curso:");

  public static States CurrentState = States.MainButtons;

  //Creates the frame (Window?)
  public static JFrame frame = new JFrame("");

  //Instantiating Actions
  public static Actions.MainButtons mainbuttons = new Actions.MainButtons();
  public static Actions.MatriculaButtons matriculaButtons = new Actions.MatriculaButtons();
  public static Actions.AltaButtonAction altaButtonAction = new Actions.AltaButtonAction();
  public static Actions.BajaButtonAction bajaButtonAction = new Actions.BajaButtonAction();
  public static Actions.BackButtonAction backButtonAction = new Actions.BackButtonAction();
  public static Actions.EnterButtonAction enterButtonAction = new Actions.EnterButtonAction();

  public static String UserInputText = "";

  public static void main(String args[]) throws IOException, InterruptedException, AWTException{
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600,600);
    Rectangle framebounds = frame.getBounds();

    //Setting position of items
    MatriculaButton.setBounds(225,200,100,100); 
    AltaButton.setBounds(168,200, 10, 10);
    BajaButton.setBounds(280,200, 10, 10);
    EnterButton.setBounds(480, 200, 100, 100);
    BackButton.setBounds(0,0,100,100);
    txt.setBounds(180,200,100,100);
    curso.setBounds(30,200,100,100);

    //Adding items to the frame (window?)
    frame.add(MatriculaButton);
    frame.add(AltaButton);
    frame.add(BajaButton);
    frame.add(EnterButton);
    frame.add(BackButton);
    frame.add(txt);
    frame.add(curso);
    frame.setLayout(null);

    //Setting the size of the items
    MatriculaButton.setSize(100,100); 
    AltaButton.setSize(100,100);
    BajaButton.setSize(100,100);
    BackButton.setSize(70,30);
    EnterButton.setSize(100, 50);
    txt.setSize(300,50);
    curso.setSize(200,50);


    //Disabling unused items at the beginning
    AltaButton.setVisible(false);
    BajaButton.setVisible(false);
    EnterButton.setVisible(false);
    txt.setVisible(false);
    curso.setVisible(false);


    //Adding the actions to the corresponding buttons

    //Action of 'Matricula' button
    MatriculaButton.addActionListener(matriculaButtons);
    //Action of 'Altabutton'
    AltaButton.addActionListener(altaButtonAction); 
    //Action of 'Bajabutton'
    BajaButton.addActionListener(bajaButtonAction); 
    //Action of 'BackButton'
    BackButton.addActionListener(backButtonAction);
    //Action of 'EnterButton' it prints the text on the terminal and stores the text in a variable
    EnterButton.addActionListener(enterButtonAction);

    //Setting the frame (Window?) visible
    frame.setVisible(true);

  }

}
