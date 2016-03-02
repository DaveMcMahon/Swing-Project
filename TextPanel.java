import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class TextPanel extends JPanel {

	private JTextArea textArea;

	public TextPanel() {
		super();
		this.setLayout(new BorderLayout());
		Border innerBorder = BorderFactory.createTitledBorder("Text Area:");
		Border outterBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		this.setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));

		textArea = new JTextArea();
		this.add(new JScrollPane(textArea), BorderLayout.CENTER);
	}

	public void appendText(String text) {
		textArea.append(text);
	}

}
