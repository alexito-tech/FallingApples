package fallingApples;

import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class FallingApplesController {
	@FXML
	private Pane paneCancha;
	private Personaje personaje;
	//private Gota gota;

	private FallingApplesAnimationTimer miTimer;

	private VectorManzanas manzanas;
	@FXML
	private Label labelPuntaje;
	@FXML
	private Label textoResultado;
	
	public FallingApplesController(){
		
	}
	@FXML
	public void initialize() {
		Rectangle clip = new Rectangle(0, 0, 0, 0);
		clip.widthProperty().bind(paneCancha.widthProperty());
		clip.heightProperty().bind(paneCancha.heightProperty());
		paneCancha.setClip(clip);
		
		this.manzanas = new VectorManzanas(25);
		this.personaje = new Personaje(103, 325);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("INTRODUZCA SU NOMBRE: ");
		personaje.setNombre(sc.nextLine());
		
		paneCancha.getChildren().add(personaje);
		manzanas.addPane(paneCancha);
		
		miTimer = new FallingApplesAnimationTimer(paneCancha, manzanas, personaje, labelPuntaje, textoResultado);
		miTimer.start();
	}
	
	public void keyMoveHnd(KeyEvent ke)
	{
		double x = personaje.getX();
		switch(ke.getCode())
		{
		case LEFT:
		case KP_LEFT:
		case J:
			x-=15;
			break;
		case RIGHT:
		case KP_RIGHT:
		case L:
			x+=15;
			break;
		default:
			System.out.println("KeyMoveHnd:" + ke.getCode() );
			break;
		}
		
		ke.consume();
		
		personaje.setX(x);
		
	}
	
	public void verificarChoqueManzana(VectorManzanas manzanas, int i, Pane paneCancha) {
		double yManzana = manzanas.getManzanas()[i].getCenterY()+manzanas.getManzanas()[i].getRadius();
		if(yManzana>=paneCancha.getHeight()-personaje.getHeight()) {
			personaje.sumarPuntaje();
		}
	}
	
}
