package dynamic_beat_14;

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
			note.screenDraw(g);
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);	// ¾ÈÆ¼¿¡ÀÏ¸®¾î½Ì (ÅØ½ºÆ® ±úÁüx)
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
		g.drawString(titleName, 20, 702);
	}
	
	public void pressS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("sound1.mp3", false).start();
	}
	
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("sound1.mp3", false).start();
	}
	
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("sound1.mp3", false).start();
	}
	
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("sound2.mp3", false).start();
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("sound1.mp3", false).start();
	}
	
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("sound1.mp3", false).start();
	}
	
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("sound1.mp3", false).start();
	}
	
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
		
	@Override
	public void run() {
		dropNotes();
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes() {
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
}
