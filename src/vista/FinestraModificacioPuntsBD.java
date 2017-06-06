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
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import model.PuntsDAO;
import model.PuntsInteres;

public class FinestraModificacioPuntsBD extends JInternalFrame implements ActionListener {
	FinestraPpal p=null;
	PuntsDAO pd=new PuntsDAO();
	JLabel camps;
	JLabel lblDades;
	JButton btnModificar;
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
	Object[] dades;
	String idVella;
	
	public FinestraModificacioPuntsBD(FinestraPpal f){
		this.p=f;
		inicialitzacions();
		crearComponents();
		afegirComponents();
		posicionarComponents();
	}

	public void dadesPoblacio(String p){
		dades=pd.consultarRegistresID(pd.consultarID(p));
		System.out.println(dades[0].toString());
		puntsDestinacio.setSelectedItem(dades[5].toString());
		nom.setText(dades[1].toString());
		desc.setText(dades[2].toString());
		tipus.setSelectedItem(dades[3].toString());
		activitats.setSelectedItem(dades[4].toString());
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
		gbl.setConstraints(lblDades, gbc);
		
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
		gbl.setConstraints(btnModificar, gbc);
		
		this.setLayout(gbl);
	}
	private void afegirComponents() {
		this.add(camps);
		this.add(lblDades);
		this.add(btnModificar);
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
		lblDades=new JLabel("Dades");
		btnModificar=new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("Modificar");
		lblId=new JLabel("Poblacio: ");
		puntsDestinacio=new JComboBox();
		puntsDestinacio.setEnabled(false);
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
				pd.modificarPunts(new PuntsInteres("",nom.getText(),desc.getText(),tipus.getSelectedItem().toString(),activitats.getSelectedItem().toString()),idVella);
				p.actualitzarTaules();
				p.actualitzarPunts();
				JOptionPane.showMessageDialog(this,"Modificació realitzada","Modificar Punts d'Interés",JOptionPane.INFORMATION_MESSAGE);
				p.pm.dispose();
				p.comprobarFinestra(this);
			}
		}
	}
}
