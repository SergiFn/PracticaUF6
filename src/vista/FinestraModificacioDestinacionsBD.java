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
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import model.Destinacions;
import model.DestinacionsDAO;

public class FinestraModificacioDestinacionsBD extends JInternalFrame implements ActionListener {
	FinestraPpal p=null;
	DestinacionsDAO d=new DestinacionsDAO();
	JButton enviar;
	JLabel camps;
	JLabel dadesIntroduides;
	JLabel lblId;
	JTextField idModi;
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
	GridBagLayout gbl;
	Object[] dades;
	String idVella;
	
	public FinestraModificacioDestinacionsBD(FinestraPpal f){
		this.p=f;
		inicialitzacions();
		crearComponents();
		afegirComponents();
		posicionarComponents();
	}

	public void dadesPoblacio(String p){
		dades=d.consultarRegistresID(d.consultarID(p));
		idModi.setText(dades[0].toString());
		idVella=dades[0].toString();
		nomContinent.setText(dades[1].toString());
		nomPais.setText(dades[2].toString());
		nomCapital.setText(dades[3].toString());
		nomCiutat.setText(dades[4].toString());
		nomPoblacio.setText(dades[5].toString());
		cpDesti.setText(dades[6].toString());
		if(dades[7].toString().equals("Te platja")){
			checkPlatja.setSelected(true);
		}
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
		gbl.setConstraints(lblId, restriccionsDestinacio);
		
		//columna 1 fila 2
		restriccionsDestinacio.gridx = 1; // columna
		restriccionsDestinacio.gridy = 2; // fila
		restriccionsDestinacio.gridwidth = 1; // amplada
		restriccionsDestinacio.gridheight = 1; // alçada
		restriccionsDestinacio.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(idModi, restriccionsDestinacio);
		
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
		gbl.setConstraints(enviar, restriccionsDestinacio);
		this.setLayout(gbl);
	}

	private void afegirComponents() {
		this.add(camps);
		this.add(dadesIntroduides);
		this.add(lblId);
		this.add(idModi);
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
		this.add(enviar);
	}

	private void crearComponents() {
		camps=new JLabel("CAMPS");
		dadesIntroduides=new JLabel("DADES");
		//ID
		lblId=new JLabel("ID: ");
		idModi=new JTextField(15);
		idModi.setEnabled(false);
		idModi.addKeyListener(new KeyAdapter(){
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
		nomPoblacio.setEnabled(false);
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
		
		enviar=new JButton("Modificar");
		enviar.addActionListener(this);
		enviar.setActionCommand("Modificar");
		((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
	}

	private void inicialitzacions() {
		this.setTitle("Finestra Modificar");
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
			if(e.getActionCommand().equals("Modificar")){
				if(checkPlatja.isSelected()){
					tePlatja="Te platja";
				}else{
					tePlatja="No te platja";
				}
				d.modificarDestinacio(new Destinacions(idModi.getText(),nomContinent.getText(),nomPais.getText(),nomCapital.getText(),nomCiutat.getText(),nomPoblacio.getText(),cpDesti.getText(),tePlatja),idVella);
				p.actualitzarTaules();
				p.pa.afegirDestinacions();
				JOptionPane.showMessageDialog(this,"Modificació realitzada","Modificar Destinació",JOptionPane.INFORMATION_MESSAGE);
				p.m.dispose();
				p.comprobarFinestra(this);
				p.comprobarDestinacions();
				p.comprobarPunts();
			}
		}
	}
}
