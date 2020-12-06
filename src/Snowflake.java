/* YOU SHOULD COMPLETE AND UNDERSTAND THE Ball.java and Bubble.java parts first! */
/* DON'T FORGET TO RENAME THE FILE TO Snowflake.java WHEN READY TO TEST! */

class Snowflake {
    /*
     * SUMMATIVE REQUIRED Implement this entire class. ONLY drawSnowflake() and
     * moveSnowflake() have been implemented for you! I recommend using your
     * Bubble.java as a template. Start by creating your instance variables and
     * constructors.
     */
    private Sketch s;
    private float diameter;
    private float x;
    private float y;
    private int col; 
    private int borderColor; 
    private float speedY;
    private float speedX;



    public Snowflake(Sketch sketch) {
        s = sketch;
        diameter = s.random(50, 100);
        x = s.random(diameter / 2, s.width - diameter / 2);
        y = s.random(diameter / 2, s.height - diameter / 2);

        col = s.color(255, 255, 255);

        speedX = s.random(5, 10);
        speedY = s.random(5, 10);
    }
    
    public Snowflake(Sketch sketch, float sx, float sy, float snowflakeDiameter, float X, float Y, int snowColor) {
      s = sketch;
      speedX = sx;
      speedY = sy;
      diameter = snowflakeDiameter;
      x = X;
      y = Y;
      col = snowColor;
    }

    public float getRadius(){
    return diameter / 2;
    }
    /** Draws the flake. */
    public void drawSnowflake() {
        s.stroke(col);
        s.line(x - getRadius() / 2, y - getRadius() / 2, x + getRadius() / 2, y + getRadius() / 2);
        s.line(x - getRadius() / 2, y + getRadius() / 2, x + getRadius() / 2, y - getRadius() / 2);
        s.line(x - getRadius(), y, x + getRadius(), y);
        s.line(x, y - getRadius(), x, y + getRadius());
    }

    /** Moves the flake */
    public void moveSnowflake() {
        if (x > (s.width - getRadius()) || x < getRadius()) {
            speedX = -speedX;
        }
        if (y < (-getRadius())) {
            y = s.height + getRadius();
        }
        if (y > (s.height + getRadius())) {
            y = -getRadius();
        }
        x += speedX;
        y += speedY;

    }
}
