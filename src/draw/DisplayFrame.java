package draw;

public class DisplayFrame extends javax.swing.JFrame {
    public DisplayFrame(){
        this.setSize(1500, 1500); //The window Dimensions
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.setBounds(20, 20, 600, 600);
        processing.core.PApplet sketch = new GUIDrawer();
        panel.add(sketch);
        this.add(panel);
        sketch.init(); //this is the function used to start the execution of the sketch
        this.setVisible(true);
    }
}