package fallingApples;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Manzana extends Circle{
	private Random r;
	private double radio;
	private double x;
	private double y;
	private boolean completo;
	private int retraso;
	private boolean esVisible;
	
	public Manzana() throws MalformedURLException {
		r = new Random();
		this.completo = false;
		this.retraso = 0;
		File file = new File("img/manzana-roja-7415.jpg");
		String localUrl = file.toURI().toURL().toString();
		Image img = new Image(localUrl);
		this.setFill(new ImagePattern(img));
		esVisible = true;
	}
	
	public void mover(double ancho, double alto) {
		if(!completo) {
			this.init(ancho);
			completo = true;
		}
		else if(retraso>0) {
			retraso--;
		}
		else {
			double x = this.getCenterX();
			double y = this.getCenterY();
			y++;
				this.setCenterY(y);
				this.setCenterX(x);
		}

	}
	
	private void init(double ancho) {
	
		this.radio = 10;
		this.y = -radio;
		this.x = r.nextInt((int) (ancho-2*radio))+radio;
		
		this.setRadius(radio);
		this.setCenterX(x);
		this.setCenterY(y);
		
		
	}
	
	public boolean esVisible() {
		return esVisible;
	}
	public void setEsVisible(boolean t) {
		this.esVisible = t;
	}
	public void setRetraso(int retraso) {
		this.retraso = retraso;
	}
}