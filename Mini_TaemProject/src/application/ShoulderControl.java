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
		// 시작시간, 종료시간, 토탈시간
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

		// 스톱워치에 사용된 변수.
		private Boolean isStart1 = false; // 시작인지 판단할 필드.
		private Timeline timeLine1; 
		private DoubleProperty timeSeconds1 = new SimpleDoubleProperty();
		private Duration time1 = Duration.ZERO;
		private Boolean isStart2 = false; // 시작인지 판단할 필드.
		private Timeline timeLine2; 
		private DoubleProperty timeSeconds2 = new SimpleDoubleProperty();
		private Duration time2 = Duration.ZERO;
		private Boolean isStart3 = false; // 시작인지 판단할 필드.
		private Timeline timeLine3; 
		private DoubleProperty timeSeconds3 = new SimpleDoubleProperty();
		private Duration time3 = Duration.ZERO;
		private Boolean isStart4 = false; // 시작인지 판단할 필드.
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
		timeLine1 = new Timeline(); // timeLine 객체 초기화
        timeLine1.setCycleCount(Timeline.INDEFINITE);
        timeLine1.play();
        timeLine2 = new Timeline(); // timeLine 객체 초기화
        timeLine2.setCycleCount(Timeline.INDEFINITE);
        timeLine2.play();
        timeLine3 = new Timeline(); // timeLine 객체 초기화
        timeLine3.setCycleCount(Timeline.INDEFINITE);
        timeLine3.play();
        timeLine4 = new Timeline(); // timeLine 객체 초기화
        timeLine4.setCycleCount(Timeline.INDEFINITE);
        timeLine4.play();
		
		
		
	}
	
	//시간 계산 및 버튼 
	public void start1HandleBtnOnAction(ActionEvent event){ 
		initTimerStart1(); 
	}
	public void end1HandleBtnOnAction(ActionEvent event){
		timeLine1.stop(); //timeLine멈춤
		System.out.println(timeValue1.getText());
	}
	public void start2HandleBtnOnAction(ActionEvent event){
		initTimerStart2(); 
	}
	public void end2HandleBtnOnAction(ActionEvent event){
		timeLine2.stop(); //timeLine멈춤
		System.out.println(timeValue2.getText());
	}
	public void start3HandleBtnOnAction(ActionEvent event){
		initTimerStart3(); 
	}
	public void end3HandleBtnOnAction(ActionEvent event){
		timeLine3.stop(); //timeLine멈춤
		System.out.println(timeValue3.getText());
	}
	public void start4HandleBtnOnAction(ActionEvent event){
		initTimerStart4(); 
	}
	public void end4HandleBtnOnAction(ActionEvent event){
		timeLine4.stop(); //timeLine멈춤
		System.out.println(timeValue4.getText());
	}
	
	public void initTimerStart1() {
		// 스톱워치
		timeLine1.stop(); // 새로 시간을 측정하려면 timeLine이 초기화되야 하므로 stop()
    	time1 = Duration.ZERO; // time의 값도 새로 측정 할 때마다 0이되어야 함.
    	timeValue1.textProperty().bind(timeSeconds1.asString()); // timeCheck 에 timeSeconds 값 대입
    	isStart1=true; //newButton을 클릭했으므로 isStart 값 true로
    	if(isStart1 == true){ 
        	
        	 if (timeLine1 == null) {
        		  // 딱히 할 거 없음.
             } else {
                 timeLine1 = new Timeline(
                     new KeyFrame(Duration.millis(10), // 0.01초 단위로 체크
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
		// 스톱워치
		timeLine2.stop(); // 새로 시간을 측정하려면 timeLine이 초기화되야 하므로 stop()
    	time2 = Duration.ZERO; // time의 값도 새로 측정 할 때마다 0이되어야 함.
    	timeValue2.textProperty().bind(timeSeconds2.asString()); // timeCheck 에 timeSeconds 값 대입
    	isStart2=true; //newButton을 클릭했으므로 isStart 값 true로
    	if(isStart2 == true){ 
        	
        	 if (timeLine2 == null) {
        		  // 딱히 할 거 없음.
             } else {
                 timeLine2 = new Timeline(
                     new KeyFrame(Duration.millis(10), // 0.01초 단위로 체크
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
		// 스톱워치
		timeLine3.stop(); // 새로 시간을 측정하려면 timeLine이 초기화되야 하므로 stop()
    	time3 = Duration.ZERO; // time의 값도 새로 측정 할 때마다 0이되어야 함.
    	timeValue3.textProperty().bind(timeSeconds3.asString()); // timeCheck 에 timeSeconds 값 대입
    	isStart3=true; //newButton을 클릭했으므로 isStart 값 true로
    	if(isStart3 == true){ 
        	
        	 if (timeLine3 == null) {
        		  // 딱히 할 거 없음.
             } else {
                 timeLine3 = new Timeline(
                     new KeyFrame(Duration.millis(10), // 0.01초 단위로 체크
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
		// 스톱워치
		timeLine4.stop(); // 새로 시간을 측정하려면 timeLine이 초기화되야 하므로 stop()
    	time4 = Duration.ZERO; // time의 값도 새로 측정 할 때마다 0이되어야 함.
    	timeValue4.textProperty().bind(timeSeconds4.asString()); // timeCheck 에 timeSeconds 값 대입
    	isStart4=true; //newButton을 클릭했으므로 isStart 값 true로
    	if(isStart4 == true){ 
        	
        	 if (timeLine4 == null) {
        		  // 딱히 할 거 없음.
             } else {
                 timeLine4 = new Timeline(
                     new KeyFrame(Duration.millis(10), // 0.01초 단위로 체크
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
