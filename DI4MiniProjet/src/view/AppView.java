package view;

import java.time.LocalTime;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AppView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4040915798387556131L;

	private JFrame frame;
	private JPanel panel_1, panel_2, panel_3;
	private JTabbedPane tab;
	private JButton addButton;
	private JButton removeButton;
	private JButton emptyButton;
	private JTextField addField;
	private JTextField removeField;
	private Date currentDate;
	private JLabel reelTimeClock;
	private JLabel warningText;

	private static final int FRAME_SIZE_X = 600;
	private static final int FRAME_SIZE_Y = 600;

	private static final int TAB_LOCATION_X = 40;
	private static final int TAB_LOCATION_Y = 20;
	private static final int TAB_SIZE_X = 500;
	private static final int TAB_SIZE_Y = 500;

	private static final int ADD_BUTTON_LOCATION_X = 30;
	private static final int ADD_BUTTON_LOCATION_Y = 100;
	private static final int ADD_BUTTON_SIZE_X = 150;
	private static final int ADD_BUTTON_SIZE_Y = 50;

	private static final int REMOVE_BUTTON_LOCATION_X = 30;
	private static final int REMOVE_BUTTON_LOCATION_Y = 200;
	private static final int REMOVE_BUTTON_SIZE_X = 150;
	private static final int REMOVE_BUTTON_SIZE_Y = 50;

	private static final int EMPTY_BUTTON_LOCATION_X = 30;
	private static final int EMPTY_BUTTON_LOCATION_Y = 300;
	private static final int EMPTY_BUTTON_SIZE_X = 150;
	private static final int EMPTY_BUTTON_SIZE_Y = 50;

	private static final int ADD_FIELD_X = 260;
	private static final int ADD_FIELD_Y = 121;
	private static final int ADD_FIELD_W = 200;
	private static final int ADD_FIELD_H = 30;

	private static final int REMOVE_FIELD_X = 260;
	private static final int REMOVE_FIELD_Y = 221;
	private static final int REMOVE_FIELD_W = 200;
	private static final int REMOVE_FIELD_H = 30;

	private static final int TIME_X = 155;
	private static final int TIME_Y = 20;
	private static final int TIME_W = 400;
	private static final int TIME_H = 30;

	private static final String FRAME_TITLE = "Stock Application™ V.1.0";
	private static final String ADD_BUTTON_NAME = "Add To Stock";
	private static final String REMOVE_BUTTON_NAME = "Remove From Stock";
	private static final String EMPTY_BUTTON_NAME = "Empty All Stock";

	AppView() {

		// Frame, tab and panels creation
		frame = new JFrame();
		frame.pack();
		panel_1 = new JPanel();
		panel_2 = new JPanel();
		panel_3 = new JPanel();
		tab = new JTabbedPane();

		addField = new JTextField();
		removeField = new JTextField();

		// Configuration
		frame.setTitle(FRAME_TITLE);
		frame.setSize(FRAME_SIZE_X, FRAME_SIZE_Y);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		tab.setBounds(TAB_LOCATION_X, TAB_LOCATION_Y, TAB_SIZE_X, TAB_SIZE_Y);

		// Buttons
		addButton = new JButton(ADD_BUTTON_NAME);
		addButton.setBounds(ADD_BUTTON_LOCATION_X, ADD_BUTTON_LOCATION_Y, ADD_BUTTON_SIZE_X, ADD_BUTTON_SIZE_Y);

		removeButton = new JButton(REMOVE_BUTTON_NAME);
		removeButton.setBounds(REMOVE_BUTTON_LOCATION_X, REMOVE_BUTTON_LOCATION_Y, REMOVE_BUTTON_SIZE_X,
				REMOVE_BUTTON_SIZE_Y);

		emptyButton = new JButton(EMPTY_BUTTON_NAME);
		emptyButton.setBounds(EMPTY_BUTTON_LOCATION_X, EMPTY_BUTTON_LOCATION_Y, EMPTY_BUTTON_SIZE_X,
				EMPTY_BUTTON_SIZE_Y);

		addField.setBounds(ADD_FIELD_X, ADD_FIELD_Y, ADD_FIELD_W, ADD_FIELD_H);
		removeField.setBounds(REMOVE_FIELD_X, REMOVE_FIELD_Y, REMOVE_FIELD_W, REMOVE_FIELD_H);

		reelTimeClock = new JLabel();
		currentDate = new Date();
		reelTimeClock.setText("" + currentDate);
		reelTimeClock.setBounds(TIME_X, TIME_Y, TIME_W, TIME_H);

		warningText = new JLabel();
		warningText.setText("All elements will be removed from stock !");
		warningText.setBounds(240, 295, 300, 100);

		panel_1.setLayout(null); // To change buttons position

		panel_1.add(addButton);
		panel_1.add(removeButton);
		panel_1.add(emptyButton);
		panel_1.add(addField);
		panel_1.add(removeField);
		panel_1.add(reelTimeClock);
		panel_1.add(warningText);

		// Icon path
		String imgUrl = "images/warning.png";
		// ImageIcon image = new ImageIcon(imgUrl);
		// JLabel imageLabel = new JLabel();
		// imageLabel.setIcon(image);

		// Layout to insert icon
		GroupLayout layout = new GroupLayout(panel_1);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		JLabel img = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(imgUrl)));
		img.setBounds(350, 272, 20, 100);

		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup().addComponent(img));
		layout.setVerticalGroup(vGroup);

		// Associate panels to tab
		tab.add("Edit Stock", panel_1);
		tab.add("Show Stock", panel_2);
		tab.add("About", panel_3);

		// Add the tab to the main frame
		frame.add(tab);

		// frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return the panel_1
	 */
	public JPanel getPanel_1() {
		return panel_1;
	}

	/**
	 * @return the panel_2
	 */
	public JPanel getPanel_2() {
		return panel_2;
	}

	/**
	 * @return the panel_3
	 */
	public JPanel getPanel_3() {
		return panel_3;
	}

	/**
	 * @return the tab
	 */
	public JTabbedPane getTab() {
		return tab;
	}

	/**
	 * @return the addButton
	 */
	public JButton getAddButton() {
		return addButton;
	}

	/**
	 * @return the removeButton
	 */
	public JButton getRemoveButton() {
		return removeButton;
	}

	/**
	 * @return the emptyButton
	 */
	public JButton getEmptyButton() {
		return emptyButton;
	}

	/**
	 * @return the addField
	 */
	public JTextField getAddField() {
		return addField;
	}

	/**
	 * @return the removeField
	 */
	public JTextField getRemoveField() {
		return removeField;
	}

	/**
	 * @return the currentDate
	 */
	public Date getCurrentDate() {
		return currentDate;
	}

	/**
	 * @return the reelTimeClock
	 */
	public JLabel getReelTimeClock() {
		return reelTimeClock;
	}

	/**
	 * @return the warningText
	 */
	public JLabel getWarningText() {
		return warningText;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * @param panel_1 the panel_1 to set
	 */
	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	/**
	 * @param panel_2 the panel_2 to set
	 */
	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}

	/**
	 * @param panel_3 the panel_3 to set
	 */
	public void setPanel_3(JPanel panel_3) {
		this.panel_3 = panel_3;
	}

	/**
	 * @param tab the tab to set
	 */
	public void setTab(JTabbedPane tab) {
		this.tab = tab;
	}

	/**
	 * @param addButton the addButton to set
	 */
	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	/**
	 * @param removeButton the removeButton to set
	 */
	public void setRemoveButton(JButton removeButton) {
		this.removeButton = removeButton;
	}

	/**
	 * @param emptyButton the emptyButton to set
	 */
	public void setEmptyButton(JButton emptyButton) {
		this.emptyButton = emptyButton;
	}

	/**
	 * @param addField the addField to set
	 */
	public void setAddField(JTextField addField) {
		this.addField = addField;
	}

	/**
	 * @param removeField the removeField to set
	 */
	public void setRemoveField(JTextField removeField) {
		this.removeField = removeField;
	}

	/**
	 * @param currentDate the currentDate to set
	 */
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	/**
	 * @param reelTimeClock the reelTimeClock to set
	 */
	public void setReelTimeClock(JLabel reelTimeClock) {
		this.reelTimeClock = reelTimeClock;
	}

	/**
	 * @param warningText the warningText to set
	 */
	public void setWarningText(JLabel warningText) {
		this.warningText = warningText;
	}

	public static void main(String[] args) {
		new AppView();

	}
}
