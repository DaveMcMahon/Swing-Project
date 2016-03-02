import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {

	private JButton helloButton;
	private JButton goodbyeButton;

	private StringListener listener;

	public Toolbar() {
		this.setLayout(new FlowLayout());
		this.setBorder(BorderFactory.createEtchedBorder());

		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("GoodBye");

		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);

		this.add(helloButton);
		this.add(goodbyeButton);
	}

	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();

		if (clicked == helloButton) {
			if (listener != null) {
				listener.textEmitted("Hello\n");
			}
		} else if (clicked == goodbyeButton) {
			if (listener != null) {
				listener.textEmitted("GoodBye\n");
			}
		}
	}

	public void setStringListener(StringListener listener) {
		this.listener = listener;
	}
}
