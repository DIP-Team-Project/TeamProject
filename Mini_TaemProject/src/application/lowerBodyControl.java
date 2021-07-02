package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class lowerBodyControl extends MiniProjectMainControl implements Initializable{
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
		
		// üũ�ڽ�
		@FXML public CheckBox exercise1;
		@FXML public CheckBox exercise2;
		@FXML public CheckBox exercise3;
		@FXML public CheckBox exercise4;
		
		// ��Ʈ
		@FXML private TextField set1;
		@FXML private TextField set2;
		@FXML private TextField set3;
		@FXML private TextField set4;
		// count
		@FXML private TextField count1;
		@FXML private TextField count2;
		@FXML private TextField count3;
		@FXML private TextField count4;
		

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
		// ����, ���� ��ư ������
		start1.setOnAction(e->start1HandleBtnOnAction(e));
		end1.setOnAction(e->end1HandleBtnOnAction(e));
		start2.setOnAction(e->start2HandleBtnOnAction(e));
		end2.setOnAction(e->end2HandleBtnOnAction(e));
		start3.setOnAction(e->start3HandleBtnOnAction(e));
		end3.setOnAction(e->end3HandleBtnOnAction(e));
		start4.setOnAction(e->start4HandleBtnOnAction(e));
		end4.setOnAction(e->end4HandleBtnOnAction(e));
		// üũ�ڽ� ������.
		exercise1.setOnMouseClicked(e->initCheckBox1(e));
		exercise2.setOnMouseClicked(e->initCheckBox2(e));
		exercise3.setOnMouseClicked(e->initCheckBox3(e));
		exercise4.setOnMouseClicked(e->initCheckBox4(e));
		
		// timer ��ü
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
	
	// �ð� ��� �� ��ư 
	public void start1HandleBtnOnAction(ActionEvent event){ 
		initTimerStart1(); 
		setList.add(set1.getText());
		countList.add(count1.getText());
		System.out.println(setList.get(0));
		System.out.println(countList.get(0));
	}
	public void end1HandleBtnOnAction(ActionEvent event){
		timeLine1.stop(); //timeLine����
		System.out.println(timeValue1.getText());
		timeList.add(timeValue1.getText());
	}
	public void start2HandleBtnOnAction(ActionEvent event){
		initTimerStart2(); 
		setList.add(set2.getText());
		countList.add(count2.getText());
	}
	public void end2HandleBtnOnAction(ActionEvent event){
		timeLine2.stop(); //timeLine����
		System.out.println(timeValue2.getText());
		timeList.add(timeValue2.getText());
	}
	public void start3HandleBtnOnAction(ActionEvent event){
		initTimerStart3(); 
		setList.add(set3.getText());
		countList.add(count3.getText());
	}
	public void end3HandleBtnOnAction(ActionEvent event){
		timeLine3.stop(); //timeLine����
		System.out.println(timeValue3.getText());
		timeList.add(timeValue3.getText());
	}
	public void start4HandleBtnOnAction(ActionEvent event){
		initTimerStart4(); 
		setList.add(set4.getText());
		countList.add(count4.getText());
	}
	public void end4HandleBtnOnAction(ActionEvent event){
		timeLine4.stop(); //timeLine����
		System.out.println(timeValue4.getText());
		timeList.add(timeValue4.getText());
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
	
	// üũ�ڽ�
	public void initCheckBox1(MouseEvent e2) {
		 // üũ�ڽ�
		try {
			if(exercise1.isSelected()) {
	        	checkList.add(exercise1.getText());
	        }else {
	        	checkList.remove(exercise1.getText());
	        }
			
		}catch(Exception e) {
			System.out.println("��ٷ��ּ���.");
		}
	}
	public void initCheckBox2(MouseEvent e2) {
		 // üũ�ڽ�
		try {
			if(exercise2.isSelected()) {
	        	checkList.add(exercise2.getText());
	        }else {
	        	checkList.remove(exercise2.getText());
	        }
			
		}catch(Exception e) {
			System.out.println("��ٷ��ּ���.");
		}
	}
	public void initCheckBox3(MouseEvent e2) {
		 // üũ�ڽ�
		try {
			if(exercise3.isSelected()) {
	        	checkList.add(exercise3.getText());
	        }else {
	        	checkList.remove(exercise3.getText());
	        }
			
		}catch(Exception e) {
			System.out.println("��ٷ��ּ���.");
		}
	}
	public void initCheckBox4(MouseEvent e2) {
		 // üũ�ڽ�
		try {
			if(exercise4.isSelected()) {
	        	checkList.add(exercise4.getText());
	        }else {
	        	checkList.remove(exercise4.getText());
	        }
			
		}catch(Exception e) {
			System.out.println("��ٷ��ּ���.");
		}
	}
}
