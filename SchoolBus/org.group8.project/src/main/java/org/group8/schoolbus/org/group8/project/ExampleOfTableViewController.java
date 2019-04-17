package org.group8.schoolbus.org.group8.project;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;


import org.json.JSONArray;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author
 */
public class ExampleOfTableViewController implements Initializable {
	
	// configure the table
	@FXML
	private TableView<Data> tableView;
	@FXML
	private TableColumn<Data, String> boroughColumn;
	@FXML
	private TableColumn<Data, String> typeOfDelayColumn;
	@FXML
	private TableColumn<Data, String> busCompanyColumn;
	@FXML
	private TableColumn<Data, String> busNumColumn;
	@FXML
	private TableColumn<Data, Integer> breakdownIDColumn;
	@FXML
	private TableColumn<Data, String> informedOnColumn;
	@FXML
	private TableColumn<Data, String> schoolNotifiedColumn;
	@FXML
	private TableColumn<Data, String> optNotifiedColumn;
	@FXML
	private TableColumn<Data, String> parentsNotifiedColumn;
	@FXML
	private TableColumn<Data, String> occurredOnColumn;
	@FXML
	private TableColumn<Data, String> createdOnColumn;
	@FXML
	private TableColumn<Data, Integer> numOfStudentsColumn;
	@FXML
	private TableColumn<Data, String> lastUpdatedColumn;
	@FXML
	private TableColumn<Data, String> reasonColumn;
	@FXML
	private TableColumn<Data, String> routeNumColumn;
	@FXML
	private TableColumn<Data, String> runTypeColumn;
	@FXML
	private TableColumn<Data, String> studentAgesColumn;
	@FXML
	private TableColumn<Data, String> schoolYearColumn;
	@FXML
	private TableColumn<Data, String> schoolsServicedColumn;
	
	// These instance variables are used to create new Data objects
	private TextField borough;
	@FXML
    private TextField typeOfDelay;
	@FXML
    private TextField busCompany;
	@FXML
    private TextField busNum;
	@FXML
    private TextField breakdownID;
	@FXML
    private TextField informedOn;
	@FXML
    private TextField schoolNotified;
	@FXML
    private TextField optNotified;
	@FXML
    private TextField parentsNotified;
	@FXML
    private TextField occurredOn;
	@FXML
    private TextField createdOn;
	@FXML
    private TextField numOfStudents;
	@FXML
    private TextField lastUpdated;
	@FXML
    private TextField reason;
	@FXML
    private TextField routeNum;
	@FXML
    private TextField runType;
	@FXML
    private TextField studentAges;
	@FXML
    private TextField schoolYear;
	@FXML
    private TextField schoolsServiced;
	
	
	@FXML
	private TextField filterField;

	@FXML
	private Button detailedDataViewButton;

	private ObservableList<Data> data = FXCollections.observableArrayList();
    private ObservableList<Data> filteredData = FXCollections.observableArrayList();
	
    /**
	 * This method will enable the detailed view button once a row in the table is
	 * selected
	 */
	public void userClickedOnTable() {
		this.detailedDataViewButton.setDisable(false);
	}

	/**
	 * When this method is called, it will change the Scene to a TableView example
	 */
	public void changeScreenButtonPushed(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/FXMLDocument.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}
	
	/**
	 * The constructor
	 */
	
