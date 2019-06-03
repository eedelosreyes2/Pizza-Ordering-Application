

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


@SuppressWarnings("serial")
public class PizzaWebAppPanel extends JPanel {
	protected PizzaDatabase pd;
	
	public Color white = Color.WHITE;
	public Color black = Color.BLACK;
	public Color lightGray = new Color(235, 235, 235);
	public Color blue = new Color(20, 80, 225);
	public Color red = new Color(250, 10, 10);
	
	protected int width = 1024;
	protected int height = 800;
	protected Dimension pictureDimension = new Dimension(160, 160);
	protected Dimension dialogDimension = new Dimension(width / 5, height / 4);
	
	// menu buttons
	private JButton pizzaButton;
	private JButton chickenButton;
	private JButton sandwichButton;
	private JButton sidesButton;
	private JButton drinksButton;
	private JButton dessertsButton;

	// pizza panel buttons
	private JButton cheeseButton;
	private JButton pepperoniButton;
	private JButton sausageButton;
	private JButton comboButton;
	private JButton vegetarianButton;
	private JButton meatButton;
	
	// add pizza popup
	private JDialog addPizzaDialog;
	private String addPizzaType;
	private JComboBox<String> choosePizzaSize;
	private JComboBox<String> chooseCrust;
	private JComboBox<Object> choosePizzaQuantity;
	private JButton addPizzaButton;

	//chicken panel
	private JButton buffaloButton;
	private JButton buffaloBonelessButton;
	private JButton bbqButton;
	private JButton bbqBonelessButton;
	private JButton jalapenoButton;
	private JButton jalapenoBonelessButton;
	
	// add chicken popup
	private JDialog addChickenDialog;
	private String addChickenType;
	private JComboBox<String> chooseChickenSauce;
	private JComboBox<Object> chooseChickenQuantity;
	private JButton addChickenButton;
	
	// sandwiches panel
	private JButton buffaloSandwichButton;
	private JButton habaneroSandwichButton;
	private JButton pcsSandwichButton;
	private JButton cbrSandwichButton;
	private JButton italianSandwichButton;
	private JButton parmSandwichButton;
	
	// add sandwich popup
	private JDialog addSandwichDialog;
	private String addSandwichType;
	private JComboBox<Object> chooseSandwichQuantity;
	private JButton addSandwichButton;
	
	// sides panel
	private JButton parmTwistsButton;
	private JButton garlicTwistsButton;
	private JButton cheesyBreadButton;
	private JButton jalapenoBreadButton;
	private JButton parmBitesButton;
	private JButton saucesButton;
	private JButton pepperButton;
	private JButton parmButton;
	
	// add sides popup
	private JDialog addSidesDialog;
	private String addSidesType;
	private JComboBox<Object> chooseSidesQuantity;
	private JComboBox<String> chooseSauce;
	private JButton addSideButton;
	
	// drinks panel
	private JButton dasaniButton;
	private JButton spriteButton;
	private JButton cokeButton;
	private JButton cokeDietButton;
	private JButton barqsButton;
	private JButton fantaButton;
	private JButton lemonadeButton;
	private JButton lemonadePinkButton;
	
	// add drinks popup
	private JDialog addDrinksDialog;
	private String addDrinksType;
	private JComboBox<String> chooseDrinkSize;
	private JComboBox<Object> chooseDrinkQuantity;
	private JButton addDrinkButton;
	
	// desserts panel
	private JButton cinnamonBreadTwistsButton;
	private JButton cookieBrownieButton;
	private JButton lavaCakesButton;
	private JButton cookieButton;
	
	// add desserts popup
	private JDialog addDessertsDialog;
	private String addDessertsType;
	private JComboBox<Object> chooseDessertQuantity;
	private JButton addDessertButton;
	
	// cart panel
	private JButton checkoutButton;
	private List<JButton> deleteItemButtons;
	
	// delete item popup
	private JDialog editItemDialog;
	private String editItemType;
	private JButton deleteItemFinalButton;
	private JButton cancelButton;
	
	// checkout popup
	private JDialog checkoutDialog;
	private JButton cancelCheckoutButton;
	private JButton confirmCheckoutButton;
	
	// confirm checkout popup
	private JDialog confirmCheckoutDialog;
	private JButton newOrderButton;
	private JButton exitButton;
	
	// bottom buttons
	protected JButton homeButton;
	protected JButton cartButton;
	
	
	public PizzaWebAppPanel(PizzaDatabase pd) {
		this.pd = pd;
		deleteItemButtons = new ArrayList<JButton>();
		setPreferredSize(new Dimension(width, height));
		setBackground(white);
		setLayout(new BorderLayout());
	}
	
	public void createHomePanels() {
		removeAll();
		
		// blue pizza panel on top
		JPanel topPanel = new JPanel();
		topPanel.setBackground(blue);
		addLabel("Pizza", "Arial", 100, white, topPanel, Component.RIGHT_ALIGNMENT);
		add(topPanel, BorderLayout.NORTH);
		
		// center blank panel
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBackground(white);
		addImage("Home", centerPanel);
		add(centerPanel, BorderLayout.CENTER);
		
		createMenuPanel();
		createBottomPanel();
		repaint();
		revalidate();
	}
	
	public void createMenuPanel() {
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		menuPanel.setBackground(red);
		addLabel("  Menu  ", "Arial", 50, white, menuPanel, Component.CENTER_ALIGNMENT);
		
		// init buttons
		pizzaButton = new JButton("Pizzas");
		chickenButton = new JButton("Chicken");
		sandwichButton = new JButton("Sandwiches");
		sidesButton = new JButton("Sides");
		drinksButton = new JButton("Drinks");
		dessertsButton = new JButton("Desserts");
		
		// add actionlistener per button
		pizzaButton.addActionListener(new ButtonListener());
		chickenButton.addActionListener(new ButtonListener());
		sandwichButton.addActionListener(new ButtonListener());
		sidesButton.addActionListener(new ButtonListener());
		drinksButton.addActionListener(new ButtonListener());
		dessertsButton.addActionListener(new ButtonListener());
		
		// init panels
		JPanel pizzaPanel = new JPanel();
		JPanel chickenPanel = new JPanel();
		JPanel sandwichPanel = new JPanel();
		JPanel sidesPanel = new JPanel();
		JPanel drinksPanel = new JPanel();
		JPanel dessertsPanel = new JPanel();
		JPanel spacePanel = new JPanel();
		
		// set layout per panel
		pizzaPanel.setLayout(new BorderLayout());
		chickenPanel.setLayout(new BorderLayout());
		sandwichPanel.setLayout(new BorderLayout());
		sidesPanel.setLayout(new BorderLayout());
		drinksPanel.setLayout(new BorderLayout());
		dessertsPanel.setLayout(new BorderLayout());
		spacePanel.setLayout(new BorderLayout());
		
		// set bg color per panel
		pizzaPanel.setBackground(red);
		chickenPanel.setBackground(red);
		sandwichPanel.setBackground(red);
		sidesPanel.setBackground(red);
		drinksPanel.setBackground(red);
		dessertsPanel.setBackground(red);
		spacePanel.setBackground(red);
		
		// add buttons to panels
		pizzaPanel.add(pizzaButton);
		chickenPanel.add(chickenButton);
		sandwichPanel.add(sandwichButton);
		sidesPanel.add(sidesButton);
		drinksPanel.add(drinksButton);
		dessertsPanel.add(dessertsButton);
		
		// add all panels
		menuPanel.add(pizzaPanel, BorderLayout.CENTER);
		menuPanel.add(chickenPanel, BorderLayout.CENTER);
		menuPanel.add(sandwichPanel, BorderLayout.CENTER);
		menuPanel.add(sidesPanel, BorderLayout.CENTER);
		menuPanel.add(drinksPanel, BorderLayout.CENTER);
		menuPanel.add(dessertsPanel, BorderLayout.CENTER);
		menuPanel.add(spacePanel, BorderLayout.CENTER);
		add(menuPanel, BorderLayout.WEST);
	}
	
	// item panels helper
	public void createItemPanel(String item) {
		removeAll();
		createMenuPanel();
		createTopPanel(item);
		createMenuPanel();
		createBottomPanel();
		if (item.equals("Pizzas")) {
			createPizzaPanel();
		} if (item.equals("Chicken")) {
			createChickenPanel();
		} if (item.equals("Sandwiches")) {
			createSandwichesPanel();
		} if (item.equals("Sides")) {
			createSidesPanel();
		} if (item.equals("Drinks")) {
			createDrinksPanel();
		} if (item.equals("Desserts")) {
			createDessertsPanel();
		}
		revalidate();
		repaint();
	}
	
	// top panel for item panels
	public void createTopPanel(String item) {
		JPanel topPanel = new JPanel();
		topPanel.setBackground(lightGray);
		addLabel(item, "Arial", 100, blue, topPanel, Component.RIGHT_ALIGNMENT);
		this.add(topPanel, BorderLayout.NORTH);
	}
	
