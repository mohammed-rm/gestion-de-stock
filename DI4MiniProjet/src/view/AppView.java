package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import management.Stock;

public class AppView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Stock stock;

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
	private DefaultTableModel model;
	private JTable table;
	private JTableHeader header;

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

	private static final int WARNING_MESSAGE_X = 240;
	private static final int WARNING_MESSAGE_Y = 295;
	private static final int WARNING_MESSAGE_W = 300;
	private static final int WARNING_MESSAGE_H = 100;

	private static final int WARNING_ICON_X = 350;
	private static final int WARNING_ICON_Y = 272;
	private static final int WARNING_ICON_W = 20;
	private static final int WARNING_ICON_H = 100;

	private static final String FRAME_TITLE = "Stock Application™ V.1.0";
	private static final String ADD_BUTTON_NAME = "Add To Stock";
	private static final String REMOVE_BUTTON_NAME = "Remove From Stock";
	private static final String EMPTY_BUTTON_NAME = "Empty All Stock";

	/**
	 * Default Builder
	 */
	public AppView(Stock st) {
		try {
			this.stock = st;
			buildWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * GUI builder
	 */
	public void buildWindow() {

		initComponents();

		// Configuration
		mainFrameSettings();
		tab.setBounds(TAB_LOCATION_X, TAB_LOCATION_Y, TAB_SIZE_X, TAB_SIZE_Y);

		// Buttons
		setButtons();
		addButton.addActionListener(this);
		removeButton.addActionListener(this);
		emptyButton.addActionListener(this);

		addField.setBounds(ADD_FIELD_X, ADD_FIELD_Y, ADD_FIELD_W, ADD_FIELD_H);
		removeField.setBounds(REMOVE_FIELD_X, REMOVE_FIELD_Y, REMOVE_FIELD_W, REMOVE_FIELD_H);

		JLabel infoRem = new JLabel();
		infoRem.setText("Number of products to remove");
		infoRem.setBounds(270, 160, 200, 200);

		JLabel infoAdd = new JLabel();
		infoAdd.setText("Product Id to add");
		infoAdd.setBounds(310, 60, 200, 200);

		// Current static time
		reelTimeClock = new JLabel();
		currentDate = new Date();
		reelTimeClock.setText("" + currentDate);
		reelTimeClock.setBounds(TIME_X, TIME_Y, TIME_W, TIME_H);

		warningText = new JLabel();
		warningText.setText("All elements will be removed from stock !");
		warningText.setBounds(WARNING_MESSAGE_X, WARNING_MESSAGE_Y, WARNING_MESSAGE_W, WARNING_MESSAGE_H);

		panel_1.setLayout(null); // To change buttons position

		panel_1.add(addButton);
		panel_1.add(removeButton);
		panel_1.add(emptyButton);
		panel_1.add(addField);
		panel_1.add(removeField);
		panel_1.add(reelTimeClock);
		panel_1.add(warningText);
		panel_1.add(infoRem);
		panel_1.add(infoAdd);

		// Icon path
		String imgUrl = "images/failure.png";

		// Layout to insert icon
		GroupLayout layout = new GroupLayout(panel_1);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		JLabel img = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(imgUrl)));
		img.setBounds(WARNING_ICON_X, WARNING_ICON_Y, WARNING_ICON_W, WARNING_ICON_H);

		GroupLayout.SequentialGroup group = layout.createSequentialGroup();
		group.addGroup(layout.createParallelGroup().addComponent(img));
		layout.setVerticalGroup(group);

		// Stack display
		model = new DefaultTableModel(stock.getMAX(), 1);
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setHeaderValue("Stock Products");
		table.getTableHeader().resizeAndRepaint();
		header = table.getTableHeader();
		header.setBackground(Color.green);
		panel_2.add(new JScrollPane(table));

		// Associate panels to tab
		tab.add("Edit Stock", panel_1);
		tab.add("Show Stock", panel_2);
		tab.add("About", panel_3);

		// Add the tab to the main frame
		frame.add(tab);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Method to initiate window components
	 */
	public void initComponents() {
		frame = new JFrame();
		frame.pack();

		panel_1 = new JPanel();
		panel_2 = new JPanel();
		panel_3 = new JPanel();
		tab = new JTabbedPane();

		addField = new JTextField();
		removeField = new JTextField();
	}

	/**
	 * Configuration method for the main frame
	 */
	public void mainFrameSettings() {
		frame.setTitle(FRAME_TITLE);
		frame.setSize(FRAME_SIZE_X, FRAME_SIZE_Y);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Configuration method for the buttons
	 */
	public void setButtons() {
		addButton = new JButton(ADD_BUTTON_NAME);
		addButton.setBounds(ADD_BUTTON_LOCATION_X, ADD_BUTTON_LOCATION_Y, ADD_BUTTON_SIZE_X, ADD_BUTTON_SIZE_Y);

		removeButton = new JButton(REMOVE_BUTTON_NAME);
		removeButton.setBounds(REMOVE_BUTTON_LOCATION_X, REMOVE_BUTTON_LOCATION_Y, REMOVE_BUTTON_SIZE_X,
				REMOVE_BUTTON_SIZE_Y);

		emptyButton = new JButton(EMPTY_BUTTON_NAME);
		emptyButton.setBounds(EMPTY_BUTTON_LOCATION_X, EMPTY_BUTTON_LOCATION_Y, EMPTY_BUTTON_SIZE_X,
				EMPTY_BUTTON_SIZE_Y);
	}

	/**
	 * Frame builder to respond when an action is made on a button
	 * 
	 * @param message
	 * @param iconPath
	 */
	public void dialogFrame(String message, String iconPath) {
		JFrame addFrame = new JFrame(FRAME_TITLE);
		addFrame.setSize(400, 180);
		addFrame.setResizable(false);
		addFrame.setLocationRelativeTo(null);
		addFrame.setVisible(true);

		JLabel l = new JLabel(message, SwingConstants.CENTER);
		addFrame.setLayout(null);
		l.setBounds(100, -40, 200, 200);

		// Icon path
		String imgUrl = iconPath;

		// Layout to insert icon
		GroupLayout layout = new GroupLayout(addFrame);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		JLabel img = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(imgUrl)));
		img.setBounds(20, 10, 100, 100);

		GroupLayout.SequentialGroup group = layout.createSequentialGroup();
		group.addGroup(layout.createParallelGroup().addComponent(img));
		layout.setVerticalGroup(group);
		addFrame.add(l);
	}

	/**
	 * Sub frame that pops when an element is added
	 */
	public void dialogFrameAdd() {
		dialogFrame("Element added succefully", "images/succes.png");
	}

	/**
	 * Sub frame that pops when an element is removed
	 */
	public void dialogFrameRemove() {
		dialogFrame("Element removed succefully", "images/succes.png");
	}

	/**
	 * Sub frame that pops when the stock is emptied
	 */
	public void dialogFrameEmpty() {
		dialogFrame("Stock is now empty", "images/succes.png");

	}

	/**
	 * Sub frame that pops when an error happens
	 */
	public void dialogFrameError() {
		dialogFrame("An error has occured!", "images/failure.png");

	}

	/**
	 * Action to buttons
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		String input = new String();
		int result;

		// When add to stock button is clicked on
		if (source == addButton) {
			try {
				// When an entry was given
				if (addField.getText().length() != 0) {
					input = addField.getText();
					String possibleNumber = input;
					boolean isNumber = Pattern.matches("[0-9]+", possibleNumber);
					// There is a valid quantity
					if (isNumber) {
						result = Integer.parseInt(input);
						if ((result > 0)) {
							try {
								stock.push(result);
								model.setValueAt(result, stock.getMAX() - stock.getTop() - 1, 0);
								// System.out.println("Top : " + stock.getTop());
							} catch (ArrayIndexOutOfBoundsException e) {
								System.out.println("Exception catched in push");
							}
							dialogFrameAdd();
							stock.display();
						} else {
							dialogFrameError();
						}
					} else {
						System.out.println("Enter a valid number!" + "\n");
					}
				} else {
					System.out.println("No entry detected!" + "\n");
				}
			} catch (Exception e) {
				dialogFrameError();
				System.out.println("Stock is full, you cannot add more products! ");
				// e.printStackTrace();
			}
		}
		// When remove from stock button is clicked on
		else if (source == removeButton) {
			try {
				// When an entry was given
				if (removeField.getText().length() != 0) {
					input = removeField.getText();
					String possibleNumber = input;
					boolean isNumber = Pattern.matches("[0-9]+", possibleNumber);
					// There is a valid quantity
					if (isNumber) {
						result = Integer.parseInt(input);
						if ((result <= stock.getTop()+1)) {
							int j = 0;
							while ((j < result)) {
								try {
									stock.pop();
								} catch (ArrayIndexOutOfBoundsException e) {
									e.printStackTrace();
									System.out.println("Exception in pop");
								}
								model.setValueAt(null, stock.getMAX() - stock.getTop() - 2, 0);
								// System.out.println("Top rem : " + stock.getTop());
								j++;
							}
							dialogFrameRemove();
							stock.display();
						} else {
							dialogFrameError();
						}
					} else {
						System.out.println("Enter a valid number!" + "\n");
					}
				} else {
					System.out.println("No entry detected!" + "\n");
				}
			} catch (Exception e) {
				dialogFrameError();
				System.out.println("Stock is empty, there is no product to remove! ");
				// e.printStackTrace();
			}
		}
		// When empty button is clicked on
		else if (source == emptyButton) {
			try {
				stock.clear();
				for (int i = 0; i < stock.getMAX(); i++) {
					model.setValueAt(null, i, 0);
				}
				dialogFrameEmpty();
				stock.display();

			} catch (Exception e) {
				dialogFrameError();
				System.out.println("Stock is already empty! ");
				// e.printStackTrace();
			}
		}
	}

	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
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
}
