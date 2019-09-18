package fallingApples;

import java.net.MalformedURLException;

import javafx.scene.layout.Pane;

public class VectorManzanas {
	private Manzana manzanas[];
	public VectorManzanas(int n) {
		
		int aumentoRetraso = 100;
		
		this.manzanas = new Manzana[n];
		for(int i=0; i<n; i++) {
			try {
				manzanas[i] = new Manzana();
				manzanas[i].setRetraso(aumentoRetraso);
				aumentoRetraso += 100;
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void addPane(Pane paneCancha) {
		for(int i=0; i<manzanas.length; i++) {
			paneCancha.getChildren().add(manzanas[i]);
		}
		
	}
	public void mover(double width, double height) {
	
		for(int i=0; i<manzanas.length; i++) {
			manzanas[i].mover(width, height);
		}
	}
	
	public double getY(int n) {
		return manzanas[n].getCenterY();
	}
	public double getX(int n) {
		return manzanas[n].getCenterX();
	}
	public double getRadius(int n) {
		return manzanas[n].getRadius();
	}
	
	public Manzana[] getManzanas() {
		return manzanas;
	}
}
