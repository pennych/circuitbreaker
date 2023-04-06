package circuitBreaker;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Creates the title panel of the CircuitBreaker application.
 */
@SuppressWarnings("serial")
public class TitlePanel extends JPanel {

	public TitlePanel() {
		setLayout(null);
		setBounds(0, 0, 800, 550);
		setBackground(new Color(249, 243, 254));
		setLocation(10, 11);
		
		JLabel lblTitle = new JLabel("CIRCUIT BREAKER");
		lblTitle.setBounds(49, 123, 698, 193);
		lblTitle.setOpaque(false);
		lblTitle.setForeground(new Color(100, 149, 237));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(CircuitBreaker.customFontRegularBold(true, 150));
		add(lblTitle);
		
		JButton btnSeries = new JButton("DESIGN SERIES CIRCUIT");
		btnSeries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CircuitBreaker.updateContentPane(CircuitBreaker.getSeriesPanel());
			}
		});
		btnSeries.setFont(CircuitBreaker.customFontRegularBold(true, 30));
		btnSeries.setForeground(new Color(255, 255, 255));
		btnSeries.setBackground(new Color(100, 149, 237));
		btnSeries.setBounds(278, 387, 250, 40);
		btnSeries.setFocusable(false);
		add(btnSeries);
		
		JLabel lightningBorder = new JLabel("");
		lightningBorder.setBounds(0, 0, 800, 550);
		lightningBorder.setIcon(new ImageIcon("src/resources/lightningBolt.png"));
		add(lightningBorder);
	}
}