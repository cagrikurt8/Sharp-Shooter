package shooter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

public class Canvas extends JPanel implements KeyListener {
    int sightX = 100;
    int sightY = 100;
    int holeX;
    int holeY;
    boolean spacePressed = false;
    HashMap<BulletHole, int[]> bulletHoleList = new HashMap<>();
    int attempts = 12;
    int score = 0;
    int currScore = 0;
    boolean gameStarted = false;
    boolean up, down, right, left;

    public Canvas() {
        setName("Canvas");
        setSize(700, 700);
        setVisible(true);
        setBackground(Color.DARK_GRAY);
        setFocusable(true);
        addKeyListener(this);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(Target.IMAGE, 0, 0, null);
        g.drawImage(Sight.IMAGE, sightX, sightY, null);
        if (spacePressed) {
            for (BulletHole hole: bulletHoleList.keySet()) {
                int x = bulletHoleList.get(hole)[0];
                int y = bulletHoleList.get(hole)[1];
                g.drawImage(hole.IMAGE, x, y, null);
            }
        }
    }

    private void movement() {
        if (up) {
            sightY -= 10;
        }

        if (down) {
            sightY += 10;
        }

        if (right) {
            sightX += 10;
        }

        if (left) {
            sightX -= 10;
        }

        repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (attempts == 0) {
            return;
        }

        if (gameStarted) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (-10 < sightY - 10) {
                    up = true;
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (sightY + 10 < 630) {
                    down = true;
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (sightX + 10 < 630) {
                    right = true;
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (-10 < sightX - 10) {
                    left = true;
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                spacePressed = true;
                holeX = sightX + 35;
                holeY = sightY + 35;
                bulletHoleList.put(new BulletHole(), new int[]{holeX, holeY});
                attempts--;
                setScore();
                if (attempts == 0) {
                    endGame();
                } else {
                    setStatusBar();
                }
            }

            movement();
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE && !gameStarted) {
            gameStarted = true;
            setStatusBar();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        }
    }

    private void setScore() {
        Point2D holeLocation = new Point2D.Double(holeX, holeY);
        double dist = new Point2D.Double(345, 345).distance(holeLocation);

        if (dist < 30) {
            currScore = 10;
        } else if (dist < 60) {
            currScore = 9;
        } else if (dist < 90) {
            currScore = 8;
        } else if (dist < 120) {
            currScore = 7;
        } else if (dist < 150) {
            currScore = 6;
        } else if (dist < 180) {
            currScore = 5;
        } else if (dist < 210) {
            currScore = 4;
        } else if (dist < 240) {
            currScore = 3;
        } else if (dist < 270) {
            currScore = 2;
        } else if (dist < 300) {
            currScore = 1;
        } else {
            currScore = 0;
        }

        score += currScore;
    }

    private void setStatusBar() {
        SharpShooter.setStatusBar(String.format("Bullets left: %d, your score: %d (%d). Use \u2192 \u2190 \u2191 \u2193 SPACE buttons.", attempts, score, currScore));
    }

    private void endGame() {
        SharpShooter.setStatusBar(String.format("Game over, your score: %d", score));
    }
}
