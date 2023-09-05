import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListGui extends JFrame implements ActionListener {

    //TaskPanel will be a container for TaskComponentPanel
    private JPanel TaskPanel, taskComponentPanel;

    //constructor
    public ToDoListGui(){
        super("To Do List Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(CommonConstants.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addGuiComponents();
    }

    private void addGuiComponents(){
        // banner Text
        JLabel banner = new JLabel("Task List");
        banner.setBounds((CommonConstants.GUI_SIZE.width - banner.getPreferredSize().width)/2,
                15,
                CommonConstants.BANNER_SIZE.width,
                CommonConstants.BANNER_SIZE.height);

        // TaskPanel
        TaskPanel = new JPanel();

        // taskComponentPanel
        taskComponentPanel = new JPanel();
        taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
        TaskPanel.add(taskComponentPanel);

        // add scrolling
        JScrollPane scrollPane = new JScrollPane(TaskPanel);
        scrollPane.setBounds(8, 70, CommonConstants.TASKPANEL_SIZE.width, CommonConstants.TASKPANEL_SIZE.height);
        scrollPane.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // add tasks
        JButton addTask = new JButton("Add Task");
        addTask.setBounds(-5, CommonConstants.GUI_SIZE.height - 88,
                CommonConstants.ADDTASKBUTTON_SIZE.width,
                CommonConstants.ADDTASKBUTTON_SIZE.height);
        addTask.addActionListener(this);

        // adds to frame
        this.getContentPane().add(banner);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(addTask);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equalsIgnoreCase("Add task")){
            // create new task component
            TaskComponent taskComponent = new TaskComponent(taskComponentPanel);
            taskComponentPanel.add(taskComponent);

            // make the task field request focus after creation
            taskComponent.getTaskField().requestFocus();
            repaint();
            revalidate();
        }
    }
}
