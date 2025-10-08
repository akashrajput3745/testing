import java.awt.event.*;
import javax.swing.*;

public class MouseEventDemo extends JFrame implements MouseListener, MouseMotionListener {
    private JTextField textField;

    public MouseEventDemo() {
        setTitle("Mouse Event Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 20, 300, 30);
        add(textField);

        // Adding mouse listeners to the frame
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    // MouseListener methods
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        textField.setText("Mouse Clicked at: (" + x + ", " + y + ")");
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    // MouseMotionListener methods
    @Override
    public void mouseMoved(MouseEvent e) {
        // Optional: Can display the mouse position while moving if needed
        // textField.setText("Mouse Moved to: (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseDragged(MouseEvent e) { }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MouseEventDemo demo = new MouseEventDemo();
            demo.setVisible(true);
        });
    }
}