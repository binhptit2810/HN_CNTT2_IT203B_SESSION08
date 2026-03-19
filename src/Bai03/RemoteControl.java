package Bai03;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoteControl {
    private final Map<Integer, Command> slots = new HashMap<>();
    private final Stack<Command> history = new Stack<>();
    private final Command noCommand = new NoCommand();

    public void assign(int slot, Command command) {
        slots.put(slot, command);
        System.out.println("Đã gán " + command.getClass().getSimpleName() + " cho nút " + slot);
    }

    public void press(int slot) {
        Command command = slots.getOrDefault(slot, noCommand);
        command.execute();
        if (command != noCommand) {
            history.push(command);
        }
    }

    public void undo() {
        if (history.isEmpty()) {
            System.out.println("Không có lệnh để undo");
            return;
        }
        Command last = history.pop();
        last.undo();
    }

    public void listSlots() {
        if (slots.isEmpty()) {
            System.out.println("Chưa gán lệnh nào");
            return;
        }
        System.out.println("Danh sách nút đã gán:");
        slots.forEach((k, v) -> System.out.println("- Nút " + k + ": " + v.getClass().getSimpleName()));
    }
}

