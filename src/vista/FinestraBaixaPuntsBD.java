package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import model.DestinacionsDAO;
import model.PuntsDAO;

public class FinestraBaixaPuntsBD extends JInternalFrame implements ActionListener {

	FinestraPpal p=null;
	DestinacionsDAO d=new DestinacionsDAO();
	PuntsDAO pd=new PuntsDAO();
	JButton sortir;
	JButton esborrar;
	JPanel panelBotons;
	JTable taula;
	JScrollPane jsp;
	DefaultTableModel model;
	GridBagLayout gbl;
	public FinestraBaixaPuntsBD(FinestraPpal f){
		this.p=f;
		inicialitzacions();
		crearComponents();
		afegirComponents();
		posicionarComponents();
		comprobarPunts();
	}
	
	public void comprobarPunts() {
		if(pd.esBuit()){
			esborrar.setEnabled(false);
			esborrar.setToolTipText("Tens que crear una destinaci� abans de poder donar-n'hi de baixa");
		}else{
			esborrar.setEnabled(true);
			esborrar.setToolTipText(null);
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
		gbl.setConstraints(panelBotons, gbc);
		
		this.setLayout(gbl);
		
		
	}
	private void afegirComponents() {
		this.add(panelBotons);
		this.add(jsp);
		
	}
	
	private void crearComponents() {
		sortir=new JButton("Sortir");
		sortir.addActionListener(this);
		sortir.setActionCommand("Sortir");
		esborrar=new JButton("Baixa");
		esborrar.addActionListener(this);
		esborrar.setActionCommand("Esborrar");
		panelBotons=new JPanel();
		panelBotons.add(esborrar);
		panelBotons.add(sortir);
		model=new DefaultTableModel();
		taula=new JTable(model);
		jsp=new JScrollPane(taula);
		model.addColumn("Id");
		model.addColumn("Nom");
		model.addColumn("Descripcio");
		model.addColumn("Tipus");
		model.addColumn("Activitats");
		model.addColumn("Poblacio");
		taula.setDefaultEditor(Object.class, null);
		taula.getTableHeader().setReorderingAllowed(false);
	}
	private void inicialitzacions() {
		this.setTitle("Finestra Baixa");
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
				p.pb.dispose();
				p.comprobarFinestra(this);
				p.comprobarPunts();
			}
			if((e.getActionCommand().equals("Esborrar"))){
				if(taula.isRowSelected(taula.getSelectedRow())){
					pd.baixaPunts(taula.getValueAt(taula.getSelectedRow(), 0).toString());
					p.actualitzarPunts();
					JOptionPane.showMessageDialog(this,"Baixa realitzada","Baixa Punts d'Interés",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(this,"No has seleccionat cap fila","Baixa Destinacio",JOptionPane.WARNING_MESSAGE);
				}
				comprobarPunts();
			}
		}
		
	}
}
