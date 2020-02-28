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
import project1.generator.DataGenerator;
import project1.sorts.*;
import project1.sorts.heap.HeapSort;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public abstract class GUIController<E extends Comparable<E>> implements Initializable {
    @FXML
    public VBox sortButtonsVBox;
    @FXML
    protected RadioButton inOrderButton;
    @FXML
    protected RadioButton reverseOrderButton;
    @FXML
    protected RadioButton almostOrderButton;
    @FXML
    protected RadioButton randomButton;

    @FXML
    private TextField nTextField;
    @FXML
    private TextField dataTypeTextField;
    @FXML
    private TextField lastSortTextField;
    @FXML
    private TextField comparisonsTextField;
    @FXML
    private TextField movementTextField;
    @FXML
    private TextField totalTimeTextField;

    @FXML
    private TextField countTextField;
    @FXML
    private Slider countSlider;

    @FXML
    private TextField winningAlgorithmTextField;

    @FXML
    private Button insertionSortButton;
    @FXML
    private Button selectionSortButton;
    @FXML
    private Button quickSortButton;
    @FXML
    private Button mergeSortButton;
    @FXML
    private Button heapSortButton;
    @FXML
    private Button radixSortButton;
    @FXML
    private Button bucketSortButton;

    protected DataGenerator<E> dataGenerator;
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

    protected abstract void initializeListProperties();

    abstract GUIType getGUIType();

    private void setSortButtonsHeights() {
        final List<Button> universalSortButtons = List.of(insertionSortButton, selectionSortButton, quickSortButton, mergeSortButton, heapSortButton);
        final List<Button> integerSortButtons = List.of(radixSortButton, bucketSortButton);
        final List<Button> sortButtons = new ArrayList<>(universalSortButtons);

        sortButtonsVBox.setPrefHeight(GUIConstants.SORT_BUTTONS_VBOX_HEIGHT);
        if (getGUIType() == GUIType.UNIVERSAL_AND_INTEGER_SORTS) {
            sortButtons.addAll(integerSortButtons);
        }
        for (Button sortButton : sortButtons) {
            sortButton.setPrefHeight(GUIConstants.SORT_BUTTONS_VBOX_HEIGHT / sortButtons.size());
        }
        if (getGUIType() == GUIType.UNIVERSAL_SORTS) {
            integerSortButtons.forEach((button) -> button.setVisible(false));
        }
    }

    private void setSortButtonsData() {
        insertionSortButton.setUserData(new InsertionSort<E>());
        selectionSortButton.setUserData(new SelectionSort<E>());
        quickSortButton.setUserData(new QuickSort<E>());
        mergeSortButton.setUserData(new MergeSort<E>());
        heapSortButton.setUserData(new HeapSort<E>());
        radixSortButton.setUserData(new RadixSort());
        bucketSortButton.setUserData(new BucketSort());
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
        Sort<E> sort = (Sort<E>) button.getUserData();
        experimentalResultsData.resetData();
        try {
            E[] data = dataGenerator.getGeneratedDataCopy();
            System.out.println(button.getText() + " data before = " + Arrays.toString(data));
            long startTime = System.currentTimeMillis();
            experimentalResultsData.setLastSort(sort.sort(experimentalResultsData, data));
            int endTime = (int) (System.currentTimeMillis() - startTime);
            experimentalResultsData.setTotalTime(endTime);
            updateExperimentalResultsGUI();
            System.out.println(button.getText() + " data after = " + Arrays.toString(data));
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
        this.dataGenerator = (DataGenerator<E>) radioButton.getUserData();

        createList(null);
        winningAlgorithmData = new ExperimentalResultsData();
        updateWinningAlgorithmGUI();
    }
}
