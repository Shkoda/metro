package structure;

import java.io.Serializable;

/**
 * Created by Nightingale on 05.03.14.
 */
public abstract class Link  implements Serializable {
    public final Processor first, second;

    protected Link(Processor first, Processor second) {
        this.first = first;
        this.second = second;
    }
}
