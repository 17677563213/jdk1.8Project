package com.company;

import javax.management.Query;
import javax.swing.tree.TreeNode;
import java.util.Comparator;
import java.util.Queue;
import java.util.Stack;

public class BaniryTree<Key extends Comparable<Key>, Value> {
    //    内部类:
    private class Node {
        public Key key;
        public Value value;
        public Node r;
        public Node l;

        public Node(Key key, Value value, Node r, Node l) {
            this.key = key;
            this.value = value;
            this.r = r;
            this.l = l;
        }



    }
    //    成员变量:
    private Node root;
    private int number;

    //    添加元素
    public void put(Key key, Value value) {
        this.root = put(root, key, value);

    }


//    添加元素重载

    /**
     * 思路:
     * 1.判断树是否为空,如果为空,创建新节点并直接进行返回
     * 2.进行keyde大小比较
     * 3.如果大于,获取右边节点
     * 4.如果小于,获取左边节点
     * 5.如果等于表示,需要进行修改value数据
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    public Node put(Node node, Key key, Value value) {
        if (node == null) {
            number++;
            return new Node(key, value, null, null);
        }
        int i = key.compareTo(node.key);
        if (i > 0) {
            node.r = put(node.r, key, value);
        } else if (i < 0) {
            node.l = put(node.l, key, value);
        } else {
            node.value = value;
        }
        return node;

    }

    //    删除元素
    public void delete(Key key) {
        root= delete(root, key);


    }


//    删除元素重载

    /**
     * 思路:
     * 1.判断是否为空
     * 2.获取key的比较情况
     * 3.如果大于获取右边节点
     * 4.如果小于获取左边节点
     * 5.如果等于进行删除操作
     *
     * @param n
     * @param key
     * @return
     */
    public Node delete(Node n, Key key) {
        if (n == null) {
            return null;

        }
        int i = key.compareTo(n.key);

        if (i > 0) {
            return delete(n.r, key);
        } else if (i < 0) {
            return delete(n.l, key);


//            确定该节点就是删除元素:
        } else {
            number--;
//            获取右边最小元素:
            if (n.r == null) {
                return n.l;
            }
            if (n.l == null) {
                return n.r;

            }
//如果左右两边都不为空
            Node rightMinNode = n.r;
            while (rightMinNode.l != null) {
                rightMinNode = rightMinNode.l;

            }
//            删除节点:
            Node setNullNode = n.r;
            while (setNullNode.l != null) {
                if (setNullNode.l.l != null) {
                    setNullNode.l = null;
                } else {
                    setNullNode = setNullNode.l;
                }

            }
//            左右两边重新设置:
            rightMinNode.l = n.l;
            rightMinNode.r = n.r;
            n = rightMinNode;


        }

        return n;

    }
//    获取元素个数
    public int getElement(){

        return number;
    }

//       获取元素:

    /**
     * 思路:
     *  1.需要两个方法进行重载:
     *  2.采用思想:递归调用
     *  3.判断元素是否为空,如果为空返回null,如果不为空,进行key的大小比较
     *  如果大于,获取右边的节点
     *  如果小于获取左边节点
     *  如果key等于,返回value的数据
     * @param key
     * @return
     */
    public Value getValueByKey(Key key){

        return getValueByKey(this.root, key);
    }
    public Value getValueByKey(Node node ,Key key){
        if(node ==null){
            return null;
        }
        int i = key.compareTo(node.key);
        if(i>0){
            return getValueByKey(node.r,key);
        }else if(i<0){
            return getValueByKey(node.l,key);
        }else{
            Value value = node.value;
            return value;
        }


    }

//    获取二叉树中最小key
    public Key getMin(){
    return getMin(root).key;
    }
    public Node getMin(Node node){
        if(node.l!=null){
            return getMin(node.l);
        }else{
            return node;
        }
    }

    public Key getMax(){
        return getMax(this.root).key;
    }
    public Node getMax(Node node){
        if(node.r!=null){
            return getMax(node.r);
        }else{
            return node;
        }



    }

    /**
     * 获取二叉树中最大key
     */
    public Key getMaxKey(){
       return getMax(root).key;

    }

    public Node getMaxKey(Node node){
        if(node.r!=null){
            return getMax(node.r);

        }else{
            return node;

        }


    };


