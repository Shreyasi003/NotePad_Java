package Notepad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.*;
public class Notepad extends JFrame implements ActionListener {

    public String x[] = {"Serif","Century Gothic","SansSerif","Monospaced","Courier"};
    public String nm="";
    public int s[]={0,2,1},st=0;
    public int f[]={10,20,30,40,50},fs=20;
    JTextArea t;
   String text;
    Notepad(){

        setTitle("Notepad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("Notepad/notepad-icon-9.png"));
        Image icon = notepadIcon.getImage();
        setIconImage(icon);

        JMenuBar mb = new JMenuBar();
        mb.setBackground( new Color(255,229,204));
        setJMenuBar(mb);

        JMenu file = new JMenu("File");
        JMenu edit= new JMenu("Edit");
        JMenu view = new JMenu("View");
        JMenu ft,fstyle,fsize,txtclr,bg;
        JMenu about= new JMenu("About");
        file.setFont(new Font("SERIF",Font.BOLD,14));
        edit.setFont(new Font("SERIF",Font.BOLD,14));
        view.setFont(new Font("SERIF",Font.BOLD,14));
        about.setFont(new Font("SERIF",Font.BOLD,14));

        JMenuItem i1= new JMenuItem("New");
        i1.addActionListener(this);
        i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        JMenuItem i2= new JMenuItem("Open");
        i2.addActionListener(this);
        i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        JMenuItem i3= new JMenuItem("Save");
        i3.addActionListener(this);
        i3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        JMenuItem i4= new JMenuItem("Print");
        i4.addActionListener(this);
        i4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        JMenuItem i5= new JMenuItem("Exit");
        i5.addActionListener(this);
        i5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, ActionEvent.CTRL_MASK));
        file.add(i1);file.add(i2);file.add(i3);file.add(i4);file.add(i5);

        JMenuItem i6= new JMenuItem("Copy");
        i6.addActionListener(this);
        i6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        JMenuItem i7= new JMenuItem("Cut");
        i7.addActionListener(this);
        i7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        JMenuItem i8= new JMenuItem("Paste");
        i8.addActionListener(this);
        i8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        JMenuItem i9= new JMenuItem("Select all");
        i9.addActionListener(this);
        i9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        edit.add(i6);edit.add(i7);edit.add(i8);edit.add(i9);

        ft=new JMenu("Font Type");
        JMenuItem plain=new JMenuItem("Plain");
        plain.addActionListener(this);
        JMenuItem bold=new JMenuItem("Bold");
        bold.addActionListener(this);
        JMenuItem italics=new JMenuItem("Italics");
        italics.addActionListener(this);
        ft.add(plain);ft.add(bold);ft.add(italics);

        fstyle=new JMenu("Font Style");
        JMenuItem a1=new JMenuItem("SERIF");
        a1.addActionListener(this);
        JMenuItem a2=new JMenuItem("CENTURY GOTHIC");
        a2.addActionListener(this);
        JMenuItem a3=new JMenuItem("SANS-SERIF");
        a3.addActionListener(this);
        JMenuItem a4=new JMenuItem("MONOSPACED");
        a4.addActionListener(this);
        JMenuItem a5=new JMenuItem("COURIER");
        a5.addActionListener(this);
        fstyle.add(a1); fstyle.add(a2); fstyle.add(a3); fstyle.add(a4); fstyle.add(a5);

        fsize=new JMenu("Size");
        JMenuItem b1=new JMenuItem("10");
        b1.addActionListener(this);
        JMenuItem b2=new JMenuItem("20");
        b2.addActionListener(this);
        JMenuItem b3=new JMenuItem("30");
        b3.addActionListener(this);
        JMenuItem b4=new JMenuItem("40");
        b4.addActionListener(this);
        JMenuItem b5=new JMenuItem("50");
        b5.addActionListener(this);
        fsize.add(b1);fsize.add(b2);fsize.add(b3);fsize.add(b4);fsize.add(b5);

        txtclr= new JMenu("Text Color");
        JMenuItem r = new JMenuItem("Red");
        r.addActionListener(this);
        JMenuItem g = new JMenuItem("Green");
        g.addActionListener(this);
        JMenuItem b = new JMenuItem("Blue");
        b.addActionListener(this);
        JMenuItem bl = new JMenuItem("Black");
        bl.addActionListener(this);
        JMenuItem wt = new JMenuItem("White");
        wt.addActionListener(this);
        txtclr.add(r); txtclr.add(g);txtclr.add(b);txtclr.add(bl);txtclr.add(wt);

        bg= new JMenu("Background Color");
        JMenuItem red = new JMenuItem("Light Blue");
        red.addActionListener(this);
        JMenuItem green = new JMenuItem("Light Green");
        green.addActionListener(this);
        JMenuItem blue = new JMenuItem("Light Pink");
        blue.addActionListener(this);
        JMenuItem white = new JMenuItem("WHITE");
        white.addActionListener(this);
        bg.add(red);bg.add(green);bg.add(blue);bg.add(white);

