/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author ELITEBOOK
 */
public class ThreadsCells extends DefaultListCellRenderer{
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
         
        if (value instanceof Thread) {
            Thread x = (Thread) value;
            setText(x.getName());
           //Estados estado = (Estados) value;
            //setText(estado.getEstado());
        }
        return this;
    }

}
