import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileViewer extends JFrame{

    JTextArea area = new JTextArea();
    JPanel control = new JPanel();
    JButton goBack = new JButton();



    public FileViewer(){
        this.setSize(1300, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        this.setTitle("E-Know File Viewer");


        area.setPreferredSize(new Dimension(800, 500));
        area.setFont(new Font("Arial", Font.PLAIN, 15));
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setBorder(BorderFactory.createCompoundBorder(
                area.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        this.add(control);
        this.add(area);

        control();
    }

    public void control(){
        control.setPreferredSize(new Dimension(800, 80));
        control.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        goBack.setText("Go Back");
        goBack.setPreferredSize(new Dimension(100, 35));
        goBack.setFocusable(false);
        goBack.addActionListener(e -> goBack());

        control.add(goBack);
    }

    public void goBack(){
        dispose();
        new TeacherFrame().setVisible(true);
    }

    public void displayFile(String file){
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                JLabel label = new JLabel();
                label.setText(data);
                area.add(label);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new FileViewer();
    }


}