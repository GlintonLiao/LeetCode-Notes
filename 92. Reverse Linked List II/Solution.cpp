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
ListNode* ta;

class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        auto p = dummy;
        for (int i = 0; i < left - 1; i++) p = p->next;
        ListNode* l = p->next;
        p->next = reverse(p->next, right - left);
        if (l) l->next = ta;
        return dummy->next;
    }
    
    ListNode* reverse(ListNode* root, int len)
    {
        if (len == 0) {
            ta = root->next;
            return root;
        }
        ListNode* se = root->next;
        root->next = NULL;
        ListNode* newHead = reverse(se, len - 1);
        se->next = root;
        return newHead;
    }
};