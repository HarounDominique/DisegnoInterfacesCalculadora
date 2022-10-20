package Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CalculadoraInterface extends JFrame implements ItemListener{

    boolean numberOneSelected = false;

    //North pane objects

    JLabel titleText = new JLabel("Tabla de Multiplicar");

    JComboBox<Integer> barOptions = new JComboBox<>();

    //Center pane objects

    JButton[] buttons1 = new JButton[10];
    JButton[] buttons2 = new JButton[10];
    JButton[] buttons3 = new JButton[10];

    //South pane objects

    JLabel numberText1 = new JLabel("Número 1:");
    JLabel numberText2 = new JLabel("Número 2:");
    JLabel resultText = new JLabel("Resultado: ");

    JTextField textField1 = new JTextField();

    JTextField textField2 = new JTextField();

    JTextField textField3 = new JTextField();

    JButton sumButton = new JButton("Sumar");



    public CalculadoraInterface() {

        //North pane

        JPanel northPane = new JPanel();
        northPane.setLayout(new GridBagLayout());
        //Constraint will be reused in south pane
        GridBagConstraints c = new GridBagConstraints();

        northPane.add(titleText);
        c.gridy=1;
        c.weightx=3;
        c.fill = GridBagConstraints.HORIZONTAL;
        northPane.add(barOptions, c);



        this.add(northPane,BorderLayout.NORTH);

        for (int i=0; i<10; i++){
            barOptions.addItem(i);
        }
        barOptions.addItemListener(this);
        //Center pane

        JPanel centerPane = new JPanel();
        centerPane.setLayout(new GridLayout(10,3));


        for(int i=0; i<10; i++) {
            buttons1[i] = new JButton(String.valueOf(i));
            centerPane.add(buttons1[i]);
            buttons2[i] = new JButton("=");
            centerPane.add(buttons2[i]);
            buttons3[i] = new JButton("");
            centerPane.add(buttons3[i]);
        }

        //FUNCIONALIDAD DEL PRIMER ARRAY DE BOTONES
        for(int i=0; i<buttons1.length; i++){
            buttons1[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(!numberOneSelected){

                        for(int i =0; i< buttons1.length; i++){

                            if(buttons1[i].isSelected()){

                                numberText1.setText(buttons1[i].getText());
                            }
                            else{

                                for(i =0; i< buttons1.length; i++){

                                    if(buttons1[i].isSelected()){

                                        numberText2.setText(buttons1[i].getText());
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }


        this.add(centerPane,BorderLayout.CENTER);

        //South pane

        JPanel southPane = new JPanel();
        southPane.setLayout(new GridBagLayout());
        southPane.setBackground(Color.yellow);

        c.gridy=0;
        c.gridx=0;
        c.gridwidth=1;
        c.gridheight=1;
        c.weightx=1.0;
        c.weighty=1.0;
        c.insets= new Insets(0, 20, 0, 0);

        southPane.add(numberText1, c);

        c.gridy=1;
        c.gridx=0;
        c.gridwidth=1;
        c.gridheight=1;
        southPane.add(numberText2, c);

        c.gridy=2;
        c.gridx=0;
        c.gridwidth=1;
        c.gridheight=1;
        southPane.add(resultText, c);

        c.gridy=0;
        c.gridx=1;
        c.gridwidth=1;
        c.gridheight=1;
        c.insets= new Insets(0, 0, 0, 10);
        southPane.add(textField1, c);

        c.gridy=1;
        c.gridx=1;
        c.gridwidth=1;
        c.gridheight=1;
        southPane.add(textField2, c);

        c.gridy=2;
        c.gridx=1;
        c.gridwidth=1;
        c.gridheight=1;
        southPane.add(textField3, c);

        c.gridy=0;
        c.gridx=2;
        c.gridwidth=3;
        c.gridheight=1;
        c.insets= new Insets(0, 0, 0, 0);
        c.fill = GridBagConstraints.BOTH;
        southPane.add(sumButton, c);

        //AÑADIENDO LA FUNCIONALIDAD 'SUMA' AL BOTÓN DE SUMA, TOMANDO COMO VALORES LOS CAMPOS TEXTFIELD 1 Y 2
        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textField3.setText(String.valueOf(Integer.parseInt(textField1.getText())+Integer.parseInt(textField2.getText())));
            }
        });

        this.add(southPane, BorderLayout.SOUTH);

        this.setTitle("Tabla de Multiplicar");
        this.setSize(350, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {

        CalculadoraInterface frame = new CalculadoraInterface();

    }

    //FUNCIONALIDAD DE LA BARRA DE OPCIONES
    @Override
    public void itemStateChanged(ItemEvent e) {
        for (JButton jButton : buttons3) {
            for(int i = 0; i<buttons3.length; i++){

                buttons3[i].setText(Integer.toString(barOptions.getItemAt(barOptions.getSelectedIndex())*i));
            }
        }
    }

}
