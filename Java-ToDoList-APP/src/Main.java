public class Main {

    public static String[] model = new String[10];

    public static void main(String[] args) {
        testRemoveTodoList();
    }

    // Menampilkan ToDoList
    public static void showTodoList() {
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList(){
        model[1] = "B";
        model[0] = "A";
        showTodoList();
    }

    // Menambah ToDoList
    public static void addTodoList(String todo){
        // cek apakah model penuh?
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // jika penuh resize array x2
        if (isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // Tambahkan ke array yang NULL
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddToDoList (){
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh " + i);
        }

        showTodoList();

    }

    // Menghapus ToDoList
    public static boolean removeTodoList(Integer number){
        if ((number - 1) >= model.length){
            return false;
        }else if (model[number - 1] == null){
            return false;
        } else {
             model[number - 1] = null;
            return true;
        }
    }

    public static void testRemoveTodoList(){
        addTodoList("1");
        addTodoList("1");
        addTodoList("1");

        var result = removeTodoList(2 );
        System.out.println(result);

        showTodoList();
    }

    //Menampilkan view ToDoList
    public static void viewShowTodoList(){

    }

    //Menampilkan view Menambah TodoList
    public static void viewAddTodoList(){

    }

    //Menampilkan viewe Menghapus TodoList
    public static void viewRemoveTodoList(){

    }
}
