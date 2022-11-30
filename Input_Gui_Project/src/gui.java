import javax.swing.*;

import java.awt.*; 


import java.io.IOException;
import java.util.ArrayList;

public class gui {

  /*
  * States:
  * 1- Main buttons
  * 2- Matricula Actions, Alta/Baja (MatriculaButton takes you to this state)
  * 3- Course information input for Alta/Baja
  */
  public static enum States {
    MainButtons, MatriculaButtons, StudentInfoInput, CourseInput, AvailableSection;
  }
  //Instantiating buttons and other items
  public static JButton MatriculaButton = new JButton("Matricula");
  public static JButton AvailableSectionsButton = new JButton("<html>Available <br/> sections<html>");
  public static JButton AltaButton = new JButton("Alta");
  public static JButton BajaButton = new JButton("Baja");
  public static JButton EnterButton = new JButton("Enter");
  public static JButton AddButton = new JButton("Add");
  public static JButton BackButton = new JButton("Back");

  //Declaring Labels
  public static JLabel cursoLabel = new JLabel("<html>Codificacion del curso: <br/> Ej. INSO4101-080<html>");
  public static JLabel NumeroIDLabel = new JLabel("<html>Numero de indentidicacíon: <br/> Ej. 802196970<html>");
  public static JLabel CodigoAccesoLabel = new JLabel("<html>Codigo de Acceso Permanente: <br/> Ej. 1234 <html>");
  public static JLabel SeguroSocialLabel = new JLabel("<html>Ultimos cuatro numeros <br/> de seguro social: <br/> Ej. 9867 <html>");
  public static JLabel FechaNacimientoLabel = new JLabel("<html>Fecha de Nacimiento:<html> <br/> Ej. MMDDAAAA");
  //public static JLabel TittleLabel = new JLabel("Refurbished RUMAD Interface");
  public static JLabel DeveloperLabel = new JLabel("<html> Developers: <br/> Alexander A. Angueira Bretón <br/> Eliel J. Hernández Vega <br/> Jeremy Sánchez Batiz <br/> Breanna G. Segarra Suárez <br/> Norely Torres Berríos <br/> Alexa M. Zaragoza Torres<html>");
  public static JLabel VersionLabel = new JLabel("Version: 1.0");

  //Declaring Texts fields
  public static JTextField textField = new JTextField();

  public static States CurrentState = States.MainButtons;

  //Creates the frame (Window)
  public static JFrame frame = new JFrame("Refurbished RUMAD Interface");

  //Instantiating Actions
  public static Actions.MainButtons mainbuttons = new Actions.MainButtons();
  public static Actions.MatriculaButtons matriculaButtons = new Actions.MatriculaButtons();
  public static Actions.AvailableSectionsButtons availablesectionsButtons = new Actions.AvailableSectionsButtons();
  public static Actions.AltaButtonAction altaButtonAction = new Actions.AltaButtonAction();
  public static Actions.BajaButtonAction bajaButtonAction = new Actions.BajaButtonAction();
  public static Actions.BackButtonAction backButtonAction = new Actions.BackButtonAction();
  public static Actions.EnterButtonAction enterButtonAction = new Actions.EnterButtonAction();
  public static Actions.AddButtonAction addButtonAction = new Actions.AddButtonAction();

  //Variables
  public static ArrayList<String> UsercourseInputArr = new ArrayList<String>();
  public static ArrayList<String> UsersectionInputArr = new ArrayList<String>();
  public static String UsercourseInput = "";
  public static ArrayList<String> UserInfoInput = new ArrayList<String>();
  public static JLabel Labels[] = {NumeroIDLabel, CodigoAccesoLabel, SeguroSocialLabel, FechaNacimientoLabel};


  public static int count = 0;

