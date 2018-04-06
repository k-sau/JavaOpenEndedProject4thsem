
package reservationsystem;

/**
 *
 * @author kumar
 */

import java.awt.*;
import java.awt.event.*;

public class ReservationSystem extends Frame implements ActionListener {
    
    int[] seats = new int[11];
    int smoke = 0;
    int nSmoke = 5;
    Label l1, l2;
    TextField tf1, tf2;
    Button b1, b2, no; //b2 is yes button
    Dialog d;
    
    ReservationSystem() {
        
        
        l1 = new Label("Please type 1 for Smoking");
        l1.setBounds(250, 100, 200, 30);
        
        l2 = new Label("Please type 2 for Non-smoking");
        l2.setBounds(250, 120, 200, 30);
        
        
        tf1 = new TextField();
        tf1.setBounds(250, 150, 200, 30);
        
        tf2 = new TextField();
        tf2.setBounds(100, 220, 600, 100);
        //tf2.setBackground(Color.LIGHT_GRAY);
        tf2.setEditable(false);   
        
        b1 = new Button("Submit");
        b1.setBounds(320, 180, 50, 30);
        b1.addActionListener(this);
        
        b2 = new Button("Yes");
        b2.setBounds(120, 350, 50, 30);
        b2.addActionListener(this);
        
        no = new Button("No");
        no.setBounds(160, 350, 50, 30);
        no.addActionListener(this);
        
        add(l1); add(l2); add(tf1); add(tf2); add(b1);
        
        setSize(800,600);
        setLayout(null);
        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
    }
    
    public void actionPerformed(ActionEvent e) {
        String str = tf1.getText();
        int val = Integer.parseInt(str);
        
           
        if(e.getSource() == b1) {
            if(val == 1 && smoke < 5) {
                 System.out.println(smoke);
                seats[++smoke] = 1;
                
                String s=String.valueOf(smoke);  
                String result = "Seat no.: " + s + "\nSection: Smoking";
                tf2.setText(result);
             }
            
            else if(val == 2 && nSmoke < 10) {
                 System.out.println(smoke);
                seats[++nSmoke] = 1;
                
                String s=String.valueOf(nSmoke);  
                String result = "Seat no.: " + s + "\nSection: Non-Smoking";
                tf2.setText(result);
             }
            else if(val == 1 && smoke >= 5 && nSmoke < 10) {
                String result = "Seats of smoking section is full. \n\nDo you want to reserve the seat in Non-Smoking section?";
                tf2.setText(result);
                add(b2);
                add(no);
            }
            else if(val == 2 && nSmoke >= 10 && smoke < 5) {
                String result = "Seats of Non-Smoking section is full. \n\nDo you want to reserve the seat in Smoking section?";
                tf2.setText(result);
                add(b2);
                add(no);
                
            }
            else {
                String result = "All seats are reserved.";
                tf2.setText(result);
            }
            
            
        }
        if(e.getSource()==b2) {
            remove(b2);
            remove(no);
            
            if(val == 1) {
                 System.out.println(smoke);
                seats[++nSmoke] = 1;
                
                String s=String.valueOf(smoke);  
                String result = "Seat no.: " + s + "\nSection: Non-Smoking";
                tf2.setText(result);
             }
            
            else if(val == 2) {
                 
                seats[++smoke] = 1;
                
                String s=String.valueOf(smoke);  
                String result = "Seat no.: " + s + "\nSection: Smoking";
                tf2.setText(result);
             }
        }
        if(e.getSource()==no) {
            remove(b2);
            remove(no);
            String result = "Next flight leaves in 3 hours.";
            tf2.setText(result);
        }
    }
    
    
    public static void main(String[] args) {
       new ReservationSystem();
    }
    
}
