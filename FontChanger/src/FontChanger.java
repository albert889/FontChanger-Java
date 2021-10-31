import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FontChanger {

    private JTextArea textBox;
    private JComboBox<String> fontOption;
    private JPanel panel;
    private JComboBox<String> styleOption;
    private JComboBox<Integer> sizeOption;
    private String currentFont = "Arial";
    private int currentStyle = 0;
    private  int currentSize = 12;

    public FontChanger() {

        String[] fontTypes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for(String s: fontTypes){
            fontOption.addItem(s);
        }

        for(int i=6;i<=70;i++){
            sizeOption.addItem(i + 2);
        }

        fontOption.setSelectedItem(currentFont);
        sizeOption.setSelectedItem(currentSize);

        fontOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFont = (String)fontOption.getSelectedItem();

                textBox.setFont(new Font(currentFont, currentStyle, currentSize));
            }
        });

        styleOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (styleOption.getSelectedItem() == "Plain"){
                    currentStyle = 0;
                }else if (styleOption.getSelectedItem() == "Bold"){
                    currentStyle = 1;
                }else {
                    currentStyle = 2;
                }

                textBox.setFont(new Font(currentFont, currentStyle, currentSize));
            }
        });

        sizeOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSize = (Integer)sizeOption.getSelectedItem();
                textBox.setFont(new Font(currentFont, currentStyle, currentSize));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FontChanger");
        frame.setSize(1200, 600);
        frame.setContentPane(new FontChanger().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
