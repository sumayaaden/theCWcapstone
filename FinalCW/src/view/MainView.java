package view;

import controller.ControllerMainView;
import model.VideoModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class MainView extends JFrame {
	private JPanel contentPane;
	private ArrayList<JLabel>videos = new ArrayList<JLabel>();
	private ControllerMainView mainController;
	
	/* MainView where we see our preview of our Netflix account */
	public MainView(ControllerMainView c) {
		setMainController(c);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,550,900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0,0,0));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/*JLabel set with image logo.png from specified path*/
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("assets/img/vistaprincipal/cw-logo.png"));// pathway for vista folder
		lblNewLabel.setBounds(250,11,131,88);
		contentPane.add(lblNewLabel);
// dark mode icon
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("assets/img/vistaprincipal/dark.png"));
		lblNewLabel_4.setBounds(430,11,150,88);
		contentPane.add(lblNewLabel_4);

//		/background pic
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("assets/img/vistaprincipal/riverdales.png"));
		lblNewLabel_3.setBounds(35,90,500,300);
		contentPane.add(lblNewLabel_3);

		
		
		/*JLabel set with "Trending Now" text to represent the category*/
		JLabel lblNewLabel_5 = new JLabel("TRENDING NOW");
		lblNewLabel_5.setFont(new Font("Gibson", Font.PLAIN,17 ));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(30,365,268,50);
		contentPane.add(lblNewLabel_5);
		
		/*JLabel set with "CW Seed Series" text to represent the category*/
		JLabel lblNewLabel_5_1 = new JLabel("CW SEED SERIES");
		lblNewLabel_5_1.setFont(new Font("Gibson", Font.PLAIN, 17));
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setBounds(30, 580, 268, 42);
		contentPane.add(lblNewLabel_5_1);
		
//		/*JLabel set with "Series" text to represent the category*/
//		JLabel lblNewLabel_5_2 = new JLabel("LATEST EPISODES");
//		lblNewLabel_5_2.setFont(new Font("Gibson", Font.PLAIN, 17));
//		lblNewLabel_5_2.setForeground(Color.WHITE);
//		lblNewLabel_5_2.setBounds(30,610,268,42);
//		contentPane.add(lblNewLabel_5_2);

		/*JLabel set with "Sign in" text*/
		JLabel lblNewLabel_1 = new JLabel("Shows");
		lblNewLabel_1.setFont(new Font("Gibson", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(67,138,137));
		lblNewLabel_1.setBounds(160, 830,71,25);
		contentPane.add(lblNewLabel_1);

		/*JLabel set with "Series" text*/
		JLabel lblNewLabel_2 = new JLabel("Continue");
		lblNewLabel_2.setFont(new Font("Gibson", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(67,138,137));
		lblNewLabel_2.setBounds(227,830,80,25);
		contentPane.add(lblNewLabel_2);

		/*JLabel set with "Search" text to represent the category*/
		JLabel lblNewLabel_2_1 = new JLabel("Search");
		lblNewLabel_2_1.setFont(new Font("Gibson", Font.PLAIN, 15));
		lblNewLabel_2_1.setForeground( new Color(67,138,137));
		lblNewLabel_2_1.setBounds(320,830,71,25);
		contentPane.add(lblNewLabel_2_1);

		/*JLabel set with "Most Recent" text*/
		JLabel lblNewLabel_2_2 = new JLabel("Settings");
		lblNewLabel_2_2.setFont(new Font("Gibson", Font.PLAIN, 15));
		lblNewLabel_2_2.setForeground( new Color(67,138,137));
		lblNewLabel_2_2.setBounds(392,830,108,20);
		contentPane.add(lblNewLabel_2_2);

//		/*JLabel set with "My List" text*/
//		JLabel lblNewLabel_2_3 = new JLabel("My List");
//		lblNewLabel_2_3.setFont(new Font("SansSerif", Font.PLAIN, 17));
//		lblNewLabel_2_3.setForeground(Color.WHITE);
//		lblNewLabel_2_3.setBounds(458,50,71,25);
//		contentPane.add(lblNewLabel_2_3);
		
		updateVideos();
		
	}
	
	private void updateVideos() {
		ArrayList<VideoModel> videos = (ArrayList<VideoModel>) getMainController().getModel().getAll();
		Integer xTrendingNow = 30;
		Integer xCWSeedSeries = 30;
		Integer xLastestEpisodes = 30;
		
		// for loop to generate each Label at its
		// specific bounds and width depending on the case
		for(VideoModel video: videos) {
			JLabel lbl = new JLabel("");
			//update videos images because we added a new entry
			lbl.setIcon(new ImageIcon(video.getImage()));
			
			switch(video.getCategory()) {
			case "TRENDING NOW":
				lbl.setBounds(xTrendingNow,370,200,250);
				xTrendingNow = xTrendingNow+130;
				break;
			case "CW SEED SERIES":
				lbl.setBounds(xCWSeedSeries,580,200,250);
				xCWSeedSeries = xCWSeedSeries+130;
				break;
//			case "LATEST EPISODES":
//				lbl.setBounds(xLastestEpisodes,660,282,353);
//				xLastestEpisodes = xLastestEpisodes+345;
//				break;
			}
			contentPane.add(lbl);
		}
		
	}
	
	
/*GETTERS AND SETTERS*/
	public ControllerMainView getMainController() {
		return mainController;
	}

	public void setMainController(ControllerMainView mainController) {
		this.mainController = mainController;
	}

	public ArrayList<JLabel> getVideos() {
		return videos;
	}

	public void setVideos(ArrayList<JLabel> videos) {
		this.videos = videos;
	}
	/*GETTERS AND SETTERS*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
