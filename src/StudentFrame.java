import java.awt.*;
import javax.swing.*;

public class StudentFrame extends JFrame{

    JPanel leftPane = new JPanel(), centerPane = new JPanel();

    public StudentFrame(){
        this.setSize(1300, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        leftPane.setPreferredSize(new Dimension(300, 10));
        leftPane.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 5));

        centerPane.setPreferredSize(new Dimension(300, 10));
        centerPane.setBackground(Color.GREEN);
        centerPane.setLayout(new CardLayout());

        this.add(leftPane, BorderLayout.WEST);
        this.add(centerPane, BorderLayout.CENTER);

        leftPane();
    }

    public void leftPane(){
        JPanel libBtn = new JPanel();
        JPanel browseBtn = new JPanel();

        libBtn.setPreferredSize(new Dimension(300, 100));
        libBtn.setLayout(new FlowLayout());
        libBtn.setBackground(Color.LIGHT_GRAY);

        browseBtn.setPreferredSize(new Dimension(300, 100));
        browseBtn.setLayout(new FlowLayout());
        browseBtn.setBackground(Color.LIGHT_GRAY);

        leftPane.add(libBtn);
        leftPane.add(browseBtn);
    }

    public static void main(String[] args){
        new StudentFrame();
    }
}
