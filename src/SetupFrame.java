import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import com.formdev.flatlaf.intellijthemes.FlatAllIJThemes;

public class SetupFrame extends JFrame {

    final String img = "assets\\img\\";

    TeacherFrame tf = new TeacherFrame();
    StudentFrame sf = new StudentFrame();

    JPanel teacherPane = new JPanel();
    JPanel studentPane = new JPanel();

    public SetupFrame(){

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("E-Know Setup");

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 110));

        teacherPane.setPreferredSize(new Dimension(250, 250));
        studentPane.setPreferredSize(new Dimension(250, 250));

        //teacherPane.setBackground(Color.LIGHT_GRAY);
        //studentPane.setBackground(Color.LIGHT_GRAY);

        teacherPane.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));
        studentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));

        teacherPane.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.DARK_GRAY));
        studentPane.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.DARK_GRAY));

        this.add(teacherPane);
        this.add(studentPane);

        paneOpt();

        teacherPane.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                teacherPane.setBackground(Color.LIGHT_GRAY);
            }
            public void mouseExited(MouseEvent e){
                teacherPane.setBackground(getBackground());
            }
            public void mouseClicked(MouseEvent e){
                dispose();
                tf.setVisible(true);
            }
        });

        studentPane.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                studentPane.setBackground(Color.LIGHT_GRAY);
            }
            public void mouseExited(MouseEvent e){
                studentPane.setBackground(getBackground());
            }
            public void mouseClicked(MouseEvent e){
                dispose();
                sf.setVisible(true);
            }
        });

    }

    public void paneOpt(){
        JLabel teacherIcon = new JLabel(new ImageIcon(new ImageIcon(img+"instructor.png").getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT)));
        JLabel teacherLabel = new JLabel("Teacher");

        teacherLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        teacherPane.add(teacherIcon);
        teacherPane.add(teacherLabel);

        JLabel studentIcon = new JLabel(new ImageIcon(new ImageIcon(img+"student.png").getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT)));
        JLabel studentLabel = new JLabel("Student");

        studentLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        studentPane.add(studentIcon);
        studentPane.add(studentLabel);
    }

    public static void main(String[] args) {
        new SetupFrame().setVisible(true);
    }

}