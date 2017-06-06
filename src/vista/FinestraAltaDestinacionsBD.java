package vista;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import model.Destinacions;
import model.DestinacionsDAO;

public class FinestraAltaDestinacionsBD extends JInternalFrame implements ActionListener {
	FinestraPpal p=null;
	DestinacionsDAO d=new DestinacionsDAO();
	JButton sortir;
	JButton enviar;
	JLabel camps;
	JLabel dadesIntroduides;
	JLabel id;
	JTextField idDesti;
	JLabel continent;
	JTextField nomContinent;
	JLabel pais;
	JTextField nomPais;
	JLabel capital;
	JTextField nomCapital;
	JLabel ciutat;
	JTextField nomCiutat;
	JLabel poblacio;
	JTextField nomPoblacio;
	JLabel cp;
	JTextField cpDesti;
	JLabel platja;
	JCheckBox checkPlatja;
	String tePlatja;
	JPanel botons;
	GridBagLayout gbl;
	
	public FinestraAltaDestinacionsBD(FinestraPpal f){
		this.p=f;
		inicialitzacions();
		crearComponents();
		afegirComponents();
		posicionarComponents();
	}

	private void posicionarComponents() {
		gbl=new GridBagLayout();
		GridBagConstraints restriccionsDestinacio=new GridBagConstraints();
		
		//columna 0 fila 0
		restriccionsDestinacio.gridx = 0; // columna
		restriccionsDestinacio.gridy = 0; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		restriccionsDestinacio.insets=new Insets(20,20,20,20);
		gbl.setConstraints(camps, restriccionsDestinacio);
		
		//columna 1 fila 0
		restriccionsDestinacio.gridx = 1; // columna
		restriccionsDestinacio.gridy = 0; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(dadesIntroduides,restriccionsDestinacio);
		
		//columna 0 fila 2
		restriccionsDestinacio.gridx = 0; // columna
		restriccionsDestinacio.gridy = 2; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(id, restriccionsDestinacio);
		
		//columna 1 fila 2
		restriccionsDestinacio.gridx = 1; // columna
		restriccionsDestinacio.gridy = 2; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(idDesti, restriccionsDestinacio);
		
		//columna 0 fila 3
		restriccionsDestinacio.gridx = 0; // columna
		restriccionsDestinacio.gridy = 3; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(continent, restriccionsDestinacio);
		
		//columna 1 fila 3
		restriccionsDestinacio.gridx = 1; // columna
		restriccionsDestinacio.gridy = 3; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(nomContinent, restriccionsDestinacio);
		
		//columna 0 fila 4
		restriccionsDestinacio.gridx = 0; // columna
		restriccionsDestinacio.gridy = 4; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(pais, restriccionsDestinacio);
		
		//columna 1 fila 4
		restriccionsDestinacio.gridx = 1; // columna
		restriccionsDestinacio.gridy = 4; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(nomPais, restriccionsDestinacio);
		
		//columna 0 fila 5
		restriccionsDestinacio.gridx = 0; // columna
		restriccionsDestinacio.gridy = 5; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(capital, restriccionsDestinacio);
		
		//columna 1 fila 5
		restriccionsDestinacio.gridx = 1; // columna
		restriccionsDestinacio.gridy = 5; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(nomCapital, restriccionsDestinacio);
		
		//columna 0 fila 6
		restriccionsDestinacio.gridx = 0; // columna
		restriccionsDestinacio.gridy = 6; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(ciutat, restriccionsDestinacio);
		
		//columna 1 fila 6
		restriccionsDestinacio.gridx = 1; // columna
		restriccionsDestinacio.gridy = 6; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(nomCiutat, restriccionsDestinacio);
		
		//columna 0 fila 7
		restriccionsDestinacio.gridx = 0; // columna
		restriccionsDestinacio.gridy = 7; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(poblacio, restriccionsDestinacio);
		
		//columna 1 fila 7
		restriccionsDestinacio.gridx = 1; // columna
		restriccionsDestinacio.gridy = 7; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(nomPoblacio, restriccionsDestinacio);
		
		//columna 0 fila 8
		restriccionsDestinacio.gridx = 0; // columna
		restriccionsDestinacio.gridy = 8; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(cp, restriccionsDestinacio);
		
		//columna 1 fila 8
		restriccionsDestinacio.gridx = 1; // columna
		restriccionsDestinacio.gridy = 8; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(cpDesti, restriccionsDestinacio);
		
		//columna 0 fila 9
		restriccionsDestinacio.gridx = 0; // columna
		restriccionsDestinacio.gridy = 9; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(platja, restriccionsDestinacio);
		
		//columna 1 fila 9
		restriccionsDestinacio.gridx = 1; // columna
		restriccionsDestinacio.gridy = 9; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(checkPlatja, restriccionsDestinacio);
		
		//columna 0 fila 10
		restriccionsDestinacio.gridx = 0; // columna
		restriccionsDestinacio.gridy = 10; // fila
		restriccionsDestinacio.gridwidth = 2; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.fill=GridBagConstraints.NONE;
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(botons, restriccionsDestinacio);
		this.setLayout(gbl);
	}

