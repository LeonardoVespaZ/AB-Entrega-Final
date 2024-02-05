import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("Serial")
public class movimiento extends JPanel {

    int x = 0;
    int y = 0;
    int xa = 1;
    int ya= 1;

    // Método creado para que la bola tenga movimiento
    private void moveBall() {
            if (x + xa < 0)
                xa = 1; // incremento de 1 en 1
            if (x + xa > getWidth() - 40)
                xa = -1;
            if (y + ya < 0)
                ya = 1; // incremento de 1 en 1
            if (y + ya > getHeight() - 40)
                ya = -1;

            x = x + xa;
            y = y + ya;

    }

    @Override
    // Graficar la bola
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillOval(x, y, 40, 40);

    }

    // Graficar el lienzo
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("JuegoLVZ");
        movimiento game = new movimiento();
        frame.add(game);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Bucle creado para borrar y pintar la pelota según su reccorido
        while (true) {
            game.moveBall();
            game.repaint();
            Thread.sleep(10);

        }
    }
}
