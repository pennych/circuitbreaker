package circuitBreaker;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Defines the instructions panel.
 */
@SuppressWarnings("serial")
public class InstructionsPanel extends JPanel {

	/**
	 * Creates the panel.
	 */
	public InstructionsPanel() {
		setBackground(new Color(249, 243, 254));
		setBounds(0, 0, 800, 550);
		setLayout(null);
		
		createInstructionsPanel();
		createComponentDisplay();
		createOhmsLawPanel();
		
		JButton btnNavigateBack = new JButton("back");
		btnNavigateBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CircuitBreaker.getPreviousPanel().equals(CircuitBreaker.getSeriesPanel()))
					CircuitBreaker.updateContentPane(CircuitBreaker.getSeriesPanel());
			}
		});
		btnNavigateBack.setFont(CircuitBreaker.customFontRegularBold(true, 20));
		btnNavigateBack.setBounds(617, 486, 117, 29);
		btnNavigateBack.setFocusable(false);
		add(btnNavigateBack);
	}

	/**
	 * Creates display for Ohm's law.
	 */
	private void createOhmsLawPanel() {
		JLabel lblOhmsLaw = new JLabel("Ohm's law");
		lblOhmsLaw.setHorizontalAlignment(SwingConstants.CENTER);
		lblOhmsLaw.setFont(CircuitBreaker.customFontRegularBold(true, 40));
		lblOhmsLaw.setForeground(new Color(0, 0, 0));
		lblOhmsLaw.setBounds(205, 6, 160, 48);
		add(lblOhmsLaw);
		
		JTextArea txtOhmsLaw = new JTextArea();
		formatTextArea(txtOhmsLaw, 20, false);
		txtOhmsLaw.setText("     Ohm's Law describes how current (I) flows through a resistance when a potential "
				+ "difference (voltage, V) is applied across the resistance (R). A helpful analogy is to "
				+ "think of current as water flow, voltage as water pressure, & resistance as the size of "
				+ "a pipe. If  more pressure (voltage) is applied to a larger pipe (lower resistance), then "
				+ "more water\n       will flow (current). Mathematically, Ohm's Law is represented as: V = I * R");
		txtOhmsLaw.setBounds(36, 65, 500, 165);
		add(txtOhmsLaw);
	}
	
	/**
	 * Creates the instructions panel that describes how users can use the interface.
	 */
	private void createInstructionsPanel() {
		JTextArea txtInstructions = new JTextArea();
		formatTextArea(txtInstructions, 17, true);
		txtInstructions.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		txtInstructions.setCaretColor(new Color(147, 112, 219));
		txtInstructions.setText("    Design your circuit by cycling          through components "
				+ "using the\n                arrow buttons.\n\n Choose values for your components"
				+ "   from the drop-down menus, then\n   run the simulation to see how\n           "
				+ "the circuit behaves.\n\n   If a node turns green, current\n    is flowing through "
				+ "that node; \n       if it turns red, current is \n                 not flowing."
				+ "\n\nHover your cursor over the nodes to\n see the corresponding current and\n"
				+ "                 voltage values.\n");
		txtInstructions.setBounds(581, 68, 184, 399);
		add(txtInstructions);
		
		JLabel lblInstructions = new JLabel("Instructions");
		lblInstructions.setForeground(new Color(0, 0, 0));
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions.setFont(CircuitBreaker.customFontRegularBold(true, 40));
		lblInstructions.setBounds(593, 6, 160, 48);
		add(lblInstructions);
	}

	/**
	 * Creates the component display.
	 */
	private void createComponentDisplay() {
		// create icons - these are smaller than those created in series circuit
		ImageIcon resistor = new ImageIcon("src/resources/resistorHorizontal.png");
		ImageIcon ledRight = new ImageIcon("src/resources/ledRight.png");
		ImageIcon currentSource = new ImageIcon("src/resources/currentSource.png");
		ImageIcon voltageSource = new ImageIcon("src/resources/voltageSource.png");

		Image resistorImg = resistor.getImage();
		Image ledRightImg = ledRight.getImage();
		Image currentSourceImg = currentSource.getImage();
		Image voltageSourceImg = voltageSource.getImage();
		
		resistorImg = resistorImg.getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH);
		ledRightImg = ledRightImg.getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH);
		currentSourceImg = currentSourceImg.getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH);
		voltageSourceImg = voltageSourceImg.getScaledInstance(48, 48, java.awt.Image.SCALE_SMOOTH);

		resistor = new ImageIcon(resistorImg);
		ledRight = new ImageIcon(ledRightImg);
		currentSource = new ImageIcon(currentSourceImg);
		voltageSource = new ImageIcon(voltageSourceImg);
		
		// components title
		JLabel lblComponents = new JLabel("ComponentS");
		lblComponents.setFont(CircuitBreaker.customFontRegularBold(true, 40));
		lblComponents.setBounds(133, 224, 317, 48);
		add(lblComponents);
		lblComponents.setHorizontalAlignment(SwingConstants.CENTER);
		lblComponents.setForeground(new Color(0, 0, 0));
		
		// component icons to match descriptions
		JLabel lblVoltageSource = new JLabel("");
		lblVoltageSource.setBounds(50, 284, 48, 48);
		add(lblVoltageSource);
		lblVoltageSource.setIcon(voltageSource);
		
		JLabel lblCurrentSource = new JLabel("");
		lblCurrentSource.setBounds(190, 284, 48, 48);
		add(lblCurrentSource);
		lblCurrentSource.setIcon(currentSource);
		
		JLabel lblResistor = new JLabel("");
		lblResistor.setBounds(333, 283, 48, 48);
		add(lblResistor);
		lblResistor.setIcon(resistor);
		
		JLabel lblLED = new JLabel("");
		lblLED.setBounds(475, 284, 48, 48);
		add(lblLED);
		lblLED.setIcon(ledRight);
		
		// descriptions of each component
		JTextArea txtVoltageSource = new JTextArea();
		formatTextArea(txtVoltageSource, 20, false);
		txtVoltageSource.setText("  Voltage Source:\n     provides a constant voltage     "
				+ "independent of any other circuit         elements");
		txtVoltageSource.setBounds(22, 360, 108, 155);
		add(txtVoltageSource);
		
		JTextArea txtCurrentSource = new JTextArea();
		formatTextArea(txtCurrentSource, 20, false);
		txtCurrentSource.setText("  Current Source:\n     provides a constant current    "
				+ "independent of any other circuit          elements");
		txtCurrentSource.setBounds(159, 360, 108, 155);
		add(txtCurrentSource);
		
		JTextArea txtResistor = new JTextArea();
		formatTextArea(txtResistor, 20, false);
		txtResistor.setText("     Resistor:\nlimits the flow        of electric          "
				+ "    current\n");
		txtResistor.setBounds(320, 360, 97, 109);
		add(txtResistor);
		
		JTextArea txtLED = new JTextArea();
		formatTextArea(txtLED, 18, false);
		txtLED.setText("             LED:\n a light- emitting        diode that only allows"
				+ " current flow   in one direction         (from + to -)");
		txtLED.setBounds(448, 360, 102, 155);
		add(txtLED);

	}
	
	/**
	 * Formats the given JTextArea as non-editable with line-wrapping and a black font color.
	 * Additionally, the preferred font size and opacity is defined.
	 * @param txt JTextArea
	 * @param fontSize font size
	 * @param opacity whether or not the text area is opaque
	 */
	public void formatTextArea(JTextArea txt, int fontSize, boolean opacity) {
		txt.setFont(CircuitBreaker.customFontRegularBold(true, fontSize));
		txt.setEditable(false);
		txt.setWrapStyleWord(true);
		txt.setLineWrap(true);
		txt.setOpaque(opacity);
		txt.setForeground(new Color(0, 0, 0));
	}
}
