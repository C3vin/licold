
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists_Recursion(l1.next, l2);       // 內部循環
            return l1;
        }
        else {
            l2.next = mergeTwoLists_Recursion(l1, l2.next);
            return l2;
        }
