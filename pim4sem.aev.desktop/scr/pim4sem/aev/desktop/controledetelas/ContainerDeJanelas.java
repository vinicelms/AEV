package pim4sem.aev.desktop.controledetelas;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.JButton;
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
		JMenu administrarConta = new JMenu("Administrar Conta");
		JMenu sair = new JMenu("Encerrar Sess�o");
		JMenu sobre = new JMenu("Sobre");
		
		JLabel user = new JLabel("Bem-vindo, user");
		
		//Itens de cada op��o
		JMenuItem trocarSenha = new JMenuItem("Alterar Senha");
		JMenuItem metas = new JMenuItem("Visualizar Metas");
		
		JMenuItem logoff = new JMenuItem("Log off");
		//JMenuItem fechar = new JMenuItem("Sair");
		Action actionQuit = new AbstractAction("Sair"){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		};
		
		
		JMenuItem about = new JMenuItem("Sobre a aplica��o");
		
		//Atribuindo itens �s op��es
		administrarConta.add(trocarSenha);
		administrarConta.add(metas);
		
		sair.add(logoff);
		sair.add(new JMenuItem(actionQuit));
		
		sobre.add(about);
		
		//Atribuindo op��es � barra
		barraFerramentas.add(administrarConta);
		barraFerramentas.add(sair);
		barraFerramentas.add(sobre);
		
		barraFerramentas.add(Box.createGlue());
		barraFerramentas.add(user);
		
		
		//Atribuindo a barra � aplica��o
		setJMenuBar(barraFerramentas);
		
		
		
		
		
		setUndecorated(true);
		setTitle("Loja de Cal�ados");
		setSize(this.getToolkit().getScreenSize());
		setLocationRelativeTo(null);
		setVisible(true);		
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
	}

	
	public static void main(String[] args) {
		new ContainerDeJanelas();
	}

	
}
