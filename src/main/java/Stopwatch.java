import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    JLabel timeLabel = new JLabel();
    int elaplsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    //formating display
    String secondsString = String.format("%02d",seconds);
    String minutesString = String.format("%02d",minutes);
    String hoursString = String.format("%02d",hours);

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elaplsedTime+=1000;
            hours = elaplsedTime / 3600000;
            minutes = (elaplsedTime / 60000) % 60;
            seconds = (elaplsedTime / 1000) % 60;
            secondsString = String.format("%02d",seconds);
            minutesString = String.format("%02d",minutes);
            hoursString = String.format("%02d",hours);
            timeLabel.setText(hoursString+":"+minutesString+":"+secondsString);

        }
    });

    Stopwatch(){

        timeLabel.setText(hoursString+":"+minutesString+":"+secondsString);
        timeLabel.setBounds(100,50,200,100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100,150,100,50);
        startButton.setFont(new Font("Verdana", Font.PLAIN,20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(200,150,100,50);
        resetButton.setFont(new Font("Verdana", Font.PLAIN,20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(timeLabel);
        frame.add(startButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==startButton){
            if (started==false){
                started=true;
                startButton.setText("Stop");
                start();
            }
            else {
                started=false;
                startButton.setText("Start");
                stop();
            }
        }
        if (e.getSource()==resetButton){
            reset();
        }
    }

    void start(){
        timer.start();
    }

    void stop(){
        timer.stop();
    }

    void reset(){
        elaplsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        secondsString = String.format("%02d",seconds);
        minutesString = String.format("%02d",minutes);
        hoursString = String.format("%02d",hours);
        timeLabel.setText(hoursString+":"+minutesString+":"+secondsString);
    }
}
