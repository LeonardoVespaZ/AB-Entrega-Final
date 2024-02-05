import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

//Raqueta para golpear a la pelota

public class Racquet {
    private static final int Y = 380; // Posición de la raqueta en el lienzo, se define mediante constante (static final)
    private static final int WIDTH = 80; // Anchura de la raqueta, se define mediante constante (static final)
    private static final int HEIGHT = 10; // Altura de la raqueta, se define mediante constante (static final)
    int x = 190; // Posició inicial de la raqueta (eje X)
    int xa = 0;
    private Juego game;

    public Racquet(Juego game) {
        this.game = game;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
            x += xa;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }

    // Método utilizado para crear eventos de teclado
    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) // tecla "A" desplaza la barra hacía la izquierda
            xa = -1;
        if (e.getKeyCode() == KeyEvent.VK_L) // tecla "L" desplaza la barra hacía la derecha
            xa = 1;
    }

    public Rectangle getBounds() { //el método getBound() retorna un objeto de tipo rectangulo que encierra a la raqueta
        return new Rectangle(x, Y, WIDTH, HEIGHT); //utilizado para envolver a la raqueta para cuando se genere la colisión entre ella y la pelota
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setXa(int xa) {
        this.xa = xa;
    }

    public int getX() {
        return x;
    }

    public int getXa() {
        return xa;
    }
}

