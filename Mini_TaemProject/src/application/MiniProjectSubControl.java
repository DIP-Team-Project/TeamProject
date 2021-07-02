// 두번째 결과창
package application;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MiniProjectSubControl extends MiniProjectMainControl implements Initializable{
	// 닫기 버튼 
	@FXML private Button p2endButton;
	// 운동이름, 세트, 개수,타임 값 넣기.
	@FXML private Label p2exercise1;
	@FXML private Label p2exercise2;
	@FXML private Label p2exercise3;
	@FXML private Label p2exercise4;
	
	@FXML private Label p2set1;
	@FXML private Label p2set2;
	@FXML private Label p2set3;
	@FXML private Label p2set4;
	
	@FXML private Label p2count1;
	@FXML private Label p2count2;
	@FXML private Label p2count3;
	@FXML private Label p2count4;
	
	@FXML private Label p2timeValue1;
	@FXML private Label p2timeValue2;
	@FXML private Label p2timeValue3;
	@FXML private Label p2timeValue4;
	//부위
	@FXML private Label p2exerciseName;
	//시간
	@FXML private Label p2date;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LocalDateTime ldt = LocalDateTime.now();
		p2date.setText(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt).toString());
		p2exerciseName.setText(part);
		p2endButton.setOnAction(e->closeBtnOnAction(e));
		nameOfList();// 운동이름 넣기.
		setOfList();// 세트
		countOfList();// 개수
		timeOfList();// 총 타이머
	}
	
	// 닫기 버튼 클릭시 리스너
	public void closeBtnOnAction(ActionEvent e) {
		checkList.clear();
		setList.clear();
		countList.clear();
		dialog.close();
	}
	
	//리스트에 값 넣기.
	public void nameOfList() {
		for(int i = 0; i < checkList.size(); i++) {
			switch(i) {
			case 0:
				p2exercise1.setText(checkList.get(i));
				break;
			case 1:
				p2exercise2.setText(checkList.get(i));
				break;
			case 2:
				p2exercise3.setText(checkList.get(i));
				break;
			case 3:
				p2exercise4.setText(checkList.get(i));
			}
		}
	}
	
	public void setOfList() {
		for(int i = 0; i < setList.size(); i++) {
			switch(i) {
			case 0:
				p2set1.setText(String.valueOf(setList.get(i)) + "세트");
				break;
			case 1:
				p2set2.setText(String.valueOf(setList.get(i)) + "세트");
				break;
			case 2:
				p2set3.setText(String.valueOf(setList.get(i)) + "세트");
				break;
			case 3:
				p2set4.setText(String.valueOf(setList.get(i)) + "세트");
				break;
			}
		}
	}
	
	public void countOfList() {
	
		for(int i = 0; i < countList.size(); i++) {
			switch(i) {
			case 0:
				p2count1.setText(String.valueOf(countList.get(i)) + "개");
				break;
			case 1:
				p2count2.setText(String.valueOf(countList.get(i)) + "개");
				break;
			case 2:
				p2count3.setText(String.valueOf(countList.get(i)) + "개");
				break;
			case 3:
				p2count4.setText(String.valueOf(countList.get(i)) + "개");
			}
		}
	}
	
	public void timeOfList() {
		
		for(int i = 0; i < timeList.size(); i++) {
			switch(i) {
			case 0:
				p2timeValue1.setText(String.valueOf(timeList.get(i)) + "초");
				break;
			case 1:
				p2timeValue2.setText(String.valueOf(timeList.get(i)) + "초");
				break;
			case 2:
				p2timeValue3.setText(String.valueOf(timeList.get(i)) + "초");
				break;
			case 3:
				p2timeValue4.setText(String.valueOf(timeList.get(i)) + "초");
			}
		}
	}
}
