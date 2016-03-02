import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;

	public MainFrame() {
		super("Swing Project");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		textPanel = new TextPanel();
		toolbar = new Toolbar();
		formPanel = new FormPanel();

		toolbar.setStringListener(new StringListener() {
			public void textEmitted(String text) {
				textPanel.appendText(text);
			}
		});

		this.add(formPanel, BorderLayout.WEST);
		this.add(toolbar, BorderLayout.NORTH);
		this.add(textPanel, BorderLayout.CENTER);
	}

}
