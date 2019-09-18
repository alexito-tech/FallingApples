package fallingApples;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class FallingApplesAnimationTimer extends AnimationTimer{
	
	private Pane paneCancha;
	
	private VectorManzanas manzanas;
	Personaje personaje;
	FallingApplesController controller;
	@FXML
	Label labelPuntaje;
	@FXML
	Label textoResultado;

	
	public FallingApplesAnimationTimer(Pane paneCancha, VectorManzanas lluvia, Personaje personaje, Label labelPuntaje, Label textoResultado) {
		
		this.paneCancha = paneCancha;
		this.manzanas = lluvia;
		this.personaje = personaje;
		this.labelPuntaje = labelPuntaje;
		this.textoResultado = textoResultado;
	}
	@Override
	public void handle(long arg0) {

		manzanas.mover(paneCancha.getWidth(), paneCancha.getHeight());
		
		for(int i=0; i<manzanas.getManzanas().length; i++) {
			if(manzanas.getManzanas()[i].esVisible()) {
				
				if(manzanas.getManzanas()[i].intersects(personaje.getBoundsInLocal())) {
					paneCancha.getChildren().remove(manzanas.getManzanas()[i]);
					manzanas.getManzanas()[i].setEsVisible(false);
					personaje.sumarPuntaje();
					labelPuntaje.setText(""+personaje.getPuntaje());
					break;
				}	
				else if(manzanas.getManzanas()[i].getCenterY()+manzanas.getManzanas()[i].getRadius() == paneCancha.getHeight()){
					this.stop();
					textoResultado.setText("GAME OVER");
					System.out.println("Vuelvelo a intentar.");
					break;
				}
				else if(personaje.getPuntaje() == 20) {
					this.stop();
					textoResultado.setText("WINNER");
					System.out.println("Felicidades "+personaje.getNombre()+", Ganaste!");
					break;
				}
			}
		}
	}
}
