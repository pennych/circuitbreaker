package circuitBreaker;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * Drives the CircuitBreaker application and sets the JFrame, panels,
 * and provides custom font.
 * 
 * @author Penny Chanthavong
 */
@SuppressWarnings("serial")
public class CircuitBreaker extends JFrame {
	private static JPanel contentPane;
	private static TitlePanel titlePanel;
	private static JPanel current;
	private static SeriesCircuit seriesPanel;
	private static JPanel previousPanel;
	private static JPanel instructionsPanel;

	/**
	 * Launches the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircuitBreaker frame = new CircuitBreaker();
					frame.setVisible(true);
					frame.setTitle("Circuit Breaker");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the frame.
	 */
	public CircuitBreaker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 585);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		contentPane.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("src/resources/lighteningCursor.png").getImage(),
				new Point(0,0),"custom cursor"));
		initializePanels();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(titlePanel, BorderLayout.CENTER);
		current = titlePanel;
	}

	/**
	 * Creates instances of each panel of the program.
	 */
	private void initializePanels() {
		titlePanel = new TitlePanel();
		titlePanel.setLocation(0, 0);
		
		seriesPanel = new SeriesCircuit();
		seriesPanel.setLocation(0,0);
		
		instructionsPanel = new InstructionsPanel();
		instructionsPanel.setLocation(0, 0);
	}
	
	/**
	 * Updates the content pane with the current panel.
	 * @param update panel to update contentPane with
	 */
	public static void updateContentPane(JPanel update) {
		previousPanel = current;
		contentPane.remove(current);
		contentPane.add(update, BorderLayout.CENTER);
		current = update;
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	/**
	 * Returns the previous panel the user was on, enabling
	 * the user to 'go back'.
	 * @return the previous panel
	 */
	public static JPanel getPreviousPanel() {
		return previousPanel;
	}
	
	/**
	 * Returns the series panel.
	 * @return seriesPanel
	 */
	public static JPanel getSeriesPanel() {
		return seriesPanel;
	}
	
	/**
	 * Returns the title panel.
	 * @return titlePanel
	 */
	public static JPanel getTitlePanel() {
		return titlePanel;
	}
	
	/**
	 * Returns the instructions panel.
	 * @return instructions panel
	 */
	public static JPanel getInstructionsPanel() {
		return instructionsPanel;
	}
	
	/**
	 * Returns the current panel displayed by user.
	 * @return current panel
	 */
	public static JPanel getCurrentPanel() {
		return current;
	}
	
	/**
	 * Updates the panel that is currently being displayed.
	 * @param newCurrent the panel to update the display with
	 */
	public static void setCurrentPanel(JPanel newCurrent) {
		current = newCurrent;
	}
	
	/**
	 * Returns a custom font. The method returns regular weight if true,
	 * otherwise it returns the font-weight in bold.
	 * 
	 * @param value true for regular-weighted font, false for bold
	 * @param fontSize font size
	 * @return custom font size
	 */
	public static Font customFontRegularBold(boolean value, int fontSize) {
		String fontPathRegular = "src/resources/AmaticSC-Regular.ttf";
		String fontPathBold = "src/resources/AmaticSC-Bold.ttf";
		Font amaticSCFont = null;
		Font customFont = null;
		InputStream inputStream = null;
		
		String fontPath = (value) ? fontPathRegular : fontPathBold;

		try {
			inputStream = new BufferedInputStream(new FileInputStream(fontPath));
			amaticSCFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			customFont = amaticSCFont.deriveFont(Font.PLAIN, fontSize);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("There was a problem loading the font.");
		}
		return customFont;
	}
}