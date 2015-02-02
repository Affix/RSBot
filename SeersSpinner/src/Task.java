/**
 * Title : SeersSpinner
 * Author : Keiran "Affix" Smith
 * License : GNU/GPLv3
 * Copyright : Keiran Smith
 *
 * Description : Seers Spinner, Spin Flax in Seers Village
 */

package SeersSpinner;

import org.powerbot.script.ClientAccessor;
import org.powerbot.script.ClientContext;


public abstract class Task<C extends ClientContext> extends ClientAccessor<C>
{

    public Task(C ctx) {
        super(ctx);
    }

    public abstract boolean activate();

    public abstract void execute();
}