import java.awt.*;
import javax.swing.*;

public class TeacherFrame extends JFrame{

    public TeacherFrame(){
        this.setSize(1300, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
    }

    public static void main(){
        new TeacherFrame();
    }

}
