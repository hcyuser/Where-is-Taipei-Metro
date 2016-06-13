import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import org.json.JSONException;

class MRTPanel extends JFrame {
	JFrame f;
	private JMenu jmenuFile, jmenuHelp;
	private JMenuItem jmenuitemExit, jmenuitemAbout;
	private JLabel NumberOfMRT;
	private JLabel Weather;
	DealJS dealjs;
	String[] tempbanlan = {"南港展覽館站","南港站","昆陽站","後山埤站","永春站","市政府站","國父紀念館站","忠孝敦化站","忠孝復興站","忠孝新生站","善導寺站","台北車站站","西門站","龍山寺站","江子翠站","新埔站","板橋站","府中站","亞東醫院站","海山站","土城站","永寧站","頂埔站"};
	String[] tempwenhu = {"南港展覽館站","南港軟體園區站","東湖站","葫洲站","大湖公園站","內湖站","文德站","港墘站","西湖站","劍南路站","大直站","松山機場站","中山國中站","南京復興站","忠孝復興站","大安站","科技大樓站","六張犁站","麟光站","辛亥站","萬芳醫院站","萬芳社區站","木柵站","動物園站"};
	public MRTPanel() {
		try {
			dealjs = new DealJS();
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NumberOfMRT = new JLabel("目前捷運系統上共有"+dealjs.getNumberOfMRT()+"在運行。");
		dealjs.setWeather();
		Weather = new JLabel("現在位置:"+dealjs.getWeatherlocation()+"天氣狀況"+dealjs.getWeatherdescription());
		jmenuFile = new JMenu("File");
		jmenuitemExit = new JMenuItem("Exit");
		jmenuFile.add(jmenuitemExit);

		jmenuitemExit.addActionListener(new MenuAction());

		jmenuHelp = new JMenu("Help");
		jmenuitemAbout = new JMenuItem("About");
		jmenuHelp.add(jmenuitemAbout);

		jmenuitemAbout.addActionListener(new MenuAction());

		JMenuBar M = new JMenuBar();
		M.add(jmenuFile);
		M.add(jmenuHelp);
		setJMenuBar(M);

		// Create panel cp for the buttons 
		JPanel cp = new JPanel(new BorderLayout());
		cp.setLayout(null);
		JPanel p2 = new JPanel(new BorderLayout());
		p2.add(cp,BorderLayout.CENTER);
		p2.add(Weather,BorderLayout.SOUTH);
		p2.add(NumberOfMRT,BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		p2.setBackground(Color.PINK);

		ImageIcon WHL = new ImageIcon("WHL.png");
		JButton b1 = new JButton(WHL);
		b1.setBounds(20,20,120,50);
		cp.add(b1);	
		ImageIcon TXL = new ImageIcon("TXL.png");
		JButton b2 = new JButton(TXL);
		cp.add(b2);
		b2.setBounds(20,100,120,50);
		ImageIcon SXL = new ImageIcon("SXL.png");
		JButton b3 = new JButton(SXL);
		cp.add(b3);
		b3.setBounds(20,270,120,50);
		ImageIcon ZXL = new ImageIcon("ZXL.png");
		JButton b4 = new JButton(ZXL);
		cp.add(b4);
		b4.setBounds(450,20,120,50);
		ImageIcon BL = new ImageIcon("BL.png");
		JButton b5 = new JButton(BL);
		cp.add(b5);
		b5.setBounds(450,200,120,50);

		//buttons and their action
		ImageIcon WHL1 = new ImageIcon("ZooTONangang.png");
		JButton b6 = new JButton(WHL1);
		b6.setBounds(150,20,130,50);
		cp.add(b6);	
		b6.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("南港展覽館站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int i=0;i<tempbanlan.length;i++){
						for(int ii=0;ii<dealjs.corrdestination.size();){
							if(dealjs.corrdestination.get(ii).equals(tempbanlan[i])){
								dealjs.corrdestination.remove(ii);
							}else
								ii++;
						}

					}
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}

		});
		ImageIcon WHL2 = new ImageIcon("NangangTOZoo.png");
		JButton b7 = new JButton(WHL2);
		b7.setBounds(290,20,130,50);
		cp.add(b7);	
		b7.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("動物園站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});

		ImageIcon TXL1 = new ImageIcon("TamsuiTOXiangshan.png");
		JButton b8 = new JButton(TXL1);
		b8.setBounds(150,100,130,50);
		cp.add(b8);	
		b8.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("象山站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon TXL2 = new ImageIcon("XiangshanTOTamsui.png");
		JButton b9 = new JButton(TXL2);
		b9.setBounds(290,100,130,50);
		cp.add(b9);	
		b9.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("淡水站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon TXL3 = new ImageIcon("BeitouTODaan.png");
		JButton b10 = new JButton(TXL3);
		b10.setBounds(150,150,130,50);
		cp.add(b10);	
		b10.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("大安站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon TXL4 = new ImageIcon("DaanTOBeitou.png");
		JButton b11 = new JButton(TXL4);
		b11.setBounds(290,150,130,50);
		cp.add(b11);	
		b11.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("北投站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon TXL5 = new ImageIcon("BeitouTONewBeitou.png");
		JButton b12 = new JButton(TXL5);
		b12.setBounds(150,200,130,50);
		cp.add(b12);	
		b12.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("新北投站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon TXL6 = new ImageIcon("NewBeitouTOBeitou.png");
		JButton b13 = new JButton(TXL6);
		b13.setBounds(290,200,130,50);
		cp.add(b13);	
		b13.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("北投站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});

		ImageIcon SXL1 = new ImageIcon("SongshanTOXindian.png");
		JButton b14 = new JButton(SXL1);
		b14.setBounds(150,270,130,50);
		cp.add(b14);	
		b14.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("新店站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon SXL2 = new ImageIcon("XindianTOSongshan.png");
		JButton b15 = new JButton(SXL2);
		b15.setBounds(290,270,130,50);
		cp.add(b15);	
		b15.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("松山站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon SXL3 = new ImageIcon("SongshanTOTB.png");
		JButton b16 = new JButton(SXL3);
		b16.setBounds(150,320,130,50);
		cp.add(b16);	
		b16.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("臺電大樓站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon SXL4 = new ImageIcon("TBTOSongshan.png");
		JButton b17 = new JButton(SXL4);
		b17.setBounds(290,320,130,50);
		cp.add(b17);	
		b17.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("松山站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon SXL5 = new ImageIcon("QizhangTOXiaobitan.png");
		JButton b18 = new JButton(SXL5);
		b18.setBounds(150,370,130,50);
		cp.add(b18);	
		b18.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("小碧潭站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon SXL6 = new ImageIcon("XiaobitanTOQizhang.png");
		JButton b19 = new JButton(SXL6);
		b19.setBounds(290,370,130,50);
		cp.add(b19);	
		b19.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("七張站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});

		ImageIcon ZXL1 = new ImageIcon("HuilongTONanshijiao.png");
		JButton b20 = new JButton(ZXL1);
		b20.setBounds(580,20,130,50);
		cp.add(b20);	
		b20.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("南勢角站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon ZXL2 = new ImageIcon("NanshijiaoTOHuilong.png");
		JButton b21 = new JButton(ZXL2);
		b21.setBounds(720,20,130,50);
		cp.add(b21);	
		b21.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("迴龍站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon ZXL3 = new ImageIcon("LuzhouTONanshijiao.png");
		JButton b22 = new JButton(ZXL3);
		b22.setBounds(580,70,130,50);
		cp.add(b22);	
		b22.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("南勢角站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon ZXL4 = new ImageIcon("NanshijiaoTOLuzhou.png");
		JButton b23 = new JButton(ZXL4);
		b23.setBounds(720,70,130,50);
		cp.add(b23);	
		b23.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("蘆洲站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon BL1 = new ImageIcon("NangangTODingpu.png");
		JButton b24 = new JButton(BL1);
		b24.setBounds(580,200,130,50);
		cp.add(b24);	
		b24.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("頂埔站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon BL2 = new ImageIcon("DingpuTONangang.png");
		JButton b25 = new JButton(BL2);
		b25.setBounds(720,200,130,50);
		cp.add(b25);	
		b25.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("南港展覽館站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int i=0;i<tempwenhu.length;i++){
						for(int ii=0;ii<dealjs.corrdestination.size();){
							if(dealjs.corrdestination.get(ii).equals(tempwenhu[i])){
								dealjs.corrdestination.remove(ii);
							}else
								ii++;
						}

					}
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}

		});
		ImageIcon BL3 = new ImageIcon("NangangTOFEH.png");
		JButton b26 = new JButton(BL3);
		b26.setBounds(580,260,130,50);
		cp.add(b26);	
		b26.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("亞東醫院站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}});
		ImageIcon BL4 = new ImageIcon("FEHTONangang.png");
		JButton b27 = new JButton(BL4);
		b27.setBounds(720,260,130,50);
		cp.add(b27);	
		b27.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dealjs.setCorrDestination("南港展覽館站");
				String nowdestination="";
				if(dealjs.corrdestination.size()==1){
					nowdestination =dealjs.corrdestination.get(0);
				}
				else{
					for(int i=0;i<tempwenhu.length;i++){
						for(int ii=0;ii<dealjs.corrdestination.size();){
							if(dealjs.corrdestination.get(ii).equals(tempwenhu[i])){
								dealjs.corrdestination.remove(ii);
							}else
								ii++;
						}

					}
					for(int ii=0;ii<dealjs.corrdestination.size();ii++){
						nowdestination =  nowdestination+"\n"+dealjs.corrdestination.get(ii)+" ";}
				}
				JOptionPane.showMessageDialog(f,"目前共有"+dealjs.corrdestination.size()+"輛車可以搭\n車子在"+nowdestination,"訊息",JOptionPane.INFORMATION_MESSAGE);
			}

		});
	}
	//the action of menu
	class MenuAction implements ActionListener {
		JFrame a;
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == jmenuitemExit){
				{System.exit(0);}
			}
			if(e.getSource() == jmenuitemAbout){
				JDialog dlgAbout = new AboutDialog(a, "About Developer");
				dlgAbout.setVisible(true);
			}
		}
	}
		//creat first panel
		public static void main(String[] args) {
			First first = new First();
			first.setTitle("歡迎使用");
			first.setBounds(0,0,300,300);
			first.setLocationRelativeTo(null);
			first.setVisible(true);
			first.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		}

}