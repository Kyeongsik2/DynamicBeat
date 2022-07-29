package dynamic_beat_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground;
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);	// 해상도
		setResizable(false);							// 사이즈 변경 불가
		setLocationRelativeTo(null);					// 컴퓨터 중앙에 실행
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 게임 창 종료시 프로그램 종료
		setVisible(true);	//
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();	// 인트로 이미지 초기화
		
	}

	public void paint(Graphics g) {	// 이미지 생성
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);	// 이미지 삽입
		screenGraphic = screenImage.getGraphics();	// 객체를 얻어 옴
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);		// 화면 이미지
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();
	}
}