	public void createPizzaPanel() {
		// init pizza panel
		JPanel pizzaPanel = new JPanel();
		pizzaPanel.setLayout(new BorderLayout());
		pizzaPanel.setBackground(white);
		
		// init panels
		JPanel choosePizzaPanel = new JPanel();
		JPanel cheesePizzaPanel = new JPanel();
		JPanel pepperoniPizzaPanel = new JPanel();
		JPanel sausagePizzaPanel = new JPanel();
		JPanel comboPizzaPanel = new JPanel();
		JPanel vegetarianPizzaPanel = new JPanel();
		JPanel meatPizzaPanel = new JPanel();
		
		// set layout per panel
		choosePizzaPanel.setLayout(new GridLayout(3, 2, 25, 15));
		cheesePizzaPanel.setLayout(new BorderLayout());
		pepperoniPizzaPanel.setLayout(new BorderLayout());
		sausagePizzaPanel.setLayout(new BorderLayout());
		comboPizzaPanel.setLayout(new BorderLayout());
		vegetarianPizzaPanel.setLayout(new BorderLayout());
		meatPizzaPanel.setLayout(new BorderLayout());
		
		// set bg color per panel
		choosePizzaPanel.setBackground(white);
		cheesePizzaPanel.setBackground(white);
		pepperoniPizzaPanel.setBackground(white);
		sausagePizzaPanel.setBackground(white);
		comboPizzaPanel.setBackground(white);
		vegetarianPizzaPanel.setBackground(white);
		meatPizzaPanel.setBackground(white);
		
		// init image panels
		JPanel cheesePicturePanel = new JPanel();
		JPanel pepperoniPicturePanel = new JPanel();
		JPanel sausagePicturePanel = new JPanel();
		JPanel comboPicturePanel = new JPanel();
		JPanel vegetarianPicturePanel = new JPanel();
		JPanel meatPicturePanel = new JPanel();
		
		// layout per picture panels
		cheesePicturePanel.setLayout(new BorderLayout());
		pepperoniPicturePanel.setLayout(new BorderLayout());
		sausagePicturePanel.setLayout(new BorderLayout());
		comboPicturePanel.setLayout(new BorderLayout());
		vegetarianPicturePanel.setLayout(new BorderLayout());
		meatPicturePanel.setLayout(new BorderLayout());
		
		// set bg color per picture panel
		cheesePicturePanel.setBackground(white);
		pepperoniPicturePanel.setBackground(white);
		sausagePicturePanel.setBackground(white);
		comboPicturePanel.setBackground(white);
		vegetarianPicturePanel.setBackground(white);
		meatPicturePanel.setBackground(white);
		
		// set dimension per panel
		cheesePicturePanel.setPreferredSize(pictureDimension);
		pepperoniPicturePanel.setPreferredSize(pictureDimension);
		sausagePicturePanel.setPreferredSize(pictureDimension);
		comboPicturePanel.setPreferredSize(pictureDimension);
		vegetarianPicturePanel.setPreferredSize(pictureDimension);
		meatPicturePanel.setPreferredSize(pictureDimension);
		
		// add image per panel
		addImage("Cheese Pizza", cheesePicturePanel);
		addImage("Pepperoni Pizza", pepperoniPicturePanel);
		addImage("Sausage Pizza", sausagePicturePanel);
		addImage("Combo Pizza", comboPicturePanel);
		addImage("Vegetarian Pizza", vegetarianPicturePanel);
		addImage("Meat Pizza", meatPicturePanel);
		
		// add picture panels to panels
		cheesePizzaPanel.add(cheesePicturePanel, BorderLayout.WEST);
		pepperoniPizzaPanel.add(pepperoniPicturePanel, BorderLayout.WEST);
		sausagePizzaPanel.add(sausagePicturePanel, BorderLayout.WEST);
		comboPizzaPanel.add(comboPicturePanel, BorderLayout.WEST);
		vegetarianPizzaPanel.add(vegetarianPicturePanel, BorderLayout.WEST);
		meatPizzaPanel.add(meatPicturePanel, BorderLayout.WEST);
		
		// add label per panel
		cheesePizzaPanel.add(new JLabel("<html>Provolone, Parmesan-Asiago and cheese made "
				+ "with 100% real mozzarella features a crispy crust with a soft, tender inside "
				+ "that’s smothered with herb-flavored sauce.</html>"), BorderLayout.SOUTH);
		pepperoniPizzaPanel.add(new JLabel("<html>Two layers of pepperoni sandwiched between "
				+ "provolone, Parmesan-Asiago and cheese made with 100% real mozzarella "
				+ "then sprinkled with oregano.</html>"), BorderLayout.SOUTH);
		sausagePizzaPanel.add(new JLabel("<html>Italian sausage sandwiched between provolone, "
				+ "Parmesan-Asiago and cheese made with 100% real mozzarella.</html>"), BorderLayout.SOUTH);
		comboPizzaPanel.add(new JLabel("<html>Pepperoni, ham, Italian sausage, beef, fresh onions, "
				+ "fresh green peppers, fresh mushrooms and black olives, all "
				+ "between two layers of mozzarella cheese.</html>"), BorderLayout.SOUTH);
		vegetarianPizzaPanel.add(new JLabel("<html>Roasted red peppers, fresh baby spinach, "
				+ "fresh onions, fresh mushrooms, tomatoes, black olives, feta, provolone, "
				+ "mozzarella cheese and garlic herb seasoning.</html>"), BorderLayout.SOUTH);
		meatPizzaPanel.add(new JLabel("<html>Pepperoni, ham, Italian sausage and beef, "
				+ "all sandwiched between two layers of cheese made with 100% real "
				+ "mozzarella.</html>"), BorderLayout.SOUTH);
		
		// init buttons
		cheeseButton = new JButton("Cheese Pizza");
		pepperoniButton = new JButton("Pepperoni Pizza");
		sausageButton = new JButton("Sausage Pizza");
		comboButton = new JButton("Combo Pizza");
		vegetarianButton = new JButton("Vegetarian Pizza");
		meatButton = new JButton("Meat Pizza");
		
		// add actionlistener per button
		cheeseButton.addActionListener(new ButtonListener());
		pepperoniButton.addActionListener(new ButtonListener());
		sausageButton.addActionListener(new ButtonListener());
		comboButton.addActionListener(new ButtonListener());
		vegetarianButton.addActionListener(new ButtonListener());
		meatButton.addActionListener(new ButtonListener());
		
		// add buttons to panels
		cheesePizzaPanel.add(cheeseButton);
		pepperoniPizzaPanel.add(pepperoniButton);
		sausagePizzaPanel.add(sausageButton);
		comboPizzaPanel.add(comboButton);
		vegetarianPizzaPanel.add(vegetarianButton);
		meatPizzaPanel.add(meatButton);
		
		// add all panels
		choosePizzaPanel.add(cheesePizzaPanel);
		choosePizzaPanel.add(pepperoniPizzaPanel);
		choosePizzaPanel.add(sausagePizzaPanel);
		choosePizzaPanel.add(comboPizzaPanel);
		choosePizzaPanel.add(vegetarianPizzaPanel);
		choosePizzaPanel.add(meatPizzaPanel);
		pizzaPanel.add(choosePizzaPanel);
		add(pizzaPanel);		
	}

	public void addPizzaPopup(JButton button, String pizza) {
		addPizzaType = pizza;
		
		// init dialog
		addPizzaDialog = new JDialog();
		addPizzaDialog.setTitle("Add Pizza");
		addPizzaDialog.setLocationRelativeTo(button);
		addPizzaDialog.setPreferredSize(dialogDimension);
		addPizzaDialog.setResizable(false);
		addPizzaDialog.setModal(true);
		
		// init panel
		JPanel addPizzaPanel = new JPanel();
		addPizzaPanel.setLayout(new BoxLayout(addPizzaPanel, BoxLayout.Y_AXIS));
		addPizzaPanel.setBackground(blue);
		
		// init size combobox
		choosePizzaSize = new JComboBox<String>();
		choosePizzaSize.addItem("<choose size>");
		choosePizzaSize.addItem("Small");
		choosePizzaSize.addItem("Medium");
		choosePizzaSize.addItem("Large");
		choosePizzaSize.addItem("Extra Large");
		
		// init crust combobox
		chooseCrust = new JComboBox<String>();
		chooseCrust.addItem("<choose crust>");
		chooseCrust.addItem("Normal");
		chooseCrust.addItem("Thin");
		chooseCrust.addItem("Pan");
		chooseCrust.addItem("Brooklyn");
		
		// init quantity combobox
		choosePizzaQuantity = new JComboBox<Object>();
		choosePizzaQuantity.addItem("<choose quantity>");
		choosePizzaQuantity.addItem(1);
		choosePizzaQuantity.addItem(2);
		choosePizzaQuantity.addItem(3);
		choosePizzaQuantity.addItem(4);
		choosePizzaQuantity.addItem(5);
		choosePizzaQuantity.addItem(6);
		choosePizzaQuantity.addItem(7);
		choosePizzaQuantity.addItem(8);
		choosePizzaQuantity.addItem(9);
		choosePizzaQuantity.addItem(10);
		
		// add all comboboxes
		addPizzaPanel.add(choosePizzaSize);
		addPizzaPanel.add(chooseCrust);
		addPizzaPanel.add(choosePizzaQuantity);
		addPizzaPanel.add(Box.createVerticalGlue());
		addPizzaPanel.add(Box.createVerticalGlue());
		
		// init button
		addPizzaButton = new JButton("Add to Cart");
		addPizzaButton.addActionListener(new ButtonListener());
		addPizzaPanel.add(addPizzaButton);
		
		// finalize
		addPizzaDialog.add(addPizzaPanel);
		addPizzaDialog.pack();
		addPizzaDialog.setVisible(true);
	}
	
	public void createChickenPanel() {
		// init chicken panel
		JPanel chickenPanel = new JPanel();
		chickenPanel.setLayout(new BorderLayout());
		chickenPanel.setBackground(white);
		
		// init panels
		JPanel chooseChickenPanel = new JPanel();
		JPanel buffaloPanel = new JPanel();
		JPanel buffaloBonelessPanel = new JPanel();
		JPanel bbqPanel = new JPanel();
		JPanel bbqBonelessPanel = new JPanel();
		JPanel jalapenoPanel = new JPanel();
		JPanel jalapenoBonelessPanel = new JPanel();
		
		// set layout per panel
		chooseChickenPanel.setLayout(new GridLayout(3, 2, 25, 15));
		buffaloPanel.setLayout(new BorderLayout());
		buffaloBonelessPanel.setLayout(new BorderLayout());
		bbqPanel.setLayout(new BorderLayout());
		bbqBonelessPanel.setLayout(new BorderLayout());
		jalapenoPanel.setLayout(new BorderLayout());
		jalapenoBonelessPanel.setLayout(new BorderLayout());
		
		// set bg color per panel
		chooseChickenPanel.setBackground(white);
		buffaloPanel.setBackground(white);
		buffaloBonelessPanel.setBackground(white);
		bbqPanel.setBackground(white);
		bbqBonelessPanel.setBackground(white);
		jalapenoPanel.setBackground(white);
		jalapenoBonelessPanel.setBackground(white);
		
		// add label per panel
		buffaloPanel.add(new JLabel("<html>Tender wings with bones of lightly "
				+ "breaded, 100% whole breast white meat chicken, topped with "
				+ "classic hot buffalo sauce.</html>"), BorderLayout.SOUTH);
		buffaloBonelessPanel.add(new JLabel("<html>Tender bites of lightly "
				+ "breaded, 100% whole breast white meat chicken, topped with "
				+ "classic hot buffalo sauce.</html>"), BorderLayout.SOUTH);
		bbqPanel.add(new JLabel("<html>Tender wings with bones of lightly breaded, "
				+ "100% whole breast white meat chicken, topped with sweet and smoky "
				+ "BBQ sauce.</html>"), BorderLayout.SOUTH);
		bbqBonelessPanel.add(new JLabel("<html>Tender bites of lightly breaded, 100% "
				+ "whole breast white meat chicken, topped with sweet and smoky BBQ "
				+ "sauce.</html>"), BorderLayout.SOUTH);
		jalapenoPanel.add(new JLabel("<html>Tender wings with bones of lightly "
				+ "breaded, 100% whole breast white meat chicken, "
				+ "topped with cheese and jalapeño.</html>"), BorderLayout.SOUTH);
		jalapenoBonelessPanel.add(new JLabel("<html>Tender bites of lightly "
				+ "breaded, 100% whole breast white meat chicken, "
				+ "topped with cheese and jalapeño.</html>"), BorderLayout.SOUTH);
		
		// init buttons
		buffaloButton = new JButton("Buffalo Chicken Wings");
		buffaloBonelessButton = new JButton("Buffalo Boneless Chicken Wings");
		bbqButton = new JButton("BBQ Chicken Wings");
		bbqBonelessButton = new JButton("BBQ Boneless Chicken Wings");
		jalapenoButton = new JButton("Jalapeño Chicken Wings");
		jalapenoBonelessButton = new JButton("Jalapeño Boneless Chicken Wings");
		
		// add actionlistener per button
		buffaloButton.addActionListener(new ButtonListener());
		buffaloBonelessButton.addActionListener(new ButtonListener());
		bbqButton.addActionListener(new ButtonListener());
		bbqBonelessButton.addActionListener(new ButtonListener());
		jalapenoButton.addActionListener(new ButtonListener());
		jalapenoBonelessButton.addActionListener(new ButtonListener());
		
		// add all buttons
		buffaloPanel.add(buffaloButton);
		buffaloBonelessPanel.add(buffaloBonelessButton);
		bbqPanel.add(bbqButton);
		bbqBonelessPanel.add(bbqBonelessButton);
		jalapenoPanel.add(jalapenoButton);
		jalapenoBonelessPanel.add(jalapenoBonelessButton);
		
		// add image per panel
		addImage("Buffalo Chicken Wings", buffaloPanel);
		addImage("Buffalo Boneless Chicken Wings", buffaloBonelessPanel);
		addImage("BBQ Chicken Wings", bbqPanel);
		addImage("BBQ Boneless Chicken Wings", bbqBonelessPanel);
		addImage("Jalapeño Chicken Wings", jalapenoPanel);
		addImage("Jalapeño Boneless Chicken Wings", jalapenoBonelessPanel);
		
		// add all panels
		chooseChickenPanel.add(buffaloPanel);
		chooseChickenPanel.add(buffaloBonelessPanel);
		chooseChickenPanel.add(bbqPanel);
		chooseChickenPanel.add(bbqBonelessPanel);
		chooseChickenPanel.add(jalapenoPanel);
		chooseChickenPanel.add(jalapenoBonelessPanel);
		chickenPanel.add(chooseChickenPanel);
		add(chickenPanel);
	}

