import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;

/**
 * Created by affix on 01/02/15.
 */
public class Drop extends Task<ClientContext> {

    private int logID = 1511;

    public Drop(ClientContext ctx)
    {
        super(ctx);
    }

    @Override
    public boolean activate()
    {
        return ctx.backpack.select().count() == 28;
    }

    @Override
    public void execute()
    {
        for(Item i: ctx.backpack.id(logID))
        {
            i.interact("Drop");
        }
    }
}
