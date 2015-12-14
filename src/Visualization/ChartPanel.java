package Visualization;

import Model.EmployeeInformation;
import Model.EventInformation;
import Controller.*;
import java.awt.Color;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChartPanel extends JPanel implements Observer  {
//  private double[] values;
//
//  private String[] names;
	
	private ArrayList<Double> values;
	private ArrayList<String> names;
	

  private String title ="testtttttttt";
  
  public static List<EventInformation> objHolder = new ArrayList<EventInformation>();
  
 //private  WebController controller = new WebController();

 
 public static List<EventInformation> getObjHolder() {
	return objHolder;
}


public static void setObjHolder(List<EventInformation> list) {
	ChartPanel.objHolder = list;
	
	System.out.println("in panel  :" + ChartPanel.objHolder);
}


public ChartPanel(){
	 
 }
 
 
 public ChartPanel(ArrayList<Double> v, ArrayList<String> n, String t) {
    names = n;
    values = v;
    title = t;
  }

 
// public void paintComponent(Graphics g) {
//	    super.paintComponent(g);
//	    if (values == null || values.length == 0)
//	      return;
//	    double minValue = 0;
//	    double maxValue = 0;
//	    for (int i = 0; i < values.length; i++) {
//	      if (minValue > values[i])
//	        minValue = values[i];
//	      if (maxValue < values[i])
//	        maxValue = values[i];
//	    }
//
//	    Dimension d = getSize();
//	    int clientWidth = d.width;
//	    int clientHeight = d.height;
//	    int barWidth = clientWidth / values.length;
//
//	    Font titleFont = new Font("SansSerif", Font.BOLD, 20);
//	    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
//	    Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
//	    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);
//
//	    int titleWidth = titleFontMetrics.stringWidth(title);
//	    int y = titleFontMetrics.getAscent();
//	    int x = (clientWidth - titleWidth) / 2;
//	    g.setFont(titleFont);
//	    g.drawString(title, x, y);
//
//	    int top = titleFontMetrics.getHeight();
//	    int bottom = labelFontMetrics.getHeight();
//	    if (maxValue == minValue)
//	      return;
//	    double scale = (clientHeight - top - bottom) / (maxValue - minValue);
//	    y = clientHeight - labelFontMetrics.getDescent();
//	    g.setFont(labelFont);
//
//	    for (int i = 0; i < values.length; i++) {
//	      int valueX = i * barWidth + 1;
//	      int valueY = top;
//	      int height = (int) (values[i] * scale);
//	      if (values[i] >= 0)
//	        valueY += (int) ((maxValue - values[i]) * scale);
//	      else {
//	        valueY += (int) (maxValue * scale);
//	        height = -height;
//	      }
//
//	      g.setColor(Color.red);
//	      g.fillRect(valueX, valueY, barWidth - 2, height);
//	      g.setColor(Color.black);
//	      g.drawRect(valueX, valueY, barWidth - 2, height);
//	      int labelWidth = labelFontMetrics.stringWidth(names[i]);
//	      x = i * barWidth + (barWidth - labelWidth) / 2;
//	      g.drawString(names[i], x, y);
//	    }
//	  }

 
 
 
 public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (values == null || values.size() == 0)
      return;
    double minValue = 0;
    double maxValue = 0;
    for (int i = 0; i < values.size(); i++) {
      if (minValue > values.get(i))
        minValue = values.get(i);
      if (maxValue <values.get(i))
        maxValue = values.get(i);
    }

    Dimension d = getSize();
    int clientWidth = d.width;
    int clientHeight = d.height;
    int barWidth = clientWidth / values.size();

    Font titleFont = new Font("SansSerif", Font.BOLD, 20);
    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
    Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

    int titleWidth = titleFontMetrics.stringWidth(title);
    int y = titleFontMetrics.getAscent();
    int x = (clientWidth - titleWidth) / 2;
    g.setFont(titleFont);
    g.drawString(title, x, y);

    int top = titleFontMetrics.getHeight();
    int bottom = labelFontMetrics.getHeight();
    if (maxValue == minValue)
      return;
    double scale = (clientHeight - top - bottom) / (maxValue - minValue);
    y = clientHeight - labelFontMetrics.getDescent();
    g.setFont(labelFont);

    for (int i = 0; i < values.size(); i++) {
      int valueX = i * barWidth + 1;
      int valueY = top;
      int height = (int) (values.get(i) * scale);
      if (values.get(i)>= 0)
        valueY += (int) ((maxValue - values.get(i)) * scale);
      else {
        valueY += (int) (maxValue * scale);
        height = -height;
      }

      g.setColor(Color.red);
      g.fillRect(valueX, valueY, barWidth - 2, height);
      g.setColor(Color.black);
      g.drawRect(valueX, valueY, barWidth - 2, height);
      int labelWidth = labelFontMetrics.stringWidth(names.get(i));
      x = i * barWidth + (barWidth - labelWidth) / 2;
      g.drawString(names.get(i), x, y);
    }
  }

  public static void main() {
    JFrame f = new JFrame();
    f.setSize(400, 300);
    
    
 //   EventInformation eventInfo = new EventInformation();
   // PersonalInfoController infoController = new PersonalInfoController();
    
    
    // objHolder = controller.eventInformationObjHolder;
     
    // System.out.println(controller.eventInformationObjHolder.get(0).getExtraPay() + "hahahahahahaha");
    
    double[] values = new double[5];
    
    ArrayList<Double> vals = new ArrayList<Double>();
    ArrayList<String> nam = new ArrayList<String>();
    
    
    for(int i=0;i<objHolder.size();i++)
    {
    	vals.add(objHolder.get(i).getHoursWorked());
    	nam.add("hours" + objHolder.get(i).getHoursWorked());
    }
    
//    System.out.println("my list  " + vals);
//    System.out.println(nam);
    
    double[] temp = new double[vals.size()];
    String[] names = new String[5];
    values[0] = 1;
    names[0] = "Item 1";

    values[1] = 2;
    names[1] = "Item 2";

    values[2] = 8;
    names[2] = "Item 3";
    
    values[3] = 5;
    names[3] = "Item 4";
   
    values[4] = 8;
    names[4] = "Item 5";
    
    

    //f.getContentPane().add(new ChartPanel(values, names, "title"));
    f.getContentPane().add(new ChartPanel(vals, nam, "HOURS/PAY"));

    WindowListener wndCloser = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
    f.addWindowListener(wndCloser);
    f.setVisible(true);
  }

public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	ArrayList<EventInformation> eventInfo = new ArrayList<EventInformation>();
	
    System.out.println("in obsrever");   
	System.out.println("argu from obsrver" + arg);
	eventInfo= (ArrayList<EventInformation>) arg;
	System.out.println("customet name of first person :" + eventInfo.get(0).getCustomerName());
     
	
}
}