	public void addChickenPopup(JButton button, String chicken) {
		addChickenType = chicken;
		
		// init dialog
		addChickenDialog = new JDialog();
		addChickenDialog.setTitle("Add Chicken");
		addChickenDialog.setLocationRelativeTo(button);
		addChickenDialog.setPreferredSize(dialogDimension);
		addChickenDialog.setResizable(false);
		addChickenDialog.setModal(true);
		
		// init panel
		JPanel addChickenPanel = new JPanel();
		addChickenPanel.setLayout(new BoxLayout(addChickenPanel, BoxLayout.Y_AXIS));
		addChickenPanel.setBackground(blue);
		
		// init sauce combobox
		chooseChickenSauce = new JComboBox<String>();
		chooseChickenSauce.addItem("<choose sauce (1)>");
		chooseChickenSauce.addItem("Ranch Sauce");
		chooseChickenSauce.addItem("BBQ Sauce");
		chooseChickenSauce.addItem("Spicy Sauce");
		chooseChickenSauce.addItem("Marinara Sauce");
		chooseChickenSauce.addItem("Garlic Sauce");
		chooseChickenSauce.addItem("Mango Habanero Sauce");
		
		// init quantity combobox
		chooseChickenQuantity = new JComboBox<Object>();
		chooseChickenQuantity.addItem("<choose piece>");
		chooseChickenQuantity.addItem("6");
		chooseChickenQuantity.addItem("12");
		chooseChickenQuantity.addItem("18");
		chooseChickenQuantity.addItem("24");
		
		// add comboboxes
		addChickenPanel.add(chooseChickenQuantity);
		addChickenPanel.add(chooseChickenSauce);
		addChickenPanel.add(Box.createVerticalGlue());
		addChickenPanel.add(Box.createVerticalGlue());
		
		// init button
		addChickenButton = new JButton("Add to Cart");
		addChickenButton.addActionListener(new ButtonListener());
		addChickenPanel.add(addChickenButton);
		
		// finalize
		addChickenDialog.add(addChickenPanel);
		addChickenDialog.pack();
		addChickenDialog.setVisible(true);
	}
	
	public void createSandwichesPanel() {
		// init sandwich panel
		JPanel sandwichesPanel = new JPanel();
		sandwichesPanel.setLayout(new BorderLayout());
		sandwichesPanel.setBackground(white);
		
		// init panels
		JPanel chooseSandwichesPanel = new JPanel();
		JPanel buffaloSandwichPanel = new JPanel();
		JPanel habaneroSandwichPanel = new JPanel();
		JPanel pcsSandwichPanel = new JPanel();
		JPanel cbrSandwichPanel = new JPanel();
		JPanel italianSandwichPanel = new JPanel();
		JPanel parmSandwichPanel = new JPanel();
		
		// set layout per panel
		chooseSandwichesPanel.setLayout(new GridLayout(3, 2, 25, 15));
		buffaloSandwichPanel.setLayout(new BorderLayout());
		habaneroSandwichPanel.setLayout(new BorderLayout());
		pcsSandwichPanel.setLayout(new BorderLayout());
		cbrSandwichPanel.setLayout(new BorderLayout());
		italianSandwichPanel.setLayout(new BorderLayout());
		parmSandwichPanel.setLayout(new BorderLayout());
		
		// set bg color per panel
		chooseSandwichesPanel.setBackground(white);
		buffaloSandwichPanel.setBackground(white);
		habaneroSandwichPanel.setBackground(white);
		pcsSandwichPanel.setBackground(white);
		cbrSandwichPanel.setBackground(white);
		italianSandwichPanel.setBackground(white);
		parmSandwichPanel.setBackground(white);
		
		// add label per panel
		buffaloSandwichPanel.add(new JLabel("<html>Grilled chicken breast, creamy blue cheese sauce, "
				+ "fresh onions, hot sauce, cheddar and provolone cheeses. On artisan bread and "
				+ "baked to a golden brown.</html>"), BorderLayout.SOUTH);
		habaneroSandwichPanel.add(new JLabel("<html>Grilled chicken breast, pineapple, jalapeños, "
				+ "sweet mango habanero sauce, provolone and cheddar cheeses. On artisan bread "
				+ "and baked to a golden brown.</html>"), BorderLayout.SOUTH);
		pcsSandwichPanel.add(new JLabel("<html>Tender slices of steak, American and provolone cheeses, "
				+ "fresh onions, fresh green peppers and fresh mushrooms placed on baked artisan "
				+ "bread.</html>"), BorderLayout.SOUTH);
		cbrSandwichPanel.add(new JLabel("<html>Enjoy our flavorful grilled chicken breast topped with "
				+ "smoked bacon, creamy ranch and provolone cheese on artisan bread baked to golden brown "
				+ "perfection.</html>"), BorderLayout.SOUTH);
		italianSandwichPanel.add(new JLabel("<html>Pepperoni, salami, and ham topped with banana "
				+ "peppers, fresh green peppers, fresh onions, and provolone cheese. On artisan bread "
				+ "and baked to a golden brown.</html>"), BorderLayout.SOUTH);
		parmSandwichPanel.add(new JLabel("<html>Grilled chicken breast, tomato basil marinara, "
				+ "Parmesan-Asiago and provolone cheese. On artisan bread and baked to a "
				+ "golden brown.</html>"), BorderLayout.SOUTH);
		
		// init buttons
		buffaloSandwichButton = new JButton("Buffalo Chicken Sandwich");
		habaneroSandwichButton = new JButton("Chicken Habanero Sandwich");
		pcsSandwichButton = new JButton("Philly Cheese Steak Sandwich");
		cbrSandwichButton = new JButton("Chicken Bacon Ranch Sandwich");
		italianSandwichButton = new JButton("Italian Sandwhich");
		parmSandwichButton = new JButton("Chicken Parm Sandwich");
		
		// add actionlistener per button
		buffaloSandwichButton.addActionListener(new ButtonListener());
		habaneroSandwichButton.addActionListener(new ButtonListener());
		pcsSandwichButton.addActionListener(new ButtonListener());
		cbrSandwichButton.addActionListener(new ButtonListener());
		italianSandwichButton.addActionListener(new ButtonListener());
		parmSandwichButton.addActionListener(new ButtonListener());
		
		// add panels
		buffaloSandwichPanel.add(buffaloSandwichButton);
		habaneroSandwichPanel.add(habaneroSandwichButton);
		pcsSandwichPanel.add(pcsSandwichButton);
		cbrSandwichPanel.add(cbrSandwichButton);
		italianSandwichPanel.add(italianSandwichButton);
		parmSandwichPanel.add(parmSandwichButton);
		
		// add image per panel
		addImage("Buffalo Chicken Sandwich", buffaloSandwichPanel);
		addImage("Chicken Habanero Sandwich", habaneroSandwichPanel);
		addImage("Philly Cheese Steak Sandwich", pcsSandwichPanel);
		addImage("Chicken Bacon Ranch Sandwich", cbrSandwichPanel);
		addImage("Italian Sandwich", italianSandwichPanel);
		addImage("Chicken Parm Sandwich", parmSandwichPanel);
		
		// add all panels
		chooseSandwichesPanel.add(buffaloSandwichPanel);
		chooseSandwichesPanel.add(habaneroSandwichPanel);
		chooseSandwichesPanel.add(pcsSandwichPanel);
		chooseSandwichesPanel.add(cbrSandwichPanel);
		chooseSandwichesPanel.add(italianSandwichPanel);
		chooseSandwichesPanel.add(parmSandwichPanel);
		sandwichesPanel.add(chooseSandwichesPanel);
		add(sandwichesPanel);
	}

