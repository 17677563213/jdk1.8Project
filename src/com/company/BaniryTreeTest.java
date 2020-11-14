package com.company;

import org.junit.Test;

public class BaniryTreeTest {

    @Test
    public void method01(){
        BaniryTree<Integer, String> treeNode = new BaniryTree<>();
        treeNode.put(1, "蘑菇街");
        treeNode.put(2, "华为");
        treeNode.put(3, "阿里巴巴");
        treeNode.put(4, "京东");
        Integer minKey = treeNode.getMinKey();
        System.out.println("获取最小的键"+minKey);
        Integer maxKey = treeNode.getMaxKey();
        System.out.println("获取最大的键"+maxKey);


//        System.out.println("元素个数"+treeNode.getElement());
//        System.out.println("获取key=4的元素"+treeNode.getValueByKey(1));
//        treeNode.delete(3);
//        System.out.println("删除元素key=3的元素"+treeNode.getValueByKey(3));
//        System.out.println("获取最小元素"+treeNode.getMin());
//        System.out.println("获取最大元素"+treeNode.getMax());
//        /**
//         * 太巧妙了:
//         *  通过链表形式构建一个二叉树:
//         *  主要采用队规操作
//         *
//         */
//
//
//        /**
//         * 掌握内容:
//         *  springboot如何整合es搜索引擎
//         *  logstash如果实现数据库与索引库之间数据的同步:
//         *      需要配置文件进行需要的配置信息:
//         *          1.连接数据库的地址
//         *          2.用户名称
//         *          3.密码
//         *          4.驱动
//         *          5.执行的sql语句
//         *          6.定时任务设置(最小一分钟触发一次)
//         *          7.是否分页
//         *          8.一页显示多少条
//         *      输出部分:
//         *          1.对应哪个索引库
//         *          2.数据类型;article
//         *          3.文本中id的类型
//         *          4.
//         */
//
//
//        /**
//         * springboot中实体类
//         * 与采用spring data jpa模式一样
//         * 1.持久层接口需要继承elasticsearchReponsity<自己创建实体类,主键数据类型>
//         * 2.@id
//         * 3.
//         *   @Field(
//         *             //类型
//         *             type = FieldType.Text,
//         *             //是否生成索引,默认是true，如果是false，则保存的时候，不生成索引词条
//         *             index=true,
//         *             //存储文档的时候，生成索引词条所使用的分词器
//         *             analyzer="ik_max_word",
//         *             //进行字段分词搜索的时候，使用的分词器
//         *             searchAnalyzer="ik_max_word"
//         *     )
//         *
//         *     analyzer="ik_max_word"
//         *     searchAnalyzer="ik_max_word"
//         *
//         */
    }


}
