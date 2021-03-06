package me.arasple.mc.trchat.data;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Arasple
 * @date 2019/8/15 18:38
 */
public class Cooldowns {

    private List<Cooldown> cooldown = Lists.newArrayList();

    public List<Cooldown> getCooldowns() {
        return cooldown;
    }

    public void setCooldowns(List<Cooldown> cooldown) {
        this.cooldown = cooldown;
    }

    public enum CooldownType {

        /**
         * Chat Cooldown Types
         */

        CHAT("Chat"),
        ITEM_SHOW("ItemShow"),
        MENTION("Mention");

        private String name;

        CooldownType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Cooldown {

        private String id;
        private long time;

        public Cooldown() {

        }

        public Cooldown(String id, long time) {
            this.id = id;
            this.time = time;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

    }

}
