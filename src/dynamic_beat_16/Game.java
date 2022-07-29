package dynamic_beat_16;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgmentLineImage = new ImageIcon(Main.class.getResource("../images/judgmentLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image purpleFlareImage;
	private Image judgeImage;
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	

	private String titleName;
	private String start;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String start, String musicTitle) {
		this.titleName = titleName;
		this.start = start;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
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
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);	// 사용되지 않는 노트 지워짐
				i--;
			} else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);	// 안티에일리어싱 (텍스트 깨짐x)
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("titleName", 20, 702);
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
		g.drawImage(purpleFlareImage, 500, 430, null);
		g.drawImage(judgeImage, 460, 420, null);
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
		
	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("sound1.mp3", false).start();
	}
	
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("sound1.mp3", false).start();
	}
	
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("sound1.mp3", false).start();
	}
	
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("sound2.mp3", false).start();
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		
	}
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("sound1.mp3", false).start();
	}
	
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("sound1.mp3", false).start();
	}
	
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("sound1.mp3", false).start();
	}
	
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
		
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if(titleName.equals("Tell Me That I Can't")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime + gap * 2, "F"),
					new Beat(startTime + gap * 4, "J"),
					new Beat(startTime + gap * 6, "S"),
					new Beat(startTime + gap * 8, "D"),
					new Beat(startTime + gap * 10, "F"),
					new Beat(startTime + gap * 12, "J"),
					new Beat(startTime + gap * 14, "K"),
					new Beat(startTime + gap * 18, "L"),
					new Beat(startTime + gap * 20, "K"),
					new Beat(startTime + gap * 22, "J"),
					new Beat(startTime + gap * 24, "Space"),
					new Beat(startTime + gap * 26, "F"),
					new Beat(startTime + gap * 28, "D"),
					new Beat(startTime + gap * 30, "S"),
					new Beat(startTime + gap * 32, "D"),
					new Beat(startTime + gap * 34, "F"),
					new Beat(startTime + gap * 36, "Space"),
					new Beat(startTime + gap * 38, "J"),
					new Beat(startTime + gap * 40, "K"),
					new Beat(startTime + gap * 42, "L"),
					
			};
		}
		else if(titleName.equals("Would it Kill You")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime + gap * 2, "F"),
					new Beat(startTime + gap * 4, "J"),
					new Beat(startTime + gap * 6, "S"),
					new Beat(startTime + gap * 8, "D"),
					new Beat(startTime + gap * 10, "F"),
					new Beat(startTime + gap * 12, "J"),
					new Beat(startTime + gap * 14, "K"),
					new Beat(startTime + gap * 18, "L"),
					new Beat(startTime + gap * 20, "K"),
					new Beat(startTime + gap * 22, "J"),
					new Beat(startTime + gap * 24, "Space"),
					new Beat(startTime + gap * 26, "F"),
					new Beat(startTime + gap * 28, "D"),
					new Beat(startTime + gap * 30, "S"),
					new Beat(startTime + gap * 32, "D"),
					new Beat(startTime + gap * 34, "F"),
					new Beat(startTime + gap * 36, "Space"),
					new Beat(startTime + gap * 38, "J"),
					new Beat(startTime + gap * 40, "K"),
					new Beat(startTime + gap * 42, "L"),
			};
			
		}
		else if(titleName.equals("Fingerprint")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime + gap * 2, "F"),
					new Beat(startTime + gap * 4, "J"),
					new Beat(startTime + gap * 6, "S"),
					new Beat(startTime + gap * 8, "D"),
					new Beat(startTime + gap * 10, "F"),
					new Beat(startTime + gap * 12, "J"),
					new Beat(startTime + gap * 14, "K"),
					new Beat(startTime + gap * 18, "L"),
					new Beat(startTime + gap * 20, "K"),
					new Beat(startTime + gap * 22, "J"),
					new Beat(startTime + gap * 24, "Space"),
					new Beat(startTime + gap * 26, "F"),
					new Beat(startTime + gap * 28, "D"),
					new Beat(startTime + gap * 30, "S"),
					new Beat(startTime + gap * 32, "D"),
					new Beat(startTime + gap * 34, "F"),
					new Beat(startTime + gap * 36, "Space"),
					new Beat(startTime + gap * 38, "J"),
					new Beat(startTime + gap * 40, "K"),
					new Beat(startTime + gap * 42, "L"),
			};
		}
		int i = 0;
		gameMusic.start();
		while(i < beats.length &&  !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void judge(String input) {
		for(int i = 0; i< noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {	// 판정 이미지
//		if(!judge.equals("None")) {
//			purpleFlareImage = new ImageIcon(Main.class.getResource("../images/purpleFlare.png")).getImage();
//		}	// 투명 이미지 구해서 넣기
		if(!judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
		}
		if(!judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
		}
		if(!judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
		}
		if(!judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
		}
		if(!judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
		}
		if(!judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
		}
		
	}
}
