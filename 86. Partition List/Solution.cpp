/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        if (!head) return head;
        ListNode* l1 = new ListNode(-1);
        ListNode* l2 = new ListNode(-1);
        auto c1 = l1, c2 = l2;
        auto p = head;
        while (p) {
            if (p->val < x)
            {
                l1->next = new ListNode(p->val);
                l1 = l1->next;
            }
            else 
            {
                l2->next = new ListNode(p->val);
                l2 = l2->next;
            }
            p = p->next;
        }
        l1->next = c2->next;
        return c1->next;
    }
};
