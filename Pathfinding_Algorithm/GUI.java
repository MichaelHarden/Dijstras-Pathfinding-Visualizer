import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class GUI /*implements ActionListener*/ {

    private static JPanel[][] nodeViews = new JPanel[22][22];
        
    public GUI() {

        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        int panelPadding = 10;
        panel.setLayout(new GridLayout(22, 22));
        panel.setBackground(new Color(247, 247, 240));

        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 22; j++) {
                NodeView nodeView = new NodeView();
                nodeView.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
                nodeView.setBackground(new Color(247, 244, 240));
                
                nodeViews[i][j] = nodeView;
            }
        }
        
        for (JPanel[] row: nodeViews) {
            for (JPanel node: row) {
                panel.add(node);
            }
        }
        
        JButton runButton = new JButton();
        runButton.setBounds(0, 0, 30, 18);

        Dimension panelDimension = new Dimension(660 + (panelPadding * 2), 660 + (panelPadding * 2) + 50);

        JPanel panel2 = new JPanel();
        panel2.setSize(panelDimension);
        panel2.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(panel);
        panel2.add(runButton);
        panel2.setBackground(new Color(247, 244, 240));
        

        frame.add(panel2, BorderLayout.CENTER); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setTitle("PathFinder"); 
        frame.setSize(panelDimension);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    public static void main(String[] args) {
        new GUI();

        
    }
}