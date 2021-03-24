package lang.commands.single;

import environments.Environment;

public final class Wait extends SingleCommand {
    private final int wait_time;
    public Wait(int wait_time_milliseconds){
        wait_time = wait_time_milliseconds;
    }
    @Override
    public void execute(Environment envi) {
        envi.wait(wait_time);
    }
}
