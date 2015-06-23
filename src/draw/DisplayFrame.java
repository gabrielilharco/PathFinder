package draw;

import representations.maps.Map;
import representations.Path;

public class DisplayFrame extends javax.swing.JFrame {
    public DisplayFrame(Path path, Map map){
        this.setSize(map.width+50, (int)map.height+50); //The window Dimensions
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        javax.swing.JPanel panel = new javax.swing.JPanel();
        //panel.setBounds(20, 20, 20, 20);
        //processing.core.PApplet sketch = new MainPApplet(path, map);
        MainPApplet sketch = new MainPApplet(path, map);
        panel.add(sketch);
        
        this.add(panel);
        sketch.init(); //this is the function used to start the execution of the sketch
        this.setVisible(true);
        sketch.setVariables(path,map);
        
    }
}