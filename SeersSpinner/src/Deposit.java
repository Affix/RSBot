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

import java.util.concurrent.Callable;

public class Deposit extends Task<ClientContext> {

    Area bankArea = new Area(new Tile(2730, 3495, 0),new Tile(2721, 3491, 0));
    int bowstringID = 1777;

    public Deposit(ClientContext ctx){
        super(ctx);
    }

    @Override
    public boolean activate(){
        return ctx.backpack.select().id(bowstringID).count()==28
                &&bankArea.contains(ctx.players.local())
                &&ctx.bank.opened()==true;

    }

    @Override
    public void execute(){
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.bank.depositInventory();
            }
        });
        ctx.backpack.select(); //refresh in case
    }
}