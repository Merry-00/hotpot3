package com.gcl.demo.utils;

import javax.swing.*;

public class Dialoginfo {
    public String dialog(String input){
        String inputValue = JOptionPane.showInputDialog(input);
        return inputValue;
    }
    public  void dialogReform(String message){
        Object[] options = { "OK", "取消" };
        JOptionPane.showOptionDialog(null, message, "提示",  JOptionPane.NO_OPTION,
                JOptionPane.OK_OPTION,  null, options, options[0]);

    }
}
