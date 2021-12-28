package view;



import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import view.panels.SandwichOverviewPane;

public class AdminMainPane extends BorderPane {
	public AdminMainPane(){
	    TabPane tabPane = new TabPane();
        SandwichOverviewPane sandwichOverviewPane = new SandwichOverviewPane();
        Tab broodjesTab = new Tab("Broodjes/Beleg",sandwichOverviewPane);
        Tab instellingTab = new Tab("Instellingen"); // nog , zetten en dan een klasse maken voor nieuwe pane
        Tab statistiekTab = new Tab("Statistieken"); // nog , zetten en dan een klasse maken voor nieuwe pane
        tabPane.getTabs().add(broodjesTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}
}
