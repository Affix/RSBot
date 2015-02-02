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

public class Withdraw extends Task<ClientContext> {

    Area bankArea = new Area(new Tile(2730, 3495, 0),new Tile(2721, 3491, 0));
    int flaxID = 1779;

    public Withdraw(ClientContext ctx){
        super(ctx);
    }

    @Override
    public boolean activate(){
        return ctx.backpack.select().id(flaxID).count()==0
                &&bankArea.contains(ctx.players.local())
                &&ctx.bank.opened()==true;

    }

    @Override
    public void execute(){

        if(ctx.backpack.select().count()>0){
            ctx.bank.withdraw(flaxID, 28);
            ctx.backpack.select(); //refresh in case
        }

        Condition.sleep(500);


    }
}