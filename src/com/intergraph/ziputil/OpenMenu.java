package com.intergraph.ziputil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import javax.swing.*;

public class OpenMenu {
    /**
     * @param args
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        JButton jb = new JButton("选择");
        jb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jf = new JFileChooser();
                jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);
                jf.showDialog(null,null);
                File fi = jf.getSelectedFile();
                String f = fi.getAbsolutePath()+"\\test.txt";
                System.out.println("save: "+f);
                try{
                    FileWriter out = new FileWriter(f);
                    out.write("successful!!!");
                    out.close();
                }
                catch(Exception ee){}

            }
        });
        jf.add(jb);
        jf.setSize(500, 100);
        jf.setLocation(600, 200);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
