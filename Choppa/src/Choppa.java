/**
 * Title : Choppa
 * Author : Keiran "Affix" Smith
 * License : GNU/GPLv3
 * Copyright : Keiran Smith
 *
 * Description : Choppa is a simple Powerbot Script to Chop and Drop Normal Logs.
 * This is a basic script written as an example.
 */

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.ClientContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Script.Manifest(name="Choppa", description="Powerchops Normal Trees then Drops the Logs")

public class Choppa extends PollingScript<ClientContext> {

    private List<Task> taskList = new ArrayList<Task>();

    @Override
    public void start() {
        taskList.addAll(Arrays.asList(new Chop(ctx), new Drop(ctx)));
    }

    @Override
    public void poll() {
        for (Task task: taskList)
        {
            if(task.activate())
            {
                task.execute();
            }
        }
    }


}
