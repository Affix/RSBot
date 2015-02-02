/**
 * Title : Flaxinator
 * Author : Keiran "Affix" Smith
 * License : GNU/GPLv3
 * Copyright : Keiran Smith
 *
 * Description : Flaxinator is an Auto Flax Picker and Bow Stringer
 */

package Flaxinator;

import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.ClientContext;

public class PickFlax extends Task<ClientContext> {

    private int FlaxID[] = {2646};

    public PickFlax(ClientContext ctx)
    {
        super (ctx);
    }

    @Override
    public boolean activate()
    {
        return ctx.backpack.select().count() < 28
                && !ctx.objects.select().id(FlaxID).isEmpty()
                && ctx.players.local().animation() == -1;
    }

    @Override
    public void execute()
    {
        GameObject flax = ctx.objects.nearest().poll();
        /* Add Animation Check to Prevent Spam Clicking */
        if(flax.inViewport() && ctx.players.local().animation() == -1) {
            flax.interact("Pick");
        } else {
            ctx.movement.step(flax);
            ctx.camera.turnTo(flax);
        }
    }
}
