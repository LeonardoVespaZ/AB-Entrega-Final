import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

@SuppressWarnings("serial")
// clase donde se ejecuta el juego

public class Juego extends JPanel {

    Pelota ball = new Pelota(this); // proveniente de la clase Pelota
    Racquet racquet = new Racquet(this); // Proveniente de la clase Racquet

    public Juego() {
        addKeyListener(new KeyListener() { // está expresión se utiliza para que responda a los eventos del teclado
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);

            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);

            }
        });
        setFocusable(true);
    }

    private void move() {
        ball.move();
        racquet.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        ball.paint(g2d);
        racquet.paint(g2d);
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Juego terminado", "Juego Terminado", JOptionPane.YES_NO_OPTION);
        // muestra una ventana emergente con el mensaje "Juego terminado" y JOptionPne se utiiza para colocar un boton de aceptar
        System.exit(ABORT); // esta ejecución cierra la ventana del juego
    }


    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("JuegoLVZ");
        Juego game = new Juego();
        frame.add(game);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}

