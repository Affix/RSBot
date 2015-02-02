/**
 * Title : Flaxinator
 * Author : Keiran "Affix" Smith
 * License : GNU/GPLv3
 * Copyright : Keiran Smith
 *
 * Description : Flaxinator is an Auto Flax Picker and Bow Stringer
 */

package Flaxinator;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

public class BankOpener extends Task<ClientContext> {

    Area bankArea = new Area(new Tile(2730, 3495, 0),new Tile(2721, 3491, 0));
    Area upstairsBank = new Area(new Tile(2729, 34940, 1), new Tile(2726, 3490,1));
    int bankBoothID = 25808;

    public BankOpener(ClientContext ctx){

        super(ctx);

    }

    @Override
    public boolean activate(){

        return ctx.backpack.select().count()==28
                && !ctx.objects.select().id(bankBoothID).isEmpty()
                && ctx.bank.opened()==false;

    }

    @Override
    public void execute(){
        GameObject bankBooth = ctx.objects.select().id(bankBoothID).nearest().poll();

        if(upstairsBank.contains(ctx.players.local()))
        {
            GameObject ladder = ctx.objects.select().id(25939).nearest().poll();
            ladder.interact("Climb-down");
        } else if(bankBooth.inViewport())
        {
            bankBooth.interact("Bank");
        } else {
            ctx.movement.step(bankBooth);
            ctx.camera.turnTo(bankBooth);
        }

    }
}