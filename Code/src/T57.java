/**
 * Author: zhangxin
 * Time: 2016/11/27 0027.
 * Desc:删除链表中重复的节点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * <p>
 * 注意:只要是重复的节点,都删掉,一个不留;
 */
public class T57 {


    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode p0 = new ListNode(pHead.val - 1);
        p0.next = pHead;
        ListNode p = p0;
        ListNode q = pHead;

        while (q != null) {
            //想跳过该重复节点;
            while (q.next != null && (q.next.val == q.val)) {
                q = q.next;
            }

            if (p.next != q) {
                //此时,q.next才是新的数,q还是重复的数
                q = q.next;
                p.next = q;
                //但是此时要注意的是,q此时已然可能是重复的节点;
            } else {
                //可以确定q是一个单一的节点,后移;
                p = q;
                q = q.next;
            }
        }

        return p0.next;

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;
        T57 t = new T57();
        ListNode p = t.deleteDuplication(n1);
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }


}
