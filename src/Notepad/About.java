Javpackage Notepad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {
    About() {
        setBounds(400,100,600,500);
        setLayout(null);
        ImageIcon image1= new ImageIcon(ClassLoader.getSystemResource("Notepad/windows.png"));
        Image image2 = image1.getImage().getScaledInstance(300,60,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel headerIcon= new JLabel(image3);
        headerIcon.setBounds(70,40,400,80);
        add(headerIcon);

        ImageIcon image4= new ImageIcon(ClassLoader.getSystemResource("Notepad/notepad-icon-9.png"));
        Image image5 = image4.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon image6 = new ImageIcon(image5);
        JLabel icon= new JLabel(image6);
        icon.setBounds(50,180,70,70);
        add(icon);

        JLabel text = new JLabel("<html>About Notepad<br>My Notepad Version 2024<br>2024 About Notepad. All rights reserved<br><br>Notepad is a word processing program, <br>which allows changing of text in a computer file.<br>Notepad is a simple text editor for basic text-editing program<br> which enables computer users to create documents. </html>");
        text.setBounds(150,100,500,200);
        text.setFont(new Font ("SAN_SERIF",Font.PLAIN,16));
        add(text);

        JButton b1= new JButton("OK");
        b1.setBounds(580,500,80,25);
        b1.addActionListener(this);
        add(b1);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent a){
            this.setVisible(false);
    }

    public static void main(String[] args) {
        new About();
    }
}
