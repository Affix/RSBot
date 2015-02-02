/**
 * Title : Choppa
 * Author : Keiran "Affix" Smith
 * License : GNU/GPLv3
 * Copyright : Keiran Smith
 *
 * Description : Flaxinator is an Auto Flax Picker and Bow Stringer
 */

package Flaxinator;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;


public class FlaxField extends Task<ClientContext> {

    Tile[] toBankTile = new Tile[]{new Tile(2732, 3443, 0), new Tile(2731, 3449, 0), new Tile(2730, 3455, 0), new Tile(2727, 3461, 0), new Tile(2728, 3467, 0), new Tile(2728, 3474, 0), new Tile(2728, 3481, 0), new Tile(2726, 3486, 0)};
    Area fieldArea = new Area(new Tile(2739, 3450, 0), new Tile(2743, 3438, 0));
    Area upstairsBank = new Area(new Tile(2729, 34940, 1), new Tile(2726, 3490,1));

    public FlaxField(ClientContext ctx){

        super(ctx);

    }

    @Override
    public boolean activate(){

        return ctx.backpack.select().count() < 28
                &&!fieldArea.contains(ctx.players.local())
                &&ctx.bank.opened()==false
                &&fieldArea.getClosestTo(ctx.players.local()).distanceTo(ctx.players.local())>15;

    }

    @Override
    public void execute(){
        if(upstairsBank.contains(ctx.players.local()))
        {
            GameObject ladder = ctx.objects.select().id(25939).nearest().poll();
            ladder.interact("Climb-down");
        } else {
            ctx.movement.newTilePath(toBankTile).reverse().randomize(1, 1).traverse();
        }
    }
}