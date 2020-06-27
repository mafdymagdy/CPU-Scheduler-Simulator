import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author mafdy
 */

public class GUI 
{
    private JFrame frame;
    private JPanel mainPanel;
    private CustomPanel chartPanel;
    private JScrollPane tablePane;
    private JScrollPane chartPane;
    private JTable table;
    private JButton addBtn;
    private JButton removeBtn;
    private JButton calcBtn;
    private JButton fileBtn;
    private JRadioButton nonPreemptive;
    private JRadioButton preemptive;
    private ButtonGroup btng;
    private JLabel wtLabel;
    private JLabel wtResultLabel;
    private JLabel tatLabel;
    private JLabel tatResultLabel;
    private JLabel combotitle;
    private JLabel space2;
    private JLabel snotes;
    private JLabel s1notes;
    private JLabel s2notes;
    private JLabel s3notes;
    private JLabel s4notes;
    private JLabel space4;
    private JLabel space1;
    private JLabel NonPremp;
    private JLabel NonPremp2;
    private JLabel NonPremp3;
    private JLabel space3;
    private JLabel Premp;
    private JLabel Premp2;
    private JLabel centertitle;
    private JLabel copyright;
    private JComboBox option;
    private String st;
    private DefaultTableModel model;

    public GUI() 
    {
        model = new DefaultTableModel(new String[]{"Process", "Arrival Time", "Brust Time", "Priority", "Waiting Time", "TAT"}, 0);

        table = new JTable(model);
        table.setFillsViewportHeight(true);
        tablePane = new JScrollPane(table);
        tablePane.setBounds(25, 25, 450, 250);
        
        for(int column = 0; column < table.getColumnCount(); column++)
        {
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(column).setCellRenderer(centerRenderer);
        }

        addBtn = new JButton("Add");
        addBtn.setBounds(475, 195, 95, 25);
        addBtn.setFont(new Font("Arial Black", Font.PLAIN, 11));
        addBtn.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                model.addRow(new String[]{"", "", "", "", "", ""});
            }
        });

        removeBtn = new JButton("Remove");
        removeBtn.setBounds(565, 195, 95, 25);
        removeBtn.setFont(new Font("Arial Black", Font.PLAIN, 11));
        removeBtn.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                int row = table.getSelectedRow();

                if (row > -1) 
                {
                    model.removeRow(row);
                }
            }
        });
        
        nonPreemptive = new JRadioButton("Non-Preemptive");
        nonPreemptive.setBounds(25, 280, 120 , 25);
        nonPreemptive.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        nonPreemptive.setBorder(BorderFactory.createRaisedBevelBorder());
        nonPreemptive.setBorderPainted(true);
        
        nonPreemptive.setSelected(true);
        nonPreemptive.setEnabled(true);
                
        preemptive = new JRadioButton("Preemptive");
        preemptive.setBounds(150, 280, 120 , 25);
        preemptive.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        preemptive.setEnabled(false);
        preemptive.setBorder(BorderFactory.createRaisedBevelBorder());
        preemptive.setBorderPainted(true);
        
        btng = new ButtonGroup();
        btng.add(nonPreemptive);
        btng.add(preemptive);
        
        chartPanel = new CustomPanel();
        chartPanel.setBackground(Color.BLACK);
        chartPane = new JScrollPane(chartPanel);
        chartPane.setBounds(25, 310, 450, 100);

        wtLabel = new JLabel("Avg. Waiting Time:");
        wtLabel.setBounds(25, 420, 200, 25);
        tatLabel = new JLabel("Avg. Turn Around Time:");
        tatLabel.setBounds(300, 420, 200, 25);
        wtResultLabel = new JLabel();
        wtResultLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        wtResultLabel.setBounds(145, 420, 180, 25);
        tatResultLabel = new JLabel();
        tatResultLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        tatResultLabel.setBounds(453, 420, 180, 25);
        copyright = new JLabel("Copyright @mafdymagdy");
        copyright.setBounds(490, 383, 200, 30);
        s4notes = new JLabel("    *Here are some Notes*");
        s4notes.setBounds(485, 305, 250, 25);
        space3 = new JLabel("==================");
        space3.setBounds(485, 315, 250, 25);
        s1notes = new JLabel("To add a new process, press");
        s1notes.setBounds(485, 328, 250, 25);
        s2notes = new JLabel("                                     Add");
        s2notes.setBounds(485, 345, 250, 25);
        s3notes = new JLabel("To remove it, press Remove");
        s3notes.setBounds(485, 360, 250, 25);
        space4 = new JLabel("==================");
        space4.setBounds(485, 370, 250, 25);
        combotitle = new JLabel("Algorithms: ");
        combotitle.setBounds(485, 170, 95, 25);
        space2 = new JLabel("==================");
        space2.setBounds(485, 150, 250, 25);
        snotes = new JLabel("    *Here are some Notes*");
        snotes.setBounds(485, 58, 250, 25);
        space1 = new JLabel("==================");
        space1.setBounds(485, 70, 250, 25);
        NonPremp = new JLabel("*Non-Premative: FCFS");
        NonPremp.setBounds(485, 85, 250, 25);
        NonPremp2 = new JLabel("                            SJF, PSN");
        NonPremp2.setBounds(485, 105, 250, 25);
        Premp = new JLabel("*Premative: SRT, PSP, RR");
        Premp.setBounds(485, 130, 160, 25);
        centertitle = new JLabel("CPU\n Scheduling\n Simulator");
        centertitle.setBounds(485, 10, 200, 50);
        st = "<html><u>CPU Scheduling Simulator</html></u>";
        centertitle.setText(st);
        centertitle.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

        option = new JComboBox(new String[]{"FCFS", "SJF", "SRT", "PSN", "PSP", "RR"});
        option.setBounds(565, 170, 92, 25);
        
        option.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                if(option.getSelectedItem().equals("FCFS"))
                {
                    nonPreemptive.setSelected(true);
                    nonPreemptive.setEnabled(true);
                    preemptive.setEnabled(false);
                }
                else if(option.getSelectedItem().equals("SJF"))
                {
                    nonPreemptive.setSelected(true);
                    nonPreemptive.setEnabled(true);
                    preemptive.setEnabled(false);
                }
                else if(option.getSelectedItem().equals("SRT"))
                {
                    preemptive.setSelected(true);
                    preemptive.setEnabled(true);
                    nonPreemptive.setEnabled(false);
                }
                else if(option.getSelectedItem().equals("PSN"))
                {
                    nonPreemptive.setSelected(true);
                    nonPreemptive.setEnabled(true);
                    preemptive.setEnabled(false);
                }
                else if(option.getSelectedItem().equals("PSP"))
                {
                    preemptive.setSelected(true);
                    preemptive.setEnabled(true);
                    nonPreemptive.setEnabled(false);
                }
                else if(option.getSelectedItem().equals("RR"))
                {
                    preemptive.setSelected(true);
                    preemptive.setEnabled(true);
                    nonPreemptive.setEnabled(false);
                }
               
            }
        
        });

        fileBtn = new JButton("Import from File");
        fileBtn.setBounds(500, 220, 140, 25);
        fileBtn.setFont(new Font("Arial Black", Font.BOLD, 11));
        fileBtn.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser chooser=new JFileChooser();
                int result=chooser.showOpenDialog(Premp);
                if(result==JFileChooser.APPROVE_OPTION)
                {
                    File selectedfile=chooser.getSelectedFile();
                    readprocess(selectedfile.getAbsolutePath());
                }
            }
        });
                
        calcBtn = new JButton("Calculate");
        calcBtn.setBounds(485, 250, 165, 25);
        calcBtn.setFont(new Font("Arial Black", Font.BOLD, 11));
        calcBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pressed = (String) option.getSelectedItem();
                CPUScheduler scheduler;

                switch (pressed) 
                {
                    case "FCFS":
                        scheduler = new FirstComeFirstServe();
                        break;
                    case "SJF":
                        scheduler = new ShortestJobFirst();
                        break;
                    case "SRT":
                        scheduler = new ShortestRemainingTime();
                        break;
                    case "PSN":
                        scheduler = new PriorityNonPreemptive();
                        break;
                    case "PSP":
                        scheduler = new PriorityPreemptive();
                        break;
                    case "RR":
                        String tq = JOptionPane.showInputDialog("Time Quantum");
                        if (tq == null) 
                        {
                            return;
                        }
                        scheduler = new RoundRobin();
                        scheduler.setTimeQuantum(Integer.parseInt(tq));
                        break;
                    default:
                        return;
                }

                for (int i = 0; i < model.getRowCount(); i++) 
                {
                    String process = (String) model.getValueAt(i, 0);
                    int at = Integer.parseInt((String) model.getValueAt(i, 1));
                    int bt = Integer.parseInt((String) model.getValueAt(i, 2));
                    int pl;

                    if (pressed.equals("PSN") || pressed.equals("PSP")) 
                    {
                        if (!model.getValueAt(i, 3).equals("")) 
                        {
                            pl = Integer.parseInt((String) model.getValueAt(i, 3));
                        } else {
                            pl = 1;
                        }
                    } else 
                    {
                        pl = 1;
                    }

                    scheduler.add(new Row(process, at, bt, pl));
                }

                scheduler.process();

                for (int i = 0; i < model.getRowCount(); i++) 
                {
                    String process = (String) model.getValueAt(i, 0);
                    Row row = scheduler.getRow(process);
                    model.setValueAt(row.getWaitingTime(), i, 4);
                    model.setValueAt(row.getTurnaroundTime(), i, 5);
                }
                
                wtResultLabel.setText(Double.toString(scheduler.getAverageWaitingTime()) + " ms");
                tatResultLabel.setText(Double.toString(scheduler.getAverageTurnAroundTime()) + " ms");

                chartPanel.setTimeline(scheduler.getTimeline());
            }
        });

        mainPanel = new JPanel(null);
        mainPanel.setPreferredSize(new Dimension(675, 450));
        mainPanel.add(tablePane);
        mainPanel.add(addBtn);
        mainPanel.add(removeBtn);
        mainPanel.add(chartPane);
        mainPanel.add(wtLabel);
        mainPanel.add(tatLabel);
        mainPanel.add(wtResultLabel);
        mainPanel.add(tatResultLabel);
        mainPanel.add(combotitle);
        mainPanel.add(space2);
        mainPanel.add(option);
        mainPanel.add(calcBtn);
        mainPanel.add(fileBtn);
        mainPanel.add(nonPreemptive);
        mainPanel.add(preemptive);
        mainPanel.add(snotes);
        mainPanel.add(space1);
        mainPanel.add(NonPremp);
        mainPanel.add(NonPremp2);
        mainPanel.add(Premp);
        mainPanel.add(centertitle);
        mainPanel.add(copyright);
        mainPanel.add(s1notes);
        mainPanel.add(s2notes);
        mainPanel.add(s3notes);
        mainPanel.add(s4notes);
        mainPanel.add(space3);
        mainPanel.add(space4);

        frame = new JFrame("CPU Scheduler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(mainPanel);
        frame.pack();
    }

    public static void main(String[] args) 
    {
        new GUI();
    }
    
    public  void readprocess(String filename)
    {
        BufferedReader breader;
try
{
    breader=new BufferedReader(new FileReader(filename));
    String process_row=breader.readLine(); 
    while(process_row !=null)
    {
        String [] process_terms=process_row.split("\\s");
        model.addRow(new String[]{process_terms[0], process_terms[1], process_terms[2], process_terms[3], "", ""});
        process_row=breader.readLine();
    }
}
catch(IOException e)
        {
            
        }
    }

    class CustomPanel extends JPanel 
    {

        private List<Event> timeline;

        @Override
        protected void paintComponent(Graphics g) 
        {
            super.paintComponent(g);

            if (timeline != null) 
            {
                int counter=0;
                int rowCount=model.getRowCount();
                
                for (int i = 0; i < timeline.size(); i++) 
                {
                    Event event = timeline.get(i);
                    int x = 30 * (i + 1);
                    int y = 20;
                    g.setColor(Color.WHITE);
                    g.drawRect(x, y, 30, 30);
                    g.setFont(new Font("Arial Black", Font.BOLD, 13));
                    g.drawString(event.getProcessName(), x + 10, y + 20);
                    counter+=i;
                    g.setFont(new Font("Arial Black", Font.PLAIN, 11));
                    g.drawString(Integer.toString(event.getStartTime()), x - 5, y + 45);

                    if (i == timeline.size() - 1) 
                    {
                        g.drawString(Integer.toString(event.getFinishTime()), x + 27, y + 45);
                    }
                }
                if(option.getSelectedItem().equals("FCFS") || option.getSelectedItem().equals("SJF") || option.getSelectedItem().equals("PSN"))
                g.drawString("Context Switching: " + Integer.toString(rowCount-1),305,90);
                else
                g.drawString("Context Switching: " + Integer.toString(counter-rowCount),305,90);
            }
        }

        public void setTimeline(List<Event> timeline) 
        {
            this.timeline = timeline;
            repaint();
        }
    }
}
