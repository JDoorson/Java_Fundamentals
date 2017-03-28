import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 16/03/2017.
 */
public class BootVakjeView extends VakjeView implements Observer{
    private BootVakje bvakje;
    private Image imgCross;

    public BootVakjeView(BootVakje bvakje)
    {
        super(bvakje);
        this.bvakje = bvakje;
        imgCross = new ImageIcon("cross.png").getImage();
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(bvakje.geraakt) {
            setBackground(Color.GRAY);
            g.drawImage(imgCross, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void update(Observable obs, Object obj)
    {
        repaint();
    }
}
