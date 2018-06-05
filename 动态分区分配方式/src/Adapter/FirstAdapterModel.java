package Adapter;

import java.util.ArrayList;
import java.util.Vector;

public class FirstAdapterModel {
    public ArrayList<MemoryBlock> memoryBlocks = new ArrayList<MemoryBlock>(50);
    public ArrayList<ArrayList<MemoryBlock>> firstAdapter = new ArrayList<ArrayList<MemoryBlock>>(50);
    public ArrayList firstAdapterModel(){
        Constants constants = new Constants();
        MemoryBlock mBlock = new MemoryBlock(0,640,0);
        int regionNum = 0;
        memoryBlocks.add(regionNum,mBlock);

        Vector firstAdapterCommand = constants.taskVector;

        for (int i=0;i<11;i++){
            String[] sCommand = new String[3];
            sCommand = firstAdapterCommand.get(i).toString().split(" ");
            int[] numCommand = new int[3];
            for (int j=0;j<3;j++){
                numCommand[j] = Integer.parseInt(sCommand[j]);

            }
            //System.out.println(numCommand[1]);

            if (numCommand[1]==1){
                boolean inputFlag = false;
                int temp;
                for (temp = 0; temp < memoryBlocks.size(); temp++){
                    if (memoryBlocks.get(temp).getCurTag() == 0 && memoryBlocks.get(temp).getCurLength()>numCommand[2]){
                        inputFlag = true;
                        break;
                    }
                }
                if (!inputFlag) System.out.println("分配空间不足");
                else{
                    int curStartPosition = memoryBlocks.get(temp).getStartPosition();
                    int curEndPosition = curStartPosition + numCommand[2];
                    MemoryBlock cMBlock = new MemoryBlock(curStartPosition,curEndPosition,numCommand[0]);
                    regionNum++;
                    memoryBlocks.get(temp).setStartPosition(curEndPosition);
                    memoryBlocks.get(temp).setCurLength();
                    memoryBlocks.add(temp,cMBlock);
                }
            }
            else{
                int temp = 0;
                boolean releaseFlag = false;
                for (temp=0; temp<memoryBlocks.size();temp++){
                    if (memoryBlocks.get(temp).getCurTag()==numCommand[0]){
                        releaseFlag = true;
                        break;
                    }
                }
                if (!releaseFlag) System.out.println("释放错误！");
                else{

                    if (temp>0 && temp<memoryBlocks.size()-1 && memoryBlocks.get(temp-1).getCurTag()==0 && memoryBlocks.get(temp+1).getCurTag()==0){
                        int curStartPosition = memoryBlocks.get(temp-1).getStartPosition();
                        int curEndPosition =  memoryBlocks.get(temp+1).getEndPosition();
                        //System.out.println(curStartPosition+ " "+curEndPosition+" 0");
                        MemoryBlock cMBlock = new MemoryBlock(curStartPosition,curEndPosition,0);
                        memoryBlocks.remove(temp+1);
                        memoryBlocks.remove(temp);
                        memoryBlocks.set(temp-1,cMBlock);
                        regionNum = regionNum-2;
                    }
                    else if (temp>0 && memoryBlocks.get(temp-1).getCurTag()==0){
                        int curStartPosition = memoryBlocks.get(temp-1).getStartPosition();
                        int curEndPosition =  memoryBlocks.get(temp).getEndPosition();
                        //System.out.println(curStartPosition+ " "+curEndPosition+" 1");
                        MemoryBlock cMBlock = new MemoryBlock(curStartPosition,curEndPosition,0);
                        memoryBlocks.set(temp-1,cMBlock);
                        memoryBlocks.remove(temp);
                        regionNum = regionNum -1;
                    }
                    else if (temp<memoryBlocks.size()-1 && memoryBlocks.get(temp+1).getCurTag()==0){
                        int curStartPosition = memoryBlocks.get(temp).getStartPosition();
                        int curEndPosition =  memoryBlocks.get(temp+1).getEndPosition();
                        //System.out.println(curStartPosition+ " "+curEndPosition+" 2");
                        MemoryBlock cMBlock = new MemoryBlock(curStartPosition,curEndPosition,0);
                        memoryBlocks.set(temp,cMBlock);
                        memoryBlocks.remove(temp+1);
                        regionNum = regionNum -1;
                    }
                    else{
                        int curStartPosition = memoryBlocks.get(temp).getStartPosition();
                        int curEndPosition =  memoryBlocks.get(temp).getEndPosition();
                        MemoryBlock cMBlock = new MemoryBlock(curStartPosition,curEndPosition,0);
                        //System.out.println(curStartPosition+ " "+curEndPosition+" 3");
                        memoryBlocks.set(temp,cMBlock);
                    }
                }
            }


            ArrayList<MemoryBlock> result = new ArrayList<MemoryBlock>();
            for (int j=0;j<memoryBlocks.size();j++){
                MemoryBlock memoryBlock = new MemoryBlock();
                memoryBlock.setStartPosition(memoryBlocks.get(j).getStartPosition());
                memoryBlock.setEndPosition(memoryBlocks.get(j).getEndPosition());
                memoryBlock.setCurTag(memoryBlocks.get(j).getCurTag());
                memoryBlock.setCurLength();
                result.add(memoryBlock);

            }

            firstAdapter.add(result);
            System.out.println("");
            System.out.println("!!!");
            System.out.println("");
        }
        return firstAdapter;

    }


}