	private void afegirComponents() {
		this.add(camps);
		this.add(dadesIntroduides);
		this.add(id);
		this.add(idDesti);
		this.add(continent);
		this.add(nomContinent);
		this.add(pais);
		this.add(nomPais);
		this.add(capital);
		this.add(nomCapital);
		this.add(ciutat);
		this.add(nomCiutat);
		this.add(poblacio);
		this.add(nomPoblacio);
		this.add(cp);
		this.add(cpDesti);
		this.add(checkPlatja);
		this.add(platja);
		this.add(botons);
	}

	private void crearComponents() {
		sortir=new JButton("Sortir");
		sortir.setActionCommand("Sortir");
		sortir.addActionListener(this);
		camps=new JLabel("CAMPS");
		dadesIntroduides=new JLabel("DADES");
		//ID
		id=new JLabel("ID: ");
		idDesti=new JTextField(15);
		idDesti.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				if(!Character.isDigit(e.getKeyChar())){
					e.consume();
				}
			}
		});
		//Continent
		continent=new JLabel("Continent: ");
		nomContinent=new JTextField(15);
		nomContinent.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				if(!Character.isLetter(e.getKeyChar())){
					e.consume();
				}
			}
		});
		//Pais
		pais=new JLabel("Pais: ");
		nomPais=new JTextField(15);
		nomPais.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				if(!Character.isLetter(e.getKeyChar())){
					e.consume();
				}
			}
		});
		//Capital
		capital=new JLabel("Capital: ");
		nomCapital=new JTextField(15);
		nomCapital.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				if(!Character.isLetter(e.getKeyChar())){
					e.consume();
				}
			}
		});
		//Ciutat
		ciutat=new JLabel("Ciutat: ");
		nomCiutat=new JTextField(15);
		nomCiutat.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				if(!Character.isLetter(e.getKeyChar())){
					e.consume();
				}
			}
		});
		//Poblacio
		poblacio=new JLabel("Poblacio: ");
		nomPoblacio=new JTextField(15);
		nomPoblacio.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				if(!Character.isLetter(e.getKeyChar())){
					e.consume();
				}
			}
		});
		//Codi Postal
		cp=new JLabel("Codi Postal: ");
		cpDesti=new JTextField(15);
		cpDesti.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				if(!Character.isDigit(e.getKeyChar())){
					e.consume();
				}
			}
		});
		platja=new JLabel("Te platja? ");
		checkPlatja=new JCheckBox();
		
		enviar=new JButton("Alta");
		enviar.addActionListener(this);
		enviar.setActionCommand("Alta");
		botons=new JPanel();
		botons.add(enviar);
		botons.add(sortir);
	}

	private void inicialitzacions() {
		this.setTitle("Finestra Alta");
		this.setBounds(400,1,500,700);
		this.setVisible(false);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		p.centrarFinestra(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if((obj instanceof JButton)){
			if((e.getActionCommand().equals("Sortir"))){
				p.a.dispose();
				p.comprobarFinestra(this);
				p.comprobarDestinacions();
				p.comprobarPunts();
				p.b.comprobarDestis();
			}
			if(e.getActionCommand().equals("Alta")){
				if(checkPlatja.isSelected()){
					tePlatja="Te platja";
				}else{
					tePlatja="No te platja";
				}
				if(!idDesti.getText().equals("") && !nomContinent.getText().equals("") && !nomPais.getText().equals("") && !nomCapital.getText().equals("") && !nomCiutat.getText().equals("") && !nomPoblacio.getText().equals("") && !cpDesti.getText().equals("")){
					d.altaDestinacio(new Destinacions(idDesti.getText(),nomContinent.getText(),nomPais.getText(),nomCapital.getText(),nomCiutat.getText(),nomPoblacio.getText(),cpDesti.getText(),tePlatja));
					p.actualitzarTaules();
					p.actualitzarPunts();
					llimpiarText();
					JOptionPane.showMessageDialog(this,"Alta realitzada","Alta Destinació",JOptionPane.INFORMATION_MESSAGE);
				}else{
					if(idDesti.getText().equals("")) 
						JOptionPane.showMessageDialog(this,"ID no introduïda","Error ID",JOptionPane.WARNING_MESSAGE);
					
					if(nomContinent.getText().equals("")) 
						JOptionPane.showMessageDialog(this,"Continent no introduït","Error Continent",JOptionPane.WARNING_MESSAGE);
					
					if(nomPais.getText().equals("")) 
						JOptionPane.showMessageDialog(this,"Pais no introduït","Error Pais",JOptionPane.WARNING_MESSAGE);
					
					if(nomCapital.getText().equals("")) 
						JOptionPane.showMessageDialog(this,"Capital no introduïda","Error Capital",JOptionPane.WARNING_MESSAGE);
					
					if(nomCiutat.getText().equals("")) 
						JOptionPane.showMessageDialog(this,"Ciutat no introduïda","Error Ciutat",JOptionPane.WARNING_MESSAGE);
				
					if(nomPoblacio.getText().equals("")) 
						JOptionPane.showMessageDialog(this,"Població no introduïda","Error Població",JOptionPane.WARNING_MESSAGE);
				
					if(cpDesti.getText().equals("")) 
						JOptionPane.showMessageDialog(this,"CP no introduït","Error CP",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		}
	}

	private void llimpiarText() {
		nomPoblacio.setText("");
		idDesti.setText("");
		nomContinent.setText("");
		nomPais.setText("");
		nomCapital.setText("");
		nomCiutat.setText("");
		nomPoblacio.setText("");
		cpDesti.setText("");
		checkPlatja.setSelected(false);
		
	}
}
