package model;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by eric on 10/30/14.
 */
public class Entity implements Denormalizable<Integer> {

    //public static final int LOGIC_FORMATION = 0;
    //public static final int LOGIC_SEPARATION = 1;
    //public static final int LOGIC_FIELD_MOVEMENT = 2;
    //public static final int LOGIC_FORCE_INTEGRATOR = 3;
    //public static final int LOGIC_BATTLE = 4;
    //public static final int LOGIC_ORIENTATION = 6;

    public static final int NODE_TROOP_DRAWER = 5;
    public static final int NODE_SELECTION = 7;
    public static final int NODE_MOVE_TOWARD_DESTINATION = 8;

    public static final int NODE_ABILITIES = 9;

    public static final int TAG_LEADER = 103;
    public static final int TAG_FOLLOWER = 104;

    public static final int UNIT_TROOP = 105;

    public static final int UI_BUTTON = 500;

    public Entity self = this;

    private static int NEXT_UNIQUE_ID = 1;
    private int id;

    private ArrayList<Integer> labels = new ArrayList<Integer>(16);

    /**
     * A map from Component classes to the component the entity has of that class
     */
    public Hashtable<Class<? extends Component>, Component> cData = new Hashtable<Class<? extends Component>, Component>(64);

    public static enum Event {
        NONE, ADDED, REMOVED, CHANGED
    }

    public Event event = Event.NONE;

    public Entity() {
        id = NEXT_UNIQUE_ID;
        NEXT_UNIQUE_ID += 1;
    }

    public ArrayList<Integer> getLabels() {
        return labels;
    }
}
