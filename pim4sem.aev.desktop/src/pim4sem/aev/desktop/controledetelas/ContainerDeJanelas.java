package pim4sem.aev.desktop.controledetelas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ContainerDeJanelas extends JFrame{
	
	//==== Construtor ====
	public ContainerDeJanelas(){
		
		//Barra
		JMenuBar barraFerramentas = new JMenuBar();
		
		//Op��es
		JMenu sair = new JMenu("Encerrar Sess�o");
		JMenu sobre = new JMenu("Sobre");
		
		JLabel user = new JLabel("Bem-vindo, user");
		
		//Itens de cada op��o
		
		JMenuItem logoff = new JMenuItem("Log off");
		//JMenuItem fechar = new JMenuItem("Sair");
		Action actionQuit = new AbstractAction("Sair"){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent evt){
				//System.exit(0);
				MenuTela s = new MenuTela();
				getContentPane().add(s);
				s.show();
				
			}
		};
				
		//JMenuItem about = new JMenuItem("Sobre a aplica��o");
		Action actionAbout = new AbstractAction("Sobre a Aplica��o"){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent evt){
				SobreTela about = new SobreTela();
				about.show();
			}
		};
		
		
		//Atribuindo itens �s op��es
		
		sair.add(logoff);
		sair.add(new JMenuItem(actionQuit));
		
		sobre.add(actionAbout);
		
		//Atribuindo op��es � barra
		barraFerramentas.add(sair);
		barraFerramentas.add(sobre);
		
		barraFerramentas.add(Box.createGlue());
		barraFerramentas.add(user);
		
		
		//Atribuindo a barra � aplica��o
		setJMenuBar(barraFerramentas);
		
		
		//Mudar aparencia
		this.getContentPane().setBackground(new Color(247, 247, 249));
		barraFerramentas.setPreferredSize(new Dimension(this.getWidth(), 50));
		barraFerramentas.setBackground(new Color(239, 61, 49));
		user.setFont(new Font("Impact",Font.PLAIN, 25));
		sair.setFont(new Font("Impact",Font.PLAIN, 25));
		sobre.setFont(new Font("Impact",Font.PLAIN, 25));
		
		setUndecorated(true);
		setTitle("Loja de Cal�ados");
		setSize(this.getToolkit().getScreenSize());
		setLocationRelativeTo(null);
		setVisible(true);		
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		getContentPane().setLayout(new GridLayout());
	}

	
	public static void main(String[] args) {
		new ContainerDeJanelas();
	}

	
}
