/**
 * Title : Choppa
 * Author : Keiran "Affix" Smith
 * License : GNU/GPLv3
 * Copyright : Keiran Smith
 *
 * Description : Choppa is a simple Powerbot Script to Chop and Drop Normal Logs.
 * This is a basic script written as an example.
 */

package Choppa;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;


public class Drop extends Task<ClientContext> {

    private int logID = 1511;

    public Drop(ClientContext ctx)
    {
        super(ctx);
    }

    @Override
    public boolean activate()
    {
        return ctx.backpack.select().count() == 28;
    }

    @Override
    public void execute()
    {
        for(Item i: ctx.backpack.id(logID))
        {
            i.interact("Drop");
        }
    }
}
