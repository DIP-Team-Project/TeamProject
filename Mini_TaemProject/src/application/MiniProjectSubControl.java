// �ι�° ���â
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
	// �ݱ� ��ư 
	@FXML private Button p2endButton;
	// ��̸�, ��Ʈ, ����,Ÿ�� �� �ֱ�.
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
	//����
	@FXML private Label p2exerciseName;
	//�ð�
	@FXML private Label p2date;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LocalDateTime ldt = LocalDateTime.now();
		p2date.setText(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt).toString());
		p2exerciseName.setText(part);
		p2endButton.setOnAction(e->closeBtnOnAction(e));
		nameOfList();// ��̸� �ֱ�.
		setOfList();// ��Ʈ
		countOfList();// ����
		timeOfList();// �� Ÿ�̸�
	}
	
	// �ݱ� ��ư Ŭ���� ������
	public void closeBtnOnAction(ActionEvent e) {
		checkList.clear();
		setList.clear();
		countList.clear();
		dialog.close();
	}
	
	//����Ʈ�� �� �ֱ�.
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
				p2set1.setText(String.valueOf(setList.get(i)) + "��Ʈ");
				break;
			case 1:
				p2set2.setText(String.valueOf(setList.get(i)) + "��Ʈ");
				break;
			case 2:
				p2set3.setText(String.valueOf(setList.get(i)) + "��Ʈ");
				break;
			case 3:
				p2set4.setText(String.valueOf(setList.get(i)) + "��Ʈ");
				break;
			}
		}
	}
	
	public void countOfList() {
	
		for(int i = 0; i < countList.size(); i++) {
			switch(i) {
			case 0:
				p2count1.setText(String.valueOf(countList.get(i)) + "��");
				break;
			case 1:
				p2count2.setText(String.valueOf(countList.get(i)) + "��");
				break;
			case 2:
				p2count3.setText(String.valueOf(countList.get(i)) + "��");
				break;
			case 3:
				p2count4.setText(String.valueOf(countList.get(i)) + "��");
			}
		}
	}
	
	public void timeOfList() {
		
		for(int i = 0; i < timeList.size(); i++) {
			switch(i) {
			case 0:
				p2timeValue1.setText(String.valueOf(timeList.get(i)) + "��");
				break;
			case 1:
				p2timeValue2.setText(String.valueOf(timeList.get(i)) + "��");
				break;
			case 2:
				p2timeValue3.setText(String.valueOf(timeList.get(i)) + "��");
				break;
			case 3:
				p2timeValue4.setText(String.valueOf(timeList.get(i)) + "��");
			}
		}
	}
}
