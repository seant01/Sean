import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Tooltip;
import java.util.ArrayList;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType; 
import java.io.FileNotFoundException;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollPane;  
/**
 * ChartWindow is used to start the program, create
 * the objects, and call the file.
 *
 * @author (seant01)
 * @version (12.4.20)
 */
public class ChartWindow extends Application
{
    private final static double RADIUS = 2000.0;
    private ArrayList<State> statelist = new ArrayList<State>();
    private DataReader obj = new DataReader();
    private int vertical = 10;
    private int horizontal = 10;
    private Group g;
    /**
     * @param primaryStage sets the JavaFX application.
     */
    public void start(Stage primaryStage) throws FileNotFoundException
    {
        String user = "COVIDdata.csv";
        obj.instantiate(user);
        statelist = obj.readData();
        FlowPane flowpane = new FlowPane(vertical, horizontal);
        for (State s : statelist)
        {
            drawState(s);
            flowpane.getChildren().add(g);
        }
        ScrollPane sp = new ScrollPane();
        sp.setContent(flowpane);
        sp.setFitToWidth(true);
        sp.setFitToHeight(true);
        Scene s = new Scene(sp, Color.WHITE);
        primaryStage.setScene(s);
        primaryStage.setTitle("COVID-19 In The United States");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
    /**
     * @param state allows methods from the 
     * State class to be called.
     * @return returns the group created for
     * each state.
     */
    public Group drawState(State state) throws FileNotFoundException
    {
        double infectionrate = 0;
        double deathrate = 0;
        double num = 0;
        g = new Group();
        num = 0.0;
        for (State t : statelist)
        {
            num += t.getInfections();
        }
        infectionrate = state.getInfections() / num;
        int death = state.getDeaths();
        deathrate = death;
        deathrate = deathrate / state.getInfections();
        Circle circle = new Circle(infectionrate * RADIUS);
        circle.setFill(Color.BLUE);
        circle.setStroke(Color.BLUE);
        String outputi = String.format("%.1f", infectionrate * 100);
        String outputd = String.format("%.1f", deathrate * 100);
        Tooltip tool = new Tooltip("Infection Rate: " + outputi + "%" +
            "\n" + "Death Rate: " + outputd + "%");
        Tooltip.install(circle, tool);
        g.getChildren().add(circle);
        Arc arc = new Arc(0.0, 0.0, infectionrate * RADIUS,
            infectionrate * RADIUS, deathrate * 360, deathrate * 360);
        arc.setFill(Color.RED);
        arc.setStroke(Color.RED);
        arc.setType(ArcType.ROUND);
        g.getChildren().add(arc);
        Text text = new Text();
        text.setText(state.getStateName());
        text.setY(infectionrate * RADIUS + 10);
        text.setX(text.getLayoutBounds().getWidth() / 2);
        g.getChildren().add(text);
        return g;
    }

}