	public void addSandwichPopup(JButton button, String sandwich) {
		addSandwichType = sandwich;
		
		// init dialog
		addSandwichDialog = new JDialog();
		addSandwichDialog.setTitle("Add Sandwich");
		addSandwichDialog.setLocationRelativeTo(button);
		addSandwichDialog.setPreferredSize(dialogDimension);
		addSandwichDialog.setResizable(false);
		addSandwichDialog.setModal(true);
		
		// init panel
		JPanel addSandwichPanel = new JPanel();
		addSandwichPanel.setLayout(new BoxLayout(addSandwichPanel, BoxLayout.Y_AXIS));
		addSandwichPanel.setBackground(blue);
		
		// init quantity combobox
		chooseSandwichQuantity = new JComboBox<Object>();
		chooseSandwichQuantity.addItem("<choose quantity>");
		chooseSandwichQuantity.addItem(1);
		chooseSandwichQuantity.addItem(2);
		chooseSandwichQuantity.addItem(3);
		chooseSandwichQuantity.addItem(4);
		chooseSandwichQuantity.addItem(5);
		chooseSandwichQuantity.addItem(6);
		chooseSandwichQuantity.addItem(7);
		chooseSandwichQuantity.addItem(8);
		chooseSandwichQuantity.addItem(9);
		chooseSandwichQuantity.addItem(10);
		
		// add comboboxes
		addSandwichPanel.add(chooseSandwichQuantity);
		addSandwichPanel.add(Box.createVerticalGlue());
		addSandwichPanel.add(Box.createVerticalGlue());
		
		// init button
		addSandwichButton = new JButton("Add to Cart");
		addSandwichButton.addActionListener(new ButtonListener());
		addSandwichPanel.add(addSandwichButton);
		
		// finalize
		addSandwichDialog.add(addSandwichPanel);
		addSandwichDialog.pack();
		addSandwichDialog.setVisible(true);
	}
	
	public void createSidesPanel() {
		// init sides panel
		JPanel sidesPanel = new JPanel();
		sidesPanel.setLayout(new BorderLayout());
		sidesPanel.setBackground(white);
		
		// init panels
		JPanel chooseSidesPanel = new JPanel();
		JPanel parmTwistsPanel = new JPanel();
		JPanel garlicTwistsPanel = new JPanel();
		JPanel cheesyBreadPanel = new JPanel();
		JPanel jalapenoBreadPanel = new JPanel();
		JPanel parmBitesPanel = new JPanel();
		JPanel saucesPanel = new JPanel();
		JPanel pepperPanel = new JPanel();
		JPanel parmPanel = new JPanel();
		
		// set layout per panel
		chooseSidesPanel.setLayout(new GridLayout(4, 2, 25, 15));
		parmTwistsPanel.setLayout(new BorderLayout());
		garlicTwistsPanel.setLayout(new BorderLayout());
		cheesyBreadPanel.setLayout(new BorderLayout());
		jalapenoBreadPanel.setLayout(new BorderLayout());
		parmBitesPanel.setLayout(new BorderLayout());
		saucesPanel.setLayout(new BorderLayout());
		pepperPanel.setLayout(new BorderLayout());
		parmPanel.setLayout(new BorderLayout());
		
		// set bg color per panel
		chooseSidesPanel.setBackground(white);
		parmTwistsPanel.setBackground(white);
		garlicTwistsPanel.setBackground(white);
		cheesyBreadPanel.setBackground(white);
		jalapenoBreadPanel.setBackground(white);
		parmBitesPanel.setBackground(white);
		saucesPanel.setBackground(white);
		pepperPanel.setBackground(white);
		parmPanel.setBackground(white);
		
		// add label per panel
		parmTwistsPanel.add(new JLabel("<html>Handmade from fresh buttery-tasting "
				+ "dough and baked to a golden brown. Drizzled with garlic and "
				+ "Parmesan cheese seasoning, and sprinkled with more Parmesan."
				+ "</html>"), BorderLayout.SOUTH);
		garlicTwistsPanel.add(new JLabel("<html>Handmade from fresh buttery-tasting "
				+ "dough and baked to a golden brown. Drizzled with buttery garlic and "
				+ "Parmesan cheese seasoning.</html>"), BorderLayout.SOUTH);
		cheesyBreadPanel.add(new JLabel("<html>Oven-baked breadsticks generously stuffed "
				+ "and covered with a blend of 100% real mozzarella and cheddar cheeses "
				+ "then seasoned with a touch of garlic.</html>"), BorderLayout.SOUTH);
		jalapenoBreadPanel.add(new JLabel("<html>Breadsticks generously stuffed with cheese "
				+ "& jalapeno peppers, covered with a blend of mozzarella and cheddar "
				+ "cheeses then seasoned with a touch of garlic.</html>"), BorderLayout.SOUTH);
		parmBitesPanel.add(new JLabel("<html>Oven-baked bread bites handmade from fresh "
				+ "buttery-tasting dough and seasoned with garlic and Parmesan."
				+ "</html>"), BorderLayout.SOUTH);
		saucesPanel.add(new JLabel("<html>Choose from a variety of sauces including: Ranch, "
				+ "BBQ, Spicy, Marinara, Garlic, & Mango Habanero."
				+ "</html>"), BorderLayout.SOUTH);
		
		// init buttons
		parmTwistsButton = new JButton("Parmesan Bread Twists");
		garlicTwistsButton = new JButton("Garlic Bread Twists");
		cheesyBreadButton = new JButton("Stuffed Cheesy Bread");
		jalapenoBreadButton = new JButton("Stuffed Jalapeño Cheesy Bread");
		parmBitesButton = new JButton("Parmesan Bread Bites");
		saucesButton = new JButton("Sauces");
		pepperButton = new JButton("Pepper Packets");
		parmButton = new JButton("Parmesan Packets");
		
		// add actionlistener per panel
		parmTwistsButton.addActionListener(new ButtonListener());
		garlicTwistsButton.addActionListener(new ButtonListener());
		cheesyBreadButton.addActionListener(new ButtonListener());
		jalapenoBreadButton.addActionListener(new ButtonListener());
		parmBitesButton.addActionListener(new ButtonListener());
		saucesButton.addActionListener(new ButtonListener());
		pepperButton.addActionListener(new ButtonListener());
		parmButton.addActionListener(new ButtonListener());
		
		// add buttons
		parmTwistsPanel.add(parmTwistsButton);
		garlicTwistsPanel.add(garlicTwistsButton);
		cheesyBreadPanel.add(cheesyBreadButton);
		jalapenoBreadPanel.add(jalapenoBreadButton);
		parmBitesPanel.add(parmBitesButton);
		saucesPanel.add(saucesButton);
		pepperPanel.add(pepperButton);
		parmPanel.add(parmButton);
		
		// add image per panel
		addImage("Parmesan Bread Twists", parmTwistsPanel);
		addImage("Garlic Bread Twists", garlicTwistsPanel);
		addImage("Stuffed Cheesy Bread", cheesyBreadPanel);
		addImage("Stuffed Jalapeño Cheesy Bread", jalapenoBreadPanel);
		addImage("Parmesan Bread Bites", parmBitesPanel);
		addImage("Sauce", saucesPanel);
		addImage("Crushed Red Pepper Packets", pepperPanel);
		addImage("Crushed Parmesan Cheese Packets", parmPanel);
		
		// add panels
		chooseSidesPanel.add(parmTwistsPanel);
		chooseSidesPanel.add(garlicTwistsPanel);
		chooseSidesPanel.add(cheesyBreadPanel);
		chooseSidesPanel.add(jalapenoBreadPanel);
		chooseSidesPanel.add(parmBitesPanel);
		chooseSidesPanel.add(saucesPanel);
		chooseSidesPanel.add(pepperPanel);
		chooseSidesPanel.add(parmPanel);
		sidesPanel.add(chooseSidesPanel);
		add(sidesPanel);
	}
	
	public void addSidesPopup(JButton button, String side) {
		addSidesType = side;
		
		// init dialog
		addSidesDialog = new JDialog();
		addSidesDialog.setTitle("Add Side");
		addSidesDialog.setLocationRelativeTo(button);
		addSidesDialog.setPreferredSize(dialogDimension);
		addSidesDialog.setResizable(false);
		addSidesDialog.setModal(true);
		
		// init panel
		JPanel addSidesPanel = new JPanel();
		addSidesPanel.setLayout(new BoxLayout(addSidesPanel, BoxLayout.Y_AXIS));
		addSidesPanel.setBackground(blue);
		
		// init quantity combobox
		// init sauce combobox as needed
		chooseSidesQuantity = new JComboBox<Object>();
		chooseSidesQuantity.addItem("<choose quantity>");
		
		if (addSidesType.contains("Twists")) {
			chooseSidesQuantity.addItem(6);
			chooseSidesQuantity.addItem(12);
			
			chooseSauce = new JComboBox<String>();
			chooseSauce.addItem("<choose sauce (1)>");
			chooseSauce.addItem("Ranch Sauce");
			chooseSauce.addItem("BBQ Sauce");
			chooseSauce.addItem("Spicy Sauce");
			chooseSauce.addItem("Marinara Sauce");
			chooseSauce.addItem("Garlic Sauce");
			chooseSauce.addItem("Mango Habanero Sauce");
			
			addSidesPanel.add(chooseSidesQuantity);
			addSidesPanel.add(chooseSauce);
		} if (addSidesType.contains("Stuffed")) {
			chooseSidesQuantity.addItem(1);
			chooseSidesQuantity.addItem(2);
			chooseSidesQuantity.addItem(3);
			chooseSidesQuantity.addItem(4);
			chooseSidesQuantity.addItem(5);
			
			chooseSauce = new JComboBox<String>();
			chooseSauce.addItem("<choose sauce (1)>");
			chooseSauce.addItem("Ranch Sauce");
			chooseSauce.addItem("BBQ Sauce");
			chooseSauce.addItem("Spicy Sauce");
			chooseSauce.addItem("Marinara Sauce");
			chooseSauce.addItem("Garlic Sauce");
			chooseSauce.addItem("Mango Habanero Sauce");
			
			addSidesPanel.add(chooseSidesQuantity);
			addSidesPanel.add(chooseSauce);
		} if (addSidesType.equals("Parmesan Bread Bites")) {
			chooseSidesQuantity.addItem(8);
			chooseSidesQuantity.addItem(16);
			chooseSidesQuantity.addItem(24);
			
			chooseSauce = new JComboBox<String>();
			chooseSauce.addItem("<choose sauce (1)>");
			chooseSauce.addItem("Ranch Sauce");
			chooseSauce.addItem("BBQ Sauce");
			chooseSauce.addItem("Spicy Sauce");
			chooseSauce.addItem("Marinara Sauce");
			chooseSauce.addItem("Garlic Sauce");
			chooseSauce.addItem("Mango Habanero Sauce");
			
			addSidesPanel.add(chooseSidesQuantity);
			addSidesPanel.add(chooseSauce);
		} if (addSidesType.equals("Sauces")) {
			chooseSauce = new JComboBox<String>();
			chooseSauce.addItem("<choose Sauce>");
			chooseSauce.addItem("Ranch Sauce");
			chooseSauce.addItem("BBQ Sauce");
			chooseSauce.addItem("Spicy Sauce");
			chooseSauce.addItem("Marinara Sauce");
			chooseSauce.addItem("Garlic Sauce");
			chooseSauce.addItem("Mango Habanero Sauce");
			
			chooseSidesQuantity.addItem(1);
			chooseSidesQuantity.addItem(2);
			chooseSidesQuantity.addItem(3);
			chooseSidesQuantity.addItem(4);
			chooseSidesQuantity.addItem(5);
			chooseSidesQuantity.addItem(6);
			chooseSidesQuantity.addItem(7);
			chooseSidesQuantity.addItem(8);
			chooseSidesQuantity.addItem(9);
			chooseSidesQuantity.addItem(10);
			
			addSidesPanel.add(chooseSauce);
			addSidesPanel.add(chooseSidesQuantity);
		} if (addSidesType.contains("Packet")) {
			chooseSidesQuantity.addItem(1);
			chooseSidesQuantity.addItem(2);
			chooseSidesQuantity.addItem(3);
			chooseSidesQuantity.addItem(4);
			chooseSidesQuantity.addItem(5);
			chooseSidesQuantity.addItem(6);
			chooseSidesQuantity.addItem(7);
			chooseSidesQuantity.addItem(8);
			chooseSidesQuantity.addItem(9);
			chooseSidesQuantity.addItem(10);
			
			addSidesPanel.add(chooseSidesQuantity);
		}
		
		addSidesPanel.add(Box.createVerticalGlue());
		addSidesPanel.add(Box.createVerticalGlue());
		
		// add button
		addSideButton = new JButton("Add");
		addSideButton.addActionListener(new ButtonListener());
		addSidesPanel.add(addSideButton);
		
		// finalize
		addSidesDialog.add(addSidesPanel);
		addSidesDialog.pack();
		addSidesDialog.setVisible(true);
	}
	
