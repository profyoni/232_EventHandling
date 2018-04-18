package graphicaluserinterface1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MyApplication extends JFrame {

    private JTextField display = new JTextField(20);

    public MyApplication() {
        this.setSize(500, 200);
        this.setTitle("My Amazing App");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton button = new JButton("Press Me");

        JPanel mainPanel = new JPanel(); // default layout is FlowLayout
        mainPanel.setLayout(new GridLayout(5,3));
        mainPanel.setBackground(Color.red);
        
        MyFirstActionListener actionListener = new MyFirstActionListener();
        for (int i=0;i<15;i++)
        {
            JButton b = new JButton(i + 1 + "");
            b.setFont( new Font("Serif",0,0));
            mainPanel.add(b);
            
            b.addActionListener( actionListener );
        }
        
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(this.display, BorderLayout.SOUTH);

        button.addActionListener(actionListener);
        
        MyAmazingMouseMotionListener mml = new MyAmazingMouseMotionListener();
        
        mainPanel.addMouseMotionListener( mml ); // register event listener
        button.addMouseMotionListener(mml);

        setVisible(true);
    }

    private class MyAmazingMouseMotionListener implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            display.setText(e.getSource() + "" + e.getPoint());
         }
        
    }
    
    public class MyFirstActionListener implements ActionListener {

        private int buttonPressedTimes;
        String display;
// non static inner class
        // access to fields of outer class (MyApplication)

        @Override
        public void actionPerformed(ActionEvent e) {

            MyApplication.this.display.setText(e.getActionCommand());
        }

    }
}
