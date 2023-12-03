public class Main {
    public static void main(String[] args){
        System.out.println("1.\tНаписать программу на языке Java, использующая функции: " +
                "1)Вставка узла в бинарное дерево" +
                "2)Удаление узла в бинарное дерево" +
                "3)Поиск узла по его значению в бинарное дерево"+
                "4)Вывод бинарного дерева");
        int value1= (int) (Math.random()*100);
        int value2= (int) (Math.random()*100);
        int value3= (int) (Math.random()*100);
        int value4= (int) (Math.random()*100);
        int value5= (int) (Math.random()*100);
        int value6= (int) (Math.random()*100);
        int value7= (int) (Math.random()*100);
        int value8= (int) (Math.random()*100);
        int value9= (int) (Math.random()*100);
        int value10= (int) (Math.random()*100);
        System.out.println("Вводимые значения: "+value1+" "+value2+" "+value3+" "+value4+" "+value5+" "+value6
        +" "+value7+" "+value8+" "+value9+" "+value10);
        Tree tree = new Tree();
        tree.insertNode(value1);
        tree.insertNode(value2);
        tree.insertNode(value3);
        tree.insertNode(value4);
        tree.insertNode(value5);
        tree.insertNode(value6);
        tree.insertNode(value7);
        tree.insertNode(value8);
        tree.insertNode(value10);
        tree.insertNode(value9);
        tree.printTree();
        System.out.println("Удаление элемента с значением"+value9);
        tree.deleteNode(value9);
        tree.printTree();
        System.out.println("Поиск элемента с значением"+value4);
        Node foundNode = tree.findNodeByValue(value4);
        System.out.println(foundNode);
        System.out.println("2.\nРеализовать алгоритм Хаффмана \n");
        String text1 = "Я препод по джаве на учебных субботах:)";
        Huffman test1= new Huffman();
        test1.buildHuffmanTree(text1);
        String text2 = "aabbbccccddddd";
        test1.buildHuffmanTree(text2);
    }
}
