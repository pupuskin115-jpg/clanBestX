package ru.clansplugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Clan {
    private final String name;
    private final UUID leader;
    private final List<UUID> members = new ArrayList<>();
    private int cp = 0;
    private boolean pvpEnabled = false;
    private final List<String> effects = new ArrayList<>();

    public Clan(String name, UUID leader) {
        this.name = name;
        this.leader = leader;
        members.add(leader);
    }

    public String getName() { return name; }
    public UUID getLeader() { return leader; }
    public List<UUID> getMembers() { return members; }
    public int getCp() { return cp; }
    public void addCp(int amount) { cp += amount; }
    public boolean isPvpEnabled() { return pvpEnabled; }
    public void togglePvp() { pvpEnabled = !pvpEnabled; }
    public List<String> getEffects() { return effects; }

    public boolean addMember(UUID uuid) {
        if (!members.contains(uuid)) {
            members.add(uuid);
            return true;
        }
        return false;
    }

    public boolean removeMember(UUID uuid) {
        if (members.contains(uuid) && !leader.equals(uuid)) {
            members.remove(uuid);
            return true;
        }
        return false;
    }

    public void addEffect(String effect) {
        if (!effects.contains(effect)) effects.add(effect);
    }
}
