package com.leetcode;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*//		addTwoNums
		ListNode A, HeadA = A = new ListNode(1);
		ListNode B, HeadB = B = new ListNode(0);
		// for(int i=1;i<3;i++) {
		// A.next=new ListNode(i);
		// A=A.next;
		// B.next=new ListNode(i+8);
		// B=B.next;
		// }
		B.next = new ListNode(8);
//		Solution test = new Solution();
		test.printList(HeadA);
		test.printList(HeadB);
		test.printList(test.addTwoNumbers(HeadA, HeadB));*/
		Solution test = new Solution();
//	    ����Ӵ���
		test.lengthOfLongestSubstring("abcdde");
		
		

	}

//����һ���ַ������ҳ��������ظ��ַ�����Ӵ��ĳ��ȡ�
//
//ʾ����
//
//���� "abcabcbb" ��û���ظ��ַ�����Ӵ��� "abc" ����ô���Ⱦ���3��
//
//���� "bbbbb" ������Ӵ����� "b" ��������1��
//
//���� "pwwkew" ����Ӵ��� "wke" ��������3����ע��𰸱�����һ���Ӵ���"pwke" �� ������  �������Ӵ���
	
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), length = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        int i,j;
        String str = null;
        for ( j = 0, i = 0; j < n; j++) {
        	
            i = Math.max(index[s.charAt(j)], i);//�Ƚϸ��ַ�λ�ô洢��λ����Ϣ �Ƿ�����  i�ǿ�ͷ��һ���ַ�λ�� 
            length = Math.max(length, j - i + 1);//��¼���� ���ֵ
            index[s.charAt(j)] = j + 1;//����ǲ�ͬ�ַ����һֱ������ȥ ���������ͬ�ַ� ������֮ǰ��λ�õ����� ���ǵ��� 
        }
       
     return length;

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head, Sum = head = new ListNode(0), pre = null;
		int val, temp;
		while (l1 != null || l2 != null) {

			val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
			temp = Sum.val + val;
			Sum.val = temp % 10;
			Sum.next = new ListNode(temp / 10);
			pre = Sum;
			Sum = Sum.next;

			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;

		}

		// while (l1 != null && l2 != null) {
		// val = l1.val + l2.val;
		// temp = Sum.val + val;
		// Sum.val = temp % 10;
		// System.out.println(temp+" Sum.val:"+Sum.val);
		// Sum.next = new ListNode(temp / 10);
		// pre=Sum;
		// Sum = Sum.next;
		// l1 = l1.next;
		// l2 = l2.next;
		//
		// }

		// while (l2 != null) {
		// temp = Sum.val + l2.val;
		// Sum.val = temp % 10;
		// Sum.next = new ListNode(temp / 10);
		// pre=Sum;
		// Sum = Sum.next;
		// l2=l2.next;
		//
		//
		//
		// }
		// while (l1 != null) {
		// temp = Sum.val + l1.val;
		// Sum.val = temp % 10;
		// Sum.next = new ListNode(temp / 10);
		// pre=Sum;
		// Sum = Sum.next;
		// l1=l1.next;
		// }
		//
		if (Sum.val == 0)
			pre.next = null;
		return head;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}