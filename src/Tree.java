import java.util.Stack;

class Tree {
    private Node rootNode;//корень дерева
    public Tree() {rootNode = null;}//создание пустого дерева
    public Node findNodeByValue(int value) {
        Node currentNode = rootNode;
        while (currentNode.getValue() != value) {//перебор от корневого узла к узлу, которое имеет заданное
            // значение
            if (value < currentNode.getValue()) {//если значение меньше чем значение корневого узла,
                // то поинтер движется влево
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();//иначе двигайся поинтер движется влево по бинарному
                // дереву
            }
            if (currentNode == null) { // если потомка нет,
                return null;
            }
        }
        return currentNode;
    }
    public void insertNode(int value) {
        Node newNode = new Node();
        newNode.setValue(value);//инициализация узла и присваивание ему значения
        if (rootNode == null) { // если корневой узел не существует, то новый элемент и есть корневой узел
            rootNode = newNode;
        }
        else {
            Node currentNode = rootNode; // начинаем с корневого узла
            Node parentNode;
            while (true)
            {
                parentNode = currentNode;//обозначаем корневой узел как родительский
                if(value == currentNode.getValue()) {//если значение его равно данному, то такой узел уже есть,
                    // поэтому выходим из метода
                    return;
                }
                else  if (value < currentNode.getValue()) {//если значение его меньше, чем данное,
                    // то поинтер движется влево
                    currentNode = currentNode.getLeftChild();//и если потомка не существует, то ставим узел с
                    // данным значением как его потомок
                    if (currentNode == null){
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                }
                else { //если значение его больше, чем данное, то поинтер движется направо, и если был достигнут
                    //конец цепочки, то есть потомка у этого узла не существует, то вставим узел с данными
                    //значениями
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }
    public boolean deleteNode(int value)
    {
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isLeftChild = true;
        //с помощью цикла while ыполняется поиск узла с заданным значенением
        while (currentNode.getValue() != value) {//если значене корневого узла, не равно данному значению, то
            //поинтером становится корневой узел
            parentNode = currentNode;
            if (value < currentNode.getValue()) {//если значение поинтера больше, чем данное, то поинтер
                //движется влево
                isLeftChild = true;
                currentNode = currentNode.getLeftChild();
            }
            else { //если значение поинтера больше, чем данное, то поинтер движется вправо
                isLeftChild = false;
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null)
                return false; // yзел не найден
        }
        //если узел не имеет потомков, то он просто удаляется
        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            if (currentNode == rootNode)
                rootNode = null;
            else if (isLeftChild)
                parentNode.setLeftChild(null); //если узел был левым потомком, то значение левого потомка у предыдущего
                // узла зануляется
            else
                parentNode.setRightChild(null);//иначе узел был правым потомком, значит значение правого потомка у
            //предыдущего узла занулсяется
        }
        //если удаляемый узел имеет только левого потомка
        else if (currentNode.getRightChild() == null) {
            if (currentNode == rootNode)
                rootNode = currentNode.getLeftChild();//следовательно корневым узлом становится левый потомок
            //(Если мы удаляем правый элемент, но оставляем левый, тогда дерево не бинарное)
            else if (isLeftChild)//если удаляемый узел был левым потомком, то левый потомок предыдущего узла
                //теперь является левый потомок удаляемого узла
                parentNode.setLeftChild(currentNode.getLeftChild());
            else//если удаляемый узел был правым потомком, то правый потом предыдущего узла теперь является левый
            //потомок удаляемого узла
                parentNode.setRightChild(currentNode.getLeftChild());
        }
        //если удаляемый узел имеет только правого потомка
        else if (currentNode.getLeftChild() == null) {//следовательно корневым узлом становится левый потомок
            if (currentNode == rootNode)
                rootNode = currentNode.getRightChild();
                //(Если мы удаляем правый элемент, но оставляем левый, тогда дерево не бинарное)
            else if (isLeftChild)//если удаляемый узел был левым потомком, то левый потомок предыдущего узла
                //теперь является правый потомок удаляемого узла
                parentNode.setLeftChild(currentNode.getRightChild());
            else//если удаляемый узел был правым потомком, то правый потом предыдущего узла теперь является правый
                //потомок удаляемого узла
                parentNode.setRightChild(currentNode.getRightChild());
        }
        else {//если у удаляемого узла имеется оба потомка, то ищется подходящий преемник и он становится корневым узлом
            Node heir = receiveHeir(currentNode);
            if (currentNode == rootNode)
                rootNode = heir;
            else if (isLeftChild)//если удаляемый узел был левым потомком, то левый потомок предыдущего узла будет преемником
                parentNode.setLeftChild(heir);
            //если удаляемый узел был правым потомком, то правый потом удаляемого предыдущего узла будет преемником
            else
                parentNode.setRightChild(heir);
        }
        return true; // элемент успешно удалён
    }
    // метод возвращает узел со следующим значением после передаваемого аргументом.
    // для этого он сначала переходим к правому потомку, а затем
    // отслеживаем цепочку левых потомков этого узла.
    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRightChild();
        while (currentNode != null) //поиск подходящего преемника
        {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeftChild();
        }
        if (heirNode != node.getRightChild())
        { //создание связей между узлами
            parentNode.setLeftChild(heirNode.getRightChild());
            heirNode.setRightChild(node.getRightChild());
        }
        return heirNode;// возвращаем приемника
    }
    public void printTree() {
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(rootNode);//запушиваем корневой узел в стек
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "\n\n\n";//обозначение нового бинарного дерева
        System.out.println(separator);
        while (isRowEmpty == false) {//пока не закончатся строки
            Stack localStack = new Stack();//стек потомков
            isRowEmpty = true;
            for (int j = 0; j < gaps; j++){System.out.print(' ');}//?????
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getValue()); // выводим его значение в консоли
                    localStack.push(temp.getLeftChild()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null || temp.getRightChild() != null)
                        isRowEmpty = false;//сли имеются еще потомки, то не заканчиваем цикл
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++) {System.out.print(' ');}
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false) {globalStack.push(localStack.pop());} // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }
}