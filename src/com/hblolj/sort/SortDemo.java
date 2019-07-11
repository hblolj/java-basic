package com.hblolj.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Create With hblolj.
 * Data : 2019/6/6
 * Time : 13:26
 */
public class SortDemo {

    public static void main(String[] args) {

        String currentNode = "r-0000004";

        String currentNode1 = "/parent/r-0000004";

        String replace = currentNode1.replace("/parent/", "");

        System.out.println(replace);

        List<String> nodes = new ArrayList<>();
        nodes.add("r-0000008");
        nodes.add("r-0000005");
        nodes.add("w-0000006");
        nodes.add("r-0000001");
        nodes.add("r-0000004");
        nodes.add("r-0000002");
        nodes.add("w-0000003");
        nodes.add("w-0000007");

        System.out.println(nodes.toString());

        // 1. 按序号排序
        nodes.sort(Comparator.comparing(n -> n.split("-")[1]));
        System.out.println(nodes.toString());

        // 2. 找到当前节点在 nodes 中的位置，现在做读锁处理，判断前面是否存在写锁
        int currentIndex = 0;
        for (int i = nodes.size()-1 ; i >= 0; i--) {
            if (currentNode.equals(nodes.get(i))){
                // 记录当前 node 的 位置
                currentIndex = i;
            }else {
                if (i < currentIndex && nodes.get(i).split("-")[0].equals("w")){
                    // 当前节点前面的节点，并且是写节点。这里找到的一定是前面离当前 node 最近的写节点
                    // 添加对该写节点的删除监听，然后阻塞，完事后，break
                    System.out.println(currentNode + " 前面的最近的一个写节点: " + nodes.get(i));
                    break;
                }
            }
        }
    }
}
