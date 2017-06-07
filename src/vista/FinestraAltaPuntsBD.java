package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import model.DestinacionsDAO;
import model.PuntsDAO;
import model.PuntsInteres;

public class FinestraAltaPuntsBD extends JInternalFrame implements ActionListener{
	FinestraPpal p=null;
	DestinacionsDAO d=new DestinacionsDAO();
	PuntsDAO pd=new PuntsDAO();
	JLabel camps;
	JLabel dades;
	JButton btnSortir;
	JButton btnAlta;
	JPanel botons;
	JLabel lblId;
	JComboBox puntsDestinacio;
	JLabel lblNom;
	JTextField nom;
	JLabel lblDesc;
	JTextField desc;
	JLabel lblTipus;
	JComboBox tipus;
	JLabel lblActi;
	JComboBox activitats;
	GridBagLayout gbl;
	Object[] poblacions;
	
	public FinestraAltaPuntsBD(FinestraPpal finestra){
		this.p=finestra;
		inicialitzacions();
		crearComponents();
		afegirComponents();
		posicionarComponents();
		afegirDestinacions();
	}
	public void afegirDestinacions(){
		puntsDestinacio.removeAllItems();
		poblacions=d.consultarPoblacions();
		for(int i=0;i<poblacions.length;i++){
			puntsDestinacio.addItem(poblacions[i].toString());
		}
	}
	private void posicionarComponents() {
		gbl=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		//columna 0 fila 0
		gbc.gridx = 0; // columna
		gbc.gridy = 0; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets=new Insets(10,10,10,10);
		gbl.setConstraints(camps, gbc);
		
		//columna 1 fila 0
		gbc.gridx = 1; // columna
		gbc.gridy = 0; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(dades, gbc);
		
		//columna 0 fila 1
		gbc.gridx = 0; // columna
		gbc.gridy = 2; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(lblId, gbc);
		
		//columna 1 fila 1
		gbc.gridx = 1; // columna
		gbc.gridy = 2; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(puntsDestinacio, gbc);
		
		//columna 0 fila 2
		gbc.gridx = 0; // columna
		gbc.gridy = 3; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(lblNom, gbc);
		
		//columna 1 fila 2
		gbc.gridx = 1; // columna
		gbc.gridy = 3; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(nom, gbc);
		
		//columna 0 fila 3
		gbc.gridx = 0; // columna
		gbc.gridy = 4; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(lblDesc, gbc);
		
		//columna 1 fila 3
		gbc.gridx = 1; // columna
		gbc.gridy = 4; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(desc, gbc);
		
		//columna 0 fila 4
		gbc.gridx = 0; // columna
		gbc.gridy = 5; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(lblTipus, gbc);
		
		//columna 1 fila 4
		gbc.gridx = 1; // columna
		gbc.gridy = 5; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(tipus, gbc);
		
		//columna 0 fila 5
		gbc.gridx = 0; // columna
		gbc.gridy = 6; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(lblActi, gbc);
		
		//columna 1 fila 5
		gbc.gridx = 1; // columna
		gbc.gridy = 6; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(activitats, gbc);
		
		//columna 0 fila 6
		gbc.gridx = 0; // columna
		gbc.gridy = 7; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(botons, gbc);
		
		this.setLayout(gbl);
	}
	private void afegirComponents() {
		this.add(camps);
		this.add(dades);
		this.add(botons);
		this.add(lblId);
		this.add(puntsDestinacio);
		this.add(lblNom);
		this.add(nom);
		this.add(lblDesc);
		this.add(desc);
		this.add(lblTipus);
		this.add(tipus);
		this.add(lblActi);
		this.add(activitats);
	}
	private void crearComponents() {
		camps=new JLabel("Camps");
		dades=new JLabel("Dades");
		btnSortir=new JButton("Sortir");
		btnSortir.addActionListener(this);
		btnSortir.setActionCommand("Sortir");
		btnAlta=new JButton("Alta");
		btnAlta.addActionListener(this);
		btnAlta.setActionCommand("Alta");
		botons=new JPanel();
		botons.add(btnAlta);
		botons.add(btnSortir);
		lblId=new JLabel("Poblacio: ");
		puntsDestinacio=new JComboBox();
		lblNom=new JLabel("Nom: ");
		nom = new JTextField(15);
		nom.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				if(!Character.isLetter(e.getKeyChar())){
					e.consume();
				}
			}
		});
		lblDesc=new JLabel("Descripcio: ");
		desc=new JTextField(15);
		lblTipus=new JLabel("Tipus: ");
		tipus=new JComboBox();
		tipus.addItem("Gastronomic");
		tipus.addItem("Cultural");
		tipus.addItem("Oci");
		tipus.addItem("Esport");
		tipus.addItem("Platja");
		tipus.addItem("Muntanya");
		tipus.addItem("Rural");
		lblActi=new JLabel("Activitats: ");
		activitats=new JComboBox();
		activitats.addItem("Esqui");
		activitats.addItem("Natacio");
		activitats.addItem("Escalada");
		activitats.addItem("Compres");
		activitats.addItem("Equitacio");
		activitats.addItem("Senderisme");
		
	}
	private void inicialitzacions() {
		this.setTitle("Finestra Alta Punts");
		this.setBounds(400,1,500,700);
		this.setVisible(false);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		p.centrarFinestra(this);
		
	}
	private void llimpiarText() {
		puntsDestinacio.setSelectedItem(puntsDestinacio.getItemAt(0));
		nom.setText("");
		desc.setText("");
		tipus.setSelectedItem(tipus.getItemAt(0));
		activitats.setSelectedItem(activitats.getItemAt(0));
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if((obj instanceof JButton)){
			if((e.getActionCommand().equals("Sortir"))){
				p.pa.dispose();
				p.comprobarFinestra(this);
				p.comprobarPunts();
				p.pb.comprobarPunts();
			}
			if((e.getActionCommand().equals("Alta"))){
				if(pd.comprobarPunts(nom.getText(),puntsDestinacio.getSelectedItem().toString())){
					JOptionPane.showMessageDialog(this,"Punt d'interes ja existeix","Alta Punts d'Interés",JOptionPane.ERROR_MESSAGE);
				}else{
					if(!nom.getText().equals("") && !desc.getText().equals("")){
						pd.afegirPunts(new PuntsInteres("id",nom.getText(),desc.getText(),tipus.getSelectedItem().toString(),activitats.getSelectedItem().toString()),puntsDestinacio.getSelectedItem().toString());
						p.actualitzarTaules();
						p.actualitzarPunts();
						llimpiarText();
						JOptionPane.showMessageDialog(this,"Alta realitzada","Alta Punts d'Interés",JOptionPane.INFORMATION_MESSAGE);
					}else{
						if(nom.getText().equals(""))
							JOptionPane.showMessageDialog(this,"Nom no introduït","Error Nom",JOptionPane.WARNING_MESSAGE);
						
						if(desc.getText().equals(""))
							JOptionPane.showMessageDialog(this,"Descripció no introduïda","Error Nom",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}
		
	}
}
