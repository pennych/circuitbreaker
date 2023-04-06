package circuitBreaker;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import edu.princeton.cs.algs4.Cycle;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;

/**
 * Creates the display panel for a series circuit configuration. Allows
 * users to select various components in a simple series circuit using 
 * Java GUI.
 */
@SuppressWarnings("serial")
public class SeriesCircuit extends JPanel {
	// JLabels that store each component icon
	private JLabel componentWest; 
	private JLabel componentNorth;
	private JLabel componentEast;
	private JLabel componentSouth;
	
	// component icons
	private static Icon resistorVertical = Component.getResistorVertical();
	private static Icon resistorHorizontal = Component.getResistorHorizontal();
	private static Icon ledRight = Component.getLEDRight();
	private static Icon ledLeft = Component.getLEDLeft();
	private static Icon ledUp = Component.getLEDUp();
	private static Icon ledDown = Component.getLEDDown();
	private static Icon currentSource = Component.getCurrentSource();
	private static Icon voltageSource = Component.getVoltageSource();
	
	// circuit nodes
	private JLabel node1a;
	private JLabel node1b;
	private JLabel node2a;
	private JLabel node2b;
	private JLabel node3a;
	private JLabel node3b;
	private JLabel node4a;
	private JLabel node4b;
	
	// JComboBox labels
	private JTextField fieldCompA;
	private JTextField fieldCompB;
	private JTextField fieldCompC;
	private JTextField fieldSupply;
	
	// circuit component labels
	private JLabel lblA;
	private JLabel lblC;
	private JLabel lblB;
	private JLabel lblPS;
	
	// unit labels corresponding to each JComboBox
	private JLabel unitSupply;
	private JLabel unitA;
	private JLabel unitB;
	private JLabel unitC;
	
	// drop-down menus of component values
	private JComboBox<String> comboSupply;
	private JComboBox<String> comboA;
	private JComboBox<String> comboB;
	private JComboBox<String> comboC;
	
	// array of units, nodes, components, and JComboBoxes
	private static JLabel[] units;
	private static JLabel[] nodes;
	private static JLabel[] components;
	private static JComboBox<String>[] boxes;
	
	// JLabels display light
	private static JLabel componentALight;
	private static JLabel componentBLight;
	private static JLabel componentCLight;
	private static JTextArea lblBrokeYourCircuit;
	
	/**
	 * Creates the panel.
	 */
	public SeriesCircuit() {
		setForeground(new Color(100, 149, 237));
		setBackground(new Color(249, 243, 254));
		setBounds(0, 0, 800, 590);
		setLayout(null);
		
		displayComponents();
		createCircuitDisplay();
		createNavigationButtons();
		chooseValuesPanel();
	}

	/**
	 * Displays default components for the circuit design.
	 */
	private void displayComponents() {
		componentWest = new JLabel("");
		componentWest.setBounds(41, 187, 61, 61);
		componentWest.setIcon(voltageSource); 
		
		componentNorth = new JLabel("");
		componentNorth.setBounds(260, 45, 61, 62);
		componentNorth.setIcon(resistorHorizontal);
		
		componentEast = new JLabel("");
		componentEast.setBounds(474, 187, 61, 61);
		componentEast.setIcon(resistorVertical);
		
		componentSouth = new JLabel("");
		componentSouth.setBounds(260, 322, 61, 61);
		componentSouth.setIcon(resistorHorizontal);
		
		// instantiates array of components
		components = new JLabel[] {componentWest, componentNorth, componentEast, componentSouth};
		
		for(JLabel component : components) {
			componentWest.setBackground(new Color(216, 191, 216));
			add(component);
		}
	}

