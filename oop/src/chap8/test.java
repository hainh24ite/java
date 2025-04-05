package chap8;
public class test {
    public static void main(String[] args) {
        MyIntstack stack = new MyIntstack(5); // Tạo stack với dung lượng ban đầu là 5

        // Thử thêm phần tử vào stack
        for (int i = 1; i <= 7; i++) {
            System.out.println("Pushing: " + i);
            stack.push(i);  // Thêm phần tử vào stack
        }

        // Xem phần tử trên cùng mà không xóa
        System.out.println("Top element is: " + stack.peek());

        // Xóa và in ra phần tử từ stack
        while (!stack.isEmpty()) {
            System.out.println("Popping: " + stack.pop());
        }

        // Thử pop khi stack rỗng (sẽ ném ngoại lệ)
        try {
            stack.pop();  // Đây sẽ ném ngoại lệ vì stack đã rỗng
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());  // In thông báo lỗi
        }
    }
}