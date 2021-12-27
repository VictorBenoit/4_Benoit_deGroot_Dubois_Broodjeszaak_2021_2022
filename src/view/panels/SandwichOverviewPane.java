//Brinio 2-12: de pane voor het overview van alle broodjes en beleggen die beschikbaar zijn

package view.panels;
import domain.model.Beleg;
import domain.model.Broodje;
import domain.Broodjeszaak;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;


public class SandwichOverviewPane extends GridPane {
	private Broodjeszaak broodjeszaak;
	private TableView<Broodje> table1;
	private TableView<Beleg> table2;
	private ObservableList<Broodje> broodjes;
	private ObservableList<Beleg> beleggen;


	public SandwichOverviewPane(Broodjeszaak broodjeszaak) {
		this.broodjeszaak = broodjeszaak;
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		//Brinio 2-12: tabel opgesteld voor de broodjes en de gegevens die in de arraylist broodjes zijn toegevoegd bij de klasse "Broodjeszaak" ingevuld in de tabel, grotendeels overgenomen van het voorbeeld Tableview_JavaFX_Movies

		Label label1 = new Label("Broodjes");
		table1 = new TableView<Broodje>();
		refresh1();
		TableColumn<Broodje, String> colName1 = new TableColumn<Broodje, String>("Naam broodje:");
		colName1.setMinWidth(150);
		colName1.setCellValueFactory(new PropertyValueFactory<Broodje, String>("name"));
		TableColumn<Broodje, Double> colPrice1 = new TableColumn<Broodje, Double>("Prijs:");
		colPrice1.setMinWidth(100);
		colPrice1.setCellValueFactory(new PropertyValueFactory<Broodje, Double>("price"));
		TableColumn<Broodje, Integer> colAmount1 = new TableColumn<Broodje, Integer>("Hoeveelheid in stock:");
		colAmount1.setMinWidth(200);
		colAmount1.setCellValueFactory(new PropertyValueFactory<Broodje, Integer>("amount"));
		TableColumn<Broodje, Integer> colSales1 = new TableColumn<Broodje, Integer>("Verkoopcijfer:");
		colSales1.setMinWidth(150);
		colSales1.setCellValueFactory(new PropertyValueFactory<Broodje, Integer>("sales"));
		table1.getColumns().addAll(colName1, colPrice1, colAmount1, colSales1);

		//Brinio 2-12: tabel opgesteld voor beleggen, hetzelfde eig als bij broodjes

		Label label2 = new Label("Beleggen");
		table2 = new TableView<Beleg>();
		refresh2();
		TableColumn<Beleg, String> colName2 = new TableColumn<Beleg, String>("Naam beleg:");
		colName2.setMinWidth(150);
		colName2.setCellValueFactory(new PropertyValueFactory<Beleg, String>("name"));
		TableColumn<Beleg, Double> colPrice2 = new TableColumn<Beleg, Double>("Prijs:");
		colPrice2.setMinWidth(100);
		colPrice2.setCellValueFactory(new PropertyValueFactory<Beleg, Double>("price"));
		TableColumn<Beleg, Integer> colAmount2 = new TableColumn<Beleg, Integer>("Hoeveelheid in stock:");
		colAmount2.setMinWidth(200);
		colAmount2.setCellValueFactory(new PropertyValueFactory<Beleg, Integer>("amount"));
		TableColumn<Beleg, Integer> colSales = new TableColumn<Beleg, Integer>("Verkoopcijfer:");
		colSales.setMinWidth(150);
		colSales.setCellValueFactory(new PropertyValueFactory<Beleg, Integer>("sales"));
		table2.getColumns().addAll(colName2, colPrice2, colAmount2, colSales);

		//Brinio 2-12: hier wordt alles aan de tabel toegevoegd met nummers van een grid

		this.add(label1, 0, 0);
		this.add(table1, 0, 1);
		this.add(label2, 0, 2);
		this.add(table2, 0, 3);

	}

	//Brinio 2-12: refresh codes om de Arraylisten in te vullen in de tabellen

	public void refresh1() {
		broodjes = FXCollections.observableArrayList(broodjeszaak.getBroodjes());
		table1.setItems(broodjes);
		table1.refresh();
	}

	public void refresh2() {
		beleggen = FXCollections.observableArrayList(broodjeszaak.getBeleg());
		table2.setItems(beleggen);
		table2.refresh();
	}
}



