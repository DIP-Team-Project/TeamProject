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
	// ���ι�ư: ���, ����, ��, ��ü ��ư
	@FXML private Button shoulder;
	@FXML private Button chest;
	@FXML private Button back;
	@FXML private Button lowerBody;
	// � �̹���
	@FXML private ImageView image1;
	@FXML private ImageView image2;
	@FXML private ImageView image3;
	@FXML private ImageView image4;
	// ���̹�ư�� ���� ���̺� ����
	@FXML private Pane changeTable;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// ���ι�ư Ŭ�� ������
		shoulder.setOnAction(e->shoulderHandleBtnOnAction(e));// ���
		chest.setOnAction(e->chestHandleBtnOnAction(e));// ����
		back.setOnAction(e->backHandleBtnOnAction(e));// ��
		lowerBody.setOnAction(e->lowerBodyHandleBtnOnAction(e));// ��ü
		
	}
	//���ι�ư ������ �Լ�
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
			System.out.println("���� ��ư���� ���� �߻�.");
		}
		
	}
	
	// ��� Ŭ�� ������ �Լ�
	public void shoulderHandleBtnOnAction(ActionEvent event){ mainHandleBtnOnAction(1); }
	// ���� Ŭ�� ������ �Լ�
	public void chestHandleBtnOnAction(ActionEvent event) { mainHandleBtnOnAction(2); }
	// �� Ŭ�� ������ �Լ�
	public void backHandleBtnOnAction(ActionEvent event) { mainHandleBtnOnAction(3); }
	// ��ü Ŭ�� ������ �Լ�
	public void lowerBodyHandleBtnOnAction(ActionEvent event) { mainHandleBtnOnAction(4); }

}
