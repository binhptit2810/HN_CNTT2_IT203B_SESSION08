package Bai05;

public class RemoteControl {
    private Command sleepCommand;

    public void setSleepCommand(Command sleepCommand) {
        this.sleepCommand = sleepCommand;
    }

    public void pressSleep() {
        if (sleepCommand == null) {
            System.out.println("(Chưa gán lệnh sleep)");
            return;
        }
        sleepCommand.execute();
    }
}

