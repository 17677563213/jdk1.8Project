package com.company;

public class DeptFirstSearch {
    //表示遍历过的点
    private boolean [] marked;
    //相同点的个数:
    private int count;

    public DeptFirstSearch(Graph graph,int spot){
        this.marked=new boolean[graph.getSpotNumber()];
        this.count=0;
        dfs(graph, spot);

    }
    public void dfs(Graph graph , int spot){
        //表示该点已经被遍历过:
        this.marked[spot]=true;
        for (Object o : graph.getAllAdjoinSpot(spot)) {
            if(!this.marked[Integer.valueOf(o.toString())]){
                dfs(graph, Integer.valueOf(o.toString()));
            }
        }
        this.count++;
    }
    //判断某一个点与顶点是否相连:
    public boolean isConnect(int spot){
        return this.marked[spot];
    }
    //获取与顶点相连的总个数:
    public int getConnectNumber(){
        return this.count;
    }







}
