/**
 * Title : Choppa
 * Author : Keiran "Affix" Smith
 * License : GNU/GPLv3
 * Copyright : Keiran Smith
 *
 * Description : Choppa is a simple Powerbot Script to Chop and Drop Normal Logs.
 * This is a basic script written as an example.
 */

package Choppa;

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