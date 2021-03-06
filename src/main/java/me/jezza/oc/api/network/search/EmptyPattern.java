package me.jezza.oc.api.network.search;

import me.jezza.oc.api.network.interfaces.INetworkNode;
import me.jezza.oc.api.network.interfaces.ISearchPattern;

import java.util.List;

public class EmptyPattern implements ISearchPattern {

    private boolean delete = false;

    @Override
    public boolean searchForPath() {
        return true;
    }

    @Override
    public boolean canDelete() {
        return delete;
    }

    @Override
    public boolean hasFinished() {
        return true;
    }

    @Override
    public List<INetworkNode> getPath() {
        delete = true;
        return null;
    }
}
