import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 16/03/2017.
 */
public class VakjeView extends JPanel implements Observer{
    private Vakje vakje;
    protected Image imgFlag;

    public VakjeView(Vakje vakje)
    {
        imgFlag = new ImageIcon("flag.png").getImage();
        this.vakje = vakje;
        vakje.addObserver(this);
        addMouseListener(new VakjeController(this));

        setBackground(Color.BLUE);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(vakje.marked) {
            g.drawImage(imgFlag, 0, 0, getWidth(), getHeight(), this);
        }

        if(vakje.bekend)
        {
            setBackground(Color.CYAN);
        }
    }

    public void update(Observable obs, Object obj)
    {
        repaint();
    }

    public Vakje getVakje()
    {
        return vakje;
    }
}
