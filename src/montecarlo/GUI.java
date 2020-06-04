/*
 * To change this license header1, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montecarlo;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 *
 * @author marti
 */
public class GUI extends JFrame{
    JPanel jp = new JPanel();
    JLabel demandLabel, frequencyLabel,  averageLabel, expectedLabel;
    JTextField demandText1, demandText2, demandText3, demandText4, demandText5, demandText6,
            frequencyText1, frequencyText2, frequencyText3, frequencyText4, frequencyText5, frequencyText6;
    JFrame frame;
    JButton back;
    JButton ok;
    JTable table1, table2;
    JScrollPane sp1, sp2;
    String[] header1 = {"Daily Demand", "Frequency ", "Probability", "Cumulative Probability", "Interval of Random Numbers"};
   static String[][] arr1 = new String[10][5];
    String[] header2 = {"Day", "Random Number", "Simulated Daily Demand"};
    static String[][] arr2=new String[10][3];
    public GUI(){
         setTitle("Monte Carlo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setContentPane(new JLabel(new ImageIcon("")));
        setBounds(450, 180, 450, 450);
        
        
        demandLabel = new JLabel("Demand");
        demandLabel.setBounds(130, 20, 100, 40);
        add(demandLabel);
         
        frequencyLabel = new JLabel("Frequency");
        frequencyLabel.setBounds(260, 20, 100, 40);
        add(frequencyLabel);

        demandText1 = new JTextField();
        demandText1.setBounds(100, 80, 100, 25);
        add(demandText1);
         
        demandText2 = new JTextField();
        demandText2.setBounds(100, 120, 100, 25); 
        add(demandText2); 
         
        demandText3 = new JTextField();
        demandText3.setBounds(100, 160, 100, 25);
        add(demandText3);
        
        demandText4 = new JTextField();
        demandText4.setBounds(100, 200, 100, 25);
        add(demandText4);
        
        demandText5 = new JTextField();
        demandText5.setBounds(100, 240, 100, 25);
         add(demandText5);
         
        demandText6 = new JTextField();
        demandText6.setBounds(100, 280, 100, 25);
        add(demandText6);
        
        frequencyText1 = new JTextField();
        frequencyText1.setBounds(260, 80, 100, 25);
        add(frequencyText1);

        frequencyText2 = new JTextField();
        frequencyText2.setBounds(260, 120, 100, 25);
        add(frequencyText2);

        frequencyText3 = new JTextField();
        frequencyText3.setBounds(260, 160, 100, 25);
        add(frequencyText3);

        frequencyText4 = new JTextField();
        frequencyText4.setBounds(260, 200, 100, 25);
        add(frequencyText4);

        frequencyText5 = new JTextField();
        frequencyText5.setBounds(260, 240, 100, 25);
        add(frequencyText5);

        frequencyText6 = new JTextField();
        frequencyText6.setBounds(260, 280, 100, 25);
        add(frequencyText6);

        ok=new JButton("OK");   
        ok.setBounds(170, 340, 100, 25);
        add(ok);
        
        back = new JButton("back");

        ok.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                  if("".equals(demandText5.getText())||"".equals(demandText6.getText())||"".equals(frequencyText1.getText())||
                          "".equals(demandText1.getText())||"".equals(demandText2.getText())||"".equals(demandText3.getText())||"".equals(demandText4.getText())||"".equals(frequencyText2.getText())||"".equals(frequencyText3.getText())||"".equals(frequencyText4.getText())||"".equals(frequencyText5.getText())||"".equals(frequencyText6.getText())){
                       JOptionPane.showMessageDialog(null, "Enter allrequired fields", "ALERT", JOptionPane.WARNING_MESSAGE);
                  
                  }
                  else{
                  dispose();
                 JPanel h=new JPanel();
                 frame = new JFrame();
                 frame.setTitle("Monte Carlo");
                 setDefaultCloseOperation(EXIT_ON_CLOSE);
                 setContentPane(new JLabel(new ImageIcon("")));
                 frame.setVisible(true);
                 frame.setResizable(false);
                 frame.setSize(1650, 750);
                
                 
                arr1[0][0] = (demandText1.getText());
                arr1[1][0] = (demandText2.getText());
                arr1[2][0] = (demandText3.getText());
                arr1[3][0] = (demandText4.getText());
                arr1[4][0] = (demandText5.getText());
                arr1[5][0] = (demandText6.getText());

                arr1[0][1] = (frequencyText1.getText());
                arr1[1][1] = (frequencyText2.getText());
                arr1[2][1] = (frequencyText3.getText());
                arr1[3][1] = (frequencyText4.getText());
                arr1[4][1] = (frequencyText5.getText());
                arr1[5][1] = (frequencyText6.getText());

                Function obj = new Function();
                obj.fun(arr1);
                table1 = new JTable(arr1, header1);
                sp1 = new JScrollPane(table1);
                sp1.setBounds(700, 500, 570, 183);

                
                int sum_ave = obj.func2(arr2);
                table2 = new JTable(arr2, header2);
                 sp2 = new JScrollPane(table2);
                 sp2.setBounds(70, 500, 400, 183);
                
                float temp[] = obj.fun3(arr1, arr2);
                 averageLabel=new JLabel("Average daily demand for tires = "+ temp[0]);
                 averageLabel.setBounds(0, 200,350, 50);
                 averageLabel.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 20));
                 
                 expectedLabel = new JLabel("Expected daily demand = " + temp[1]);
                 expectedLabel.setBounds(0, 300, 350, 50);
                 expectedLabel.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 20));
        
                  frame.add(sp2);
                 frame.add(sp1);
                 frame.add(expectedLabel);
                 frame.add(averageLabel);
                 h.add(back);
                 h.setLayout(new FlowLayout(0,0,0));
                 h.setVisible(true);
                 frame.add(h);
                  
                  }
                 
            }
             
        });
         
        back.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                 frame.dispose();
                 GUI g=new GUI();
                 g.setVisible(true);
             }
        });
    }
   
}
