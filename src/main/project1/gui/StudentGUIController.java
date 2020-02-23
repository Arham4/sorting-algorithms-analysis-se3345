package project1.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import project1.ExperimentalResultsData;
import project1.data.Student;
import project1.generator.DataGenerator;
import project1.generator.student.StudentAlmostOrderDataGenerator;
import project1.generator.student.StudentInOrderDataGenerator;
import project1.generator.student.StudentRandomOrderDataGenerator;
import project1.generator.student.StudentReverseOrderDataGenerator;
import project1.sorts.*;
import project1.sorts.heap.HeapSort;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public final class StudentGUIController implements Initializable {
    @FXML public VBox sortButtonsVBox;
    @FXML private RadioButton inOrderButton;
    @FXML private RadioButton reverseOrderButton;
    @FXML private RadioButton almostOrderButton;
    @FXML private RadioButton randomButton;

    @FXML private TextField nTextField;
    @FXML private TextField dataTypeTextField;
    @FXML private TextField lastSortTextField;
    @FXML private TextField comparisonsTextField;
    @FXML private TextField movementTextField;
    @FXML private TextField totalTimeTextField;

    @FXML private TextField countTextField;
    @FXML private Slider countSlider;

    @FXML private TextField winningAlgorithmTextField;

    @FXML private Button insertionSortButton;
    @FXML private Button selectionSortButton;
    @FXML private Button quickSortButton;
    @FXML private Button mergeSortButton;
    @FXML private Button heapSortButton;

    private DataGenerator<Student> dataGenerator;
    private final ExperimentalResultsData experimentalResultsData = new ExperimentalResultsData();
    private ExperimentalResultsData winningAlgorithmData = new ExperimentalResultsData();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeListProperties();
        createInitialList();
        initializeSortButtons();
    }

    private void initializeSortButtons() {
        setSortButtonsHeights();
        setSortButtonsData();
    }

    private void initializeListProperties() {
        final DataGenerator<Student> initialDataGenerator = new StudentInOrderDataGenerator();

        dataGenerator = initialDataGenerator;
        inOrderButton.setUserData(initialDataGenerator);
        reverseOrderButton.setUserData(new StudentReverseOrderDataGenerator());
        almostOrderButton.setUserData(new StudentAlmostOrderDataGenerator());
        randomButton.setUserData(new StudentRandomOrderDataGenerator());
    }

    private void setSortButtonsHeights() {
        sortButtonsVBox.setPrefHeight(GUIConstants.SORT_BUTTONS_VBOX_HEIGHT);
        final Button[] sortButtons = {insertionSortButton, selectionSortButton, quickSortButton, mergeSortButton, heapSortButton};
        for (Button sortButton : sortButtons) {
            sortButton.setPrefHeight(GUIConstants.SORT_BUTTONS_VBOX_HEIGHT / sortButtons.length);
        }
    }

    private void setSortButtonsData() {
        insertionSortButton.setUserData(new InsertionSort<Student>());
        selectionSortButton.setUserData(new SelectionSort<Student>());
        quickSortButton.setUserData(new QuickSort<Student>());
        mergeSortButton.setUserData(new MergeSort<Student>());
        heapSortButton.setUserData(new HeapSort<Student>());
    }

    private void createInitialList() {
        countTextField.setText(((int) (countSlider.getValue()) + ""));
        countSlider.valueProperty().addListener((observableValue, number, t1) -> {
            countTextField.setText(number.intValue() + "");
        });
        createList(null);
    }

    private void updateExperimentalResultsGUI() {
        nTextField.setText(dataGenerator.getCurrentDataSize() + "");
        dataTypeTextField.setText(dataGenerator.getDataType().toString());
        lastSortTextField.setText(experimentalResultsData.getLastSort().toString());
        comparisonsTextField.setText(experimentalResultsData.getComparisons() + "");
        movementTextField.setText(experimentalResultsData.getMovements() + "");
        totalTimeTextField.setText(experimentalResultsData.getTotalTime() + "");
    }

    @FXML
    public void onSetManualArrayCount(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            int count = 0;
            if (countTextField.getText() != null) {
                try {
                    count = Integer.parseInt(countTextField.getText());
                } catch (NumberFormatException e) {
                    count = 0;
                }
            }
            countSlider.setValue(count);
            countTextField.setText(count + "");
        }
    }

    @FXML
    public void createList(ActionEvent actionEvent) {
        int n = Integer.parseInt(countTextField.getText());
        dataGenerator.makeData(n);

        winningAlgorithmData = new ExperimentalResultsData();
        updateWinningAlgorithmGUI();
    }

    @FXML
    public void selectSort(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        Sort<Student> sort = (Sort<Student>) button.getUserData();
        experimentalResultsData.resetData();
        try {
            Student[] data = dataGenerator.getGeneratedDataCopy();
            System.out.println(button.getText() + " data before = " + Arrays.deepToString(data));
            long startTime = System.currentTimeMillis();
            experimentalResultsData.setLastSort(sort.sort(experimentalResultsData, data));
            int endTime = (int) (System.currentTimeMillis() - startTime);
            experimentalResultsData.setTotalTime(endTime);
            updateExperimentalResultsGUI();
            System.out.println(button.getText() + " data after = " + Arrays.deepToString(data));
        } catch (StackOverflowError e) {
            experimentalResultsData.setLastSort(SortType.valueOf(button.getText().toUpperCase().replaceAll(" ", "_")));
            updateExperimentalResultsGUI();
            comparisonsTextField.setText("ERROR");
            movementTextField.setText("ERROR");
            totalTimeTextField.setText("ERROR");
            e.printStackTrace();
            return;
        }
        updateWinningAlgorithm();
    }

    private void updateWinningAlgorithm() {
        if (experimentalResultsData.compareTo(winningAlgorithmData) < 0) {
            winningAlgorithmData = experimentalResultsData.clone();
        }
        updateWinningAlgorithmGUI();
    }

    private void updateWinningAlgorithmGUI() {
        SortType winningAlgorithm = winningAlgorithmData.getLastSort();
        if (winningAlgorithm == null) {
            winningAlgorithmTextField.setText("");
        } else {
            winningAlgorithmTextField.setText(winningAlgorithm.toString());
        }
    }

    @FXML
    public void selectDataType(ActionEvent actionEvent) {
        RadioButton radioButton = (RadioButton) actionEvent.getSource();
        this.dataGenerator = (DataGenerator<Student>) radioButton.getUserData();

        createList(null);
        winningAlgorithmData = new ExperimentalResultsData();
        updateWinningAlgorithmGUI();
    }
}
