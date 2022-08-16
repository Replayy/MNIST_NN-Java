import javax.swing.*;

public class MyFrame extends JFrame{
    Drawer draw;

    public MyFrame(double[][] input, int[] label){
        draw = new Drawer(input, label);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(draw);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }  
}