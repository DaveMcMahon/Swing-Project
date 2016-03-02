import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	private JTextField nameField;
	private JTextField occupationField;
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JButton okBtn;
	private FormListener listener;

	public FormPanel() {
		Dimension dim = this.getPreferredSize();
		dim.width = 300;

		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		okBtn = new JButton("Ok");

		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();

				FormEvent event = new FormEvent(this, name, occupation);
				if (listener != null) {
					listener.formEventFired(event);
				}
			}
		});

		this.setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Add Person:");
		Border outterBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		this.setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));

		this.setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		///////////// First Row ////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		this.add(nameLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		this.add(nameField, gc);

		///////////// Second Row ////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		this.add(occupationLabel, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		this.add(occupationField, gc);

		///////////// Third Row ////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 2.0;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(okBtn, gc);
	}

	public void setFormListener(FormListener listener) {
		this.listener = listener;
	}

}
