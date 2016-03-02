import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});

	}
}
