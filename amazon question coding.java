Q. There is a binary tree where each node has a special pointer to its parent.  The tree has been corrupted and only the parent nodes and data are available.  Write a function where given the leaf nodes of the original tree, it will reconstruct the original tree by populating the left/right child pointers for all the nodes.

class Node {
    char data;
    Node left;  << Corrupted (lost).  Repopulate this pointer
    Node right; << Corrupted (lost).  Repopulate this pointer
    Node parent;.
}

Example Tree:
. 1point3acres.com/bbs
         A
   B           C
           D       E
                       F                        
leaves: [B,D,F]

void constructTree(List<Node> leafNodes){

}


找到所有的node,然后挨个修复这样? 抱歉我写的C++. more info on 1point3acres.com

    Node* constructTree(vector<Node*> leafNodes) {
            unordered_set<Node*> nodecollection;
            for(auto node:leafNodes) {. 鐣欏鐢宠璁哄潧-涓€浜╀笁鍒嗗湴
                    while(node && !nodecollection.count(node)) {. from: 1point3acres.com/bbs
                            nodecollection.insert(node);
                            node = node->parent;
                    }
            }
            Node* root = NULL;
            for(auto node:nodecollection) {
                    if(!node->parent) {
                            root = node;
                    }
                    else {
                            if(!node->parent->left)
                                    node->parent->left = node;
                            else
                                    node->parent->right = node;
                    }
            }
            return root;
    }
    
    //javascript learning
    1. Ninjia : the secret of Javascript. 这本书太好了 2. 进阶书： the good part of javascript 3. Javascript的秘密花园， 这个涵盖了javascript所有能考的 知识点： http://bonsaiden.github.io/JavaScript-Garden/zh/ 4. 25 到模拟题： 每次面前端都刷一遍： https://www.toptal.com/javascript/interview-questions 5. 一些DOM 的知识，一些event 的知识，比如 propogation 和 delegation的知识，和一些常见的js 题: flatten a array, 用javascript array method rotated array 等等。

链接: https://instant.1point3acres.com/thread/191282
来源: 一亩三分地
