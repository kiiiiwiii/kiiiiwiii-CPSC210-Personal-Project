package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//The popup window for no evidence history
public class NewWindow extends JFrame {

    //error picture
    private JLabel error;

    //EFFECTS: constructs a window indicating no evidence available
    public NewWindow() {
        super("Error");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 600));
        setLayout(null);
        error = new JLabel();
        addImageToLabel(error);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    //MODIFIES: error
    //EFFECTS: constructs the error picture
    private void addImageToLabel(JLabel error) {
        try {
            BufferedImage buffer = ImageIO.read(new File("./src/main/ui/newwindow.jpeg"));
            ImageIcon imageIcon = new ImageIcon(buffer);
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(500,600,Image.SCALE_SMOOTH);
            error.setIcon(new ImageIcon(newImage));
            error.setBounds(0,0,500,600);
            add(error);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
