package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class ShoulderControl implements Initializable{
		// ���۽ð�, ����ð�, ��Ż�ð�
		@FXML private Button start1;
		@FXML private Button start2;
		@FXML private Button start3;
		@FXML private Button start4;
		@FXML private Button end1;
		@FXML private Button end2;
		@FXML private Button end3;
		@FXML private Button end4;
		@FXML public Label timeValue1;
		@FXML public Label timeValue2;
		@FXML public Label timeValue3;
		@FXML public Label timeValue4;

		// �����ġ�� ���� ����.
		private Boolean isStart1 = false; // �������� �Ǵ��� �ʵ�.
		private Timeline timeLine1; 
		private DoubleProperty timeSeconds1 = new SimpleDoubleProperty();
		private Duration time1 = Duration.ZERO;
		private Boolean isStart2 = false; // �������� �Ǵ��� �ʵ�.
		private Timeline timeLine2; 
		private DoubleProperty timeSeconds2 = new SimpleDoubleProperty();
		private Duration time2 = Duration.ZERO;
		private Boolean isStart3 = false; // �������� �Ǵ��� �ʵ�.
		private Timeline timeLine3; 
		private DoubleProperty timeSeconds3 = new SimpleDoubleProperty();
		private Duration time3 = Duration.ZERO;
		private Boolean isStart4 = false; // �������� �Ǵ��� �ʵ�.
		private Timeline timeLine4; 
		private DoubleProperty timeSeconds4 = new SimpleDoubleProperty();
		private Duration time4 = Duration.ZERO;
		

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		start1.setOnAction(e->start1HandleBtnOnAction(e));
		end1.setOnAction(e->end1HandleBtnOnAction(e));
		start2.setOnAction(e->start2HandleBtnOnAction(e));
		end2.setOnAction(e->end2HandleBtnOnAction(e));
		start3.setOnAction(e->start3HandleBtnOnAction(e));
		end3.setOnAction(e->end3HandleBtnOnAction(e));
		start4.setOnAction(e->start4HandleBtnOnAction(e));
		end4.setOnAction(e->end4HandleBtnOnAction(e));
		timeLine1 = new Timeline(); // timeLine ��ü �ʱ�ȭ
        timeLine1.setCycleCount(Timeline.INDEFINITE);
        timeLine1.play();
        timeLine2 = new Timeline(); // timeLine ��ü �ʱ�ȭ
        timeLine2.setCycleCount(Timeline.INDEFINITE);
        timeLine2.play();
        timeLine3 = new Timeline(); // timeLine ��ü �ʱ�ȭ
        timeLine3.setCycleCount(Timeline.INDEFINITE);
        timeLine3.play();
        timeLine4 = new Timeline(); // timeLine ��ü �ʱ�ȭ
        timeLine4.setCycleCount(Timeline.INDEFINITE);
        timeLine4.play();
		
		
		
	}
	
	//�ð� ��� �� ��ư 
	public void start1HandleBtnOnAction(ActionEvent event){ 
		initTimerStart1(); 
	}
	public void end1HandleBtnOnAction(ActionEvent event){
		timeLine1.stop(); //timeLine����
		System.out.println(timeValue1.getText());
	}
	public void start2HandleBtnOnAction(ActionEvent event){
		initTimerStart2(); 
	}
	public void end2HandleBtnOnAction(ActionEvent event){
		timeLine2.stop(); //timeLine����
		System.out.println(timeValue2.getText());
	}
	public void start3HandleBtnOnAction(ActionEvent event){
		initTimerStart3(); 
	}
	public void end3HandleBtnOnAction(ActionEvent event){
		timeLine3.stop(); //timeLine����
		System.out.println(timeValue3.getText());
	}
	public void start4HandleBtnOnAction(ActionEvent event){
		initTimerStart4(); 
	}
	public void end4HandleBtnOnAction(ActionEvent event){
		timeLine4.stop(); //timeLine����
		System.out.println(timeValue4.getText());
	}
	
	public void initTimerStart1() {
		// �����ġ
		timeLine1.stop(); // ���� �ð��� �����Ϸ��� timeLine�� �ʱ�ȭ�Ǿ� �ϹǷ� stop()
    	time1 = Duration.ZERO; // time�� ���� ���� ���� �� ������ 0�̵Ǿ�� ��.
    	timeValue1.textProperty().bind(timeSeconds1.asString()); // timeCheck �� timeSeconds �� ����
    	isStart1=true; //newButton�� Ŭ�������Ƿ� isStart �� true��
    	if(isStart1 == true){ 
        	
        	 if (timeLine1 == null) {
        		  // ���� �� �� ����.
             } else {
                 timeLine1 = new Timeline(
                     new KeyFrame(Duration.millis(10), // 0.01�� ������ üũ
                     new EventHandler<ActionEvent>() {
                         @Override
                         public void handle(ActionEvent t) {
                             Duration duration = ((KeyFrame)t.getSource()).getTime();
                             time1 = time1.add(duration);
                             timeSeconds1.set(time1.toSeconds());
                        
                          }
                     })
                 );
                 timeLine1.setCycleCount(Timeline.INDEFINITE);
                 timeLine1.play();
             }
    	}
        	
    }
	
	public void initTimerStart2() {
		// �����ġ
		timeLine2.stop(); // ���� �ð��� �����Ϸ��� timeLine�� �ʱ�ȭ�Ǿ� �ϹǷ� stop()
    	time2 = Duration.ZERO; // time�� ���� ���� ���� �� ������ 0�̵Ǿ�� ��.
    	timeValue2.textProperty().bind(timeSeconds2.asString()); // timeCheck �� timeSeconds �� ����
    	isStart2=true; //newButton�� Ŭ�������Ƿ� isStart �� true��
    	if(isStart2 == true){ 
        	
        	 if (timeLine2 == null) {
        		  // ���� �� �� ����.
             } else {
                 timeLine2 = new Timeline(
                     new KeyFrame(Duration.millis(10), // 0.01�� ������ üũ
                     new EventHandler<ActionEvent>() {
                         @Override
                         public void handle(ActionEvent t) {
                             Duration duration = ((KeyFrame)t.getSource()).getTime();
                             time2 = time2.add(duration);
                             timeSeconds2.set(time2.toSeconds());
                        
                          }
                     })
                 );
                 timeLine2.setCycleCount(Timeline.INDEFINITE);
                 timeLine2.play();
             }
    	}
        	
    }
	
	public void initTimerStart3() {
		// �����ġ
		timeLine3.stop(); // ���� �ð��� �����Ϸ��� timeLine�� �ʱ�ȭ�Ǿ� �ϹǷ� stop()
    	time3 = Duration.ZERO; // time�� ���� ���� ���� �� ������ 0�̵Ǿ�� ��.
    	timeValue3.textProperty().bind(timeSeconds3.asString()); // timeCheck �� timeSeconds �� ����
    	isStart3=true; //newButton�� Ŭ�������Ƿ� isStart �� true��
    	if(isStart3 == true){ 
        	
        	 if (timeLine3 == null) {
        		  // ���� �� �� ����.
             } else {
                 timeLine3 = new Timeline(
                     new KeyFrame(Duration.millis(10), // 0.01�� ������ üũ
                     new EventHandler<ActionEvent>() {
                         @Override
                         public void handle(ActionEvent t) {
                             Duration duration = ((KeyFrame)t.getSource()).getTime();
                             time3 = time3.add(duration);
                             timeSeconds3.set(time3.toSeconds());
                        
                          }
                     })
                 );
                 timeLine3.setCycleCount(Timeline.INDEFINITE);
                 timeLine3.play();
             }
    	}
        	
    }
	public void initTimerStart4() {
		// �����ġ
		timeLine4.stop(); // ���� �ð��� �����Ϸ��� timeLine�� �ʱ�ȭ�Ǿ� �ϹǷ� stop()
    	time4 = Duration.ZERO; // time�� ���� ���� ���� �� ������ 0�̵Ǿ�� ��.
    	timeValue4.textProperty().bind(timeSeconds4.asString()); // timeCheck �� timeSeconds �� ����
    	isStart4=true; //newButton�� Ŭ�������Ƿ� isStart �� true��
    	if(isStart4 == true){ 
        	
        	 if (timeLine4 == null) {
        		  // ���� �� �� ����.
             } else {
                 timeLine4 = new Timeline(
                     new KeyFrame(Duration.millis(10), // 0.01�� ������ üũ
                     new EventHandler<ActionEvent>() {
                         @Override
                         public void handle(ActionEvent t) {
                             Duration duration = ((KeyFrame)t.getSource()).getTime();
                             time4 = time4.add(duration);
                             timeSeconds4.set(time4.toSeconds());
                        
                          }
                     })
                 );
                 timeLine4.setCycleCount(Timeline.INDEFINITE);
                 timeLine4.play();
             }
    	}
        	
    }

}