        view.add(ft);view.add(fstyle);view.add(fsize);view.add(txtclr);view.add(bg);


        JMenuItem j1= new JMenuItem("About Notepad");
        j1.addActionListener(this);
        j1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        about.add(j1);

        mb.add(file);mb.add(edit);mb.add(view);mb.add(about);

        t=new JTextArea();
        t.setLineWrap(true);
        t.setWrapStyleWord(true);

        JScrollPane pane=new JScrollPane(t);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane);


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent a){
        if(a.getActionCommand().equals("New")) {
            t.setText("");

        }else if (a.getActionCommand().equals("Open")) {
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files","txt");
            chooser.addChoosableFileFilter(restrict);

            int action = chooser.showOpenDialog(this);
            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File f = chooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                t.read(reader, null);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if(a.getActionCommand().equals("Save")){
            JFileChooser Saveas= new JFileChooser();
            Saveas.setApproveButtonText("Save");
            int action = Saveas.showOpenDialog(this);
            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            }
            File f1= new File(Saveas.getSelectedFile()+".txt");
            BufferedWriter outFile = null;
            try {
                outFile=new BufferedWriter(new FileWriter(f1));
                t.write(outFile);
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(a.getActionCommand().equals("Print")){
            try{
                t.print();
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if(a.getActionCommand().equals("Exit")){
            System.exit(0);

        }else if(a.getActionCommand().equals("Copy")){
            text=t.getSelectedText();

        }else if(a.getActionCommand().equals("Cut")){
            text= t.getSelectedText();
            t.replaceRange("",t.getSelectionStart(),t.getSelectionEnd());

        }else if(a.getActionCommand().equals("Paste")){
            t.insert(text,t.getCaretPosition());

        }else if(a.getActionCommand().equals("Select all")){
            t.selectAll();

        }else if(a.getActionCommand().equals("Plain")){
            t.setFont(new Font(nm,s[0],fs));
            st=s[0];
        } else if (a.getActionCommand().equals("Bold")) {
            t.setFont(new Font(nm,s[2],fs));
            st=s[2];
        } else if(a.getActionCommand().equals("Italics")) {
            t.setFont(new Font(nm,s[1],fs));
            st=s[1];

        }else if(a.getActionCommand().equals("SERIF")){
            t.setFont(new Font(x[0], st, fs));
            nm=x[0];
        }else if(a.getActionCommand().equals("CENTURY GOTHIC")){
            t.setFont(new Font(x[1], st, fs));
            nm=x[1];
        } else if(a.getActionCommand().equals("SANS-SERIF")){
            t.setFont(new Font(x[2], st, fs));
            nm=x[2];
        }else if(a.getActionCommand().equals("MONOSPACED")){
            t.setFont(new Font(x[3], st, fs));
            nm=x[3];
        }else if(a.getActionCommand().equals("COURIER")){
            t.setFont(new Font(x[4], st, fs));
            nm=x[4];

        }
        else if(a.getActionCommand().equals("Red")){
            t.setForeground(Color.RED);
        }else if(a.getActionCommand().equals("Green")){
            t.setForeground(Color.GREEN);
        }else if(a.getActionCommand().equals("Blue")){
            t.setForeground(Color.BLUE);
        }else if(a.getActionCommand().equals("Black")){
            t.setForeground(Color.BLACK);
        }else if(a.getActionCommand().equals("White")){
            t.setForeground(Color.WHITE);

        }else if(a.getActionCommand().equals("10")){
            t.setFont(new Font(nm, st, f[0]));
            fs=f[0];
        }else if(a.getActionCommand().equals("20")){
            t.setFont(new Font(nm, st, f[1]));
            fs=f[1];
        }else if(a.getActionCommand().equals("30")){
            t.setFont(new Font(nm, st, f[2]));
            fs=f[2];
        }else if(a.getActionCommand().equals("40")){
            t.setFont(new Font(nm, st, f[3]));
            fs=f[3];
        }else if(a.getActionCommand().equals("50")){
            t.setFont(new Font(nm, st, f[4]));
            fs=f[4];

        }else if(a.getActionCommand().equals("Light Blue")){
            t.setBackground(new Color(204,229,255));
        }else if(a.getActionCommand().equals("Light Green")){
            t.setBackground(new Color(229,255,204));
        }else if(a.getActionCommand().equals("Light Pink")){
            t.setBackground(new Color(255,204,229));
        }else if(a.getActionCommand().equals("WHITE")){
            t.setBackground(Color.WHITE);

        }
        else if(a.getActionCommand().equals("About Notepad")){
           new About().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Notepad();
    }
}