	public void createDrinksPanel() {
		// init drinks panel
		JPanel drinksPanel = new JPanel();
		drinksPanel.setLayout(new GridLayout(4, 2, 25, 15));
		drinksPanel.setBackground(white);
		
		// init panels
		JPanel dasaniPanel = new JPanel();
		JPanel spritePanel = new JPanel();
		JPanel cokePanel = new JPanel();
		JPanel cokeDietPanel = new JPanel();
		JPanel barqsPanel = new JPanel();
		JPanel fantaPanel = new JPanel();
		JPanel lemonadePanel = new JPanel();
		JPanel lemonadePinkPanel = new JPanel();
		
		// set layout per panel
		dasaniPanel.setLayout(new BorderLayout());
		spritePanel.setLayout(new BorderLayout());
		cokePanel.setLayout(new BorderLayout());
		cokeDietPanel.setLayout(new BorderLayout());
		barqsPanel.setLayout(new BorderLayout());
		fantaPanel.setLayout(new BorderLayout());
		lemonadePanel.setLayout(new BorderLayout());
		lemonadePinkPanel.setLayout(new BorderLayout());
		
		// set bg color per panel
		dasaniPanel.setBackground(white);
		spritePanel.setBackground(white);
		cokePanel.setBackground(white);
		cokeDietPanel.setBackground(white);
		barqsPanel.setBackground(white);
		fantaPanel.setBackground(white);
		lemonadePanel.setBackground(white);
		lemonadePinkPanel.setBackground(white);
		
		// init buttons
		dasaniButton = new JButton("Dasani");
		spriteButton = new JButton("Sprite");
		cokeButton = new JButton("Coke");
		cokeDietButton = new JButton("Diet Coke");
		barqsButton = new JButton("Barq's Root Beer");
		fantaButton = new JButton("Fanta");
		lemonadeButton = new JButton("Minute Maid Lemonade");
		lemonadePinkButton = new JButton("Minute Maid Pink Lemonade");
		
		// add actionlistener per button
		dasaniButton.addActionListener(new ButtonListener());
		spriteButton.addActionListener(new ButtonListener());
		cokeButton.addActionListener(new ButtonListener());
		cokeDietButton.addActionListener(new ButtonListener());
		barqsButton.addActionListener(new ButtonListener());
		fantaButton.addActionListener(new ButtonListener());
		lemonadeButton.addActionListener(new ButtonListener());
		lemonadePinkButton.addActionListener(new ButtonListener());
		
		// add buttons
		dasaniPanel.add(dasaniButton);
		spritePanel.add(spriteButton);
		cokePanel.add(cokeButton);
		cokeDietPanel.add(cokeDietButton);
		barqsPanel.add(barqsButton);
		fantaPanel.add(fantaButton);
		lemonadePanel.add(lemonadeButton);
		lemonadePinkPanel.add(lemonadePinkButton);
		
		// add image per panel
		addImage("Dasani", dasaniPanel);
		addImage("Sprite", spritePanel);
		addImage("Coke", cokePanel);
		addImage("Diet Coke", cokeDietPanel);
		addImage("Barq's Root Beer", barqsPanel);
		addImage("Fanta", fantaPanel);
		addImage("Lemonade", lemonadePanel);
		addImage("Pink Lemonade", lemonadePinkPanel);
		
		// add panels
		drinksPanel.add(dasaniPanel);
		drinksPanel.add(spritePanel);
		drinksPanel.add(cokePanel);
		drinksPanel.add(cokeDietPanel);
		drinksPanel.add(barqsPanel);
		drinksPanel.add(fantaPanel);
		drinksPanel.add(lemonadePanel);
		drinksPanel.add(lemonadePinkPanel);
		add(drinksPanel);
	}
	
	public void addDrinksPopup(JButton button, String drink) {
		addDrinksType = drink;
		
		// init dialog
		addDrinksDialog = new JDialog();
		addDrinksDialog.setTitle("Add Drink");
		addDrinksDialog.setLocationRelativeTo(button);
		addDrinksDialog.setPreferredSize(dialogDimension);
		addDrinksDialog.setResizable(false);
		addDrinksDialog.setModal(true);
		
		// init panel
		JPanel addDrinksPanel = new JPanel();
		addDrinksPanel.setLayout(new BoxLayout(addDrinksPanel, BoxLayout.Y_AXIS));
		addDrinksPanel.setBackground(blue);
		
		// init size combobox
		chooseDrinkSize = new JComboBox<String>();
		chooseDrinkSize.addItem("<choose size>");
		chooseDrinkSize.addItem("20oz");
		chooseDrinkSize.addItem("2liter");
		
		// init quantity combobox
		chooseDrinkQuantity = new JComboBox<Object>();
		chooseDrinkQuantity.addItem("<choose quantity>");
		chooseDrinkQuantity.addItem(1);
		chooseDrinkQuantity.addItem(2);
		chooseDrinkQuantity.addItem(3);
		chooseDrinkQuantity.addItem(4);
		chooseDrinkQuantity.addItem(5);
		chooseDrinkQuantity.addItem(6);
		chooseDrinkQuantity.addItem(7);
		chooseDrinkQuantity.addItem(8);
		chooseDrinkQuantity.addItem(9);
		chooseDrinkQuantity.addItem(10);
		
		// add comboboxes
		addDrinksPanel.add(chooseDrinkSize);
		addDrinksPanel.add(chooseDrinkQuantity);
		addDrinksPanel.add(Box.createVerticalGlue());
		addDrinksPanel.add(Box.createVerticalGlue());
		
		// init button
		addDrinkButton = new JButton("Add");
		addDrinkButton.addActionListener(new ButtonListener());
		addDrinksPanel.add(addDrinkButton);
		
		// finalize
		addDrinksDialog.add(addDrinksPanel);
		addDrinksDialog.pack();
		addDrinksDialog.setVisible(true);
	}
	
	public void createDessertsPanel() {
		// init desserts panel
		JPanel dessertsPanel = new JPanel();
		dessertsPanel.setLayout(new BorderLayout());
		dessertsPanel.setBackground(white);
		
		// init panels
		JPanel chooseDessertsPanel = new JPanel();
		JPanel cinnamonBreadTwistsPanel = new JPanel();
		JPanel cookieBrowniePanel = new JPanel();
		JPanel lavaCakesPanel = new JPanel();
		JPanel cookiePanel = new JPanel();
		
		// set layout per panel
		chooseDessertsPanel.setLayout(new GridLayout(3, 2, 25, 15));
		cinnamonBreadTwistsPanel.setLayout(new BorderLayout());
		cookieBrowniePanel.setLayout(new BorderLayout());
		lavaCakesPanel.setLayout(new BorderLayout());
		cookiePanel.setLayout(new BorderLayout());
		
		// set bg color per panel
		chooseDessertsPanel.setBackground(white);
		cinnamonBreadTwistsPanel.setBackground(white);
		cookieBrowniePanel.setBackground(white);
		lavaCakesPanel.setBackground(white);
		cookiePanel.setBackground(white);
		
		// add label per panel
		cinnamonBreadTwistsPanel.add(new JLabel("<html>Handmade from fresh buttery-tasting "
				+ "dough and baked to a golden brown. Crusty on the outside and soft "
				+ "on the inside. Drizzled with a perfect blend of cinnamon and sugar, "
				+ "and served with a side of sweet icing for dipping or drizzling.</html>"), BorderLayout.SOUTH);
		cookieBrowniePanel.add(new JLabel("<html>Satisfy your sweet tooth! Taste the decadent "
				+ "blend of gooey milk chocolate chunk cookie and delicious fudge brownie. "
				+ "Oven-baked to perfection and cut into 9 pieces - this dessert is perfect "
				+ "to share with the whole group.</html>"), BorderLayout.SOUTH);
		lavaCakesPanel.add(new JLabel("<html>Indulge in two delectable oven-baked chocolate "
				+ "cakes with molten chocolate fudge on the inside. Perfectly topped "
				+ "with a dash of powdered sugar.</html>"), BorderLayout.SOUTH);
		cookiePanel.add(new JLabel("<html>Moist chocolate chunk cookie dipped in extra milk "
				+ "chocolate for a delicious chocolately treat.</html>"), BorderLayout.SOUTH);
		
		// init buttons
		cinnamonBreadTwistsButton = new JButton("Cinnamon Bread Twists");
		cookieBrownieButton = new JButton("Cookie Brownie");
		lavaCakesButton = new JButton("Lava Cakes");
		cookieButton = new JButton("Chocolate Chip Cookie");
		
		// add actionlistener per button
		cinnamonBreadTwistsButton.addActionListener(new ButtonListener());
		cookieBrownieButton.addActionListener(new ButtonListener());
		lavaCakesButton.addActionListener(new ButtonListener());
		cookieButton.addActionListener(new ButtonListener());
		
		// add buttons
		cinnamonBreadTwistsPanel.add(cinnamonBreadTwistsButton);
		cookieBrowniePanel.add(cookieBrownieButton);
		lavaCakesPanel.add(lavaCakesButton);
		cookiePanel.add(cookieButton);
		
		// add image per panel
		addImage("Cinnamon Bread Twists", cinnamonBreadTwistsPanel);
		addImage("Cookie Brownie", cookieBrowniePanel);
		addImage("Lava Cakes", lavaCakesPanel);
		addImage("Cookie", cookiePanel);
		
		// add all panels
		chooseDessertsPanel.add(cinnamonBreadTwistsPanel);
		chooseDessertsPanel.add(cookieBrowniePanel);
		chooseDessertsPanel.add(lavaCakesPanel);
		chooseDessertsPanel.add(cookiePanel);
		dessertsPanel.add(chooseDessertsPanel);
		add(dessertsPanel);
	}
		
