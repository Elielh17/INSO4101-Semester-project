import java.awt.event.*;  

interface Actions extends ActionListener {
    public static gui mygui = new gui();

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

    public class EnterButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mygui.UserInputText = mygui.txt.getText();
            System.out.println(mygui.UserInputText);
        }

    }

}