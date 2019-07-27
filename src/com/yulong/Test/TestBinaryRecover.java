package com.yulong.Test;

import com.yulong.MyBST.Node;

/**
 * @program: JavaInterview
 * @description:
 * @author: Dragon
 * @create: 2019-06-28 12:01
 */
public class TestBinaryRecover {
    public static void main(String[] args) {
        int[] pre = {5,3,2,4,6,8,7};
        int[] in = {2,3,4,5,6,7,8};
        Node node = reConstructBinaryTree(pre, in);
    }

    public static Node reConstructBinaryTree(int [] pre, int [] in) {
        if(pre==null||in==null){
            return null;
        }

        java.util.HashMap<Integer,Integer> map= new java.util.HashMap<Integer, Integer>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
    }

    public static Node<Integer> preIn(int[] p, int pi, int pj, int[] n, int ni, int nj, java.util.HashMap<Integer,Integer> map){
        if(pi>pj){
            return null;
        }
        Node<Integer> head = new Node<>(p[pi]);
        int index=map.get(p[pi]);
        head.left=preIn(p,pi+1,pi+index-ni,n,ni,index-1,map);
        System.out.print(head.e + "===");
        head.right=preIn(p,pi+index-ni+1,pj,n,index+1,nj,map);
        //System.out.print(head.e + "***");
        return head;
    }
}
