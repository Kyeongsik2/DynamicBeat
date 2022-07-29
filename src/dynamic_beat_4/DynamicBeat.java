package dynamic_beat_4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dynamic_beat_5.Music;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();	// 인트로 이미지 초기화
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	private int mouseX, mouseY;
	
	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);	// 해상도
		setResizable(false);							// 사이즈 변경 불가
		setLocationRelativeTo(null);					// 컴퓨터 중앙에 실행
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 게임 창 종료시 프로그램 종료
		setVisible(true);	//
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		Music introMusic = new Music("introMusic.mp3" , true);
		introMusic.start();
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);		
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	// 마우스 커서 손가락 모양으로 변경
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {	// 버튼 클릭시 종료
				System.exit(0);
			}
		});
		add(exitButton);
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}			
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {	// 마우스로 메뉴바 잡고 이동
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}			
		});
		add(menuBar);
	}

	public void paint(Graphics g) {	// 이미지 생성
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);	// 이미지 삽입
		screenGraphic = screenImage.getGraphics();	// 객체를 얻어 옴
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);		// 화면 이미지
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);	// 메뉴바 (paintComponents고정)
		this.repaint();
	}
}
