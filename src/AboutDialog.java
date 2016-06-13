import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class AboutDialog extends JDialog implements ActionListener {
	JButton jbnOk;

	AboutDialog(JFrame a, String title){
		super( a , title);
		
		JPanel p1 = new JPanel();
		//creat stringbuffer
		StringBuffer text = new StringBuffer();
		text.append("MRT Information\n\n");
		text.append("Developer:U10416011ÁÂªÃ½@\n           and U10416001¶À§Ó·¨\n");
		text.append("Version:	1.0");
		//add text on textarea
		JTextArea jtAreaAbout = new JTextArea(5, 21);
		jtAreaAbout.setText(text.toString());

		jtAreaAbout.setEditable(false);

		p1.add(jtAreaAbout);
		getContentPane().add(p1, BorderLayout.CENTER);

		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jbnOk = new JButton(" OK ");
		jbnOk.addActionListener(this);

		p2.add(jbnOk);
		getContentPane().add(p2, BorderLayout.SOUTH);

		setLocation(408, 300);
		setResizable(false);

		addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					Window aboutDialog = e.getWindow();
					aboutDialog.dispose();
				}
		});

		pack();
	}
	//close the window
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbnOk)	{
			this.dispose();
		}
	}
	
}