import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.ClientContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chop extends Task<ClientContext> {

    private int TreeIds[] = {38785, 1286, 38783, 38732, 38731};

    public Chop(ClientContext ctx)
    {
        super (ctx);
    }

    @Override
    public boolean activate()
    {
        return ctx.backpack.select().count() < 28
                && !ctx.objects.select().id(TreeIds).isEmpty()
                && ctx.players.local().animation() == -1;
    }

    @Override
    public void execute()
    {
        GameObject tree = ctx.objects.nearest().poll();
        if(tree.inViewport())
        {
            tree.interact("Chop");
        } else {
            ctx.movement.step(tree);
            ctx.camera.turnTo(tree);
        }
    }
}
