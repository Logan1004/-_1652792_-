package Adapter;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {
    String curMethod;
    int tempNumBestAdapter = 0;
    int tempNumFirstAdapter = 0;
    Label labelBestCommand = new Label("Best Adapter");
    Label labelFirstCommand = new Label("First Adapter");
    private static String helpMessage =
            "<html>" +
                    "<body>" +
                    "<h1>动态内存调度</h1>" +
                    "<h2>基本算法</h2>" +
                    "<h3>最先适配算法</h3>" +
                    "<ul> <li>从头开始找到最先满足要求的内存块</li> <li>释放内存时合并空白内存块</li> </ul>" +
                    "<h3>最佳适配算法</h3>" +
                    "<ul> <li>遍历所有可用内存块，找出满足要求的最小内存块</li> <li>释放内存时合并空白内存块</li> </ul>" +
                    "<h2>操作说明</h2>" +
                    "<ul> <li>两个不同按钮用来控制两个不同算法的演示</li> <li>文本框用于显示当前操作指令</li> " +
                    "<li>点击按钮可以逐步运行指令</li>" +
                    "<li>下方空白处将显示内存块当前状况 数字表示相应的起始地址及结束地址</li> </ul>" +
                    "<h2>点击ok 开始演示</h2>"+
                    "</body>" +
                    "</html>";


    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,
                helpMessage,
                "动态内存调度",
                JOptionPane.INFORMATION_MESSAGE);
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AdapterGUI.fxml"));
            Scene scene = new Scene(root, 700, 764);

            Image image = new Image(getClass().getResourceAsStream("BestAdapter.png"),79,35,false,false);
            Label labelBestAdapter = new Label();
            labelBestAdapter.setGraphic(new ImageView(image));
            labelBestAdapter.setText("BestAdapter");
            labelBestAdapter.setTextFill(Color.web("#0076a3"));
            labelBestAdapter.setFont(new Font("Arial", 15));
            labelBestAdapter.setLayoutX(50);
            labelBestAdapter.setLayoutY(100);
            root.getChildren().add(labelBestAdapter);

            labelBestCommand.setLayoutX(500);
            labelBestCommand.setLayoutY(108);
            labelBestCommand.setFont(new Font("Arial",15));
            root.getChildren().add(labelBestCommand);


            image = new Image(getClass().getResourceAsStream("FirstAdapter.png"),79,35,false,false);
            Label labelFirstAdapter = new Label();
            labelFirstAdapter.setGraphic(new ImageView(image));
            labelFirstAdapter.setText("FirstAdapter");
            labelFirstAdapter.setTextFill(Color.web("#0076a3"));
            labelFirstAdapter.setFont(new Font("Arial", 15));
            labelFirstAdapter.setLayoutX(50);
            labelFirstAdapter.setLayoutY(300);

            root.getChildren().add(labelFirstAdapter);

            labelFirstCommand.setLayoutX(500);
            labelFirstCommand.setLayoutY(308);
            labelFirstCommand.setFont(new Font("Arial",15));
            root.getChildren().add(labelFirstCommand);


            final Button strBestButton = new Button("开始模拟");
            strBestButton.setVisible(true);
            strBestButton.setLayoutX(320.0);
            strBestButton.setLayoutY(105.0);

            final Button strFirstButton = new Button("开始模拟");
            strFirstButton.setVisible(true);
            strFirstButton.setLayoutX(320.0);
            strFirstButton.setLayoutY(305.0);


            BestAdapterModel bestAdapterModeler = new BestAdapterModel();
            ArrayList<ArrayList<MemoryBlock>> bestAdapter = bestAdapterModeler.bestAdapterModel();

            FirstAdapterModel firstAdapterModeler = new FirstAdapterModel();
            ArrayList<ArrayList<MemoryBlock>> firstAdapter = firstAdapterModeler.firstAdapterModel();


            tempNumBestAdapter=0;

            strBestButton.setOnAction(oa -> {
                double xPosition = 20.0;
                double yPosition = 170.0;
                labelBestCommand.setText(Constants.command.get(tempNumBestAdapter).toString());
                if (tempNumBestAdapter < 11) {
                    ArrayList<MemoryBlock> bestAdapterModel = bestAdapter.get(tempNumBestAdapter);
                    tempNumBestAdapter++;
                    ArrayList<javafx.scene.control.Label> labelArrayList = new ArrayList<javafx.scene.control.Label>(50);
                    for (int i = 0; i < bestAdapterModel.size(); i++) {
                        javafx.scene.control.Label label = new Label();

                        switch (bestAdapterModel.get(i).getCurTag()) {
                            case 0:
                                label.setText("Blank Space\n   ");
                                label.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                                break;
                            case 1:
                                label.setText("Homework 1\n" + bestAdapterModel.get(i).getStartPosition() + " " + bestAdapterModel.get(i).getEndPosition());
                                label.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
                                break;
                            case 2:
                                label.setText("Homework 2\n" + bestAdapterModel.get(i).getStartPosition() + " " + bestAdapterModel.get(i).getEndPosition());
                                label.setBackground(new Background(new BackgroundFill(Color.PALEGREEN, null, null)));
                                break;
                            case 3:
                                label.setText("Homework 3\n" + bestAdapterModel.get(i).getStartPosition() + " " + bestAdapterModel.get(i).getEndPosition());
                                label.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD, null, null)));
                                break;
                            case 4:
                                label.setText("Homework 4\n" + bestAdapterModel.get(i).getStartPosition() + " " + bestAdapterModel.get(i).getEndPosition());
                                label.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, null, null)));
                                break;
                            case 5:
                                label.setText("Homework 5\n" + bestAdapterModel.get(i).getStartPosition() + " " + bestAdapterModel.get(i).getEndPosition());
                                label.setBackground(new Background(new BackgroundFill(Color.GOLD, null, null)));
                                break;
                            case 6:
                                label.setText("Homework 6\n" + bestAdapterModel.get(i).getStartPosition() + " " + bestAdapterModel.get(i).getEndPosition());
                                label.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
                                break;
                            case 7:
                                label.setText("Homework 7\n" + bestAdapterModel.get(i).getStartPosition() + " " + bestAdapterModel.get(i).getEndPosition());
                                label.setBackground(new Background(new BackgroundFill(Color.PALEGREEN, null, null)));
                                break;
                        }
                        System.out.println(bestAdapterModel.get(i).getCurTag());

                        label.setPrefWidth(bestAdapterModel.get(i).getCurLength()+10);
                        label.setPrefHeight(80);
                        label.setLayoutX(xPosition);
                        label.setLayoutY(yPosition);
                        xPosition += bestAdapterModel.get(i).getCurLength();
                        root.getChildren().add(label);
                    }
                }
                else tempNumBestAdapter=0;
            });

            tempNumFirstAdapter=0;
            strFirstButton.setOnAction(oa -> {
                    double xPosition = 20.0;
                    double yPosition = 370.0;
                labelFirstCommand.setText(Constants.command.get(tempNumFirstAdapter).toString());
                    if (tempNumFirstAdapter < 11) {
                        ArrayList<MemoryBlock> firstAdapterModel = firstAdapter.get(tempNumFirstAdapter);
                        tempNumFirstAdapter++;
                        ArrayList<javafx.scene.control.Label> labelArrayList = new ArrayList<javafx.scene.control.Label>(50);
                        for (int i = 0; i < firstAdapterModel.size(); i++) {
                            javafx.scene.control.Label label = new Label();
                            System.out.println(firstAdapterModel.get(i).getCurTag());
                            switch (firstAdapterModel.get(i).getCurTag()) {
                                case 0:
                                    label.setText("Blank Space\n   ");
                                    label.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                                    break;
                                case 1:
                                    label.setText("Homework 1\n" + firstAdapterModel.get(i).getStartPosition() + " " + firstAdapterModel.get(i).getEndPosition());
                                    label.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
                                    break;
                                case 2:
                                    label.setText("Homework 2\n" + firstAdapterModel.get(i).getStartPosition() + " " + firstAdapterModel.get(i).getEndPosition());
                                    label.setBackground(new Background(new BackgroundFill(Color.PALEGREEN, null, null)));
                                    break;
                                case 3:
                                    label.setText("Homework 3\n" + firstAdapterModel.get(i).getStartPosition() + " " + firstAdapterModel.get(i).getEndPosition());
                                    label.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD, null, null)));
                                    break;
                                case 4:
                                    label.setText("Homework 4\n" + firstAdapterModel.get(i).getStartPosition() + " " + firstAdapterModel.get(i).getEndPosition());
                                    label.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, null, null)));
                                    break;
                                case 5:
                                    label.setText("Homework 5\n" + firstAdapterModel.get(i).getStartPosition() + " " + firstAdapterModel.get(i).getEndPosition());
                                    label.setBackground(new Background(new BackgroundFill(Color.GOLD, null, null)));
                                    break;
                                case 6:
                                    label.setText("Homework 6\n" + firstAdapterModel.get(i).getStartPosition() + " " + firstAdapterModel.get(i).getEndPosition());
                                    label.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
                                    break;
                                case 7:
                                    label.setText("Homework 7\n" + firstAdapterModel.get(i).getStartPosition() + " " + firstAdapterModel.get(i).getEndPosition());
                                    label.setBackground(new Background(new BackgroundFill(Color.PALEGREEN, null, null)));
                                    break;
                            }
                            label.setPrefWidth(firstAdapterModel.get(i).getCurLength()+10);
                            label.setPrefHeight(80);
                            //System.out.println(firstAdapterModel.get(i).getCurLength()+",,,,,,");
                            label.setLayoutX(xPosition);
                            label.setLayoutY(yPosition);
                            xPosition += firstAdapterModel.get(i).getCurLength();
                            root.getChildren().add(label);
                        }
                    }
                    else tempNumFirstAdapter=0;

                });

            root.getChildren().add(strBestButton);
            root.getChildren().add(strFirstButton);

            Label labelColor = new Label("颜色说明");
            labelColor.setFont(new Font("Arial",15));
            labelColor.setLayoutX(40);
            labelColor.setLayoutY(530);
            root.getChildren().add(labelColor);

            double xPosition = 20.0;
            double yPosition = 580.0;
            for (int i=0;i<8;i++){
                Label label = new Label();
                switch (i){
                    case 0:
                        label.setText("Blank Space\n");
                        label.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                        break;
                    case 1:
                        label.setText("Homework 1\n" );
                        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
                        break;
                    case 2:
                        label.setText("Homework 2\n" );
                        label.setBackground(new Background(new BackgroundFill(Color.PALEGREEN, null, null)));
                        break;
                    case 3:
                        label.setText("Homework 3\n" );
                        label.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD, null, null)));
                        break;
                    case 4:
                        label.setText("Homework 4\n" );
                        label.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, null, null)));
                        break;
                    case 5:
                        label.setText("Homework 5\n" );
                        label.setBackground(new Background(new BackgroundFill(Color.GOLD, null, null)));
                        break;
                    case 6:
                        label.setText("Homework 6\n" );
                        label.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
                        break;
                    case 7:
                        label.setText("Homework 7\n" );
                        label.setBackground(new Background(new BackgroundFill(Color.PALEGREEN, null, null)));
                        break;
                }
                label.setPrefWidth(80);
                label.setPrefHeight(60);
                label.setLayoutX(xPosition);
                label.setLayoutY(yPosition);
                xPosition += 80;
                root.getChildren().add(label);
            }


            primaryStage.setScene(scene);
            primaryStage.setTitle("动态分区分配方式");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