	/**
	 * Creates the visual display of a circuit using JLabels to represent 
	 * circuit nodes and uses a label to identify each circuit component.
	 */
	private void createCircuitDisplay() {
		// Node 1
		node1a = new JLabel("");
        node1a.setBounds(70, 72, 8, 116);

        node1b = new JLabel("");
        node1b.setBounds(70, 72, 189, 8);

		// Node 2
        node2a = new JLabel("");
        node2a.setBounds(320, 72, 189, 8);

        node2b = new JLabel("");
        node2b.setBounds(501, 72, 8, 116);

		// Node 3
        node3a = new JLabel("");
        node3a.setBounds(501, 245, 8, 107);

        node3b = new JLabel("");
        node3b.setBounds(320, 348, 189, 8);

		// Node 4
        node4a = new JLabel("");
        node4a.setBounds(70, 348, 189, 8);

        node4b = new JLabel("");
        node4b.setBounds(70, 245, 8, 107);
        
        // instantiates nodes into array, format, and add to container
        nodes = new JLabel[]{node1a, node1b, node2a, node2b, node3a, node3b, node4a, node4b};
        
        for(JLabel node : nodes) {
        	node.setOpaque(true);
        	node.setBackground(Color.DARK_GRAY);
        	add(node);
        }
		
		displayIconButtons();
		
		// labels corresponding with each component on the circuit
		lblA = new JLabel("A");
		lblA.setBackground(new Color(64, 224, 208));
		lblA.setOpaque(true);	
		lblA.setBounds(320, 81, 16, 16);
		add(lblA);
		
		lblB = new JLabel("B");
		lblB.setBackground(new Color(64, 224, 208));
		lblB.setOpaque(true);
		lblB.setBounds(482, 245, 16, 16);
		add(lblB);
		
		lblC = new JLabel("C");
		lblC.setBackground(new Color(64, 224, 208));
		lblC.setOpaque(true);	
		lblC.setBounds(320, 330, 16, 16);
		add(lblC);
		
		lblPS = new JLabel("PS");
		lblPS.setBackground(new Color(64, 224, 208));
		lblPS.setOpaque(true);	
		lblPS.setBounds(82, 245, 25, 16);
		add(lblPS);
		
		//components for adding light effects
		componentALight = new JLabel("");
		componentALight.setBounds(260, 45, 61, 61);
		add(componentALight);
		
		componentBLight = new JLabel("");
		componentBLight.setBounds(474, 187, 61, 61);
		add(componentBLight);
		
		componentCLight = new JLabel("");
		componentCLight.setBounds(260, 320, 61, 61);
		add(componentCLight);
		
		// output display after simulating circuit
		lblBrokeYourCircuit = new JTextArea();
		lblBrokeYourCircuit.setOpaque(false);
		lblBrokeYourCircuit.setEditable(false);
		lblBrokeYourCircuit.setForeground(new Color(0, 0, 0));
		lblBrokeYourCircuit.setLineWrap(true);
		lblBrokeYourCircuit.setFont(CircuitBreaker.customFontRegularBold(true, 25));
		lblBrokeYourCircuit.setBounds(154, 143, 284, 153);
		add(lblBrokeYourCircuit);
	}
	
	/**
	 * Formats the JTextFields used to label each circuit node drop down list.
	 * @param txt JTextField
	 * @param str label to display
	 * @param color background color
	 */
	private void formatTextLabels(JTextField txt, String str, Color color) {
		txt.setText(str);
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setForeground(Color.DARK_GRAY);
		txt.setEditable(false);
		txt.setBorder(null);
		txt.setBackground(new Color(255, 255, 0));
	}

