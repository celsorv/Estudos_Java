package weekday;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ZellerAlgorithmGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField dateField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public ZellerAlgorithmGUI() {
        super("Zeller Algorithm");

        // create components
        JLabel dateLabel = new JLabel("Enter a date (format dd/mm/yyyy):");
        dateField = new JTextField(10);
        calculateButton = new JButton("Calculate");
        resultLabel = new JLabel();

        // add components to panel
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        // add panel to frame
        add(panel);

        // set frame properties
        setSize(600, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // add action listener to button
        calculateButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculateButton) {

            String dateString = dateField.getText();

            int day = Integer.parseInt(dateString.substring(0, 2));
            int month = Integer.parseInt(dateString.substring(3, 5));
            int year = Integer.parseInt(dateString.substring(6));

            DayOfWeek dayOfWeekRef = LocalDate.of(year, month, day).getDayOfWeek();

            int dayOfWeek = zellerAlgorithm(year, month, day);

            String result = String.format("%02d/%02d/%04d => Java Time: %s, Zeller Algorithm: %s",
                    day, month, year, dayOfWeekRef, getDayOfWeekName(dayOfWeek));

            resultLabel.setText(result);

        }

    }

    private int zellerAlgorithm(int year, int month, int day) {

        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }

        int k = year % 100;
        int j = year / 100;
        int h = (day + 13 * (month + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;

        return h;

    }

    private String getDayOfWeekName(int dayOfWeek) {
        String[] daysOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        return daysOfWeek[dayOfWeek];
    }

    public static void main(String[] args) {
        ZellerAlgorithmGUI gui = new ZellerAlgorithmGUI();
        gui.setVisible(true);
    }

}
