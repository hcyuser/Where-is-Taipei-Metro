import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

class First extends JFrame implements ActionListener {
	JButton Ok;
	First(){
		InternetReachable ie = new InternetReachable(); // whether connect the Internet
		JPanel p1 = new JPanel();
		StringBuffer text = new StringBuffer();
		text.append("                              �w��ϥ�\n\n");
		if(ie.isInternetReachable()){
		text.append("                              �����s�u\n\n");}
		else{
			text.append("                              �������~�A�Ь�����\n\n");
		}
		text.append("                            U10416011�ªý@\n                            U10416001���ӷ�");
		JTextArea jtAreaAbout = new JTextArea(5, 21);
		//add cs.jpg
		ImageIcon SL = new ImageIcon("cs.jpg");
		JButton sl = new JButton(SL);
		sl.setBounds(25,140,250,90);
		add(sl);
		jtAreaAbout.setText(text.toString());

		jtAreaAbout.setEditable(false);

		p1.add(jtAreaAbout);
		getContentPane().add(p1, BorderLayout.CENTER);

		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		Ok = new JButton(" OK ");
		Ok.addActionListener(this);

		p2.add(Ok);
		getContentPane().add(p2, BorderLayout.SOUTH);

		setLocation(408, 300);
		setResizable(false);

		pack();
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == Ok)	{
			this.dispose();
			MRTPanel frame = new MRTPanel();
			frame.setTitle("���B");
			frame.setBounds(0,0,1000,550);
			frame.setLocationRelativeTo(null); 
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			frame.setVisible(true);
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					//ask you whether close the window
					int result = JOptionPane.showConfirmDialog(frame,"�T�w�n�����{����?","�T�{�T��",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
						if (result == JOptionPane.YES_OPTION)
							{System.exit(0);}
				}    
			});
		}
	}
	
}
