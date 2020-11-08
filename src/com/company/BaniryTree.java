package com.company;

import java.util.Comparator;

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
                number--;

            }

            return n;

        }
//    获取元素个数

    }


}
