package fallingApples;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Personaje extends Rectangle{
	
	private double x;
	private double y;
	private int puntaje;
	private String nombre;

	
	public Personaje (double x, double y)
	{
		this.puntaje=0;
		this.setWidth(80);
		this.setHeight(40);
		this.setX(x);
		this.setY(y);
		this.setStroke(Color.BLACK);
		this.setFill(Color.LAWNGREEN);
		
	}


	public void sumarPuntaje() {
		puntaje++;
	}


	public int getPuntaje() {
		return puntaje;
	}
	
	public void verificarChoqueManzana(VectorManzanas manzanas, Pane paneCancha, Label labelPuntaje) {
		
		
		for(int i=0; i<manzanas.getManzanas().length; i++) {
			
			double yManzana = manzanas.getManzanas()[i].getCenterY()+manzanas.getManzanas()[i].getRadius();
			double xManzana = manzanas.getManzanas()[i].getCenterX();
			
			double a = this.getX();
			double b = a + this.getWidth();
			
			if(yManzana>=paneCancha.getHeight()-this.getHeight()) {
				if(xManzana>=a && xManzana <= b) {
					manzanas.getManzanas()[i].getCenterX();
					this.sumarPuntaje();
					paneCancha.getChildren().remove(manzanas.getManzanas()[i]);
				}
			}
		}
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}