    /**
     * 查询最小key的值:
     *
     * 思路:
     *  1.最小值,一直往左获取
     *  2.获取key最大值
     *
     */
    public Key getMinKey(){

        return getMinKey(root).key;
    }

    public Node getMinKey(Node node){
        if(node!=null&&node.l!=null){
           return  getMinKey(node.l);

        }else{
            return node;


        }

    }

    /**
     * 思路:
     *  1.采用递归操作
     *  2.判断是否为空
     *  3.添加元素到队列中
     *  4.之后再判断左边
     *  5.判断右边
     * @return
     */
    public CustomerQueue<Key> preErgodi(){
        CustomerQueue<Key> keyCustomerQueue = new CustomerQueue<>();
        preErgodi(root, keyCustomerQueue);

        return keyCustomerQueue;

    }
    public void preErgodi(Node treeNode, CustomerQueue<Key> keys){
        if(treeNode==null){
            return;

        }
        Key key = treeNode.key;
        keys.enqueue(key);
        if(treeNode.l!=null){
            preErgodi(treeNode.l, keys);


        }
        if(treeNode.r!=null){
            preErgodi(treeNode.r,keys);

        }

    }

    /**
     * 需求:
     *      对二叉树进行中序遍历:
     *  1.
     * @return
     */
    public CustomerQueue<String> midErgodic(){
        CustomerQueue<String> keys = new CustomerQueue<>();
        midErgodic(root, keys);
        return keys;

    }
    public void midErgodic(Node nodeTree,CustomerQueue<String> keys){
//        判断是否为空
        if(nodeTree==null){
            return ;

        }

//        判断左边
        if(nodeTree.l!=null){
            midErgodic(nodeTree.l,keys);
        }
//        中间添加元素
        keys.enqueue((String) nodeTree.key);
//        判断右边
        if(nodeTree.r!=null){
            midErgodic(nodeTree.r,keys);
        }


    }


    public CustomerQueue afterErgodic(){
        CustomerQueue<String> keys = new CustomerQueue<>();
        afterErgodic(root,keys);

        return keys;
    }
    public void afterErgodic(Node node,CustomerQueue keys){
        if(node==null){
            return ;
        }
        if(node.l!=null){
            afterErgodic(node.l,keys);
        }
        if(node.r!=null){
            afterErgodic(node.r,keys);
        }
        keys.enqueue(node.key);




    }

    /**
     * 层次遍历:从上往下,左往右
     *
     * 思路:
     *  1.需要采用两个队列,一个用来存储节点,一个用来存储key
     *  2.
      */
    public CustomerQueue<String> layerErgodic(){
        CustomerQueue<String> keys = new CustomerQueue<>();
        CustomerQueue<Node> nodes = new CustomerQueue<>();
        nodes.enqueue(root);
        while (!nodes.isEmpty()){
            //队列弹出元素
            Node node = nodes.deQueue();
            //将弹出元素放到另一个队列中
            keys.enqueue((String) node.key);
            //左边判断
            if(node.l!=null){
                nodes.enqueue(node.l);
            }
            if(node.r!=null){
                nodes.enqueue(node.r);
            }

        }



        return keys;

    }


    public int maxDepth(Node node){
        /**
         * 判断是否为空
         * 2.初始化,左右两边的深度
         * 3.比较左右两边获取最大值
         * 问题:
         *  1.没调用都会初始化一次
         */

        return 0;
    }


    /**
     * 需求:
     *  判断一个纯括号的字符串,是否是完全匹配,括号类型,括号闭合顺序
     *  别人思想:采用栈,先进后出性质
     */

    public boolean   isValid(String str){
        Stack<Character> stack = new Stack<>();
        for (char e : str.toCharArray()) {
            if(e=='('){
                stack.push(')');
            }else if(e=='['){
                stack.push(']');
            }else if(e=='{'){
                stack.push('}');
            }else if(stack.isEmpty()||stack.pop()!=e) {
                return false;

            }
        }
        return stack.isEmpty();
        /**
         * 思路: 模型分析,寻找特点
         */
        /**
         * 三种情况:
         * 如果是已经为空,或者是不相等,就可以直接终止循环
         * 2.
         */









    }













}
