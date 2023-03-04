public class Main {

    static StudentFrame sf;
    static SetupFrame set;
    static TeacherFrame tf;

    public void openTf(){
        set.dispose();
        tf.setVisible(true);
    }

    public static void main(String[] args) {
        sf = new StudentFrame();
        set = new SetupFrame();
        tf = new TeacherFrame();
        set.setVisible(true);
    }
}