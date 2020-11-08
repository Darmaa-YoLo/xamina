
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MediaPlayer {
	static JFrame frame;
	static JButton button;
	static JTextArea area;
	static JTextField text;
	static JComboBox<String> angiud;
	static String[] links;
	public static void main(String[] args) {
		String path = new File("").getAbsolutePath();
		path = path.concat("\\source\\logo.png");
		frame=new JFrame("Анимэ Үзүүлэгч by Redemption");
		frame.setSize(500, 150);
		ImageIcon img = new ImageIcon(path);
		text=new JTextField("Энд anime url бичнэ");
		area=new JTextArea();
		button=new JButton();
		button.setText("Линк салгах");
		
		angiud=new JComboBox<String>();
		
		frame.add(button);
		frame.add(text);
		frame.add(angiud);
		frame.add(area);
		frame.setIconImage(img.getImage());
		frame.setLocationRelativeTo(null);;
		frame.setLayout(new GridLayout(4,1));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		text.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				text.setText("");
			}
			
		});
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					String id=Animax_Downloader.id(text.getText());
					String res=Animax_Downloader.getRes(id);
					links=Animax_Downloader.getLinks(res);
					
					for(int i=0;i<links.length;i++)
					{
						angiud.addItem(links[i]);
						area.append(links[i]+"\n");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		angiud.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
			          Object item = e.getItem();
			          try {
						Desktop.getDesktop().browse(new URL(item.toString()).toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			       }
				
			}
		});
		
	}

	
}