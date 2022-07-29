package dynamic_beat_10;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon gameStartButtonImage = new ImageIcon(Main.class.getResource("../images/gameStartButton.png"));
	private ImageIcon gameStartButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/gameStartButtonEntered.png"));
	private ImageIcon backButtonImage = new ImageIcon(Main.class.getResource("../images/backButton.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgmentLineImage = new ImageIcon(Main.class.getResource("../images/judgmentLine.png")).getImage();
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();	// 인트로 이미지 초기화
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton gameStartButton = new JButton(gameStartButtonImage);
	private JButton backButton = new JButton(backButtonImage);	
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private Music introMusic = new Music("introMusic.mp3" , true);
	private int nowSelected = 0;	// 현재 선택된 트랙의 번호
	
	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);	// 해상도
		setResizable(false);							// 사이즈 변경 불가
		setLocationRelativeTo(null);					// 컴퓨터 중앙에 실행
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 게임 창 종료시 프로그램 종료
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		introMusic.start();
		
		// 타이틀 이미지, 스타트 이미지, 게임 이미지, 타이틀 뮤직, 게임 뮤직
		trackList.add(new Track("Tell Me That I Can't (Clean)_title.png", "Tell Me That I Can't (Clean)_start.png", "Tell Me That I Can't (Clean) - NEFFEX_game.jpg", "Tell Me That I Can't (Clean) - NEFFEX.mp3", "Tell Me That I Can't (Clean) - NEFFEX.mp3 "));
		trackList.add(new Track("Would it Kill You_ - Mini Vandals_title.png", "Would it Kill You_ - Mini Vandals_start.png", "Would it Kill You_ - Mini Vandals_game.jpg", "Would it Kill You_ - Mini Vandals.mp3", "Would it Kill You_ - Mini Vandals.mp3"));
		trackList.add(new Track("Fingerprint - Mini Vandals_title.png", "Fingerprint - Mini Vandals_start.png", "Fingerprint - Mini Vandals_game.jpg", "Fingerprint - Mini Vandals.mp3", "Fingerprint - Mini Vandals.mp3"));
		
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
		add(exitButton);	// 게임 종료 버튼
		
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);		
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {	// 게임 실행 버튼 눌렀을 때
				enterMain();	
				
			}
		});
		add(startButton);	// 게임 실행 버튼
		
		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);		
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);	// 게임 종료
			}
		});
		add(quitButton);	// 게임 종료 버튼
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);		
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectLeft();
				// 왼쪽 버튼 이벤트
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);		
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectRight();
				// 오른쪽 버튼 이벤트
			}
		});
		add(rightButton);
		
		gameStartButton.setVisible(false);
		gameStartButton.setBounds(550, 580, 200, 100);
		gameStartButton.setBorderPainted(false);
		gameStartButton.setContentAreaFilled(false);
		gameStartButton.setFocusPainted(false);		
		gameStartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				gameStartButton.setIcon(gameStartButtonEnteredImage);
				gameStartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				gameStartButton.setIcon(gameStartButtonImage);
				gameStartButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "Start");
				// 선택 게임 시작 이벤트
			}
		});
		add(gameStartButton);
		
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);		
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				backMain();
				// 메인화면으로 돌아가는 이벤트
			}
		});
		add(backButton);		
		
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
		add(menuBar);	// 상단 메뉴 바
	}

	public void paint(Graphics g) {	// 이미지 생성
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);	// 이미지 삽입
		screenGraphic = screenImage.getGraphics();	// 객체를 얻어 옴
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);		// 화면 이미지
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 100, null);
		}
		if(isGameScreen) {
			g.drawImage(noteRouteImage, 228, 30, null);
			g.drawImage(noteRouteImage, 332, 30, null);
			g.drawImage(noteRouteImage, 436, 30, null);
			g.drawImage(noteRouteImage, 540, 30, null);
			g.drawImage(noteRouteImage, 640, 30, null);
			g.drawImage(noteRouteImage, 744, 30, null);
			g.drawImage(noteRouteImage, 848, 30, null);
			g.drawImage(noteRouteImage, 952, 30, null);
			g.drawImage(noteRouteLineImage, 224, 30, null);
			g.drawImage(noteRouteLineImage, 328, 30, null);
			g.drawImage(noteRouteLineImage, 432, 30, null);
			g.drawImage(noteRouteLineImage, 536, 30, null);
			g.drawImage(noteRouteLineImage, 740, 30, null);
			g.drawImage(noteRouteLineImage, 844, 30, null);
			g.drawImage(noteRouteLineImage, 948, 30, null);
			g.drawImage(noteRouteLineImage, 1052, 30, null);
			g.drawImage(gameInfoImage, 0, 660, null);
			g.drawImage(judgmentLineImage, 0, 580, null);
			g.drawImage(noteBasicImage, 228, 120, null);
			g.drawImage(noteBasicImage, 332, 580, null);
			g.drawImage(noteBasicImage, 436, 500, null);
			g.drawImage(noteBasicImage, 540, 340, null);
			g.drawImage(noteBasicImage, 640, 340, null);
			g.drawImage(noteBasicImage, 744, 325, null);
			g.drawImage(noteBasicImage, 848, 305, null);
			g.drawImage(noteBasicImage, 952, 305, null);
			g.setColor(Color.white);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);	// 안티에일리어싱 (텍스트 깨짐x)
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Tell Me That I Can't (Clean) - NEFFEX", 20, 702);
			g.setColor(Color.DARK_GRAY);
			g.drawString("S", 270, 615);
			g.drawString("D", 374, 615);
			g.drawString("F", 478, 615);
			g.drawString("Space Bar", 580, 615);
			g.drawString("J", 784, 615);
			g.drawString("K", 889, 615);
			g.drawString("L", 993, 615);
			g.setColor(Color.LIGHT_GRAY);
			g.setFont(new Font("Elephant", Font.BOLD, 30));
			g.drawString("000000", 565, 702);
		}
		paintComponents(g);	// 메뉴바 (paintComponents고정)
		this.repaint();
	}
	
	public void selectTrack(int nowSelected) {	// Track
		if(selectedMusic != null)	
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	public void selectLeft() {	// 곡 왼쪽
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	
	public void selectRight() {	// 곡 오른쪽
		if(nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic != null)
			selectedMusic.close();	// 현재 재생되는 음악 닫기
		isMainScreen = false;		// 메인화면 x
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		gameStartButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();	// 선택된 게임 이미지 불러오기
		backButton.setVisible(true);
		isGameScreen = true;
	}
	
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		rightButton.setVisible(true);
		gameStartButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
	}
	
	public void enterMain() {
		startButton.setVisible(false);	// 게임 실행 버튼 숨기기
		quitButton.setVisible(false);	// 게임 종료 버튼 숨기기
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();	// 곡 선택 화면 이미지 출력
		isMainScreen = true;
		leftButton.setVisible(true);	// 왼쪽 버튼 활성화
		rightButton.setVisible(true);	// 오른쪽 버튼 활성화
		gameStartButton.setVisible(true);	// 게임 스타트 버튼 활성화
		introMusic.close();	// 인트로 뮤직 off
		selectTrack(0);	// 첫번째 곡 실행
	}
}
