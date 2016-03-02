import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
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
	private JList<AgeCategory> ageList;

	public FormPanel() {
		Dimension dim = this.getPreferredSize();
		dim.width = 300;
		this.setPreferredSize(dim);

		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		okBtn = new JButton("Ok");
		ageList = new JList<AgeCategory>();

		ageList.setPreferredSize(new Dimension(127, 65));

		DefaultListModel<AgeCategory> ageModel = new DefaultListModel<AgeCategory>();
		ageModel.addElement(new AgeCategory(0, "Over 18"));
		ageModel.addElement(new AgeCategory(1, "18 to 65"));
		ageModel.addElement(new AgeCategory(2, "65 or over"));

		ageList.setModel(ageModel);
		ageList.setBorder(BorderFactory.createEtchedBorder());
		ageList.setSelectedIndex(0);

		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCat = ageList.getSelectedValue();

				System.out.println(ageCat.getID());

				FormEvent event = new FormEvent(this, name, occupation);
				if (listener != null) {
					listener.formEventFired(event);
				}
			}
		});

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
		gc.weighty = 0.1;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(ageList, gc);

		///////////// Fourth Row ////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 2.0;
		gc.gridx = 1;
		gc.gridy = 3;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(okBtn, gc);
	}

	public void setFormListener(FormListener listener) {
		this.listener = listener;
	}

}

class AgeCategory {
	private int id;
	private String text;

	public AgeCategory(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public String toString() {
		return text;
	}

	public int getID() {
		return id;
	}
}
