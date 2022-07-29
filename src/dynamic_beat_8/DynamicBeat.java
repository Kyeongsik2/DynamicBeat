package dynamic_beat_8;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
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
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();	// ��Ʈ�� �̹��� �ʱ�ȭ
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton gameStartButton = new JButton(gameStartButtonImage);
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private int nowSelected = 0;	// ���� ���õ� Ʈ���� ��ȣ
	
	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);	// �ػ�
		setResizable(false);							// ������ ���� �Ұ�
		setLocationRelativeTo(null);					// ��ǻ�� �߾ӿ� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// ���� â ����� ���α׷� ����
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		Music introMusic = new Music("introMusic.mp3" , true);
		introMusic.start();
		
		// Ÿ��Ʋ �̹���, ��ŸƮ �̹���, ���� �̹���, Ÿ��Ʋ ����, ���� ����
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
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	// ���콺 Ŀ�� �հ��� ������� ����
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {	// ��ư Ŭ���� ����
				System.exit(0);
			}
		});
		add(exitButton);	// ���� ���� ��ư
		
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
			public void mousePressed(MouseEvent e) {	// ���� ���� ��ư ������ ��
				introMusic.close();	// ��Ʈ�� ���� off	
				selectTrack(0);	// ù��° �� ����
				startButton.setVisible(false);	// ���� ���� ��ư �����
				quitButton.setVisible(false);	// ���� ���� ��ư �����
				leftButton.setVisible(true);	// ���� ��ư Ȱ��ȭ
				rightButton.setVisible(true);	// ������ ��ư Ȱ��ȭ
				gameStartButton.setVisible(true);	// ���� ��ŸƮ ��ư Ȱ��ȭ
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();	// �� ���� ȭ�� �̹��� ���
				isMainScreen = true;
			}
		});
		add(startButton);	// ���� ���� ��ư
		
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
				System.exit(0);	// ���� ����
			}
		});
		add(quitButton);	// ���� ���� ��ư
		
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
				// ���� ��ư �̺�Ʈ
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
				// ������ ��ư �̺�Ʈ
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
				// ���� ���� ���� �̺�Ʈ
			}
		});
		add(gameStartButton);
		
		
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}			
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {	// ���콺�� �޴��� ��� �̵�
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}			
		});
		add(menuBar);	// ��� �޴� ��
	}

	public void paint(Graphics g) {	// �̹��� ����
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);	// �̹��� ����
		screenGraphic = screenImage.getGraphics();	// ��ü�� ��� ��
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);		// ȭ�� �̹���
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 100, null);
		}
		paintComponents(g);	// �޴��� (paintComponents����)
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
	
	public void selectLeft() {	// �� ����
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	
	public void selectRight() {	// �� ������
		if(nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic != null)
			selectedMusic.close();	// ���� ����Ǵ� ���� �ݱ�
		isMainScreen = false;		// ����ȭ�� x
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		gameStartButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();	// ���õ� ���� �̹��� �ҷ�����
	}
}
