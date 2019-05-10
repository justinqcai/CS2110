/**
 * Justin Cai, jc5pz
 * Homework 5
 * Sources : Java documentation
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Collections;
import javax.swing.*;

public class PhotoViewer extends JFrame{
	private PhotographContainer imageAlbum;

	ImageIcon center_image;
	JPanel main, bar, ratings, top;
	JLabel mainImg;


	int intcurr = 0;
	Photograph curr;
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

	public static void main(String[] args) {
//		PhotoViewer myViewer = new PhotoViewer();
//		myViewer.setVisible(true);
		// relative path for Macs/Linux:

		String imageDirectory = "images/";
		Photograph p1 = new Photograph(imageDirectory + "img1.jpg", "ALBERT", "2013-03-23", 5);
		Photograph p2 = new Photograph(imageDirectory + "img2.jpg", "BERT", "2018-02-14", 2);
		Photograph p3 = new Photograph(imageDirectory + "img3.jpg", "CERT", "2015-08-03", 3);
		Photograph p4 = new Photograph(imageDirectory + "img4.jpg", "DERT", "2017-09-10", 4);
		Photograph p5 = new Photograph(imageDirectory + "img5.jpg", "ERT", "2011-02-02", 1);
		PhotographContainer pc = new PhotoLibrary("Library", 1);
		pc.addPhoto(p1);
		pc.addPhoto(p2);
		pc.addPhoto(p3);
		pc.addPhoto(p4);
		pc.addPhoto(p5);
		
		PhotoViewer myViewer = new PhotoViewer(pc);
		javax.swing.SwingUtilities.invokeLater(() -> myViewer.init() );
		
	}

	/**
	 * Constructor for PhotoViewer that takes the PhotographContainer as a parameter and checks to make sure it contains 5 photos
	 * @param pc The PhotographContainer that becomes imageAlbum if it contains the right amount of photos
	 */
	public PhotoViewer(PhotographContainer pc) {
		if(pc.getPhotos().size() != 5) {
			System.out.println("PhotoLibrary must contain 5 photos.");
			System.exit(0);
		}
		this.imageAlbum = pc;
		
		this.setVisible(true);
		//    	Collections.sort(myViewer.imageAlbum.getPhotos());

		
		//init();
	}

	/**
	 * Creates the JFrame and draws it
	 */
	private void init() {
		Collections.sort(this.imageAlbum.getPhotos());

		// Creates the top bar (panel with listeners)
		top = new JPanel();
		top.setLayout(new FlowLayout());

		JButton previous = new JButton("Previous");
		previous.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				prevImg();
			}
		});
		JButton next = new JButton("Next");
		next.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				nextImg();
			}
		});
		JButton date = new JButton("Sort By Date");
		date.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Collections.sort(imageAlbum.getPhotos());
				draw();
			}
		});
		JButton rating = new JButton("Sort By Rating");
		rating.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Collections.sort(imageAlbum.getPhotos(), new CompareByRating());
				draw();
			}
		});
		JButton caption = new JButton("Sort By Caption");
		caption.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Collections.sort(imageAlbum.getPhotos(), new CompareByCaption());
				draw();

			}
		});
		JButton exit = new JButton("Exit");
		exit.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(1);
			}
		});
		top.add(exit);
		top.add(previous);
		top.add(next);
		top.add(date);
		top.add(rating);
		top.add(caption);
		// Creates main image and side bar panels
		
		setBounds(0,0, screen.width, screen.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		bar = new JPanel();
		main = new JPanel();
		mainImg = new JLabel();
		setMainImg();
		main.add(mainImg);
		curr = this.imageAlbum.getPhotos().get(intcurr);
		bar.setLayout(new BoxLayout(bar, BoxLayout.Y_AXIS));
		bar.setAutoscrolls(true);
		
		// Creates the rating bar panel
		ratings = new JPanel();
		
		drawRatings();
		draw();
		getContentPane().add(main, BorderLayout.EAST);
		getContentPane().add(bar, BorderLayout.WEST);
		getContentPane().add(top, BorderLayout.NORTH);
		getContentPane().add(ratings, BorderLayout.SOUTH);
	}

	/**
	 * Creates the rating JRadioButtons
	 */
	public void drawRatings() {
		ratings.removeAll();
		// Instantiates the rating buttons
		JLabel ratingLabel = new JLabel("Rating:");
		ratings.add(ratingLabel);
		JRadioButton button1 = new JRadioButton("1");
		JRadioButton button2 = new JRadioButton("2");
		JRadioButton button3 = new JRadioButton("3");
		JRadioButton button4 = new JRadioButton("4");
		JRadioButton button5 = new JRadioButton("5");

		// Makes action listeners so the rating buttons change the ratings
		button1.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				curr.setRating(1);
				draw();
			}
		});
		button2.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				curr.setRating(2);
				draw();
			}
		});
		button3.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				curr.setRating(3);
				draw();
			}
		});
		button4.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				curr.setRating(4);
				draw();
			}
		});
		button5.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				curr.setRating(5);
				draw();
			}
		});
		//Makes sure the appropriate rating button is selected for the main image when rendered
		int curr_rating = curr.getRating();
		if(curr_rating == 1) button1.setSelected(true);
		else if(curr_rating == 2) button2.setSelected(true);
		else if(curr_rating == 3) button3.setSelected(true);
		else if(curr_rating == 4) button4.setSelected(true);
		else if(curr_rating == 5) button5.setSelected(true);
		ratings.setLayout(new GridLayout(1, 5));
		ratings.add(button1);
		ratings.add(button2);
		ratings.add(button3);
		ratings.add(button4);
		ratings.add(button5);
		revalidate();
		repaint();
	}
	/**
	 * Creates the side bar and renders the JFrame again
	 */
	public void draw() {
		intcurr = imageAlbum.photos.indexOf(curr);
		bar.removeAll();
		for(Photograph p: imageAlbum.photos) {
			int x = imageAlbum.photos.indexOf(p);
			ImageIcon img = new ImageIcon(new ImageIcon(p.getFilename()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
			JLabel pl = new JLabel(img);
			pl.setText("Caption: "+p.getCaption()+"\n Date: "+p.getDateTaken()+"\n Rating: "+p.getRating());
			pl.setSize(screen.height/5,screen.width/2);
			pl.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					intcurr = x;
					curr = imageAlbum.getPhotos().get(intcurr);
					setMainImg();
					drawRatings();
				}
			});
			bar.add(pl);
			revalidate();
			repaint();
		}
	}
	/**
	 * Changes the selected main image to the next image on the side bar
	 */
	public void nextImg() {
		if(intcurr == 4) intcurr = 0;
		else intcurr++;
		curr = this.imageAlbum.getPhotos().get(intcurr);
		setMainImg();
		drawRatings();
	}
	/**
	 * Changes the selected main image to the previous image on the side bar
	 */
	public void prevImg() {
		if(intcurr == 0) intcurr = 4;
		else intcurr--;
		curr = this.imageAlbum.getPhotos().get(intcurr);
		setMainImg();
		drawRatings();
	}
	/**
	 * Sets the main image
	 */
	public void setMainImg() {
		mainImg.setIcon(new ImageIcon(new ImageIcon(this.imageAlbum.getPhotos().get(intcurr).getFilename()).getImage().getScaledInstance(screen.height, screen.width/2, Image.SCALE_DEFAULT)));
	}
}
