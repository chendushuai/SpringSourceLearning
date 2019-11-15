package com.chenss.zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ZkLock {
    private ZooKeeper zookeeper;

    private String LOCK_NAME="/lock";

    public void init() {
        if (null == zookeeper) {
            try {
                zookeeper = new ZooKeeper("192.168.122.36:2181", 300, new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {

                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean tryLock() {
        String nodeName = LOCK_NAME+"/zk_";
        try {
            // 此处返回的是全路径
            String currentNodeName = zookeeper.create(nodeName, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

            // 此处是最终目录名称
            List<String> childList = zookeeper.getChildren(LOCK_NAME, false);
            Collections.sort(childList);

            String minNodeName = childList.get(0);
            String minFullNodeName = LOCK_NAME + "/" + minNodeName;
            if (minFullNodeName.equals(currentNodeName)) {
                return true;
            } else {
                String currSimpleName = currentNodeName.substring(currentNodeName.lastIndexOf("/") + 1);
                int currIndex = childList.indexOf(currSimpleName);
                String prevName ="";
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

}
