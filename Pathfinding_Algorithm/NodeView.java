import javax.swing.*;
import java.awt.*;

public class NodeView extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension d = new Dimension(30, 30);
        this.setSize(d);

        g.setColor(new Color(211, 211, 211));

        int padding = 2;
        int width = (int) d.getWidth() - padding;
        int height = (int) d.getHeight() - padding;
        g.fillRoundRect(1, 1, width, height, 13, 13);
        
    }
}