	public void addDessertsPopup(JButton button, String dessert) {
		addDessertsType = dessert;
		
		// init dialog
		addDessertsDialog = new JDialog();
		addDessertsDialog.setTitle("Add Dessert");
		addDessertsDialog.setLocationRelativeTo(button);
		addDessertsDialog.setPreferredSize(dialogDimension);
		addDessertsDialog.setResizable(false);
		addDessertsDialog.setModal(true);
		
		// init panel
		JPanel addDessertsPanel = new JPanel();
		addDessertsPanel.setLayout(new BoxLayout(addDessertsPanel, BoxLayout.Y_AXIS));
		addDessertsPanel.setBackground(blue);
		
		// init quantity combobox
		chooseDessertQuantity = new JComboBox<Object>();
		chooseDessertQuantity.addItem("<choose quantity>");
		chooseDessertQuantity.addItem(1);
		chooseDessertQuantity.addItem(2);
		chooseDessertQuantity.addItem(3);
		chooseDessertQuantity.addItem(4);
		chooseDessertQuantity.addItem(5);
		chooseDessertQuantity.addItem(6);
		chooseDessertQuantity.addItem(7);
		chooseDessertQuantity.addItem(8);
		chooseDessertQuantity.addItem(9);
		chooseDessertQuantity.addItem(10);
		
		// add combobox
		addDessertsPanel.add(chooseDessertQuantity);
		addDessertsPanel.add(Box.createVerticalGlue());
		addDessertsPanel.add(Box.createVerticalGlue());
		
		// init button
		addDessertButton = new JButton("Add");
		addDessertButton.addActionListener(new ButtonListener());		
		addDessertsPanel.add(addDessertButton);		
		
		// finalize
		addDessertsDialog.add(addDessertsPanel);
		addDessertsDialog.pack();
		addDessertsDialog.setVisible(true);
	}
	
