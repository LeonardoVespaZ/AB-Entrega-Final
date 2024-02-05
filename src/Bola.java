import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Bola extends JPanel {

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; // comando para crear la pelota
        g2d.setColor(Color.BLACK); // color de la pelota
        g2d.fillOval(0, 0, 40, 40); // Dimensiones de la pelota

    }

    //Se dibuja el lienzo sobre el cual aparecerá la Bola
    public static void main(String[] args) {
        JFrame frame = new JFrame("Juego LVZ");
        frame.add(new Bola());
        frame.setSize(500, 500); // DImensiones del lienzo
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}