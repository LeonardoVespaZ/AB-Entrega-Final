import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pelota {
    private static final int DIAMETER = 30;
    int x = 0;
    int y = 0;
    int xa = 2; // velocidad de la pelota en eje x
    int ya = 2; // velocidad de la pelota en eje Y
    private Juego game;

    public Pelota(Juego game) {


        this.game= game;
    }

    void move() {
        if (x + xa < 0)
            xa = 2;
        if (x + xa > game.getWidth() - DIAMETER)
            xa = -2;
        if (y + ya < 0)
            ya = 2;
        if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver(); // Si llega a este límte inferior, se termina el juego mostrando la ventana "Juego Terminado"
        if (collision()){
            ya = -2;
        }

        x = x + xa;
        y = y + ya;
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    } // Si ambos rectangulos (getBound9 se solaparan, se genera la colisicón y el rebote de la pelota

    public void paint(Graphics2D g) {
        g.fillOval(x, y, 30, 30);
    }

    public Rectangle getBounds() { // el método getBound() retorna un objeto de tipo rectangulo que encierra a la pelota
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    } // utilizado para envolver a la pelota cuando se genere la colisión entre ella y la raqueta
}