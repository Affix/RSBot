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
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;

public class Deposit extends Task<ClientContext> {

    Area bankArea = new Area(new Tile(2730, 3495, 0),new Tile(2721, 3491, 0));

    public Deposit(ClientContext ctx){
        super(ctx);
    }

    @Override
    public boolean activate(){
        return ctx.backpack.select().count()==28
                &&bankArea.contains(ctx.players.local())
                &&ctx.bank.opened()==true;

    }

    @Override
    public void execute(){

        if(ctx.backpack.select().count()>0){
            ctx.bank.depositInventory();
            ctx.backpack.select(); //refresh in case
        }

        Condition.sleep(500);


    }
}