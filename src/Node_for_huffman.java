public class Node_for_huffman {
        char ch;
        int freq;
        Node_for_huffman left = null;
        Node_for_huffman right = null;

        Node_for_huffman(char ch, int freq)
        {
            this.ch = ch;
            this.freq = freq;
        }
    public Node_for_huffman(char ch, int freq, Node_for_huffman left, Node_for_huffman right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}
