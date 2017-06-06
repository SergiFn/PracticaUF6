package vista;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import model.DestinacionsDAO;

public class FinestraConsultaDestinacionsBD extends JInternalFrame implements ActionListener{

	FinestraPpal p=null;
	DestinacionsDAO d=new DestinacionsDAO();
	JButton sortir;
	JTable taula;
	JScrollPane jsp;
	DefaultTableModel model;
	GridBagLayout gbl;
	
	public FinestraConsultaDestinacionsBD(FinestraPpal finestra){
		this.p=finestra;
		inicialitzacions();
		crearComponents();
		afegirComponents();
		posicionarComponents();
		d.afegirDadesTaula(model);
	}
	
	private void posicionarComponents() {
		gbl=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		
		//columna 0 fila 0
		gbc.gridx = 0; // columna
		gbc.gridy = 0; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbl.setConstraints(jsp, gbc);
		
		//columna 0 fila 0
		gbc.gridx = 0; // columna
		gbc.gridy = 1; // fila
		gbc.gridwidth = 1; // amplada
		gbc.gridheight = 1; // alçada
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill=GridBagConstraints.NONE;
		gbl.setConstraints(sortir, gbc);
		
		this.setLayout(gbl);
		
		
	}
	
	private void afegirComponents() {
		this.add(sortir);
		this.add(jsp);
	}
	
	private void crearComponents() {
		sortir=new JButton("Sortir");
		sortir.addActionListener(this);
		sortir.setActionCommand("Sortir");
		model=new DefaultTableModel();
		taula=new JTable(model);
		jsp=new JScrollPane(taula);
		model.addColumn("Id");
		model.addColumn("Continent");
		model.addColumn("Pais");
		model.addColumn("Capital");
		model.addColumn("Ciutat");
		model.addColumn("Poblacio");
		model.addColumn("CP");
		model.addColumn("Platja");
		taula.setSize(400,600);
		taula.setDefaultEditor(Object.class, null);
		taula.getTableHeader().setReorderingAllowed(false);
	}
	private void inicialitzacions() {
		this.setTitle("Finestra Consulta");
		this.setBounds(400,1,500,700);
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		p.centrarFinestra(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if((obj instanceof JButton)){
			if((e.getActionCommand().equals("Sortir"))){
				p.c.dispose();
				p.comprobarFinestra(this);
				p.comprobarDestinacions();
				p.comprobarPunts();
			}
		}
	}

}
