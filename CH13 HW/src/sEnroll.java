import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Trey Gwin
 * Homework 13
 * @version 2022-10-19
 * CS 2323 001
 *
 * This code creates an interactive
 * GUI that will add information
 * about a student as entered by
 * the user.
 */
public class sEnroll extends JFrame implements ChangeListener, ActionListener {
    private JLabel nameLabel;
    private JLabel stuInfo;
    private JLabel idLabel;
    private JLabel credLabel;
    private JLabel tranLabel;
    private JLabel majorLabel;
    private JTextField nameField;
    private JTextField idField;
    private JTextField credField;
    Checkbox tranBox = new Checkbox();
    JSlider credSlide;
    private JComboBox majorBox;
    private JButton stuButton;
    private JTextArea outputArea;
    JScrollPane scrollPane;
    /**
     * This constructor creates the GUI
     * using the reserved variables above.
     */
    public sEnroll() {
        int credMin = 0;
        int credMax = 150;
        int credInit = 0;

        /**
         * These variables create
         * and sets the size of the
         * GUI.
         */
        JFrame myFrame = new JFrame("RSU Students");
        myFrame.setLayout(new GridBagLayout());
        myFrame.setSize(600,400);


        /**
         * These variables make use
         * of the reserved names
         * and creates instances of
         * JLabels.
         */
        nameLabel = new JLabel("Name: ");
        stuInfo = new JLabel("Enter Student Information");
        Font myFont = new Font(Font.SERIF,Font.BOLD,20);
        stuInfo.setFont(myFont);
        idLabel = new JLabel("ID: ");
        tranLabel = new JLabel("Transfer:");
        credLabel = new JLabel("Credits:");
        majorLabel = new JLabel("Major:");

        /**
         * These variables use the
         * reserved names from above
         * and creates editable JTextFields.
         */
        nameField = new JTextField(20);
        nameField.setEditable(true);
        idField = new JTextField(20);
        idField.setEditable(true);
        credField = new JTextField(3);
        credField.setEditable(true);

        /**
         * These variables create the
         * JTextArea for the output of the
         * GUI and makes an instance of
         * the Grid Bag Constraints.
         */
        outputArea = new JTextArea(7,52);
        scrollPane = new JScrollPane(outputArea);
        outputArea.setEditable(false);
        GridBagConstraints gbc = new GridBagConstraints();

        /**
         * These variables create an instance
         * of the JSlider as well as the Major
         * and Minor Tick Spacing.
         */
        credSlide = new JSlider(credMin,credMax,credInit);
        credSlide.setMajorTickSpacing(10);
        credSlide.setMinorTickSpacing(2);
        credSlide.setSize(400,0);
        credSlide.setPaintTicks(true);
        credSlide.setPaintLabels(true);
        credSlide.addChangeListener(this);

        /**
         * Sets up the array and the Action Listener
         * for the JComboBox named "majorBox"
         */
        String majorArr[] = {"B.S. in Business Information Technology",
                 "B.S. in Justice Administration",
                 "B.T. in Applied Technology",
                 "A.A. in Criminal Justice Studies",
                 "A.A.S. in Applied Technology"};
        majorBox = new JComboBox(majorArr);

        /**
         * Creates the JButton and adds an Action Listener
         * to use for the actionPerformed method.
         */
        stuButton = new JButton("Add Student");
        stuButton.addActionListener(this);

        /**
         * Aligns the student information
         * label at the top of the GUI.
         */
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        myFrame.add(stuInfo,gbc);

        /**
         * Aligns the name label.
         */
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,100,0,0);
        myFrame.add(nameLabel,gbc);

        /**
         * Aligns the text field for the
         * nameField.
         */
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,5,0,0);
        myFrame.add(nameField,gbc);

        /**
         * Aligns the ID label.
         */
        gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.anchor = GridBagConstraints.LINE_END;
        myFrame.add(idLabel,gbc);

        /**
         * Aligns the ID text field.
         */
        gbc = new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=4;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,5,0,0);
        myFrame.add(idField,gbc);

        /**
         * Aligns the transfer label.
         */
        gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.anchor = GridBagConstraints.LINE_END;
        myFrame.add(tranLabel,gbc);

        /**
         * Aligns the transfer box.
         */
        gbc = new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=5;
        gbc.insets = new Insets(0,10,0,0);
        gbc.anchor = GridBagConstraints.LINE_START;
        myFrame.add(tranBox,gbc);

        /**
         * Aligns the credit label.
         */
        gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=6;
        gbc.anchor = GridBagConstraints.LINE_END;
        myFrame.add(credLabel,gbc);

        /**
         * Aligns and add an actionListener
         * for the credit field.
         */
        gbc = new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=6;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,5,0,0);
        credField.addActionListener(this);
        myFrame.add(credField,gbc);

        /**
         * Aligns the credit slide.
         */
        gbc = new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=7;
        gbc.gridwidth=3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        myFrame.add(credSlide,gbc);

        /**
         * Aligns the major label.
         */
        gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=8;
        gbc.anchor = GridBagConstraints.LINE_END;
        myFrame.add(majorLabel,gbc);

        /**
         * Aligns the major checkbox.
         */
        gbc = new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=8;
        gbc.insets = new Insets(0,5,0,0);
        myFrame.add(majorBox,gbc);

        /**
         * Aligns the student button.
         */
        gbc = new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=10;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(20,0,0,50);
        myFrame.add(stuButton,gbc);

        /**
         * Aligns the scroll pane/output area.
         */
        gbc = new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=11;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        myFrame.add(scrollPane,gbc);


        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.setVisible(true);

    }

    public static void main(String[] args) {
        sEnroll myFrame = new sEnroll();
    }

    /**
     * Runs when the stuButton is selected in the GUI
     * and takes all the entered information in order
     * to append an instance of the Student method in
     * the scrollPane.
     * Afterwards it resets each of the fields to their
     * default instance and await for the user to enter
     * more information.
     * @param e The required variable for the ActionEvent interface.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String stuName;
        int numCredits;
        long stuID;
        boolean isTransfer;

        stuName = nameField.getText();
        numCredits = (Integer.parseInt(String.valueOf(credField.getText())));
        stuID = (Long.parseLong(String.valueOf(idField.getText())));
        isTransfer = tranBox.getState();

        String majorName = (String) majorBox.getSelectedItem();

        Student newStu = new Student(stuName,numCredits,stuID,majorName,isTransfer);
        outputArea.append(newStu + "\n");
        nameField.setText("");
        credField.setText("");
        idField.setText("");
        tranBox.setState(false);
        credSlide.setValue(0);
        majorBox.setSelectedIndex(0);

    }

    /**
     * Simply allows the JSlider to make changes
     * to the credit text field.
     * @param e The variable needed for the ChangeListener
     *          interface.
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        credField.setText(credSlide.getValue()+"");
        credSlide.setValue((Integer.parseInt(credField.getText())));

    }

}