/*
public class Main {
    public static void main(String args[]){
        Constants constants = new Constants();
        //FirstAdapterModel firstAdapterModeler = new FirstAdapterModel();
        //firstAdapterModeler.firstAdapterModel();
        BestAdapterModel bestAdapterModeler = new BestAdapterModel();
        bestAdapterModeler.bestAdapterModel();

    }
}
*/

/*
            ArrayList<MemoryBlock> firstAdapterModel = new ArrayList<MemoryBlock>(50);
            FirstAdapterModel firstAdapterModeler = new FirstAdapterModel();
            firstAdapterModel = firstAdapterModeler.firstAdapterModel();

*/

            /*for (int j=0;j<11;j++) {
                yPosition += 100;
                ArrayList<MemoryBlock> bestAdapterModel = bestAdapter.get(j);
                ArrayList<javafx.scene.control.Label> labelArrayList = new ArrayList<javafx.scene.control.Label>(50);
                for (int i = 0; i < bestAdapterModel.size(); i++) {
                    javafx.scene.control.Label label = new Label();
                    switch (bestAdapterModel.get(i).getCurTag()){
                        case 0:
                            label.setText("Blank Space\n   ");
                            label.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
                            break;
                        case 1:
                            label.setText("Homework 1\n"+bestAdapterModel.get(i).getStartPosition()+" "+bestAdapterModel.get(i).getEndPosition());
                            label.setBackground(new Background(new BackgroundFill(Color.YELLOW,null,null)));
                            break;
                        case 2:
                            label.setText("Homework 2\n"+bestAdapterModel.get(i).getStartPosition()+" "+bestAdapterModel.get(i).getEndPosition());
                            label.setBackground(new Background(new BackgroundFill(Color.PALEGREEN,null,null)));
                            break;
                        case 3:
                            label.setText("Homework 3\n"+bestAdapterModel.get(i).getStartPosition()+" "+bestAdapterModel.get(i).getEndPosition());
                            label.setBackground(new Background(new BackgroundFill(Color.PALEGOLDENROD,null,null)));
                            break;
                        case 4:
                            label.setText("Homework 4\n"+bestAdapterModel.get(i).getStartPosition()+" "+bestAdapterModel.get(i).getEndPosition());
                            label.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW,null,null)));
                            break;
                        case 5:
                            label.setText("Homework 5\n"+bestAdapterModel.get(i).getStartPosition()+" "+bestAdapterModel.get(i).getEndPosition());
                            label.setBackground(new Background(new BackgroundFill(Color.GOLD,null,null)));
                            break;
                        case 6:
                            label.setText("Homework 6\n"+bestAdapterModel.get(i).getStartPosition()+" "+bestAdapterModel.get(i).getEndPosition());
                            label.setBackground(new Background(new BackgroundFill(Color.GRAY,null,null)));
                            break;
                        case 7:
                            label.setText("Homework 7\n"+bestAdapterModel.get(i).getStartPosition()+" "+bestAdapterModel.get(i).getEndPosition());
                            label.setBackground(new Background(new BackgroundFill(Color.PALEGREEN,null,null)));
                            break;
                    }
                    label.setPrefWidth(bestAdapterModel.get(i).getCurLength());
                    label.setLayoutX(xPosition);
                    label.setLayoutY(yPosition);
                    xPosition+=bestAdapterModel.get(i).getCurLength();
                    labelArrayList.add(label);
                }
                for (int i = 0; i < labelArrayList.size(); i++) {
                    root.getChildren().add(labelArrayList.get(i));
                }
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            */