import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainProgram extends JFrame {

    public static void main(String[] args) {
        MainProgram MP = new MainProgram();
    }

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JTextField tf[] = new JTextField[9];
    JLabel l[] = new JLabel[9];

    HandlingKeyboardMouse hkm;

    String label[] = {"Mouse clicked",
            "Mouse Entered",
            "Mouse Exit",
            "Mouse Pressed",
            "Mouse Released",
            "Mouse Dragged",
            "Mouse Moved",
            "Kode Tombol",
            "Karakter Tombol"};

    Container c;

    MainProgram() {
        setTitle("Menangani Input Dari Keyboard dan Mouse");

        c = this.getContentPane();
        c.setLayout(null);
        p1.setLayout(null);

        for (int i = 0; i < 9; i++) {
            tf[i] = new JTextField(30);
            tf[i].setEditable(false);
            tf[i].setFocusable(false);
            l[i] = new JLabel(label[i]);
            p1.add(l[i]).reshape(10, i * 30, 100, 25);
            p1.add(tf[i]).reshape(120, i * 30, 300, 25);
        }

        hkm = new HandlingKeyboardMouse(tf);

        p2.addMouseListener(hkm);
        p2.addMouseMotionListener(hkm);

        addKeyListener(hkm);

        p2.setBackground(Color.GREEN);
        p3.setBackground(Color.ORANGE);

        c.add(p1).reshape(0, 10, 500, 300);
        c.add(p2).reshape(50, 300, 400, 150);

        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class HandlingKeyboardMouse implements KeyListener, MouseListener, MouseMotionListener {

    int clickx, clicky;
    int pressx, pressy;
    int releasex, releasey;
    int enterx, entery;
    int exitx, exity;
    int dragx, dragy;
    int movex, movey;
    int mousebutton;
    int KodeTombol;
    char KarakterTombol;

    JTextField tf[] = new JTextField[9];

    HandlingKeyboardMouse(JTextField a[]) {
        for (int i = 0; i < 9; i++) {
            tf[i] = new JTextField(30);
            tf[i] = a[i];
        }
    }

    public void update() {
        tf[0].setText(mousebutton + " at " + clickx + "," + clicky);
        tf[1].setText(enterx + "," + entery);
        tf[2].setText(exitx + "," + exity);
        tf[3].setText(mousebutton + " at " + pressx + "," + pressy);
        tf[4].setText(mousebutton + " at " + releasex + "," + releasey);
        tf[5].setText(dragx + "," + dragy);
        tf[6].setText(movex + "," + movey);
        tf[7].setText("" + KodeTombol);
        tf[8].setText("" + KarakterTombol);
    }

    public void mouseClicked(MouseEvent e) {
        // Menyimpan posisi mouse
        clickx = e.getX();
        clicky = e.getY();
        // Mengupdate Tombol
        checkButton(e);
        // refresh tampilan
        update();
    }

    public void checkButton(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                mousebutton = 1;
                break;
            case MouseEvent.BUTTON2:
                mousebutton = 2;
                break;
            case MouseEvent.BUTTON3:
                mousebutton = 3;
                break;
            default:
                mousebutton = 0;
        }
    }

    public void mouseEntered(MouseEvent e) {
        enterx = e.getX();
        entery = e.getY();
        update();
    }

    public void mouseExited(MouseEvent e) {
        exitx = e.getX();
        exity = e.getY();
        update();
    }

    public void mousePressed(MouseEvent e) {
        pressx = e.getX();
        pressy = e.getY();
        update();
    }

    public void mouseReleased(MouseEvent e) {
        releasex = e.getX();
        releasey = e.getY();
        update();
    }

    public void mouseDragged(MouseEvent e) {
        dragx = e.getX();
        dragy = e.getY();
        update();
    }

    public void mouseMoved(MouseEvent e) {
        movex = e.getX();
        movey = e.getY();
        update();
    }

    public void keyPressed(KeyEvent e) {
        KodeTombol = e.getKeyCode();
        KarakterTombol = e.getKeyChar();
        update();
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {
    }
}