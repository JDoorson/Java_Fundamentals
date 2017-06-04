package controller;

import model.Wildernis;
import view.Knoppenbalk;
import view.OplossingView;
import view.Statusbalk;
import view.WildernisView;

import javax.swing.*;
import java.awt.BorderLayout;

/**
 * Created by Jamal on 30/05/2017.
 */
public class CampsitesApplication extends JFrame {
    private Wildernis model;

    public CampsitesApplication()
    {
        model = new Wildernis(10);

        setBounds(100, 100, 500, 500);
        setLayout(new BorderLayout());
        setTitle("Campsites");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        new OplossingView(model);

        add(new Statusbalk(model), BorderLayout.NORTH);
        add(new WildernisView(model), BorderLayout.CENTER);
        add(new Knoppenbalk(model), BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args)
    {
        new CampsitesApplication();
    }
}