	/**
	 * Creates buttons to perform the following actions:
	 * run simulation, reset circuit, go home, and go to instructions.
	 */
	private void createNavigationButtons() {
		// run simulation button
		JButton btnRunSimulation = new JButton("simulate");
		btnRunSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simulateCircuit();			
			}
		});
		btnRunSimulation.setFont(CircuitBreaker.customFontRegularBold(true, 21));
		btnRunSimulation.setBounds(166, 444, 104, 23);
		btnRunSimulation.setFocusable(false);
		add(btnRunSimulation);
		
		// reset circuit button
		JButton btnResetCircuit = new JButton("reset");
		btnResetCircuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetCircuit();				
			}
		});
		btnResetCircuit.setFont(CircuitBreaker.customFontRegularBold(true, 21));
		btnResetCircuit.setBounds(296, 444, 114, 23);
		btnResetCircuit.setFocusable(false);
		add(btnResetCircuit);
		
		// home button
		JButton btnHome = new JButton("home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CircuitBreaker.updateContentPane(CircuitBreaker.getTitlePanel());
				resetCircuit();				
			}
		});
		btnHome.setFont(CircuitBreaker.customFontRegularBold(true, 21));
		btnHome.setBounds(633, 481, 89, 23);
		btnHome.setFocusable(false);
		add(btnHome);
		
		// instruction button
		JButton btnInstructions = new JButton("instructions");
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CircuitBreaker.updateContentPane(CircuitBreaker.getInstructionsPanel());
			}
		});
		btnInstructions.setFont(CircuitBreaker.customFontRegularBold(true, 21));
		btnInstructions.setBounds(620, 441, 117, 29);
		btnInstructions.setFocusable(false);
		add(btnInstructions);
	}

	/**
	 * Creates the Choose Values panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void chooseValuesPanel() {
		JLabel lblChooseValues = new JLabel("Choose Values");
		lblChooseValues.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseValues.setFont(CircuitBreaker.customFontRegularBold(true, 45));
		lblChooseValues.setBackground(new Color(216, 191, 216));
		lblChooseValues.setBounds(586, 18, 176, 50);
		add(lblChooseValues);
		
		JPanel chooseValuesPanel = new JPanel();
		chooseValuesPanel.setBackground(new Color(210, 210, 247));
		chooseValuesPanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(218, 112, 214), 
				new Color(127, 255, 212), new Color(218, 112, 214), new Color(64, 224, 208)));
		chooseValuesPanel.setBounds(586, 72, 176, 346);
		add(chooseValuesPanel);
		chooseValuesPanel.setLayout(null);
		
		// component labels: Power Supply, Component A/B/C
		fieldSupply = new JTextField();
		fieldSupply.setForeground(new Color(0, 0, 0));
		formatTextLabels(fieldSupply, "Power Supply:", new Color(255, 240, 245));
		fieldSupply.setFont(CircuitBreaker.customFontRegularBold(true, 25));
		fieldSupply.setBounds(16, 6, 130, 26);
		fieldSupply.setOpaque(false);
		chooseValuesPanel.add(fieldSupply);
		
		fieldCompA = new JTextField();
		formatTextLabels(fieldCompA, "Component A:", new Color(255, 240, 245));
		fieldCompA.setFont(CircuitBreaker.customFontRegularBold(true, 25));
		fieldCompA.setBounds(16, 90, 130, 26);
		fieldCompA.setOpaque(false);
		chooseValuesPanel.add(fieldCompA);
		
		fieldCompB = new JTextField();
		formatTextLabels(fieldCompB, "Component B:", new Color(255, 240, 245));
		fieldCompB.setFont(CircuitBreaker.customFontRegularBold(true, 25));
		fieldCompB.setBounds(21, 182, 130, 26);
		fieldCompB.setOpaque(false);
		chooseValuesPanel.add(fieldCompB);
		
		fieldCompC = new JTextField();
		formatTextLabels(fieldCompC, "Component C:", new Color(255, 240, 245));
		fieldCompC.setFont(CircuitBreaker.customFontRegularBold(true, 25));
		fieldCompC.setBounds(21, 268, 130, 26);
		fieldCompC.setOpaque(false);
		chooseValuesPanel.add(fieldCompC);
		
		// chooseValuesPanel
		comboSupply = new JComboBox();
		comboSupply.setBounds(30, 41, 93, 27);
		comboSupply.setModel(new DefaultComboBoxModel(Component.getVoltageValues()));
		
		comboA = new JComboBox();
		comboA.setBounds(30, 128, 93, 27);
		comboA.setModel(new DefaultComboBoxModel(Component.getResistorValues()));
		
		comboB = new JComboBox();
		comboB.setBounds(31, 216, 92, 27);
		comboB.setModel(new DefaultComboBoxModel(Component.getResistorValues()));
		
		comboC = new JComboBox();
		comboC.setBounds(31, 297, 92, 27);
		comboC.setModel(new DefaultComboBoxModel(Component.getResistorValues()));
		
		// instantiates array of comboBoxes
		boxes = new JComboBox[] {comboSupply, comboA, comboB, comboC};
		
		// set cursor/color for comboBoxes
		for(JComboBox box : boxes) {
			box.setBackground(new Color(255, 240, 245));
			chooseValuesPanel.add(box);
		}
		
		// output values for measurement unit pertaining to chosen components
		unitSupply = new JLabel("V");
		unitSupply.setBounds(127, 45, 24, 16);
		
		unitA = new JLabel("k\u2126");
		unitA.setBounds(131, 132, 24, 16);
		
		unitB = new JLabel("k\u2126");
		unitB.setBounds(131, 220, 24, 16);
		
		unitC = new JLabel("k\u2126");
		unitC.setBounds(131, 301, 24, 16);
		
		// instantiates array of units, format, and adds to chooseValuesPanel
		units = new JLabel[] {unitSupply, unitA, unitB, unitC};
		
		for(JLabel unit : units) {
			unit.setHorizontalAlignment(SwingConstants.CENTER);
			chooseValuesPanel.add(unit);
		}
	}

	/**
	 * Creates buttons that allow users to cycle through images of
	 * different circuit components for the circuit.
	 */
	private void displayIconButtons() {
		Icon[] westIcons = {voltageSource, currentSource};
		Icon[] northSouthIcons = {resistorHorizontal, ledLeft, ledRight};
		Icon[] eastIcons = {resistorVertical, ledUp, ledDown};
		
		// north buttons
		JButton btnNorthUp = new JButton("^");
		btnNorthUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// reverts circuit back to default if simulate button is pressed
				iterateUpButtons(northSouthIcons, componentNorth);
				unitA.setText(getUnit(componentNorth.getIcon()));
				removeEffects();
				updateListValues(componentNorth);
			}
		});
		btnNorthUp.setBounds(212, 44, 41, 25);
		btnNorthUp.setFocusable(false);
		add(btnNorthUp);
		
		JButton btnNorthDown = new JButton("v");
		btnNorthDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iterateDownButtons(northSouthIcons, componentNorth);
				unitA.setText(getUnit(componentNorth.getIcon()));
				removeEffects();
				updateListValues(componentNorth);
			}
		});
		btnNorthDown.setBounds(212, 83, 41, 25);
		btnNorthDown.setFocusable(false);
		add(btnNorthDown);
		
		// east buttons
		JButton btnEastUp = new JButton("^");
		btnEastUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iterateUpButtons(eastIcons, componentEast);
				unitB.setText(getUnit(componentEast.getIcon()));
				removeEffects();
				updateListValues(componentEast);
			}
		});
		btnEastUp.setBounds(535, 190, 41, 25);
		btnEastUp.setFocusable(false);
		add(btnEastUp);
		
		JButton btnEastDown = new JButton("v");
		btnEastDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iterateDownButtons(eastIcons, componentEast);
				unitB.setText(getUnit(componentEast.getIcon()));
				removeEffects();
				updateListValues(componentEast);
			}
		});
		btnEastDown.setBounds(535, 220, 41, 25);
		btnEastDown.setFocusable(false);
		add(btnEastDown);
		
		// west buttons
		JButton btnWestUp = new JButton("^");
		btnWestUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iterateUpButtons(westIcons, componentWest);
				unitSupply.setText(getUnit(componentWest.getIcon()));
				removeEffects();
				updateListValues(componentWest);
			}
		});
		btnWestUp.setBounds(10, 190, 41, 25);
		btnWestUp.setFocusable(false);
		add(btnWestUp);
		
		JButton btnWestDown = new JButton("v");
		btnWestDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iterateDownButtons(westIcons, componentWest);
				unitSupply.setText(getUnit(componentWest.getIcon()));
				removeEffects();
				updateListValues(componentWest);
			}
		});
		btnWestDown.setBounds(10, 220, 41, 25);
		btnWestDown.setFocusable(false);
		add(btnWestDown);
		
		// south buttons
		JButton btnSouthUp = new JButton("^");
		btnSouthUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iterateUpButtons(northSouthIcons, componentSouth);
				unitC.setText(getUnit(componentSouth.getIcon()));
				removeEffects();
				updateListValues(componentSouth);
			}
		});
		btnSouthUp.setBounds(212, 320, 41, 25);
		btnSouthUp.setFocusable(false);
		add(btnSouthUp);
		
		JButton btnSouthDown = new JButton("v");
		btnSouthDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iterateDownButtons(northSouthIcons, componentSouth);
				unitC.setText(getUnit(componentSouth.getIcon()));
				removeEffects();
				updateListValues(componentSouth);
			}
		});
		btnSouthDown.setBounds(212, 359, 41, 25);
		btnSouthDown.setFocusable(false);
		add(btnSouthDown);
	}
	
	/**
	 * Simulates the circuit under the conditions defined by user input.
	 * If the circuit is a closed circuit, the circuit node turns
	 * green indicating that current if flowing. Otherwise the
	 * circuit node will be displayed in red to indicate an
	 * open circuit.
	 */
	private void simulateCircuit() {
		Graph graph = new Graph(8); // creates digraph with 8 vertices
		graph.addEdge(0, 1); // PS component
		graph.addEdge(1, 2); // node1
		graph.addEdge(3, 4); // node2
		graph.addEdge(5, 6); // node3
		graph.addEdge(7, 0); // node4
		
		// only add the edge if no LEDs are facing wrong way
		if(!componentNorth.getIcon().equals(ledLeft))
			graph.addEdge(2, 3);
		
		if(!componentEast.getIcon().equals(ledUp))
			graph.addEdge(4, 5);
		
		if(!componentSouth.getIcon().equals(ledRight))
			graph.addEdge(6, 7);
		
		Cycle cycle = new Cycle(graph); // creates cycle, used to verify current flow
		
		lblBrokeYourCircuit.setFont(CircuitBreaker.customFontRegularBold(false, 30));
		
		if(cycle.hasCycle()) { // checks to see if there is a cycle
			updateNodeColors(new Color(144, 238, 144)); // change circuit nodes to green
			Queue<String> outputs = getSeriesOutput(); // get output for each node

			for(int i = 1; i < components.length; i++) {
				components[i].setToolTipText(outputs.dequeue());
			}
			
			for(int i = 0; i < nodes.length; i += 2) { // update toolTipTexts with current/voltage values
				String str = outputs.dequeue();
				nodes[i].setToolTipText(str);
				nodes[i + 1].setToolTipText(str);
			}
			
			if(node1a.getToolTipText().equals("RED ALERT!!")) {
				lblBrokeYourCircuit.setText("     Current is flowing but you\n       destroyed your battery :("
						+ "\n                 Try again!");
			}
			else {
				lblBrokeYourCircuit.setText("    You didn't break your circuit!\n            "
						+ "You're electric!");
			}
		}
		else {
			updateNodeColors(new Color(240, 128, 128)); // changes circuit nodes to red
			for(int i = 0; i < nodes.length; i++) { // update toolTipTexts with current/voltage values
				nodes[i].setToolTipText("<html>Voltage: 0 V<br>Current: 0 mA</html>");
			}
			lblBrokeYourCircuit.setText("     There is no current flow \n            in your circuit!\n"
					+ "  Reset your circuit & try again.");
		}
	}
	
	/**
	 * Determines the output voltages/currents for each node of the circuit
	 * when current is flowing through it. This includes the three voltage drops
	 * pertaining to each component, as well as four voltage/current values
	 * present in each circuit node, all of which are stored in a queue.
	 * @return queue of all output values
	 */
	public static Queue<String> getSeriesOutput(){
		double totalResistance = 0;
		
		for(int i = 0; i < components.length; i++) {
			if(isResistor(components[i].getIcon())) {
				totalResistance += (Double.parseDouble(boxes[i].getSelectedItem().toString()) * 1000); // convert from kilo-ohms to ohms
			}
		}
		
		double voltage = 0; // nodeA voltage
		double current = 0; // current used for all nodes
		double v1 = 0; // nodeB voltage
		double v2 = 0; // nodeC voltage
		double v3 = 0; // nodeD voltage -- should be zero at the end
		
		// if voltage is selected, define voltage, then find current
		if(components[0].getIcon().equals(voltageSource)) {
			voltage = Double.parseDouble(boxes[0].getSelectedItem().toString()); // in V
			current = voltage / totalResistance; // in A
		}
		else { // if current is selected, define current, then find voltage
			current = Double.parseDouble(boxes[0].getSelectedItem().toString()); // in mA
			current *= 1000; // convert to A
			voltage = current * totalResistance;
		}
		
		// find node voltages/currents
		if(isResistor(components[1].getIcon())) {
			v1 = current * Double.parseDouble(boxes[1].getSelectedItem().toString()) * 1000; // v1 = current x resistance in kiloohms
		}
		else {
			componentALight.setIcon(Component.getLEDLight(boxes[1].getSelectedItem().toString()));
			v1 = 0;
		}

		if(isResistor(components[2].getIcon())) {
			v2 = current * Double.parseDouble(boxes[2].getSelectedItem().toString()) * 1000;
		}
		else {
			componentBLight.setIcon(Component.getLEDLight(boxes[2].getSelectedItem().toString()));
			v2 = 0;
		}

		if(isResistor(components[3].getIcon())) {
			v3 = current * Double.parseDouble(boxes[3].getSelectedItem().toString()) * 1000;
		}
		else {
			componentCLight.setIcon(Component.getLEDLight(boxes[3].getSelectedItem().toString()));
			v3 = 0;
		}
		
		String currentDF = new DecimalFormat("#######.##").format(current * 1000);
		String voltageDF = new DecimalFormat("#######.##").format(voltage);
		String v1DF = new DecimalFormat("#######.##").format(v1);
		String v2DF = new DecimalFormat("#######.##").format(v2);			
		String v3DF = new DecimalFormat("#######.##").format(v3);
		
		// create strings for circuit display
		Queue<String> queue = new Queue<>();

		// If all voltages = 0 (meaning all components are LEDs), then set "RED ALERT"
		if((v1 + v2 + v3) == 0) {
			queue.enqueue("Voltage Drop: " + v1DF + " V");
			queue.enqueue("Voltage Drop: " + v2DF + " V");
			queue.enqueue("Voltage Drop: " + v3DF + " V");
			
			for(int i = 0; i < 4; i++) {
				queue.enqueue("RED ALERT!!");
			}
		}
		else {	// add voltage/current displays for node toolTipTexts		
			String node1 = "<html>Voltage: " + voltageDF + " V<br>Current: " + currentDF + " mA</html>";
			String node2 = "<html>Voltage: " + new DecimalFormat("#######.##").format(voltage - v1) 
					+ " V<br>Current: " + currentDF + " mA</html>";
			String node3 = "<html>Voltage: " + new DecimalFormat("#######.##").format(voltage - v1 - v2) 
					+ " V<br>Current: " + currentDF + " mA</html>";
			String node4 = "<html>Voltage: 0 V<br>Current: " + currentDF + " mA</html>";
			
			// add strings to queue
			queue.enqueue("Voltage Drop: " + v1DF + " V");
			queue.enqueue("Voltage Drop: " + v2DF + " V");
			queue.enqueue("Voltage Drop: " + v3DF + " V");
			queue.enqueue(node1);
			queue.enqueue(node2);
			queue.enqueue(node3);
			queue.enqueue(node4);
		}
		return queue;
	}
	
	/**
	 * Determines whether a displayed icon is a resistor.
	 * @param icon icon
	 * @return whether or not the icon is a resistor
	 */
	public static boolean isResistor(Icon icon) {
		if(icon.equals(resistorHorizontal) || icon.equals(resistorVertical))
			return true;
		else
			return false;
	}

	/**
	 * Updates the color of the circuit node with the given color.
	 * @param color new color
	 */
	private void updateNodeColors(Color color) {
		for(JLabel node : nodes) {
			node.setBackground(color);
		}
	}

	/**
	 * Resets the circuit to its default display images, consisting of one voltage
	 * source and three resistors.
	 */
	private void resetCircuit() {		
		for (JLabel node : nodes) {
	        node.setBackground(Color.DARK_GRAY);
		}

		// reset icons
		Icon[] icons = {voltageSource, resistorHorizontal, resistorVertical, resistorHorizontal};
		
		for (int i = 0; i < components.length; i++) {
			components[i].setIcon(icons[i]);
			add(components[i]);
		}	
		
		// resets combobox lists
		for(JLabel component : components) {
			updateListValues(component);
		}
		
		// resets unit of measurement
		for(int i = 0; i < units.length; i++) {
			units[i].setText(getUnit(components[i].getIcon()));
		}
		
		removeEffects();
	}
	
	/**
	 * Removes all visual effects after a circuit simulation.
	 */
	public void removeEffects() {
		// remove light effects
		componentALight.setIcon(null);
		componentBLight.setIcon(null);
		componentCLight.setIcon(null);
		lblBrokeYourCircuit.setText(""); // remove output display
		updateNodeColors(Color.DARK_GRAY); // change node color to gray
		// remove toolTipText displays
		for(JLabel node : nodes) {
			node.setToolTipText(null);
		}
	}
	
	/**
	 * Determines the appropriate unit of measurement of a component based off a given
	 * icon of that component.
	 * @param icon image icon
	 * @return unit of measurement
	 */
	private String getUnit(Icon icon) {
		if(icon.equals(resistorVertical) || icon.equals(resistorHorizontal)) { // kilo-ohms
			return "k\u2126";
		}
		if(icon.equals(currentSource)) { // mA
			return "mA";
		}
		if(icon.equals(voltageSource)) { // V
			return "V";
		}
		else { // diodes - no units
			return ""; 
		}
	}

	/**
	 * Updates the drop-down list values based on the component selected.
	 * @param label JLabel component to update corresponding list
	 */
	private void updateListValues(JLabel label) {
		if (label.equals(componentNorth)) {			
			updateListValues(componentNorth, comboA);
		}
		else if (label.equals(componentEast)) {
			updateListValues(componentEast, comboB);

		}
		else if (label.equals(componentSouth)) {
			updateListValues(componentSouth, comboC);
		}
		else if (label.equals(componentWest)) {
			updateListValues(componentWest, comboSupply);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	/**
	 * Helper method to the updateListValues method.
	 * 
	 * @param label
	 * @param combo
	 */
	private void updateListValues(JLabel label, JComboBox combo) {
		combo.removeAllItems();
		if (isResistor(label.getIcon())) {
			for (int el : Component.getResistorValues()) {
				combo.addItem(el);
			}
		}
		else if(label.getIcon().equals(voltageSource)) {
			for (int el : Component.getVoltageValues()) {
				combo.addItem(el);
			}
		}
		else if(label.getIcon().equals(currentSource)) {
			for (double el : Component.getCurrentValues()) {
				combo.addItem(el);
			}
		}
		else {
			for (String el : Component.getColorValues()) {
				combo.addItem(el);
			}
		}
	}

	/**
	 * Returns the index of the current icon.
	 * 
	 * @param icons array of component icons
	 * @param label label to update
	 * @return the index of the current icon
	 */
	private int iconArrayIndex(JLabel label, Icon[] icons) {
		int currentIndex = 0;
		
		for(int i = 0; i < icons.length; i++) {
			if(label.getIcon().equals(icons[i]))
				currentIndex = i;
			else
				continue;
		}
		return currentIndex;
	}

	/**
	 * Iterates through an array of icons and displays the icon on a given JLabel.
	 * Method is invoked when the up button (represented by ^) is pressed.
	 * 
	 * @param icons array of icons
	 * @param label the label whose icon will be updated
	 */
	private void iterateUpButtons(Icon[] icons, JLabel label) {
		int currentIndex = iconArrayIndex(label, icons);
		int nextIndex = currentIndex + 1;
		
		if(nextIndex % icons.length == 0)
			nextIndex = 0;
		
		label.setIcon(icons[nextIndex]);
	}

	/**
	 * Iterates through an array of icons and displays the icon on a given JLabel.
	 * Method is invoked when the down button (represented by v) is pressed.
	 * 
	 * @param array of icons
	 * @param label the label whose icon will be updated
	 */
	private void iterateDownButtons(Icon[] icons, JLabel label) {
		int currentIndex = iconArrayIndex(label, icons);
		int lastIndex = currentIndex - 1;
		
		if(currentIndex == 0)
			lastIndex = icons.length - 1;
		
		label.setIcon(icons[lastIndex]);
	}
}