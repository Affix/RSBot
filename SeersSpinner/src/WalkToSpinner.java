/**
 * Title : SeersSpinner
 * Author : Keiran "Affix" Smith
 * License : GNU/GPLv3
 * Copyright : Keiran Smith
 *
 * Description : Seers Spinner, Spin Flax in Seers Village
 */

package SeersSpinner;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;

public class WalkToSpinner extends Task<ClientContext> {

    Tile[] toBankTile = new Tile[]{new Tile(2714,3427,0), new Tile(2725,3474,0), new Tile(2726,3489,0)};
    Area bankArea = new Area(new Tile(2718, 3499, 0),new Tile(2729, 3488, 0));
    Area upstairsBank = new Area(new Tile(2729, 34940, 1), new Tile(2726, 3490,1));
    Area spinnerLower = new Area(new Tile(2716,3473,0), new Tile(2711,3470,0));

    int flaxID = 1779;

    public WalkToSpinner(ClientContext ctx){
        super(ctx);
    }

    @Override
    public boolean activate(){

        return ctx.backpack.select().id(flaxID).count()==28
                &&!bankArea.contains(ctx.players.local())
                &&bankArea.getClosestTo(ctx.players.local()).distanceTo(ctx.players.local())>12;
    }

    @Override
    public void execute(){
        if(upstairsBank.contains(ctx.players.local()))
        {
            GameObject ladder = ctx.objects.select().id(25939).nearest().poll();
            ladder.interact("Climb-down");
        } else {
            if(spinnerLower.contains(ctx.players.local()))
            {
                GameObject ladder = ctx.objects.select().id(25939).nearest().poll();
                ladder.interact("Climb-up");
            } else {
                ctx.movement.newTilePath(toBankTile).reverse().randomize(1, 1).traverse();
            }
        }
    }
}
