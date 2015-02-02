/**
 * Title : Choppa
 * Author : Keiran "Affix" Smith
 * License : GNU/GPLv3
 * Copyright : Keiran Smith
 *
 * Description : Flaxinator is an Auto Flax Picker and Bow Stringer
 */

package Flaxinator;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Item;
import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;



public class WalkToBank extends Task<ClientContext> {

    Tile[] toBankTile = new Tile[]{new Tile(2732, 3443, 0), new Tile(2731, 3449, 0), new Tile(2730, 3455, 0), new Tile(2727, 3461, 0), new Tile(2728, 3467, 0), new Tile(2728, 3474, 0), new Tile(2728, 3481, 0), new Tile(2726, 3486, 0), new Tile(2726, 3493, 0)};
    Area bankArea = new Area(new Tile(2718, 3499, 0),new Tile(2729, 3488, 0));
    Area upstairsBank = new Area(new Tile(2729, 34940, 1), new Tile(2726, 3490,1));

    public WalkToBank(ClientContext ctx){

        super(ctx);

    }

    @Override
    public boolean activate(){

        return ctx.backpack.select().count()==28
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
            ctx.movement.newTilePath(toBankTile).randomize(1, 1).traverse();
        }
    }
}
