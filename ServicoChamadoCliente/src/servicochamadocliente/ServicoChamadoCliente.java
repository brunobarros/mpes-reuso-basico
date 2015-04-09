package servicochamadocliente;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import servico.IServicoChamado;

public class ServicoChamadoCliente extends JFrame {
	
	private List<IServicoChamado> servicosChamado;
	
	private JButton b = new JButton("Diga oi");
	private JTextField textbox = new JTextField(30);
	
	public ServicoChamadoCliente() {
		JPanel holder = new JPanel(new FlowLayout());
		this.setSize(400, 200);
		holder.add(textbox);
		holder.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String message = null;
				if (servicosChamado == null || servicosChamado.isEmpty()) {
					message = "Serviços indisponíveis";
				} else {
					message = servicosChamado.get(0).toString();
				}
				JOptionPane.showMessageDialog(null, message);
			}
		});
		this.add(holder);
		this.setVisible(true);
	}
	
	public void addServicoChamado(IServicoChamado servicoChamado) {
		System.out.println("Adicionando Serviço chamado");
		
		if (this.servicosChamado == null) {
			this.servicosChamado = new ArrayList<IServicoChamado>();
		}
		this.servicosChamado.add(servicoChamado);
		
		System.out.println("Serviço chamado adicionado");
	}

	public void removeServicoChamado(IServicoChamado servicoChamado) {
		System.out.println("Serviço chamado sendo removido");
		
		if (this.servicosChamado != null && !this.servicosChamado.isEmpty()) {
			this.servicosChamado.remove(servicoChamado);
			System.out.println("Serviço chamado removido");
		}
	}
	
}

