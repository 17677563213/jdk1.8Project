package com.company;

import org.junit.Test;
import sun.awt.SunHints;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class RedBlackTree<Key extends  Comparable<Key>,Value>  {
    //内部类:
    private class Node{
        public Key key;
        public Value value;
        public Node left;
        public Node right;
        public boolean color;
//        构造方法:
        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }
    private Node root;
    private int N;
    private static final boolean RED=true;
    private static final boolean BACK=false;
    //判断是否是红色节点:
    public boolean isRed(Node node){
        if(node == null){
            return false;
        }
        return RED==node.color;

    }
    //获取元素个数:
    public int size(){
        return N;
    }
    //左旋(左旋返回结果是一个节点):
    public Node roteLeft(Node h){
        //获取节点
        Node x = h.right;
        //将x节点左边节点,移交给h,作为它的右节点
        h.right=x.left;
        //x的左节点变成h节点
        x.left=h;
        //x的颜色变成黑色
        x.color=false;
        //h的颜色变成红色
        h.color=true;
        return x;
    }
    //右旋:
    public Node roteRight(Node h){
        //获取x节点
        Node x = h.left;
        //将x右边节点,移交给s节点,作为它的左节点
        h.left=x.right;
        //设置x节点右边指向
        x.right=h;
        //
        x.right.color=true;
        x.left.color=true;
        h.color=true;
        return x;
    }
    //变色控制:
    public void flipColors(Node h){
        h.color=true;
        h.left.color=false;
        h.right.color=false;
       //没有产生新节点就不需要返回?
    }
    public void put(Key key , Value value){
        this.root=put(root, key, value);
        root.color=true;
    }
    public Node put(Node h,Key key ,Value value){
        //添加元素思路:
        /**
         * 1.如果为空该如何处理
         * 2.比较他们key,如果大于该如何操作,如果小于该如何操作,如果等于该如何操作
         *
         */
        if(h==null){
            N++;
            return new Node(key, value, null, null, true);
        }
        int result = key.compareTo(h.key);
        if(result<0){
            h.left=put(h.left, key, value);
        }else if(result>0){
            h.right=put(h.right, key, value);
        }else{
            h.value=value;
        }
        if(isRed(h.left)&&isRed((h.right))){
            flipColors(h);
        }
        if(isRed(h.left)&&isRed(h.left.left)){
           roteRight(h);
        }
        if(isRed(h.right)&&!isRed(h.left)){
           h= roteLeft(h);
        }
        return h;
    }
    //获取元素:
    public Value get(Key key){
       return  get(root, key);
    }
    public Value get(Node node ,Key key){
        if(node == null){
            return null;
        }
        int result = key.compareTo(node.key);
        if(result<0){
            return  get(node.left,key);
        }else if(result>0){
            return  get(node.right,key);
        }else{
            return node.value;
        }
    }
    //在方法设置巧妙啊,通过递归调用
    //这里面变色控制好像不起作用
    @Test
    public void method01(){
        RedBlackTree<String, String> redBlackTree = new RedBlackTree<>();
        redBlackTree.put("1","张三");
        redBlackTree.put("2","李四");
        redBlackTree.put("3","王五");
        System.out.println(redBlackTree.get("1"));
        System.out.println(redBlackTree.get("2"));
        System.out.println(redBlackTree.get("3"));
    }

    public void method02(){
        Queue<String> strings = new Queue<String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public boolean offer(String s) {
                return false;
            }

            @Override
            public String remove() {
                return null;
            }

            @Override
            public String poll() {
                return null;
            }

            @Override
            public String element() {
                return null;
            }

            @Override
            public String peek() {
                return null;
            }
        };
    }

    /**
     * 这里面的工具类方法还需要自己实现,就没有意义了
     */
}
