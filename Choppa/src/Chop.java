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

import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.ClientContext;

public class Chop extends Task<ClientContext> {

    private int TreeIds[] = {38785, 1286, 38783};

    public Chop(ClientContext ctx)
    {
        super (ctx);
    }

    @Override
    public boolean activate()
    {
        return ctx.backpack.select().count() < 28
                && !ctx.objects.select().id(TreeIds).isEmpty()
                && ctx.players.local().animation() == -1;
    }

    @Override
    public void execute()
    {
        GameObject tree = ctx.objects.nearest().poll();
        if(tree.inViewport())
        {
            tree.interact("Chop");
        } else {
            ctx.movement.step(tree);
            ctx.camera.turnTo(tree);
        }
    }
}
