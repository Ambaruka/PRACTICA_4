package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FRMDeportes extends JFrame{
    private JPanel pato;
    private JTextField JTAncho;
    private JTextField JTContacto;
    private JTextField JTJugadores;
    private JTextField JTNombre;
    private JTextField JTAlto;
    private JButton JBregistrar;
    private JButton JBlimpiar;
    private JButton JBbuscar;
    private JButton JBeliminar;
    private JLabel JLNombre;
    private JLabel JLDeportes;
    private JLabel JLJugadores;
    private JLabel JLContacto;
    private JLabel JLCancha;
    private JLabel JLAncho;
    private JLabel JLLargo;
    private JLabel JLMensajes;
    Deportes[] deportes= new Deportes[20];
    int array=0;
    public FRMDeportes() {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pato);
        setSize(700,500);

        JTNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                validaLetras(e);
                enter(e,JTNombre,JTJugadores);
            }
        });


        JTJugadores.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                validaNumeros(e);
                enter(e,JTJugadores,JTContacto);
            }
        });
        JTContacto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                validaLetras(e);
                enter(e,JTContacto,JTAncho);
            }
        });
        JTAncho.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                validaDecimales(e,JTAncho);
                enter(e,JTAncho,JTAlto);
            }
        });
        JTAlto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                validaDecimales(e,JTAlto);
                enter(e,JTAlto,JBregistrar);
            }
        });
        JBregistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean contact=false;
                String b=JTContacto.getText();
                if (b.equalsIgnoreCase("si")){
                     contact=true;
                }

                deportes[array]= new Deportes(JTNombre.getText(), Integer.parseInt(JTJugadores.getText()),Float.parseFloat(JTAncho.getText()),Float.parseFloat(JTAlto.getText()),contact);
                System.out.println("pichuela");
                array++;
            }
        });
        JBlimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTAlto.setText("");
                JTAncho.setText("");
                JTContacto.setText("");
                JTJugadores.setText("");
                JTNombre.setText("");
            }
        });
        JBbuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int posision=buscar(deportes);
               eliminatorio(posision,deportes);
            }
        });
        JBeliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int posision=buscar(deportes);
                eliminar(posision,deportes);
            }
        });
    }

    private void validaLetras(KeyEvent e){
        if (!(Character.isAlphabetic(e.getKeyChar()))){
            e.consume();
        }
    }

    private void validaNumeros(KeyEvent e){
        if (!(Character.isDigit(e.getKeyChar()))){
            e.consume();
        }
    }

    private void validaDecimales(KeyEvent e,JTextField pepe){
        if (!Character.isDigit(e.getKeyChar())&&e.getKeyChar()!='.'){
            e.consume();
        }
        if (e.getKeyChar() == '.' && pepe.getText().contains(".")) {
            e.consume();
        }
    }

    private int buscar(Deportes[] deportes) {
        int posision=0;
        for (int i = 0; i< deportes.length; i++){
            if ((deportes[i].getNombre()).equals(JTNombre.getText())){
                posision=i;
            }else {JLMensajes.setText("Registro inexistente");}
        }
        return posision;
    }

    private void eliminatorio(int i,Deportes[] deportes){
        JTNombre.setText(deportes[i].nombre);
        JTJugadores.setText(String.valueOf(deportes[i].jugadores));
        JTContacto.setText(booleanos(deportes,i));
        JTAncho.setText(String.valueOf(deportes[i].anchoCancha));
        JTAlto.setText(String.valueOf(deportes[i].largoCancha));
    }

    private String booleanos(Deportes[] deportes,int i){
        String traduccion;
        if (deportes[i].contacto==true){
            traduccion= "Si";
        }else {traduccion="no";}
        return traduccion;
    }

    private void eliminar(int e,Deportes[] deportes){
        for (int i=e;i<deportes.length;i++){
            deportes[e]=deportes[e+1];
        }
        deportes[deportes.length]=null;
    }

    private void enter(KeyEvent e,JTextField javier,JComponent oskar){
        char letra = e.getKeyChar();
        if (letra == KeyEvent.VK_ENTER) {
            javier.setBackground(Color.GRAY);//cambiar de color el fondo del input
            oskar.requestFocus();//pasar el focus al siguiente input
        }
    }
}
