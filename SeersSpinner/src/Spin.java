/**
 * Title : SeersSpinner
 * Author : Keiran "Affix" Smith
 * License : GNU/GPLv3
 * Copyright : Keiran Smith
 *
 * Description : Seers Spinner, Spin Flax in Seers Village
 */

package SeersSpinner;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

public class Spin extends Task<ClientContext> {

    Area spinArea = new Area(new Tile(2730, 3495, 0),new Tile(2721, 3491, 0));
    int spinnerID = 25824;

    public Spin(ClientContext ctx){

        super(ctx);

    }

    @Override
    public boolean activate(){

        return ctx.backpack.select().count()==28
                && !ctx.objects.select().id(spinnerID).isEmpty()
                && ctx.bank.opened()==false;

    }

    @Override
    public void execute(){
        GameObject spinner = ctx.objects.select().id(spinnerID).nearest().poll();

        if(spinner.inViewport())
        {
            spinner.interact("Spin");
        } else {
            ctx.movement.step(spinner);
            ctx.camera.turnTo(spinner);
        }

    }
}