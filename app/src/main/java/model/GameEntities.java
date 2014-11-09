package model;

import structure.DrawList2DItem;
import utils.MemoryPool;

/**
 * Created by eric on 10/30/14.
 */
public class GameEntities {

    public static MemoryPool<Troop> troopsMemoryPool = new MemoryPool<Troop>(Troop.class, 1024);

//    /**
//     * Construct an entity representing a troop
//     * @return
//     */
//    public static Entity buildTroop() {
//
//        //Entity troop = new Entity();
//        Entity troop = troopsMemoryPool.fetchMemory();
//        troop.labels().add(Entity.UNIT_TROOP);
////
////        PlayerComponent pc = new PlayerComponent();
////        pc.name = "default";
////        pc.team = team;
////        troop.cData.put(PlayerComponent.class, pc);
//
//        WorldComponent worldComponent = new WorldComponent();
//        troop.cData.put(WorldComponent.class, worldComponent);
//
//        SelectionComponent selectionComponent = new SelectionComponent();
//        troop.cData.put(SelectionComponent.class, selectionComponent);
//        troop.labels().add(Entity.NODE_SELECTION);
//
//        DestinationComponent destinationComponent = new DestinationComponent();
//        troop.cData.put(DestinationComponent.class, destinationComponent);
//        troop.labels().add(Entity.NODE_MOVE_TOWARD_DESTINATION);
//
//        troop.labels().add(Entity.NODE_TROOP_DRAWER);
//
//        AbilityComponent ac = new AbilityComponent();
//        ac.abilities.add(Abilities.SPECIAL_ATTACK);
//        troop.cData.put(AbilityComponent.class, ac);
//
//        LivingComponent lc = new LivingComponent();
//        troop.cData.put(LivingComponent.class, lc);
////
////        troop.labels().add(team);
////        troop.labels().add(leader);
//
//        return troop;
//    }

//    public static void recycleTroop(Entity toRecycle) {
//        troopsMemoryPool.recycleMemory(toRecycle);
//    }

    public static void recycle(Entity entity) {
        if (entity.labels().contains(Entity.UNIT_TROOP)) {
            troopsMemoryPool.recycleMemory((Troop) entity);
        }
    }

    public static Entity buildAttackButton() {
        Entity button = new Entity();

        ButtonComponent bc = new ButtonComponent(Buttons.S_ATTACK);
        bc.position = 0;
        bc.texture = DrawList2DItem.ANIMATION_BUTTONS_ATTACK;
        bc.size.y = 0.6f;

        button.cData.put(ButtonComponent.class, bc);

        button.labels().add(Entity.UI_BUTTON);

        return button;
    }

    public static Entity buildDefendButton() {
        Entity button = new Entity();

        ButtonComponent bc = new ButtonComponent(Buttons.DEFEND);
        bc.position = 1;
        bc.texture = DrawList2DItem.ANIMATION_BUTTONS_DEFEND;
        bc.size.y = 0.6f;

        button.cData.put(ButtonComponent.class, bc);

        button.labels().add(Entity.UI_BUTTON);

        return button;
    }

}
