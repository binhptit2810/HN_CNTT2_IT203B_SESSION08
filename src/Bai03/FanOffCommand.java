package Bai03;

public class FanOffCommand implements Command {
    private final Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.off();
    }

    @Override
    public void undo() {
        fan.on();
        System.out.println("Undo: Quạt Bật");
    }
}