	public void createCartPanel() {
		removeAll();
		
		// init cart top panel
		JPanel cartTopPanel = new JPanel();
		cartTopPanel.setBackground(red);
		addLabel("Cart","Arial", 100, white, cartTopPanel, Component.RIGHT_ALIGNMENT);
		
		// init cart panel
		JPanel cartPanel = new JPanel();
		cartPanel.setLayout(new BorderLayout());
		cartPanel.setBackground(white);
		
		// init scroll panel
		JPanel cartScrollPanel = new JPanel();
		cartScrollPanel.setBackground(white);
		
		// init blue, left checkout panel and add label
		JPanel checkoutPanel = new JPanel();
		checkoutPanel.setLayout(new BoxLayout(checkoutPanel, BoxLayout.Y_AXIS));
		checkoutPanel.setBackground(blue);
		addLabel("Total items: " + pd.getSize(), "Arial", 20, white, checkoutPanel, Component.CENTER_ALIGNMENT);
		
		// init checkout button panel
		JPanel checkoutButtonPanel = new JPanel();
		checkoutButtonPanel.setLayout(new FlowLayout());
		checkoutButtonPanel.setBackground(blue);
		
		// init checkout button
		checkoutButton = new JButton("  Checkout  ");
		checkoutButton.addActionListener(new ButtonListener());

		// add button and panel
		checkoutButtonPanel.add(checkoutButton);
		checkoutPanel.add(checkoutButtonPanel, BorderLayout.BEFORE_FIRST_LINE);
		checkoutPanel.add(Box.createVerticalGlue());
		
		// init scrollpane
		JScrollPane scrollPane = new JScrollPane(cartScrollPanel, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getVerticalScrollBar().setUnitIncrement(25);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(25);
		
		Iterator<Item> it = pd.iterator();
		if (!it.hasNext()) { // if cart is empty
			cartScrollPanel.setLayout(new BoxLayout(cartScrollPanel, BoxLayout.Y_AXIS));
			cartScrollPanel.add(Box.createVerticalGlue());
			addLabel("No items in Cart", "Arial", 20, black, cartScrollPanel, Component.CENTER_ALIGNMENT);
			cartScrollPanel.add(Box.createVerticalGlue());
		} else { // if cart not empty
			cartScrollPanel.setLayout(new GridLayout(0, 2, 25, 15));
			cartPanel.add(checkoutPanel, BorderLayout.WEST);
			while (it.hasNext()) {
				Item item = it.next();
				JButton deleteItemButton = new JButton("Edit");
				deleteItemButton.setName(item.toString());
				deleteItemButton.addActionListener(new ButtonListener());
				deleteItemButtons.add(deleteItemButton);
				
				// init item panel
				JPanel itemPanel = new JPanel();
				itemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
				itemPanel.setBackground(white);
				
				// init picture panel
				JPanel picturePanel = new JPanel();
				picturePanel.setLayout(new BorderLayout());
				picturePanel.setPreferredSize(pictureDimension);
				picturePanel.setBackground(white);
				addImage(item.getType(), picturePanel);
				
				// init item info panel and add label
				JPanel infoPanel = new JPanel();
				infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
				infoPanel.setBackground(white);
				addLabel("<html>" + item.toString() + "</html>", "Arial", 20, black, infoPanel, Component.CENTER_ALIGNMENT);
				
				// init delete and quantity panel and add button and label
				JPanel deleteItemPanel = new JPanel();
				deleteItemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
				deleteItemPanel.setBackground(white);
				deleteItemPanel.add(deleteItemButton, BorderLayout.BEFORE_FIRST_LINE);
				addLabel("|  Quantity: " + item.getQuantity(), "Arial", 15, black, deleteItemPanel, Component.RIGHT_ALIGNMENT);
				
				// add panels
				itemPanel.add(picturePanel);
				infoPanel.add(deleteItemPanel);
				itemPanel.add(infoPanel);
				cartScrollPanel.add(itemPanel);
			}
		}
		// add panels and finalize
		cartPanel.add(scrollPane, BorderLayout.CENTER);
		add(cartTopPanel, BorderLayout.NORTH);
		add(cartPanel);
		createBottomPanel();
		repaint();
		revalidate();
	}

	public void createEditPopup(JButton button, String item) {
		editItemType = item;
		
		// init dialog
		editItemDialog = new JDialog();
		editItemDialog.setTitle("Edit");
		editItemDialog.setLocationRelativeTo(button);
		editItemDialog.setPreferredSize(new Dimension(width/ 4, height / 6));
		editItemDialog.setResizable(false);
		editItemDialog.setModal(true);
		
		// init panels
		JPanel editItemPanel = new JPanel();
		editItemPanel.setLayout(new BoxLayout(editItemPanel, BoxLayout.Y_AXIS));
		editItemPanel.setBackground(blue);
		addLabel("<html>Delete " + editItemType + "?</html>", "Arial", 20, white, editItemPanel, Component.CENTER_ALIGNMENT);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
		buttonsPanel.setBackground(blue);
		editItemPanel.add(buttonsPanel);
		
		// init buttons
		deleteItemFinalButton = new JButton("Delete");
		cancelButton = new JButton("Cancel");
		deleteItemFinalButton.addActionListener(new ButtonListener());
		cancelButton.addActionListener(new ButtonListener());
		buttonsPanel.add(deleteItemFinalButton);
		buttonsPanel.add(cancelButton);
		
		// finalize
		editItemDialog.add(editItemPanel);
		editItemDialog.pack();
		editItemDialog.setVisible(true);
	}
	
	public void createCheckoutPopup() {
		// init dialog
		checkoutDialog = new JDialog();
		checkoutDialog.setTitle("Checkout");
		checkoutDialog.setLocation(new Point((width / 3) + (width / 22), height / 3));
		checkoutDialog.setPreferredSize(new Dimension(width / 2, height / 2));
		checkoutDialog.setResizable(false);
		checkoutDialog.setModal(true);
		
		// init checkout panel
		JPanel checkoutPanel = new JPanel();
		checkoutPanel.setLayout(new BorderLayout());
		
		// init top panel
		JPanel checkoutTopPanel = new JPanel();
		checkoutTopPanel.setLayout(new BoxLayout(checkoutTopPanel, BoxLayout.Y_AXIS));
		checkoutTopPanel.setBackground(blue);
		checkoutTopPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		addLabel("Are you sure you want to checkout?", "Arial", 30, white, checkoutTopPanel, Component.CENTER_ALIGNMENT);
		checkoutTopPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		// init center panel
		JPanel checkoutCenterPanel = new JPanel();
		checkoutCenterPanel.setLayout(new BoxLayout(checkoutCenterPanel, BoxLayout.Y_AXIS));
		checkoutCenterPanel.setBackground(white);
		checkoutCenterPanel.setBorder(BorderFactory.createLineBorder(white, 35, false));
		JScrollPane checkoutCenterPane = new JScrollPane(checkoutCenterPanel); // make scrollable
		
		// show items
		addLabel("Items: " + pd.getSize(), "Arial", 20, black, checkoutCenterPanel, Component.CENTER_ALIGNMENT);
		Iterator<Item> it = pd.iterator();
		while (it.hasNext()) {
			Item item = it.next();
			addLabel("• " + item.getQuantity() + " " + item.toString(), 
					"Arial", 20, black, checkoutCenterPanel, Component.LEFT_ALIGNMENT);
		}
		
		// init button panel
		JPanel checkoutButtonPanel = new JPanel();
		checkoutButtonPanel.setLayout(new FlowLayout());
		checkoutButtonPanel.setBackground(red);
		
		// init cancel button
		cancelCheckoutButton = new JButton("Cancel");
		cancelCheckoutButton.addActionListener(new ButtonListener());
		checkoutButtonPanel.add(cancelCheckoutButton);
		
		// init confirm button
		confirmCheckoutButton = new JButton("Confirm");
		confirmCheckoutButton.addActionListener(new ButtonListener());
		checkoutButtonPanel.add(confirmCheckoutButton);
		
		// finalize
		checkoutPanel.add(checkoutButtonPanel);
		checkoutPanel.add(checkoutTopPanel, BorderLayout.PAGE_START);
		checkoutPanel.add(checkoutCenterPane, BorderLayout.CENTER);
		checkoutPanel.add(checkoutButtonPanel, BorderLayout.PAGE_END);
		checkoutDialog.add(checkoutPanel);
		checkoutDialog.pack();
		checkoutDialog.setVisible(true);
	}
	
	public void createConfirmCheckoutPopup() {
		// init dialog
		confirmCheckoutDialog = new JDialog();
		confirmCheckoutDialog.setLocation(new Point((width / 3) + (width / 22), height / 3));
		confirmCheckoutDialog.setPreferredSize(new Dimension(width / 2, height / 5));
		confirmCheckoutDialog.setResizable(false);
		confirmCheckoutDialog.setModal(true);
		
		// init panel
		JPanel confirmCheckoutPanel = new JPanel();
		confirmCheckoutPanel.setLayout(new BoxLayout(confirmCheckoutPanel, BoxLayout.Y_AXIS));
		confirmCheckoutPanel.setBackground(red);
		confirmCheckoutPanel.setBorder(BorderFactory.createRaisedBevelBorder());
		addLabel("Congratulations on your order!", "Arial", 30, white, confirmCheckoutPanel, Component.CENTER_ALIGNMENT);
		addLabel("Create new order or exit?", "Arial", 25, white, confirmCheckoutPanel, Component.CENTER_ALIGNMENT);
		confirmCheckoutPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		// init button panel
		JPanel confirmCheckoutButtonPanel = new JPanel();
		confirmCheckoutButtonPanel.setLayout(new FlowLayout());
		confirmCheckoutButtonPanel.setBackground(red);
		
		// init new order button
		newOrderButton = new JButton("Yes");
		newOrderButton.addActionListener(new ButtonListener());
		confirmCheckoutButtonPanel.add(newOrderButton);
		
		// init exit button
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ButtonListener());
		confirmCheckoutButtonPanel.add(exitButton);
		
		// finalzie
		confirmCheckoutPanel.add(confirmCheckoutButtonPanel);
		confirmCheckoutDialog.add(confirmCheckoutPanel);
		confirmCheckoutDialog.pack();
		confirmCheckoutDialog.setVisible(true);
	}
	
	
	public void createBottomPanel() {
		// init bottom panel
		JPanel botPanel = new JPanel();
		botPanel.setLayout(new BoxLayout(botPanel, BoxLayout.X_AXIS));
		botPanel.setBackground(lightGray);
		
		// init buttons
		homeButton = new JButton("HOME");
		cartButton = new JButton("VIEW CART");
		
		// add actionlistener per button
		homeButton.addActionListener(new ButtonListener());
		cartButton.addActionListener(new ButtonListener());
		
		// add buttons
		botPanel.add(homeButton);
		botPanel.add(cartButton);
		
		add(botPanel, BorderLayout.PAGE_END);
	}
	
	
	public void addLabel(String name, String font, int fontSize, Color color, JPanel panel, float alignment) {
		JLabel text = new JLabel(name);
		text.setFont(new Font(font, Font.PLAIN, fontSize));
		text.setForeground(color);
		text.setAlignmentX(alignment);
		panel.add(text);
	}
	
	
	public void addImage(String item, JPanel imagePanel) {
		File imFile = null;
		// home
		if (item.equals("Home")) {
			imFile = new File("images/homeIMG.jpg");
		}
		// pizzas
		if (item.equals("Cheese Pizza")) {
			imFile = new File("images/choosePizza/cheesePizza.jpg");
		} if (item.equals("Pepperoni Pizza")) {
			imFile = new File("images/choosePizza/pepperoniPizza.jpg");
		} if (item.equals("Sausage Pizza")) {
			imFile = new File("images/choosePizza/sausagePizza.jpg");
		} if (item.equals("Combo Pizza")) {
			imFile = new File("images/choosePizza/comboPizza.png");
		} if (item.equals("Vegetarian Pizza")) {
			imFile = new File("images/choosePizza/vegetarianPizza.png");
		} if (item.equals("Meat Pizza")) {
			imFile = new File("images/choosePizza/meatPizza.jpeg");
		} 
		// chicken
		if (item.equals("Buffalo Chicken Wings")) {
			imFile = new File("images/chooseChicken/buffalo.png");
		} if (item.equals("Buffalo Boneless Chicken Wings")) {
			imFile = new File("images/chooseChicken/buffaloBoneless.jpeg");
		} if (item.equals("BBQ Chicken Wings")) {
			imFile = new File("images/chooseChicken/bbq.jpg");
		} if (item.equals("BBQ Boneless Chicken Wings")) {
			imFile = new File("images/chooseChicken/bbqBoneless.jpg");
		} if (item.equals("Jalapeño Chicken Wings")) {
			imFile = new File("images/chooseChicken/jalapeno.jpg");
		} if (item.equals("Jalapeño Boneless Chicken Wings")) {
			imFile = new File("images/chooseChicken/jalapenoBoneless.jpg");
		}
		// sandwiches
		if (item.equals("Buffalo Chicken Sandwich")) {
			imFile = new File("images/chooseSandwiches/buffaloSandwich.jpg");
		} if (item.equals("Chicken Habanero Sandwich")) {
			imFile = new File("images/chooseSandwiches/habaneroSandwich.jpg");
		} if (item.equals("Philly Cheese Steak Sandwich")) {
			imFile = new File("images/chooseSandwiches/pcsSandwich.jpg");
		} if (item.equals("Chicken Bacon Ranch Sandwich")) {
			imFile = new File("images/chooseSandwiches/cbrSandwich.jpg");
		} if (item.equals("Italian Sandwich")) {
			imFile = new File("images/chooseSandwiches/italianSandwich.jpg");
		} if (item.equals("Chicken Parm Sandwich")) {
			imFile = new File("images/chooseSandwiches/parmSandwich.jpg");
		}
		// sides
		if (item.equals("Parmesan Bread Twists")) {
			imFile = new File("images/chooseSides/parmTwists.jpg");
		} if (item.equals("Garlic Bread Twists")) {
			imFile = new File("images/chooseSides/garlicTwists.jpg");
		} if (item.equals("Stuffed Cheesy Bread")) {
			imFile = new File("images/chooseSides/cheesyBread.jpg");
		} if (item.equals("Stuffed Jalapeño Cheesy Bread")) {
			imFile = new File("images/chooseSides/jalapenoBread.jpg");
		} if (item.equals("Parmesan Bread Bites")) {
			imFile = new File("images/chooseSides/parmBites.jpg");
		} if (item.contains("Sauce")) {
			imFile = new File("images/chooseSides/sauces.jpg");
		} if (item.equals("Crushed Red Pepper Packets")) {
			imFile = new File("images/chooseSides/pepper.jpg");
		} if (item.equals("Crushed Parmesan Cheese Packets")) {
			imFile = new File("images/chooseSides/parm.jpg");
		}
		// drinks
		if (item.equals("Dasani")) {
			imFile = new File("images/chooseDrinks/dasaniSmall.jpg");
		} if (item.equals("Sprite")) {
			imFile = new File("images/chooseDrinks/spriteSmall.jpg");
		} if (item.equals("Coke")) {
			imFile = new File("images/chooseDrinks/cokeSmall.jpg");
		} if (item.equals("Diet Coke")) {
			imFile = new File("images/chooseDrinks/cokeDietSmall.jpg");
		} if (item.equals("Barq's Root Beer")) {
			imFile = new File("images/chooseDrinks/barqsSmall.jpeg");
		} if (item.equals("Fanta")) {
			imFile = new File("images/chooseDrinks/fantaSmall.jpeg");
		} if (item.contains("Lemonade")) {
			imFile = new File("images/chooseDrinks/lemonadeSmall.jpeg");
		} if (item.contains("Pink Lemonade")) {
			imFile = new File("images/chooseDrinks/lemonadePinkSmall.jpeg");
		}
		// desserts
		if (item.equals("Cinnamon Bread Twists")) {
			imFile = new File("images/chooseDesserts/cinnamonBreadTwists.jpg");
		} if (item.equals("Cookie Brownie")) {
			imFile = new File("images/chooseDesserts/cookieBrownie.jpg");
		} if (item.equals("Lava Cakes")) {
			imFile = new File("images/chooseDesserts/lavaCakes.jpg");
		} if (item.equals("Cookie")) {
			imFile = new File("images/chooseDesserts/cookies.jpg");
		}
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(imFile);
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			imagePanel.add(picLabel, BorderLayout.WEST);
		} catch (IOException e) {
			System.out.println("Could not load an image: " + e);
		}
	}
	
	
	class ButtonListener implements ActionListener {			
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			
			// menu panel
			if (b.equals(pizzaButton)) {
				createItemPanel("Pizzas");
			} if (b.equals(chickenButton)) {
				createItemPanel("Chicken");
			} if (b.equals(sandwichButton)) {
				createItemPanel("Sandwiches");
			} if (b.equals(sidesButton)) {
				createItemPanel("Sides");
			} if (b.equals(drinksButton)) {
				createItemPanel("Drinks");
			} if (b.equals(dessertsButton)) {
				createItemPanel("Desserts");
			}
			// pizza panel
			if (b.equals(cheeseButton)) {
				addPizzaPopup(cheeseButton, "Cheese Pizza");
			} if (b.equals(pepperoniButton)) {
				addPizzaPopup(pepperoniButton, "Pepperoni Pizza");
			} if (b.equals(sausageButton)) {
				addPizzaPopup(sausageButton, "Sausage Pizza");
			} if (b.equals(comboButton)) {
				addPizzaPopup(comboButton, "Combo Pizza");
			} if (b.equals(vegetarianButton)) {
				addPizzaPopup(vegetarianButton, "Vegetarian Pizza");
			} if (b.equals(meatButton)) {
				addPizzaPopup(meatButton, "Meat Pizza");
			} if (b.equals(addPizzaButton)) {
				String size = choosePizzaSize.getSelectedItem().toString();
				String crust = chooseCrust.getSelectedItem().toString();
				String quantity = choosePizzaQuantity.getSelectedItem().toString();
				if (!size.startsWith("<") && 
						!crust.startsWith("<") &&
						!quantity.startsWith("<")) {
					pd.addItem(new Item("Pizza", addPizzaType, size, crust, Integer.parseInt(quantity)));
					addPizzaDialog.setVisible(false);
					JOptionPane.showMessageDialog(null, quantity + " " + addPizzaType + 
							" Pizza(s) with " + crust + " crust added to Cart!", "Yum!", 
							JOptionPane.PLAIN_MESSAGE);
				}
			// chicken panel
			} if (b.equals(buffaloButton)) {
				addChickenPopup(buffaloButton, "Buffalo Chicken Wings");
			} if (b.equals(buffaloBonelessButton)) {
				addChickenPopup(buffaloBonelessButton, "Buffalo Boneless Chicken Wings");
			} if (b.equals(bbqButton)) {
				addChickenPopup(bbqButton, "BBQ Chicken Wings");
			} if (b.equals(bbqBonelessButton)) {
				addChickenPopup(bbqBonelessButton, "BBQ Boneless Chicken Wings");
			} if (b.equals(jalapenoButton)) {
				addChickenPopup(jalapenoButton, "Jalapeño Chicken Wings");
			} if (b.equals(jalapenoBonelessButton)) {
				addChickenPopup(jalapenoBonelessButton, "Jalapeño Boneless Chicken Wings");
			} if (b.equals(addChickenButton)) {
				String sauce = chooseChickenSauce.getSelectedItem().toString();
				String quantity = chooseChickenQuantity.getSelectedItem().toString();
				if (!sauce.startsWith("<") && !quantity.startsWith("<")) {
					pd.addItem(new Item("Chicken", addChickenType, Integer.parseInt(quantity)));
					pd.addItem(new Item("Sauce", sauce, 1));
					addChickenDialog.setVisible(false);
					JOptionPane.showMessageDialog(null, quantity + " " + addChickenType + 
							" and 1 " + sauce + " added to Cart!", "Yum!", 
							JOptionPane.PLAIN_MESSAGE);
				}
			// sandwiches panel
			} if (b.equals(buffaloSandwichButton)) {
				addSandwichPopup(buffaloSandwichButton, "Buffalo Chicken Sandwich");
			} if (b.equals(habaneroSandwichButton)) {
				addSandwichPopup(habaneroSandwichButton, "Chicken Habanero Sandwich");
			} if (b.equals(pcsSandwichButton)) {
				addSandwichPopup(pcsSandwichButton, "Philly Cheese Steak Sandwich");
			} if (b.equals(cbrSandwichButton)) {
				addSandwichPopup(cbrSandwichButton, "Chicken Bacon Ranch Sandwich");
			} if (b.equals(italianSandwichButton)) {
				addSandwichPopup(italianSandwichButton, "Italian Sandwich");
			} if (b.equals(parmSandwichButton)) {
				addSandwichPopup(parmSandwichButton, "Chicken Parm Sandwich");
			} if (b.equals(addSandwichButton)) {
				String quantity = chooseSandwichQuantity.getSelectedItem().toString();
				if (!quantity.startsWith("<")) {
					pd.addItem(new Item("Sandwich", addSandwichType, Integer.parseInt(quantity)));
					addSandwichDialog.setVisible(false);
					JOptionPane.showMessageDialog(null, quantity + " " + addSandwichType + 
							"(es) added to Cart!", "Yum!", JOptionPane.PLAIN_MESSAGE);
				}
			}
			// sides panel
			if (b.equals(parmTwistsButton)) {
				addSidesPopup(parmTwistsButton, "Parmesan Bread Twists");
			} if (b.equals(garlicTwistsButton)) {
				addSidesPopup(garlicTwistsButton, "Garlic Bread Twists");
			} if (b.equals(cheesyBreadButton)) {
				addSidesPopup(cheesyBreadButton, "Stuffed Cheesy Bread");
			} if (b.equals(jalapenoBreadButton)) {
				addSidesPopup(jalapenoBreadButton, "Stuffed Jalapeño Cheesy Bread");
			} if (b.equals(parmBitesButton)) {
				addSidesPopup(parmBitesButton, "Parmesan Bread Bites");
			} if (b.equals(saucesButton)) {
				addSidesPopup(saucesButton, "Sauces");
			} if (b.equals(pepperButton)) {
				addSidesPopup(pepperButton, "Crushed Red Pepper Packets");
			} if (b.equals(parmButton)) {
				addSidesPopup(parmButton, "Crushed Parmesan Cheese Packets");
			} if (b.equals(addSideButton)) {
				String side = addSidesType;
				String quantity = chooseSidesQuantity.getSelectedItem().toString();
				String sauce = "";
				if (chooseSauce != null) {
					sauce = chooseSauce.getSelectedItem().toString();
				}
				if (side.contains("Twists") && !quantity.startsWith("<") 
						&& !sauce.startsWith("<")) {
					pd.addItem( new Item("Side", side, Integer.parseInt(quantity)));
					pd.addItem(new Item("Sauce", sauce, 1));
					addSidesDialog.setVisible(false);
					JOptionPane.showMessageDialog(null, quantity + " " + addSidesType + 
							" and 1 " + sauce + " added to Cart!", "Yum!", JOptionPane.PLAIN_MESSAGE);
				} if (side.contains("Stuffed") && !quantity.startsWith("<") 
						&& !sauce.startsWith("<")) {
					pd.addItem(new Item("Side", side, Integer.parseInt(quantity)));
					pd.addItem(new Item("Sauce", sauce, 1));
					addSidesDialog.setVisible(false);
					JOptionPane.showMessageDialog(null, quantity + " " + addSidesType + 
							" and 1 " + sauce + " added to Cart!", "Yum!", JOptionPane.PLAIN_MESSAGE);
				} if (side.equals("Parmesan Bread Bites") && !quantity.startsWith("<") 
						&& !sauce.startsWith("<")) {
					pd.addItem(new Item("Side", side, Integer.parseInt(quantity)));
					pd.addItem(new Item("Sauce", sauce, 1));
					addSidesDialog.setVisible(false);
					JOptionPane.showMessageDialog(null, quantity + " " + addSidesType + 
							" and 1 " + sauce + " added to Cart!", "Yum!", JOptionPane.PLAIN_MESSAGE);
				} if (side.equals("Sauces") && !quantity.startsWith("<")
						&& !sauce.startsWith("<")) {
					pd.addItem(new Item("Sauce", sauce, Integer.parseInt(quantity)));
					addSidesDialog.setVisible(false);
					JOptionPane.showMessageDialog(null, quantity + " " + sauce + 
							" added to Cart!", "Yum!", JOptionPane.PLAIN_MESSAGE);
				} if (side.contains("Packet") && !quantity.startsWith("<")) {
					pd.addItem(new Item("Side", side, Integer.parseInt(quantity)));
					addSidesDialog.setVisible(false);
					JOptionPane.showMessageDialog(null, quantity + " " + addSidesType + 
							" added to Cart!", "Yum!", JOptionPane.PLAIN_MESSAGE);
				}
			}
			// drinks panel
			if (b.equals(dasaniButton)) {
				addDrinksPopup(dasaniButton, "Dasani");
			} if (b.equals(spriteButton)) {
				addDrinksPopup(spriteButton, "Sprite");
			} if (b.equals(cokeButton)) {
				addDrinksPopup(cokeButton, "Coke");
			} if (b.equals(cokeDietButton)) {
				addDrinksPopup(cokeDietButton, "Diet Coke");
			} if (b.equals(barqsButton)) {
				addDrinksPopup(barqsButton, "Barq's Root Beer");
			} if (b.equals(fantaButton)) {
				addDrinksPopup(fantaButton, "Fanta");
			} if (b.equals(lemonadeButton)) {
				addDrinksPopup(lemonadeButton, "Minute Maid Lemonade");
			} if (b.equals(lemonadePinkButton)) {
				addDrinksPopup(lemonadePinkButton, "Minute Main Pink Lemonade");
			} if (b.equals(addDrinkButton)) {
				String size = chooseDrinkSize.getSelectedItem().toString();
				String quantity = chooseDrinkQuantity.getSelectedItem().toString();
				if (!size.startsWith("<") && !quantity.startsWith("<")) {
					pd.addItem(new Item("Drink", addDrinksType, size, Integer.parseInt(quantity)));
					addDrinksDialog.setVisible(false);
					JOptionPane.showMessageDialog(null, quantity + " " + size + 
							" " + addDrinksType + "(s) added to Cart!", "Yum!", 
							JOptionPane.PLAIN_MESSAGE);
				}
			// desserts panel
			} if (b.equals(cinnamonBreadTwistsButton)) { 
				addDessertsPopup(cinnamonBreadTwistsButton, "Cinnamon Bread Twists");
			} if (b.equals(cookieBrownieButton)) {
				addDessertsPopup(cookieBrownieButton, "Cookie Brownie");
			} if (b.equals(lavaCakesButton)) {
				addDessertsPopup(lavaCakesButton, "Lava Cakes");
			} if (b.equals(cookieButton)) {
				addDessertsPopup(cookieButton, "Cookie");
			} if (b.equals(addDessertButton)) {
				String quantity = chooseDessertQuantity.getSelectedItem().toString();
				if (!quantity.startsWith("<")) {
					pd.addItem(new Item("Dessert", addDessertsType, Integer.parseInt(quantity)));
					addDessertsDialog.setVisible(false);
					JOptionPane.showMessageDialog(null, quantity + " " + addDessertsType + 
							"(s) added to Cart!", "Yum!", JOptionPane.PLAIN_MESSAGE);
				}
			}
			if (b.equals(homeButton)) {
				createHomePanels();
			} if (b.equals(cartButton)) {
				pd.combineItems();
				createCartPanel();
			} 
			// cart panel
			if (b.getName() != null) {
				Iterator<JButton> it = deleteItemButtons.iterator();
				while (it.hasNext()) {
					JButton button = it.next();
					if (button.getName().equals(b.getName())) {
						createEditPopup(b, button.getName());
					}
				}
			}
			if (b.equals(deleteItemFinalButton)) {
				pd.removeItem(editItemType);
				editItemDialog.setVisible(false);
				Iterator<JButton> it = deleteItemButtons.iterator();
				while (it.hasNext()) {
					if (it.next().getName().equals(editItemType)) {
						it.remove();
					}
				}
				createCartPanel();
			}
			if (b.equals(cancelButton)) {
				editItemDialog.setVisible(false);
			}
			if (b.equals(checkoutButton)) {
				createCheckoutPopup();
			} if (b.equals(cancelCheckoutButton)) {
				checkoutDialog.setVisible(false);
			} if (b.equals(confirmCheckoutButton)) {
				checkoutDialog.setVisible(false);
				createConfirmCheckoutPopup();
			} if (b.equals(newOrderButton)) {
				pd.clearItems();
				confirmCheckoutDialog.setVisible(false);
				createHomePanels();
			} if (b.equals(exitButton)) {
				System.exit(0);
			}
		} // actionPerformed()
	} // class ButtonListener
	
} // class PizzaWebAppPanel
