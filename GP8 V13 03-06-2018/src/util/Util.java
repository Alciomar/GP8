/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Adriano
 */
public class Util {

    public static void limparCampos(JFrame Frame) {
        //limpa os campos     
        for (int i = 0; i < Frame.getContentPane().getComponentCount(); i++) {
            //varre todos os componentes     
            Component c = Frame.getContentPane().getComponent(i);
            if (c instanceof JComboBox) {
                JComboBox field = (JComboBox) c;
                field.setSelectedItem("-----");
            } else if (c instanceof JTextField) {
                JTextField field = (JTextField) c;
                field.setText("");
            } else if (c instanceof JRadioButton) {
                JRadioButton field = (JRadioButton) c;
                field.setSelected(false);
            } else if (c instanceof JCheckBox) {
                JCheckBox field = (JCheckBox) c;
                field.setSelected(false);
            } else if (c instanceof JTextArea) {
                JTextArea field = (JTextArea) c;
                field.setText("");
            }

        }

    }
    
    public static void limparCamposJDialog(JDialog Frame) {
        //limpa os campos     
        for (int i = 0; i < Frame.getContentPane().getComponentCount(); i++) {
            //varre todos os componentes     
            Component c = Frame.getContentPane().getComponent(i);
            if (c instanceof JComboBox) {
                JComboBox field = (JComboBox) c;
                field.setSelectedItem("-----");
            } else if (c instanceof JTextField) {
                JTextField field = (JTextField) c;
                field.setText("");
            } else if (c instanceof JRadioButton) {
                JRadioButton field = (JRadioButton) c;
                field.setSelected(false);
            } else if (c instanceof JCheckBox) {
                JCheckBox field = (JCheckBox) c;
                field.setSelected(false);
            } else if (c instanceof JTextArea) {
                JTextArea field = (JTextArea) c;
                field.setText("");
            }

        }

    }

}
