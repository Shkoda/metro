package structure;

import java.io.Serializable;

/**
 * Created by Nightingale on 05.03.14.
 */
public class Processor  implements Serializable {
    public final String name;
    private boolean isSimplex;

    public Processor(String name) {
        this.name = name;
    }

    public boolean isSimplex() {
        return isSimplex;
    }
}
