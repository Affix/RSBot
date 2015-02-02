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
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

public class ExitBank extends Task<ClientContext> {

    Area bankArea = new Area(new Tile(2730, 3495, 0),new Tile(2721, 3491, 0));
    Area upstairsBank = new Area(new Tile(2729, 34940, 1), new Tile(2726, 3490,1));

    int flaxID = 1779;

    public ExitBank(ClientContext ctx){

        super(ctx);

    }

    @Override
    public boolean activate(){
        int flaxID = 0;
        return ctx.backpack.select().id(flaxID).count()==28
                &&bankArea.contains(ctx.players.local())
                &&ctx.bank.opened()==true;

    }

    @Override
    public void execute(){

        /* This condition should never be met. Nice to be safe though */
        if(upstairsBank.contains(ctx.players.local()))
        {
            GameObject ladder = ctx.objects.select().id(25939).nearest().poll();
            ladder.interact("Climb-down");
        } else {
            int closeMethod = (Random.nextInt(1, 8));

            if (closeMethod > 1) {
                Condition.sleep(300);
                ctx.bank.close();
            } else {
                Condition.sleep(300);
                ctx.movement.step(bankArea.getRandomTile());
            }
        }
    }
}