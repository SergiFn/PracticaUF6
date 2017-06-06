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

import model.PuntsDAO;

public class FinestraConsultaPuntsBD extends JInternalFrame implements ActionListener{

	FinestraPpal p=null;
	JButton sortir;
	JTable taula;
	JScrollPane jsp;
	DefaultTableModel model;
	GridBagLayout gbl;
	
	public FinestraConsultaPuntsBD(FinestraPpal finestra){
		this.p=finestra;
		PuntsDAO pd=new PuntsDAO();
		inicialitzacions();
		crearComponents();
		afegirComponents();
		posicionarComponents();
		pd.afegirDadesTaula(model);
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
		model.addColumn("Nom");
		model.addColumn("Descripcio");
		model.addColumn("Tipus");
		model.addColumn("Activitats");
		model.addColumn("Poblacio");
		taula.setSize(400,600);
		taula.setDefaultEditor(Object.class, null);
		taula.getTableHeader().setReorderingAllowed(false);
	}
	private void inicialitzacions() {
		this.setTitle("Finestra Consulta Punts");
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
				p.pc.dispose();
				p.comprobarFinestra(this);
				p.comprobarPunts();
				p.pb.comprobarPunts();
			}
		}
	}


}
