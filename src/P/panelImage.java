package P;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel (Image img) {
		this.img = img;
		setSize (new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}
	
	public void paintComponent (Graphics g) {
		g.drawImage(img,  0, 0, null);
	}
}


public class panelImage {
	public static void main (String[] args) {
		JFrame frame = new JFrame("add image to pandel");
		frame.setSize(640,480);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		ImagePanel panel = new ImagePanel (new ImageIcon("./image/happy.png").getImage());
		File f = new File("./image/happy.png");
		// 콘솔에서 exists가 출력되면 경로가 맞음
//		System.out.print(f.exists()?"Exists":"doesnt exists");
		
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

}
