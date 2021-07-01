package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MiniProjectMainControl implements Initializable{
	// 메인버튼: 어깨, 가슴, 등, 하체 버튼
	@FXML private Button shoulder;
	@FXML private Button chest;
	@FXML private Button back;
	@FXML private Button lowerBody;
	// 운동 이미지
	@FXML private ImageView image1;
	@FXML private ImageView image2;
	@FXML private ImageView image3;
	@FXML private ImageView image4;
	// 메이버튼에 따른 테이블 변경
	@FXML private Pane changeTable;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 메인버튼 클릭 리스너
		shoulder.setOnAction(e->shoulderHandleBtnOnAction(e));// 어깨
		chest.setOnAction(e->chestHandleBtnOnAction(e));// 가슴
		back.setOnAction(e->backHandleBtnOnAction(e));// 등
		lowerBody.setOnAction(e->lowerBodyHandleBtnOnAction(e));// 하체
		
	}
	//메인버튼 리스너 함수
	public void mainHandleBtnOnAction(int a) {
		changeTable.getChildren().clear();
		try {
			switch(a) {
			case 1:
				changeTable.getChildren().add(FXMLLoader.load(getClass().getResource("shoulderData.fxml")));
				break;
			case 2:
				changeTable.getChildren().add(FXMLLoader.load(getClass().getResource("chestData.fxml")));
				break;
			case 3:
				changeTable.getChildren().add(FXMLLoader.load(getClass().getResource("backData.fxml")));
				break;
			case 4:
				changeTable.getChildren().add(FXMLLoader.load(getClass().getResource("lowerBodyData.fxml")));
			}
		}catch (IOException e) {
			System.out.println("메인 버튼에서 에러 발생.");
		}
		
	}
	
	// 어깨 클릭 리스너 함수
	public void shoulderHandleBtnOnAction(ActionEvent event){ mainHandleBtnOnAction(1); }
	// 가슴 클릭 리스너 함수
	public void chestHandleBtnOnAction(ActionEvent event) { mainHandleBtnOnAction(2); }
	// 등 클릭 리스너 함수
	public void backHandleBtnOnAction(ActionEvent event) { mainHandleBtnOnAction(3); }
	// 하체 클릭 리스너 함수
	public void lowerBodyHandleBtnOnAction(ActionEvent event) { mainHandleBtnOnAction(4); }

}
