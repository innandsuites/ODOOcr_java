/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bitsexcel.pos.JavaPosProject;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Dann
 */
public class Inicio {

    public static void main(String[] args) {
        NewMDIApplication mdi = new NewMDIApplication();
        mdi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        final GraphicsConfiguration config = mdi.getGraphicsConfiguration();
//
//        final int left = Toolkit.getDefaultToolkit().getScreenInsets(config).left;
//        final int right = Toolkit.getDefaultToolkit().getScreenInsets(config).right;
//        final int top = Toolkit.getDefaultToolkit().getScreenInsets(config).top;
//        final int bottom = Toolkit.getDefaultToolkit().getScreenInsets(config).bottom;
//
//        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        final int width = screenSize.width - left - right;
//        final int height = screenSize.height - top - bottom;
//        mdi.setSize(width, height);
        // mdi.setExtendedState(mdi.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        mdi.setVisible(true);

    }

}
