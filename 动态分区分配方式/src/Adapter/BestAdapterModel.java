package Adapter;

import java.util.ArrayList;
import java.util.Vector;

public class BestAdapterModel {
    public ArrayList<MemoryBlock> memoryBlocks = new ArrayList<MemoryBlock>(50);
    public ArrayList<ArrayList<MemoryBlock>> bestAdapter = new ArrayList<ArrayList<MemoryBlock>>(50);
    public ArrayList bestAdapterModel(){
        Constants constants = new Constants();
        MemoryBlock mBlock = new MemoryBlock(0,640,0);

        memoryBlocks.add(0,mBlock);

        Vector firstAdapterCommand = constants.taskVector;

        for (int i=0;i<11;i++) {
            String[] sCommand = new String[3];
            sCommand = firstAdapterCommand.get(i).toString().split(" ");
            int[] numCommand = new int[3];
            for (int j = 0; j < 3; j++) {
                numCommand[j] = Integer.parseInt(sCommand[j]);
            }
            ArrayList<MemoryBlock> emptyMemoryBlocks = new ArrayList<MemoryBlock>(50);
            for (int j=0;j<memoryBlocks.size();j++){
                if (memoryBlocks.get(j).getCurTag() == 0) {
                    emptyMemoryBlocks.add(memoryBlocks.get(j));
                }
            }


            for (int j=0;j<emptyMemoryBlocks.size();j++){
                for (int k = j+1; k<emptyMemoryBlocks.size();k++){
                    if (emptyMemoryBlocks.get(k).getCurLength()<emptyMemoryBlocks.get(j).getCurLength()){
                        MemoryBlock tempMBlock = emptyMemoryBlocks.get(j);
                        emptyMemoryBlocks.set(j,emptyMemoryBlocks.get(k));
                        emptyMemoryBlocks.set(k,tempMBlock);

                    }
                }
            }

            if (numCommand[1]==1){
                boolean inputFlag = false;
                int tempEmpty;
                for (tempEmpty = 0; tempEmpty < emptyMemoryBlocks.size(); tempEmpty++){
                    if (emptyMemoryBlocks.get(tempEmpty).getCurLength()>numCommand[2]){
                        inputFlag = true;
                        break;
                    }
                }
                int temp;
                for (temp=0; temp<memoryBlocks.size();temp++){
                    if (memoryBlocks.get(temp).equals(emptyMemoryBlocks.get(tempEmpty))) break;
                }
                if (!inputFlag) System.out.println("分配空间不足");
                else{
                    int curStartPosition = emptyMemoryBlocks.get(tempEmpty).getStartPosition();
                    int curEndPosition = curStartPosition + numCommand[2];
                    MemoryBlock cMBlock = new MemoryBlock(curStartPosition,curEndPosition,numCommand[0]);
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
                    }
                    else if (temp>0 && memoryBlocks.get(temp-1).getCurTag()==0){
                        int curStartPosition = memoryBlocks.get(temp-1).getStartPosition();
                        int curEndPosition =  memoryBlocks.get(temp).getEndPosition();
                        //System.out.println(curStartPosition+ " "+curEndPosition+" 1");
                        MemoryBlock cMBlock = new MemoryBlock(curStartPosition,curEndPosition,0);
                        memoryBlocks.set(temp-1,cMBlock);
                        memoryBlocks.remove(temp);
                    }
                    else if (temp<memoryBlocks.size()-1 && memoryBlocks.get(temp+1).getCurTag()==0){
                        int curStartPosition = memoryBlocks.get(temp).getStartPosition();
                        int curEndPosition =  memoryBlocks.get(temp+1).getEndPosition();
                        //System.out.println(curStartPosition+ " "+curEndPosition+" 2");
                        MemoryBlock cMBlock = new MemoryBlock(curStartPosition,curEndPosition,0);
                        memoryBlocks.set(temp,cMBlock);
                        memoryBlocks.remove(temp+1);
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

            bestAdapter.add(result);
            System.out.println("");
            System.out.println("!!!");
            System.out.println("");
        }
        /*
        for (int i=0;i<11;i++){
            for (int t=0;t<bestAdapter.get(i).size();t++){
                System.out.print(bestAdapter.get(i).get(t).getCurTag()+" !! ");
            }
            System.out.println();
        }

        */
        return bestAdapter;
    }

}
