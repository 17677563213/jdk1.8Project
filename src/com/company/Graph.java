package com.company;

/**
 * 图实体类:
 */
public class Graph {
    private int spotNumber;
    private int edgeNumber;
    private CustomerQueue<Integer> [] queuesArrays;
    //构造方法初始化顶点个数
    public Graph(int spotNumber) {
        this.spotNumber = spotNumber;
        this.queuesArrays=new CustomerQueue[spotNumber];
        for (int i = 0; i <queuesArrays.length ; i++) {
            queuesArrays[i]=new CustomerQueue();
        }
    }
    //获取顶点个数:
    public int getSpotNumber(){
        return spotNumber;
    }
    //获取边个数:
    public int getEdgeNumber(){
        return edgeNumber;
    }
    //对两个点添加边:
    public void connetTwoSpot(int spot1,int spot2){
        queuesArrays[spot1].enqueue(spot2);
        queuesArrays[spot2].enqueue(spot1);
    }
    //获取某个点所有相邻点:
    public CustomerQueue<Integer> getAllAdjoinSpot(int spot){
        return queuesArrays[spot];

    }
}
