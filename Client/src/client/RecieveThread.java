package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecieveThread extends Thread {

	private User user;

	public RecieveThread(User user) {
		this.user = user;
	}

	public void run() {
		BufferedReader in = null;

		try {
			in = new BufferedReader(new InputStreamReader(
					user.serverSocket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String text;
		while (true) {
			try {
				text = in.readLine();
//				if (text.equals("onlines:")){
//					user.getFrame().getListData().clear();
//					int onlines = Integer.parseInt(in.readLine());
//					for(int i = 0;i<onlines;i++){
//						user.getFrame().getListData().add(in.readLine());
//					}
//					user.getFrame().getContentPane().revalidate();
//					user.getFrame().getContentPane().repaint();
//				}
				//else{
					user.getFrame()
					.getTextPane()
					.setText(
							user.getFrame().getTextPane().getText()
									+ "Server said: " + text + "\n");
					String history;
					if ((history = user.getFrame().getTextPane().getText()).split("\n").length>=7){
						user.getFrame().getTextPane().setText("");
					}
				//}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
