package com.sist.commons;
import java.awt.*;
import javax.swing.ImageIcon;
public class imageChange {
	public static Image getImage(ImageIcon icon,int w, int h) {
		return icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
	}
}
