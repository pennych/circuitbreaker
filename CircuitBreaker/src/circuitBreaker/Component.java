package circuitBreaker;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Defines images and values representative of various circuit components.
 */
public class Component {
	
	/**
	 * Returns an icon of a vertically oriented resistor.
	 * @return verticalResistor icon
	 */
	public static ImageIcon getResistorVertical() {
		return formatIcon(new ImageIcon("src/resources/resistorVertical.png"), 65);
	}
	
	/**
	 * Returns an icon of a horizontally oriented resistor.
	 * @return horizontalResistor icon
	 */
	public static ImageIcon getResistorHorizontal() {
		return formatIcon(new ImageIcon("src/resources/resistorHorizontal.png"), 65);
	}
	
	/**
	 * Returns an icon of a left-pointing LED.
	 * @return left LED
	 */
	public static ImageIcon getLEDLeft() {
		return formatIcon(new ImageIcon("src/resources/ledLeft.png"), 70);
	}
	
	/**
	 * Returns an icon of a right-pointing LED.
	 * @return right LED
	 */
	public static ImageIcon getLEDRight() {
		return formatIcon(new ImageIcon("src/resources/ledRight.png"), 70);
	}
	
	/**
	 * Returns an icon of a upward-pointing LED.
	 * @return upward LED
	 */
	public static ImageIcon getLEDUp() {
		return formatIcon(new ImageIcon("src/resources/ledUp.png"), 70);
	}
	
	/**
	 * Returns an icon of a downward-pointing LED.
	 * @return downward LED
	 */
	public static ImageIcon getLEDDown() {
		return formatIcon(new ImageIcon("src/resources/ledDown.png"), 70);
	}
	
	/**
	 * Returns an icon of a current source.
	 * @return current source
	 */
	public static ImageIcon getCurrentSource() {
		return formatIcon(new ImageIcon("src/resources/currentSource.png"), 70);
	}
	
	/**
	 * Returns an icon of a voltage source.
	 * @return voltage source
	 */
	public static ImageIcon getVoltageSource() {
		return formatIcon(new ImageIcon("src/resources/voltageSource.png"), 70);
	}
	
	/**
	 * Resizes a square icon to the given dimension.
	 * @param icon icon to resize
	 * @param dim new dimension
	 * @return resized icon
	 */
	private static ImageIcon formatIcon(ImageIcon icon, int dim) {
		Image img = icon.getImage();
		img = img.getScaledInstance(dim, dim, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(img);
	}
	
	/**
	 * Returns an icon simulating light from an LED.
	 * @param color LED color
	 * @return light icon
	 */
	public static ImageIcon getLEDLight(String color) {
		ImageIcon redLED = new ImageIcon("src/resources/redLED.png");
		ImageIcon blueLED = new ImageIcon("src/resources/blueLED.png");
		ImageIcon greenLED = new ImageIcon("src/resources/greenLED.png");
		
		if(color.equals("Blue"))
			return blueLED;
		
		if(color.equals("Green"))
			return greenLED;
		else
			return redLED;		
	}
	
	/**
	 * Returns a String array of LED colors.
	 * @return LED colors
	 */
	public static String[] getColorValues() {
		String[] colors = {"Blue", "Red", "Green"};
		return colors;
	}
	
	/**
	 * Returns an Integer array of voltage values in Volts.
	 * @return voltages
	 */
	public static Integer[] getVoltageValues() {
		Integer[] voltages = {12, 9, 5, 3};
		return voltages;
	}
	
	/**
	 * Returns an Integer array of resistor values in kilo-ohms.
	 * @return resistors
	 */
	public static Integer[] getResistorValues() {
		Integer[] resistors = {1, 2, 5, 10, 24, 56, 100, 300, 560, 1000};
		return resistors;
	}
	
	/**
	 * Returns a Double array of current values in milliamperes.
	 * @return currents
	 */
	public static Double[] getCurrentValues() {
		Double[] currents = {0.1, 0.5, 1.0, 2.0, 10.0};
		return currents;
	}	
}