	public void SchoolBusController() {
		
		//Add all data that needs to be filtered
		filteredData.addAll(data);
        
		//Listen for changes in data
		//When the data is changes, we must update the filter
        data.addListener(new ListChangeListener<Data>() {

			@Override
			public void onChanged(Change<? extends Data> c) {
				updateFilteredData();
			}
        });
		
	}

	
	@SuppressWarnings("unchecked")
	public void initialize(URL url, ResourceBundle rb) {
		
	    // set up the columns in the table
		boroughColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("borough"));
		typeOfDelayColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("typeOfDelay"));
		busCompanyColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("busCompany"));
		busNumColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("busNum"));
		breakdownIDColumn.setCellValueFactory(new PropertyValueFactory<Data, Integer>("breakdownID"));
		informedOnColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("informedOn"));
		schoolNotifiedColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("schoolNotified"));
		optNotifiedColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("optNotified"));
		parentsNotifiedColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("parentsNotified"));
		occurredOnColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("occurredOn"));
		occurredOnColumn.setSortType(SortType.DESCENDING);
		createdOnColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("createdOn"));
		numOfStudentsColumn.setCellValueFactory(new PropertyValueFactory<Data, Integer>("numOfStudents"));
		lastUpdatedColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("lastUpdated"));
		reasonColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("reason"));
		routeNumColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("routeNum"));
		runTypeColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("runType"));
		studentAgesColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("studentAges"));
		schoolYearColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("schoolYear"));
		schoolsServicedColumn.setCellValueFactory(new PropertyValueFactory<Data, String>("schoolsServiced"));

		
		// load  data
		try {
			tableView.setItems(getData1());
			tableView.getSortOrder().setAll(occurredOnColumn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// This will allow the table to select multiple rows at once
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	
		
		//Add filtered data to the table 
		tableView.setItems(filteredData);
	 	
		//Listen for text changes
	 	filterField.textProperty().addListener( new ChangeListener<String>(){
	 		
	 		@Override
	 		public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                
                updateFilteredData();
            }
	});
		
}


	

	/**
	 * This method will return an ObservableList of Data objects
	 * It gets each column in the Dataset and adds the values to the observable list
	 * @throws Exception 
	 */
	public ObservableList<Data> getData1() throws Exception {
		
    		String urlToRead = "https://data.cityofnewyork.us/resource/fbkk-fqs7.json";
    	
        JSONArray objArr = new JSONArray(busData.getHTML(urlToRead));

        for(int i = 0; i < objArr.length(); i++) {
        	String boro = "";
        	try {
        		boro = objArr.getJSONObject(i).getString("boro");
        	}
        	catch (Exception e){
        		boro = "No boro detected";
        	}
        	
        

        	data.add(new Data(
        			boro,
        			objArr.getJSONObject(i).getString("breakdown_or_running_late"),
        			objArr.getJSONObject(i).getString("bus_company_name"),
        			objArr.getJSONObject(i).getString("bus_no"),
        			objArr.getJSONObject(i).getInt("busbreakdown_id"),
        			objArr.getJSONObject(i).getString("informed_on"),
        			objArr.getJSONObject(i).getString("has_contractor_notified_schools"),
        			objArr.getJSONObject(i).getString("have_you_alerted_opt"),
        			objArr.getJSONObject(i).getString("has_contractor_notified_parents"),
        			objArr.getJSONObject(i).getString("occurred_on"),
        			objArr.getJSONObject(i).getString("created_on"),
        			objArr.getJSONObject(i).getInt("number_of_students_on_the_bus"),
        			objArr.getJSONObject(i).getString("last_updated_on"),
        			objArr.getJSONObject(i).getString("reason"),
        			objArr.getJSONObject(i).getString("route_number"),
        			objArr.getJSONObject(i).getString("run_type"),
        			objArr.getJSONObject(i).getString("school_age_or_prek"),
        			objArr.getJSONObject(i).getString("school_year"),
        			objArr.getJSONObject(i).getString("schools_serviced")
        		));
        }
        
        return data;
        
        
	}
	
	/*
	 * Updates the filteredData 
	 */
		private void updateFilteredData() {
				filteredData.clear();
				
				for (Data p: data) {
					if (matchesFilter(p)) {
						filteredData.add(p);
					}
				}
				
				reapplyTableSortOrder();
			}

		
		/*
		 * Returns true if the busData matches the filter
		 * Works for both Upper/Lower case
		 */
		private boolean matchesFilter(Data busData) {
					
			String filterString = filterField.getText();
			if(filterString == null || filterString.isEmpty()) {
				return true;
			}
			
			String lowerCaseFilterString = filterString.toLowerCase();
			
			if (busData.getBorough().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
				return true;
			}
			
			else if (busData.getTypeOfDelay().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
				return true;
			}
			
			return false;
		}  
				
		
		private void reapplyTableSortOrder() {			
				ArrayList<TableColumn<Data, ?>> sortOrder = new ArrayList<>(tableView.getSortOrder());
				tableView.getSortOrder().clear();
				tableView.getSortOrder().addAll(sortOrder);
			}
                  
	
	}


	