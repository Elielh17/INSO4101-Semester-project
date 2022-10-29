import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  

class gui{

    public static void main(String args[]){
      //Creates the frame (Window?)
       JFrame frame = new JFrame("Putty en su forma Gay");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(600,600);
       Rectangle framebounds = frame.getBounds();

       //Creating items
       JButton MatriculaButton = new JButton("Matricula");
       JButton AltaButton = new JButton("Alta");
       JButton BajaButton = new JButton("Baja");
       JButton EnterButton = new JButton("Enter");
       JTextField txt = new JTextField();
       JLabel curso = new JLabel("Codificacion del curso:");

       //Setting position of items
       MatriculaButton.setBounds(225,200,100,100); 
       AltaButton.setBounds(168,200, 10, 10);
       BajaButton.setBounds(280,200, 10, 10);
       EnterButton.setBounds(480, 200, 100, 100);
       txt.setBounds(180,200,100,100);
       curso.setBounds(30,200,100,100);

       //Adding items to the frame (window?)
       frame.add(MatriculaButton);
       frame.add(AltaButton);
       frame.add(BajaButton);
       frame.add(EnterButton);
       frame.add(txt);
       frame.add(curso);
       frame.setLayout(null);

       //Setting the size of the items
       MatriculaButton.setSize(100,100); 
       AltaButton.setSize(100,100);
       BajaButton.setSize(100,100);
       EnterButton.setSize(100, 50);
       txt.setSize(300,50);
       curso.setSize(200,50);


       //Disabling unused items at the beginning

       //AltaButton.setEnabled(false);
       //BajaButton.setEnabled(false);
       AltaButton.setVisible(false);
       BajaButton.setVisible(false);
       EnterButton.setVisible(false);
       txt.setVisible(false);
       curso.setVisible(false);

       
       //Action of 'Matricula' button
       MatriculaButton.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
            AltaButton.setVisible(true);
            BajaButton.setVisible(true);
            MatriculaButton.setVisible(false);
                 }  
             });  
      //Action of 'Altabutton'
       AltaButton.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
            AltaButton.setVisible(false);
            BajaButton.setVisible(false);
            EnterButton.setVisible(true);
            txt.setVisible(true);
            curso.setVisible(true);
                 }  
             }); 
      
       //String text = txt.getText();
       //Prints text
       EnterButton.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
             String text = txt.getText();
             System.out.println(text);
                 }  
             }); 

       frame.setVisible(true);
    }

}
