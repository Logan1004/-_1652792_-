package Adapter;

import java.util.Vector;

public class Constants {
    //public static int maxMemory = 640;
    public static Vector taskVector = new Vector();
    public static Vector command = new Vector();

    public Constants() {
        taskVector.add(0,"1 1 130");
        taskVector.add(1,"2 1 60");
        taskVector.add(2,"3 1 100");
        taskVector.add(3,"2 0 60");
        taskVector.add(4,"4 1 200");
        taskVector.add(5,"3 0 100");
        taskVector.add(6,"1 0 130");
        taskVector.add(7,"5 1 140");
        taskVector.add(8,"6 1 60");
        taskVector.add(9,"7 1 50");
        taskVector.add(10,"6 0 60");
        command.add(0,"作业1申请130K");
        command.add(1,"作业2申请60K");
        command.add(2,"作业3申请100K");
        command.add(3,"作业2释放60K");
        command.add(4,"作业4申请200K");
        command.add(5,"作业3释放100K");
        command.add(6,"作业1释放130K");
        command.add(7,"作业5申请140K");
        command.add(8,"作业6申请60K");
        command.add(9,"作业7申请50K");
        command.add(10,"作业6释放60K");
        command.add(11,"演示完毕！点击按钮重新开始");
    }
}