  public static ImageIcon img = new ImageIcon("Input_Gui_Project\\Images\\Logominimized.jpg");
  public static JLabel LogoLabel = new JLabel(img);
  public static void main(String args[]) throws IOException, InterruptedException, AWTException{
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //frame.setLayout(null); //Terminates default flow layout
    frame.setSize(600,600);
    frame.setLocationRelativeTo(null);
    Rectangle framebounds = frame.getBounds();

    //Setting position of items
      //Buttons
    MatriculaButton.setBounds(168,200,100,100); 
    AvailableSectionsButton.setBounds(280,200,100,100); 
    AltaButton.setBounds(168,200, 10, 10);
    BajaButton.setBounds(280,200, 10, 10);
    EnterButton.setBounds(480, 200, 100, 100);
    AddButton.setBounds(480, 250, 100, 100);
    BackButton.setBounds(0,0,100,100);

      //Texts
    textField.setBounds(180,200,100,100);

      //Labels
    cursoLabel.setBounds(30,200,100,100);
    NumeroIDLabel.setBounds(20,200,100,100);
    CodigoAccesoLabel.setBounds(2,200,100,100);
    SeguroSocialLabel.setBounds(0,200,100,100);
    FechaNacimientoLabel.setBounds(20,200,100,100);
    //TittleLabel.setBounds(168,100,500,500);
    DeveloperLabel.setBounds(1,425,100,100);
    VersionLabel.setBounds(497,520,100,100);
    LogoLabel.setBounds(-100,-100, 600,600);

    //Adding items to the frame (window)
    frame.add(MatriculaButton);
    frame.add(AvailableSectionsButton);
    frame.add(AltaButton);
    frame.add(BajaButton);
    frame.add(EnterButton);
    frame.add(AddButton);
    frame.add(BackButton);
    frame.add(textField);
    frame.add(cursoLabel);
    frame.add(NumeroIDLabel);
    frame.add(CodigoAccesoLabel);
    frame.add(SeguroSocialLabel);
    frame.add(FechaNacimientoLabel);
    //frame.add(TittleLabel);
    frame.add(DeveloperLabel);
    frame.add(VersionLabel);
    frame.add(LogoLabel);
    //frame.setLayout(null);

    //Setting the size of the items
    MatriculaButton.setSize(100,100); 
    AvailableSectionsButton.setSize(100,100);
    AltaButton.setSize(100,100);
    BajaButton.setSize(100,100);
    BackButton.setSize(70,30);
    EnterButton.setSize(100, 50);
    AddButton.setSize(100, 50);
    textField.setSize(300,50);
    cursoLabel.setSize(200,50);
    NumeroIDLabel.setSize(200,50); 
    CodigoAccesoLabel.setSize(200,50); 
    SeguroSocialLabel.setSize(200,50);
    FechaNacimientoLabel.setSize(200,50);
    //TittleLabel.setSize(200,50);
    DeveloperLabel.setSize(200,150);
    VersionLabel.setSize(200,50);
    LogoLabel.setSize(600,600);


    //Disabling unused items at the beginning
    AltaButton.setVisible(false);
    BajaButton.setVisible(false);
    EnterButton.setVisible(false);
    AddButton.setVisible(false);
    textField.setVisible(false);
    cursoLabel.setVisible(false);
    NumeroIDLabel.setVisible(false);
    CodigoAccesoLabel.setVisible(false); 
    SeguroSocialLabel.setVisible(false);
    FechaNacimientoLabel.setVisible(false);
    BackButton.setVisible(false);


    //Adding the actions to the corresponding buttons

    //Action of 'Matricula' button
    MatriculaButton.addActionListener(matriculaButtons);
    //Action of 'Matricula' button
    AvailableSectionsButton.addActionListener(availablesectionsButtons);
    //Action of 'Altabutton'
    AltaButton.addActionListener(altaButtonAction); 
    //Action of 'Bajabutton'
    BajaButton.addActionListener(bajaButtonAction); 
    //Action of 'BackButton'
    BackButton.addActionListener(backButtonAction);
    //Action of 'EnterButton' it prints the text on the terminal and stores the text in a variable
    EnterButton.addActionListener(enterButtonAction);

    AddButton.addActionListener(addButtonAction);

    //Setting the frame (Window) visible
    frame.setVisible(true);

  }

}
