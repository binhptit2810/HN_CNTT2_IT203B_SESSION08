package Bai03;

public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("(Chưa gán lệnh cho nút này)");
    }

    @Override
    public void undo() {
        System.out.println("(Không có lệnh để undo)");
    }
}

